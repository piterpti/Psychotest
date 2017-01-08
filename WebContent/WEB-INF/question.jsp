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
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
  </head>
  
  <style>
	 input[type=radio] {
	    display: block;
	    margin: 0 auto;
	    padding: 10px;
	}
	label {
	    display: inline-block;
	    padding-right: 20px;
	}
	#send {
		margin-top 10px;
		padding-left: 50px;
		padding-right: 50px
	}

  </style>
  
  <script type="text/javascript">
	function validateRadio (radios)
	{
	    for (i = 0; i < radios.length; ++ i)
	    {
	        if (radios [i].checked) return true;
	    }
	    return false;
	}
	
	function validateForm()
	{
	    if(validateRadio (document.forms["answer"]["rate"]))
	    {
	        return true;
	    }
	    else
	    {
	        alert('Nie zaznaczono żadnej odwpoiedzi');
	        return false;
	    }
	}
</script>
  
  <body>
     
    <jsp:include page="fragment/navbar.jspf" />
    
    <div class="container">
    	<h1>Pytanie <%=current %>/<%=questionCount %></h1>
    	<% session.setAttribute("questionNo", current); %>
    	<p><%= questions.get(current-1).getText() %></p>
    	<p>Twoja odpowiedź:</p>
    	
    	<form action="question" method="post" name="answer" onsubmit="return validateForm()">
    	<% for(int i = 0; i < 11; i++) { %>
			    
			<label><input type="radio" name="rate" value=<%=i %> /><%=i %></label>
				
	    <% } %>
	    <br>
	    <input id="send" type="submit" value="Dalej">
	    </form>
	    <br>
	    Odpowiedź oznacza:
    	<ul>
	    	<li>0 - nie zgadzam się całkowicie</li>
	    	<li>10 - zgadzam się całkowicie</li>
    	</ul>
    	
    </div>
     
    <jsp:include page="fragment/footer.jspf" />
     
    <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <script src="resources/js/bootstrap.js"></script>
  </body>
</html>