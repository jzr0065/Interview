<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="interview.ShowPeers" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		 List<String> result = new ArrayList<String>();
   	  	 ShowPeers m;
   	  	 m = new ShowPeers(request.getParameter("IP"),request.getParameter("User"),request.getParameter("Password"));
   	  	 result = m.show();%>
   	<form action="check.jsp">
   	<%= result.get(0)%>:<br>
   		<select name="sip">
   		<% for(int i=1;i<result.size();i++)
   			{%>
    		<option value="<%= result.get(i) %>"><%=result.get(i) %></option>
   		<%
   			}
    	%>
  		</select><br>
  		Extension:<br>
  		<input type="text" name="extension" value="">
  		<br>
  		Context:<br>
  		<input type="text" name="context" value="">
  		<br>
  		<input type="submit" value="Dial">
  	</form>
  	
  	<p>select one to dial!
</body>
</html>