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
@WebServlet("/AddCommentWithCookie")
public class AddCommentWithCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddCommentWithCookie() {
        super();

    }
    private String getUsernameFromCookie(HttpServletRequest request) {
    	for(Cookie cookie:request.getCookies()) {
    		if(cookie.getName().equals("name")) {
    			return cookie.getValue();
    		}
    	}
    	return null;
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		

		PrintWriter out = response.getWriter();
		out.println("<h2>GuestBook</h2>");
		out.println("<html><head><title>Add Comment</title></head><body>");
		//if we already have name in a cookie, then just display the name
		// get a cookie from request?
		
		out.println("<form action='AddCommentWithCookie' method='post'>");
		String name = getUsernameFromCookie(request);
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
		String name = getUsernameFromCookie(request);
		if(name==null) {
			name = request.getParameter("name");
			Cookie cookie = new Cookie("name", name);
			response.addCookie(cookie);
		}

		String message = request.getParameter("message");
		List<GuestBookEntry> entries = (List<GuestBookEntry>)getServletContext().getAttribute("entries");
		entries.add(new GuestBookEntry(name, message));
		
		//send the user back to guestbook display
		response.sendRedirect("GuestBook");
	}

}
