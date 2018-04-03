<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

<h2>Login as Manager</h2>

<form action="select.jsp">
  Host:<br>
  <input type="text" name="IP" value="localhost">
  <br>
  User:<br>
  <input type="text" name="User" value="">
  <br>
  Password:<br>
  <input type="text" name="Password" value="">
  <br><br>
  <input type="submit" value="Submit">
</form> 

<p>If you click the "Submit" button, the form-data will be sent to a page called "select.jsp".</p>

</body>
</html>
