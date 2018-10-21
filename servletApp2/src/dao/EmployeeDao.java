package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.EmployeeDto;

public class EmployeeDao {
	// employeeテーブルのカラムと合わせたフィールド
	String name;
	EmployeeDto count;

	// 検索メソッド
	public ArrayList<EmployeeDto> select(EmployeeDto empInput) {
		ArrayList<EmployeeDto> array = new ArrayList<>();
		EmployeeDto emp = null;
		try {
			// JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Connectionの生成
			Connection con = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/rezodb?serverTimezone=UTC&useSSL=false" // データベース
							, "rezouser" // ユーザ
							, "Rezo_0000" // パスワード
			);

			// SQLの生成
			String sql = "SELECT * FROM employee";
			sql += " WHERE TRUE";
			if (empInput.getId_employee() >= 0) {
				sql += " AND id_employee = ?";
			}
			if (empInput.getNm_employee().length() > 0) {
				sql += " AND nm_employee LIKE ?";
			}
			if (empInput.getKn_employee().length() > 0) {
				sql += " AND kn_employee LIKE ?";
			}
			if (empInput.getMail_address().length() > 0) {
				sql += " AND mail_address LIKE ?";
			}
			if (empInput.getId_department() >= 0) {
				sql += " AND id_department = ?";
			}

			// PreparedStatementの生成
			PreparedStatement stmt = con.prepareStatement(sql);

			// パラメータ指定
			int index = 0;
			if (empInput.getId_employee() >= 0) {
				stmt.setInt(++index, empInput.getId_employee());
			}
			if (empInput.getNm_employee().length() > 0) {
				stmt.setString(++index, "%" + empInput.getNm_employee() + "%");
			}
			if (empInput.getKn_employee().length() > 0) {
				stmt.setString(++index, "%" + empInput.getKn_employee() + "%");
			}
			if (empInput.getMail_address().length() > 0) {
				stmt.setString(++index, "%" + empInput.getMail_address() + "%");
			}
			if (empInput.getId_department() >= 0) {
				stmt.setInt(++index, empInput.getId_department());
			}

			// SQLの実行
			ResultSet rs = stmt.executeQuery();

			// 実行結果の取得と表示
			while (rs.next()) {
				// Employeeインスタンスを作成
				emp = new EmployeeDto();
				// 値の取得
				emp.setId_employee(rs.getInt("id_employee"));
				emp.setNm_employee(rs.getString("nm_employee"));
				emp.setKn_employee(rs.getString("kn_employee"));
				emp.setMail_address(rs.getString("mail_address"));
				emp.setPassword(rs.getString("password"));
				emp.setId_department(rs.getInt("id_department"));
				// ArrayListに追加
				array.add(emp);
			}
			// ResultSet、PreparedStatement、Connectionの切断
			rs.close();
			stmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Employeeインスタンスをリターン
		return array;
	}


	// 削除する社員情報を検索するメソッド
	public int selectId(int id) {
		int ret = 0; // 検索結果が0か1以上かを判定するときに使用

		try {
			// JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Connectionの生成
			Connection con = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/rezodb?serverTimezone=UTC&useSSL=false" // データベース
							, "rezouser" // ユーザ
							, "Rezo_0000" // パスワード
			);

			// SQLの生成
			// 社員番号を検索
			String sql = "SELECT * FROM employee WHERE id_employee = ?";

			// PreparedStatementの生成
			PreparedStatement stmt = con.prepareStatement(sql);

			// 1個目の?をidに置き換える
			stmt.setInt(1, id);

			// SQLの実行
			ResultSet rs = stmt.executeQuery();

			// 実行結果の取得
			if (rs.next()) {
				ret = 1;
			}

			// ResultSet、PreparedStatement、Connectionの切断
			rs.close();
			stmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

	// 社員情報検索メソッド（ログイン時に使用）
	public EmployeeDto selectAllColumn(String mail) {

		// DTOクラスをインスタンス化して社員情報を格納する
		EmployeeDto dto = null;

		try {
			// JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Connectionの生成
			Connection con = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/rezodb?serverTimezone=UTC&useSSL=false" // データベース
							, "rezouser" // ユーザ
							, "Rezo_0000" // パスワード
			);

			// SQLの生成
			// メールアドレスを検索
			String sql = "SELECT * FROM employee WHERE mail_address = ?";

			// PreparedStatementの生成
			PreparedStatement stmt = con.prepareStatement(sql);

			// 1個目の?をmailに置き換える
			stmt.setString(1, mail);

			// SQLの実行
			ResultSet rs = stmt.executeQuery();

			// 実行結果の取得
			if (rs.next()) {
				// 値の取得
				dto = new EmployeeDto();
				dto.setId_employee(rs.getInt("id_employee"));
				dto.setNm_employee(rs.getString("nm_employee"));
				dto.setKn_employee(rs.getString("kn_employee"));
				dto.setMail_address(rs.getString("mail_address"));
				dto.setPassword(rs.getString("password"));
				dto.setId_department(rs.getInt("id_department"));
			}

			// ResultSet、PreparedStatement、Connectionの切断
			rs.close();
			stmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 取得した社員情報をリターン
		return dto;
	}


	// 更新する際の社員情報呼び出しメソッド
	public EmployeeDto selectUpdate(int id) {

		// DTOクラスをインスタンス化して社員情報を格納する
		EmployeeDto dto = null;

		try {
			// JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Connectionの生成
			Connection con = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/rezodb?serverTimezone=UTC&useSSL=false" // データベース
							, "rezouser" // ユーザ
							, "Rezo_0000" // パスワード
			);

			// SQLの生成
			// 社員番号を検索
			String sql = "SELECT * FROM employee WHERE id_employee = ?";

			// PreparedStatementの生成
			PreparedStatement stmt = con.prepareStatement(sql);

			// 1個目の?をidに置き換える
			stmt.setInt(1, id);

			// SQLの実行
			ResultSet rs = stmt.executeQuery();

			// 実行結果の取得
			if (rs.next()) {
				// 値の取得
				dto = new EmployeeDto();
				dto.setId_employee(rs.getInt("id_employee"));
				dto.setNm_employee(rs.getString("nm_employee"));
				dto.setKn_employee(rs.getString("kn_employee"));
				dto.setMail_address(rs.getString("mail_address"));
				dto.setPassword(rs.getString("password"));
				dto.setId_department(rs.getInt("id_department"));
				dto.setId_department(rs.getInt("id_department"));
			}

			// ResultSet、PreparedStatement、Connectionの切断
			rs.close();
			stmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 取得した社員情報をリターン
		return dto;
	}


	// 削除メソッド
	public void deleteAllColumn(int id) {

		try {
			// JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Connectionの生成
			Connection con = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/rezodb?serverTimezone=UTC&useSSL=false" // データベース
							, "rezouser" // ユーザ
							, "Rezo_0000" // パスワード
			);

			// SQLの生成
			// 社員番号を検索
			String sql = "DELETE FROM employee WHERE id_employee = ?";

			// PreparedStatementの生成
			PreparedStatement stmt = con.prepareStatement(sql);

			// 1個目の?をidに置き換える
			stmt.setInt(1, id);

			// SQLの実行
			int count = stmt.executeUpdate();
			System.out.println(count + "件削除されました");

			// PreparedStatement、Connectionの切断
			stmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	// 更新メソッド
	public void updateEmployee(int id, String name, String kana, String mail, String pass, int dep) {
		try {
			// JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Connectionの生成
			Connection con = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/rezodb?serverTimezone=UTC&useSSL=false" // データベース
							, "rezouser" // ユーザ
							, "Rezo_0000" // パスワード
			);

			// SQLの生成
			if (name != null) {
				String sql1 = "update employee set nm_employee=? where id_employee=" + id;
				PreparedStatement stmt = con.prepareStatement(sql1);
				stmt.setString(1, name);
				int count = stmt.executeUpdate();
				System.out.println("名前" + count);
				stmt.close();
			}
			if (kana != null) {
				String sql2 = "update employee set kn_employee=? where id_employee=" + id;
				PreparedStatement stmt = con.prepareStatement(sql2);
				stmt.setString(1, kana);
				int count2 = stmt.executeUpdate();
				System.out.println("かな" + count2);
				stmt.close();
			}
			if (mail != null) {
				String sql3 = "update employee set mail_address=? where id_employee=" + id;
				PreparedStatement stmt = con.prepareStatement(sql3);
				stmt.setString(1, mail);
				int count3 = stmt.executeUpdate();
				System.out.println("メール" + count3);
				stmt.close();
			}
			if (pass != null) {
				String sql4 = "update employee set password=? where id_employee=" + id;
				PreparedStatement stmt = con.prepareStatement(sql4);
				stmt.setString(1, pass);
				int count4 = stmt.executeUpdate();
				System.out.println("パス" + count4);
				stmt.close();
			}
			if (dep > 0) {
				String sql5 = "update employee set id_department=? where id_employee=" + id;
				PreparedStatement stmt = con.prepareStatement(sql5);
				stmt.setInt(1, dep);
				int count5 = stmt.executeUpdate();
				System.out.println("部署ID" + count5);
				stmt.close();
			}
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	// 追加メソッド
	public void InsertEmployee(String name, String kana, String email, String pass, int idno) {
		try {
			// JDBCドライバの読み込み
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Connectionの生成
			Connection con = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/rezodb?serverTimezone=UTC&useSSL=false" // データベース
							, "rezouser" // ユーザ
							, "Rezo_0000" // パスワード
			);

			// SQLの生成
			String sql = "INSERT INTO employee(nm_employee, kn_employee, mail_address, password, id_department) VALUES(?,?,?,?,?)";

			// PreparedStatementの生成
			PreparedStatement stmt = con.prepareStatement(sql);

			// パラメータ指定
			stmt.setString(1, name);
			stmt.setString(2, kana);
			stmt.setString(3, email);
			stmt.setString(4, pass);
			stmt.setInt(5, idno);

			// SQLの実行
			stmt.executeUpdate();

			// Statement、Connectionの切断
			stmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
