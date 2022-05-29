package hello;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class adminpanel{
	
	private JFrame frame1;
	private JFrame frame;
	private JLabel nameLabel;
	private JLabel priceLabel;
	
	
	public class adminFrameOne {
		public void frameWin1(){
	setFrame1(new JFrame());
	getFrame1().getContentPane().setBackground(Color.WHITE);
	getFrame1().setBounds(200, 200, 500, 400);
	getFrame1().setTitle("Admin");
	getFrame1().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	getFrame1().getContentPane().setLayout(null);
	getFrame1().setVisible(true);
	
	JLabel lblNewLabel_2 = new JLabel("Welcome Admin");
	lblNewLabel_2.setForeground(Color.BLUE);
	lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
	lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_2.setBounds(30, 35, 414, 42);
	getFrame1().getContentPane().add(lblNewLabel_2);
}
}
	
public class sPl {
				
public void addP(){
			
			frame = new JFrame();
			frame.setVisible(true);
			frame.setBounds(200, 200, 800, 600);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			
			
			JLabel lblNewLabel = new JLabel("Add Products to List");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(10, 5, 764, 43);
			frame.getContentPane().add(lblNewLabel);
			
			nameLabel = new JLabel("Name");
			nameLabel.setBounds(10, 46, 54, 26);
			frame.getContentPane().add(nameLabel);
			
			priceLabel = new JLabel("Price");
			priceLabel.setBounds(586, 46, 60, 26);
			frame.getContentPane().add(priceLabel);
			
			JLabel showmsg = new JLabel("Product Added to List");
			showmsg.setFont(new Font("Tahoma", Font.PLAIN, 15));
			showmsg.setForeground(Color.GREEN);
			showmsg.setHorizontalAlignment(SwingConstants.CENTER);
			showmsg.setBounds(10, 234, 764, 23);
			frame.getContentPane().add(showmsg);
			showmsg.setVisible(false);

			
			JTextArea textArea= new JTextArea();
			textArea.setBackground(SystemColor.info);
			textArea.setBounds(82, 46, 475, 26);
			frame.getContentPane().add(textArea);
			textArea.setColumns(10);
			
			JTextArea textArea1 = new JTextArea();
			textArea1.setBackground(SystemColor.info);
			textArea1.setBounds(656, 46, 86, 26);
			frame.getContentPane().add(textArea1);
//add button
			JButton Add = new JButton("Add");
			Add.setBounds(20, 114, 89, 23);
			frame.getContentPane().add(Add);
//add button action
			Add.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					
					String Productname=textArea.getText().toString();
					int Productprice=Integer.parseInt(textArea1.getText());
	
					Products PD=new Products(Productname,Productprice);
//adding to data base					
					boolean ans=Plistsql.insetProductsToDB(PD);
//showmsg 					
					if(ans){
						showmsg.setVisible(true);
					}
					else{
						showmsg.setForeground(Color.RED);
						showmsg.setText("failed to Add product");
						showmsg.setVisible(true);
					}
				}
			});

			
//add another button
			JButton Addother = new JButton("Add Other Product");
			Addother.setBounds(20, 150, 200, 20);
			frame.getContentPane().add(Addother);
//add button action
			Addother.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					showmsg.setVisible(false);
	               textArea.setText("");	
	               textArea1.setText("");
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
					getFrame1().setVisible(true);		
				}
			});
}

//delete product function
public void deleteP(){
	
	frame = new JFrame();
	frame.setVisible(true);
	frame.setBounds(200, 200, 800, 600);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
	
	
	JLabel lblNewLabel = new JLabel("Delete Products from List");
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(10, 5, 764, 43);
	frame.getContentPane().add(lblNewLabel);
	
	JLabel showmsg = new JLabel("Product Deleted from List");
	showmsg.setFont(new Font("Tahoma", Font.PLAIN, 15));
	showmsg.setForeground(Color.GREEN);
	showmsg.setHorizontalAlignment(SwingConstants.CENTER);
	showmsg.setBounds(10, 234, 764, 23);
	frame.getContentPane().add(showmsg);
	showmsg.setVisible(false);

	
	JTextArea textArea = new JTextArea();
	textArea.setBackground(SystemColor.info);
	textArea.setBounds(20, 60, 745, 25);
	frame.getContentPane().add(textArea);
//add button
	JButton Delete = new JButton("Delete");
	Delete.setBounds(20, 114, 89, 23);
	frame.getContentPane().add(Delete);
//add button action
	Delete.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
	
			String Productname=textArea.getText().toString();
//adding to database					
			boolean answ=Plistsql.deleteProductsfromDB(Productname);
//showmsg 					
			if(answ){
				showmsg.setVisible(true);
			}
			else{
				showmsg.setForeground(Color.RED);
				showmsg.setText("failed to Delete product");
				showmsg.setVisible(true);
			}	
			
		}
	});
//add another button
	JButton Addother = new JButton("Delete Other Product");
	Addother.setBounds(20, 150, 200, 20);
	frame.getContentPane().add(Addother);
//add button action
	Addother.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){
			showmsg.setVisible(false);
           textArea.setText("");			
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
			getFrame1().setVisible(true);		
		}
	});
}
	




}
	public void aPage(){
		adminFrameOne f1=new adminFrameOne();
		sPl f2=new sPl();
		f1.frameWin1();
		
//See Products Lists button
		JButton btnback = new JButton("See Products Lists");
		btnback.setBounds(135, 90, 200, 30);
		getFrame1().getContentPane().add(btnback);
//See Products Lists button action
		btnback.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				Plistsql.showAllProducts();
			}
			
		});
//add Products to Lists button
		JButton addp = new JButton("Add Products");
		addp.setBounds(135, 140, 200, 30);
		getFrame1().getContentPane().add(addp);
//add Products to Lists button action
		addp.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){			
				f2.addP();	
			}
		});
//add Products to Lists button
		JButton delp = new JButton("delete Products");
		delp.setBounds(135, 190, 200, 30);
		getFrame1().getContentPane().add(delp);
//add Products to Lists button action
		delp.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0){			
				f2.deleteP();	
			}
		});

	}

// getter and setter for frame1
	public JFrame getFrame1() {
		return frame1;
	}
	public void setFrame1(JFrame frame1) {
		this.frame1 = frame1;
	}

}
