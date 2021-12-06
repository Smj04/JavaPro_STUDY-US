package Page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class StartPage extends JFrame {

   public static long start;
   private JPanel contentPane, main_panel, view_panel, PricePage_panel;
   private JButton btn_login, btn_join;
   private JLabel title, sub_title;

   // ��Ʈ����
   Font font_75 = new Font("Cafe24SsurroundAir", Font.PLAIN, 75); // ùȭ�� ���� ��Ʈ
   Font font_12 = new Font("Cafe24SsurroundAir", Font.BOLD, 12);
   Font font_17 = new Font("Cafe24SsurroundAir", Font.BOLD, 17);

   StartPage() {
      super("���͵�ī�� ���� ���α׷� [STUDY US]");
      start = System.currentTimeMillis(); //�����ϴ� ���� ���
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
      main_panel = new JPanel();
      main_panel.setBackground(Color.WHITE);
      contentPane.add(main_panel, BorderLayout.CENTER);
      main_panel.setLayout(null);

      /* ���� Ÿ��Ʋ */
      sub_title = new JLabel("���͵� ī�� ���� ���α׷�");
      sub_title.setFont(font_17);
      sub_title.setForeground(new Color(53, 69, 98));
      sub_title.setHorizontalAlignment(SwingConstants.LEFT);
      sub_title.setBounds(360, 140, 624, 175);// 624
      main_panel.add(sub_title);

      /* ���� Ÿ��Ʋ */
      title = new JLabel("STUDY US");
      title.setFont(font_75);
      title.setForeground(new Color(255, 255, 255));
      title.setHorizontalAlignment(SwingConstants.CENTER);
      title.setBounds(330, 256, 624, 175);// 624
      main_panel.add(title);

      /* Ÿ��Ʋ ��� */
      view_panel = new JPanel();
      view_panel.setBackground(new Color(255, 255, 255));
      view_panel.setBounds(330, 250, 624, 175);
      // view_panel.setLayout(null);
      view_panel.setBorder(new LineBorder(new Color(237, 197, 214), 90, true));
      main_panel.add(view_panel);

      /* ��ư �α��� */
      btn_login = new JButton("�α���");
      btn_login.setFont(font_12);
      btn_login.setForeground(Color.WHITE);
      btn_login.setBorderPainted(false); // �׵θ� ���ֱ�
      btn_login.setBounds(840, 460, 105, 33);
      btn_login.setBackground(new Color(53, 69, 98));
      main_panel.add(btn_login);

      btn_login.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            new LoginPage(); // LoginPage ����
            setVisible(false); // â �Ⱥ��̰� �ϱ�
         }
      });

      /* ��ư ȸ������ */
      btn_join = new JButton("ȸ������");
      btn_join.setFont(font_12);
      btn_join.setForeground(Color.WHITE);
      btn_join.setBorderPainted(false);
      btn_join.setBackground(new Color(53, 69, 98));
      btn_join.setBounds(717, 460, 105, 33);
      // btn_join.setBounds(850, 501, 97, 28);
      main_panel.add(btn_join);

      ImageIcon PricePageImg = new ImageIcon("./img/resizequestion-mark.png");
      JButton PricePage = new JButton(PricePageImg);
      PricePage.setBorderPainted(false); // ��ư �׵θ� ��������
      PricePage.setBounds(1165, 45, 60, 60);
      PricePage.setPreferredSize(new Dimension(60, 60)); // ��ư ũ�� ����
      PricePage.setContentAreaFilled(false);
      main_panel.add(PricePage);

      PricePage.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            new PricePage();
            setVisible(false);
         }
      });

      btn_join.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            new JoinPage();
            setVisible(false);
         }
      });
   }

   public static void main(String[] args) {
      new StartPage();
   }
}