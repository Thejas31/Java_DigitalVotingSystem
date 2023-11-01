import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class AdminPage extends JFrame implements ActionListener {
    JLabel labelAdminPage, note;
    JButton displayResults, EndVoting, back;
    
    AdminPage()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(Color.GRAY);
        setTitle("Class Voting System");
        setSize(1000,1000);

        labelAdminPage=new JLabel("Admin Page");
        labelAdminPage.setFont(new Font("Cambrie", Font.BOLD, 40));
        labelAdminPage.setForeground(Color.BLACK);
        labelAdminPage.setBounds(390, 90, 1000, 50);

        note = new JLabel("Select your option");
        note.setForeground(Color.BLACK);
        note.setFont(new Font("Cambrie", Font.ROMAN_BASELINE, 20));
        note.setBounds(425, 140, 1000, 50);
        
        displayResults=new JButton("DISPLAY RESULTS");
        displayResults.setBounds(380, 225, 250, 100);
        displayResults.addActionListener(this);

       back = new JButton("BACK");
        back.setBounds(450, 500, 100, 50);
        back.addActionListener(this);

        EndVoting=new JButton("END VOTING");
        EndVoting .setBounds(380, 350, 250, 100);
        EndVoting.addActionListener(this);

        add(labelAdminPage);
        add(displayResults);
        add(EndVoting);
        add(note);
        add(back);
       
    }
    
   
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == EndVoting) {
                int result = JOptionPane.showConfirmDialog(this, "Exit?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                	Connect sb = new Connect();
                	try {
						sb.ExitReset(1);
						sb.ExitReset(2);
						sb.ExitReset(3);
						sb.ExitReset(4);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation to exit the application
                    dispose(); // Close the window
                }
            } else if (e.getSource() == displayResults) {
                // Implement what you want to do when the Display Results button is clicked.
            } else if (e.getSource() == back) {
                JOptionPane.showMessageDialog(this, "Returning to Homepage...");
                new HomePage();
                dispose(); // Close the window
            }
        

        
        if(e.getSource() == displayResults) {
        	new VoteTableGUI();
        	
        }
        
    }

 class admin_page{
    public static void main(String[] args){
    new AdminPage();
    }
}
}