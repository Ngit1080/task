<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- CSSの読み込み -->
<link rel=stylesheet type="text/css" href="css/style.css">
<title>ログイン</title>
</head>

<body>
    <h1>ログイン</h1>
    <form method="post" action="sampleTest">
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
                <th class="header">メールアドレス</th>
                <td style="width: 250px;">
                    <input type="text" placeholder="メールアドレス" name="mail" required="required"
                        style="width: 100%;" value=""/>
                </td>
            </tr>
            <tr>
                <th style="text-align: right;">パスワード</th>
                <td>
                    <input type="password" placeholder="パスワード" name="pass" required="required"
                        style="width: 100%;" value="" />
                </td>
            </tr>
            <tr>
                <td colspan="2" class="btnArea">
                    <input type="reset" value="リセット" />
                    <input type="submit" value="ログイン"  />
                </td>
            </tr>
        </table>
    </form>
</body>

</html>
