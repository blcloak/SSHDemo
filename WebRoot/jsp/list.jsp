<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="./common/common.jsp"%>
<html>
<head>
<title>User List</title>

</head>

<body>
	<nav class="navbar navbar-default" role="navigation">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">W3Cschool</a>
	</div>
	<div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">iOS</a></li>
			<li><a href="#">SVN</a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"> Java <b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a href="#">jmeter</a></li>
					<li><a href="#">EJB</a></li>
					<li><a href="#">Jasper Report</a></li>
					<li class="divider"></li>
					<li><a href="#">分离的链接</a></li>
					<li class="divider"></li>
					<li><a href="#">另一个分离的链接</a></li>
				</ul></li>
		</ul>
	</div>
	</nav>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-xs-2">
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">SVN</a></li>
					<li><a href="#">iOS</a></li>
					<li><a href="#">VB.Net</a></li>
					<li><a href="#">Java</a></li>
					<li><a href="#">PHP</a></li>
				</ul>

			</div>
			<div class="col-xs-10">
				<div class="row-fluid">
					<div class="bloak">
						<table class="table table-bordered table-hover">
							<caption>边框表格布局</caption>
							<thead>
								<tr>
									<th>User Name</th>
									<th>Password</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator id="" value="#request.users">
									<tr>
										<td><s:property value='username' /></td>
										<td><s:property value='password' /></td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
				</div>
				<div class="row-fluid">
					<div class="bloak">
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
