<%@page import="java.util.ArrayList"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>

<% ArrayList<String> list = (ArrayList<String>)request.getAttribute("list");
	for(String list1:list)
	{
		%>
		
		<%=list1%>
	<% 
	}
%>
      <h2>Select Your Category</h2>
      <form:form method = "POST" action = "/selectArticle" modelAttribute="command">
         <table>    
	    <form:select path="list">
   			<form:option value="NONE" label="--- Select ---"/>
   			<form:options items="${list}" />
		</form:select>
         </table>  
      </form:form> 
   </body>
</html>