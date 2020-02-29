<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.header {
  padding: 80px;
  text-align: center;
  background: #1abc9c;
  color: white;
}

/* Increase the font size of the heading */
.header h1 {
  font-size: 40px;
}
</style>
</head>
<body>
<div class="header">
<%
out.println("Welcome "+(session.getAttribute("Name")));%></br>
<% out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");%></br>
<%out.println("Name :"+(session.getAttribute("Name"))); %></br>
<%out.println("Email :"+(session.getAttribute("Email"))); %></br>
<% out.println("Mobile :"+(session.getAttribute("Mobile")));%></br>
<% out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");%></br>

<a href="/Gmail/home.html"><input type="submit" value="Log out"></a>
</div>
</body>
</html>