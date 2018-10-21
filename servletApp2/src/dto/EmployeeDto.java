package dto;

public class EmployeeDto {

	//社員情報のフィールド
	private int id_employee;
	private String nm_employee;
	private String kn_employee;
	private String mail_address;
	private String password;
	private int id_department;


	//Getter,Setter
	public int getId_employee() {
		return id_employee;
	}

	public void setId_employee(int id_employee) {
		this.id_employee = id_employee;
	}

	public String getNm_employee() {
		return nm_employee;
	}

	public void setNm_employee(String nm_employee) {
		this.nm_employee = nm_employee;
	}

	public String getKn_employee() {
		return kn_employee;
	}

	public void setKn_employee(String kn_employee) {
		this.kn_employee = kn_employee;
	}

	public String getMail_address() {
		return mail_address;
	}

	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId_department() {
		return id_department;
	}

	public void setId_department(int id_department) {
		this.id_department = id_department;
	}

}
