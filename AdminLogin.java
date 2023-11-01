import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class AdminLogin extends JFrame implements ActionListener
{
    JLabel UserName,Password,admin;
    JTextField EnterUser;
    JPasswordField EnterPass;
    JButton Log,back;
    Map<String, String> admindetails = new HashMap<>();
    AdminLogin() throws Exception
    {
    	Connect v = new Connect();
    	admindetails = v.AdminDetails();     
    	getContentPane().setBackground(Color.gray);
        setTitle("Admin Login");
        setVisible(true);
        setSize(1000,1000);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        admin=new JLabel("Admin Login");
        admin.setFont(new Font("Cambrie",Font.BOLD,30));
        admin.setForeground(Color.BLACK);
        

        
        UserName=new JLabel("Admin ID: ");
        UserName.setFont(new Font("Cambrie",Font.BOLD,25));
        UserName.setForeground(Color.BLACK);

        EnterUser=new JTextField(25);
        
        Password=new JLabel("Password: ");
        Password.setFont(new Font("Cambrie",Font.BOLD,25));
        Password.setForeground(Color.BLACK);

        EnterPass=new JPasswordField(25);
        
        Log=new JButton("LOGIN");

        back=new JButton("BACK");

        add(admin);
        admin.setBounds(390, 200, 1000, 50);
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
            String u = EnterUser.getText();
            String p = EnterPass.getText();
            if(admindetails.containsKey(u) && e.getSource()==Log){
            	String storedPassword = admindetails.get(u);
                if (p.equals(storedPassword)&& e.getSource()== Log) {
                	JOptionPane.showMessageDialog(this, "Login Sucessful. Redirecting to Admin panel.");
            	   	new AdminPage();
            	   	dispose();

            }
                if((!admindetails.containsKey(u))&& e.getSource()== Log){
                	JOptionPane.showMessageDialog(null,"Incorrect Credentials.", "Warning",JOptionPane.WARNING_MESSAGE  );
                }
                
                
            if(e.getSource()==back){
                new HomePage();
                dispose();
            }
            
        }
        
    
}

class login_admin{
    public static void main(String[] args) throws Exception
    {
        new AdminLogin();
    }
}}