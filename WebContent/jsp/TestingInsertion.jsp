<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<link href="css/bootstrap.css" type="text/css"  rel="stylesheet" media="screen">
	<link href="css/bootstrap-responsive.css"  type="text/css"  rel="stylesheet" media="screen">
</head>
<body>
<!-- <form action="/Schooltrix/sction.do"> -->
<!-- <form action="TestLogin.do"   > -->
		<form action="TestLogin.action" method="post"  >
			Class Name:<input type="text" name="class_name"><br>
			Active::<input type="text" name="active">
							<input type="submit">
		</form>
</body>
</html>