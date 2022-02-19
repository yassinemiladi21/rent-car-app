import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class signup extends JFrame implements ActionListener{
	
	 JPanel mainpanel;
	 JButton button1;

	signup() {
		
		
		JLabel icon = new JLabel();
		
		ImageIcon image = new ImageIcon("RentCar.png");
		
		icon.setIcon(image);
		icon.setBounds(50,15,388,104);
		
		mainpanel = new JPanel();
		mainpanel.setBounds(260,200,500,410);
		mainpanel.setBackground(new Color(0x1e2329));
		mainpanel.setLayout(null);
		
		
		JLabel lab = new JLabel ();
		lab.setText("Sign Up");
		lab.setFont(new Font("Poppins",Font.PLAIN,35));
		lab.setForeground(Color.white);
		
		

		
		JLabel lab2 = new JLabel ();
		lab2.setText("Username");
		lab2.setFont(new Font("Poppins",Font.PLAIN,15));
		//lab.setCursor(new Color(166,48,85));
		lab2.setForeground(Color.white);
		

		JPanel panel = new JPanel();
		panel.setBounds(150,0,200,70);
		panel.setBackground(new Color(0x1e2329));
		panel.add(lab);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(150,90,200,25);
		panel1.setBackground(new Color(0x1e2329));
		panel1.add(lab2);

		JTextField user = new JTextField();
		user.setPreferredSize(new Dimension(200,30));
		user.setForeground(Color.black);
		user.setFont(new Font("Poppins",Font.PLAIN,18));
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(150,115,200,30);
		panel2.setBackground(new Color(0x1e2329));
		panel2.add(user);
		panel2.setBorder(null);
		
		JPasswordField pd = new JPasswordField();
		pd.setPreferredSize(new Dimension(200,30));
		pd.setForeground(Color.black);
		pd.setFont(new Font("Poppins",Font.PLAIN,18));
		
		
		JLabel lab3 = new JLabel ();
		lab3.setText("Password");
		lab3.setFont(new Font("Poppins",Font.PLAIN,15));
		lab3.setForeground(Color.white);
		
		JPanel panel3 = new JPanel();
		panel3.setBounds(150,155,200,30);
		panel3.setBackground(new Color(0x1e2329));
		panel3.add(lab3);
		
		JPanel panel4 = new JPanel();
		panel4.setBounds(150,180,200,30);
		panel4.setBackground(new Color(0x1e2329));
		panel4.add(pd);
		panel4.setBorder(null);
		
		
		JPasswordField pd2 = new JPasswordField();
		pd2.setPreferredSize(new Dimension(200,30));
		pd2.setForeground(Color.black);
		pd2.setFont(new Font("Poppins",Font.PLAIN,18));
		
		
		JLabel lab32 = new JLabel ();
		lab32.setText("Confirm Password");
		lab32.setFont(new Font("Poppins",Font.PLAIN,15));
		lab32.setForeground(Color.white);
		
		JPanel panel32 = new JPanel();
		panel32.setBounds(150,215,200,30);
		panel32.setBackground(new Color(0x1e2329));
		panel32.add(lab32);
		
		JPanel panel42 = new JPanel();
		panel42.setBounds(150,240,200,30);
		panel42.setBackground(new Color(0x1e2329));
		panel42.add(pd2);
		panel42.setBorder(null);
		
		JButton button = new JButton();
		button.setBounds(200,300,100,40);
		button.setBackground(new Color (0xf4b301));
		button.setFont(new Font("Poppins",Font.BOLD,17));
		button.setText("SignUp");
		button.setForeground(new Color(0x1e2329));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (pd.getText().equals("") || pd2.getText().equals("") || user.getText().equals("") ) {
					JOptionPane.showMessageDialog(null,"Please fill complete information !");
				}
				else if (!pd.getText().equals(pd2.getText()) ){
					JOptionPane.showMessageDialog(null,"Confirm your password correctly ");}
				else {
					
					try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet","root","");
					Statement s = c.createStatement(); 
					//String sql1 = "INSERT INTO users VALUES("+ user+","+pd")";
					ResultSet r = s.executeQuery("SELECT * FROM users WHERE id='"+user+"'");
					
					
					if (r.next()) {
						JOptionPane.showMessageDialog(null,"User already exists !");
						user.setText("");
						pd.setText("");
						pd2.setText("");
					}
						
						try {
						
							//Class.forName("com.mysql.jdbc.Driver");
							//Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet","root","");
							System.out.println("Connected");
							String sql = "INSERT INTO users VALUES ('"+user.getText()+"','"+pd.getText()+"')";
							s = c.prepareStatement(sql);
							System.out.println("Statement created");
							
							System.out.println("Query correct");
							s.executeUpdate(sql);
							System.out.println("Inserted");
							c.close();
							JOptionPane.showMessageDialog(null,"U have an account now !");
							new new_main();
							
						}
						catch (Exception e) {
							
						}
					}catch (Exception e) {
						
					}
				}
				
				
			}
		});
		
		
		JLabel lab4=new JLabel("Already have an account?",SwingConstants.CENTER);
		lab4.setForeground(Color.white);
		lab4.setFont(new Font("Poppins",Font.PLAIN,14));
		
		button1=new JButton();
		button1.setText("Login");
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
		mainpanel.add(panel32);
		mainpanel.add(panel42);
		mainpanel.add(button);
		mainpanel.add(panel5);
		
	

		
	
	}
		public void actionPerformed(ActionEvent e ) {
				if(e.getSource()==button1) {
					new new_main ();
		this.dispose();
	}
}

}