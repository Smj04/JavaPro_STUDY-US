package pjk;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;

public class StartPage extends JFrame {
	
	private JPanel contentPane, panel;
	private JButton btn_login, btn_join;
	private JLabel title;
	
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
		
		btn_login = new JButton("�α���");
		btn_login.setForeground(Color.WHITE);
		btn_login.setBounds(970, 452, 97, 28);
		btn_login.setBackground(Color.DARK_GRAY);
		panel.add(btn_login);
		
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginPage(); // JoinPage ����
				setVisible(false);  // â �Ⱥ��̰� �ϱ� 
			}
		});
		
		
		btn_join = new JButton("ȸ������");
		btn_join.setForeground(Color.WHITE);
		btn_join.setBackground(Color.BLACK);
		btn_join.setBounds(970, 508, 97, 28);
		panel.add(btn_join);
		
		JPanel title_panel = new JPanel();
		title_panel.setBorder(new LineBorder(new Color(192, 192, 192), 30, true));
		title_panel.setBounds(182, 301, 526, 168);
		title_panel.setBackground(Color.LIGHT_GRAY);
		panel.add(title_panel);
		
		title_panel.setLayout(null);
		
		title = new JLabel("STUDY US");
		title.setBounds(111, 35, 304, 87);
		title_panel.add(title);
		title.setForeground(Color.WHITE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Century Gothic", Font.PLAIN, 70));
		
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

