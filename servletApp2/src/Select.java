import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import dto.EmployeeDto;

public class Select extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		// 入力情報を取得
		String id = req.getParameter("empId");
		String name = req.getParameter("empNm");
		String kana = req.getParameter("empKn");
		String mail = req.getParameter("mail");
		String department = req.getParameter("dep");

		String errer = "入力された情報で社員がみつかりませんでした";

		// 検索処理
		EmployeeDto emp = new EmployeeDto();
		if (!id.equals("")) {
			emp.setId_employee(Integer.parseInt(id));
		} else {
			emp.setId_employee(-1);
		}
		if (!name.equals("")) {
			emp.setNm_employee(name);
		} else {
			emp.setNm_employee("");
		}
		if (!kana.equals("")) {
			emp.setKn_employee(kana);
		} else {
			emp.setKn_employee("");
		}
		if (!mail.equals("")) {
			emp.setMail_address(mail);
		} else {
			emp.setMail_address("");
		}
		if (!department.equals("")) {
			emp.setId_department(Integer.parseInt(department));
		} else {
			emp.setId_department(-1);
		}

		EmployeeDao eDao = new EmployeeDao();
		emp.setPassword("");
		ArrayList<EmployeeDto> listAll = eDao.select(emp);

		if (listAll.size() > 0) {
			req.setAttribute("employeeList", listAll);
			req.getRequestDispatcher("list.jsp").forward(req, res);
		} else {
			req.setAttribute("errerMessage", errer);
			req.getRequestDispatcher("select.jsp").forward(req, res);
		}
	}
}