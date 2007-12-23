package webcalendar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.HttpJspPage;

import org.apache.jasper.runtime.HttpJspBase;
import org.hibernate.Transaction;

import webcalendar.common.HibernateUtils;


public abstract class DefaultJSP extends HttpJspBase implements HttpJspPage {

	private org.hibernate.classic.Session hbSession=null;
	private Transaction tx=null;
	
	// Servlet methods:
	
	protected org.hibernate.classic.Session getHbSession() {
		if (hbSession==null) {
			hbSession = HibernateUtils.getSessionFactory().openSession();			
		}
		if (tx==null) {
			tx = hbSession.beginTransaction();
		}
		return hbSession;
	}
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		
		try {

			super.service(arg0, arg1);
			
			if (tx!=null) tx.commit();
		}	
		catch (Exception e) {
		    if (tx!=null) tx.rollback();
		    throw new ServletException(e);
		}
		finally {
			if (hbSession!=null) {
				hbSession.close();
			}	
			hbSession = null;
			tx = null;			
		}							
		
	}
	// JSP Page methods:

	abstract public void _jspService(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException;

	// jspInit and jspDestroy can either be declared abstract or it can be
	// defined right here if some

	// centralized initialization/cleanup is to be done.

	public void jspInit() {
		
	}

	public void jspDestroy() {
	}



	
	
	// Before service handler method can be defined here.

	// After service handler method can be defined here.

	// Other functions can be defined here:

	// Performance Measurement Functions

	// Logging Functions

	// Error Handling Functions

	// Utility methods

	// Authentication Functions

}
