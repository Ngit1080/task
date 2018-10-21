<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- CSSの読み込み -->
<link rel=stylesheet type="text/css" href="css/style.css">
<title>検索</title>
</head>

<body>
	<h1>検索条件入力　　　<span class="loginInfo"><% out.print("ログイン者名：" + session.getAttribute("servlet-name")); %></span></h1>
	<form action="sampleSelect" method="post" >

	<div class="msgBox error">
    	<%
			String errerMsg = (String)request.getAttribute("errerMessage");
		%>
		<%
			if(errerMsg != null){
			out.println(errerMsg);
			}
		%>
	</div>
		<table>
			<tr>
				<th class="header">社員ID</th>
				<td>
					<input type="text" name="empId" placeholder="社員ID" value="" />
				</td>
			</tr>
			<tr>
				<th class="header">社員名</th>
				<td>
					<input type="text" name="empNm" placeholder="社員名" value="" />
				</td>
			</tr>
			<tr>
				<th class="header">社員名フリガナ</th>
				<td>
					<input type="text" name="empKn" placeholder="フリガナ" value="" />
				</td>
			</tr>
			<tr>
				<th class="header">メールアドレス</th>
				<td>
					<input type="text" name="mail" placeholder="メールアドレス" value="" />
				</td>
			</tr>
			<tr>
				<th class="header">所属部署ID</th>
				<td>
					<input type="text" name="dep" placeholder="所属部署ID" value="" />
				</td>
			</tr>
			<tr>
				<td colspan="2" class="btnArea">
					<input type="submit" value="検索" />
				</td>
			</tr>
		</table>
	</form>
	<a href="menu.jsp" >メニューに戻る</a>
</body>
</html>