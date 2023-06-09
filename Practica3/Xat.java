import java.awt.*;
import javax.swing.*;

/**
 * general purpose powerful free layouts:
 * JGoodies' FormLayout
 * MigLayout
 * DesignGridLayout
 */

public class Xat {
    private static void createAndShowGUI() {
        //Set the look and feel.
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {

        }
        
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create and set up the window.
        JFrame frame = new JFrame("Xat");
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create an output JPanel and add a JList with the messages inside a JScrollPane
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> messages = new JList<>(listModel);
        JPanel output = new JPanel();
        output.setLayout(new BoxLayout(output, BoxLayout.PAGE_AXIS));
         // Create the list and put it in a scroll pane.
        JLabel usersLabel= new JLabel("Users available");
        output.add(usersLabel);

        // Create a list available users 
        DefaultListModel<String> listUsers = new DefaultListModel<>();
        JList<String> users = new JList<>(listUsers);
        users.setBackground(new Color(0, 255, 0));
        JScrollPane scrollPane = new JScrollPane(users);
        scrollPane.setMaximumSize(new Dimension(scrollPane.getMaximumSize().width, scrollPane.getMinimumSize().height));
        output.add(scrollPane);
        output.add(new JScrollPane(messages));
        frame.add(output);

        // Create an input JPanel and add a JTextField(25) and a JButton
        JPanel input = new JPanel();
        input.setLayout(new BoxLayout(input, BoxLayout.LINE_AXIS));
        JTextField textField = new JTextField(/* 25*/);
        JButton button = new JButton("Send");
        input.add(textField);
        input.add(button);
        input.setMaximumSize(new Dimension(input.getMaximumSize().width, input.getMinimumSize().height));

        // add panels to main frame
        frame.add(output, BorderLayout.CENTER);
        frame.add(input, BorderLayout.PAGE_END);
        
        //Display the window centered.
        //frame.pack();
        frame.setSize(400,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}