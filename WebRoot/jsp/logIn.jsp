<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="./common/common.jsp"%>

<html>
<head>

<script>
function doSubmit(){
	document.forms[0].submit;
}
</script>
<base href="${basePath}" />
<title>Share your ideals</title>

</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-md-2 col-md-offset-5">
				<div class="block">
					<form role="form" action="logIn" id="loginForm">
						<div class="form-group">
							<div class=" text-center">
								<img src="img/loginlog.png" width="60">
								<p></p>
								<h1>
									<span>Login</span>
								</h1>
							</div>
							<input type="text" class="form-control" class="required" id="userName" name="user.username" placeholder="用户名">
							<p></p>
							<input type="password" class="form-control" id="password" name="user.password" placeholder="密码">
							<p></p>
							<button type="submit"  class="btn btn-default btn-block btn-danger">登录</button>
							<p></p>
							<p align="right">
								<a href="${basePath}jsp/register.jsp" class="btn">注册</a>| <a class="btn">忘记密码?</a>
							</p>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>


</html>
