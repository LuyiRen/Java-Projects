package starting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Countdown
 */
@WebServlet("/Countdown")
public class Countdown extends HttpServlet {
	private static final long serialVersionUID = 1L;
    int counter=10;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Countdown() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>CountDown</title></head><body>");
		
		//if counter hasnt reached zerp, set a refresh header and then decrement
		if(counter==0) {
			out.println("<p>Rocket Launched!</p>");
		}
		else {
			out.println("<h3>" + counter + " to launch!!<h3>");
			response.setHeader("Refresh", "1");
			counter--;
		}

		
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
