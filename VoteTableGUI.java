import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.Image;

public class VoteTableGUI extends JFrame implements ActionListener {
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextArea area;
    private JButton rb;
    private JButton backButton; // New Back button

    public VoteTableGUI() {
        Connect obj = new Connect();
        int[] finalCount;

        try {
            finalCount = obj.getResult();
        } catch (Exception e) {
            e.printStackTrace();
            finalCount = new int[]{0, 0, 0, 0}; // Default values in case of an exception
        }

        setTitle("Vote Table");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        area = new JTextArea();
        rb = new JButton("Show Winners");
        rb.addActionListener(this);

        backButton = new JButton("Back"); // Initialize the Back button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminPage();
                dispose();
            }
        });

        // Create the table model with 4 rows and 3 columns
        tableModel = new DefaultTableModel(4, 3);
        tableModel.setColumnIdentifiers(new Object[]{"SNo.", "Nominee", "Votes"});

        // Fill in the initial serial numbers, nominee names, and vote values
        String[] nominees = {"Aaron", "Thejas", "Shalom", "NOTA"};
        for (int i = 0; i < 4; i++) {
            tableModel.setValueAt(i + 1, i, 0);
            tableModel.setValueAt(nominees[i], i, 1);
            tableModel.setValueAt(finalCount[i], i, 2); // Set the vote values from finalCount
        }

        // Create the table with the table model
        table = new JTable(tableModel);

        // Set table cell selection to single selection mode
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Create a JScrollPane to hold the table
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Add the buttons, text area, and image to the GUI
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(createImagePanel(), BorderLayout.NORTH);
        panel.add(rb, BorderLayout.WEST);
        panel.add(backButton, BorderLayout.EAST); // Add the Back button to the right
        panel.add(area, BorderLayout.SOUTH);
        getContentPane().add(panel, BorderLayout.SOUTH);
    }

    private JPanel createImagePanel() {
        JPanel imagePanel = new JPanel();
        ImageIcon originalIcon = new ImageIcon("Homedisplay.png"); // Change "Homedisplay.png" to your image file
        Image originalImage = originalIcon.getImage();
        int newWidth = (int) (originalImage.getWidth(null) * 0.75); // Reduce width by 25%
        int newHeight = (int) (originalImage.getHeight(null) * 0.75); // Reduce height by 25%
        Image image = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel label = new JLabel(scaledIcon);
        imagePanel.add(label);
        return imagePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Determine and declare the winner(s) or tie
        int highestVotes = -1;
        boolean isTie = false;
        StringBuilder winners = new StringBuilder("Winners: ");

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            int votes = (int) tableModel.getValueAt(i, 2);
            if (votes > highestVotes) {
                highestVotes = votes;
                isTie = false;
                winners = new StringBuilder("Winners: " + tableModel.getValueAt(i, 1) + " with " + highestVotes + " votes");
            } else if (votes == highestVotes) {
                isTie = true;
                winners.append(", ").append(tableModel.getValueAt(i, 1));
            }
        }

        area.setText(""); // Clear the text area
        if (isTie) {
            area.append(winners.toString() + " \n\n \t ITS A TIE \n");
        } else {
            area.append(winners.toString() + ".\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VoteTableGUI();
        });
    }
}
