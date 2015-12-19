<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="./common/common.jsp"%>
 <script language="javascript" type="text/javascript" src="./js/common.js"></script>
<html>
<head>
<title>User List</title>
<script>
	function addBook() {
		$('#addForm')[0].action = "addBook";
		$('#addForm')[0].submit();
	}

	function delBook() {
		$('#showTable')[0].action = "delBook";
		$('#showTable')[0].submit();
	}
	window.onload = function()
	{
	    new TableSorter("bookTable");
	}
</script>
</head>

<body>
	<div class="container">
		<jsp:include page="./common/topNav.jsp" flush="true"/>
		<div class="row-fluid">
			<jsp:include page="./common/leftNav.jsp" flush="true"/>
			<div class="col-xs-10">
				<div class="row-fluid">
					<div class="bloak">
						<form id="showTable">
							<input name="key" type="text" id="key" onkeydown="onSearch(this, 'bookTable',3)" value="" />
							<table class="table table-bordered table-hover" id="bookTable">
								<caption>书</caption>
								<thead>
									<tr>
										<th></th>
										<th>书名</th>
										<th>作者</th>
										<th>出版商</th>
										<th>价格</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator id="bookList" value="bookList">
										<tr>
											<td><input type="checkbox" name='delName' value='<s:property value="bookNo"/>'></td>
											<td><s:property value='bookName' /></td>
											<td><s:property value='author' /></td>
											<td><s:property value='publisher' /></td>
											<td><s:property value='price' /></td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
						</form>
					</div>
				</div>
				<div class="row-fluid">
					<div class="bloak">
						<div class="form-group">
							<button class="btn" data-toggle="modal" data-target="#myModal">添加书籍</button>
							<button type="button" class="btn btn-danger" onclick="delBook()">删除</button>
						</div>
					</div>
				</div>

				<!-- 模态框（Modal） -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">添加书籍</h4>
							</div>
							<div class="modal-body">
								<form role="form-horizontal" id="addForm">
									<!--class="form-horizontal" -->
									<table class="table">
										<tr>
											<td width="40%"><label for="firstname" class="control-label">书名</label></td>
											<td width="60%"><input type="text" class="form-control" id="firstname" name="newBook.bookName" placeholder="请输入书名"></td>
										</tr>
										<tr>
											<td><label for="lastname" class=" control-label">作者</label></td>
											<td><input type="text" class="form-control" id="lastname" name="newBook.author" placeholder="请输入作者"></td>
										</tr>
										<tr>
											<td><label for="firstname" class="control-label">出版商</label></td>
											<td><input type="text" class="form-control" id="firstname" name="newBook.publisher" placeholder="请输入出版商"></td>
										</tr>
										<tr>
											<td><label for="lastname" class="control-label">价格</label></td>
											<td><input type="text" class="form-control" id="lastname" name="newBook.price" placeholder="请输入价格"></td>
										</tr>
									</table>
								</form>
							</div>

							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
								<button type="button" class="btn btn-primary" onclick="addBook()">保存</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>


</html>
