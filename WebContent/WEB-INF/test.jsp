<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    	<h2>Za chwilę rozpoczniesz test osobowości</h2>
    	<p>Aby uzyskać jak najlepszy wynik odpowiadaj szczerze - przemyśl swoje odpowiedzi - nie jest to wyścig z czasem ;)</p>
    	<a href="question">Rozpocznij test</a>
    	
    </div>
    
    
     
    <jsp:include page="fragment/footer.jspf" />
     
    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="resources/js/bootstrap.js"></script>
  </body>
</html>