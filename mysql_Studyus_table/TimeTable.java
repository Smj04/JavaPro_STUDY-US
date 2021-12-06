package mysql_Studyus_table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TimeTable {
	
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

			String sql = "CREATE TABLE Time(";
			sql+="subscribe varchar(10), ";
			sql+="period varchar(6), ";
			sql+="price varchar(9),";
			sql+="sec int);";
			
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
