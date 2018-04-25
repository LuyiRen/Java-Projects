package lab13pack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CurrencyConverter")
public class CurrencyConverter extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public CurrencyConverter()
    {
        super();
    }

    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );

        Map<String, Double> data = new HashMap<String, Double>();

        try
        {
            // read file
            Scanner in;
            in = new Scanner( new File(
                getServletContext().getRealPath( "/WEB-INF/rates.txt" ) ) );
            while( in.hasNextLine() )
            {
                String line = in.nextLine();
                String tokens[] = line.split( " " );
                data.put( tokens[0], Double.valueOf( tokens[1] ) );
            }
            in.close();
        }
        catch( FileNotFoundException e )
        {
            throw new ServletException( e );
        }

        getServletContext().setAttribute( "data", data );
    }

    @SuppressWarnings("unchecked")
    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
//        Map<String, Double> data = (Map<String, Double>) getServletContext()
//            .getAttribute( "data" );
//
//        response.setContentType( "text/html" );
//        PrintWriter out = response.getWriter();
//        out.println(
//            "<html><head><title>Currency Converter</title></head><body>" );
//        out.println( "<form action='CurrencyConverter' method='post'>" );
//        out.println( "<input type='text' name='amount' />" );
//
//        // use the keys to generate <select> list one
//        out.println( "<select name='c1'>" );
//        for( String c : data.keySet() )
//            out.println( "<option>" + c + "</option>" );
//        out.println( "</select>" );
//
//        out.println( "= ?" );
//
//        // use the keys to generate <select> list one
//        out.println( "<select name='c2'>" );
//        for( String c : data.keySet() )
//            out.println( "<option>" + c + "</option>" );
//        out.println( "</select>" );
//
//        out.println( "<input type='submit' name='convert' value='Convert' />" );
//
//        out.println( "</body></html>" );
    	request.getRequestDispatcher("/WEB-INF/currency.jsp").forward(request, response);
    }

    @SuppressWarnings("unchecked")
    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        Map<String, Double> data = (Map<String, Double>) getServletContext()
            .getAttribute( "data" );

        String c1 = request.getParameter( "c1" );
        String c2 = request.getParameter( "c2" );
        double amount = Double.parseDouble( request.getParameter( "amount" ) );
        double result = amount * data.get( c2 ) / data.get( c1 );

//        response.setContentType( "text/html" );
//        PrintWriter out = response.getWriter();
//        out.println(
//            "<html><head><title>Currency Converter</title></head><body>" );
//        out.println(
//            "<p>" + amount + " " + c1 + " = " + result + " " + c2 + "</p>" );
//        out.println( "<p><a href='CurrencyConverter'>Back</a></p>" );
//        out.println( "</body></html>" );
    	request.setAttribute("result", result);
    	request.setAttribute("c1", c1);
    	request.setAttribute("c2", c2);
    	request.setAttribute("amount", amount);
    	request.getRequestDispatcher("/WEB-INF/displayCurrency.jsp").forward(request, response);
    }

}
