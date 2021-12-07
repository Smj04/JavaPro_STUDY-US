package Page;

import static Page.LoginPage.user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Page.JoinPage.BackActionListener;
import Page.JoinPage.Listener;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class LoginPage extends JFrame {
   
   public static User user;
   private JPanel contentPane, panel, subtitle_panel, flower_img_panel, textID_panel, textPASS_panel;
   private JTextField field_id,  field_pass;
   private JLabel textID, textPASS, title;
   private JButton btn_Login;
   String user_date ="";
   int user_select_sec;
   
   Font font_12 = new Font("Cafe24SsurroundAir", Font.BOLD, 12); 
   Font font_30 = new Font("Cafe24SsurroundAir", Font.PLAIN, 30);
   
   LoginPage(){
      super("���͵�ī�� ���� ���α׷� [STUDY US]");
      init();
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
      
      /* ��Ҹ� ���� ���� ���� panel */
      panel = new JPanel();
      panel.setBackground(Color.WHITE);
      contentPane.add(panel, BorderLayout.CENTER);
      panel.setLayout(null);
      
      /* ��� �� panel */
      subtitle_panel = new JPanel();
      subtitle_panel.setLayout(null);
      subtitle_panel.setBackground(new Color(255,255,255));
      subtitle_panel.setForeground(new Color(211, 211, 211));
      subtitle_panel.setBorder(new LineBorder(new Color(215,176,212), 30, true));
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
      
      /* �ڷ� ���� ��ư */
	   ImageIcon backImg = new ImageIcon("./img/back_main_icon.png");
	   JButton back = new JButton(backImg);
	   back.setBackground(new Color(215,176,212));
	   back.setBorderPainted(false); // ��ư �׵θ� ���ֱ�
	   back.setPreferredSize(new Dimension(30, 30)); 
	   back.setBounds(1225, 16, 20, 20);
	   back.addActionListener(new BackActionListener());
	   subtitle_panel.add(back);
      
      /* ���̵� �Է� �κ� */
      field_id = new JTextField();
      field_id.setBounds(520, 275, 360, 40);
      field_id.setBackground(new Color(244,244,244));
      field_id.setBorder(new LineBorder(new Color(244,244,244), 0, true));
      panel.add(field_id);
      
      textID_panel = new JPanel();
      textID_panel.setBackground(new Color(255,255,255));
      textID_panel.setBounds(516, 271, 377, 47);
      textID_panel.setBorder(new LineBorder(new Color(244,244,244), 30, true));
      panel.add(textID_panel);
      
      JLabel textID = new JLabel("ID");
      textID.setFont(font_30);
      textID.setForeground(new Color(127,114,165));
	  textID.setBounds(405, 271, 30, 47);
      panel.add(textID);   
      
       
      /* ��й�ȣ �Է� �κ� */
      field_pass = new JTextField();
      field_pass.setBounds(520, 355, 360, 40);
      field_pass.setBackground(new Color(244,244,244));
      field_pass.setBorder(new LineBorder(new Color(244,244,244), 0, true));
      panel.add(field_pass);
      
      textPASS_panel = new JPanel();
      textPASS_panel.setBackground(new Color(255,255,255));
      textPASS_panel.setBounds(514, 351, 377, 47);
      textPASS_panel.setBorder(new LineBorder(new Color(244,244,244), 30, true));
      panel.add(textPASS_panel);
      
      JLabel textPASS = new JLabel("PASSWORD");
      textPASS.setFont(font_30);
      textPASS.setForeground(new Color(127,114,165));
      textPASS.setBounds(328, 351, 195, 47);
      panel.add(textPASS);
      

      /* �α��� ��ư */
      btn_Login = new JButton("�α���");
      btn_Login.setForeground(Color.WHITE);
      btn_Login.setFont(font_12);
      btn_Login.setBorderPainted(false);	//�׵θ� ���ֱ�
      btn_Login.setBounds(783, 440, 105, 33);
      btn_Login.setBackground(new Color(53,69,98));       
      btn_Login.addActionListener(new Listener(this));
      panel.add(btn_Login);  
      
   }
   
   public boolean ChkTimeOver() {
	   String login_id = field_id.getText();
	   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/STUDY_US";
			String id = "root";
			String pw = "111111";
			Connection conn = DriverManager.getConnection(url, id, pw);

			String sql = "SELECT * FROM user where id='"+login_id+"'";

			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(sql); //����� ���� ResultSet ���� �� ��� ���
			
			while(rs.next()) {
				user_date = rs.getString("start_date");
				break;
			}
	       
	       /* ���������� ���� �ð��� �ٽ� ������ �ð� ���� ���ϱ� */
	       SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd/hh/mm/ss");
	       Date today = new Date();
	       today = date.parse(date.format(today));
	       Date user_day = date.parse(user_date);
	       
	       System.out.println(today);
		   System.out.println(user_day);
	       
	       int time_term = (int) ((today.getTime() - user_day.getTime())/1000);
	       System.out.println(time_term);
	       
	       
	       /* ���� �ð��� ������ �ð�(��)�� �Ѿ����� üũ */
	       String sql2 = "SELECT sec FROM user where id='"+login_id+"'";

			Statement stmt2 = conn.createStatement(); 
			ResultSet rs2 = stmt2.executeQuery(sql2); //����� ���� ResultSet ���� �� ��� ���
			
			while(rs2.next()) {
				user_select_sec = rs.getInt("sec");
				break;
			}
			System.out.println(user_select_sec);
			

			if(user_select_sec > time_term) {
				return false;
				 
			}
			else {    // ������ �ð��� ���� ����ߴٸ�
				String sql3 = "update user set selected_time=?, sec=?, selected_seat=?, start_date=? where id=?";
				 PreparedStatement pstmts = null;
				 
				 pstmts = conn.prepareStatement(sql3.toString());
				 pstmts.setString(1, "NULL");
			 	 pstmts.setInt(2, 0);
			 	 pstmts.setString(3, "NULL");
			 	 pstmts.setString(4, "NULL");
			 	 pstmts.setString(5, user.getId());
				 
				 System.out.println("�ð��� ���� �̿��ϼ̽��ϴ�");
				 int cnts = pstmts.executeUpdate();
					
				 String sql4 = "delete from seat where id = '"+user.getId()+"'";
				 Statement stmt4 = conn.createStatement(); 
				 stmt.execute(sql4);
				 
				 System.out.println("����");
				 
			}
	       // conn.close();
			
		}catch(Exception ee) {
			System.out.println("����");
		}

		return true;
	   
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
   
   class BackActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			new StartPage(); // StartPage ����
           setVisible(false);  // â �Ⱥ��̰� �ϱ� 
		}
		
	}
   
   /* �α��� ��ư Ŭ�� �̺�Ʈ */
   class Listener implements ActionListener{
	   
	   
		JFrame frame;
		public Listener(JFrame f) {
			frame = f;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
		
			boolean togle = false;
			String login_id = field_id.getText();
			String login_pass = field_pass.getText();
			
			if(login_id.equals("") && login_pass.equals("")) {				
				JOptionPane.showMessageDialog(frame, "���� �Է����ּ���"); 
			}			
			else if(login_id.equals("studyus") && login_pass.equals("admin")) {
	            JOptionPane.showMessageDialog(frame, "������ ���� �α��� �մϴ�"); 
	            new AdminUserListPage(); // SelectTimeTablePage ����
	               setVisible(false);  // â �Ⱥ��̰� �ϱ� 
	        }
			else {			
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3306/STUDY_US";
					String id = "root";
					String pw = "111111";
					Connection conn = DriverManager.getConnection(url, id, pw);
	
					String sql = "SELECT name, id, pass FROM user";
	
					Statement stmt = conn.createStatement(); 
					ResultSet rs = stmt.executeQuery(sql); //����� ���� ResultSet ���� �� ��� ���
					
					while(rs.next()) {
						String user_name = rs.getString("name");
						String user_id = rs.getString("id");
						String user_pw = rs.getString("pass");
						
						if(user_id.equals(login_id) && user_pw.equals(login_pass)) {	
							
							user = new User(user_name, user_id, user_pw);
							JOptionPane.showMessageDialog(frame, user_name+"��, �ȳ��ϼ���!"); 
							
							if(ChkTimeOver() == true) {
								new SelectTimeTablePage(); // SelectTimeTablePage ����
					            setVisible(false);  // â �Ⱥ��̰� �ϱ� 
					            togle = true;
							}
							else {
								new MyPage(); 
					            setVisible(false);  // â �Ⱥ��̰� �ϱ� 
					            togle = true;
							}
							
							
						}
					}
					if(!togle) JOptionPane.showMessageDialog(frame, "���̵� Ȥ�� ��й�ȣ�� ���� �ʽ��ϴ�"); 					
					/*
					// [Table�� ����� ������ ��� �׽�Ʈ] 
					  
					String sql = "SELECT * FROM user";
	
					Statement stmt = conn.createStatement(); 
					ResultSet rs = stmt.executeQuery(sql); //����� ���� ResultSet ���� �� ��� ���
					
					//����� ���� ArrayList���� 
					ArrayList<User> userlist = new ArrayList<User>(); 
					
					//ResultSet�� ��� ����� ArrayList�� ���
					while(rs.next()) {
						User user = new User();
						user.setName(rs.getString("name"));
						user.setId(rs.getString("id"));
						user.setPass(rs.getString("pass"));
						user.setRegular_chk(rs.getString("regular_chk"));
						userlist.add(user);
					}
					
					//����� ���
					for(int i=0; i<userlist.size(); i++) {
						System.out.println("�̸�:"+userlist.get(i).getName());
						System.out.println("���̵�:"+userlist.get(i).getId());
						System.out.println("��й�ȣ:"+userlist.get(i).getPass());
						System.out.println("����üũ:"+userlist.get(i).getRegular_chk());
					}
					*/						
				}catch(Exception ee) {
					System.out.println("����");
				}
			 }
		}
  }
   public static void main(String[] args) {
      new LoginPage();
   }

}