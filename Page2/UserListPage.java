package Page2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

//���� auto_incremet�װ� ������ �ξ� ������ or for�� i������ �����!!
public class UserListPage extends JFrame{
	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	JPanel contentPane, panel, subtitle_panel, result_panel;
	JLabel title;
	
	public UserListPage() {
		super("���͵�ī�� ���� ���α׷� [STUDY US]");
	      init();
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
				JOptionPane.showMessageDialog(null, rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3), "��������Ʈ", JOptionPane.PLAIN_MESSAGE);
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

public final void init() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setResizable(false); //������ ���� �Ұ���
		setVisible(true); //���̰� ���� ����
		setBounds(100, 100, 1300, 800);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel(); //��ü �г�
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		subtitle_panel = new JPanel();
        subtitle_panel.setLayout(null);
        subtitle_panel.setForeground(new Color(211, 211, 211));
        subtitle_panel.setBorder(new LineBorder(new Color(211,183,219), 30, true));
        subtitle_panel.setBounds(0, 0, 1273, 52);
        panel.add(subtitle_panel);
        
        title = new JLabel("STUDY US");
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("Century Gothic", Font.PLAIN, 25));
        title.setBounds(22, 6, 440, 42);
        subtitle_panel.add(title);
	}	
	
	public static void main(String[] args) {
		new UserListPage();
	}
}