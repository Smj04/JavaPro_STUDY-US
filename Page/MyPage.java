package Page;

import static Page.SelectSeatPage.select_seat;
import static Page.SelectTimeTablePage.select_time;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

//���� auto_incremet�װ� ������ �ξ� ������ or for�� i������ �����!!
public class MyPage extends JFrame {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private ResultSet rs2;

	JPanel contentPane, panel, subtitle_panel, result_panel, inlist_title_panel;
	JLabel title, inlist_title_text;

	public MyPage() {
		super("���͵�ī�� ���� ���α׷� [STUDY US]");
		init();

	}

	public final void init() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); // ������ ���� �Ұ���
		setVisible(true); // ���̰� ���� ����
		setBounds(100, 100, 1300, 800);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel = new JPanel(); // ��ü �г�
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		subtitle_panel = new JPanel();
		subtitle_panel.setLayout(null);
		subtitle_panel.setForeground(Color.white);
		subtitle_panel.setBorder(new LineBorder(new Color(211, 183, 219), 30, true));
		subtitle_panel.setBounds(0, 0, 1273, 52);
		panel.add(subtitle_panel);

		title = new JLabel("STUDY US");
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		title.setBounds(22, 6, 440, 42);
		subtitle_panel.add(title);

		/* �� ���� ���� & �г� */
		JPanel User_title_panel = new JPanel();
		User_title_panel.setBounds(101, 80, 196, 39);
		User_title_panel.setLayout(null);
		User_title_panel.setBorder(new LineBorder(new Color(127, 114, 165), 30, true));
		panel.add(User_title_panel);

		JLabel User_title_text = new JLabel("�� ����");
		User_title_text.setFont(new Font("����", Font.PLAIN, 20));
		User_title_text.setHorizontalAlignment(SwingConstants.CENTER);
		User_title_text.setForeground(Color.WHITE);
		User_title_text.setBounds(26, 7, 139, 25);
		User_title_panel.add(User_title_text);

		/* �г� �׵θ� */
		JPanel User_panel = new JPanel();
		User_panel.setBackground(Color.WHITE);
		User_panel.setBorder(new LineBorder(new Color(127, 114, 165), 1, true));
		User_panel.setBounds(72, 96, 1109, 590);
		panel.add(User_panel);
		User_panel.setLayout(null);

		JPanel User_img_panel = new JPanel();
		User_img_panel.setBounds(404, 137, 80, 80);
		User_img_panel.setBackground(Color.white);
		User_panel.add(User_img_panel);

		/* ������ �ð��� ��� */
		JPanel SelTime_panel = new JPanel();
		SelTime_panel.setBorder(new LineBorder(new Color(255, 223, 132), 30, true));
		SelTime_panel.setBackground(Color.WHITE);
		SelTime_panel.setBounds(365, 273, 153, 33);
		User_panel.add(SelTime_panel);
		SelTime_panel.setLayout(null);

		JLabel Seltime_text = new JLabel("������ �ð���");
		Seltime_text.setForeground(Color.WHITE);
		Seltime_text.setBounds(3, 10, 146, 17);
		SelTime_panel.add(Seltime_text);
		Seltime_text.setHorizontalAlignment(SwingConstants.CENTER);
		Seltime_text.setFont(new Font("������� ExtraBold", Font.BOLD, 14));

		JLabel SetSeltime_label = new JLabel(select_time);
		SetSeltime_label.setHorizontalAlignment(SwingConstants.LEFT);
		SetSeltime_label.setFont(new Font("������� ExtraBold", Font.PLAIN, 20));
		SetSeltime_label.setBackground(Color.YELLOW);
		SetSeltime_label.setBounds(513, 273, 274, 33);
		User_panel.add(SetSeltime_label);

		/* ������ �¼� ��� */
		JPanel SelSeat_panel = new JPanel();
		SelSeat_panel.setBorder(new LineBorder(new Color(240, 128, 128), 30, true));
		SelSeat_panel.setBackground(Color.WHITE);
		SelSeat_panel.setBounds(365, 340, 153, 33);
		User_panel.add(SelSeat_panel);
		SelSeat_panel.setLayout(null);

		JLabel SelSeat_text = new JLabel("������ �¼�");
		SelSeat_text.setHorizontalAlignment(SwingConstants.CENTER);
		SelSeat_text.setForeground(Color.WHITE);
		SelSeat_text.setFont(new Font("������� ExtraBold", Font.BOLD, 14));
		SelSeat_text.setBounds(3, 9, 146, 17);
		SelSeat_panel.add(SelSeat_text);

		JLabel SelSeat_label = new JLabel(select_seat);
		SelSeat_label.setHorizontalAlignment(SwingConstants.LEFT);
		SelSeat_label.setFont(new Font("������� ExtraBold", Font.PLAIN, 20));
		SelSeat_label.setBackground(Color.YELLOW);
		SelSeat_label.setBounds(513, 340, 274, 33);
		User_panel.add(SelSeat_label);

		/* ���ǻ��� */

		JLabel caution1 = new JLabel("���͵�ī���̹Ƿ� �������ּ���.");
		caution1.setHorizontalAlignment(JLabel.CENTER);
		caution1.setFont(new Font("����", Font.PLAIN, 15));
		caution1.setForeground(Color.GRAY);
		caution1.setBounds(7, 489, 242, 31);
		User_panel.add(caution1);

		JLabel caution2 = new JLabel("�ǳ������� ������ ! ��Ʈ�� ���� �Ҹ� ���� ! �ڵ��� ������ �ʼ� !");
		caution2.setHorizontalAlignment(SwingConstants.CENTER);
		caution2.setForeground(Color.GRAY);
		caution2.setFont(new Font("����", Font.PLAIN, 15));
		caution2.setBounds(7, 528, 454, 31);
		User_panel.add(caution2);

		// �гο� �׸��� �÷��ִ� Ŭ����
		class ImagePanel extends JPanel {
			private Image img;

			public ImagePanel(Image img) {
				this.img = img;
				setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
				setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
				setLayout(null);
			}

			public void paintComponent(Graphics g) {
				g.drawImage(img, 3, 0, null);
			}
		}
		JPanel flower_img_panel = new JPanel();
		flower_img_panel.setBounds(130, 12, 40, 30);
		subtitle_panel.add(flower_img_panel);
		flower_img_panel.setLayout(null);

		ImagePanel flowerimg = new ImagePanel(new ImageIcon("./img/resizeflower.png").getImage());
		flower_img_panel.add(flowerimg);

		ImagePanel userimg = new ImagePanel(new ImageIcon("./img/resizeuser.png").getImage());
		User_img_panel.add(userimg);

		/* �ڷ� ���� ��ư */
		ImageIcon backImg = new ImageIcon("./img/back_main_icon.png");
		JButton back = new JButton(backImg);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false); // ��ư �׵θ� ��������
		back.setPreferredSize(new Dimension(30, 30)); // ��ư ũ�� ����
		back.setBounds(1225, 16, 20, 20);
		subtitle_panel.add(back);

		try {

			String url = "jdbc:mysql://localhost:3306/STUDY_US";
			String id = "root";
			String pw = "111111";
			Connection conn = DriverManager.getConnection(url, id, pw);

			String sql = "SELECT name, id, pass FROM user"; // ?

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql); // ����� ���� ResultSet ���� �� ��� ���

			while (rs.next()) {
				String user_name = rs.getString("name");
				String user_id = rs.getString("id");
				String user_pw = rs.getString("pass");

				JLabel username = new JLabel(user_name);
				username.setHorizontalAlignment(JLabel.CENTER); // ���� ��� ����
				username.setFont(new Font("����", Font.PLAIN, 30));
				username.setBounds(450, 190, 179, 35);
				User_panel.add(username);

				JLabel username2 = new JLabel("��");
				username2.setHorizontalAlignment(JLabel.CENTER); // ���� ��� ����
				username2.setFont(new Font("����", Font.PLAIN, 20));
				username2.setBounds(500, 190, 179, 35);
				User_panel.add(username2);
			}
//          int rowcount = 0;
//          int height_Default = 80;   //top����
//          int index = 0;
//          
//          rs2 = stmt.executeQuery("SELECT COUNT(*) FROM user");
//          if (rs2.next())
//             rowcount = rs2.getInt(1);
//          rs2.close();
//          
//          JLabel userList[] = new JLabel[rowcount];
//          for(int i = 0; i<rowcount; i++) {
//            userList[i] = new JLabel();
//             userList[i].setFont(new Font("����", Font.PLAIN, 20));
//             userList[i].setBounds(65, height_Default, 500, 100);
//             height_Default += 30;
//             list_panel.add(userList[i]);
//          }
//          System.out.println(String.valueOf(rowcount));
//
//          rs = stmt.executeQuery("select name from user"); // ��ȸ�� ������� ResultSet�� rs�� �����Ѵ�.
//          System.out.println("== mypage ����Ʈ==");
//          while (rs.next()) { 
//            System.out.println(rs.getString(1));
//            System.out.println(index); 
//            userList[index].setText(rs.getString(1));
//             list_panel.add(userList[index]);
//             index++;
//          }
//          rs.close();
//          stmt.close();
//          con.close(); 

		} catch (SQLException e) {
			System.out.println("DB���� �����ϰų�, SQL���� Ʋ�Ƚ��ϴ�.");
			System.out.print("���� : " + e.getMessage());
		}

	}

	public static void main(String[] args) {
		new MyPage();
	}
}