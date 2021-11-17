package Page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Page.JoinPage.Listener;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class LoginPage  extends JFrame {
   
   private JPanel contentPane, panel, subtitle_panel;
   private JTextField field_id,  field_pass;
   private JLabel textID, textPASS, title;
   private JButton btn_Login;
   
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
         textID.setFont(new Font("����", Font.PLAIN, 30));
         textID.setBounds(481, 331, 30, 47);
         panel.add(textID);
      
         JLabel textPASS = new JLabel("PASSWORD");
         textPASS.setFont(new Font("����", Font.PLAIN, 30));
         textPASS.setBounds(348, 401, 195, 47);
         panel.add(textPASS);
      
         btn_Login = new JButton("�α���");
         btn_Login.setForeground(Color.WHITE);
         btn_Login.setBackground(Color.black);
         btn_Login.setBounds(794, 493, 97, 28);
         btn_Login.setBorder(new LineBorder(new Color(0, 0, 0), 0, true)); 
         panel.add(btn_Login);
         
         btn_Login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               new SelectTimeTablePage(); // SelectTimeTablePage ����
               setVisible(false);  // â �Ⱥ��̰� �ϱ� 
            }
         });
         
         subtitle_panel = new JPanel();
         subtitle_panel.setLayout(null);
         subtitle_panel.setForeground(new Color(211, 211, 211));
         subtitle_panel.setBorder(new LineBorder(new Color(192, 192, 192), 30, true));
         subtitle_panel.setBounds(0, 0, 1273, 52);
         panel.add(subtitle_panel);
         
         title = new JLabel("STUDY US");
         title.setForeground(new Color(255, 255, 255));
         title.setFont(new Font("Century Gothic", Font.PLAIN, 25));
         title.setBounds(22, 6, 440, 42);
         subtitle_panel.add(title);
         // btn_Login.addActionListener(new Listener(this));
      
   }

	/* ���̵�/��й�ȣ �Է� Ȯ�� �׽�Ʈ
	 * class Listener implements ActionListener{ JFrame frame; public
	 * Listener(JFrame f) { frame = f; }
	 * 
	 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
	 * method stub System.out.println(e.getActionCommand());
	 * 
	 * String id = field_id.getText(); System.out.println(id);
	 * 
	 * String pass = field_pass.getText(); System.out.println(pass);
	 * 
	 * JOptionPane.showMessageDialog(frame, id+" "+pass); } }
	 */
   public static void main(String[] args) {
      new LoginPage();
   }

}