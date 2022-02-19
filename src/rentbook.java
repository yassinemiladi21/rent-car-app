import java.awt.*;

import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.*;

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


public class rentbook extends JFrame implements ActionListener {

	JButton button1;
	JButton button2;
	String value;
	static Object this_id;
	DefaultTableModel model;
	rentbook() {
		
JLabel icon = new JLabel();
		
		ImageIcon image = new ImageIcon("RentCar.png");
		
		icon.setIcon(image);
		icon.setBounds(50,15,388,104);
		
		JLabel title = new JLabel();
		title.setText("Rent/Book Car");
		title.setFont(new Font("Poppins",Font.BOLD,30));
		title.setForeground(new Color(0xf4b301));
		JPanel panel = new JPanel();
		panel.setBounds(260,10,230,50);
		panel.setBackground(new Color(0x1e2329));
		panel.add(title);
		
		
		JLabel id = new JLabel();
		id.setText("RentID");
		id.setFont(new Font("Poppins",Font.BOLD,13));
		id.setForeground(Color.white);
		JPanel panel2 = new JPanel();
		panel2.setBounds(10,80,80,50);
		panel2.setBackground(new Color(0x1e2329));
		panel2.add(id);
		
		JLabel reg = new JLabel();
		reg.setText("Registration");
		reg.setFont(new Font("Poppins",Font.BOLD,13));
		reg.setForeground(Color.white);
		JPanel panel3 = new JPanel();
		panel3.setBounds(60,80,170,50);
		panel3.setBackground(new Color(0x1e2329));
		panel3.add(reg);
		
		
		
		JLabel name = new JLabel();
		name.setText("Customer Name");
		name.setFont(new Font("Poppins",Font.BOLD,13));
		name.setForeground(Color.white);
		JPanel panel4 = new JPanel();
		panel4.setBounds(220,80,170,20);
		panel4.setBackground(new Color(0x1e2329));
		panel4.add(name);
		
		JLabel rent = new JLabel();
		rent.setText("Rent Date");
		rent.setFont(new Font("Poppins",Font.BOLD,13));
		rent.setForeground(Color.white);
		JPanel panel5 = new JPanel();
		panel5.setBounds(375,80,100,50);
		panel5.setBackground(new Color(0x1e2329));
		panel5.add(rent);
		
		JLabel returnd = new JLabel();
		returnd.setText("Return Date");
		returnd.setFont(new Font("Poppins",Font.BOLD,13));
		returnd.setForeground(Color.white);
		JPanel panel6 = new JPanel();
		panel6.setBounds(500,80,100,50);
		panel6.setBackground(new Color(0x1e2329));
		panel6.add(returnd);
		
		JLabel fees = new JLabel();
		fees.setText("Fees");
		fees.setFont(new Font("Poppins",Font.BOLD,13));
		fees.setForeground(Color.white);
		JPanel panel7 = new JPanel();
		panel7.setBounds(610,80,80,50);
		panel7.setBackground(new Color(0x1e2329));
		panel7.add(fees);
		
		
		JTextField id1 = new JTextField();
		id1.setPreferredSize(new Dimension(50,22));
		id1.setForeground(Color.black);
		id1.setFont(new Font("Poppins",Font.PLAIN,14));
		JPanel panel8 = new JPanel();
		panel8.setBounds(-46,100,200,30);
		panel8.setBackground(new Color(0x1e2329));
		panel8.add(id1);
		panel8.setBorder(null);
		
		JTextField reg1 = new JTextField();
		//reg1.setEditable(false);
		reg1.setPreferredSize(new Dimension(120,22));
		reg1.setForeground(Color.black);
		reg1.setFont(new Font("Poppins",Font.PLAIN,14));
		JPanel panel9 = new JPanel();
		panel9.setBounds(90,100,150,30);
		panel9.setBackground(new Color(0x1e2329));
		panel9.add(reg1);
		panel9.setBorder(null);
		
		//String[] status = {"Available","Booked","Rent"};
		JComboBox name1 = new JComboBox();
		name1.setBounds(250,105,120,25);
		name1.setForeground(Color.black);
		name1.setFont(new Font("Poppins",Font.PLAIN,14));
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet","root","");
			Statement s = c.createStatement(); 
			String sql2 = "SELECT * FROM CUSTOMERS";
			ResultSet rs = s.executeQuery(sql2);
			
			while (rs.next()) {
				String s1 = rs.getString("name");
				name1.addItem(s1);
			}
			c.close();
			}
			catch (Exception e3) {
				
			}

		
		JTextField rentdate = new JTextField();
		rentdate.setPreferredSize(new Dimension(100,22));
		rentdate.setForeground(Color.black);
		rentdate.setFont(new Font("Poppins",Font.PLAIN,14));
		JPanel panel11 = new JPanel();
		panel11.setBounds(390,100,100,30);
		panel11.setBackground(new Color(0x1e2329));
		panel11.add(rentdate);
		panel11.setBorder(null);
		
		JTextField returndate = new JTextField();
		returndate.setPreferredSize(new Dimension(100,22));
		returndate.setForeground(Color.black);
		returndate.setFont(new Font("Poppins",Font.PLAIN,14));
		JPanel panel12 = new JPanel();
		panel12.setBounds(460,100,200,30);
		panel12.setBackground(new Color(0x1e2329));
		panel12.add(returndate);
		panel12.setBorder(null);
		
		JTextField fees1 = new JTextField();
		fees1.setPreferredSize(new Dimension(80,22));
		fees1.setForeground(Color.black);
		fees1.setFont(new Font("Poppins",Font.PLAIN,14));
		JPanel panel13 = new JPanel();
		panel13.setBounds(575,100,200,30);
		panel13.setBackground(new Color(0x1e2329));
		panel13.add(fees1);
		panel13.setBorder(null);
		
		JButton button = new JButton();
		button.setBounds(220,150,80,25);
		button.setBackground(new Color (0xf4b301));
		button.setFont(new Font("Poppins",Font.BOLD,17));
		button.setText("Rent");
		button.setForeground(new Color(0x1e2329));
		
		JButton buttonn = new JButton();
		buttonn.setBounds(310,150,80,25);
		buttonn.setBackground(new Color (0xf4b301));
		buttonn.setFont(new Font("Poppins",Font.BOLD,17));
		buttonn.setText("Book");
		buttonn.setForeground(new Color(0x1e2329));
		
		JButton delete = new JButton();
		delete.setBounds(400,150,90,25);
		delete.setBackground(new Color (0xf4b301));
		delete.setFont(new Font("Poppins",Font.BOLD,17));
		delete.setText("Delete");
		delete.setForeground(new Color(0x1e2329));
		
		String data[][]={ {"101","Amit","670000","1111","555"},};    
	    String column[]={"RegNum","Brand","Model","Status","Price"};         
	    JTable tab =new JTable(data,column);   
	    final Object[] row = new Object[5];
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(22,200,700,130);
	    
		tab.setBounds(60,235,620,90);
		tab.setBackground(new Color(0x2a2f35));
		tab.setForeground(Color.white);
		tab.setFont(new Font("Poppins",Font.PLAIN,15));
		model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		tab.setModel(model);
		scrollPane.setViewportView(tab);
		
		/*
		button.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent arg0) {
				int i=tab.getSelectedRow();
				value=tab.getValueAt(i,0).toString();
				reg1.setText(value);
				if (i>=0) {
					System.out.println(value);
					
					JOptionPane.showMessageDialog(null,"deleted successfully");
				}
				else {
					JOptionPane.showMessageDialog(null,"Select a row first");
				}
				
				
			}
		});*/
		
		
		//reg1.setText(a.toString());
		/*
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet","root","");
			Statement s = c.createStatement(); 
			String sql2 = "SELECT * FROM CARS WHERE status='Available'";
			ResultSet rs = s.executeQuery(sql2);
			
			while (rs.next()) {
				String s1 = rs.getString("regnum");
				String s2 = rs.getString("brand");
				String s3 = rs.getString("model");
				String s4 = rs.getString("status");
				String s5 = rs.getString("price");
				
				String data1[] = {s1,s2,s3,s4,s5};
				model.addRow(data1);
			}
			c.close();
			
			}
			catch (Exception e2) {
				
			}
		*/
		setcar();

		
		
		
		String data2[][]={ {"2","KM64651","Amit","Booked","12/03/2020","30/03/2020","985"}, {"3","KM64651","Amit","Rent","12/03/2020","30/03/2020","585"}};    
	    String column2[]={"RentID","CarReg","CustName","Status","RentDate","ReturnDate","Fee"};         
	    JTable tab2 =new JTable(data2,column2); 
	    final Object[] row2 = new Object[7];
	    JScrollPane scrollPane2 = new JScrollPane();
	    scrollPane2.setBounds(22,360,700,130);
	    
		tab2.setBounds(60,500,620,90);
		tab2.setBackground(new Color(0x2a2f35));
		tab2.setForeground(Color.white);
		tab2.setFont(new Font("Poppins",Font.PLAIN,12));
		DefaultTableModel model2 = new DefaultTableModel();
		model2.setColumnIdentifiers(column2);
		tab2.setModel(model2);
		scrollPane2.setViewportView(tab2);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet","root","");
			Statement s = c.createStatement(); 
			String sql2 = "SELECT * FROM rentbook";
			ResultSet rs = s.executeQuery(sql2);
			
			while (rs.next()) {
				String s1 = rs.getString("rentid");
				String s2 = rs.getString("carreg");
				String s3 = rs.getString("custname");
				String s4 = rs.getString("status");
				String s5 = rs.getString("rentdate");
				String s6 = rs.getString("returndate");
				String s7 = rs.getString("fee");
				
				String data3[] = {s1,s2,s3,s4,s5,s6,s7};
				model2.addRow(data3);
			}
			c.close();
			
			}
			catch (Exception e2) {
				
			}
		
		delete.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent arg0) {
				int i=tab2.getSelectedRow();
				this_id=tab2.getValueAt(i,0);
				Object this_car=tab2.getValueAt(i,1);
				
				if (i>=0) {
					try {
					Connection c = connect();
					String sqll = "UPDATE cars SET status='Available' WHERE regnum='"+this_car.toString()+"'";
					Statement s = c.prepareStatement(sqll);
					
					System.out.println("Query correct");
					s.executeUpdate(sqll);
					}
					catch (Exception e) {
						
					}
					model.setRowCount(0);
					setcar();
					deletedata();
					model2.removeRow(i);
					JOptionPane.showMessageDialog(null,"deleted successfully");
					
				}
				else {
					JOptionPane.showMessageDialog(null,"Select a row first");
				}
				
				
			}
		});
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (id1.getText().equals("") || reg1.getText().equals("") || rentdate.getText().equals("") || returndate.getText().equals("") || fees1.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Please fill complete information !");
				}
				
				else {
					row2[0] = id1.getText();
					row2[1] = reg1.getText();
					row2[2] = name1.getSelectedItem();
					row2[3] = "Rent";
					row2[4] = rentdate.getText();
					row2[5] = returndate.getText();
					row2[6] = fees1.getText();
					//model2.addRow(row2);
					
					try {
						System.out.println("dkhalna f try");
					Class.forName("com.mysql.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet","root","");
					System.out.println("connecta");

					Statement s = c.createStatement(); 
					String sql1 = "SELECT * FROM rentbook WHERE rentid='"+row2[0].toString()+"'";
					ResultSet r = s.executeQuery(sql1);
					System.out.println("result");
					
					Statement s3 = c.createStatement(); 
					String sql3 = "SELECT * FROM cars WHERE regnum='"+row2[1].toString()+"' AND status='Available'";
					ResultSet r3 = s3.executeQuery(sql3);

					
					
					if (r.next()) {
						JOptionPane.showMessageDialog(null,"Row already exists !");
						id1.setText("");
						reg1.setText("");
						rentdate.setText("");
						returndate.setText("");
						fees1.setText("");
					}
					else if (!(r3.next())) {
						JOptionPane.showMessageDialog(null,"There is no car !");
						id1.setText("");
						reg1.setText("");
						rentdate.setText("");
						returndate.setText("");
						fees1.setText("");
					}
					
					else {
						
						model2.addRow(row2);
						id1.setText("");
						reg1.setText("");
						rentdate.setText("");
						returndate.setText("");
						fees1.setText("");
						
						//JOptionPane.showMessageDialog(null,"Row added !");
						
						try {
			
							//Class.forName("com.mysql.jdbc.Driver");
							//Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet","root","");
							System.out.println("Connected");
							String sql = "INSERT INTO rentbook VALUES ('"+row2[0].toString()+"','"+row2[1].toString()+"','"+name1.getSelectedItem().toString()+"','Rent','"+row2[4].toString()+"','"+row2[5].toString()+"',"+row2[6]+")";
							s = c.prepareStatement(sql);
							System.out.println("Statement created");
							
							System.out.println("Query correct");
							s.executeUpdate(sql);
							System.out.println("Inserted");
							String sqll = "UPDATE cars SET status='Rent' WHERE regnum='"+row2[1].toString()+"'";
							s = c.prepareStatement(sqll);
							
							System.out.println("Query correct");
							s.executeUpdate(sqll);
							System.out.println("updated");
							c.close();
							model.setRowCount(0);
							setcar();
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
		
		buttonn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (id1.getText().equals("") || reg1.getText().equals("") || rentdate.getText().equals("") || returndate.getText().equals("") || fees1.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Please fill complete information !");
				}
				else {
					row2[0] = id1.getText();
					row2[1] = reg1.getText();
					row2[2] = name1.getSelectedItem();
					row2[3] = "Booked";
					row2[4] = rentdate.getText();
					row2[5] = row2[4];
					row2[6] = "0";
					//model2.addRow(row2);
					
					try {
						System.out.println("dkhalna f try");
					Class.forName("com.mysql.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet","root","");
					System.out.println("connecta");

					Statement s = c.createStatement(); 
					String sql1 = "SELECT * FROM rentbook WHERE rentid='"+row2[0].toString()+"'";
					ResultSet r = s.executeQuery(sql1);
					System.out.println("result");
					
					Statement s3 = c.createStatement(); 
					String sql3 = "SELECT * FROM cars WHERE regnum='"+row2[1].toString()+"' AND status='Available'";
					ResultSet r3 = s3.executeQuery(sql3);

					
					
					if (r.next()) {
						JOptionPane.showMessageDialog(null,"Row already exists !");
						id1.setText("");
						reg1.setText("");
						rentdate.setText("");
						returndate.setText("");
						fees1.setText("");
					}
					else if (!(r3.next())) {
						JOptionPane.showMessageDialog(null,"There is no car !");
						id1.setText("");
						reg1.setText("");
						rentdate.setText("");
						returndate.setText("");
						fees1.setText("");
					}
					
					else {
						model.setRowCount(0);
						setcar();
						model2.addRow(row2);
						id1.setText("");
						reg1.setText("");
						rentdate.setText("");
						returndate.setText("");
						fees1.setText("");
						//JOptionPane.showMessageDialog(null,"Row added !");
						
						
						try {
						
							//Class.forName("com.mysql.jdbc.Driver");
							//Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet","root","");
							System.out.println("Connected");
							String sql = "INSERT INTO rentbook VALUES ('"+row2[0].toString()+"','"+row2[1].toString()+"','"+name1.getSelectedItem().toString()+"','Booked','"+row2[4].toString()+"','"+row2[4].toString()+"','0')";
							s = c.prepareStatement(sql);
							System.out.println("Statement created");
							
							System.out.println("Query correct");
							s.executeUpdate(sql);
							System.out.println("Inserted");
							String sqll = "UPDATE cars SET status='Booked' WHERE regnum='"+row2[1].toString()+"'";
							s = c.prepareStatement(sqll);
							
							System.out.println("Query correct");
							s.executeUpdate(sqll);
							System.out.println("updated");
							c.close();
							model.setRowCount(0);
							setcar();
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
		main.add(name1);
		main.add(panel11);
		main.add(panel12);
		main.add(panel13);
		main.add(button);
		main.add(buttonn);
		main.add(delete);
		/*main.add(labb1);
		main.add(labb2);
		main.add(labb3);
		main.add(labb4);
		main.add(labb5);*/
		main.add(scrollPane);
		main.add(scrollPane2);
		




		
		button1=new JButton();
		button1.setText("Customers");
		button1.setFont(new Font("Poppins",Font.BOLD,18));
		button1.setForeground(new Color(0xf4b301));
		button1.setBackground(new Color(0x1e2329));
		button1.setBounds(15,100,115,30);
		button1.setBorder(null);
		button1.addActionListener(this);
		
		button2=new JButton();
		button2.setText("Manage Cars");
		button2.setFont(new Font("Poppins",Font.BOLD,18));
		button2.setForeground(new Color(0xf4b301));
		button2.setBackground(new Color(0x1e2329));
		button2.setBounds(15,50,130,30);
		button2.setBorder(null);
		button2.addActionListener(this);
		
		JButton button3=new JButton();
		button3.setText("Rent/Book Car");
		button3.setFont(new Font("Poppins",Font.BOLD,18));
		button3.setForeground(new Color(0x848483));
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
		
		
		
		this.setTitle("Rent/Book Car");
		this.setBounds(250,50,1024,768);
		this.getContentPane().setBackground(new Color(0x2a2f35));
		this.setVisible(true);
		this.setLayout(null);
		this.add(main);
		this.add(opt);
		this.add(icon);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button2) {
			new manage();
			this.dispose();
		}

		if(e.getSource()==button1) {
			new customers();
			this.dispose();
		}}
	
	public static Connection connect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/projet","root","");
		
	}
	
public static void deletedata() {
		
		try {
			String sql="DELETE FROM rentbook WHERE rentid ='"+this_id+"'";
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

public void setcar() {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet","root","");
		Statement s = c.createStatement(); 
		String sql2 = "SELECT * FROM CARS WHERE status='Available'";
		ResultSet rs = s.executeQuery(sql2);
		
		while (rs.next()) {
			String s1 = rs.getString("regnum");
			String s2 = rs.getString("brand");
			String s3 = rs.getString("model");
			String s4 = rs.getString("status");
			String s5 = rs.getString("price");
			
			String data1[] = {s1,s2,s3,s4,s5};
			
			model.addRow(data1);
		}
		c.close();
		
		}
		catch (Exception e2) {
			
		}
}
	

}
