<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
<h2>Add Book</h2>
<form method="post" action="<%=request.getContextPath()%>/whpda/api.pda/ajaxjson">
	name:<input type="text" name="workerid" id="workerid"> age:<input
		type="password" name="password" id="password"> <input type="submit"
															  value="Add">
</form>
<input id="sb" type="button" value="Ajax提交">
<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$("#sb").click(function() {
			 var pushdata = {
			 workerid : $("#workerid").val(),
			 password : $("#password").val()
			 };
			 $.ajax({
			 url : "<%=request.getContextPath()%>/ETC/api.jicha?method=login",
			 type : "POST",
			 contentType : "application/json",
			 dataType : "json",//json--返回json数据类型；xml--返回xml
			 data : JSON.stringify(pushdata),
			 success : function(data) {
				 console.log(data);
				 $.ajax({
					 url : "<%=request.getContextPath()%>/ETC/api.jicha?method=version",
					 type : "POST",
					 contentType : "application/json",
					 dataType : "json",//json--返回json数据类型；xml--返回xml

					 success : function(data) {
						 console.log(data)
					 }
				 });
			 }
			 });
			/*var pushdata1 = {
			 workerid : $("#workerid").val(),
			 blocks:["1","2","3","4"]
			 };*/


		});

	});
</script>
</body>
</html>
