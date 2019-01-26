<!DOCTYPE html>
<%@page import="com.concretepage.entity.Article"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>


<p>Welcome to You ${message}</p>

<%  Article article = (Article) request.getAttribute("article"); %>

<%= article %>
<body>
<form>
	<table>
         <tr>
            <td>ID</td>
            <td>${article.articleId}</td>
         </tr>
         
         <tr>
            <td>Title</td>
            <td>${article.title}</td>
         </tr>
         
         <tr>
            <td>Category</td>
            <td>${article.category}</td>
         </tr>
         
      </table>  
</form>
</body>
</html>