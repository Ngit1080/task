import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import dto.EmployeeDto;

public class Update extends HttpServlet {
	protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		req.setCharacterEncoding("UTF-8");

		//入力情報を取得
		String id = req.getParameter("empId");

		String errer = "該当社員は存在しません";

		EmployeeDao eDao = new EmployeeDao();
		EmployeeDto dto = new EmployeeDto();

		// データベースを検索
		dto = eDao.selectUpdate(Integer.parseInt(id));

		// 社員情報が1件以上あったら
		if(dto != null) {
			req.setAttribute("employeeList", dto);
			req.getRequestDispatcher("updateInput.jsp").forward(req, res);
		//社員情報が0件だったら
		} else {
			//エラーメッセージを表示
			req.setAttribute("errerMessage",errer);
			req.getRequestDispatcher("update.jsp").forward(req, res);
		}
	}

}
