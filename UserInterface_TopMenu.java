// Package declaration for the UserInterface_TopMenu package
package UserInterface_TopMenu;

// Import statements for necessary Java classes and components
import java.util.Calendar;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

// Class definition for the UserInterface_TopMenu class, which extends JFrame
public class UserInterface_TopMenu extends JFrame{

    // Constant for the date format
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    // Static variables for the menu bar, menu, frame, and menu items
    static JMenuBar menuBar;
    static JMenu menu;
    static JFrame frame;
    static JMenuItem dateTimeItem, textItem, backgroundColorItem, exitItem;

    // Static variables for the panel and label used in the interface
    static JPanel panel;
    static JLabel dateTimeLabel;

    // Main method, the entry point of the program
    public static void main(String[] args) {

        // Create a new JFrame with a title
        frame = new JFrame("Menu Frame");

        // Create a new menu bar
        menuBar = new JMenuBar();

        // Create a new menu with the label "Menu"
        menu = new JMenu("Menu");

        // Create a label for displaying date and time
        dateTimeLabel = new JLabel("Date/Time:");

        // Create a menu item for displaying date and time
        dateTimeItem = new JMenuItem("Date/Time");

        // ActionListener for updating the label with the current date and time
        dateTimeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
                dateTimeLabel.setText(dateFormat.format(calendar.getTime()));
            }
        });

        // Create a menu item for saving text to a file
        textItem = new JMenuItem("Save Text");

        // ActionListener for saving the current date and time to a file
        textItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"));
                    writer.write(dateTimeLabel.getText());
                    writer.close();
                } catch (IOException ioe) {
                    // Handle IOException, if any
                }
            }
        });

        // Create a menu item for randomizing the background color
        backgroundColorItem = new JMenuItem("Randomize background");

        // ActionListener for changing the background color to a random color
        backgroundColorItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Random r = new Random();
                int green = r.nextInt(254) + 1;
                panel.setBackground(new Color(0, green, 0));
            }
        });

        // Create a menu item for exiting the program
        exitItem = new JMenuItem("Exit");

        // ActionListener for exiting the program
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        // Add menu items to the menu
        menu.add(dateTimeItem);
        menu.add(textItem);
        menu.add(backgroundColorItem);
        menu.add(exitItem);

        // Set layout for the menu bar and add menu to it
        menuBar.setLayout(new GridBagLayout());
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(menu);

        // Set the menu bar for the frame
        frame.setJMenuBar(menuBar);

        // Create a panel and add the date/time label to it
        panel = new JPanel();
        panel.add(dateTimeLabel);

        // Add the panel to the frame
        frame.add(panel);

        // Set size and make the frame visible
        frame.setSize(210, 180);
        frame.setVisible(true);
    }
}