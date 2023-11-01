import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VotingPanel extends JFrame {
	
	
	int count1=0,count2=0,count3=0,countnota=0;
    JRadioButton candidate1, candidate2, candidate3, nota;
    JButton vote;
    JLabel title, c1, c2, c3, c4;
    ImageIcon lion, tiger, eagle, nota_image;
    ButtonGroup group;


    VotingPanel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(890, 650);
        setVisible(true);
        setTitle("Class Voting System");
        setLayout(null);
        getContentPane().setBackground(Color.getHSBColor(55, 22, 70));

        group = new ButtonGroup();
        title = new JLabel("Cast your vote: ");
        title.setFont(new Font("Cambria", Font.BOLD, 27));
        title.setBounds(330, 15, 1000, 50);
        title.setForeground(Color.BLACK);

        candidate1 = new JRadioButton("AARON");
        candidate1.setBounds(100, 100, 100, 50);

        candidate2 = new JRadioButton("THEJAS");
        candidate2.setBounds(600, 100, 100, 50);

        candidate3 = new JRadioButton("SHALOM");
        candidate3.setBounds(100, 300, 100, 50);

        nota = new JRadioButton("NOTA");
        nota.setBounds(600, 300, 100, 50);

        vote = new JButton("Vote");
        vote.setBounds(350, 450, 100, 50);

        eagle = new ImageIcon(getClass().getResource("eagle.png"));
        lion = new ImageIcon(getClass().getResource("lion.png"));
        tiger = new ImageIcon(getClass().getResource("tiger.png"));
        nota_image = new ImageIcon(getClass().getResource("nota.png"));

        c1 = new JLabel(lion);
        c2 = new JLabel(tiger);
        c3 = new JLabel(eagle);
        c4 = new JLabel(nota_image);
        add(c1);
        add(c2);
        add(c3);
        add(c4);
        c1.setBounds(120, 150, 120, 120);
        c2.setBounds(620, 140, 150, 130);
        c3.setBounds(120, 350, 120, 120);
        c4.setBounds(620, 350, 140, 140);

        candidate1.setBackground(Color.getHSBColor(55, 22, 70));
        candidate2.setBackground(Color.getHSBColor(55, 22, 70));
        candidate3.setBackground(Color.getHSBColor(55, 22, 70));
        nota.setBackground(Color.getHSBColor(55, 22, 70));

        add(title);
        add(candidate1);
        add(candidate2);
        add(candidate3);
        add(nota);
        add(vote);

        Connect c=new Connect();
        
        group.add(candidate1);
        group.add(candidate2);
        group.add(candidate3);
        group.add(nota);

        vote.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedCandidate;
                if (candidate1.isSelected()) {
                    selectedCandidate = "AARON";
                   
                    try {
						c.UpdateCount(1);
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
                } else if (candidate2.isSelected()) {
                    selectedCandidate = "THEJAS";
                    
                    try {
                    	c.UpdateCount(2);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } else if (candidate3.isSelected()) {
                    selectedCandidate = "SHALOM";
                    
                    try {
                    	c.UpdateCount(3);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                } else if (nota.isSelected()) {
                    selectedCandidate = "NOTA";
                    try {
                    	c.UpdateCount(4);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                    
                } else {
                    selectedCandidate = "No candidate selected";
                }
        
        JOptionPane.showMessageDialog(null, "You voted for: " + selectedCandidate);
                try {
                    new VoterLogin();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                dispose();
            }
        });
    }

    public static void main(String[] args) {
       new VotingPanel();
       }
}
