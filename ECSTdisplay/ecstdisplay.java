package lab15;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab15.model.departments;

/**
 * Servlet implementation class ecstdisplay
 */
@WebServlet("/ecstdisplay")
public class ecstdisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ecstdisplay() {
        super();

    }


	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<departments> dept = new ArrayList<departments>();
		departments compsci = new departments("Computer Science");
		compsci.people.add("Pamula(Chair)");
		compsci.people.add("Sun");
		
		dept.add(compsci);
		
		departments electric = new departments("Electrical and Computer Engineering");
		electric.people.add("Agarwal");
		
		dept.add(electric);
		
		getServletContext().setAttribute("dept", dept);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("adddept")!=null) {
			request.getRequestDispatcher("/WEB-INF/adddept.jsp").forward(request, response);
		}
		else if(request.getParameter("addp")!=null) {
			List<departments> dept = (List<departments>)getServletContext().getAttribute("dept");
			request.setAttribute("dept", dept);
			request.getRequestDispatcher("/WEB-INF/addp.jsp").forward(request, response);
		}
		else {
		List<departments> dept = (List<departments>)getServletContext().getAttribute("dept");
		request.setAttribute("dept", dept);
		request.getRequestDispatcher("/WEB-INF/displaye.jsp").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("addnew")!=null) {
			List<departments> dept = (List<departments>)getServletContext().getAttribute("dept");
			departments nextdept = new departments(request.getParameter("newdept"));
			dept.add(nextdept);
			request.getRequestDispatcher("/WEB-INF/displaye.jsp").forward(request, response);
		}
		else {
			List<departments> dept = (List<departments>)getServletContext().getAttribute("dept");
			String add = (String)request.getParameter("whatdept");
			String newFacultyName = (String)request.getParameter("n");
			for(departments depart: dept) {
				if(depart.name.equals(add)) {
					if(request.getParameter("chair")!= null) {
						depart.people.add(newFacultyName+"(Chair)");
					}
					else {
						depart.people.add(newFacultyName);
					}
				}
			}
			request.getRequestDispatcher("/WEB-INF/displaye.jsp").forward(request, response);
		}
	}

}
