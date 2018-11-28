<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<%=basePath %>bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="stylesheet" href="<%=basePath %>bootstrap-3.3.7-dist/jq/jquery-3.2.0.min.js">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<table class="table table-hover" style="height: 100%;width: 100%;border: 1px black solid;">
			<c:forEach items="${orders}" var="s">
			<tr><td>${s}</td></tr>
		</c:forEach>
		</table>
	</div>
	
</body>
</html>