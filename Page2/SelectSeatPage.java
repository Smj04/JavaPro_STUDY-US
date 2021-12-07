package Page2;

import static Page2.LoginPage.user;
import static Page2.SelectSeatPage.select_seat;
import static Page2.SelectTimeTablePage.select_time;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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

import Page2.JoinPage;
import Page2.LoginPage;
import Page2.StartPage;
import Page2.LoginPage.Listener;
import Page2.SelectTimeTablePage.ImagePanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Button;
import javax.swing.JTable;


public class SelectSeatPage extends JFrame {

	public static String select_seat;
	private JPanel contentPane, panel, panel2, seattable_panel, subtitle_panel, flower_img_panel;
	private JTextField field_pass;
	private JLabel textID, textPASS, title;
	private JTable table;

    Font font_20 = new Font("Cafe24SsurroundAir", Font.BOLD, 20);
    Font font_12 = new Font("Cafe24SsurroundAir", Font.BOLD, 12);
    Font font_14 = new Font("Cafe24SsurroundAir", Font.BOLD, 14);
    Font font_16 = new Font("Cafe24SsurroundAir", Font.BOLD, 16);
    
    String setting_room, setting_seatNum;
    String room, seatNum, addText;
   
    String[] num = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18"};
	JButton[] btn_private = new JButton[6];
	JButton[] btn_Metting = new JButton[2];
	JButton[] btn_seat = new JButton[18];
	
	SelectSeatPage(){		
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
	     
	     
	    /* '�¼� ����' ���� & ��� */
		JPanel seattable_title_panel = new JPanel();
		seattable_title_panel.setBounds(101, 80, 196, 39);
		seattable_title_panel.setLayout(null);
		seattable_title_panel.setBackground(new Color(255,255,255));
		seattable_title_panel.setBorder(new LineBorder(new Color(127,114,165), 30, true));
		panel.add(seattable_title_panel);
		
		JLabel seattable_title_text = new JLabel("�¼� ����");
		seattable_title_text.setHorizontalAlignment(SwingConstants.CENTER);
		seattable_title_text.setForeground(Color.WHITE);
		seattable_title_text.setFont(font_20);
		seattable_title_text.setBounds(31, 7, 139, 25);
		seattable_title_panel.add(seattable_title_text);
		
		seattable_panel = new JPanel();
		seattable_panel.setBackground(Color.WHITE);
		seattable_panel.setBorder(new LineBorder(new Color(127,114,165), 1, true));
		seattable_panel.setBounds(72, 96, 1109, 590);
		panel.add(seattable_panel);
		seattable_panel.setLayout(null);
		

		
	    /* ���ν� ǥ�� & ���� */
        JPanel mainromm_bar = new JPanel();
        mainromm_bar.setBackground(Color.BLACK);
        mainromm_bar.setBounds(247, 54, 78, 2);
        seattable_panel.add(mainromm_bar);
      
        JLabel label_mainRoom = new JLabel("���ν�");
        label_mainRoom.setHorizontalAlignment(SwingConstants.CENTER);
        label_mainRoom.setBounds(258, 62, 57, 15);
        seattable_panel.add(label_mainRoom);
	
	    SeatSetting();
	    

	    /* ȸ�ǽ� ǥ�� & ���� */
	    JPanel mettingromm_bar = new JPanel();
	    mettingromm_bar.setBackground(Color.BLACK);
	    mettingromm_bar.setBounds(836, 54, 78, 2);
	    seattable_panel.add(mettingromm_bar);
	      
	    JLabel label_meetingRoom = new JLabel("ȸ�ǽ�");
	    label_meetingRoom.setHorizontalAlignment(SwingConstants.CENTER);
        label_meetingRoom.setBounds(847, 62, 57, 15);
	    seattable_panel.add(label_meetingRoom); 
	      
	    MeetingSetting();
	      
	      
	    /* ���ν� ǥ�� & ���� */
	    JPanel privateromm_bar = new JPanel();
	    privateromm_bar.setBackground(Color.BLACK);
	    privateromm_bar.setBounds(884, 243, 78, 2);
	    seattable_panel.add(privateromm_bar);
	      
	    JLabel label_privateRoom = new JLabel("���ν�");
	    label_privateRoom.setHorizontalAlignment(SwingConstants.CENTER);
	    label_privateRoom.setBounds(895, 251, 57, 15);
	    seattable_panel.add(label_privateRoom);
	      
	    PrivateSetting();	  
	    
	    
		 SeatChk_Setting();
   
	    /* ���� �Ϸ� ��ư */
        JButton btn_Chk = new JButton("���� �Ϸ�");
		btn_Chk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				try {
					select_seat = room +" "+seatNum+addText;
					System.out.println(select_seat);
					
					System.out.println(select_time);				
					System.out.println(user.getId());
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3306/STUDY_US";
					String id = "root";
					String pw = "111111";
					Connection conn = DriverManager.getConnection(url, id, pw);
					
					Statement stmt = conn.createStatement(); 
					
					String sql =  "insert into seat(id, room, seat_num, use_chk) values('"+user.getId()+"', '"+room+"', "+Integer.parseInt(seatNum)+", 'true');"; 
					
					stmt.executeUpdate(sql);
					
					new SelectionInfo();
					setVisible(false);  // â �Ⱥ��̰� �ϱ� 
				
				}catch(Exception ee) {
					System.out.println("����");
				}
				 
			}
		});
		btn_Chk.setFont(font_12);
		btn_Chk.setForeground(Color.WHITE);
		btn_Chk.setBackground(Color.BLACK);
		btn_Chk.setBounds(933, 531, 105, 33);
		btn_Chk.setBackground(new Color(53,69,98)); 
		btn_Chk.setBorderPainted(false);
		seattable_panel.add(btn_Chk);      
		
	      
	}	
	public void PrivateSetting() {

		/*String num = "1";
		int width_Default = 966;
		int height_Default = 250;
		
		JLabel[] privateNum = new JLabel[6];
		for(int i=0; i<6; i++) {
			privateNum[i] = new JLabel(num);
			privateNum[i].setHorizontalAlignment(SwingConstants.LEFT);
			privateNum[i].setForeground(Color.WHITE);
			privateNum[i].setFont(new Font("����", Font.BOLD, 15));
		    seattable_panel.add(privateNum[i]);
		    
			if(i<3) {
				privateNum[i].setBounds(width_Default, height_Default, 19, 15);
				height_Default+=94;
			}
			else if(i==3) {
				privateNum[i].setBounds(876, 438, 19, 15);
			}
			else if(i==4) {
				privateNum[i].setBounds(783, 438, 19, 15);
			}
			else if(i==5) {
				privateNum[i].setBounds(692, 439, 19, 15);
			}
			int num_set = Integer.valueOf(num);
			num_set++;
			num = String.valueOf(num_set);
		}
		*/
		
		int height_Default = 242;

		for(int i=0; i<6; i++) {
			btn_private[i] = new JButton(num[i]+" ��밡��");
			btn_private[i].setBackground(new Color(145,223,144));
			btn_private[i].setForeground(Color.WHITE);
			btn_private[i].setBorderPainted(false);	
			btn_private[i].setFont(new Font("������� ExtraBold", Font.BOLD, 10));
	
			if(i<3) {
				btn_private[i].setBounds(956, height_Default, 82, 84);
				height_Default+=94;
			}
			else if(i==3) {
				btn_private[i].setBounds(866, 430, 82, 84);
			}
			else if(i==4) {
				btn_private[i].setBounds(773, 430, 82, 84);
			}
			else if(i==5) {
				btn_private[i].setBounds(682, 431, 82, 84);
			}
	        seattable_panel.add(btn_private[i]);
	        
	        
	        btn_private[i].addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 
		        	 JButton btn_num = (JButton)e.getSource();
		        	 String nums = btn_num.getText().substring(0, 2);
		        	 int seat_num = Integer.parseInt(nums.trim());
		           	 System.out.println(seat_num);
		        	 for(int i=0; i<6; i++) {
		        		 btn_private[i].setBackground(new Color(145,223,144));
		        		 for(int j=0; j<2; j++) btn_Metting[j].setBackground(new Color(145,223,144));
	        			 for(int k=0; k<18; k++) btn_seat[k].setBackground(new Color(145,223,144));
	        			 
		        		 if(i+1 == seat_num) {
		        			 
		        			 btn_private[i].setBackground(new Color(117,151,183));
		        			 btn_private[i].setText(String.valueOf(seat_num) + " ��밡��");
		        			 room = "���ν�";
		        			 seatNum = String.valueOf(seat_num);
		        			 addText = "����";
		        		 }

		        		 SeatChk_Setting();
		        		 
		        	 }
		         }
			});
		}
	
	}
	
	public void MeetingSetting() {
	
		
		  /*String num = "1";
		  int width_Defalut = 733;
		  
	      JLabel[] MettingSeatNum = new JLabel[2];
			for(int i=0; i<2; i++) {
				MettingSeatNum[i] = new JLabel(num);
				MettingSeatNum[i].setFont(new Font("����", Font.BOLD, 15));
				MettingSeatNum[i].setForeground(Color.WHITE);
				MettingSeatNum[i].setHorizontalAlignment(SwingConstants.LEFT);
				MettingSeatNum[i].setBounds(width_Defalut, 100, 25, 24);
				width_Defalut -= 164;
			      
				int num_set = Integer.valueOf(num);
				num_set++;
				num = String.valueOf(num_set);
				
		        seattable_panel.add(MettingSeatNum[i]);
			}
	      
	      */
		
	      int width_Defalut = 720;
	      for(int i=0; i<2; i++) {
	    	  btn_Metting[i] = new JButton(num[i]+" ��밡��");
	    	  btn_Metting[i].setBackground(new Color(145,223,144));
	    	  btn_Metting[i].setForeground(Color.WHITE);
	    	  btn_Metting[i].setBounds(width_Defalut, 92, 154, 131);
	    	  btn_Metting[i].setFont(new Font("������� ExtraBold", Font.BOLD, 12));
	    	  btn_Metting[i].setBorderPainted(false);	
		      seattable_panel.add(btn_Metting[i]);
	    	  width_Defalut += 164;
	    	  
	    	  btn_Metting[i].addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	 
			        	 JButton btn_num = (JButton)e.getSource();
			        	 String nums = btn_num.getText().substring(0, 2);
			        	 int seat_num = Integer.parseInt(nums.trim());
			        	 System.out.println(seat_num);
			        	 
			        	 for(int i=0; i<2; i++) {
			        		 
			        		 btn_Metting[i].setBackground(new Color(145,223,144));
			        		 for(int j=0; j<6; j++) btn_private[j].setBackground(new Color(145,223,144));
		        			 for(int k=0; k<18; k++) btn_seat[k].setBackground(new Color(145,223,144));
		        			 
			        		 if(i+1 == seat_num) {
			        			 btn_Metting[i].setBackground(new Color(117,151,183));
			        			 btn_Metting[i].setText(String.valueOf(seat_num) + " ��밡��");
			        			 
			        			 room = "ȸ�ǽ�";
			        			 seatNum = String.valueOf(seat_num);
			        			 addText = "����";
			        		 }

			        		 SeatChk_Setting();
			        	 }
			         }
				});
	      }
	 
	}
	
	public void SeatSetting() {
		
		for(int i=0; i<18; i++) {
			btn_seat[i] = new JButton(num[i] + " ��밡��");
			btn_seat[i].setBackground(new Color(145,223,144));
			btn_seat[i].setForeground(Color.WHITE);
			btn_seat[i].setBorderPainted(false);	
						
			btn_seat[i].addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 
		        	 JButton btn_num = (JButton)e.getSource();
		        	 String nums = btn_num.getText().substring(0, 2);
		        	 int seat_num = Integer.parseInt(nums.trim());
		        	 System.out.println(seat_num);
		        	
		        	 for(int i=0; i<18; i++) {
		        			
		        		 btn_seat[i].setBackground(new Color(145,223,144));
		        		 for(int j=0; j<2; j++) btn_Metting[j].setBackground(new Color(145,223,144));
	        			 for(int k=0; k<6; k++) btn_private[k].setBackground(new Color(145,223,144));
	        			 
		        		 if(i+1 == seat_num) {
		        			 btn_seat[i].setBackground(new Color(117,151,183));
		 	 				 btn_seat[i].setText(String.valueOf(seat_num) + " ��밡��");
		 	 				 
		 	 				 room = "���ν�";
		        			 seatNum = String.valueOf(seat_num);
		        			 addText = "�� �¼�";
		        		 }

		        		 SeatChk_Setting();
		        	 }
		         }
			});
		}
	 			 	 
		int height_Default = 92;
		for(int i=0; i<6; i++) {			
			btn_seat[i].setBounds(91, height_Default, 127, 62);
			height_Default+=72;
		}
		
		height_Default = 92;
		for(int i=6; i<12; i++) {
		    btn_seat[i].setBounds(230, height_Default, 127, 62);		
			height_Default+=72;
		}
		
		height_Default = 92;
		for(int i=12; i<18; i++) {
		    btn_seat[i].setBounds(369, height_Default, 127, 62);
			height_Default+=72;
		}
		
		for(int i=0; i<18; i++) {	
			seattable_panel.add(btn_seat[i]);
		}
	
	}
   public static void main(String[] args) {
      new SelectSeatPage();
   }
   
   
   public void SeatChk_Setting() {
	   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/STUDY_US";
			String id = "root";
			String pw = "111111";
			Connection conn = DriverManager.getConnection(url, id, pw);

			String sql = "SELECT room, seat_num FROM seat";

			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(sql); //����� ���� ResultSet ���� �� ��� ���
			
			while(rs.next()) {
				setting_room = rs.getString("room");
				setting_seatNum = rs.getString("seat_num");
				System.out.println(setting_room + " " + setting_seatNum);
				
				switch(setting_room) {
				case "���ν�" : {
					btn_seat[Integer.parseInt(setting_seatNum)-1].setBackground(new Color(218,76,76));
					btn_seat[Integer.parseInt(setting_seatNum)-1].setText(setting_seatNum+" �����");
					break;
				}
				case "���ν�" : {
					btn_private[Integer.parseInt(setting_seatNum)-1].setBackground(new Color(218,76,76));
					btn_private[Integer.parseInt(setting_seatNum)-1].setText(setting_seatNum+" �����");
					break;
				}
				case "ȸ�ǽ�" : 
					btn_Metting[Integer.parseInt(setting_seatNum)-1].setBackground(new Color(218,76,76));
					btn_Metting[Integer.parseInt(setting_seatNum)-1].setText(setting_seatNum+" �����");
					break;
				}
			}
		}catch(Exception ee) {
			System.out.println("����");
		}
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
   
   
}