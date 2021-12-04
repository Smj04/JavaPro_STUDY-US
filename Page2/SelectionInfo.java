package Page2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextPane;

public class SelectionInfo extends JFrame {

   private JPanel contentPane, panel;
   private JButton btn_cancel, btn_sumit;
   
   
   
   SelectionInfo(){
      
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
      
      JPanel panel = new JPanel();
      contentPane.add(panel, BorderLayout.CENTER);
      panel.setLayout(null);
      
      JPanel subtitle_panel = new JPanel();
      subtitle_panel.setLayout(null);
      subtitle_panel.setForeground(new Color(211, 211, 211));
      subtitle_panel.setBorder(new LineBorder(new Color(211,183,219), 30, true));
      subtitle_panel.setBounds(0, 0, 1273, 52);
      panel.add(subtitle_panel);
      
      JLabel title = new JLabel("STUDY US");
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

      
      JPanel seattable_title_panel = new JPanel();
      seattable_title_panel.setBounds(101, 96, 196, 39);
      
      panel.add(seattable_title_panel);
      seattable_title_panel.setLayout(null);
      seattable_title_panel.setBorder(new LineBorder(new Color(211,183,219), 30, true));
      
      JLabel seattable_title_text = new JLabel("���� ����");
      seattable_title_text.setHorizontalAlignment(SwingConstants.CENTER);
      seattable_title_text.setForeground(Color.WHITE);
      seattable_title_text.setFont(new Font("��������", Font.PLAIN, 20));
      seattable_title_text.setBounds(31, 7, 139, 25);
      seattable_title_panel.add(seattable_title_text);
      
      JPanel seattable_panel = new JPanel();
      seattable_panel.setBackground(Color.WHITE);
      seattable_panel.setBorder(new LineBorder(new Color(211,183,219), 3, true));
      seattable_panel.setBounds(72, 96, 1109, 590);
      panel.add(seattable_panel);
      seattable_panel.setLayout(null);
      

         
         JLabel label_setTime = new JLabel("������ �ð����� �������ϴ�..");
         label_setTime.setHorizontalAlignment(SwingConstants.LEFT);
         label_setTime.setFont(new Font("������� ExtraBold", Font.PLAIN, 20));
         label_setTime.setBackground(Color.YELLOW);
         label_setTime.setBounds(513, 233, 274, 33);
         seattable_panel.add(label_setTime);
         
         JLabel label_setSeat = new JLabel("������ �¼�/���� �������ϴ�..");
         label_setSeat.setHorizontalAlignment(SwingConstants.LEFT);
         label_setSeat.setFont(new Font("������� ExtraBold", Font.PLAIN, 20));
         label_setSeat.setBackground(Color.YELLOW);
         label_setSeat.setBounds(513, 300, 274, 33);
         seattable_panel.add(label_setSeat);
         
         
         
         JPanel panel_1 = new JPanel();
         panel_1.setBorder(new LineBorder(new Color(255, 228, 196), 30, true));
         panel_1.setBackground(Color.WHITE);
         panel_1.setBounds(321, 233, 153, 33);
         seattable_panel.add(panel_1);
         panel_1.setLayout(null);
         
         JLabel label_time_text = new JLabel("������ �ð���");
         label_time_text.setForeground(Color.WHITE);
         label_time_text.setBounds(3, 10, 146, 17);
         panel_1.add(label_time_text);
         label_time_text.setHorizontalAlignment(SwingConstants.CENTER);
         label_time_text.setFont(new Font("������� ExtraBold", Font.BOLD, 14));

         
         JPanel panel_1_1 = new JPanel();
         panel_1_1.setBorder(new LineBorder(new Color(240, 128, 128), 30, true));
         panel_1_1.setBackground(Color.WHITE);
         panel_1_1.setBounds(321, 300, 153, 33);
         seattable_panel.add(panel_1_1);
         panel_1_1.setLayout(null);
         
         JLabel label_seat_text = new JLabel("������ �¼�");
         label_seat_text.setHorizontalAlignment(SwingConstants.CENTER);
         label_seat_text.setForeground(Color.WHITE);
         label_seat_text.setFont(new Font("������� ExtraBold", Font.BOLD, 14));
         label_seat_text.setBounds(3, 9, 146, 17);
         panel_1_1.add(label_seat_text);
         
         
      
         
         btn_sumit = new JButton("����");
         btn_sumit.setForeground(Color.WHITE);
         btn_sumit.setBackground(new Color(211,183,219));
         btn_sumit.setBounds(805, 391, 97, 28);	//97, 28
         btn_sumit.setBorderPainted(false);	//�׵θ� ���ֱ�
         btn_sumit.setBorder(new LineBorder(new Color(0, 0, 0), 2, true)); 
         seattable_panel.add(btn_sumit);
         
         btn_cancel = new JButton("���");
         btn_cancel.setForeground(Color.WHITE);
         btn_cancel.setBackground(new Color(211,183,219));
         btn_cancel.setBorderPainted(false);	//�׵θ� ���ֱ�
         btn_cancel.setBounds(666, 391, 97, 28);
         btn_cancel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true)); 
         seattable_panel.add(btn_cancel);
               
         
      
   }      
      public static void main(String[] args) {
         new SelectionInfo();
      }
}