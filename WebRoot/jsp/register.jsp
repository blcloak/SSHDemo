<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="./common/common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>
<body>
<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-md-2 col-md-offset-5">
				<div class="block">
					<form role="form" action="userAdd" id="loginForm">
						<div class="form-group">
							<div class=" text-center">
								<p></p>
								<h1>
									<span>注册</span>
								</h1>
							</div>
							<input type="text" class="form-control" class="required" id="userName" name="user.username" placeholder="用户名">
							<p></p>
							<input type="password" class="form-control" id="password" name="user.password" placeholder="密码">
							<p></p>
							<button type="submit" class="btn btn-default btn-block btn-danger">登录</button>
							<p></p>
							<p align="right">
								<a href="${basePath}jsp/logIn.jsp" class="btn">登录</a>
							</p>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


</form>





</body>
</html>
