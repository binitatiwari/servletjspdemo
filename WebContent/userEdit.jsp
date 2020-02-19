<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<%@ include file="header.jsp" %>
</head>
<body>
	<form action ="UserController" method="post">
	<div>
		<label>ID</label>
		<input type="text" name="id" readonly="readonly" value="${user.id}">
	
	</div>
	
	
	<div>
		<label> Username </label>
		<input type="text" name="uname" value="${user.username}">
	</div>
	<div>
		<label>Password </label>
		<input type="password" name="pass" value="${user.password}">
	</div>
	<div>
		<label>Email </label>
		<input type="email" name="email" value="${user.email}">
	</div>
	<div>
		<label>DOB </label>
		<input type="date" name="dob" value="${user.dob}">
	</div>
	<div>
		<label>Gender </label>
		<input type="radio" name="gender" value="Male"${user.gender=='Male'?'checked':''}>Male
		<input type="radio" name="gender" value="Female"${user.gender=='Female'?'checked':''}>Female
	</div>
	<div>
		<label>Hobbies </label>
		<input type="checkbox" name="hobbies" value="Reading"
		<c:if test="${fn:contains(user.hobbies, 'Reading')}">checked</c:if>
		
		>Reading
		<input type="checkbox" name="hobbies" value="Playing"
		
		<c:if test="${fn:contains(user.hobbies, 'Playing')}">checked</c:if>
		
		>playing
	</div>
	<div>
	<select name="nationality">
		<option value="Nepalese"${user.nationality=='Nepalese'?'selected':'' }>Nepalese</option>
		<option value="Indian"${user.nationality=='Indian'?'selected':'' }>Indian</option>
		
		<option value="Chinease"${user.nationality=='Chinease'?'selected':'' }>Chinease</option>
		<option value="American"${user.nationality=='American'?'selected':'' }>American</option>
	
	</select>
	
	
	</div>
	
	<div>
		
		<input type="submit" value="submit">
	</div>
	
	
</form>
</body>
</html>