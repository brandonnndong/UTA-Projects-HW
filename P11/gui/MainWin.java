package gui;

import store.Store;
import store.Customer;
import store.Option;
import store.Computer;
import store.Order;

import javax.swing.JFrame;           // for main window
import javax.swing.JOptionPane;      // for standard dialogs
import javax.swing.JPanel;
import javax.swing.JTextField;
// import javax.swing.JDialog;          // for custom dialogs (for alternate About dialog)
import javax.swing.JMenuBar;         // row of menu selections
import javax.swing.JMenu;            // menu selection that offers another menu
import javax.swing.JMenuItem;        // menu selection that does something
import javax.swing.JToolBar;         // row of buttons under the menu
import javax.swing.JButton;          // regular button
import javax.swing.JToggleButton;    // 2-state button
import javax.swing.BorderFactory;    // manufacturers Border objects around buttons
import javax.swing.Box;              // to create toolbar spacer
import javax.swing.UIManager;        // to access default icons
import javax.swing.JLabel;           // text or image holder
import javax.swing.ImageIcon;        // holds a custom icon
import javax.swing.JComboBox;        // for selecting from lists
import javax.swing.SwingConstants;   // useful values for Swing method calls

import javax.imageio.ImageIO;        // loads an image from a file

import javax.swing.JFileChooser;     // File selection dialog
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;                 // opens a file
import java.io.FileReader;           // opens a file for reading
import java.io.BufferedReader;       // adds buffering to a FileReader
import java.io.FileWriter;           // opens a file for writing
import java.io.BufferedWriter;       // adds buffering to a FileWriter
import java.io.IOException;          // reports an error reading from a file

import java.awt.BorderLayout;        // layout manager for main window
import java.awt.FlowLayout;          // layout manager for About dialog

import java.awt.Color;               // the color of widgets, text, or borders
import java.awt.Dimension;
import java.awt.Font;                // rich text in a JLabel or similar widget
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage; // holds an image loaded from a file

public class MainWin extends JFrame {
    private final String NAME = "ELSA";
    private final String EXTENSION = "elsa";
    private final String VERSION = "0.3";
    private final String FILE_VERSION = "1.0";
    private final String MAGIC_COOKIE = "⮚Ě1şà⮘";
    private final String DEFAULT_STORE_NAME = "New " + NAME + " Store";

    public enum Record {CUSTOMER, OPTION, COMPUTER, ORDER};
    public MainWin(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1080);

        
        // /////// ////////////////////////////////////////////////////////////////
        // M E N U
        // Add a menu bar to the PAGE_START area of the Border Layout

        JMenuBar menubar = new JMenuBar();
        
        JMenu     file       = new JMenu("File");
        JMenuItem anew       = new JMenuItem("New");
        JMenuItem open       = new JMenuItem("Open");
                  save       = new JMenuItem("Save");
                  saveAs     = new JMenuItem("Save As");
        JMenuItem quit       = new JMenuItem("Quit");

        JMenu     insert     = new JMenu("Insert");
        JMenuItem iCust  = new JMenuItem("Customer");
        JMenuItem iOpt    = new JMenuItem("Option");
        JMenuItem iComp  = new JMenuItem("Computer");
        JMenuItem iOrd     = new JMenuItem("Order");
        
        JMenu     view       = new JMenu("View");
        JMenuItem vCust  = new JMenuItem("Customers");
        JMenuItem vOpt    = new JMenuItem("Options");
        JMenuItem vComp  = new JMenuItem("Computers");
        JMenuItem vOrd     = new JMenuItem("Orders");
        
        JMenu     help       = new JMenu("Help");
        JMenuItem about      = new JMenuItem("About");
        
        anew     .addActionListener(event -> onNewClick());
        open     .addActionListener(event -> onOpenClick());
        save     .addActionListener(event -> onSaveClick());
        saveAs   .addActionListener(event -> onSaveAsClick());
        quit     .addActionListener(event -> onQuitClick());

        iCust.addActionListener(event -> onInsertCustomerClick());
        iOpt  .addActionListener(event -> onInsertOptionClick());
        iComp.addActionListener(event -> onInsertComputerClick());
        iOrd   .addActionListener(event -> onInsertOrderClick());

        vCust.addActionListener(event -> onViewClick(Record.CUSTOMER));
        vOpt  .addActionListener(event -> onViewClick(Record.OPTION));
        vComp.addActionListener(event -> onViewClick(Record.COMPUTER));
        vOrd   .addActionListener(event -> onViewClick(Record.ORDER));

        about.addActionListener(event -> onAboutClick());

        file.add(anew);
        file.add(open);
        file.add(save);
        file.add(saveAs);
        file.add(quit);
        insert.add(iCust);
        insert.add(iOpt);
        insert.add(iComp);
        insert.add(iOrd);
        view.add(vCust);
        view.add(vOpt);
        view.add(vComp);
        view.add(vOrd);
        help.add(about);
        
        menubar.add(file);
        menubar.add(insert);
        menubar.add(view);
        menubar.add(help);
        setJMenuBar(menubar);
        // ///////////// //////////////////////////////////////////////////////////
        // T O O L B A R
        // Add a toolbar to the PAGE_START region below the menu
        JToolBar toolbar = new JToolBar("Nim Controls");

        JButton nButton  = new JButton(new ImageIcon("gui/resources/anew.png"));
          nButton.setActionCommand("Create a new ELSA file");
          nButton.setToolTipText("Create a new ELSA file");
          nButton.addActionListener(event -> onNewClick());
          bStyle(nButton);
          toolbar.add(nButton);
        
        JButton oButton  = new JButton(new ImageIcon("gui/resources/open.png"));
          oButton.setActionCommand("Load data from selected file");
          oButton.setToolTipText("Load data from selected file");
          oButton.addActionListener(event -> onOpenClick());
          bStyle(oButton);
          toolbar.add(oButton);
        
        sButton  = new JButton(new ImageIcon("gui/resources/save.png"));
          sButton.setActionCommand("Save data to default file");
          sButton.setToolTipText("Save data to default file");
          sButton.addActionListener(event -> onSaveClick());
          bStyle(sButton);
          toolbar.add(sButton);
        
        sAButton  = new JButton(new ImageIcon("gui/resources/save_as.png"));
          sAButton.setActionCommand("Save data to selected file");
          sAButton.setToolTipText("Save data to selected file");
          sAButton.addActionListener(event -> onSaveAsClick());
          bStyle(sAButton);
          toolbar.add(sAButton);
        
        toolbar.add(Box.createHorizontalStrut(25));

        JButton bAddCust = new JButton(new ImageIcon("gui/resources/add_customer.png"));
          bAddCust.setActionCommand("Insert Customer");
          bAddCust.setToolTipText("Insert Customer");
          bStyle(bAddCust);
          toolbar.add(bAddCust);
          bAddCust.addActionListener(event ->onInsertCustomerClick());

        JButton bAddOpt = new JButton(new ImageIcon("gui/resources/add_option.png"));
          bAddOpt.setActionCommand("Insert Option");
          bAddOpt.setToolTipText("Insert Option");
          bStyle(bAddOpt);
          toolbar.add(bAddOpt);
          bAddOpt.addActionListener(event -> onInsertOptionClick());

        JButton bAddComp = new JButton(new ImageIcon("gui/resources/add_computer.png"));
          bAddComp.setActionCommand("Insert Computer");
          bAddComp.setToolTipText("Insert Computer");
          bStyle(bAddComp);
          toolbar.add(bAddComp);
          bAddComp.addActionListener(event -> onInsertComputerClick());

        JButton bAddOrd = new JButton(new ImageIcon("gui/resources/add_order.png"));
          bAddOrd.setActionCommand("Insert Order");
          bAddOrd.setToolTipText("Insert Order");
          bStyle(bAddOrd);
          toolbar.add(bAddOrd);
          bAddOrd.addActionListener(event -> onInsertOrderClick());
        
        toolbar.add(Box.createHorizontalStrut(25));

        JButton bViewCust = new JButton(new ImageIcon("gui/resources/view_customers.png"));
          bViewCust.setActionCommand("View Customer");
          bViewCust.setToolTipText("View Customers");
          bStyle(bViewCust);
          toolbar.add(bViewCust);
          bViewCust.addActionListener(event ->onViewClick(Record.CUSTOMER));

        JButton bViewOpt = new JButton(new ImageIcon("gui/resources/view_options.png"));
          bViewOpt.setActionCommand("View Options");
          bViewOpt.setToolTipText("View Options");
          bStyle(bViewOpt);
          toolbar.add(bViewOpt);
          bViewOpt.addActionListener(event -> onViewClick(Record.OPTION));

        JButton bViewComp = new JButton(new ImageIcon("gui/resources/view_computers.png"));
          bViewComp.setActionCommand("View Computers");
          bViewComp.setToolTipText("View Computers");
          bStyle(bViewComp);
          toolbar.add(bViewComp);
          bViewComp.addActionListener(event -> onViewClick(Record.COMPUTER));

        JButton bViewOrd = new JButton(new ImageIcon("gui/resources/add_order.png"));
          bViewOrd.setActionCommand("View Order");
          bViewOrd.setToolTipText("View Order");
          bStyle(bViewOrd);
          toolbar.add(bViewOrd);
          bViewOrd.addActionListener(event -> onInsertOrderClick());
        
        getContentPane().add(toolbar, BorderLayout.PAGE_START);
       
        
        // /////////////////////////// ////////////////////////////////////////////
        // D I S P L A Y
        // Provide a label to show data requested by the user
        display = new JLabel();
        display.setFont(new Font("SansSerif", Font.BOLD, 14));
        display.setVerticalAlignment(JLabel.TOP);
        add(display, BorderLayout.CENTER);

        setVisible(true);
        
        onNewClick(DEFAULT_STORE_NAME);
    }
    
    private void bStyle(JButton button){
        Dimension fieldSize = new Dimension(button.getPreferredSize().width, button.getPreferredSize().height);
        button.setPreferredSize(fieldSize);
        button.setMinimumSize(fieldSize);
        button.setMaximumSize(fieldSize);
      }

    // Listeners
   protected void onNewClick() {onNewClick("");}
   protected void onNewClick(String name) { 
       if(name.isEmpty()) {
           name = JOptionPane.showInputDialog(this, "Store Name", DEFAULT_STORE_NAME);
           if(name.isEmpty()) name = DEFAULT_STORE_NAME;
       }
       store = new Store(name);
       setDirty(false);
       onViewClick(Record.CUSTOMER);
   }
   protected void onOpenClick() { 
        final JFileChooser fc = new JFileChooser(filename);  
        FileFilter elsaFiles = new FileNameExtensionFilter("ELSA files", EXTENSION);
        fc.addChoosableFileFilter(elsaFiles);         
        fc.setFileFilter(elsaFiles);                     
        
        int result = fc.showOpenDialog(this);              
        if (result == JFileChooser.APPROVE_OPTION) {         
            filename = fc.getSelectedFile();                
            
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String magicCookie = br.readLine();
                if(!magicCookie.equals(MAGIC_COOKIE)) throw new RuntimeException("Not an ELSA file");
                String fileVersion = br.readLine();
                if(!fileVersion.equals(FILE_VERSION)) throw new RuntimeException("Incompatible ELSA file format");
                
                store = new Store(br);                 
                onViewClick(Record.CUSTOMER);              
                setDirty(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Unable to load " + filename + '\n' + e, 
                    "Failed", JOptionPane.ERROR_MESSAGE); 
             }
        }
    }

    protected void onSaveClick() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(MAGIC_COOKIE + '\n');
            bw.write(FILE_VERSION + '\n');
            store.save(bw);
            setDirty(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unable to write " + filename + '\n' + e,
                "Failed", JOptionPane.ERROR_MESSAGE); 
        }
        setDirty(false);
    }

    protected void onSaveAsClick() {
        final JFileChooser fc = new JFileChooser(filename); 
        FileFilter elsaFiles = new FileNameExtensionFilter("ELSA files", EXTENSION);
        fc.addChoosableFileFilter(elsaFiles);        
        fc.setFileFilter(elsaFiles);                
        
        int result = fc.showSaveDialog(this);        
        if (result == JFileChooser.APPROVE_OPTION) {  
            filename = fc.getSelectedFile();         
            if(!filename.getAbsolutePath().endsWith("." + EXTENSION)) 
                filename = new File(filename.getAbsolutePath() + "." + EXTENSION);
            onSaveClick();                      
        }
    }

    protected void onQuitClick() {System.exit(0);} 

    protected String[] UnifiedDialog(String[] fields, String title, String iconFilename) {
        // Returning null indicates Cancel or X was clicked
        String[] result = null;
        
        // Load the icon if available
        ImageIcon icon = null;
        try {
            if(iconFilename != null) 
                icon = new ImageIcon(iconFilename);
        } catch(Exception e) {
        }

        // Widgets will include a label and JTextField for each field
        Object[] widgets = new Object[2*fields.length];
            
        // Create the widget pairs           
        for(int i=0; i<fields.length; ++i) {
            widgets[2*i] = new JLabel("<html><br>" + fields[i] + "</html>");
            widgets[2*i+1] = new JTextField();
        }
        
        // Show the dialog
        int button = JOptionPane.showConfirmDialog(this, widgets, title,
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, icon);
            
        // If the OK button was pressed, extract result from widgets
        if(button == JOptionPane.OK_OPTION) {
            result = new String[fields.length];
            for(int i=0; i<fields.length; ++i) {
                JTextField textField = (JTextField) widgets[2*i+1];
                result[i] = textField.getText();
            }
        } 
        return result;
    }
    
    protected void onInsertCustomerClick() {
        try{
            String[] result = UnifiedDialog(new String[]{"Name", "Email"}, "New Customer", "gui/resources/add_customer.png");
            if(result != null) {
                store.add(new Customer(result[0], result[1]));
                setDirty(true);
                onViewClick(Record.CUSTOMER);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, e, "Customer Not Created", JOptionPane.ERROR_MESSAGE);
        }
    }
            
    protected void onInsertOptionClick() { 
        try {
            String[] result = UnifiedDialog(new String[]{"Name", "Cost"},
                "New Option", "gui/resources/add_option.png");
            
            if(result != null) {
                store.add(new Option(result[0], (long) (100.0 * Double.parseDouble(result[1]))));
                setDirty(true);
                onViewClick(Record.OPTION);
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, e, "Option Not Created", JOptionPane.ERROR_MESSAGE);
        }    
    
    }
            
    protected void onInsertComputerClick() { 
        ImageIcon icon = null;
        try {
             icon = new ImageIcon("gui/resources/add_computer.png");
        } catch(Exception e) {
        }
        try {
            String[] result = UnifiedDialog(new String[]{"Computer Name", "Computer Model"},
                "New Computer", "gui/resources/add_computer.png");
            if(result == null) return;

            Computer c = new Computer(result[0], result[1]);
 
            JComboBox<Object> cb = new JComboBox<>(store.options());
            int optionsAdded = 0; // Don't add computers with no options
            while(true) {
                int button = JOptionPane.showConfirmDialog(this, cb, "Another Option?", 
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, icon);
                if(button != JOptionPane.YES_OPTION) break;
                c.addOption((Option) cb.getSelectedItem());
                ++optionsAdded;
            }
            if(optionsAdded > 0) {
                store.add(c);
                onViewClick(Record.COMPUTER);
                setDirty(true);
            }
        } catch(NullPointerException e) {
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, e, "Computer Not Created", JOptionPane.ERROR_MESSAGE);
        }    
    }

    protected void onInsertOrderClick(){
        try{
            Customer customer = null;
            if (store.customers().length == 0) {
                onInsertCustomerClick();
                return;
            } else if (store.customers().length == 1) {
                onViewClick(Record.COMPUTER);
            } else {
                JComboBox<Object> customerComboBox = new JComboBox<>(store.customers());
                int result = JOptionPane.showConfirmDialog(this, customerComboBox, "Order for which Customer?", JOptionPane.OK_CANCEL_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                    customer = (Customer) customerComboBox.getSelectedItem();
                    } else {
                    return;
                    }       
            }
    
            Order order = new Order(customer);
            int computersAdded = 0;
            while (true) {
                JComboBox<Object> computerComboBox = new JComboBox<>(store.computers());
                int result = JOptionPane.showConfirmDialog(this, computerComboBox, "Add computer to order?", JOptionPane.YES_NO_CANCEL_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    Computer selectedComputer = (Computer) computerComboBox.getSelectedItem();
                    order.addComputer(selectedComputer);
                    ++computersAdded;
                } else if (result == JOptionPane.NO_OPTION) {
                    break;
                } else {
                    return;
                }
            }

            if (computersAdded > 0) {
                store.add(order);
                setDirty(true);
                onViewClick(Record.ORDER);
            }

        } catch(NullPointerException e) {
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, e, "Order Not Created", JOptionPane.ERROR_MESSAGE);
        } 
    }
                        
    protected void onViewClick(Record record) { 
        String header = null;
        Object[] list = null;
        if(record == Record.CUSTOMER) {
            header = "Our Beloved Customers";
            list = store.customers();
        }
        if(record == Record.OPTION) {
           header = "Options for our SuperComputers";
           list = store.options();
        }
        if(record == Record.COMPUTER) {
            header = "Computers for Sale - Cheap!";
            list = store.computers();
        }
        if(record == Record.ORDER) {
            header = "Orders Placed to Date";
            list = store.orders();
        }
        
        StringBuilder sb = new StringBuilder("<html><p><font size=+2>" + header + "</font></p><br/>\n<ol>\n");
        for(Object i : list) sb.append("<li>" + i.toString().replaceAll("<","&lt;")
                                                            .replaceAll(">", "&gt;")
                                                            .replaceAll("\n", "<br/>") + "</li>\n");
        sb.append("</ol></html>");
        display.setText(sb.toString());
    }
            
    protected void onAboutClick() {                 
        Canvas logo = new Canvas("gui/resources/logo420.png");

        JLabel title = new JLabel("<html>"
          + "<p><font size=+4>" + NAME + "</font></p>"
          + "</html>",
          SwingConstants.CENTER);

        JLabel subtitle = new JLabel("<html>"
          + "<p>Exceptional Laptops and Supercomputers Always</p>"
          + "</html>",
          SwingConstants.CENTER);

        JLabel version = new JLabel("<html>"
          + "<p>Version " + VERSION + "</p>"
          + "</html>",
          SwingConstants.CENTER);

        JLabel artists = new JLabel("<html>"
          + "<br/><p>Copyright 2023-2023 by Quang Minh Dong</p>"
          + "<p>Licensed under Gnu GPL 3.0</p><br/>"

          + "<br/><p>Logo based on work by CleanPNG</p>"
          + "<p><font size=-2>https://www.cleanpng.com/free/computer-logo.html</font></p>"
          
          + "<br/><p>Add Customer icon based on work by Google Fonts</p>"
          + "<p><font size=-2>https://fonts.google.com/icons?icon.category=content</font></p>"

          + "<br/><p>View Customers icon based on work by Google Fonts</p>"
          + "<p><font size=-2>https://fonts.google.com/icons?icon.category=content</font></p>"

          + "<br/><p>Add Option icon based on work by Google Fonts</p>"
          + "<p><font size=-2>https://fonts.google.com/icons?icon.category=content</font></p>"

          + "<br/><p>View Options icon based on work by Google Fonts</p>"
          + "<p><font size=-2>https://fonts.google.com/icons?icon.category=content</font></p>"

          + "<br/><p>Add Computer icon based on work by Google Fonts</p>"
          + "<p><font size=-2>https://fonts.google.com/icons?icon.category=content</font></p>"

          + "<br/><p>View Computers icon based on work by Google Fonts</p>"
          + "<p><font size=-2>https://fonts.google.com/icons?icon.category=content</font></p>"
 
          + "<br/><p>New and open icon based on work by Google Fonts</p>"
          + "<p><font size=-2>https://fonts.google.com/icons?icon.category=content</font></p>"

          + "<br/><p>Save and Save As icons based on work by Google Fonts</p>"
          + "<p><font size=-2>https://fonts.google.com/icons?icon.category=content</font></p>"

          + "<br/><p>Add and View Order icons based on work by Google Fonts</p>"
          + "<p><font size=-2>https://fonts.google.com/icons?icon.category=content</font></p>"

          + "</html>");
          
        JOptionPane.showMessageDialog(this, 
            new Object[]{logo, title, subtitle, version, artists},
            "ELSA",
            JOptionPane.PLAIN_MESSAGE
        );
    }

    private void setDirty(boolean isDirty) {
        save.setEnabled(isDirty);
        saveAs.setEnabled(isDirty);
        sButton.setEnabled(isDirty);
        sAButton.setEnabled(isDirty);
    };


    private Store store;                      
    private JLabel display;                 

    private File filename;
    
    private JMenuItem save;
    private JMenuItem saveAs;
    private JButton sButton;
    private JButton sAButton;

}
