import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class HomePage extends JFrame implements ActionListener {
    JLabel labelHomePage, note, DisplayHome;
    JButton Nominees,voter ,adminlogin;
    ImageIcon HomeDisplay;
    HomePage()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        try{
            HomeDisplay = new ImageIcon(getClass().getResource("Homedisplay.png"));
            DisplayHome = new JLabel(HomeDisplay);
            add(DisplayHome);
            DisplayHome.setBounds(10, 50, 1000, 150);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this, "Image Not Found...");

        }
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.lightGray);
        setTitle("Class Voting System");
        setSize(1000,1000);

        labelHomePage=new JLabel("WELCOME TO THE HOMEPAGE");
        labelHomePage.setFont(new Font("Cambrie", Font.BOLD, 40));
        labelHomePage.setForeground(Color.BLACK);
        labelHomePage.setBounds(200, 190, 1000, 50);

        note = new JLabel("Select your option");
        note.setForeground(Color.BLACK);
        note.setFont(new Font("Cambrie", Font.ROMAN_BASELINE, 20));
        note.setBounds(425, 240, 1000, 50);
        
        Nominees=new JButton("DISPLAY NOMINEES");
        Nominees.setBounds(380, 300, 250, 100);
        Nominees.addActionListener(this);

        voter =new JButton("VOTER LOGIN");
        voter .setBounds(380, 425, 250, 100);
        voter .addActionListener(this);

        adminlogin=new JButton("ADMIN LOGIN");
        adminlogin.setBounds(380, 550, 250, 100);
        adminlogin.addActionListener(this);

        add(labelHomePage);
        add(Nominees);
        add(voter );
        add(adminlogin);
        add(note);
       
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == voter ){
          try {
			new VoterLogin();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
            dispose();
        }
        if(e.getSource() == adminlogin){
            try {
				new AdminLogin();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            dispose();
        }
        if(e.getSource() == Nominees){
            try {
				new DisplayNominees();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            dispose();
        }
    }
   
}

 class Home_page{
    public static void main(String[] args){
    new HomePage();
    }
}
