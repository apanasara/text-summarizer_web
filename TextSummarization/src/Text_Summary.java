import javax.servlet.annotation.WebServlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


@WebServlet(urlPatterns="/input", name="Text_Summary")

public class Text_Summary extends HttpServlet 
{    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Text_Summary()
	{}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("POST received...");
		improved_summary_Servlet ISS = new improved_summary_Servlet();
		String textReceived = request.getParameter("fullText");
		
		ISS.loadFullText(textReceived);
		//ISS.consolePrint();// for debuging purpose only
		
		response.setContentType("text/xml");
	    PrintWriter pw = response.getWriter();
	    pw.println(ISS.responseCreation());
	    pw.close();
	}
}