package Page2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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


public class JoinPage extends JFrame {
	
	private JPanel contentPane, panel;
	private JTextField field_id,  field_pass, field_name;
	private JLabel textID, textPASS, textNAME;
	private JButton btn_Join;
	
	JoinPage(){
		super("���͵�ī�� ���� ���α׷� [STUDY US]");
		init();
	}
	
	class ImagePanel extends JPanel{	//�̹��� �г� Ŭ����
		private Image img;
		
		public ImagePanel(Image img) {
			this.img = img;
			setSize(new Dimension(img.getWidth(null),img.getHeight(null)));
			setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
			setLayout(null);
		}
		public void paintComponent(Graphics g) {
			g.drawImage(img, 0 , 0,null);
		}
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
		field_id.setHorizontalAlignment(SwingConstants.CENTER);
		field_id.setBackground(SystemColor.inactiveCaptionBorder);
		field_id.setBounds(528, 347, 357, 47);
		panel.add(field_id);
		field_id.setColumns(10);
		
		field_pass = new JTextField();
		field_pass.setHorizontalAlignment(SwingConstants.CENTER);
		field_pass.setBackground(SystemColor.inactiveCaptionBorder);
		field_pass.setColumns(10);
		field_pass.setBounds(528, 417, 357, 47);
		panel.add(field_pass);
		
		field_name = new JTextField();
		field_name.setBackground(SystemColor.inactiveCaptionBorder);
		field_name.setHorizontalAlignment(SwingConstants.CENTER);
		field_name.setColumns(10);
		field_name.setBounds(528, 483, 357, 47);
		panel.add(field_name);
		
		JLabel textID = new JLabel("ID");
		textID.setHorizontalAlignment(SwingConstants.CENTER);
		textID.setFont(new Font("����", Font.PLAIN, 30));
		textID.setBounds(475, 347, 30, 47);
		panel.add(textID);
		
		JLabel textPASS = new JLabel("PASSWORD");
		textPASS.setHorizontalAlignment(SwingConstants.CENTER);
		textPASS.setFont(new Font("����", Font.PLAIN, 30));
		textPASS.setBounds(342, 417, 195, 47);
		panel.add(textPASS);
		
		textNAME = new JLabel("NAME");
		textNAME.setHorizontalAlignment(SwingConstants.CENTER);
		textNAME.setFont(new Font("����", Font.PLAIN, 30));
		textNAME.setBounds(420, 485, 105, 47);
		panel.add(textNAME);
		
		btn_Join = new JButton("�����ϱ�");
		btn_Join.setBackground(Color.BLACK);
		btn_Join.setForeground(Color.WHITE);
		btn_Join.setBounds(788, 567, 97, 28);
		panel.add(btn_Join);
		
		JPanel subtitle_panel = new JPanel();
		subtitle_panel.setLayout(null);
		subtitle_panel.setForeground(new Color(211, 211, 211));
		subtitle_panel.setBorder(new LineBorder(new Color(211,183,219), 30, true));
		subtitle_panel.setBounds(0, 0, 1286, 52);
		panel.add(subtitle_panel);
		
		JLabel lblNewLabel = new JLabel("STUDY US");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		lblNewLabel.setBounds(65, 5, 440, 42);	//18�̿��� **�̹��� �־ ����**
		subtitle_panel.add(lblNewLabel);
		
		
		
		ImagePanel panel = new ImagePanel(new ImageIcon("./img/flower.png").getImage());
		subtitle_panel.add(panel);
	
		
		btn_Join.addActionListener(new Listener(this));
		
		
		
	}
	class Listener implements ActionListener{
		JFrame frame;
		public Listener(JFrame f) {
			frame = f;
		}
		@Override
		public void actionPerformed(ActionEvent e) {

			String join_name = field_name.getText();
			String join_id = field_id.getText();
			String join_pass = field_pass.getText();
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/STUDY_US";
				String id = "root";
				String pw = "111111";
				Connection conn = DriverManager.getConnection(url, id, pw);

				String sql = "insert into user(name, id, pass, regular_chk) values('"+join_name+"', '"+join_id+"', '"+join_pass+"', 'false');";			
				Statement stmt = conn.createStatement(); 
				stmt.executeUpdate(sql);
				
				// System.out.println("����");
				
				JOptionPane.showMessageDialog(frame, "���ԵǾ����ϴ�"); 
		
				 new LoginPage(); // JoinPage ����
		         setVisible(false);  // â �Ⱥ��̰� �ϱ� 
				
			}catch(Exception ee) {
				System.out.println("����");
			}
		}
	}
	
	public static void main(String[] args) {
		new JoinPage();
	}
}