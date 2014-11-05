//Michael McGuirk - D13123389
//DT228/3 Cloud Computing Lab Test 1
//Math servlet to take in 4 values and perform a calculation.

package ie.mydit.mcguirk.michael;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class MathServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		String AString, BString, CString, DString;
		int a, b, c, d, total;
		a=b=c=d=0;
		AString = req.getParameter("A");
		BString = req.getParameter("B");
		CString = req.getParameter("C");
		DString = req.getParameter("D");
		if(AString != null && BString != null && CString != null && DString != null) 
		{
			if(tryParse(AString))
			{
				a = Integer.parseInt(AString);
			}
			else
			{
				resp.getWriter().println("A is not an integer");
			}
			
			if(tryParse(BString))
			{
				b = Integer.parseInt(BString);
			}
			else
			{
				resp.getWriter().println("B is not an integer");
			}
			
			if(tryParse(CString))
			{
				c = Integer.parseInt(CString);
			}
			else
			{
				resp.getWriter().println("C is not an integer");
			}
			
			if(tryParse(DString))
			{
				d = Integer.parseInt(DString);
			}
			else
			{
				resp.getWriter().println("C is not an integer");
			}
			
			total = (a - b) * (c - d);
			resp.getWriter().println(calculateTotal(a,b,c,d));
		}
		else
		{
			resp.getWriter().println("Error! One or more values may be null");
			resp.getWriter().println("Using default values");
			a=b=c=d=1;
			resp.getWriter().println(calculateTotal(a,b,c,d));
			
		}
		

	}
	//tryparse method attempts to parse user input to string, returns false if attempt fails.
	public boolean tryParse(String s)
	{
		try
		{
			int i = Integer.parseInt(s);
		}
		catch(NumberFormatException e)
		{
			return false;
		}
		return true;
	}
	
	//method to take 4 values, perform the calculation and return the string to be printed to the screen.
	public String calculateTotal(int a, int b, int c, int d)
	{
		int total = 0;
		total = (a - b) * (c - d);
		String output = ("( " + a  + " - " + b + " )" + " * " + "( " + c + " - " + d  + ") = " + total );
		return output;
	}
	
	
}
