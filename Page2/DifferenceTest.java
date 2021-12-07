package Page2;


import java.awt.Font;
import java.util.Calendar;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
 
public class DifferenceTest extends JFrame{
	Font f1;
	
	DifferenceTest(){
		
		final int[] TIME_UNIT = {3600,60,1};
		final String[] TIME_UNIT_NAME = {"�ð� ","�� ","��"};
		
		f1 = new Font("����ǹ��� ����",Font.PLAIN,30);
		
		// today
		Calendar date1 = Calendar.getInstance();
		 Calendar cal = Calendar.getInstance();
		date1.set( cal.get(Calendar.YEAR),
                (cal.get(Calendar.MONTH)+1),
                cal.get(Calendar.DATE),
                cal.get(Calendar.HOUR),
                cal.get(Calendar.MINUTE),
                cal.get(Calendar.SECOND));
		
		// that day
		Calendar date2 = Calendar.getInstance();
		date2.set( cal.get(Calendar.YEAR),
                (cal.get(Calendar.MONTH)+1),
                cal.get(Calendar.DATE),
                cal.get(Calendar.HOUR),
                cal.get(Calendar.MINUTE),
                cal.get(Calendar.SECOND));
		
		
		String str1 = "�ð� 1: " + date1.get(Calendar.HOUR_OF_DAY) + "�� " + date1.get(Calendar.MINUTE) + "�� " +
				date1.get(Calendar.SECOND) + "�� ";
		
		String str2 = "�ð� 2: " + date2.get(Calendar.HOUR_OF_DAY) + "�� " + date2.get(Calendar.MINUTE) + "�� " +
				date2.get(Calendar.SECOND) + "�� ";
		
		
		long dif1 = (date2.getTimeInMillis() - date1.getTimeInMillis())/1000;
		
		String tmp ="�ð� ���� : ";
		
		for (int i=0; i<TIME_UNIT.length; i++) {
			tmp += dif1/TIME_UNIT[i] + TIME_UNIT_NAME[i];
			dif1 %= TIME_UNIT[i];
		}
		
	
		JLabel lb1 = new JLabel(tmp);
		lb1.setBounds(50, 200, 600, 40);
		lb1.setFont(f1);
		
		JLabel lb2 = new JLabel(str1);
		lb2.setBounds(50, 100, 600, 40);
		lb2.setFont(f1);
		
		JLabel lb3 = new JLabel(str2);
		lb3.setBounds(50, 150, 600, 40);
		lb3.setFont(f1);
		
		
		// JFrame
		add(lb1);add(lb2);add(lb3);
		setTitle("Calendar Example");
		setSize(700,500);
		setLayout(null);
		setVisible(true);
	}
 
	public static void main(String[] args) {
		
		new DifferenceTest();
	}
}