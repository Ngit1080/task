<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- CSSの読み込み -->
<link rel=stylesheet type="text/css" href="css/style.css">
<title>社員登録</title>
</head>

<body>
	<h1>社員登録　　　<span class="loginInfo"><% out.print("ログイン者名：" + session.getAttribute("servlet-name")); %></span></h1>
	<form action="sampleInsert" method="post" >

		<table>
			<tr>
				<th class="header">社員ID</th>
				<td>
					<input type="text" name="empId" readonly="readonly" class="readOnly" value="自動で設定されます" />
				</td>
			</tr>
			<tr>
				<th class="header">社員名</th>
				<td>
					<input type="text" name="empNm" placeholder="社員名" required="required" value="" />
				</td>
			</tr>
			<tr>
				<th class="header">社員名フリガナ</th>
				<td>
					<input type="text" name="empKn" placeholder="フリガナ" required="required" value="" />
				</td>
			</tr>
			<tr>
				<th class="header">メールアドレス</th>
				<td>
					<input type="text" name="mail" placeholder="メールアドレス" required="required" value="" />
				</td>
			</tr>
			<tr>
				<th class="header">パスワード</th>
				<td>
					<input type="password" name="pass" placeholder="パスワード ※3文字以上" required="required" value="" />
				</td>
			</tr>
			<tr>
				<th class="header">所属部署ID</th>
				<td>
					<input type="text" name="dep" placeholder="所属部署ID" required="required" value="" />
				</td>
			</tr>
			<tr>
				<td colspan="2" class="btnArea">
					<input type="submit" value="登録" />
				</td>
			</tr>
		</table>
	</form>
	<a href="menu.jsp" >メニューに戻る</a>
</body>
</html>