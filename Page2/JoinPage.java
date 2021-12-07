package Page2;


import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Page2.LoginPage.ImagePanel;
import Page2.LoginPage.Listener;

public class JoinPage extends JFrame {
	
	private JPanel contentPane, panel,  subtitle_panel, flower_img_panel, textID_panel, textPASS_panel, textNAME_panel;
	private JTextField field_id,  field_pass, field_name;
	private JLabel title;
	private JButton btn_Join;
	
	Font font_12 = new Font("Cafe24SsurroundAir", Font.BOLD, 12); 
	Font font_30 = new Font("Cafe24SsurroundAir", Font.PLAIN, 30);
	
	JoinPage(){
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
	    
		/* ���̵� �Է� */
	    field_id = new JTextField();
	    field_id.setBounds(520, 255, 360, 40);
	    field_id.setBackground(new Color(244,244,244));
	    field_id.setBorder(new LineBorder(new Color(244,244,244), 0, true));
	    panel.add(field_id);
	      
        textID_panel = new JPanel();
	    textID_panel.setBackground(new Color(255,255,255));
	    textID_panel.setBounds(516, 251, 377, 47);
	    textID_panel.setBorder(new LineBorder(new Color(244,244,244), 30, true));
	    panel.add(textID_panel);
	      
	    JLabel textID = new JLabel("ID");
	    textID.setFont(font_30);
	    textID.setForeground(new Color(127,114,165));
	    textID.setBounds(405, 251, 30, 47);
	    panel.add(textID);   
	        
	        
		/* ��й�ȣ �Է� */
	    field_pass = new JTextField();
	    field_pass.setBounds(520, 335, 360, 40);
	    field_pass.setBackground(new Color(244,244,244));
	    field_pass.setBorder(new LineBorder(new Color(244,244,244), 0, true));
	    panel.add(field_pass);
	      
	    textPASS_panel = new JPanel();
	    textPASS_panel.setBackground(new Color(255,255,255));
	    textPASS_panel.setBounds(516, 331, 377, 47);
	    textPASS_panel.setBorder(new LineBorder(new Color(244,244,244), 30, true));
	    panel.add(textPASS_panel);
	      
	    JLabel textPASS = new JLabel("PASSWORD");
	    textPASS.setFont(font_30);
	    textPASS.setForeground(new Color(127,114,165));
	    textPASS.setBounds(328, 331, 195, 47);
	    panel.add(textPASS);
	    
		
		/* �г��� �Է� */
	    field_name = new JTextField();
	    field_name.setBounds(520, 415, 360, 40);
	    field_name.setBackground(new Color(244,244,244));
	    field_name.setBorder(new LineBorder(new Color(244,244,244), 0, true));
	    panel.add(field_name);
	      
	    textNAME_panel = new JPanel();
	    textNAME_panel.setBackground(new Color(255,255,255));
	    textNAME_panel.setBounds(516, 411, 377, 47);
	    textNAME_panel.setBorder(new LineBorder(new Color(244,244,244), 30, true));
	    panel.add(textNAME_panel);
	      
	    JLabel textNAME = new JLabel("NAME");
		textNAME.setFont(font_30);
		textNAME.setForeground(new Color(127,114,165));
		textNAME.setBounds(370, 411, 100, 47);
		panel.add(textNAME);
		

		/* ȸ������ ��ư */
		btn_Join = new JButton("ȸ�� ����");
		btn_Join.setFont(font_12);
		btn_Join.setBackground(new Color(53,69,98));
		btn_Join.setBorderPainted(false);	//�׵θ� ���ֱ�
		btn_Join.setForeground(Color.WHITE);
		btn_Join.setBounds(788, 500, 105, 33);
		panel.add(btn_Join); 
		btn_Join.addActionListener(new Listener(this));
		
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
	class Listener implements ActionListener{
		JFrame frame;
		public Listener(JFrame f) {
			frame = f;
		}
		@Override
		public void actionPerformed(ActionEvent e) {

			String join_name = field_name.getText();
			String join_id = field_id.getText();
			String join_pass = field_pass.getText();
			
			
			if(join_name.equals("") || join_id.equals("") || join_pass.equals("")) {
				JOptionPane.showMessageDialog(frame, "���� ���� �Է����ּ���");
			}
			else { 
				try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						String url = "jdbc:mysql://localhost:3306/STUDY_US";
						String id = "root";
						String pw = "111111";
						Connection conn = DriverManager.getConnection(url, id, pw);
			
						String sql = "SELECT * FROM user";
						
						Statement stmt = conn.createStatement(); 
						ResultSet rs = stmt.executeQuery(sql); //����� ���� ResultSet ���� �� ��� ���
						
						//ResultSet�� ��� ����� ArrayList�� ���
						while(rs.next()) {
							if(join_id.equals(rs.getString("id"))) {
								JOptionPane.showMessageDialog(frame, "�̹� �����ϴ� ���̵� �Դϴ�");
							}
						}
						String sql2 =  "insert into user(name, id, pass, end_date) values('"+join_name+"', '"
								        +join_id+"', '"+join_pass+"', 0);"; 
						Statement stmt2 = conn.createStatement();
						stmt.executeUpdate(sql2);
								  
						// System.out.println("����");
						  
						JOptionPane.showMessageDialog(frame, "���ԵǾ����ϴ�");
						  
						new LoginPage(); // JoinPage ���� setVisible(false); // â �Ⱥ��̰� �ϱ�
						setVisible(false);  // â �Ⱥ��̰� �ϱ� 
					
						
				}catch(Exception ee) {
					System.out.println("����");
				}
				
			}
		}
	}
	public static void main(String[] args) {
		new JoinPage();
	}
}