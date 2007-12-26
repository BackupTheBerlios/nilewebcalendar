package webcalendar;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;

import webcalendar.common.HibernateUtils;


public abstract class DefaultController extends HttpServlet {
	
	public static final String PARAM_CONTROLLER_METHOD = "$method";	
	
	private org.hibernate.classic.Session hbSession=null;
	private Transaction tx=null;

	protected org.hibernate.classic.Session getHbSession() {
		if (hbSession==null) {
			hbSession = HibernateUtils.getSessionFactory().openSession();			
		}
		if (tx==null) {
			tx = hbSession.beginTransaction();
		}
		return hbSession;
	}
	
	protected String getDefaultMethodName() {
		return "show";
	}
	
	/**
	 * Vytvori prazdne parametry
	 * @return
	 */
	protected final Map<String,String> createParameters() {
		return new HashMap<String,String>();		
	}
	
	/**
	 * Vytvori parametry z requestu
	 * @param request
	 * @return
	 */
	protected final Map<String,String> createParameters(HttpServletRequest request) {
		Map<String,String> params=new HashMap<String,String>();		
		Enumeration en=request.getParameterNames();
		while(en.hasMoreElements()){				
			String name=(String)en.nextElement();				
			if (!name.startsWith("$")) { 
				String value=request.getParameter(name);
				params.put(name, value);
			}
		}
		return params;
	}

	private String completeParams(Map<String,String> params) {

		if (params==null) {
			return "";
		}
		
		StringBuffer sb=new StringBuffer();		
		Iterator it=params.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry entry= (Map.Entry)it.next();
			sb.append(entry.getKey());
			sb.append("=");
			sb.append(entry.getValue());
			sb.append("&");
		}
		return sb.toString();
	}
		
	protected final void showView(HttpServletResponse response, String jsp, Map<String,String> params) throws IOException {			
		String url = jsp + "?" + completeParams(params);
		response.sendRedirect(url);
	}
	
	protected final void redirect(HttpServletResponse response, String controller, String controllerMethod, Map<String,String> params) throws IOException {
		
		String url = controller + "?" + completeParams(params);
		if (controllerMethod!=null) {
			url+=PARAM_CONTROLLER_METHOD+"="+controllerMethod+"&";
		}				
		response.sendRedirect(url);		
	}
	
	private void callRequestedMethod(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String methodName = request.getParameter(PARAM_CONTROLLER_METHOD);		
		if (methodName==null) methodName = getDefaultMethodName();
		
		try {
			Method m=this.getClass().getDeclaredMethod(methodName, 
					new Class[] { HttpServletRequest.class, HttpServletResponse.class});
			m.invoke(this, new Object[] {request,response});
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	
	
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
				
		try {
		
			callRequestedMethod(request, response);
		
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
		
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		doGet(req,resp);
	}

	public void show(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getOutputStream().println("Show method not implemented!");
	}	
		
}
