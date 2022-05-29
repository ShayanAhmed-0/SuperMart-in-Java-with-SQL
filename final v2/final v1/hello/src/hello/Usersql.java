package hello;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;



public class Usersql {
	private static JFrame frame;
	public static boolean insetProductsToCart(Products PD) {
		boolean f=false;
		try{
			Connection con=consql.createC();
			String q="insert into cart(pName,pPrice,pID) values(?,?,?)";
//prepared statement
			PreparedStatement pstmt= con.prepareStatement(q);
//set the values of parameters
			pstmt.setString(1,PD.getpName());
			pstmt.setInt(2,PD.getpPrice());
			pstmt.setInt(3,PD.getpID());

//excute..
			pstmt.executeUpdate();
			f=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return f;
	}

	public static void showAllProducts() {
		try{
			Connection con=consql.createC();

			String q="select * from cart";

//create statement
			Statement stmt= con.createStatement();
//set the values of parameters
			ResultSet set= stmt.executeQuery(q);
			
			frame = new JFrame();
			frame.setVisible(true);
			frame.setBounds(200, 200, 800, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Products List");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(10, 5, 764, 43);
			frame.getContentPane().add(lblNewLabel);
			
			JButton btnConfirmOrder = new JButton("confirm order");
			btnConfirmOrder.setBounds(343, 450, 120, 23);
			frame.getContentPane().add(btnConfirmOrder);

			btnConfirmOrder.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					frame = new JFrame();
					frame.setVisible(true);
					frame.setBounds(100, 100, 450, 300);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.getContentPane().setLayout(null);
					
//thankyou label
					JLabel lblNewLabel_2 = new JLabel("Thank You For Shopping ");
					lblNewLabel_2.setForeground(Color.BLUE);
					lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
					lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_2.setBounds(10, 35, 414, 42);	
					lblNewLabel_2.setVisible(false);
					
//msg label
					JLabel msg = new JLabel();
					msg.setForeground(Color.GREEN);
					msg.setFont(new Font("Tahoma", Font.PLAIN, 20));
					msg.setHorizontalAlignment(SwingConstants.CENTER);
					msg.setBounds(10, 99, 414, 65);
					
//exit button
					JButton exit = new JButton("Exit");
					exit.setBounds(170, 180, 89, 23);
					exit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.exit(0);
							
						}
					});
					
//Home Delivery
					JButton btnNewButton = new JButton("Home Delivery");
					btnNewButton.setBounds(160, 70, 120, 23);
					frame.getContentPane().add(btnNewButton);
					btnNewButton.addActionListener(new ActionListener() {		
//Home Delivery button action
						public void actionPerformed(ActionEvent arg0) {
							frame = new JFrame();
							frame.setVisible(true);
							frame.setBounds(100, 100, 450, 300);
							frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							frame.getContentPane().setLayout(null);
//thank you show							
							frame.getContentPane().add(lblNewLabel_2);
							lblNewLabel_2.setVisible(true);
//msg							
							frame.getContentPane().add(msg);
							msg.setText("Your Products Will be Delivered to You...");
							frame.getContentPane().add(exit);
						
							
				}
			});
//picUp Delivery
					JButton btnNewButton1 = new JButton("Pick Up");
					btnNewButton1.setBounds(170, 120, 100, 23);
					frame.getContentPane().add(btnNewButton1);
					btnNewButton1.addActionListener(new ActionListener() {		
//pickUp button action
						public void actionPerformed(ActionEvent arg0) {
							frame = new JFrame();
							frame.setVisible(true);
							frame.setBounds(100, 100, 450, 300);
							frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							frame.getContentPane().setLayout(null);
//thank you show							
							frame.getContentPane().add(lblNewLabel_2);
							lblNewLabel_2.setVisible(true);
							msg.setFont(new Font("Tahoma", Font.PLAIN, 15));
							frame.getContentPane().add(msg);
							msg.setText("Your can pick up the Products from the nearest franchise....");
							frame.getContentPane().add(exit);
							
//back button
							JButton btnback = new JButton("Back");
							btnback.setBounds(10, 230, 100, 23);
							frame.getContentPane().add(btnback);
//back button action
							btnback.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent arg0){
									frame.setVisible(false);
//back button action end		
								}
							});
//pickup button action end
						}
					});
//back button
					JButton btnback = new JButton("Back");
					btnback.setBounds(10, 230, 100, 23);
					frame.getContentPane().add(btnback);
//back button action
					btnback.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent arg0){
							frame.setVisible(false);
						}
				});
//confirm order action end				
				}
			});
			
//back button
			JButton btnback = new JButton("Back");
			btnback.setBounds(10, 527, 89, 23);
			frame.getContentPane().add(btnback);
//back button action
			btnback.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					frame.setVisible(false);

			

				}
			});
			int i=50;
			
			while(set.next()){
				
				@SuppressWarnings("unused")
				int id=set.getInt(1);
				String name=set.getString(2);
				int price = set.getInt(3);

					JLabel prodname = new JLabel();
					prodname.setBounds(82, i, 475, 26);;
					prodname.setText(name);
					frame.getContentPane().add(prodname);
					
					JLabel prodprice = new JLabel();
					prodprice.setBounds(656, i, 86, 26);
					prodprice.setText(Integer.toString(price)+"Rs");
					frame.getContentPane().add(prodprice);
					
					i+=20;

				}
							
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public static boolean deleteProductsfromCart(String productname) {

		boolean f=false;
		try{
			Connection con=consql.createC();
			String q="delete from cart where pName=?";
//prepared statement
			PreparedStatement pstmt= con.prepareStatement(q);
//set the values of parameters
			pstmt.setString(1,productname);
//Execute..
			pstmt.executeUpdate();
			f=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return f;
	}

	public static boolean insetProductsToList(Products PD) {
		boolean f=false;
		try{
			Connection con=consql.createC();
			String q="insert into userlist(pName,pPrice,pID) values(?,?,?)";
//prepared statement
			PreparedStatement pstmt= con.prepareStatement(q);
//set the values of parameters
			pstmt.setString(1,PD.getpName());
			pstmt.setInt(2,PD.getpPrice());
			pstmt.setInt(3,PD.getpID());
//Execute..
			pstmt.executeUpdate();
			f=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return f;
	}

		
	public static void showList() {
			try{
				Connection con=consql.createC();

				String q="select * from userList";

//create statement
				Statement stmt= con.createStatement();
//set the values of parameters
     			ResultSet set= stmt.executeQuery(q);
				
				frame = new JFrame();
				frame.setVisible(true);
				frame.setBounds(200, 200, 800, 600);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				
				JLabel lblNewLabel = new JLabel("Products List");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(10, 5, 764, 43);
				frame.getContentPane().add(lblNewLabel);
				
				
//back button
				JButton btnback = new JButton("Back");
				btnback.setBounds(10, 527, 89, 23);
				frame.getContentPane().add(btnback);
//back button action
				btnback.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						frame.setVisible(false);
					}
				});
				
				
				int i=50;
				
				while(set.next()){
					
					@SuppressWarnings("unused")
					int id=set.getInt(1);
					String name=set.getString(2);
					int price = set.getInt(3);


						JLabel prodname = new JLabel();
						prodname.setBounds(82, i, 475, 26);;
						prodname.setText(name);
						frame.getContentPane().add(prodname);
						
						JLabel prodprice = new JLabel();
						prodprice.setBounds(656, i, 86, 26);
						prodprice.setText(Integer.toString(price)+"Qty");
						frame.getContentPane().add(prodprice);
						
						i+=20;

					}

			
			}catch(Exception e){
				e.printStackTrace();
			}
			
	}

	public static boolean removeList(String productname) {
		boolean f=false;
		try{
			Connection con=consql.createC();
			String q="delete from userList where pName=?";
//prepared statement
			PreparedStatement pstmt= con.prepareStatement(q);
//set the values of parameters
			pstmt.setString(1,productname);
//Execute..
			pstmt.executeUpdate();
			f=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return f;
	}
		
	}
