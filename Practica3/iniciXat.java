import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * general purpose powerful free layouts:
 * JGoodies' FormLayout
 * MigLayout
 * DesignGridLayout
 */

public class iniciXat implements ActionListener {
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
        JPanel usernamesTaken = new JPanel();
        usernamesTaken.setLayout(new BoxLayout(usernamesTaken, BoxLayout.LINE_AXIS));
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> users = new JList<>(listModel);
        users.setBackground(new Color(170, 74, 68));
        JLabel label = new JLabel("Usernames taken:");
        
        JPanel enterUsername = new JPanel();
        enterUsername.setLayout(new BoxLayout(enterUsername, BoxLayout.PAGE_AXIS));
        JLabel labelNewUser = new JLabel("Enter your username");
        JTextField textField = new JTextField(/* 25*/);
        JButton button = new JButton("Create");

        usernamesTaken.add(label);
        usernamesTaken.add(new JScrollPane(users));
        usernamesTaken.setMaximumSize(new Dimension(usernamesTaken.getMaximumSize().width, usernamesTaken.getMinimumSize().height));

        enterUsername.add(labelNewUser);
        enterUsername.add(textField);
        enterUsername.add(button);
        enterUsername.setMaximumSize(new Dimension(enterUsername.getMaximumSize().width, enterUsername.getMinimumSize().height));

        // add panels to main frame
        frame.add(usernamesTaken, BorderLayout.CENTER);
        frame.add(enterUsername, BorderLayout.PAGE_END);
        
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

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}