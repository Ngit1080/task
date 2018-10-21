<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<form action="sampleUpdate" method="post">
	<div class="msgBox error">
	<%
			String deleteId = (String)request.getAttribute("servlet_id");
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
                <td style="width: 250px;">
                    <input type="text" placeholder="社員ID" name="empId" required="required"
                        style="width: 100%;" value=""/>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="btnArea">
                    <input type="hidden" name="page" value="update" />
                    <input type="submit" value="更新内容入力"  />
                </td>
            </tr>
        </table>
	</form>
	<a href="menu.jsp" >メニューに戻る</a>
</body>
</html>