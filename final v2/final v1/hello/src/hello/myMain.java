package hello;

import java.awt.EventQueue;


import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;




public class myMain {
	
	

	private JTextField textField;
	private JPasswordField passwordField;	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 new myMain();
			
				} catch (Exception e) {
					System.out.println("running myMain");
				}
			}
		});
	}
	
	
	public class frameOne { 
		JFrame frame1;
		public void frameWin1(){
			frame1 = new JFrame();
			frame1.getContentPane().setBackground(Color.WHITE);
			frame1.setBounds(100, 100, 450, 300);
			frame1.setTitle("Login");
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame1.getContentPane().setLayout(null);
			frame1.setVisible(true);
		}
		public void logo(){
			JLabel Name = new JLabel("Super Mart");
			Name.setFont(new Font("Tahoma", Font.PLAIN, 20));
			Name.setForeground(Color.BLUE);
			Name.setBackground(Color.WHITE);
			Name.setHorizontalAlignment(SwingConstants.CENTER);
			Name.setBounds(10, 6, 414, 41);
			frame1.getContentPane().add(Name);
		}

	}

	public class frameTwo{
		JFrame frame1;
		public void frameWin1(){
			
		frame1 = new JFrame();
		frame1.getContentPane().setBackground(Color.WHITE);
		frame1.setBounds(100, 100, 450, 300);
		frame1.setTitle("Admin");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		frame1.setVisible(true);
		}
		public void logo(){
		JLabel adminID = new JLabel("Admin ID");
		adminID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		adminID.setForeground(Color.BLUE);
		adminID.setBackground(Color.WHITE);
		adminID.setHorizontalAlignment(SwingConstants.CENTER);
		adminID.setBounds(10, 6, 414, 41);
		frame1.getContentPane().add(adminID);
		}
		public void textf(){
		textField = new JTextField();
		textField.setBounds(49, 60, 347, 23);
		frame1.getContentPane().add(textField);
		textField.setColumns(10);
		}
		public void passlogo(){
		JLabel adminPassword = new JLabel("Password");
		adminPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		adminPassword.setForeground(Color.BLUE);
		adminPassword.setBackground(Color.WHITE);
		adminPassword.setHorizontalAlignment(SwingConstants.CENTER);
		adminPassword.setBounds(10, 86, 414, 41);
		frame1.getContentPane().add(adminPassword);
		}
		public void passfeild(){
		passwordField = new JPasswordField();
		passwordField.setBounds(49, 130, 347, 23);
		frame1.getContentPane().add(passwordField);
		}
		public void incpass(){
		JLabel inc = new JLabel("incorrect ID or Password");
		inc.setHorizontalAlignment(SwingConstants.CENTER);
		inc.setBounds(10, 214, 414, 14);
		frame1.getContentPane().add(inc);	
		inc.setForeground(Color.RED);
		inc.setVisible(true);
		}
	}

	/**
	 * Create the application.
	 */
	public myMain() {
		initialize();
		
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
//frame One 		
		frameOne f1= new frameOne();
		f1.frameWin1();
// LOGO		
		f1.logo();		
//ADMIN
		JButton btnNewButton = new JButton("Admin");
		btnNewButton.setBounds(170, 74, 89, 23);
		f1.frame1.getContentPane().add(btnNewButton);
		frameTwo f2= new frameTwo();
		btnNewButton.addActionListener(new ActionListener() {		
//admin button action
			public void actionPerformed(ActionEvent arg0) {
           // to disable previous frame
				f1.frame1.setVisible(false);
//setting new frame				
				
//new frame				
				f2.frameWin1();		
//label enter ID admin	
				f2.logo();				
//textfield enter ID
				f2.textf();					
//label enter password admin
				f2.passlogo();
//password enter password
				f2.passfeild();	
				
//submit button
				JButton btnNewButton_4 = new JButton("SUBMIT");
				btnNewButton_4.addActionListener(new ActionListener() {
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e) {
						if(textField.getText().toString().equals("admin") && passwordField.getText().toString().equals("admin")){
//disable previous frame
							f2.frame1.setVisible(false);
//new class
							
							adminpanel ap= new adminpanel();
							ap.aPage();
							
//back button of admin panel							
							JButton btnNewButton_3 = new JButton("Back");
							btnNewButton_3.setBounds(0, 300, 89, 23);
							ap.getFrame1().getContentPane().add(btnNewButton_3);
							btnNewButton_3.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent arg0){
									ap.getFrame1().setVisible(false);
									f2.frame1.setVisible(true);
//action end back button								
								}
							});
//if-ending						
						}
						else
							f2.incpass();
						
//submit button action end						
					}
				});
				f2.frame1.setVisible(true);
				
				btnNewButton_4.setBounds(112, 180, 199, 31);
				f2.frame1.getContentPane().add(btnNewButton_4);
				
				
//back button
				JButton btnback = new JButton("Back");
				btnback.setBounds(0, 227, 89, 23);
				f2.frame1.getContentPane().add(btnback);
//back button action
				btnback.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						f2.frame1.setVisible(false);
						f1.frame1.setVisible(true);		
					}
				});

//admin button action end				
					}
				});
		
//USER 					
		JButton btnNewButton_1 = new JButton("User");
		btnNewButton_1.setBounds(170, 127, 89, 23);
		f1.frame1.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {			
//user button action
			public void actionPerformed(ActionEvent e) {
				f1.frame1.setVisible(false);
//new class										
				userpanel up= new userpanel();
				up.aPage();																				
//back button of user panel							
				JButton btnNewButton_3 = new JButton("Back");
				btnNewButton_3.setBounds(0, 520, 89, 23);
				up.getFrame1().getContentPane().add(btnNewButton_3);
				btnNewButton_3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
				up.getFrame1().setVisible(false);
				f1.frame1.setVisible(true);
												
				}
		});
//end action user button											
				}
		});
		
		
		
//exit button
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setBounds(170, 180, 89, 23);
		f1.frame1.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});

		
	}
}
