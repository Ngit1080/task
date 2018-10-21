import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;

public class UpdateInput extends HttpServlet {
	protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		req.setCharacterEncoding("UTF-8");

		//入力情報を取得
		String id = req.getParameter("empId");
		String name = req.getParameter("empNm");
		String kana = req.getParameter("empKn");
		String mail = req.getParameter("mail");
		String pass = req.getParameter("pass");
		String dep = req.getParameter("dep");

		EmployeeDao eDao = new EmployeeDao();

		//更新メソッドの呼び出し
		eDao.updateEmployee(Integer.parseInt(id),name,kana,mail,pass,Integer.parseInt(dep));
		req.getRequestDispatcher("updateComplete.jsp").forward(req, res);
	}
}