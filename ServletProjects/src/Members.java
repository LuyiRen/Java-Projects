package starting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Members")
public class Members extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Members() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//check if theres a session attribute user if yes display
		String user = (String)request.getSession().getAttribute("username");
		if(user != null) {
			response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Member</title></head><body>");
			out.println("<h2>This is members only!!!</h2>");
			out.println("<p>Welcome " + user+"</p>");
			out.println("</body></html>");
			
		}

		else {
			response.sendRedirect("login");
		}

		//if not redirect the suser to the log in page
	}

}
