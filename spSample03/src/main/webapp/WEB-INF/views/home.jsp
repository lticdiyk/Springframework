<%@page import="mul.cam.a.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<MemberDto> list = (List<MemberDto>)request.getAttribute("list");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
</head>
<body>

<h1>home</h1>

<table border="1">
<tr>
	<th>번호</th><th>id</th><th>pw</th><th>name</th><th>email</th>
</tr>
<%
	for(int i = 0;i < list.size(); i++){
		MemberDto dto = list.get(i);
	%>
	<tr>
		<th><%=i + 1 %></th>
		<td><%=dto.getId() %></td>
		<td><%=dto.getPwd() %></td>
		<td><%=dto.getName() %></td>
		<td><%=dto.getEmail() %></td>
	</tr>
	<%
	}	
%>
</table>

<br><br>

<!-- ajax send(String) recv(String)  -->
id:<input type="text" id="checkid"><br><br>
<button type="button" onclick="idcheckBtn()">아이디첵크</button>

<script type="text/javascript">
function idcheckBtn() {
	
	$.ajax({
		url:"idcheck.do",
		type:"get",
	//	data:"id=" + $("#checkid").val(),
		data:{ "id":$("#checkid").val() },
		success:function(msg){
			//alert('success');
			alert(msg);
		},
		error:function(){
			alert('error');
		}
	});	
}
</script>

<br><br>

<!-- send(object) recv(list) -->
id:<input type="text" id="id" value="gdhong"><br>
pw:<input type="text" id="pwd" value="1234"><br>
name:<input type="text" id="name" value="홍길동"><br>
email:<input type="text" id="email" value="gdhong@naver.com"><br>
<button type="button" id="account">회원가입</button>

<script type="text/javascript">
$("#account").click(function(){
	// servlet-context.xml에 ajax 사용허가를 설정
	let member = {
			"id":$("#id").val(),
			"pwd":$("#pwd").val(),
			"name":$("#name").val(),
			"email":$("#email").val()
	};
	
	$.ajax({
		url:"account.do",
		type:"post",
		dataType:"json",
		data:member,
		async:true,
		success:function( list ){
			// alert('success');
			// alert(JSON.stringify(list));
			
			alert(list[1].name);
			
		},
		error:function(){
			alert('error');
		}
	});
	
	
	
});
</script>

</body>
</html>










