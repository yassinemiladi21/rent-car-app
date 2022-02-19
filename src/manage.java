import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.sql.*;

public class manage extends JFrame implements ActionListener{
	
	JButton b1;
	JButton b2;
	JButton b3;
	JButton save;
	JButton delete;
	static JTextField t1;
	JTextField t2;
	JTextField t3;
	JComboBox t4;
	JTextField t5;
	JScrollPane scrollpane;
	DefaultTableModel model;
	Object[] row = new Object[5];
	Object[] column ={"RegNum","Brand","Model","Status","Price"};
	static Object this_id;
	JTable tab ;
	
	manage(){
		JLabel icon = new JLabel();
		ImageIcon image = new ImageIcon("RentCar.png");
		
		icon.setIcon(image);
		icon.setBounds(50,15,388,104);
		
		JPanel menu= new JPanel();
		menu.setBounds(30,140,210,540);
		menu.setBackground(new Color(0x1e2329));
		menu.setLayout(null);
		
		JPanel mainpanel= new JPanel();
		mainpanel.setBounds(250,140,740,540);
		mainpanel.setBackground(new Color(0x1e2329));
		mainpanel.setLayout(null);
		
		b1=new JButton();
		b2=new JButton();
		b3=new JButton();
		
		b1.setBounds(10,40,200,50);
		b1.setText("Manage Cars");
		b1.setForeground(Color.gray);
		b1.setBackground(new Color(0x1e2329));
		b1.setFont(new Font ("Poppins",Font.BOLD,20));
		b1.setBorderPainted(false);
		b1.setBorder(null);
		b1.setHorizontalAlignment(SwingConstants.LEFT);
		
		b2.setBounds(10,90,200,50);
		b2.setText("Customers");
		b2.setForeground(new Color (0xf4b301));
		b2.setBackground(new Color(0x1e2329));
		b2.setFont(new Font ("Poppins",Font.BOLD,20));
		b2.setBorderPainted(false);
		b2.setBorder(null);
		b2.setHorizontalAlignment(SwingConstants.LEFT);
		b2.addActionListener(this);
		
		b3.setBounds(10,140,200,50);
		b3.setText("Rent/Book Car");
		b3.setForeground(new Color (0xf4b301));
		b3.setBackground(new Color(0x1e2329));
		b3.setFont(new Font ("Poppins",Font.BOLD,20));
		b3.setBorderPainted(false);
		b3.setBorder(null);
		b3.setHorizontalAlignment(SwingConstants.LEFT);
		b3.addActionListener(this);
		
		JLabel lab1=new JLabel();
		lab1.setHorizontalAlignment(SwingConstants.CENTER);
		lab1.setText("Manage Cars");
		lab1.setForeground(new Color (0xf4b301));
		lab1.setFont(new Font("Poppins",Font.BOLD,27));
		lab1.setBounds(-15,10,800,70);
		
		JLabel lab2 = new JLabel();
		lab2.setBounds(59,100,150,20);
		lab2.setText("Registration Num");
		lab2.setForeground(Color.white);
		lab2.setFont(new Font("Poppins",Font.BOLD,15));
		
		t1=new JTextField();
		t1.setBounds(45,125,150,25);
		t1.setFont(new Font ("Poppins",Font.PLAIN,18));
		t1.setForeground(Color.black);
		
		JLabel lab3 = new JLabel();
		lab3.setBounds(345,100,150,20);
		lab3.setText("Brand");
		lab3.setForeground(Color.white);
		lab3.setFont(new Font("Poppins",Font.BOLD,15));
		
		t2 =new JTextField();
		t2.setBounds(290,125,150,25);
		t2.setFont(new Font ("Poppins",Font.PLAIN,18));
		t2.setForeground(Color.black);
		
		JLabel lab4 = new JLabel();
		lab4.setBounds(580,100,150,20);
		lab4.setText("Model");
		lab4.setForeground(Color.white);
		lab4.setFont(new Font("Poppins",Font.BOLD,15));
		
		t3 =new JTextField();
		t3.setBounds(535,125,150,25);
		t3.setFont(new Font ("Poppins",Font.PLAIN,18));
		t3.setForeground(Color.black);
		
		JLabel lab5 = new JLabel();
		lab5.setBounds(210,170,150,20);
		lab5.setText("Status");
		lab5.setForeground(Color.white);
		lab5.setFont(new Font("Poppins",Font.BOLD,15));
		
		String[] status = {"Available","Booked","Rent"};
		t4 =new JComboBox(status);
		t4.setBounds(170,190,138,25);
		
		JLabel lab6 = new JLabel();
		lab6.setBounds(470,170,150,20);
		lab6.setText("Price");
		lab6.setForeground(Color.white);
		lab6.setFont(new Font("Poppins",Font.BOLD,15));
		
		t5 =new JTextField();
		t5.setBounds(420,190,150,25);
		t5.setFont(new Font ("Poppins",Font.PLAIN,18));
		t5.setForeground(Color.black);
		
		save=new JButton("Save");
		save.setBounds(240,250,100,30);
		save.setBackground(new Color (0xf4b301));
		save.setForeground(Color.black);
		save.setFont(new Font ("Poppins",Font.PLAIN,18));
		
		delete=new JButton("Delete");
		delete.setBounds(350,250,100,30);
		delete.setBackground(new Color (0xf4b301));
		delete.setForeground(Color.black);
		delete.setFont(new Font ("Poppins",Font.PLAIN,18));
		
		String data[][]={ {"101","Amit","670000","1111","555"},};    
	    String column[]={"RegNum","Brand","Model","Status","Price"};         
	    JTable tab =new JTable(data,column);   
	    final Object[] row = new Object[5];
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(20,315,700,200);
	    
		//tab.setBounds(20,350,700,50);
		tab.setBackground(new Color(0x2a2f35));
		tab.setForeground(Color.white);
		tab.setFont(new Font("Poppins",Font.PLAIN,15));
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(column);
		tab.setModel(model);
		scrollPane.setViewportView(tab);
		/*tab.getTableHeader().setForeground(new Color(0xf4b301))	;
		tab.getTableHeader().setOpaque(false);
		tab.getTableHeader().setBackground(new Color(0x1e2329));*/
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet","root","");
		Statement s = c.createStatement(); 
		String sql2 = "SELECT * FROM CARS";
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
		
		}
		catch (Exception e2) {
			
		}
		
		delete.addActionListener(new ActionListener() {
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
		
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (t1.getText().equals("") || t2.getText().equals("") || t2.getText().equals("") || t3.getText().equals("") || t5.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Please fill complete information !");
				}
				else {
					row[0] = t1.getText();
					row[1] = t2.getText();
					row[2] = t3.getText();
					row[3] = t4.getSelectedItem();
					row[4] = t5.getText();
					
					try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet","root","");
					Statement s = c.createStatement(); 
					String sql1 = "SELECT * FROM CARS WHERE regnum='"+row[0].toString()+"'";
					ResultSet r = s.executeQuery(sql1);
					
					
					if (r.next()) {
						JOptionPane.showMessageDialog(null,"Row already exists !");
						t1.setText("");
						t2.setText("");
						t3.setText("");
						t5.setText("");
					}
					
					else {
					
						model.addRow(row);
						t1.setText("");
						t2.setText("");
						t3.setText("");
						t5.setText("");
						//JOptionPane.showMessageDialog(null,"Row added !");
						
						try {
						
							//Class.forName("com.mysql.jdbc.Driver");
							//Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet","root","");
							System.out.println("Connected");
							String sql = "INSERT INTO CARS VALUES ('"+row[0].toString()+"','"+row[1].toString()+"','"+row[2].toString()+"','"+row[3].toString()+"','"+row[4].toString()+"')";
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
		
		/*
		JLabel labb1 = new JLabel("RegNum");
		labb1.setBounds(20,230,150,200);
		labb1.setForeground(new Color (0xf4b301));
		labb1.setFont(new Font("Poppins",Font.PLAIN,18));
		labb1.setBackground(new Color(0x1e2329));
		
		JLabel labb2 = new JLabel("Brand");
		labb2.setBounds(170,230,150,200);
		labb2.setForeground(new Color (0xf4b301));
		labb2.setFont(new Font("Poppins",Font.PLAIN,18));
		labb2.setBackground(new Color(0x1e2329));
		
		JLabel labb3 = new JLabel("Model");
		labb3.setBounds(300,230,150,200);
		labb3.setForeground(new Color (0xf4b301));
		labb3.setFont(new Font("Poppins",Font.PLAIN,18));
		labb3.setBackground(new Color(0x1e2329));
		
		JLabel labb4 = new JLabel("Status");
		labb4.setBounds(450,230,150,200);
		labb4.setForeground(new Color (0xf4b301));
		labb4.setFont(new Font("Poppins",Font.PLAIN,18));
		labb4.setBackground(new Color(0x1e2329));
		
		JLabel labb5 = new JLabel("Price");
		labb5.setBounds(590,230,150,200);
		labb5.setForeground(new Color (0xf4b301));
		labb5.setFont(new Font("Poppins",Font.PLAIN,18));
		labb5.setBackground(new Color(0x1e2329));
		*/
		
		this.setTitle("Manage Cars");
		this.setBounds(250,50,1024,768);
		this.getContentPane().setBackground(new Color(0x2a2f35));
		this.setVisible(true);
		this.setLayout(null);
		this.add(icon);
		this.add(menu);
		this.add(mainpanel);
		menu.add(b1);
		menu.add(b2);
		menu.add(b3);
		mainpanel.add(lab1);
		mainpanel.add(lab2);
		mainpanel.add(t1);
		mainpanel.add(lab3);
		mainpanel.add(t2);
		mainpanel.add(lab4);
		mainpanel.add(t3);
		mainpanel.add(t4);
		mainpanel.add(lab5);
		mainpanel.add(lab6);
		mainpanel.add(t5);
		mainpanel.add(save);
		mainpanel.add(delete);
		/*mainpanel.add(labb1);
		mainpanel.add(labb2);
		mainpanel.add(labb3);
		mainpanel.add(labb4);
		mainpanel.add(labb5);*/
		mainpanel.add(scrollPane);
		
	}
		
		
	public static Connection connect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/projet","root","");
		
	}
	public static void deletedata() {
		
		try {
			String sql="DELETE FROM cars WHERE regnum ='"+this_id+"'";
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
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b3) {
			new rentbook();
			this.dispose();
		}

		if(e.getSource()==b2) {
			new customers();
			this.dispose();
		}
		
		}

	
}



