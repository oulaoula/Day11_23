<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊 - 登录</title>
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/adv.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/adv.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/function.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/scripts/index.js"></script>
<script type="text/javascript">
	function changeCode() {
		//从文档中取出img图片
		var img = document.getElementById("veryCode");
		//获取图片的src 属性 并赋值
		//注意:如果请求网址完全相同 则浏览器不会帮你刷新
		//可以拼接当前时间  让每次请求的网址都不一样
		img.src = "doS3?" + new Date().getTime();
		return false;
	}
</script>
</head>
<body>
	<%@ include file="index_top.jsp"%>
	<div id="register" class="wrap">
		<div class="shadow">
			<em class="corner lb"></em> <em class="corner rt"></em>
			<div class="box">
				<h1>欢迎回到亚马逊</h1>
				<form id="loginForm" method="post" action="login"
					onsubmit="return loginCheck()">
					<table>
						<tr>
							<td class="field">用户名：</td>
							<td><input class="text" type="text" name="userName"
								onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
						</tr>
						<tr>
							<td class="field">登录密码：</td>
							<td><input class="text" type="password" id="passWord"
								name="passWord" onfocus="FocusItem(this)"
								onblur="CheckItem(this);" /><a href="retrieve_password.jsp">忘记密码</a></td>

						</tr>
						<tr>
							<td class="field">验证码：</td>
							<td><input class="text verycode" type="text" id="newCode"
								onfocus="FocusItem(this)" onblur="checkValidateCode();"
								maxlength="4" /><img id="veryCode" name="veryCode" src="doS3" /><a
								onclick="changeCode()">看不清换一张</a> <span id="Code"></span></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-green"><input type="submit"
									name="submit" value="立即登录" /></label></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2016 上海海文 All Rights Reserved</div>
</body>
</html>
