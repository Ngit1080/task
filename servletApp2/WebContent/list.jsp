<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
       <%@ page import="dto.EmployeeDto" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- CSSの読み込み -->
<link rel=stylesheet type="text/css" href="css/style.css">
<title>検索結果表示</title>
</head>

<body>
	<h1>検索結果表示　　　<span class="loginInfo"><% out.print("ログイン者名：" + session.getAttribute("servlet-name")); %></span></h1>
	<% ArrayList<EmployeeDto> list = (ArrayList<EmployeeDto>)request.getAttribute("employeeList"); %>
	<table>
		<thead>
			<tr>
				<th style="width: 60px;">社員ID</th>
				<th style="width: 100px;">社員名</th>
				<th style="width: 150px;">フリガナ</th>
				<th style="width: 150px;">メールアドレス</th>
				<th style="width: 60px;">パスワード</th>
				<th style="width: 100px;">所属部署ID</th>
			</tr>
		</thead>
		<tbody>

					<% for(int i = 0; i < list.size(); i++) { %>
				<tr>
					<%EmployeeDto dto = list.get(i);%>
					<td><%=dto.getId_employee() %></td>
					<td><%=dto.getNm_employee() %></td>
					<td><%=dto.getKn_employee() %></td>
					<td><%=dto.getMail_address() %></td>
					<td><%=dto.getPassword() %></td>
					<td><%=dto.getId_department() %></td>
				</tr>
					<% } %>
		</tbody>
	</table>
	<hr>
	<a href="select.jsp">検索条件入力に戻る</a>　|　<a href="menu.jsp">メニューに戻る</a>
</body>
</html>