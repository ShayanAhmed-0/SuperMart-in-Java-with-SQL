package hello;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class userpanel {
	
		private JFrame frame;
		private JFrame frame1;
		private JTextField Pname;
		private JTextField Day;
		private JTextField Month;
		private JTextField Year;
		private JLabel nameLabel;
		private JLabel priceLabel;
		
		
public class userFarmeOne {
			public void frameWin1(){

		setFrame1(new JFrame());
		getFrame1().getContentPane().setBackground(Color.WHITE);
		getFrame1().setBounds(200, 200, 400, 600);
		getFrame1().setTitle("User");
		getFrame1().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame1().getContentPane().setLayout(null);
		getFrame1().setVisible(true);
		
		JLabel wUser = new JLabel("Welcome User");
		wUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		wUser.setForeground(Color.BLUE);
		wUser.setHorizontalAlignment(SwingConstants.CENTER);
		wUser.setBounds(10, 11, 364, 79);
		getFrame1().getContentPane().add(wUser);

		}	
}
public class userFarmeTwo{
	
			public void frameWin1(){
				frame1 = new JFrame();
				frame1.getContentPane().setBackground(Color.WHITE);
				frame1.setBounds(100, 100, 450, 300);
				frame1.setTitle("Return A product");
				frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame1.getContentPane().setLayout(null);
				frame1.setVisible(true);		
			}

			
			public void label1() {
				JLabel PnameLabel = new JLabel("Product Name");
				PnameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
				PnameLabel.setForeground(Color.BLUE);
				PnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
				PnameLabel.setBounds(10, 23, 414, 32);
				frame1.getContentPane().add(PnameLabel);
				
				Pname = new JTextField();
				Pname.setBounds(83, 58, 274, 23);
				frame1.getContentPane().add(Pname);
				Pname.setColumns(10);
				
				JLabel DOPlabel = new JLabel("Date of Purchase");
				DOPlabel.setForeground(Color.BLUE);
				DOPlabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
				DOPlabel.setHorizontalAlignment(SwingConstants.CENTER);
				DOPlabel.setBounds(10, 108, 414, 23);
				frame1.getContentPane().add(DOPlabel);			
			}
			
//return functionality			
			public void ret(){

				JButton btnReturnAProduct = new JButton("Return A product");
				btnReturnAProduct.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
//setting new frame	
						userFarmeTwo uf= new userFarmeTwo();
						uf.frameWin1();						
//Product name		
						uf.label1();						
						
//eligiblity label					
						JLabel elig = new JLabel();
						elig.setForeground(Color.RED);
						elig.setHorizontalAlignment(SwingConstants.CENTER);
						elig.setBounds(10, 214, 414, 14);
						frame1.getContentPane().add(elig);
						elig.setVisible(false);
//day						
						Day = new JTextField("Day");
						Day.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								Day.setText("");
							}
						});
						Day.setColumns(10);
						Day.setBounds(71, 147, 89, 23);
						frame1.getContentPane().add(Day);
						
//month						
						Month = new JTextField("Month");
						Month.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								Month.setText("");
							}
						});
						Month.setColumns(10);
						Month.setBounds(170, 147, 89, 23);
						frame1.getContentPane().add(Month);
						
//year						
						Year= new JTextField("Year");
						Year.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								Year.setText("");
							}
						});
						Year.setColumns(10);
						Year.setBounds(269, 147, 89, 23);
						frame1.getContentPane().add(Year);
						
//calculating time
//day
//calculating time
						Date Cdate=new Date();
						@SuppressWarnings({ "unused", "deprecation" })
						int Cday= Cdate.getDay();
						
						
//submit button						
						JButton btnSubmit = new JButton("Submit");
						btnSubmit.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								
//calculating current time
								Date Cdate=new Date();
//day
								@SuppressWarnings("deprecation")
								int Cday= Cdate.getDate();
								Cday=(Cday*24)*60;
								
//calendar 
								    @SuppressWarnings("unused")
									Date date = new Date();
								Calendar calendar = new GregorianCalendar();
								calendar.setTime(Cdate);

//getting values from user								
								int DayTime=Integer.parseInt(Day.getText());
								int Mm=Integer.parseInt(Month.getText());
								int Yy=Integer.parseInt(Year.getText());
//day to minute 						
								 DayTime+=7;
								 DayTime=(DayTime*24)*60;
//if condition								 
								 if(Cday <= DayTime && Mm==calendar.get(Calendar.MONTH) + 1 && Yy==calendar.get(Calendar.YEAR)){
									 elig.setText("you are eligible");
									 elig.setVisible(true);
								 }
								 else{							 
									 elig.setText("you are not eligible");
									 elig.setVisible(true);
							}
							}
						});
						btnSubmit.setBounds(170, 192, 89, 23);
						frame1.getContentPane().add(btnSubmit);
//back button						
						JButton btnNewButton_3 = new JButton("Back");
						btnNewButton_3.addActionListener(new ActionListener() {
//action back button							
							public void actionPerformed(ActionEvent e) {
								frame1.setVisible(false);							
							}
						});
						btnNewButton_3.setBounds(0, 227, 89, 23);
						frame1.getContentPane().add(btnNewButton_3);
						
//submit button action end						
					}
				});
				btnReturnAProduct.setBounds(92, 380, 200, 20);
				getFrame1().getContentPane().add(btnReturnAProduct);
				
			}
			
			
//add products functionality			
			public void addP(){
				
				frame = new JFrame();
				frame.setVisible(true);
				frame.setBounds(200, 200, 800, 600);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				
				
				
				JLabel lblNewLabel = new JLabel("Add to Cart");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(10, 5, 764, 43);
				frame.getContentPane().add(lblNewLabel);
				
				nameLabel = new JLabel("Name");
				nameLabel.setBounds(10, 46, 54, 26);
				frame.getContentPane().add(nameLabel);
				
				priceLabel = new JLabel("Price");
				priceLabel.setBounds(586, 46, 60, 26);
				frame.getContentPane().add(priceLabel);
				
				JLabel showmsg = new JLabel("Product Added to Cart");
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
						boolean ans=Usersql.insetProductsToCart(PD);
//showmsg 					
						if(ans){
							showmsg.setVisible(true);
						}
						else{
							showmsg.setForeground(Color.RED);
							showmsg.setText("failed to Add product");
							showmsg.setVisible(true);
						}
//add button action end						
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

//delete products functionality			
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
//delete button action
				Delete.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
				
						String Productname=textArea.getText().toString();
//deleting from database					
						boolean answ=Usersql.deleteProductsfromCart(Productname);
//showmsg 					
						if(answ){
							showmsg.setVisible(true);
						}
						else{
							showmsg.setForeground(Color.RED);
							showmsg.setText("failed to Delete product");
							showmsg.setVisible(true);
						}	
//delete button action end						
					}
				});
//delete another button
				JButton Addother = new JButton("Delete Other Product");
				Addother.setBounds(20, 150, 200, 20);
				frame.getContentPane().add(Addother);
//delete button action
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

	
	public void deletePfromList(){
		
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
				boolean answ=Usersql.removeList(Productname);
//showmsg 					
				if(answ){
					showmsg.setVisible(true);
				}
				else{
					showmsg.setForeground(Color.RED);
					showmsg.setText("failed to Delete product");
					showmsg.setVisible(true);
				}	
//add button action	end			
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
//add button action	end           
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


	public void wishList() {
				
				frame = new JFrame();
				frame.setVisible(true);
				frame.setBounds(200, 200, 800, 600);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
	
				JLabel lblNewLabel = new JLabel("Add to List");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(10, 5, 764, 43);
				frame.getContentPane().add(lblNewLabel);
				
				nameLabel = new JLabel("Name");
				nameLabel.setBounds(10, 46, 54, 26);
				frame.getContentPane().add(nameLabel);
				
				priceLabel = new JLabel("Quantity");
				priceLabel.setBounds(586, 46, 60, 26);
				frame.getContentPane().add(priceLabel);
				
				JLabel showmsg = new JLabel("Product Added to your list");
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
						boolean ans=Usersql.insetProductsToList(PD);
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
//back button action end
					}
				});
			
	}
}
		
		
		
		public void aPage(){
			userFarmeOne f1 = new userFarmeOne();
			userFarmeTwo f2 = new userFarmeTwo();
			
			f1.frameWin1();
			f2.ret();
			
					
//See Products Lists button
			JButton btnback = new JButton("See Products Lists");
			btnback.setBounds(92, 100, 200, 20);
			getFrame1().getContentPane().add(btnback);
//See Products Lists button action
			btnback.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					Plistsql.showAllProducts();
//See Products Lists button action end
				}
			});
			
//add Products to cart button
			JButton addp = new JButton("Add to cart");
			addp.setBounds(92, 140, 200, 20);
			getFrame1().getContentPane().add(addp);
//add Products to Lists button action
			addp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){			
					f2.addP();	
//add Products to Lists button action end
				}
			});

//see cart button
			JButton addtc = new JButton("show cart");
			addtc.setBounds(92, 180, 200, 20);
			getFrame1().getContentPane().add(addtc);
//see cart button action
			addtc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){			
				Usersql.showAllProducts();
//see cart button action end
				}
			});
//delete from cart button
			JButton delfc = new JButton("delete from cart");
			delfc.setBounds(92, 220, 200, 20);
			getFrame1().getContentPane().add(delfc);
//delete from  cart button action
			delfc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){			
				f2.deleteP();
//delete from cart button action end			
				}
			});		
			
//wish list button
			JButton wishL = new JButton("Make a List");
			wishL.setBounds(92, 260, 200, 20);
			getFrame1().getContentPane().add(wishL);
//wish button action
			wishL.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){			
				f2.wishList();
//wish button action end				
				}
			});	
//wish list button
			JButton List = new JButton("Your List");
			List.setBounds(92, 300, 200, 20);
			getFrame1().getContentPane().add(List);
//wish button action
			List.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){			
				Usersql.showList();
//wish button action end				
				}
			});	
			
//wish list button
			JButton rList = new JButton("Remove from List");
			rList.setBounds(92, 340, 200, 20);
			getFrame1().getContentPane().add(rList);
//wish button action
			rList.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){	
				f2.deletePfromList();
//wish button action end				
				}
			});	
	    
		}
		public JFrame getFrame1() {
			return frame1;
		}
		public void setFrame1(JFrame frame1) {
			this.frame1 = frame1;
		}

	}

