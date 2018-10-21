import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;

//実行クラス（削除）
public class Delete extends HttpServlet {
	protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		req.setCharacterEncoding("UTF-8");

		//入力情報を取得
		String id = req.getParameter("empId");

		String errer = "該当社員は存在しません";

		EmployeeDao eDao = new EmployeeDao();

		// データベースを検索
		int deleteId = eDao.selectId(Integer.parseInt(id));

		// 社員情報が1件以上あったら
		if(deleteId > 0) {
			//削除メソッドを呼び出す
			eDao.deleteAllColumn(Integer.parseInt(id));
			req.setAttribute("servlet-id", id);
			req.getRequestDispatcher("deleteComplete.jsp").forward(req, res);
		//社員情報が0件だったらエラーメッセージを表示
		} else {
			req.setAttribute("errerMessage",errer);
			req.getRequestDispatcher("delete.jsp").forward(req, res);
		}
	}
}
