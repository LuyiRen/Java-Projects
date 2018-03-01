package starting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String a = request.getParameter("a");
		String b= request.getParameter("b");
		if(a == null|| b==null || a.trim().length()==0|| b.trim().length()==0) {
			response.sendRedirect("AddForm.html");
			return;
		}
		String what ="";
		what = request.getParameter("options");
		
		response.setContentType("text/html");
		int sum = Integer.parseInt(a) + Integer.parseInt(b);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Add</title></head><body>");
		out.println("you like: " + what);
		out.println("<p>"+ a + " + " + b + " = " + sum + "</p" );
		out.println("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

