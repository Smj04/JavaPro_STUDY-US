package Page2;

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
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

//���� auto_incremet�װ� ������ �ξ� ������ or for�� i������ �����!!
public class UserPage extends JFrame {
   private Connection con;
   private Statement stmt;
   private ResultSet rs;
   private ResultSet rs2;

   JPanel contentPane, panel, subtitle_panel, result_panel, inlist_title_panel;
   JLabel title, inlist_title_text;

   public UserPage() {
      super("���͵�ī�� ���� ���α׷� [STUDY US]");
      init();
       
      JPanel list_panel = new JPanel();
      list_panel.setBounds(0, 141, 1286, 590);
      list_panel.setBackground(new Color(245,247,248));
      panel.add(list_panel);
      list_panel.setLayout(null);

      
     

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
      subtitle_panel.setBorder(new LineBorder(new Color(211,183,219), 30, true));
      subtitle_panel.setBounds(0, 0, 1273, 52);
      panel.add(subtitle_panel);

      title = new JLabel("STUDY US");
      title.setForeground(new Color(255, 255, 255));
      title.setFont(new Font("Century Gothic", Font.PLAIN, 25));
      title.setBounds(22, 6, 440, 42);
      subtitle_panel.add(title);
      
      //�гο� �׸��� �÷��ִ� Ŭ����
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

			String sql = "SELECT name, id, pass FROM user";		//?

			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(sql); //����� ���� ResultSet ���� �� ��� ���
			
			while(rs.next()) {
				String user_name = rs.getString("name");
				String user_id = rs.getString("id");
				String user_pw = rs.getString("pass");
				
				 JLabel list_title = new JLabel(user_name+"���� ������");
			      list_title.setHorizontalAlignment(JLabel.CENTER); // ���� ��� ����
			      list_title.setFont(new Font("����", Font.PLAIN, 20));
			      list_title.setBounds(595, 90, 150, 24);
			      panel.add(list_title);
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
 
      
      JPanel inlist_title_panel = new JPanel();
      inlist_title_panel.setBounds(0, 143, 1274, 60);
      panel.add(inlist_title_panel);
      inlist_title_panel.setLayout(null);
      inlist_title_panel.setBackground(new Color(211,183,219));
      
      JLabel inlist_title_SelectTime = new JLabel("�����Ͻ� �ð�");
      inlist_title_SelectTime.setFont(new Font("����", Font.PLAIN, 20));
      inlist_title_SelectTime.setForeground(Color.WHITE);
      inlist_title_SelectTime.setBounds(65, 12, 130, 35);
      inlist_title_panel.add(inlist_title_SelectTime);
      
      JLabel inlist_title_CurrentTime = new JLabel("���� �ð�");
      inlist_title_CurrentTime.setForeground(Color.WHITE);
      inlist_title_CurrentTime.setFont(new Font("����", Font.PLAIN, 20));
      inlist_title_CurrentTime.setBounds(300, 12, 121, 35);
      inlist_title_panel.add(inlist_title_CurrentTime);
      

   }

   public static void main(String[] args) {
      new UserPage();
   }
}