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


public class facture extends JFrame{
	
	static JLabel lab22;
	static JLabel lab33;
	static JLabel lab44;
	static JLabel lab55;
	static JLabel lab77;
	
	facture() {
		JLabel lab1=new JLabel("Facture");
		lab1.setBounds(107,20,200,50);
		lab1.setFont(new Font("Poppins",Font.BOLD,30));
		lab1.setForeground(new Color(0xf4b301));
		
		JLabel lab2=new JLabel("Customer ID: ");
		lab2.setBounds(30,100,110,20);
		lab2.setFont(new Font("Poppins",Font.BOLD,16));
		lab2.setForeground(Color.white);
		
		lab22=new JLabel();
		lab22.setBounds(150,100,110,20);
		lab22.setFont(new Font("Poppins",Font.PLAIN,16));
		lab22.setForeground(Color.white);
		
		JLabel lab3=new JLabel("Name: ");
		lab3.setBounds(30,150,80,20);
		lab3.setFont(new Font("Poppins",Font.BOLD,16));
		lab3.setForeground(Color.white);
		
		lab33=new JLabel();
		lab33.setBounds(100,150,80,20);
		lab33.setFont(new Font("Poppins",Font.PLAIN,16));
		lab33.setForeground(Color.white);
		
		JLabel lab4=new JLabel("Address: ");
		lab4.setBounds(30,200,80,20);
		lab4.setFont(new Font("Poppins",Font.BOLD,16));
		lab4.setForeground(Color.white);
		
		lab44=new JLabel();
		lab44.setBounds(120,200,150,20);
		lab44.setFont(new Font("Poppins",Font.PLAIN,16));
		lab44.setForeground(Color.white);
		
		JLabel lab5=new JLabel("Phone: ");
		lab5.setBounds(30,250,150,20);
		lab5.setFont(new Font("Poppins",Font.BOLD,16));
		lab5.setForeground(Color.white);
		
		lab55=new JLabel();
		lab55.setBounds(100,250,80,20);
		lab55.setFont(new Font("Poppins",Font.PLAIN,16));
		lab55.setForeground(Color.white);
		
		JLabel lab6=new JLabel("-----------------------------");
		lab6.setBounds(25,310,320,20);
		lab6.setFont(new Font("Poppins",Font.BOLD,16));
		lab6.setForeground(Color.white);
		
		JLabel lab7=new JLabel("Total: ");
		lab7.setBounds(30,350,80,20);
		lab7.setFont(new Font("Poppins",Font.BOLD,16));
		lab7.setForeground(Color.white);
		
		lab77=new JLabel("0");
		lab77.setBounds(210,380,80,20);
		lab77.setFont(new Font("Poppins",Font.BOLD,16));
		lab77.setForeground(Color.white);
		
		this.setTitle("Facture");
		this.setBounds(500,150,350,500);
		this.getContentPane().setBackground(new Color(0x2a2f35));
		this.setVisible(true);
		this.setLayout(null);
		this.add(lab1);
		this.add(lab2);
		this.add(lab22);
		this.add(lab3);
		this.add(lab33);
		this.add(lab4);
		this.add(lab44);
		this.add(lab5);
		this.add(lab6);
		this.add(lab7);
		this.add(lab55);
		this.add(lab77);
		
		
		
	}
	

}
