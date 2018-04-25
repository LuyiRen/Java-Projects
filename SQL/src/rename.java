package lab;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.model.files;

@WebServlet("/rename")
public class rename extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public rename()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	String id = request.getParameter("id");
    	request.setAttribute("id", id);
        request.getRequestDispatcher( "/WEB-INF/rename.jsp" ).forward( request, response );
    }
    
    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        Connection c = null;
        try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu21";
            String username = "cs3220stu21";
            String password = "Hrxc!AAE";
            
            String name = (String)request.getParameter("newname");
            int id = Integer.parseInt((String)request.getParameter("id"));
            String sql = "update files set name=? where id=?;";

            c = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setString( 1, name );
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
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

        response.sendRedirect( "lab19" );


}
}
