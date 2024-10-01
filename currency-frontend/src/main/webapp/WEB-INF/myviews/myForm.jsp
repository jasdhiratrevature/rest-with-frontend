<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>

<form action="form-submit">
Select the From Currency : 
<select name="from">
<option vaule="USD">USD</option>
<option vaule="EUR">EUR</option>
<option vaule="AUD">AUD</option>
</select>
<br/>
Select the To Currency : 
<select name="to">
<option vaule="INR">INR</option>
</select>
<br>
How Many to Convert 
<input type="number" name="quantity"/>
<br/>
<input type="submit">
</form>


</body>
</html>