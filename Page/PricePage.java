package Page;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Page.LoginPage.ImagePanel;
import Page.LoginPage.Listener;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PricePage extends JFrame {
	
	private JPanel contentPane, panel,  subtitle_panel, flower_img_panel, textID_panel, textPASS_panel, textNAME_panel;
	private JTextField field_id,  field_pass, field_name;
	private JLabel title;
	private JButton btn_Join;
   

   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               PricePage frame = new PricePage();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   public PricePage() {
	   super("���͵�ī�� ���� ���α׷� [STUDY US]"); 
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
	   back.addActionListener(new Listener());
	   subtitle_panel.add(back);
	   
	    
	   /* ���� �ȳ� ǥ �г� & ���� */
	   JPanel pricetitle_panel = new JPanel();
	   pricetitle_panel.setBackground(Color.white);
	   pricetitle_panel.setBorder(new LineBorder(new Color(127,114,165), 30, true));
	   pricetitle_panel.setBounds(156, 62, 196, 39);
	   panel.add(pricetitle_panel);
	   pricetitle_panel.setLayout(null);
	  
	   JLabel pricetitle_text = new JLabel("���� �ȳ�");
	   pricetitle_text.setFont(new Font("����", Font.PLAIN, 20));
	   pricetitle_text.setForeground(Color.WHITE);
	   pricetitle_text.setBounds(56, 8, 105, 25);
	   pricetitle_panel.add(pricetitle_text);
      
	   /* ���� �ȳ� ǥ �׵θ� */
       JPanel price_panel = new JPanel(); 
       price_panel.setBounds(30, 78, 449, 657);
       panel.add(price_panel);
       price_panel.setBackground(Color.white);
       price_panel.setBorder(new LineBorder(new Color(127,114,165), 1, true));
       price_panel.setLayout(null);
       
       
       
       /* �̿�� ���� */
       JPanel coupon_panel[] = new JPanel[4];
       JLabel coupon_text[] = new JLabel[4];
       int coupon_P_height = 60;
       String coupon_text_name[] = {"���� �̿��" , "�Ⱓ��", "���ױ�", "�� ����"};
       
       for(int i=0; i<4; i++) {
           /* �̿�� �̸� ��� �г� */
     	  coupon_panel[i] = new JPanel();
     	  coupon_panel[i].setBorder(null);
     	  coupon_panel[i].setBackground(new Color(255, 183, 183));
     	  coupon_panel[i].setLayout(null);
     	  coupon_panel[i].setBounds(45, coupon_P_height, 110, 30);
     	  coupon_P_height += 140;
     	  price_panel.add(coupon_panel[i]);
     	  
     	  /* �̿�� �̸� �ؽ�Ʈ */
     	  coupon_text[i] = new JLabel(coupon_text_name[i]);
     	  coupon_text[i].setFont(new Font("����", Font.PLAIN, 15));
     	  coupon_text[i].setForeground(Color.white);
     	  coupon_panel[i].add(coupon_text[i]);
       }
       coupon_text[0].setBounds(18, 5, 93, 25);
       coupon_text[1].setBounds(34, 5, 43, 25);
       coupon_text[2].setBounds(34, 5, 43, 25);
       coupon_text[3].setBounds(31, 5, 53, 25);
       

       /* ���� �̿�� �κ� */
       int coupon1_hours_Panel_width = 49;
       int coupon1_hours_Panel_height = 100;
       JPanel coupon1_hours_Panel[] = new JPanel[8];
       JLabel coupon1_hours_text[] = new JLabel[8];
       String coupon1_text[] = {"2�ð�", "4�ð�", "6�ð�", "8�ð�", "3,000��", "5,000��", "7,000��", "8,000��"};
       
       for(int i=0; i<8; i++) {
    	   coupon1_hours_Panel[i] = new JPanel();
    	   coupon1_hours_Panel[i].setBackground(new Color(233,244,236));
    	   coupon1_hours_Panel[i].setLayout(null);
    	   coupon1_hours_Panel[i].setBounds(coupon1_hours_Panel_width, coupon1_hours_Panel_height, 90, 30);
    	   coupon1_hours_Panel_width += 91; 
    	   if(i == 3) {
    		   coupon1_hours_Panel_width = 49;
    		   coupon1_hours_Panel_height = 131;
    	   }
    	   price_panel.add(coupon1_hours_Panel[i]);
    	   
    	   coupon1_hours_text[i] = new JLabel(coupon1_text[i]);
    	   coupon1_hours_text[i].setFont(new Font("����", Font.PLAIN, 15));
    	   coupon1_hours_Panel[i].add(coupon1_hours_text[i]);
       }
       coupon1_hours_text[0].setBounds(26, 6, 37, 20);
       coupon1_hours_text[1].setBounds(25, 6, 37, 20);
      
       coupon1_hours_text[2].setBounds(24, 6, 37, 20);
       coupon1_hours_text[3].setBounds(25, 6, 37, 20);
      
       coupon1_hours_text[4].setBounds(21, 6, 52, 20);
       coupon1_hours_text[5].setBounds(19, 6, 53, 20);
     
       coupon1_hours_text[6].setBounds(18, 6, 54, 20);
       coupon1_hours_text[7].setBounds(18, 6, 53, 20);
      
      
      
       /* �Ⱓ�� �κ� */
       int coupon2_hours_Panel_width = 49;
       int coupon2_hours_Panel_height = 240; 
       JPanel coupon2_hours_Panel[] = new JPanel[8];
       JLabel coupon2_hours_text[] = new JLabel[8];
       String coupon2_text[] = {"1��", "1��", "2��", "4��", "15,000��", "45,000��", "90,000��", "150,000��"};
       
       for(int i=0; i<8; i++) {
    	   coupon2_hours_Panel[i] = new JPanel();
    	   coupon2_hours_Panel[i].setBackground(new Color(233,244,236));
    	   coupon2_hours_Panel[i].setLayout(null);
    	   coupon2_hours_Panel[i].setBounds(coupon2_hours_Panel_width, coupon2_hours_Panel_height, 90, 30);
    	   coupon2_hours_Panel_width += 91; 
    	   if(i == 3) {
    		   coupon2_hours_Panel_width = 49;
    		   coupon2_hours_Panel_height = 271;
    	   }
    	   price_panel.add(coupon2_hours_Panel[i]);
    	   
    	   coupon2_hours_text[i] = new JLabel(coupon2_text[i]);
    	   coupon2_hours_text[i].setFont(new Font("����", Font.PLAIN, 15));
    	   coupon2_hours_Panel[i].add(coupon2_hours_text[i]);
       }
       coupon2_hours_text[0].setBounds(34, 6, 22, 20);
       coupon2_hours_text[1].setBounds(33, 6, 22, 20);
      
       coupon2_hours_text[2].setBounds(32, 6, 22, 20);
       coupon2_hours_text[3].setBounds(33, 6, 22, 20);
      
       coupon2_hours_text[4].setBounds(15, 6, 69, 20);
       coupon2_hours_text[5].setBounds(18, 6, 59, 20);
     
       coupon2_hours_text[6].setBounds(16, 6, 60, 20);
       coupon2_hours_text[7].setBounds(11, 6, 72, 20);
     
      
       
       /* ���ױ� �κ� */
       int coupon3_hours_Panel_width = 49;
       int coupon3_hours_Panel_height = 380; 
       JPanel coupon3_hours_Panel[] = new JPanel[6];
       JLabel coupon3_hours_text[] = new JLabel[6];
       String coupon3_text[] = {"50�ð�", "100�ð�", "150�ð�", "70,000��", "120,000��", "170,000��"};
       
       for(int i=0; i<6; i++) {
    	   coupon3_hours_Panel[i] = new JPanel();
    	   coupon3_hours_Panel[i].setBackground(new Color(233,244,236));
    	   coupon3_hours_Panel[i].setLayout(null);
    	   coupon3_hours_Panel[i].setBounds(coupon3_hours_Panel_width, coupon3_hours_Panel_height, 90, 30);
    	   coupon3_hours_Panel_width += 91; 
    	   if(i == 2) {
    		   coupon3_hours_Panel_width = 49;
    		   coupon3_hours_Panel_height = 411;
    	   }
    	   price_panel.add(coupon3_hours_Panel[i]);
    	   
    	   coupon3_hours_text[i] = new JLabel(coupon3_text[i]);
    	   coupon3_hours_text[i].setFont(new Font("����", Font.PLAIN, 15));
    	   coupon3_hours_Panel[i].add(coupon3_hours_text[i]);
       }
       coupon3_hours_text[0].setBounds(21, 6, 50, 20);
       coupon3_hours_text[1].setBounds(18, 6, 53, 20);
      
       coupon3_hours_text[2].setBounds(17, 6, 53, 20);
       coupon3_hours_text[3].setBounds(15, 6, 69, 20);
      
       coupon3_hours_text[4].setBounds(6, 6, 78, 20);
       coupon3_hours_text[5].setBounds(7, 6, 76, 20);
      
       
       /* �� ���� �κ� */
       int coupon4_hours_Panel_width = 49;
       int coupon4_hours_Panel_height = 519; 
       JPanel coupon4_hours_Panel[] = new JPanel[4];
       JLabel coupon4_hours_text[] = new JLabel[4];
       String coupon4_text[] = {"���η�(1��) 3�ð�", "ȸ�Ƿ�(6��) 5�ð�", "5,000��", "6,000��"};
       
       for(int i=0; i<4; i++) {
    	   coupon4_hours_Panel[i] = new JPanel();
    	   coupon4_hours_Panel[i].setBackground(new Color(233,244,236));
    	   coupon4_hours_Panel[i].setLayout(null);
    	   coupon4_hours_Panel[i].setBounds(coupon4_hours_Panel_width, coupon4_hours_Panel_height, 150, 30);
    	   coupon4_hours_Panel_width += 151; 
    	   if(i == 1) {
    		   coupon4_hours_Panel_width = 49;
    		   coupon4_hours_Panel_height = 550;
    	   }
    	   price_panel.add(coupon4_hours_Panel[i]);
    	   
    	   coupon4_hours_text[i] = new JLabel(coupon4_text[i]);
    	   coupon4_hours_text[i].setFont(new Font("����", Font.PLAIN, 15));
    	   coupon4_hours_Panel[i].add(coupon4_hours_text[i]);
       }
       coupon4_hours_text[0].setBounds(15, 7, 143, 20);
       coupon4_hours_text[1].setBounds(15, 7, 143, 20);
      
       coupon4_hours_text[2].setBounds(46, 6, 51, 20);
       coupon4_hours_text[3].setBounds(54, 6, 51, 20);
      
       
      
	  /* �� �ȳ� ǥ �г� & ���� */
      JPanel roomtitle_panel = new JPanel(); 
      roomtitle_panel.setLayout(null);
      roomtitle_panel.setBackground(Color.white);
      roomtitle_panel.setBorder(new LineBorder(new Color(127,114,165), 30, true));
      roomtitle_panel.setBounds(779, 62, 189, 39);
      panel.add(roomtitle_panel);
      
      JLabel roomtitle_text = new JLabel("�� �ȳ�");
      roomtitle_text.setForeground(Color.WHITE);
      roomtitle_text.setFont(new Font("����", Font.PLAIN, 20));
      roomtitle_text.setBounds(62, 8, 74, 25);
      roomtitle_panel.add(roomtitle_text);
      
	  /* �� �ȳ� ǥ �׵θ� */
      JPanel room_panel = new JPanel();
      room_panel.setBackground(Color.WHITE);
      room_panel.setLayout(null);
      room_panel.setBorder(new LineBorder(new Color(127,114,165), 1, true));
      room_panel.setBounds(491, 79, 760, 657);
      panel.add(room_panel);

      
      /* ���ν� �Ұ� */
      JLabel maintitle = new JLabel("���ν�(����)");
      maintitle.setFont(new Font("����", Font.BOLD, 25));
      maintitle.setBounds(120, 80, 174, 47);
      room_panel.add(maintitle);
      
      JLabel mainsubtitle = new JLabel("���µǾ� �־� �����Ӱ� ��� ������ �⺻���� ���Դϴ�");
      mainsubtitle.setFont(new Font("����", Font.PLAIN, 15));
      mainsubtitle.setBounds(32, 110, 361, 47);
      room_panel.add(mainsubtitle);
      
      JPanel main_img_panel = new JPanel();
      main_img_panel.setBounds(411, 42, 310, 180);
      room_panel.add(main_img_panel);
      main_img_panel.setLayout(null);
      
      ImagePanel mainroomImg = new ImagePanel(new ImageIcon("./img/resizemainroom.png").getImage());
      main_img_panel.add(mainroomImg);
      
      
      /* ���ν� �Ұ� */
      JLabel personaltitle = new JLabel("���ν�");
      personaltitle.setFont(new Font("����", Font.BOLD, 25));
      personaltitle.setBounds(520, 280, 174, 47);
      room_panel.add(personaltitle);
      
      JLabel personalsubtitle = new JLabel("1�νǷ� �̷�����־� �����ϰ� �����̺��� ���Դϴ�");
      personalsubtitle.setFont(new Font("����", Font.PLAIN, 15));
      personalsubtitle.setBounds(395, 310, 361, 47);
      room_panel.add(personalsubtitle);

      JPanel personal_img_panel = new JPanel();
      personal_img_panel.setLayout(null);
      personal_img_panel.setBounds(50, 235, 310, 180);
      room_panel.add(personal_img_panel);
      
      ImagePanel personalroomImg = new ImagePanel(new ImageIcon("./img/resizepersonalroom.jpg").getImage());
      personal_img_panel.add(personalroomImg);
      

      /* ȸ�ǽ� �Ұ� */
      JLabel meetingtitle = new JLabel("ȸ�ǽ�");
      meetingtitle.setFont(new Font("����", Font.BOLD, 25));
      meetingtitle.setBounds(160, 490, 174, 47);
      room_panel.add(meetingtitle);
      
      JLabel meetingsubtitle = new JLabel("4~6�ϽǷ� �̷���� �ִ� ���ο� ���� ���Դϴ�");
      meetingsubtitle.setFont(new Font("����", Font.PLAIN, 15));
      meetingsubtitle.setBounds(60, 520, 361, 47);
      room_panel.add(meetingsubtitle);
      
      JPanel meeting_img_panel = new JPanel();
      meeting_img_panel.setLayout(null);
      meeting_img_panel.setBounds(411, 434, 310, 180);
      room_panel.add(meeting_img_panel);
           
      ImagePanel meetingroomImg = new ImagePanel(new ImageIcon("./img/resizemeetingroom.jpg").getImage());
      meeting_img_panel.add(meetingroomImg);
      

   }
   class Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			new SelectTimeTablePage(); // SelectTimeTablePage ����
            setVisible(false);  // â �Ⱥ��̰� �ϱ� 
		}
   }
   
   /* �гο� �׸� �ø��� Ŭ���� */
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