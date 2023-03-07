package gui;

import javax.swing.JFrame;           // for main window
import javax.swing.JOptionPane;      // for standard dialogs
import javax.swing.JToolBar;
import javax.swing.JMenuBar;         // row of menu selections
import javax.swing.JMenu;            // menu selection that offers another menu
import javax.swing.JMenuItem;        // menu selection that does something

import javax.swing.JLabel;           // text or image holder
import javax.swing.Box;
import javax.swing.ImageIcon;        // holds a custom icon
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;   // useful values for Swing method calls
import javax.swing.UIManager;

import store.Option;

import javax.imageio.ImageIO;        // loads an image from a file

import java.io.File;                 // opens a file
import java.io.IOException;          // reports an error reading from a file
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.image.BufferedImage; // holds an image loaded from a file

public class MainWin extends JFrame {
    public MainWin(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        
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
        
        quit.addActionListener(event -> onQuitClick());
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

        store = new JLabel();
        store.setFont(new Font("SansSerif", Font.BOLD,18));
        add(store, BorderLayout.CENTER);

        

        JToolBar toolbar = new JToolBar();

        ImageIcon ii = new ImageIcon("gui/image.png");
        button1 = new JButton(new ImageIcon("image.png"));
        button1.setActionCommand("Insert Customer");
        button1.setToolTipText("Insert Customer");
        toolbar.add(button1);

        button2 = new JButton(new ImageIcon("image.png"));
        button2.setActionCommand("Insert Option");
        button2.setToolTipText("Insert Option");
        toolbar.add(button2);

        button3 = new JButton(new ImageIcon("image.png"));
        button3.setActionCommand("Insert Computer");
        button3.setToolTipText("Insert Computer");
        toolbar.add(button3);

        toolbar.add(Box.createHorizontalStrut(25));

        button4 = new JButton(new ImageIcon("image.png"));
        button4.setActionCommand("View Customers");
        button4.setToolTipText("View Customers");
        toolbar.add(button4);
        
        button5 = new JButton(new ImageIcon("image.png"));
        button5.setActionCommand("View Options");
        button5.setToolTipText("View Options");
        toolbar.add(button5);

        button6 = new JButton(new ImageIcon("image.png"));
        button6.setActionCommand("View Computers");
        button6.setToolTipText("View Computers");
        toolbar.add(button6);

        getContentPane().add(toolbar, BorderLayout.PAGE_START);

        setVisible(true);

    }
    
    // Listeners
    protected void onQuitClick(){
        System.exit(0);
    }   // Exit the game
    
    protected void onNewStoreClick(){         // Create a new game
       
    }

    protected void onInsertCustomerClick(){
        try{
        JOptionPane.showInputDialog(this, "Customer name", "New Customer"); 
        JOptionPane.showInputDialog(this, "Customer email", "New Customer");
        }catch(Exception e){
            store.setText("invalid email");
        }
    }

    protected void onInsertOptionClick(){
        try{
            String name = JOptionPane.showInputDialog("name","name");
            String cost = JOptionPane.showInputDialog("cost", "cost");
            Double d = Double.parseDouble(cost);
            Double dCost = 100 * d;
            Long c = Double.valueOf(dCost).longValue();
            Option o = new Option(name, c);
            System.out.print(o);
        }catch(Exception e){
            store.setText("invalid cost");
        }
    }

    protected void onInsertComputerClick(){
            JOptionPane.showInputDialog(this, "Computer name", "Computer name");
            JOptionPane.showInputDialog(this, "Model", "Model");
            /*view = new JComboBox<Object>(options);
            view.addActionListener(event -> JOptionPane.showConfirmDialog(this, (Object)view.getSelectedItem()));
            this.add(view);
            System.out.print(view);
            this.setVisible(true);*/
    }

    protected void onViewClick(Record record){
        
       
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
    private JLabel store;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    //private JComboBox view;
}
