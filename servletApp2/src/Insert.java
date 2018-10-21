import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;

public class Insert extends HttpServlet {
	protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		req.setCharacterEncoding("UTF-8");

		//入力情報を取得
    	String pass = req.getParameter("pass");
    	String name = req.getParameter("empNm");
    	String  kana = req.getParameter("empKn");
    	String mail = req.getParameter("mail");
    	String department = req.getParameter("dep");

		EmployeeDao eDao = new EmployeeDao();

		//社員情報追加メソッドの呼び出し
		eDao.InsertEmployee(name,kana,mail,pass,Integer.parseInt(department));
		req.getRequestDispatcher("insertComplete.jsp").forward(req, res);
		}
}
