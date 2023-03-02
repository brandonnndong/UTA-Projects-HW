package gui;

import javax.swing.JFrame;           // for main window
import javax.swing.JOptionPane;      // for standard dialogs

import javax.swing.JMenuBar;         // row of menu selections
import javax.swing.JMenu;            // menu selection that offers another menu
import javax.swing.JMenuItem;        // menu selection that does something

import javax.swing.JLabel;           // text or image holder
import javax.swing.ImageIcon;        // holds a custom icon
import javax.swing.SwingConstants;   // useful values for Swing method calls

import javax.imageio.ImageIO;        // loads an image from a file

import java.io.File;                 // opens a file
import java.io.IOException;          // reports an error reading from a file

import java.awt.image.BufferedImage; // holds an image loaded from a file

public class MainWin extends JFrame {
    public MainWin(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        
        // /////// ////////////////////////////////////////////////////////////////
        // M E N U
        // Add a menu bar to the PAGE_START area of the Border Layout
        

        JMenuBar menubar = new JMenuBar();
        
        JMenu     file       = new JMenu("File");
        JMenuItem quit       = new JMenuItem("Quit");
        JMenu     insert     = new JMenu("Insert");
        JMenuItem customer   = new JMenuItem("Customer");
        JMenuItem option     = new JMenuItem("Option");
        JMenuItem computer   = new JMenuItem("Computer");
        JMenu     view       = new JMenu("View");
        JMenuItem customers   = new JMenuItem("Customers");
        JMenuItem options     = new JMenuItem("Options");
        JMenuItem computers   = new JMenuItem("Computers");
        JMenu     help       = new JMenu("Help");
        JMenuItem about      = new JMenuItem("About");
        
        quit .addActionListener(event -> onQuitClick());
        customer.addActionListener(event -> onInsertCustomerClick());
        option.addActionListener(event -> onInsertOptionClick());
        computer.addActionListener(event -> onInsertComputerClick());
        customers.addActionListener(event -> onViewClick(Record.CUSTOMER));
        options.addActionListener(event -> onViewClick(Record.OPTION));
        computers.addActionListener(event -> onViewClick(Record.COMPUTER));
        about.addActionListener(event -> onAboutClick());

        
        file.add(quit);
        insert.add(customer);
        insert.add(option);
        insert.add(computer);
        view.add(customers);
        view.add(options);
        view.add(computers);
        help.add(about);
        
        menubar.add(file);
        menubar.add(insert);
        menubar.add(view);
        menubar.add(help);
        setJMenuBar(menubar);
        
    }
    
    // Listeners
    protected void onQuitClick() {System.exit(0);}   // Exit the game
    
    protected void onNewStoreClick() {         // Create a new game
        newStore();
        msg.setFont(new JLabel().getFont());    // Reset to default font
        
    }
    protected void onInsertCustomerClick(){
        newStore();
    }

    protected void onInsertOptionClick(){
        newStore();
    }

    protected void onInsertComputerClick(){
        newStore();
    }

    protected void onViewClick(Record record){
        newStore();
    }
   
    protected void onAboutClick() {                 // Display About dialog
        JLabel logo = null;
        try {
            BufferedImage myPicture = ImageIO.read(new File("128px-Pyramidal_matches.png"));
            logo = new JLabel(new ImageIcon(myPicture));
        } catch(IOException e) {
        }
        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+4>Nim</font></p>"
          + "<p>Version 1.4J</p>"
           + "</html>",
          SwingConstants.CENTER);

        JLabel artists = new JLabel("<html>"
          + "<br/><p>Copyright 2017-2023 by George F. Rice</p>"
          + "<p>Licensed under Gnu GPL 3.0</p><br/>"
          + "<p>Logo by M0tty, licensed under CC BY-SA 3.0</p>"
          + "<p><font size=-2>https://commons.wikimedia.org/wiki/File:Pyramidal_matches.svg</font></p>"
          + "<p>Robot by FreePik.com, licensed for personal</p><p>and commercial purposes with attribution</p>"
          + "<p><font size=-2>https://www.freepik.com/free-vector/grey-robot-silhouettes_714902.htm</font></p>"
          + "</html>");
          
         JOptionPane.showMessageDialog(this, 
             new Object[]{logo, title, artists},
             "The Game of Nim",
             JOptionPane.PLAIN_MESSAGE
         );
    }

    private void newStore(){

    }
    
    private JLabel msg;                     // Status message display
    //private JButton button1;                // Button to select 1 stick
    //private JButton button2;                // Button to select 2 sticks
    //private JButton button3;                // Button to select 3 sticks
    //private JToggleButton computerPlayer;   // Button to enable robot

}
