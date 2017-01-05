<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="model.Question"%>
<%@page import="java.util.ArrayList"%>

<% ArrayList<Question> questions = (ArrayList<Question>)session.getAttribute("questions"); %> 
<% int current = (int)session.getAttribute("questionNo"); %>
<% int questionCount = questions.size();%>
<!DOCTYPE html>
<html>
  <head>
    <title>Psychotest</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
     <link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
  </head>
  <body>
     
    <jsp:include page="fragment/navbar.jspf" />
    
    <div class="container">
    	<h1>Pytanie <%=current %>/<%=questionCount %></h1>
    	<% session.setAttribute("questionNo", current); %>
    	<p><%= questions.get(current-1).getText() %></p>
    	<form action="question" method="post">
    	<select name="rate">
	    	<% for(int i = 1; i < 11; i++) { %>
			   <option value=<%=i%>><%=i%></option> 
		    <% } %>
		</select>
		<input type="submit" value="Dalej">
		</form>
		<br>
    	<p>Twoja odpowiedź:</p>
    	<ul>
	    	<li>1 - nie zgadzam się całkowicie</li>
	    	<li>10 - zgadzam się całkowicie</li>
    	</ul>
    </div>
     
    <jsp:include page="fragment/footer.jspf" />
     
    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="resources/js/bootstrap.js"></script>
  </body>
</html>