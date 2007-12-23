<%@ page language="java" 
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<jsp:directive.page import="org.hibernate.*" />
<jsp:directive.page import="java.util.*" />
<jsp:directive.page import="webcalendar.bro.*" />
<jsp:directive.page import="webcalendar.bdo.*" />
<jsp:directive.page import="webcalendar.common.*" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%


	org.hibernate.classic.Session hbSession = HibernateUtils.getSessionFactory().openSession();
	Transaction tx = hbSession.beginTransaction();
	try {
		BROUser broUser = new BROUser(hbSession);
		
		List<User> users=broUser.loadAllUsers();
		for (User u2 : users) {
			out.println(u2 + "<br/>");
		}
	
		tx.commit();
	}
	catch (Exception e) {
	    if (tx!=null) tx.rollback();
	    e.printStackTrace();
	}
	finally {
		hbSession.close();
	}		

%>



ahoja!!!aa 

<p/>

<A HREF="index.jsp">Continue</A>




</body>
</html>