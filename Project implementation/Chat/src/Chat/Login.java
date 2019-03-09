package Chat;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.*;

public class Login extends JFrame implements ActionListener
{
	JFrame frame;
	Container container;
	Font font;
	ImageIcon icon;
	JLabel lname;
	JLabel lpass,imageLabel;
	JLabel lprob;
	JTextField username;
	JPasswordField password;
	JButton loginButton, signupButton;
	JPanel aux = new JPanel();
	FileChat fc;
	Login()
	{	
		frame=new JFrame("Authentication");
		frame.setSize(256,390);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setIconImage((new ImageIcon("poza.jpg")).getImage());  
		
		container=frame.getContentPane();
	    container.setLayout(new FlowLayout());
	        frame.setBackground(new java.awt.Color(204,204,255));
	        font=new Font("Arial",Font.BOLD,20);
                setFont(font);
            	frame.setVisible(true);
            	lname=new JLabel("Name");
            	lpass=new JLabel("Password");
            	lprob=new JLabel("<HTML><U>Trouble in Signing In...?</U></HTML>");
            	lprob.setFont(new Font("Arial",Font.BOLD,12));
            	lprob.setForeground(Color.BLUE);
            	lprob.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            	username=new JTextField(20); 
            	password=new JPasswordField(20);
            	loginButton=new JButton("Login");
            	signupButton=new JButton("Signup");
            	ImageIcon icon=new ImageIcon("poza.jpg");
            	Image img = icon.getImage() ;  
            	Image newimg = img.getScaledInstance( 180,180,  java.awt.Image.SCALE_SMOOTH ) ;  
            	icon = new ImageIcon( newimg );
            	imageLabel = new JLabel(icon);
        
        JPanel a = new JPanel();
		a.setLayout(new BoxLayout(a, BoxLayout.X_AXIS));
		JPanel b = new JPanel();
		b.setLayout(new BoxLayout(b, BoxLayout.Y_AXIS));
		JPanel c = new JPanel();
		c.setLayout(new BoxLayout(c, BoxLayout.X_AXIS));
		JLabel space1=new JLabel("    ");
		JLabel space2=new JLabel("    ");
		JLabel space3=new JLabel("              ");
		
		a.add(space2);
		a.add(imageLabel);
        container.add(a);
        container.add(space1);
        b.add(lname);
        container.add(b);
        container.add(username);
        container.add(lpass);
        container.add(password);
        //aux=b;
        c.add(loginButton);
        c.add(space3);
        c.add(signupButton);
        container.add(c);
        container.add(lprob);
        
        signupButton.addActionListener(this);
        loginButton.addActionListener(this);
        lprob.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               if(evt.getClickCount() > 0){
            	   TroubleSiginningIn obj=new TroubleSiginningIn();
            	   
                   }
             }
             });
	       
	addWindowListener(new WindowAdapter()
	{
		public void windowClosing(WindowEvent  e)
		{
			System.exit(0);
		}
	});
	
	
	}
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource()==loginButton){
			String uname=username.getText().toString();
			String upass=new String(password.getPassword());
			CheckAvail caobj=new CheckAvail(uname,upass);
			try {
				if(caobj.Check_Login()){
					frame.setVisible(false);
					fc = new FileChat();
					fc.setNameUser(uname);
					fc.play();
					System.out.println("atentieeeeeeeeeeeeeeeeee  " + uname);
					
				}
				else{
					JOptionPane.showMessageDialog(null, "Invalid Name/Password.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ae.getSource()==signupButton)
		{
			frame.setVisible(false);
			Signup obj=new Signup();
		}
	} 
	
	//public String SetNameOfClient(){
		//String nameOfClient = aux.getName();
		//System.out.println("numele clienului: " + nameOfClient);
		//return nameOfClient;
		//fc
		
	//}
}
