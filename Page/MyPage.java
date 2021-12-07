package Page;

import static Page.LoginPage.user;
import static Page.SelectSeatPage.room;
import static Page.SelectSeatPage.seatNum;
import static Page.SelectSeatPage.select_seat;
//import static Page2.SelectTimeTablePage.select_time;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Page.LoginPage.Listener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MyPage extends JFrame {
   private Connection con;
   private Statement stmt;
   private ResultSet rs;
   String setName, setSeat;


   JPanel contentPane, panel, subtitle_panel, result_panel, inlist_title_panel;
   JLabel title, inlist_title_text;
   String user_date, Remaining_time;
   int user_sec;

   public MyPage() {
      super("���͵�ī�� ���� ���α׷� [STUDY US]");
      init();
   }
   public final void init() {
	   
	   try {
	         
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         String url = "jdbc:mysql://localhost:3306/STUDY_US";
	         String id = "root";
	         String pw = "111111";
	         con = DriverManager.getConnection(url, id, pw);

	         stmt = con.createStatement();
	         System.out.println();

	         String sql = "select name, selected_time, selected_seat  from user where id='" + user.getId() + "'";
	         rs = stmt.executeQuery(sql);
	         
	     	while(rs.next()) {
	     		setName = rs.getString("name");
	     		setSeat = rs.getString("selected_seat");
	     		break;
			}
	        rs.close();
	        stmt.close();
	        con.close();

	      } catch (Exception ee) {
	         System.out.println("����");
	      }
	   

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

      /* ���� ������ �̹��� �г� */
      JPanel User_img_panel = new JPanel();
      User_img_panel.setBounds(404, 82, 80, 80);
      User_img_panel.setBackground(Color.white);
      User_panel.add(User_img_panel);

      JLabel user_greeting = new JLabel("�ȳ��ϼ���");
      user_greeting.setFont(new Font("���� ���", Font.PLAIN, 14));
      user_greeting.setBounds(493, 101, 134, 35);
      User_panel.add(user_greeting);

      JLabel username = new JLabel(setName);
      username.setHorizontalAlignment(JLabel.CENTER); // ���� ��� ����
      username.setFont(new Font("������� ExtraBold", Font.BOLD, 32));
      username.setBounds(450, 130, 179, 35);
      User_panel.add(username);

      JLabel username2 = new JLabel("     ��");
      username2.setHorizontalAlignment(JLabel.CENTER); // ���� ��� ����
      username2.setFont(new Font("����", Font.PLAIN, 20));
      username2.setBounds(500, 135, 179, 35);
      User_panel.add(username2);

      /* ��� ��ư */
      JButton btn_chkout = new JButton("���");
      btn_chkout.setForeground(Color.WHITE);
      btn_chkout.setFont(new Font("Dialog", Font.BOLD, 14));
      btn_chkout.setBorderPainted(false);	//�׵θ� ���ֱ�
      btn_chkout.setBackground(new Color(150, 195, 128));
      btn_chkout.setBounds(629, 140, 90, 27);
      User_panel.add(btn_chkout);
      
      btn_chkout.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
        	  
             new StartPage(); // JoinPage ����
             setVisible(false); // â �Ⱥ��̰� �ϱ�
          }   
       });

      /* �� �гι� */
      JPanel Selbar_panel = new JPanel();
      Selbar_panel.setBackground(new Color(223,223,223));
      Selbar_panel.setBounds(207, 190, 700, 1);
      User_panel.add(Selbar_panel);
      Selbar_panel.setLayout(null);

      JLabel selected_seat = new JLabel("�����Ͻ� �¼�");
      selected_seat.setFont(new Font("���� ���", Font.BOLD, 14));
      selected_seat.setBounds(355, 205, 120, 18);
      User_panel.add(selected_seat);
      
      
      JLabel Selseat_label = new JLabel(setSeat);
      Selseat_label.setHorizontalAlignment(SwingConstants.LEFT);
      Selseat_label.setFont(new Font("������� ExtraBold", Font.PLAIN, 17));
      Selseat_label.setBackground(Color.YELLOW);
      Selseat_label.setBounds(350, 279, 150, 15);
      User_panel.add(Selseat_label);
		
      JLabel remaining_time = new JLabel("���� �ð�");
      remaining_time.setFont(new Font("���� ���", Font.BOLD, 14));
      remaining_time.setBounds(648, 205, 120, 18);
      User_panel.add(remaining_time);
      
      try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/STUDY_US";
			String id = "root";
			String pw = "111111";
			Connection conn = DriverManager.getConnection(url, id, pw);

			String sql = "SELECT sec, start_date FROM user where id='"+user.getId()+"'";

			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(sql); //����� ���� ResultSet ���� �� ��� ���
			
			while(rs.next()) {
				user_date = rs.getString("start_date");
				user_sec = rs.getInt("sec");
				break;
			}
	       
	       /* ���������� ���� �ð��� �ٽ� ������ �ð� ���� ���ϱ� */
	       SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd/hh/mm/ss");
	       Date today = new Date();
	       today = date.parse(date.format(today));
	       Date user_day = date.parse(user_date);
	       
	       System.out.println(today);
		   System.out.println(user_day);
	       
	       int time_term_sec = (int) (user_sec - ((today.getTime() - user_day.getTime())/1000));
	       
	       int hour = time_term_sec/60/60;
	       int minute = (time_term_sec/60) - (hour*60);
	       Remaining_time = hour+"�ð� "+minute+"��";
	       System.out.println(Remaining_time);
	       
	       conn.close();
			
		}catch(Exception ee) {
			System.out.println("����");
		}
      
      JLabel T_remaining_label = new JLabel(Remaining_time);
      T_remaining_label.setHorizontalAlignment(SwingConstants.LEFT);
      T_remaining_label.setFont(new Font("������� ExtraBold", Font.PLAIN, 20));
      T_remaining_label.setBackground(Color.YELLOW);
      T_remaining_label.setBounds(632, 279, 150, 20);
      User_panel.add(T_remaining_label);

      /* �Ʒ� �гι� */
      JPanel Selbar_panel2 = new JPanel();
      Selbar_panel2.setLayout(null);
      Selbar_panel2.setBackground(new Color(223,223,223));
      Selbar_panel2.setBounds(207, 240, 700, 1);
      User_panel.add(Selbar_panel2);


      /* ���ǻ��� */
      JPanel Cautionbar_panel = new JPanel();
      Cautionbar_panel.setLayout(null);
      Cautionbar_panel.setBackground(new Color(223,223,223));
      Cautionbar_panel.setBounds(0, 405, 1109, 1);
      User_panel.add(Cautionbar_panel);

      JLabel caution_title = new JLabel("STUDY US �̿� �� ���ǻ���");
      caution_title.setHorizontalAlignment(SwingConstants.CENTER);
      caution_title.setForeground(Color.GRAY);
      caution_title.setFont(new Font("����", Font.BOLD, 15));
      caution_title.setBounds(13, 430, 224, 18);
      User_panel.add(caution_title);

      JLabel caution1 = new JLabel("ȣ�� �ȿ����� �������ּ���");
      caution1.setHorizontalAlignment(SwingConstants.CENTER);
      caution1.setForeground(Color.GRAY);
      caution1.setFont(new Font("����", Font.PLAIN, 11));
      caution1.setBounds(23, 447, 179, 18);

      JLabel caution2 = new JLabel("���� ��, �޴����� ������ or ���������� �ٲ��ֽð� ��ȭ�� ��ȭ�� �ﰡ�ּ���");
      caution2.setHorizontalAlignment(SwingConstants.CENTER);
      caution2.setForeground(Color.GRAY);
      caution2.setFont(new Font("����", Font.PLAIN, 11));
      caution2.setBounds(34, 459, 396, 18);
      User_panel.add(caution2);

      JLabel caution3 = new JLabel("��� �ÿ��� �� ��� ó���� ���ּ���");
      caution3.setHorizontalAlignment(SwingConstants.CENTER);
      caution3.setForeground(Color.GRAY);
      caution3.setFont(new Font("����", Font.PLAIN, 11));
      caution3.setBounds(12, 481, 246, 18);
      User_panel.add(caution3);

      JLabel caution4 = new JLabel("�ð��� ��Ȯ�� �����ֽñ� �ٶ��ϴ�");
      caution4.setHorizontalAlignment(SwingConstants.CENTER);
      caution4.setForeground(Color.GRAY);
      caution4.setFont(new Font("����", Font.PLAIN, 11));
      caution4.setBounds(27, 503, 209, 18);
      User_panel.add(caution4);

      JLabel caution5 = new JLabel("������ û���� ���� �ܺ� ���Ĺ��� ����/����� �ﰡ�ּ���");
      caution5.setHorizontalAlignment(SwingConstants.CENTER);
      caution5.setForeground(Color.GRAY);
      caution5.setFont(new Font("����", Font.PLAIN, 11));
      caution5.setBounds(31, 525, 319, 18);
      User_panel.add(caution5);

      JLabel caution6 = new JLabel("��Ʈ�� ��� �ÿ��� Ű���� Ŀ���� �� ������ּ���");
      caution6.setHorizontalAlignment(SwingConstants.CENTER);
      caution6.setForeground(Color.GRAY);
      caution6.setFont(new Font("����", Font.PLAIN, 11));
      caution6.setBounds(40, 547, 259, 18);
      User_panel.add(caution6);

      /* ȸ�� Ż�� ��ư */
      JButton btn_withdrawal = new JButton("ȸ�� Ż��");
      btn_withdrawal.setForeground(Color.WHITE);
      btn_withdrawal.setBorderPainted(false);	//�׵θ� ���ֱ�
      btn_withdrawal.setFont(new Font("Dialog", Font.BOLD, 14));
      btn_withdrawal.setBackground(new Color(209, 99, 99));
      btn_withdrawal.setBounds(950, 530, 123, 33);
      btn_withdrawal.addActionListener(new Listener(this));
      User_panel.add(btn_withdrawal);

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

      ImagePanel userimg = new ImagePanel(new ImageIcon("./img/my_icon.png").getImage());
      User_img_panel.add(userimg);

      /* �ڷ� ���� ��ư */
      ImageIcon backImg = new ImageIcon("./img/back_main_icon.png");
      JButton back = new JButton(backImg);
      back.setContentAreaFilled(false);
      back.setBorderPainted(false); // ��ư �׵θ� ��������
      back.setPreferredSize(new Dimension(30, 30)); // ��ư ũ�� ����
      back.setBounds(1225, 16, 20, 20);
      back.addActionListener(new BackActionListener());
      subtitle_panel.add(back);

   }

   class BackActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			new StartPage(); // StartPage ����
           setVisible(false);  // â �Ⱥ��̰� �ϱ� 
		}
		
	}
   
   /* Ż�� ��ư Ŭ�� �̺�Ʈ */
   class Listener implements ActionListener{

		JFrame frame;
		public Listener(JFrame f) {
			frame = f;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/STUDY_US";
				String id = "root";
				String pw = "111111";
				Connection conn = DriverManager.getConnection(url, id, pw);
				

				String sql = "delete from user where id=?";
				
				PreparedStatement pstmt = null;
				pstmt = conn.prepareStatement(sql.toString()); // sql�� ����
			    pstmt.setString(1, user.getId());
				int cnt = pstmt.executeUpdate();
				System.out.println(cnt);
			
			    
				String sql2 = "delete from seat where id=?";

				PreparedStatement pstmt2 = null;
				pstmt2 = conn.prepareStatement(sql2.toString());// sql�� ����
				pstmt2.setString(1, user.getId());
				int cnt2= pstmt2.executeUpdate();
				System.out.println(cnt2);
				
				conn.close();
				
				JOptionPane.showMessageDialog(frame, "Ż��Ǿ����ϴ�");
				
				new StartPage();
				setVisible(false);  // â �Ⱥ��̰� �ϱ� 
			    
				 
			}catch(Exception ee) {
				System.out.println("����");
			}
		};
		
   }
   public static void main(String[] args) {
      new MyPage();
   }
}