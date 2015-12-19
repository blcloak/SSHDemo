<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="./common/common.jsp"%>
<html>
<head>
<title>User List</title>
</head>
<body>
	<div class="container">
		<jsp:include page="./common/topNav.jsp" flush="true" />
		<div class="row-fluid">
			<jsp:include page="./common/leftNav.jsp" flush="true" />
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
			</div>
		</div>
	</div>
</body>
</html>
