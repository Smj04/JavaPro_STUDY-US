package Page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class StartPage extends JFrame {
   
   private JPanel contentPane, panel;
   private JButton btn_login, btn_join;
   private JLabel title, sub_title;
    
   //��Ʈ����
   Font font_75 = new Font("Cafe24SsurroundAir", Font.PLAIN, 75); //ùȭ�� ���� ��Ʈ
   Font font_12 = new Font("Cafe24SsurroundAir", Font.BOLD, 12); 
   Font font_17 = new Font("Cafe24SsurroundAir", Font.BOLD, 17); 
   
   StartPage(){
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
      
      sub_title = new JLabel("���͵� ī�� ���� ���α׷�");
      sub_title.setFont(font_17);
      sub_title.setForeground(new Color(127,114,165));
      sub_title.setHorizontalAlignment(SwingConstants.CENTER);
      sub_title.setBounds(132, 206, 624, 175);//624
      panel.add(sub_title);
      
      title = new JLabel("STUDY US");
      title.setFont(font_75);
      title.setForeground(new Color(127,114,165));
      title.setHorizontalAlignment(SwingConstants.CENTER);
      title.setBounds(132, 266, 624, 175);//624
      panel.add(title);
      
      btn_login = new JButton("�α���");
      btn_login.setFont(font_12);
      btn_login.setForeground(Color.WHITE);
      btn_login.setBorderPainted(false);	//�׵θ� ���ֱ�
      btn_login.setBounds(900, 448, 97, 28);
      btn_login.setBackground(new Color(215,176,212));
      panel.add(btn_login);
      
      btn_login.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            new LoginPage(); // JoinPage ����
            setVisible(false);  // â �Ⱥ��̰� �ϱ� 
         }
      });
      btn_join = new JButton("ȸ������");
      btn_join.setFont(font_12);
      btn_join.setForeground(Color.WHITE);
      btn_join.setBorderPainted(false);	//�׵θ� ���ֱ�
      btn_join.setBackground(new Color(215,176,212));
      btn_join.setBounds(900, 481, 97, 28);
      panel.add(btn_join);
      
      btn_join.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            new JoinPage(); // JoinPage ����
            setVisible(false);  // â �Ⱥ��̰� �ϱ� 
         }
      });
   }
   
   public static void main(String[] args) {
      new StartPage();
   }
}