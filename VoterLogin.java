import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class VoterLogin extends JFrame implements ActionListener
{
    JLabel UserName,Password,Vote;
    JTextField EnterUser;
    JPasswordField EnterPass;
    JButton Log,back;
    Map<String, String> details = new HashMap<>();
    VoterLogin() throws Exception
    {
    	Connect v = new Connect();
    	details = v.Details();
        getContentPane().setBackground(Color.gray);
        setTitle("Digital Voting System");
        setVisible(true);
        setSize(1000,1000);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Vote=new JLabel("Digital Voting System");
        Vote.setFont(new Font("Cambrie",Font.BOLD,30));
        Vote.setForeground(Color.BLACK);
        

        
        UserName=new JLabel("Voter ID: ");
        UserName.setFont(new Font("Cambrie",Font.BOLD,25));
        UserName.setForeground(Color.BLACK);

        EnterUser=new JTextField(25);
        
        Password=new JLabel("Password: ");
        Password.setFont(new Font("Cambrie",Font.BOLD,25));
        Password.setForeground(Color.BLACK);

        EnterPass=new JPasswordField(25);
        
        Log=new JButton("LOGIN");

        back=new JButton("BACK");

        add(Vote);
        Vote.setBounds(340, 200, 1000, 50);
        add(UserName);add(EnterUser);
        UserName.setBounds(250, 300, 300, 25);
        EnterUser.setBounds(405, 300, 300, 25);
        add(Password);add(EnterPass);
        Password.setBounds(250, 350, 300, 25);
        EnterPass.setBounds(405, 350, 300, 25);
        add(Log);add(back);
        Log.setBounds(320,400,150,50);
        back.setBounds(500,400,150,50);
        Log.addActionListener(this);
        back.addActionListener(this);

    }
        public void actionPerformed(ActionEvent e){
            String user = EnterUser.getText();
            String pass = EnterPass.getText();
            
            
            if (details.containsKey(user) && e.getSource() == Log ) {
                // If it does, compare the entered password with the stored password
                String storedPassword = details.get(user);
                if (pass.equals(storedPassword)&& e.getSource()== Log) {
                	JOptionPane.showMessageDialog(this, "Login Sucessful. Redirecting to Voting panel.");
                	new VotingPanel();
                	dispose();
                } if((!pass.equals(storedPassword) )&& e.getSource()== Log){
                	JOptionPane.showMessageDialog(null,"Incorrect Credentials.", "Warning",JOptionPane.WARNING_MESSAGE  );
                }
            } 
            
            else if(e.getSource() == back)
            {
            new HomePage();
            dispose();
            }
            
        }

    
}

class Voters_login{
    public static void main(String[] args) throws Exception
    {
        new VoterLogin();
    }
}