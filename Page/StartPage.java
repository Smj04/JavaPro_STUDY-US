package Page;

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
		
		title = new JLabel("STUDY US");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Century Gothic", Font.PLAIN, 70));
		title.setBounds(132, 296, 624, 175);
		panel.add(title);
		
		btn_login = new JButton("�α���");
		btn_login.setBounds(813, 448, 97, 23);
		// btn_login.setBackground(new Color(255,128,0));
		panel.add(btn_login);
		
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginPage(); // JoinPage ����
				setVisible(false);  // â �Ⱥ��̰� �ϱ� 
			}
		});	
		
		btn_join = new JButton("ȸ������");
		btn_join.setBounds(813, 481, 97, 23);
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
