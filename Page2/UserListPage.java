package Page2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//���� auto_incremet�װ� ������ �ξ� ������ or for�� i������ �����!!
public class UserListPage {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public UserListPage() {
		try {
			String url = "jdbc:mysql://localhost:3306/STUDY_US";
			String id = "root";
			String pw = "111111";

			con = DriverManager.getConnection(url, id, pw);
			System.out.println("DB���� ����");

			stmt = con.createStatement();
			System.out.println("Statement��ü ���� ����");
			System.out.println();
			
			rs = stmt.executeQuery("select * from user"); // ��ȸ�� ������� ResultSet�� rs�� �����Ѵ�.
			System.out.print("==user ����Ʈ==");
			while (rs.next()) { // rs.next()�� ���� �������� ������ �� ������ true�� ��ȯ�ϰ�, Ŀ���� ��ĭ ������. �������� ������ false�� ��ȯ�Ѵ�.
				System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3)); // getInt(1)�� �÷���
																										// 1��° ���� Int������
																										// �����´�. /
																										// getString(2)��
																										// �÷��� 2��° ����
																										// String������
																										// �����´�.
			}

			rs.close();
			stmt.close();
			con.close(); // getString(2)�� �÷���
			// 2��° ���� String������
			// �����´�.
		} catch (SQLException e) {
			System.out.println("DB���� �����ϰų�, SQL���� Ʋ�Ƚ��ϴ�.");
			System.out.print("���� : " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		new UserListPage();
	}
}