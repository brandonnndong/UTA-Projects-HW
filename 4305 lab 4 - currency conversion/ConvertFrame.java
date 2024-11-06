/*
 * Quang Minh Dong
 * INSY - 4305 - 004
 * Lab 4
 * 11/4/2024
 */

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ConvertFrame extends JFrame{
    private JLabel from;
    private JLabel input;
    private JLabel convert;
    private JLabel output;

    private JPanel buttons;

    private JPanel fromJPanel;
    private JPanel inputJPanel;
    private JPanel convertJPanel;
    private JPanel outputJPanel;

    private JPanel imagePanel;
    private JLabel usLabel;
    private JLabel mxLabel;
    private JLabel euLabel;
    private JPanel imagePanel2;
    private JLabel usLabel2;
    private JLabel mxLabel2;
    private JLabel euLabel2;

    private JTextField inputField;
    private JTextField outputField;
    
    private JPanel rbPanel;
    private JRadioButton USD;
    private JRadioButton Peso;
    private JRadioButton Euro;
    private ButtonGroup rbg;
    private JPanel rbPanel2;
    private JRadioButton USD2;
    private JRadioButton Peso2;
    private JRadioButton Euro2;
    private ButtonGroup rbg2;
    
    private final double usdToPeso = 20.0919;
    private final double usdToEuro = 0.9181;

    public ConvertFrame(){
        super("Currency Conversion");
        
        //Create JMenu and items
        JMenu fileMenu = new JMenu("File");
        JMenuItem about = new JMenuItem("About");
        JMenuItem convCurr = new JMenuItem ("Convert");
        JMenuItem clear = new JMenuItem("Clear");
        JMenuItem exit = new JMenuItem("Exit");

        //Add ActionListeners to JMenu items
        about.addActionListener(new AboutListener());
        convCurr.addActionListener(new ConvertListener());
        clear.addActionListener(new ClearListener());
        exit.addActionListener(new ExitListener());
        
        //Add JMenu items to JMenu 
        fileMenu.add(about);
        fileMenu.add(convCurr);
        fileMenu.add(clear);
        fileMenu.add(exit);

        //Create menu bar and add filemenu to menu bar
        JMenuBar bar = new JMenuBar();
        bar.add(fileMenu);
        setJMenuBar(bar); 

        //Create radio button panel
        rbPanel = new JPanel();
        rbPanel2 = new JPanel();
        rbPanel.setLayout(new GridLayout(1, 3));
        rbPanel2.setLayout(new GridLayout(1, 3));

        //Create radio buttons
        USD = new JRadioButton("US Dollar",true);
        USD2 = new JRadioButton("US Dollar",true);
        Peso = new JRadioButton("Peso");
        Peso2 = new JRadioButton("Peso");
        Euro = new JRadioButton("Euro");
        Euro2 = new JRadioButton("Euro");

        //Create radio button groups
        rbg = new ButtonGroup();
        rbg2 = new ButtonGroup();

        //Group radio buttons
        rbg.add(USD);
        rbg2.add(USD2);
        rbg.add(Peso);
        rbg2.add(Peso2);
        rbg.add(Euro);
        rbg2.add(Euro2);

        //Add radio buttons to panels
        rbPanel.add(USD);
        rbPanel2.add(USD2);
        rbPanel.add(Peso);
        rbPanel2.add(Peso2);
        rbPanel.add(Euro);        
        rbPanel2.add(Euro2);

        //Create labels
        from = new JLabel("Convert From:");
        input = new JLabel("Enter Currency:");
        convert = new JLabel("Convert To:");
        output = new JLabel("Comparable Currency is:");

        //Create label panel
        fromJPanel = new JPanel();
        inputJPanel = new JPanel();
        convertJPanel = new JPanel();
        outputJPanel = new JPanel();

        //Set panel layout
        fromJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        inputJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        convertJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        outputJPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        //Add labels to corresponding panels
        fromJPanel.add(from);
        inputJPanel.add(input);
        convertJPanel.add(convert);
        outputJPanel.add(output);

        //Create icon image panel
        imagePanel = new JPanel();
        imagePanel2 = new JPanel();
        imagePanel.setLayout(new GridLayout(1, 3));
        imagePanel2.setLayout(new GridLayout(1, 3));

        //Create imageicons
        Icon USD = new ImageIcon(getClass().getResource("dollar.jpg"));
        Icon Peso = new ImageIcon(getClass().getResource("peso.jpg"));
        Icon Euro = new ImageIcon(getClass().getResource("euro.jpg"));
        Icon USD2 = new ImageIcon(getClass().getResource("dollar.jpg"));
        Icon Peso2 = new ImageIcon(getClass().getResource("peso.jpg"));
        Icon Euro2 = new ImageIcon(getClass().getResource("euro.jpg"));

        //Put image icons into labels
        usLabel = new JLabel(USD);
        mxLabel = new JLabel(Peso);
        euLabel = new JLabel(Euro);
        usLabel2 = new JLabel(USD2);
        mxLabel2 = new JLabel(Peso2);
        euLabel2 = new JLabel(Euro2);

        //Set label size
        usLabel.setSize(20, 20);
        mxLabel.setSize(20, 20);
        euLabel.setSize(20, 20);
        usLabel2.setSize(20, 20);
        mxLabel2.setSize(20, 20);
        euLabel2.setSize(20, 20);

        //Align images to the left
        usLabel.setHorizontalAlignment(SwingConstants.LEFT);
        mxLabel.setHorizontalAlignment(SwingConstants.LEFT);
        euLabel.setHorizontalAlignment(SwingConstants.LEFT);
        usLabel2.setHorizontalAlignment(SwingConstants.LEFT);
        mxLabel2.setHorizontalAlignment(SwingConstants.LEFT);
        euLabel2.setHorizontalAlignment(SwingConstants.LEFT);

        //Add labels to panels
        imagePanel.add(usLabel);
        imagePanel.add(mxLabel);
        imagePanel.add(euLabel);
        imagePanel2.add(usLabel2);
        imagePanel2.add(mxLabel2);
        imagePanel2.add(euLabel2);

        //Create text field
        inputField = new JTextField("0.0",20);
        outputField = new JTextField(20);
        outputField.setEditable(false); //Turn editing off in the text field (output)
        
        //Create button panel
        buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 3));

        //Create buttons
        JButton Convert = new JButton("Convert");
        JButton Clear = new JButton("Clear");
        JButton Exit = new JButton("Exit");

        //Add ActionListeners
        Convert.addActionListener(new ConvertListener());
        Clear.addActionListener(new ClearListener());
        Exit.addActionListener(new ExitListener());

        //Add buttons to panel
        buttons.add(Convert);
        buttons.add(Clear);
        buttons.add(Exit);

        //Set layout
        setLayout(new GridLayout(11, 1));
        //Add componenets to the frame
        add(fromJPanel);
        add(imagePanel);
        add(rbPanel);
        add(inputJPanel);
        add(inputField);
        add(convertJPanel);
        add(imagePanel2);
        add(rbPanel2);
        add(outputJPanel);
        add(outputField);
        add(buttons);
        pack();
        setVisible(true);

    }
    // Method to get the selected currency from the first radio button group (rbg)
    public String getInputSelection() {
        if (USD.isSelected()) {
            return "USD";
        } else if (Peso.isSelected()) {
            return "Peso";
        } else if (Euro.isSelected()) {
            return "Euro";
        }
        return "Unknown"; // Default value if no radio button is selected
    }

    // Method to get the selected currency from the second radio button group (rbg2)
    public String getOutputSelection() {
        if (USD2.isSelected()) {
            return "USD";
        } else if (Peso2.isSelected()) {
            return "Peso";
        } else if (Euro2.isSelected()) {
            return "Euro";
        }
        return "Unknown"; // Default value if no radio button is selected
    }

    //Listener to convert currency
    private class ConvertListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            //Gets inputed number from inputField and converts from string to double
            double amt = Double.parseDouble(inputField.getText());
            //Gets selection from radio buttons and sets to string variable
            String inputCurrency = getInputSelection();
            String outputCurrency = getOutputSelection();
            double strtamt = 0.0;
            double convertedAmount = 0.0;
            //Convert selected input currency to USD equivalent
            switch (inputCurrency){
                case "USD":
                    strtamt = amt;
                    break;
                case "Peso":
                    strtamt = amt / usdToPeso;
                    break;
                case "Euro":
                    strtamt = amt / usdToEuro;
                    break;
            }
            //Convert USD equivalent to selected output currency
            switch (outputCurrency) {
                case "USD":
                    convertedAmount = strtamt;
                    break;
                case "Peso":
                    convertedAmount = strtamt * usdToPeso;
                    break;
                case "Euro":
                    convertedAmount = strtamt * usdToEuro;
                    break;
            }
            //Displays the converted amount in the output text field
            outputField.setText(String.format("%,.2f",convertedAmount));
            if (outputField.getText().isEmpty()){
                outputField.setBackground(Color.DARK_GRAY);
            }else{
                outputField.setBackground(Color.GREEN);
            }
            //Message dialog to display the details of the conversion
            JOptionPane.showMessageDialog(null, 
                        String.format("%s to %s\n" +
                                    "$%,.2f is equivalent to $%,.2f\n", inputCurrency, outputCurrency, amt, convertedAmount));
        }
    }

    //Listener to show about dialog
    private class AboutListener implements ActionListener{
        @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(ConvertFrame.this,
                "Currency Conversion Program \nusing menus and buttons \nsource: https://www.oanda.com/currency-converter/",
                "About",JOptionPane.INFORMATION_MESSAGE);
            }
    }

    //Listener to clear input and output text fields
    private class ClearListener implements ActionListener{
        @Override
            public void actionPerformed(ActionEvent e){
                inputField.setText("0.0");
                outputField.setText(" ");
                outputField.setBackground(Color.DARK_GRAY);
            }
    }

    //Listener to confirm exit
    private class ExitListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int r = JOptionPane.showConfirmDialog(null,
                    "Are you sure?", "Confirmation Window", 
                        JOptionPane.YES_NO_OPTION);
            if(r == 0)
                System.exit(0);
        }
    }
    
}