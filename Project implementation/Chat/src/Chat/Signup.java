package Chat;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class Signup extends JFrame implements ActionListener{

	JFrame frame;
	Container container;
	Font font;
	JLabel name,email,pass,conpass,username,gender,dob,sequrityQues,sequrityAns;
	JTextField nameTextField,emailTextField,usernameTextField,sansTextField;
	JComboBox genderCombo,date,month,year,squesCombo;
	JPasswordField passPass,conpassPass; 
	JButton b1;
	Signup(){
		//JOptionPane.showMessageDialog(null, "This step needs an active internet connection. Please check before you proceed.", "Mandation", JOptionPane.INFORMATION_MESSAGE);
		String gen[]={"Select","Male","Female"};
		String dd[]={"Date","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		String mm[]={"Month","January","February","March","April","May","July","August","September","October","November","December"};
		String yy[]={"Year","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000","1999","1998","1997","1996","1995","1994","1993","1992","1991","1990","1989","1988","1987","1986","1985","1984","1983","1982","1981","1980","1979","1978","1977","1976","1975","1974","1973","1972","1971","1970","1969","1968","1967","1966","1965","1964","1963","1962","1961","1960","1959","1958","1957","1956","1955","1954","1953","1952","1951","1950","1949","1948","1947","1946","1945","1944","1943","1942","1941","1940","1939","1938","1937","1936","1935","1934","1933","1932","1931","1930","1929","1928","1927","1926","1925","1924","1923","1922","1921","1920","1919","1918","1917","1916","1915","1914","1913","1912","1911","1910","1909","1908","1907","1906","1905","1904","1903","1902","1901","1900"};
		String ques[]={"Select","What is your first school name?","What is your mother's maiden name?","What is your first phone number?","What is your favorite book?","What is your first crush name?","What is your pet's name?"};
		
		frame=new JFrame("Create an Account");
		frame.setSize(400,465);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setIconImage((new ImageIcon("poza.jpg")).getImage()); 
		container=frame.getContentPane();
	    container.setLayout(new FlowLayout());
	    //c1.setSize(200, 200);
	    frame.setBackground(new java.awt.Color(204,204,255));
	    font=new Font("Arial",Font.BOLD,20);
        setFont(font);
		
		name=new JLabel("Name  ");
		nameTextField=new JTextField(20);
		
		email=new JLabel("Email Id  ");
		emailTextField=new JTextField(20);
		
		username=new JLabel("Username  ");
		usernameTextField=new JTextField(20);
		
		pass=new JLabel("Password  ");
		passPass=new JPasswordField(20);
		
		conpass=new JLabel("Confirm Password  ");
		conpassPass=new JPasswordField(20);
		
		gender=new JLabel("Gender  ");
		genderCombo=new JComboBox(gen);	
		
		dob=new JLabel("Date of Birth  ");
		date=new JComboBox(dd);
		month=new JComboBox(mm);
		year=new JComboBox(yy);
		
		sequrityQues=new JLabel("Security Question  ");
		squesCombo=new JComboBox(ques);
		
		sequrityAns=new JLabel("Security Answer  ");
		sansTextField=new JTextField(20);
		
		b1=new JButton("Create Account");
		
		
		
		JPanel a = new JPanel();
		a.setLayout(new BoxLayout(a, BoxLayout.X_AXIS));
		
		JPanel b = new JPanel();
		b.setLayout(new BoxLayout(b, BoxLayout.X_AXIS));
		JPanel c = new JPanel();
		c.setLayout(new BoxLayout(c, BoxLayout.X_AXIS));
		JPanel d = new JPanel();
		d.setLayout(new BoxLayout(d, BoxLayout.X_AXIS));
		JPanel e = new JPanel();
		e.setLayout(new BoxLayout(e, BoxLayout.X_AXIS));
		JPanel f = new JPanel();
		f.setLayout(new BoxLayout(f, BoxLayout.X_AXIS));
		JPanel g = new JPanel();
		g.setLayout(new BoxLayout(g, BoxLayout.X_AXIS));
		JPanel h = new JPanel();
		h.setLayout(new BoxLayout(h, BoxLayout.X_AXIS));
		JPanel i = new JPanel();
		i.setLayout(new BoxLayout(i, BoxLayout.X_AXIS));
		JPanel j = new JPanel();
		j.setLayout(new BoxLayout(j, BoxLayout.Y_AXIS));
		j.setPreferredSize(new Dimension(350,390)); 
		
		JPanel k = new JPanel();
		k.setLayout(new BoxLayout(k, BoxLayout.Y_AXIS));
		JPanel l = new JPanel();
		l.setLayout(new BoxLayout(l, BoxLayout.Y_AXIS));
		JPanel m = new JPanel();
		m.setLayout(new BoxLayout(m, BoxLayout.Y_AXIS));
		JPanel n = new JPanel();
		n.setLayout(new BoxLayout(n, BoxLayout.Y_AXIS));
		JPanel o = new JPanel();
		o.setLayout(new BoxLayout(o, BoxLayout.Y_AXIS));
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		JPanel q = new JPanel();
		q.setLayout(new BoxLayout(q, BoxLayout.Y_AXIS));	
		JPanel r = new JPanel();
		r.setLayout(new BoxLayout(r, BoxLayout.Y_AXIS));
		JPanel s = new JPanel();
		s.setLayout(new BoxLayout(s, BoxLayout.Y_AXIS));
		//JPanel t = new JPanel();
	//	t.setLayout(new BoxLayout(t, BoxLayout.X_AXIS));
		JPanel u = new JPanel();
		u.setLayout(new BoxLayout(u, BoxLayout.X_AXIS));
		
		JLabel space1=new JLabel("    ");
		JLabel space2=new JLabel("    ");
		JLabel space3=new JLabel("    ");
		JLabel space4=new JLabel("    ");
		JLabel space5=new JLabel("    ");
		JLabel space6=new JLabel("    ");
		JLabel space7=new JLabel("    ");
		JLabel space8=new JLabel("    ");
		JLabel space9=new JLabel("    ");
		JLabel space10=new JLabel("    ");
		JLabel space11=new JLabel("    ");
		JLabel space12=new JLabel("    ");
		
		u.add(space12);
		a.add(name);
		a.add(nameTextField);
		j.add(u);
		j.add(a);
		k.add(space1);
		j.add(k);
		
		b.add(email);
		b.add(emailTextField);
		l.add(space2);
		j.add(b);
		j.add(l);
		
		c.add(username);
		c.add(usernameTextField);
		m.add(space3);
		j.add(c);
		j.add(m);
		
		d.add(pass);
		d.add(passPass);
		n.add(space4);
		j.add(d);
		j.add(n);
		
		e.add(conpass);
		e.add(conpassPass);
		o.add(space5);
		j.add(e);
		j.add(o);
		
		f.add(gender);
		f.add(genderCombo);
		p.add(space6);
		j.add(f);
		j.add(p);
		
		g.add(dob);
		g.add(date);
		g.add(space10);
		g.add(month);
		g.add(space11);
		g.add(year);
		q.add(space7);
		j.add(g);
		j.add(q);
		
		h.add(sequrityQues);
		h.add(squesCombo);
		r.add(space8);
		j.add(h);
		j.add(r);
		
		i.add(sequrityAns);
		i.add(sansTextField);
		s.add(space9);
		j.add(i);
		j.add(s);
		
		container.add(j);
		container.add(b1);
		
		b1.addActionListener(this);
	}
	boolean checkmail(String id){
		int atrate=0,dot=0;
		for(int i=0;i<id.length();i++){
		  if((id.charAt(i)>='a' && id.charAt(i)<='z')||(id.charAt(i)>='A' && id.charAt(i)<='Z')||(id.charAt(i)=='@')||(id.charAt(i)=='.')||(id.charAt(i)=='_')||(id.charAt(i)>='0' && id.charAt(i)<='9')){
			  if(id.charAt(i)=='@')
				  atrate++;
			  if(id.charAt(i)=='.')
				  dot++;
		  }
		  else
			  return false;
	   }
		if((atrate==1)&& (dot>=1))
			return true;
		return false;
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1){
			String name_s,email_s,tname_s,pass_s,conpass_s,gender_s,date_s,month_s,year_s,sques_s,sans_s;
			name_s=nameTextField.getText();
			email_s=emailTextField.getText();
			tname_s=usernameTextField.getText();
			pass_s=new String(passPass.getPassword());
			conpass_s=new String(conpassPass.getPassword());
			gender_s=(genderCombo.getSelectedItem().toString());
			date_s=(date.getSelectedItem().toString());
			month_s=(month.getSelectedItem().toString());
			year_s=(year.getSelectedItem().toString());
			sques_s=squesCombo.getSelectedItem().toString();
			sans_s=sansTextField.getText();
			
			if (name_s.trim().length() == 0) 
	           JOptionPane.showMessageDialog(null, "Name must not be empty.", "Error", JOptionPane.ERROR_MESSAGE);
			else{
				if (email_s.trim().length() == 0) 
			           JOptionPane.showMessageDialog(null, "Email Id must not be empty.", "Error", JOptionPane.ERROR_MESSAGE);
				else
				{
					if (tname_s.trim().length() == 0) 
				           JOptionPane.showMessageDialog(null, "Twiddle Name must not be empty.", "Error", JOptionPane.ERROR_MESSAGE);
					else{
						if (pass_s.length()<6) 
					           JOptionPane.showMessageDialog(null, "Password must be atleast 6 character.", "Error", JOptionPane.ERROR_MESSAGE);
						else{
							if (conpass_s.length()<6) 
						           JOptionPane.showMessageDialog(null, "Confirm Password must be atleast 6 character.", "Error", JOptionPane.ERROR_MESSAGE);
							else{
								if ((gender_s.trim().equals("Select"))) 
							           JOptionPane.showMessageDialog(null, "Select your gender.", "Error", JOptionPane.ERROR_MESSAGE);
								else{
									if (date_s.trim().equals("Date")) 
								           JOptionPane.showMessageDialog(null, "Choose a date.", "Error", JOptionPane.ERROR_MESSAGE);
									else{
										if (month_s.trim().equals("Month")) 
									           JOptionPane.showMessageDialog(null, "Choose a month", "Error", JOptionPane.ERROR_MESSAGE);
										else{
											if (year_s.trim().equals("Year")) 
										           JOptionPane.showMessageDialog(null, "Choose an year", "Error", JOptionPane.ERROR_MESSAGE);
											else{
												if (sques_s.trim().equals("Select")) 
											           JOptionPane.showMessageDialog(null, "Select a security question.", "Error", JOptionPane.ERROR_MESSAGE);
												else{
													if (sans_s.trim().length() == 0) 
												           JOptionPane.showMessageDialog(null, "Provide a security answer.", "Error", JOptionPane.ERROR_MESSAGE);
													else{
														if(!(pass_s.equals(conpass_s)))
															JOptionPane.showMessageDialog(null, "Password doesn't match.", "Error", JOptionPane.ERROR_MESSAGE);
														else{
															if(!(checkmail(email_s)))
																JOptionPane.showMessageDialog(null, "Email entered is wrong.", "Error", JOptionPane.ERROR_MESSAGE);
															else{
																 CheckAvail caobj=new CheckAvail(tname_s);
																 try {
																	if(!(caobj.Check_Signup())){
																		JOptionPane.showMessageDialog(null, "Twiddle Name Unavailable. Please choose another name.", "Error", JOptionPane.ERROR_MESSAGE);
																	}
																	else{
																		caobj=new CheckAvail(email_s);
																		if(!(caobj.Check_Email())){
																			JOptionPane.showMessageDialog(null, "Email Id Already Exits", "Error", JOptionPane.ERROR_MESSAGE);
																		}
																		else{
																				DataBaseEntry obj=new DataBaseEntry(name_s,email_s,tname_s,pass_s,gender_s,date_s,month_s,year_s,sques_s,sans_s);
																				try {
																					obj.Entry();
																					frame.setVisible(false);
																					Login lobj=new Login();
																				    }catch (SQLException e) {
																					e.printStackTrace();
																		         }
																		}
																	}		
																 } catch (SQLException e1) {
																	e1.printStackTrace();
																}
																 
															
															}
														}
													}
												}
											}
										}
									}
										
								}
							}
						}
					}
				}
			}
				
			
		}
		
	}
}
