import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EmployeeDao;
import dto.EmployeeDto;

public class TestServlet extends HttpServlet {
	protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		req.setCharacterEncoding("UTF-8");

		//入力情報を取得
		String mail = req.getParameter("mail");
		String pass = req.getParameter("pass");
		String errer = "メールアドレスまたはPassが異なります";

		HttpSession session = req.getSession();

		EmployeeDao eDao = new EmployeeDao();
		EmployeeDto dto = new EmployeeDto();
		dto = null;

		try {
			 dto = eDao.selectAllColumn(mail);

		}catch (NumberFormatException e){
			 dto = null;
		}

		//社員情報あり、かつ入力したパスワードがデータベースの社員情報と同じだったら
		if(dto != null && pass.equals(dto.getPassword())) {
			//メールアドレス、パスワード、名前をセッション領域に格納
			session.setAttribute("servlet-mail", mail);
			session.setAttribute("servlet-pass", pass);
			session.setAttribute("servlet-name",dto.getNm_employee());
			req.getRequestDispatcher("menu.jsp").forward(req, res);
		//それ以外だったら
		}else {
			//エラーメッセージを表示
			req.setAttribute("errerMessage",errer);
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}
	}
}