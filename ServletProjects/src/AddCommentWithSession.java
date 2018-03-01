package starting;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webstarter.model.GuestBookEntry;

/**
 * Servlet implementation class AddComment
 */
@WebServlet("/AddCommentWithSession")
public class AddCommentWithSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddCommentWithSession() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		

		PrintWriter out = response.getWriter();
		out.println("<h2>GuestBook</h2>");
		out.println("<html><head><title>Add Comment</title></head><body>");
		//if we already have name in a cookie, then just display the name
		// get a cookie from request?
		
		out.println("<form action='AddCommentWithSession' method='post'>");
		String name = (String)request.getSession().getAttribute("name");
		if(name !=null) {
			out.println("name: " + name+ "</br>");
		}
		else {
		out.println("Name:<input type='text' name='name' /> <br/>");
		}

		//otherwise display the input field
		out.println("<textarea name='message' rows='5' cols='60'></textarea>");
		

		out.println("<br/>");
		out.println("<input type='submit' name='add' value='Add'/>");
		out.println("</form>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//first try to get name from cookie
		String name = (String)request.getSession().getAttribute("name");
		if(name==null) {
			name = request.getParameter("name");
			request.getSession().setAttribute("name", name);
		}

		String message = request.getParameter("message");
		List<GuestBookEntry> entries = (List<GuestBookEntry>)getServletContext().getAttribute("entries");
		entries.add(new GuestBookEntry(name, message));
		
		//send the user back to guestbook display
		response.sendRedirect("GuestBook");
	}

}
