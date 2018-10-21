<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- CSSの読み込み -->
<link rel=stylesheet type="text/css" href="css/style.css">
<title>メインメニュー</title>
</head>

<body>
	<h1>メインメニュー　　　<span class="loginInfo"><% out.print("ログイン者名：" + session.getAttribute("servlet-name")); %></span></h1>
	<table>
		<!-- 検索列 -->
		<tr>
			<td><a href="select.jsp">検索</a></td>
		</tr>

		<!-- 登録列 -->
		<tr>
			<td><a href="insert.jsp">登録</a></td>
		</tr>

		<!-- 更新列 -->
		<tr>
			<td><a href="update.jsp">更新</a></td>
		</tr>

		<!-- 削除列 -->
		<tr>
			<td><a href="delete.jsp">削除</a></td>
		</tr>
	</table>
</body>

</html>