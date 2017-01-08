<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Doradca sprzętowy</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    
  </head>
 
  <body>
     
    <jsp:include page="fragment/navbar.jspf" />
    
    <div class="container">
    
    <div class="page-header">
        <h1>O nas <small>czyli o twórcach tej strony</small></h1>
      </div>
      
      <div class="row">
        <div class="col-md-6 col-sm-6 col-xs-12">
          <div class="thumbnail">
            <img src="resources/images/2016-05-26.jpg" alt="...">
            <div class="caption">
              <h3 style="text-align: center;">Piotr Łukasik</h3>
              <p class="text-justify">Główny programista - Java/SQL</p>
            </div>
          </div>
        </div>
        <div class="col-md-6 col-sm-6 col-xs-12">
          <div class="thumbnail">
            <img src="resources/images/pic01.jpg" alt="...">
            <div class="caption">
              <h3 style="text-align: center;">Damian Kurek</h3>
              <p class="text-justify">Projektant bazy danych - SQLite3</p>
            </div>
          </div>
        </div>
        <div class="col-md-6 col-sm-6 col-xs-12">
          <div class="thumbnail">
            <img src="resources/images/pic01.jpg" alt="...">
            <div class="caption">
              <h3 style="text-align: center;">Katarzyna Krzemińska</h3>
              <p class="text-justify">Frontend HTML/CSS3/Bootstrap</p>
            </div>
          </div>
        </div>
      </div>  
     </div>  
     
    <jsp:include page="fragment/footer.jspf" />
     
    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="resources/js/bootstrap.js"></script>
  </body>
</html>