<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ page import="dto.EmployeeDto" %>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- CSSの読み込み -->
<link rel=stylesheet type="text/css" href="css/style.css">
<title>社員情報更新</title>
</head>

<body>
	<h1>社員情報更新　　　<span class="loginInfo"><% out.print("ログイン者名：" + session.getAttribute("servlet-name")); %></span></h1>
	<form action="sampleUpdateInput" method="post">
	<%
			EmployeeDto dto = (EmployeeDto)request.getAttribute("employeeList");
	%>

		<table>
			<tr>
				<th class="header">社員ID</th>
				<td>
					<input type="text" name="empId" readonly="readonly" class="readOnly" value="<%=dto.getId_employee() %>" required="required" />
				</td>
			</tr>
			<tr>
				<th class="header">社員名</th>
				<td>
					<input type="text" name="empNm" placeholder="社員名" value="<%=dto.getNm_employee() %>" required="required"/>
				</td>
			</tr>
			<tr>
				<th class="header">社員名フリガナ</th>
				<td>
					<input type="text" name="empKn" placeholder="フリガナ" value="<%=dto.getKn_employee() %>" required="required"/>
				</td>
			</tr>
			<tr>

				<th class="header">メールアドレス</th>
				<td>
					<input type="text" name="mail" placeholder="メールアドレス" value="<%=dto.getMail_address() %>" required="required"/>
				</td>
			</tr>
			<tr>
				<th class="header">パスワード</th>
				<td>
					<input type="password" name="pass" placeholder="パスワード" value="<%=dto.getPassword() %>"/>
					<input type="hidden" name="passOld" value="<%=dto.getPassword() %>" />
				</td>
			</tr>
 			<tr>
				<th class="header">所属部署ID</th>
				<td>
					<input type="text" name="dep" placeholder="所属部署ID" value="<%=dto.getId_department() %>" required="required"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" class="btnArea">
					<input type="submit" value="更新" />
				</td>
			</tr>
		</table>
	</form>
	<a href="update.jsp" >更新対象の変更</a>　|　<a href="menu.jsp" >メニューに戻る</a>
</body>
</html>