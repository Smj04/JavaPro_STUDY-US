package mysql_Studyus_table;
import java.sql.*;

public class userTable {

	public static void main(String[] args) {
		try {
			// Class.forName("org.git.mm.mysql.Driver");// 1. jdbc ����̺� ����
			Class.forName("com.mysql.cj.jdbc.Driver"); // �� ������ ��
			System.out.println("����̺� ������ �ߵ�");

			String url = "jdbc:mysql://localhost:3306/STUDY_US";
			String id = "root";
			String pw = "111111";
		
	
			Connection conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB ���Ἲ��");

			String sql = "CREATE TABLE USER(";
			sql+="name varchar(10), ";
			sql+="id varchar(20) primary key, ";
			sql+="pass varchar(20),";
			sql+="regular_chk varchar(5) );";
			
			Statement stmt = conn.createStatement(); 
			
			stmt.execute(sql);
	
			System.out.println("���̺� ����!");
			
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
			
			// ���� 1���� ����, 2�� �̻� �õ����� �̹� ���̺��� �����Ͽ� ���а� ���*
			
		}catch(ClassNotFoundException e) {
			System.out.println("�ε�����");
			
		}catch(SQLException e) {
			System.out.println("���̺� ���� ����");
		}
	}
}

