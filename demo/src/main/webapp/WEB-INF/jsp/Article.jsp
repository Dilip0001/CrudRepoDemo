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
</head>
<body>
		<form:form method = "GET" action = "/allCategory" modelAttribute="command">
		 		<input type = "submit" value = "Click here to get category"/>
		</form:form>
      <h2>Article Information</h2>
      
      <form:form method = "POST" action = "/addArticle">
         <table>
            <tr>
               <td><form:label path = "title" >Title</form:label></td>
               <td><form:input path = "title" name="title" /></td>
            </tr>
            <tr>
               <td><form:label path = "category">Category</form:label></td>
               <td><form:input path = "category" name="category" /></td>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Submit"/>
               </td>
            </tr>
         </table>  
      </form:form>
   </body>
</html>