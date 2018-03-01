package starting;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webstarter.model.GuestBookEntry;

/**
 * Servlet implementation class AddComment
 */
@WebServlet("/EditEntry")
public class EditEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditEntry() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<GuestBookEntry> entries = (List<GuestBookEntry>)getServletContext().getAttribute("entries");
		int index = Integer.parseInt(request.getParameter("index"));
		GuestBookEntry entry = entries.get(index);
		
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<h2>Edit Entry</h2>");
		out.println("<html><head><title>Add Comment</title></head><body>");
		out.println("<form action='EditEntry' method='post'>");
		out.println("Name:<input type='text' name='name' value='"+entry.getName()+"' /> <br/>");
		
		out.println("<textarea name='message' rows='5' cols='60'>"+entry.getMessage()+"</textarea>");
		
		out.println("<input type='hidden' name='index' value='"+index+"'/>");
		out.println("<br/>");
		out.println("<input type='submit' name='save' value='Save'/>");
		out.println("</form>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		int index = Integer.parseInt(request.getParameter("index"));
		
		List<GuestBookEntry> entries = (List<GuestBookEntry>)getServletContext().getAttribute("entries");
		entries.get(index).setName(name);
		entries.get(index).setMessage(message	);
		
		//send the user back to guestbook display
		response.sendRedirect("GuestBook");
	}

}
