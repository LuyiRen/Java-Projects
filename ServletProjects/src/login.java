package starting;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public login() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		

		PrintWriter out = response.getWriter();
		out.println("<h2>GuestBook</h2>");
		out.println("<html><head><title>Log in</title></head><body>");
		out.println("<form action='login' method='post'>");
		out.println("Username :<input type='text' name='username' /> <br/>");
		out.println("Password :<input type='text' name='password' /> <br/>");

		out.println("<br/>");
		out.println("<input type='submit' name='login' value='login'/>");
		out.println("</form>");
		out.println("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		
		//check username and password and if corect, redirect to members
		if(user.equals("cysun") && password.equals("abcd")) {
			request.getSession().setAttribute("username", user);
			response.sendRedirect("Members");
		}
		else {
			response.sendRedirect("login");
		}
		
		//otherwise redirect back to login form
	}

}
