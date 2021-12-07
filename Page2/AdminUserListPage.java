package Page2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Page2.LoginPage.ImagePanel;

//���� auto_incremet�װ� ������ �ξ� ������ or for�� i������ �����!!
public class AdminUserListPage extends JFrame {
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private ResultSet rs2;

	JPanel contentPane, panel, subtitle_panel, result_panel, inlist_title_panel, flower_img_panel;
	JLabel title, inlist_title_text;

	public AdminUserListPage() {
		super("���͵�ī�� ���� ���α׷� [STUDY US]");
		init();

		/* ����Ʈ Ÿ��Ʋ ���� & �г� */
		JPanel list_panel = new JPanel();
		list_panel.setBounds(130, 220, 1000, 400);
		panel.add(list_panel);
		list_panel.setBackground(new Color(246, 247, 248));
		list_panel.setLayout(null);

		JLabel list_title = new JLabel("�� ���� ����Ʈ");
		list_title.setHorizontalAlignment(JLabel.CENTER); // ���� ��� ����
		list_title.setFont(new Font("����", Font.BOLD, 20));
		list_title.setBounds(550, 100, 180, 24);
		panel.add(list_title);

		try {
			String url = "jdbc:mysql://localhost:3306/STUDY_US";
			String id = "root";
			String pw = "111111";

			con = DriverManager.getConnection(url, id, pw);
			System.out.println("DB���� ����");

			stmt = con.createStatement();
			System.out.println("Statement��ü ���� ����");
			System.out.println();

			int rowcount = 0;
			int height_Default = 20; // top����
			int index = 0;

			rs2 = stmt.executeQuery("SELECT COUNT(*) FROM user");
			if (rs2.next())
				rowcount = rs2.getInt(1);
			rs2.close();

			JLabel userList[] = new JLabel[rowcount];
			for (int i = 0; i < rowcount; i++) {
				userList[i] = new JLabel();
				userList[i].setFont(new Font("����", Font.PLAIN, 15));
				userList[i].setBounds(55, height_Default, 900, 20);
				height_Default += 30;
				list_panel.add(userList[i]);
			}
			System.out.println(String.valueOf(rowcount));

			rs = stmt.executeQuery("select name, id, selected_seat, selected_time from user;"); // ��ȸ�� ������� ResultSet��
																								// rs�� �����Ѵ�.
			System.out.println("==user ����Ʈ==");
			while (rs.next()) { // rs.next()�� ���� �������� ������ �� ������ true�� ��ȯ�ϰ�, Ŀ���� ��ĭ ������. �������� ������ false�� ��ȯ�Ѵ�.
				System.out.println(
						rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4)); // getInt(1)��
																														// �÷���
				System.out.println(index);
				userList[index].setText(rs.getString(1) + "                   " + rs.getString(2)
						+ "                   " + rs.getString(3) + "                   " + rs.getString(4));
				list_panel.add(userList[index]);
				index++;
			}
			rs.close();
			stmt.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("DB���� �����ϰų�, SQL���� Ʋ�Ƚ��ϴ�.");
			System.out.print("���� : " + e.getMessage());
		}
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

		/* ��Ҹ� ���� ���� ���� panel */
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		/* ��� �� panel */
		subtitle_panel = new JPanel();
		subtitle_panel.setLayout(null);
		subtitle_panel.setBackground(new Color(255, 255, 255));
		subtitle_panel.setForeground(new Color(211, 211, 211));
		subtitle_panel.setBorder(new LineBorder(new Color(0, 0, 0), 30, true));
		subtitle_panel.setBounds(0, 0, 1274, 52);
		panel.add(subtitle_panel);

		/* ��� �� ���� */
		title = new JLabel("STUDY US");
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		title.setBounds(22, 6, 440, 42);
		subtitle_panel.add(title);

		/* ��� �� �� �̹��� */
		flower_img_panel = new JPanel();
		flower_img_panel.setBounds(130, 12, 40, 30);
		subtitle_panel.add(flower_img_panel);
		flower_img_panel.setLayout(null);

		ImagePanel flowerimg = new ImagePanel(new ImageIcon("./img/resizeflower.png").getImage());
		flower_img_panel.add(flowerimg);

		/* ����Ʈ ��� bar */
		JPanel inlist_title_panel = new JPanel();
		inlist_title_panel.setBounds(130, 150, 1000, 60);
		panel.add(inlist_title_panel);
		inlist_title_panel.setLayout(null);
		inlist_title_panel.setBackground(new Color(215, 176, 212));

		JLabel inlist_title_textName = new JLabel("�̸�");
		inlist_title_textName.setFont(new Font("����", Font.PLAIN, 16));
		inlist_title_textName.setForeground(Color.WHITE);
		inlist_title_textName.setBounds(65, 12, 121, 35);
		inlist_title_panel.add(inlist_title_textName);

		JLabel inlist_title_textId = new JLabel("���̵�");
		inlist_title_textId.setForeground(Color.WHITE);
		inlist_title_textId.setFont(new Font("����", Font.PLAIN, 16));
		inlist_title_textId.setBounds(182, 12, 121, 35);
		inlist_title_panel.add(inlist_title_textId);

		JLabel inlist_title_selseat = new JLabel("������ �¼�");
		inlist_title_selseat.setForeground(Color.WHITE);
		inlist_title_selseat.setFont(new Font("����", Font.PLAIN, 16));
		inlist_title_selseat.setBounds(305, 12, 155, 35);
		inlist_title_panel.add(inlist_title_selseat);

		JLabel inlist_title_seltime = new JLabel("������ �ð�");
		inlist_title_seltime.setForeground(Color.WHITE);
		inlist_title_seltime.setFont(new Font("����", Font.PLAIN, 16));
		inlist_title_seltime.setBounds(462, 12, 155, 35);
		inlist_title_panel.add(inlist_title_seltime);

		/* ����ǥ ��ư */
		JButton btn_Price = new JButton("���ư���");
		btn_Price.setForeground(Color.WHITE);
		btn_Price.setFont(new Font("����", Font.PLAIN, 12));
		btn_Price.setBorderPainted(false); // �׵θ� ���ֱ�
		btn_Price.setBounds(902, 650, 105, 33);
		btn_Price.setBackground(new Color(53, 69, 98));
		panel.add(btn_Price);

		btn_Price.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StartPage(); // JoinPage ����
				setVisible(false); // â �Ⱥ��̰� �ϱ�
			}
		});

		/* ���� �Ϸ� ��ư */
		JButton btn_Chk = new JButton("�¼� ��Ȳ");
		btn_Chk.setForeground(Color.WHITE);
		btn_Chk.setFont(new Font("����", Font.PLAIN, 12));
		btn_Chk.setBorderPainted(false); // �׵θ� ���ֱ�
		btn_Chk.setBounds(1020, 650, 105, 33);
		btn_Chk.setBackground(new Color(53, 69, 98));
		panel.add(btn_Chk);

		btn_Chk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminShowSeat();
				setVisible(false);
			}
		});

	}

	/* �гο� �׸� �ø��� Ŭ���� (�� �̹���) */
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

	public static void main(String[] args) {
		new AdminUserListPage();
	}
}