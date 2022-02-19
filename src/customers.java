import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Dimension;

public class customers extends JFrame implements ActionListener {

	
	JButton button2;
	JButton button3;
	JTable tab;
	static Object this_id;
	customers() {
		
		JLabel icon = new JLabel();
		
		ImageIcon image = new ImageIcon("RentCar.png");
		
		icon.setIcon(image);
		icon.setBounds(50,15,388,104);
		
		JLabel title = new JLabel();
		title.setText("Customers");
		title.setFont(new Font("Poppins",Font.BOLD,30));
		title.setForeground(new Color(0xf4b301));
		JPanel panel = new JPanel();
		panel.setBounds(260,10,200,50);
		panel.setBackground(new Color(0x1e2329));
		panel.add(title);
		
		JLabel id = new JLabel();
		id.setText("Customer ID");
		id.setFont(new Font("Poppins",Font.PLAIN,15));
		id.setForeground(Color.white);
		JPanel panel2 = new JPanel();
		panel2.setBounds(0,80,150,50);
		panel2.setBackground(new Color(0x1e2329));
		panel2.add(id);
		
		JLabel name = new JLabel();
		name.setText("Name");
		name.setFont(new Font("Poppins",Font.PLAIN,15));
		name.setForeground(Color.white);
		JPanel panel3 = new JPanel();
		panel3.setBounds(170,80,80,50);
		panel3.setBackground(new Color(0x1e2329));
		panel3.add(name);
		
		JLabel address = new JLabel();
		address.setText("Address");
		address.setFont(new Font("Poppins",Font.PLAIN,15));
		address.setForeground(Color.white);
		JPanel panel4 = new JPanel();
		panel4.setBounds(300,80,150,50);
		panel4.setBackground(new Color(0x1e2329));
		panel4.add(address);
		
		JLabel phone = new JLabel();
		phone.setText("Phone");
		phone.setFont(new Font("Poppins",Font.PLAIN,15));
		phone.setForeground(Color.white);
		JPanel panel5 = new JPanel();
		panel5.setBounds(540,80,150,50);
		panel5.setBackground(new Color(0x1e2329));
		panel5.add(phone);
		
		JTextField id1 = new JTextField();
		id1.setPreferredSize(new Dimension(120,25));
		id1.setForeground(Color.black);
		id1.setFont(new Font("Poppins",Font.PLAIN,14));
		JPanel panel6 = new JPanel();
		panel6.setBounds(-10,100,200,30);
		panel6.setBackground(new Color(0x1e2329));
		panel6.add(id1);
		panel6.setBorder(null);
		
		JTextField name1 = new JTextField();
		name1.setPreferredSize(new Dimension(120,25));
		name1.setForeground(Color.black);
		name1.setFont(new Font("Poppins",Font.PLAIN,14));
		JPanel panel7 = new JPanel();
		panel7.setBounds(148,100,200,30);
		panel7.setBackground(new Color(0x1e2329));
		panel7.add(name1);
		panel7.setBorder(null);
		
		JTextField address1 = new JTextField();
		address1.setPreferredSize(new Dimension(200,25));
		address1.setForeground(Color.black);
		address1.setFont(new Font("Poppins",Font.PLAIN,14));
		JPanel panel8 = new JPanel();
		panel8.setBounds(305,100,280,30);
		panel8.setBackground(new Color(0x1e2329));
		panel8.add(address1);
		panel8.setBorder(null);
		
		JTextField phone1 = new JTextField();
		phone1.setPreferredSize(new Dimension(120,25));
		phone1.setForeground(Color.black);
		phone1.setFont(new Font("Poppins",Font.PLAIN,14));
		JPanel panel9 = new JPanel();
		panel9.setBounds(550,100,200,30);
		panel9.setBackground(new Color(0x1e2329));
		panel9.add(phone1);
		panel9.setBorder(null);
		
		JButton button = new JButton();
		button.setBounds(160,160,100,30);
		button.setBackground(new Color (0xf4b301));
		button.setFont(new Font("Poppins",Font.BOLD,17));
		button.setText("Save");
		button.setForeground(new Color(0x1e2329));
		
		JButton buttonn = new JButton();
		buttonn.setBounds(270,160,100,30);
		buttonn.setBackground(new Color (0xf4b301));
		buttonn.setFont(new Font("Poppins",Font.BOLD,17));
		buttonn.setText("Delete");
		buttonn.setForeground(new Color(0x1e2329));
		
		JButton buttonnn = new JButton();
		buttonnn.setBounds(380,160,120,30);
		buttonnn.setBackground(new Color (0xf4b301));
		buttonnn.setFont(new Font("Poppins",Font.BOLD,17));
		buttonnn.setText("Facture");
		buttonnn.setForeground(new Color(0x1e2329));
		
		

		String data[][]={ {"101","Amit","Commercial Street","51324897"},};    
	    String column[]={"CustID","Name","Address","Phone"};        
	    
		/*tab.setBounds(20,300,700,150);
		tab.setBackground(new Color(0x2a2f35));
		tab.setForeground(Color.white);
		tab.setFont(new Font("Poppins",Font.PLAIN,15));*/
		        
	    tab =new JTable(data,column);   
	    final Object[] row = new Object[4];
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(20,300,700,200);
	    
		//tab.setBounds(20,350,700,50);
		tab.setBackground(new Color(0x2a2f35));
		tab.setForeground(Color.white);
		tab.setFont(new Font("Poppins",Font.PLAIN,15));
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		tab.setModel(model);
		scrollPane.setViewportView(tab);
		
		buttonn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent arg0) {
				int i=tab.getSelectedRow();
				this_id=tab.getValueAt(i,0);
				if (i>=0) {
					deletedata();
					model.removeRow(i);
					JOptionPane.showMessageDialog(null,"deleted successfully");
				}
				else {
					JOptionPane.showMessageDialog(null,"Select a row first");
				}
				
				
			}
		});
		
		buttonnn.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent arg0) {
				int i=tab.getSelectedRow();
				this_id=tab.getValueAt(i,0);
				if (i>=0) {
					new facture();
					System.out.println(this_id.getClass());
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet","root","");
						Statement s = c.createStatement(); 
						String sql2 = "SELECT C.custid,C.name,C.address,C.phone,sum(fee) s FROM CUSTOMERS C, RENTBOOK R where C.name=R.custname and C.custid="+Integer.parseInt((String) this_id)+" and R.status='Rent' group by C.name;";
						ResultSet rs = s.executeQuery(sql2);
						
						while (rs.next()) {
							String s1 = rs.getString("custid");
							String s2 = rs.getString("name");
							String s3 = rs.getString("address");
							String s4 = rs.getString("phone");
							String s5 = String.valueOf(rs.getInt("s"));
							facture.lab22.setText(s1);
							facture.lab33.setText(s2);
							facture.lab44.setText(s3);
							facture.lab55.setText(s4);
							facture.lab77.setText(s5);
						}
				}
					catch(Exception e) {
						
					}}
				else {
					JOptionPane.showMessageDialog(null,"Select a row first");
				}
				
				
			}
		});
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet","root","");
		Statement s = c.createStatement(); 
		String sql2 = "SELECT * FROM CUSTOMERS";
		ResultSet rs = s.executeQuery(sql2);
		
		while (rs.next()) {
			String s1 = rs.getString("custid");
			String s2 = rs.getString("name");
			String s3 = rs.getString("address");
			String s4 = rs.getString("phone");
			
			String data1[] = {s1,s2,s3,s4};
			model.addRow(data1);
		}
		
		}
		catch (Exception e2) {
			
		}
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (id1.getText().equals("") || address1.getText().equals("") || name1.getText().equals("") || phone1.getText().equals("") ) {
					JOptionPane.showMessageDialog(null,"Please fill complete information !");
				}
				else {
					row[0] = id1.getText();
					row[1] = name1.getText();
					row[2] = address1.getText();
					row[3] = phone1.getText();
					
					try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet","root","");
					Statement s = c.createStatement(); 
					String sql1 = "SELECT * FROM CUSTOMERS WHERE custid='"+row[0]+"'";
					ResultSet r = s.executeQuery(sql1);
					
					
					if (r.next()) {
						JOptionPane.showMessageDialog(null,"Row already exists !");
						id1.setText("");
						name1.setText("");
						address1.setText("");
						phone1.setText("");
					}
					
					else {
					
						model.addRow(row);
						id1.setText("");
						name1.setText("");
						address1.setText("");
						phone1.setText("");
						//JOptionPane.showMessageDialog(null,"Row added !");
						
						try {
						
							//Class.forName("com.mysql.jdbc.Driver");
							//Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet","root","");
							System.out.println("Connected");
							String sql = "INSERT INTO CUSTOMERS VALUES ('"+row[0]+"','"+row[1].toString()+"','"+row[2].toString()+"','"+row[3]+"')";
							s = c.prepareStatement(sql);
							System.out.println("Statement created");
							
							System.out.println("Query correct");
							s.executeUpdate(sql);
							System.out.println("Inserted");
							c.close();
							JOptionPane.showMessageDialog(null,"Row added !");
						}
						catch (Exception e) {
							
						}
					}
				}
				
				catch(Exception e) {
					
				}
				}
			}
		});
		/*JLabel labb1 = new JLabel("CustID");
		labb1.setBounds(20,180,150,200);
		labb1.setForeground(new Color (0xf4b301));
		labb1.setFont(new Font("Poppins",Font.PLAIN,18));
		labb1.setBackground(new Color(0x1e2329));
		
		JLabel labb2 = new JLabel("Name");
		labb2.setBounds(190,180,150,200);
		labb2.setForeground(new Color (0xf4b301));
		labb2.setFont(new Font("Poppins",Font.PLAIN,18));
		labb2.setBackground(new Color(0x1e2329));
		
		JLabel labb3 = new JLabel("Address");
		labb3.setBounds(370,180,150,200);
		labb3.setForeground(new Color (0xf4b301));
		labb3.setFont(new Font("Poppins",Font.PLAIN,18));
		labb3.setBackground(new Color(0x1e2329));
		
		JLabel labb4 = new JLabel("Phone");
		labb4.setBounds(540,180,150,200);
		labb4.setForeground(new Color (0xf4b301));
		labb4.setFont(new Font("Poppins",Font.PLAIN,18));
		labb4.setBackground(new Color(0x1e2329));*/


		
		JPanel main = new JPanel();
		main.setBounds(230,170,750,520);
		main.setBackground(new Color(0x1e2329));
		main.setLayout(null);
		main.add(panel);
		main.add(panel2);
		main.add(panel3);
		main.add(panel4);
		main.add(panel5);
		main.add(panel6);
		main.add(panel7);
		main.add(panel8);
		main.add(panel9);
		main.add(button);
		main.add(buttonn);
		main.add(buttonnn);
		/*main.add(labb1);
		main.add(labb2);
		main.add(labb3);
		main.add(labb4);*/
		main.add(scrollPane);
		
		JButton button1=new JButton();
		button1.setText("Customers");
		button1.setFont(new Font("Poppins",Font.BOLD,18));
		button1.setForeground(new Color(0x848483));
		button1.setBackground(new Color(0x1e2329));
		button1.setBounds(15,100,115,30);
		button1.setBorder(null);
		//button1.addActionListener(this);
		
		button2=new JButton();
		button2.setText("Manage Cars");
		button2.setFont(new Font("Poppins",Font.BOLD,18));
		button2.setForeground(new Color(0xf4b301));
		button2.setBackground(new Color(0x1e2329));
		button2.setBounds(15,50,130,30);
		button2.setBorder(null);
		button2.addActionListener(this);
		
		
		
		
		
		button3=new JButton();
		button3.setText("Rent/Book Car");
		button3.setFont(new Font("Poppins",Font.BOLD,18));
		button3.setForeground(new Color(0xf4b301));
		button3.setBackground(new Color(0x1e2329));
		button3.setBounds(15,150,140,30);
		button3.setBorder(null);
		button3.addActionListener(this);
		
		JPanel opt = new JPanel();
		opt.setBounds(30,170,180,520);
		opt.setBackground(new Color(0x1e2329));
		opt.setLayout(null);
		opt.add(button1);
		opt.add(button2);
		opt.add(button3);
		
		
		
		this.setTitle("Customers");
		this.setBounds(250,50,1024,768);
		this.getContentPane().setBackground(new Color(0x2a2f35));
		this.setVisible(true);
		this.setLayout(null);
		this.add(main);
		this.add(opt);
		this.add(icon);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button3) {
			new rentbook();
			this.dispose();
		}

		if(e.getSource()==button2) {
			new manage();
			this.dispose();
		}}
		
		
		/*if(e.getSource()==button2) {
			new manage();
			this.dispose();
		}}*/
		public static Connection connect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/projet","root","");
		
		}
		public static void deletedata() {
		
		try {
			String sql="DELETE FROM clients WHERE custid ='"+this_id+"'";
			Connection c=connect();
			System.out.println("rhgkjfdf");
			Statement p = c.prepareStatement(sql);
			p.execute(sql);
			System.out.println("deleted");
		}
		catch(SQLException se){
			se.printStackTrace();			
		}
		catch (Exception e ) {
			e.printStackTrace();
		}
	}
	
}

