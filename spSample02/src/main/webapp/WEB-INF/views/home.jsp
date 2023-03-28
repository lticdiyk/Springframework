<%@page import="mul.cam.a.dto.HumanDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>home</h1>
<br>

<a href="hello.do">hello</a><br>
<%
	String name = (String)request.getAttribute("name");	
	if(name != null && !name.equals("")){
		%>
		이름:<%=name %>
		<%
	}
%>
<br><br>

<form action="world.do" method="post">
이름:<input type="text" name="name"><br>
나이:<input type="text" name="age">
<input type="submit" value="world로 이동">
</form>

<!-- 
<a href="home.do?name=홍길동&age=24"></a>

<script type="text/javascript">
location.href = ""
</script>
 -->

<br><br>

<form action="main.do" method="post">
이름:<input type="text" name="name"><br>
나이:<input type="text" name="age">
<input type="submit" value="main로 이동">
</form>

<br><br>

<!--   
		mylist.do
		
		-> list
		-> 출력 table
 --> 
<a href="mylist.do?message=하이">my list</a> 
<br><br>  
<%
	List<HumanDto> list = (List<HumanDto>)request.getAttribute("list");
	if(list != null && list.isEmpty() == false){
		%> 
		
		<table border="1">
		<tr>
			<th>번호</th><th>이름</th><th>나이</th>
		</tr>
		<%
			for(int i = 0;i < list.size(); i++){
				HumanDto dto = list.get(i);	
			%>
				<tr>
					<th><%=i + 1 %></th>
					<td><%=dto.getName() %></td>
					<td><%=dto.getAge() %></td>
				</tr>
			<%
			}		
		%>
		</table>
		<%
	}
%>



</body>
</html>


