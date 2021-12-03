package Page2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Page2.JoinPage.Listener;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class LoginPage  extends JFrame {
   
   private JPanel contentPane, panel, subtitle_panel;
   private JTextField field_id,  field_pass;
   private JLabel textID, textPASS, title;
   private JButton btn_Login;
   
   Font font_10 = new Font("Cafe24SsurroundAir", Font.PLAIN, 10);
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
      
      panel = new JPanel();
      panel.setBackground(Color.WHITE);
      contentPane.add(panel, BorderLayout.CENTER);
      panel.setLayout(null);
      
      field_id = new JTextField();
       field_id.setBackground(SystemColor.inactiveCaptionBorder);
       field_id.setBounds(534, 331, 357, 47);
       panel.add(field_id);
       field_id.setColumns(10);
      
       field_pass = new JTextField();
       field_pass = new JTextField();
       field_pass.setBackground(SystemColor.inactiveCaptionBorder);
       field_pass.setColumns(10);
       field_pass.setBounds(534, 401, 357, 47);
       panel.add(field_pass);
      
       	JLabel textID = new JLabel("ID");
         textID.setFont(font_30);
         textID.setForeground(new Color(211,183,219));
         textID.setBounds(481, 331, 30, 47);
         panel.add(textID);
      
         JLabel textPASS = new JLabel("PASSWORD");
         textPASS.setFont(font_30);
         textPASS.setForeground(new Color(211,183,219));
         textPASS.setBounds(348, 401, 195, 47);
         panel.add(textPASS);
      
         btn_Login = new JButton("�α���");
         btn_Login.setForeground(Color.WHITE);
         btn_Login.setFont(font_10);
         btn_Login.setBackground(new Color(211,183,219));
         btn_Login.setBorderPainted(false);	//�׵θ� ���ֱ�
         btn_Login.setBounds(794, 493, 97, 28);
         btn_Login.setBorder(new LineBorder(new Color(0, 0, 0), 0, true)); 
         panel.add(btn_Login);         
         btn_Login.addActionListener(new Listener(this));
         
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
         // btn_Login.addActionListener(new Listener(this));
         
   }
   
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
				new AdminShowSeat(); // SelectTimeTablePage ����
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
							JOptionPane.showMessageDialog(frame, user_name+"��, �ȳ��ϼ���!"); 
							new SelectTimeTablePage(); // SelectTimeTablePage ����
				            setVisible(false);  // â �Ⱥ��̰� �ϱ� 
				            togle = true;
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
