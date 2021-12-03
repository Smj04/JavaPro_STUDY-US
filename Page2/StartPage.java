package Page2;

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
   private JButton btn_login, btn_join, btn_price;
   private JLabel title;
   
   //��Ʈ����
   Font font1 = new Font("Cafe24SsurroundAir", Font.PLAIN, 70); //ùȭ�� ���� ��Ʈ
   Font font2 = new Font("Cafe24SsurroundAir", Font.BOLD, 10); 
   
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
      
      title = new JLabel("STUDY US");
      title.setFont(font1);
      title.setHorizontalAlignment(SwingConstants.CENTER);
      title.setBounds(132, 296, 624, 175);//624
      panel.add(title);
      
   
      
  
      btn_login = new JButton("�α���");
      btn_login.setFont(font2);
      btn_login.setForeground(Color.WHITE);
      btn_login.setBounds(900, 448, 97, 28);
      btn_login.setBackground(Color.BLACK);
      panel.add(btn_login);
      
      btn_login.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            new LoginPage(); // JoinPage ����
            setVisible(false);  // â �Ⱥ��̰� �ϱ� 
         }
      });
      
      
      btn_join = new JButton("ȸ������");
      btn_join.setFont(font2);
      btn_join.setForeground(Color.WHITE);
      btn_join.setBackground(Color.BLACK);
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