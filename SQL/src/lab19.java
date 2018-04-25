package lab;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.model.files;

/**
 * Servlet implementation class lab19
 */
@WebServlet("/lab19")
public class lab19 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lab19() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<files> file = new ArrayList<files>();

        	Connection c = null;
        	try
        	{
                String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu21";
                String username = "cs3220stu21";
                String password = "Hrxc!AAE";
                
        		c = DriverManager.getConnection( url, username, password );
        		Statement stmt = c.createStatement();
        		ResultSet rf = stmt.executeQuery("select * from files");

        		while( rf.next())//files
        		{
        			file.add(new files(rf.getInt("id"), rf.getString("name"), rf.getBoolean("is_folder"), rf.getInt("parent_id"), rf.getInt("owner_id")));

        		}
        		c.close();
        	}
        	catch( SQLException e )
        	{
        		throw new ServletException( e );
        	}
        	finally
        	{
        		try
        		{
        			if( c != null ) c.close();
        		}
        		catch( SQLException e )
        		{
        			throw new ServletException( e );
        		}
        	}
        	if(request.getParameter("rename")!=null) {
        		files passfile = null;
        		for(int i=0;i<file.size();i++){
        			if(Integer.parseInt((String)request.getParameter("id"))==file.get(i).getId()) {
        				passfile = file.get(i);
        			}

        	}
            	request.setAttribute("passfile", passfile);
            	request.getRequestDispatcher("/WEB-INF/rename.jsp").forward(request, response);
        	}
        		else {
        	
        	if(request.getParameter("folder")!= null) {
    			request.getRequestDispatcher("/WEB-INF/addfolder.jsp").forward(request, response);
        	}
        	else {
            if(request.getParameter("click")==null) {
            	request.setAttribute("file", file);
            	request.getRequestDispatcher("/WEB-INF/documents.jsp").forward(request, response);
            }
            else {
            	String nameofFile = request.getParameter("click");
            	int idoffile = Integer.parseInt(nameofFile);
            	//find the children files
            	List<files> adjustedfile = new ArrayList<files>();
            	for(int i=0; i < file.size();i++) {
            		if(idoffile==file.get(i).getParent_id()) {
            			adjustedfile.add(file.get(i));
            		}
            	}
            	if(request.getParameter("current")!=null) {
            		int parentid=0;
            		String lastfilename="";
            		for(int i=0; i < file.size();i++) {
            			if(idoffile==file.get(i).getId()) {
            				parentid=file.get(i).getParent_id();
            				lastfilename=file.get(i).getName();
            			}
            		}
            		request.setAttribute("click2", parentid);
            		request.setAttribute("current", lastfilename);
            		
            	}
            	request.setAttribute("file", adjustedfile);
            	request.getRequestDispatcher("/WEB-INF/documentsAll.jsp").forward(request, response);
            }
        	}
        	}
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<files> file = new ArrayList<files>();
        if(request.getAttribute("delete")!=null) {
        	int id = Integer.parseInt((String)request.getAttribute("delete"));
        	request.setAttribute("id", id);
        	request.getRequestDispatcher("/delete.java").forward(request, response);
        }
    	Connection c = null;
    	try
    	{
            String url = "jdbc:mysql://localhost:3306/sys";
            String username = "root";
            String password = "sesskag12";


    		c = DriverManager.getConnection( url, username, password );
    		Statement stmt = c.createStatement();
    		ResultSet rf = stmt.executeQuery("select * from files");

    		while( rf.next())//files
    		{
    			file.add(new files(rf.getInt("id"), rf.getString("name"), rf.getBoolean("is_folder"), rf.getInt("parent_id"), rf.getInt("owner_id")));
    		}
        	if(request.getParameter("addnew")!=null) {
        		String newfoldername = request.getParameter("foldername");
        		String sql = "insert into files values (?,?,?,?,?)";

        		PreparedStatement pstmt = c.prepareStatement(sql);
        		pstmt.setInt(1, (file.size()+1));
    			pstmt.setString(2,  newfoldername);
    			pstmt.setBoolean(3, true);
    			pstmt.setInt(4, 1);
    			pstmt.setInt(5, 1);
    			int i = pstmt.executeUpdate();
    			if(i>0) {

    			}
    			else {
                	request.getRequestDispatcher("/WEB-INF/testing.jsp").forward(request, response);
    			}
    			c.close();
        	}	
    	}
    	catch( SQLException e )
    	{
    		throw new ServletException( e );
    	}
    	finally
    	{
    		try
    		{
    			if( c != null ) c.close();
    		}
    		catch( SQLException e )
    		{
    			throw new ServletException( e );
    		}
    	}
    	response.sendRedirect("lab19");
    	}
}
