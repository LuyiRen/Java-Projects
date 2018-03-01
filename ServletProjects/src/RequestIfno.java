package starting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RequestIfno")
public class RequestIfno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RequestIfno() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Request Info</title></head><body>");
		out.println("<h2>Hello </h2>");
		out.println("<p>Mehod: " + request.getMethod()+"</p>");
		out.println("<p>ContextPath: " + request.getContextPath()+"</p>");
		out.println("<p>URL: " + request.getRequestURL()+"</p>");
		out.println("<p>URI: " + request.getRequestURI()+"</p>");
		out.println("<p>Remote Address: " + request.getRemoteAddr()+"</p>");
		
		if(request.getHeader("Accept-Encoding").indexOf("gzip") >= 0) {
			out.println("<p>Gzip not supported</p>");
		}
		else {
			out.println("<p>Gzip not supported</p>");
		}
		
		out.println("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
