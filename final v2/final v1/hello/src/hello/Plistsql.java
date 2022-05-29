package hello;

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

public class Plistsql {
	private static JFrame frame;
//inserting to SQL database	
	public static boolean insetProductsToDB(Products PD){

		boolean f=false;
		try{
			Connection con=consql.createC();
			String q="insert into products(pName,pPrice,pID) values(?,?,?)";
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
	
	
//deleting from SQL data Base
	public static boolean deleteProductsfromDB(String productname) {

		boolean f=false;
		try{
			Connection con=consql.createC();
			String q="delete from products where pName=?";
//prepared statement
			PreparedStatement pstmt= con.prepareStatement(q);
//set the values of parameters
			pstmt.setString(1,productname);
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

			String q="select * from products";

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
// printing products			
			while(set.next()){
				
				@SuppressWarnings("unused")
				
				String name=set.getString(1);
				
				int price = set.getInt(2);
				int id=set.getInt(3);

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
	
}
