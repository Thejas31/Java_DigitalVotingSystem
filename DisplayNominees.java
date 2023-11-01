import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayNominees extends JFrame implements ActionListener{
    JLabel titleText, nominee1, nominee2, nominee3, c1, c2, c3;
    ImageIcon lion, tiger, eagle;
    JButton exit;
    JTextArea tc1, tc2, tc3;

    DisplayNominees(){
        Connect object = new Connect();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setTitle("List of Nominees");
        setSize(1170,1000);

        titleText = new JLabel("Nominees List: ");
        titleText.setFont(new Font("Cambrie", Font.BOLD, 30));
        titleText.setForeground(Color.black);
        titleText.setBounds(90, 100, 1000, 100);

        nominee1 = new JLabel("Nominee 1: ");
        nominee1.setFont(new Font("Cambrie", Font.PLAIN, 20));
        nominee1.setForeground(Color.black);
        nominee1.setBounds(190, 200, 1000, 100);
        
        nominee2 = new JLabel("Nominee 2: ");
        nominee2.setFont(new Font("Cambrie", Font.PLAIN, 20));
        nominee2.setForeground(Color.black);
        nominee2.setBounds(590, 200, 1000, 100);

        nominee3 = new JLabel("Nominee 3: ");
        nominee3.setFont(new Font("Cambrie", Font.PLAIN, 20));
        nominee3.setForeground(Color.black);
        nominee3.setBounds(190, 400, 1000, 100);

        exit = new JButton("EXIT");
        exit.setBackground(Color.DARK_GRAY);
        exit.setForeground(Color.WHITE);
        exit.setBounds(450, 650, 100, 50);
        exit.addActionListener(this);

        tc1 = new JTextArea("  AARON");
        tc2 = new JTextArea("  THEJAS");
        tc3 = new JTextArea("  SHALOM");

        tc1.setEditable(false);
        tc2.setEditable(false);
        tc3.setEditable(false);

        tc1.setBounds(300, 242, 140, 20);
        tc2.setBounds(700, 242, 140, 20);
        tc3.setBounds(300, 442, 140, 20);

        
        eagle = new ImageIcon(getClass().getResource("eagle.png"));
        lion = new ImageIcon(getClass().getResource("lion.png"));
        tiger = new ImageIcon(getClass().getResource("tiger.png"));

        c1 = new JLabel(lion);
        c2 = new JLabel(tiger);
        c3 = new JLabel(eagle);
        
        c1.setBounds(200, 270, 120, 120);
        c2.setBounds(580, 270, 140, 120);
        c3.setBounds(200, 470, 120, 120);


        add(c1);
        add(c2);
        add(c3);
        add(tc1);
        add(tc2);
        add(tc3);    
        add(titleText);
        add(nominee1);
        add(nominee2);
        add(nominee3);
        add(exit);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == exit){
            new HomePage();
            dispose();
        }
    }
}

class display{
    public static void main(String[] args){
        new DisplayNominees();}
}
