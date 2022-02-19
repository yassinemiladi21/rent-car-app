import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


public  class new_main extends JFrame implements ActionListener {
	JButton button1;
	JButton button;
	static JTextField user;
	static JPasswordField pd;

	new_main() {
		
		JPanel mainpanel = new JPanel();
		mainpanel.setBounds(260,200,500,410);
		mainpanel.setBackground(new Color(0x1e2329));
		mainpanel.setLayout(null);
		
		JLabel icon = new JLabel();
		
		ImageIcon image = new ImageIcon("RentCar.png");
		
		icon.setIcon(image);
		icon.setBounds(50,15,388,104);
		
		
		JLabel lab = new JLabel ();
		lab.setText("Login");
		lab.setFont(new Font("Poppins",Font.PLAIN,35));
		lab.setForeground(Color.white);
		
		

		
		JLabel lab2 = new JLabel ();
		lab2.setText("Username");
		lab2.setFont(new Font("Poppins",Font.PLAIN,15));
		//lab.setCursor(new Color(166,48,85));
		lab2.setForeground(Color.white);
		

		JPanel panel = new JPanel();
		panel.setBounds(150,0,200,60);
		panel.setBackground(new Color(0x1e2329));
		panel.add(lab);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(150,90,200,30);
		panel1.setBackground(new Color(0x1e2329));
		panel1.add(lab2);

		user = new JTextField();
		user.setPreferredSize(new Dimension(200,30));
		user.setForeground(Color.black);
		user.setFont(new Font("Poppins",Font.PLAIN,18));
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(150,120,200,30);
		panel2.setBackground(new Color(0x1e2329));
		panel2.add(user);
		panel2.setBorder(null);
		
		pd = new JPasswordField();
		pd.setPreferredSize(new Dimension(200,30));
		pd.setForeground(Color.black);
		pd.setFont(new Font("Poppins",Font.PLAIN,18));
		
		
		JLabel lab3 = new JLabel ();
		lab3.setText("Password");
		lab3.setFont(new Font("Poppins",Font.PLAIN,15));
		lab3.setForeground(Color.white);
		
		JPanel panel3 = new JPanel();
		panel3.setBounds(150,200,200,25);
		panel3.setBackground(new Color(0x1e2329));
		panel3.add(lab3);
		
		JPanel panel4 = new JPanel();
		panel4.setBounds(150,235,200,30);
		panel4.setBackground(new Color(0x1e2329));
		panel4.add(pd);
		panel4.setBorder(null);
		panel4.add(pd);
		
		button = new JButton();
		button.setBounds(200,300,100,40);
		button.setBackground(new Color (0xf4b301));
		button.setFont(new Font("Poppins",Font.BOLD,20));
		button.setText("Login");
		button.setForeground(new Color(0x1e2329));
		
		JLabel lab4=new JLabel("Don t have an account?",SwingConstants.CENTER);
		lab4.setForeground(Color.white);
		lab4.setFont(new Font("Poppins",Font.PLAIN,14));
		
		button1=new JButton();
		button1.setText("Signup");
		button1.setFont(new Font("Poppins",Font.BOLD,15));
		button1.setForeground(Color.white);
		button1.setBackground(new Color(0x1e2329));
		button1.setBorder(null);
		button1.addActionListener(this);
		
		JPanel panel5=new JPanel();
		panel5.setBounds(50,355,400,40);
		panel5.setBackground(new Color(0x1e2329));
		panel5.add(lab4);
		panel5.add(button1);
		
		
		
		
		
		
		this.setTitle("Login form");
		this.setBounds(250,50,1024,768);
		this.getContentPane().setBackground(new Color(0x2a2f35));
		this.setVisible(true);
		this.setLayout(null);
		this.add(mainpanel);
		this.add(icon);
		mainpanel.add(panel);
		mainpanel.add(panel1);
		mainpanel.add(panel2);
		mainpanel.add(panel3);
		mainpanel.add(panel4);
		mainpanel.add(button);
		mainpanel.add(panel5);
		button.addActionListener(this);
		
		
		
	}
	
	public static Connection connect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/projet","root","");
		
	}
	
	public static int check(String username, String password) {
		int y=0;
		
		try {
			Connection c=connect();
			System.out.println("rhgkjfdf");
			PreparedStatement p = c.prepareStatement("select * from users");
			ResultSet r=p.executeQuery();
			while(r.next()) {
				if(r.getString("id").equals(user.getText())) {
					if(r.getString("mdp").equals(pd.getText())){
						y=1;
						
				
						break;
					}
					else {
						y=2;
						break;
					}}
				else {
					y=0;
				}
				}
			c.close();
			
			}
		catch (Exception e) {
			System.out.println(e);
		}
		return y;
		}
	
	
	
	public void actionPerformed(ActionEvent e ) {
		if(e.getSource()==button1) {
			new signup();
			this.dispose();
		}
		if(e.getSource()==button) {
			int y=check(user.getText(),pd.getText());
			if(y==1) {
				this.dispose();
				new manage();
			}
			else if (y==2) {
				JOptionPane.showMessageDialog(null,"Something is wrong","Password",JOptionPane.WARNING_MESSAGE);
				user.setText("");
				pd.setText("");
			}
			else {
				JOptionPane.showMessageDialog(null, "Wrong username","Username",JOptionPane.WARNING_MESSAGE);
				user.setText("");
				pd.setText("");
			}
		}
	
	
		
		
	
	}
	public static void main(String[] args) {
		new new_main();

	}
	
	

}
