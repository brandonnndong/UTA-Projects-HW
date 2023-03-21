package gui;

import javax.swing.JFrame;           // for main window
import javax.swing.JOptionPane;      // for standard dialogs
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;         // row of menu selections
import javax.swing.JMenu;            // menu selection that offers another menu
import javax.swing.JMenuItem;        // menu selection that does something

import javax.swing.JLabel;           // text or image holder
import javax.swing.Box;
import javax.swing.ImageIcon;        // holds a custom icon
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;   // useful values for Swing method calls
import javax.swing.filechooser.FileNameExtensionFilter;

import store.Computer;
import store.Customer;
import store.Option;
import store.Store;

import javax.imageio.ImageIO;        // loads an image from a file
import javax.management.RuntimeErrorException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;                 // opens a file
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;          // reports an error reading from a file
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage; // holds an image loaded from a file

public class MainWin extends JFrame {
    public MainWin(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        add(new canva());
        pack();
        
        JMenuBar menubar = new JMenuBar();
        
        JMenu     file        = new JMenu("File");
        JMenuItem quit        = new JMenuItem("Quit");
        JMenuItem nnew        = new JMenuItem("New");
        JMenuItem open        = new JMenuItem("Open");
        JMenuItem save        = new JMenuItem("Save");
        JMenuItem saveas        = new JMenuItem("Save As");
        JMenu     insert      = new JMenu("Insert");
        JMenuItem customer    = new JMenuItem("Customer");
        JMenuItem option      = new JMenuItem("Option");
        JMenuItem computer    = new JMenuItem("Computer");
        JMenu     view        = new JMenu("View");
        JMenuItem customers   = new JMenuItem("Customers");
        JMenuItem options     = new JMenuItem("Options");
        JMenuItem computers   = new JMenuItem("Computers");
        JMenu     help        = new JMenu("Help");
        JMenuItem about       = new JMenuItem("About");
        
        quit.addActionListener(event -> onQuitClick());
        nnew.addActionListener(event -> onNewClick());
        open.addActionListener(event -> onOpenClick());
        save.addActionListener(event -> onSaveClick());
        saveas.addActionListener(event -> onSaveAsClick());
        customer.addActionListener(event -> onInsertCustomerClick());
        option.addActionListener(event -> onInsertOptionClick());
        computer.addActionListener(event -> onInsertComputerClick());
        customers.addActionListener(event -> onViewClick(Record.CUSTOMER));
        options.addActionListener(event -> onViewClick(Record.OPTION));
        computers.addActionListener(event -> onViewClick(Record.COMPUTER));
        about.addActionListener(event -> onAboutClick());
        
        file.add(quit);
        file.add(nnew);
        file.add(open);
        file.add(save);
        file.add(saveas);
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

        JToolBar toolbar = new JToolBar("ELSA Controls");

        ImageIcon i = new ImageIcon("gui/image.png");
        button1 = new JButton(new ImageIcon("image.png"));
        button1.setActionCommand("Insert Customer");
        button1.setToolTipText("Insert Customer");
        toolbar.add(button1);
        button1.addActionListener(event -> onInsertCustomerClick());

        button2 = new JButton(new ImageIcon("image.png"));
        button2.setActionCommand("Insert Option");
        button2.setToolTipText("Insert Option");
        toolbar.add(button2);
        button2.addActionListener(event -> onInsertOptionClick());

        button3 = new JButton(new ImageIcon("image.png"));
        button3.setActionCommand("Insert Computer");
        button3.setToolTipText("Insert Computer");
        toolbar.add(button3);
        button3.addActionListener(event -> onInsertComputerClick());

        toolbar.add(Box.createHorizontalStrut(25));

        button4 = new JButton(new ImageIcon("image.png"));
        button4.setActionCommand("View Customers");
        button4.setToolTipText("View Customers");
        toolbar.add(button4);
        button4.addActionListener(event -> onViewClick(Record.CUSTOMER));
        
        button5 = new JButton(new ImageIcon("image.png"));
        button5.setActionCommand("View Options");
        button5.setToolTipText("View Options");
        toolbar.add(button5);
        button5.addActionListener(event -> onViewClick(Record.OPTION));

        button6 = new JButton(new ImageIcon("image.png"));
        button6.setActionCommand("View Computers");
        button6.setToolTipText("View Computers");
        toolbar.add(button6);
        button6.addActionListener(event -> onViewClick(Record.COMPUTER));

        getContentPane().add(toolbar, BorderLayout.PAGE_START);

        display = new JLabel();
        display.setFont(new Font("SansSerif", Font.BOLD,18));
        display.setVerticalAlignment(JLabel.TOP);
        add(display, BorderLayout.CENTER);

        setVisible(true);

        onNewClick();
    }
    
    public void save(BufferedWriter bw) throws IOException{
        bw.write("" + options.size() + '\n');
        for (Option o : options)o.save(bw);
    }
    public MainWin (BufferedReader br) throws IOException{
        String s = br.readLine();
        Long l = Long.parseLong(br.readLine());
        Double d = Double.parseDouble(br.readLine());
        int size = Integer.parseInt(br.readLine());
        Option o = new Option(br);
        while(l-- > 0) options.add(new Option(br));
        while(d-- > 0) options.add(new Option(br));
        while(size-- > 0) options.add(new Option(br));
        while(size-- > 0) options.add(new Option(br));
        while(size-- > 0) options.add(new Option(br));
    }
    // Listeners
    protected void onQuitClick(){
        System.exit(0);
    }   // Exit the game

    protected void onNewClick(){
        store = new Store("Elsa Computers");
    }

    protected void onOpenClick(){
        final JFileChooser fc = new JFileChooser(filename);
        FileNameExtensionFilter files = new FileNameExtensionFilter("Text Document", "txt");
        fc.addChoosableFileFilter(files);
        fc.setFileFilter(files);

        int result = fc.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
            filename = fc.getSelectedFile();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String s = br.readLine();
            store = new Store("Elsa Computers"); 
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Unable to open" + filename + "\n" + e, "Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    protected void onSaveClick() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
            store = new Store("Elsa Computers");
            store.save(bw); 
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, "Unable to open" + filename + "\n" + e, "Failed", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    protected void onSaveAsClick(){
        final JFileChooser fc = new JFileChooser(filename);
        FileNameExtensionFilter files = new FileNameExtensionFilter("Text Document", "txt");
        fc.addChoosableFileFilter(files);
        fc.setFileFilter(files);

        int result = fc.showSaveDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
            filename = fc.getSelectedFile();
            if(!filename.getAbsolutePath().endsWith(".txt"))
                filename = new File(filename.getAbsolutePath(), ".txt");
            onSaveAsClick();
        }
    }

    protected void onInsertCustomerClick(){
        try{
        store.add(new Customer(JOptionPane.showInputDialog(this, "Customer name", "New Customer", JOptionPane.QUESTION_MESSAGE), 
        JOptionPane.showInputDialog(this, "Customer email", "New Customer", JOptionPane.QUESTION_MESSAGE)));
        onViewClick(Record.CUSTOMER);
        }catch(NullPointerException e){
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e, "Customer not created", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void onInsertOptionClick(){
        try{
            store.add(new Option(
                JOptionPane.showInputDialog(this, "Option Name",
                "New Option", JOptionPane.QUESTION_MESSAGE), 
            (long) (100 * Double.parseDouble(JOptionPane.showInputDialog(this, 
                "Option Cost", "New Option",JOptionPane.QUESTION_MESSAGE)))));
            onViewClick(Record.OPTION);
        }catch(NullPointerException e){
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e, "Customer not created", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void onInsertComputerClick(){
        try{
            Computer c = new Computer(
                JOptionPane.showInputDialog(this, "Computer Name",
                "New Computer", JOptionPane.QUESTION_MESSAGE), 
            (JOptionPane.showInputDialog(this, 
                "Model Name", "Model Name",JOptionPane.QUESTION_MESSAGE)));
            JComboBox<Object> lan = new JComboBox<>(store.options());
            int addedOp = 0;
            while(true){
                int button = JOptionPane.showConfirmDialog(this, lan, "Another Option?",
                JOptionPane.YES_NO_OPTION);
                if(button != JOptionPane.YES_OPTION) break;
                c.addOption((Option) lan.getSelectedItem());
                ++addedOp;
            }
            if(addedOp > 0){
                store.add(c);
                onViewClick(Record.COMPUTER);
            }
        }catch(NullPointerException e){
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e, "Customer not created", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void onViewClick(Record record){
        String header = null;
        Object[] list = null;
        if(record == Record.CUSTOMER){
            header = "Customer List";
            list = store.customers();
        }
        if(record == Record.OPTION){
            header = "Computer Option List";
            list = store.options();
        }
        if(record == Record.COMPUTER){
            header = "Computer List";
            list = store.computers();
        }
        if(record == Record.ORDER){
            header = "Placed Orders";
            list = store.orders();
        }

        StringBuilder sList = new StringBuilder("<html><p><font size=+2>" + header + "</font></p><br/>\n<ol>\n");
        for(Object i : list) sList.append("<li>" + i.toString().replaceAll("<","&lt;")
            .replaceAll(">", "&gt;")
                                  .replaceAll("\n", "<br/>") + "</li>\n");
        sList.append("</ol></html>");
        display.setText(sList.toString());
    }
   
    class canva extends JPanel{
        public Dimension getPreferredSize(){
            return new Dimension(1280,720);
        }
    
        @Override
        public void paintComponent(Graphics graphics){
            super.paintComponent(graphics);
            Graphics2D g = (Graphics2D) graphics.create();
    
            int x = 30;
            int y = 50;
            int w = 420;
            int h = 120;
            int aw = 20;
            int ah = 20;
    
            g.drawRoundRect(x,y,w,h,aw,ah);
    
            g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
            g.drawString("Elsa Computers for all!", x, y);
        }
    }

    protected void onAboutClick() {                 // Display About dialog
        JLabel logo = null;
        try {
            BufferedImage myPicture = ImageIO.read(new File("128px-Pyramidal_matches.png"));
            logo = new JLabel(new ImageIcon(myPicture));
        } catch(IOException e) {
        }
        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+4>ELSA</font></p>"
          +"<p>Exceptional Laptops and Supercomputers Always<p>"
          + "<p>Version 0.1</p>"
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
    private ArrayList<Option> options;
    private File filename;
    private Store store;
    private JLabel  display;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
}
