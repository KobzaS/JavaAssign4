
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

public class UpdateFrame extends JFrame implements ActionListener, ItemListener, ChangeListener
{
    ComicList comicLt;
    
    DecimalFormat twoFormat = new DecimalFormat("0.00"); 
    
    JMenuBar mb;
    JMenu mainMenu;
    JMenuItem op1, op2;
    
    JPanel stockPanel, bottomPanel, topPanel, middlePanel, overallPanel, sliderAndTF, tFPanel, comicPanel;
    JPanel blankPanel[] = new JPanel [6];
    
    JComboBox comicCombo;
    JButton updateInvBut;
    JTextArea invTextArea;
    JScrollPane invScroll;
    JSlider stockSlider;
    JCheckBox lockBox;
    JTextField stockText, comicPriceText;
    TitledBorder invBorder;
    
    Vector comicVec;
    
    int stockInt;
    int indx = 0;
    double priceDouble;
    String tempStr;

    Container con;

    public void createScreen(ComicList cl)
    {
        comicLt = cl;
        con = getContentPane();
        
        // Create JPanels
        stockPanel = new JPanel (new GridLayout(1,3,50,50));
        sliderAndTF = new JPanel (new GridLayout(1,2));
        bottomPanel = new JPanel (new GridLayout (1,2,5,5));
        topPanel = new JPanel (new BorderLayout (5,5));
        middlePanel = new JPanel (new GridLayout (2,3,5,5));
        overallPanel = new JPanel (new GridLayout (3,1));
        tFPanel = new JPanel(new GridLayout(2,1));
        comicPanel = new JPanel(new BorderLayout(0,0));
        for (int i = 0; i < blankPanel.length; i++)
        {
            blankPanel[i] = new JPanel (new GridLayout (0,1));
        }
        
        // Create JMenuBar & JMenuItems
        mb = new JMenuBar();
        mainMenu = new JMenu("Comic List");
        mainMenu.setMnemonic('m');
        op1 = new JMenuItem("Full List");
        op1.setMnemonic('F');
        op2 = new JMenuItem("Clear");
        op2.setMnemonic('C');
        mainMenu.add(op1);
        mainMenu.add(op2);
        mb.add(mainMenu);
        setJMenuBar(mb);
        
        // Create Fonts & Border
        Font invFont = new Font("Helvetica", Font.BOLD+Font.ITALIC, 14);
        Font bigFont = new Font("Helvetica", Font.BOLD+Font.ITALIC, 18);
        Font stockFont = new Font("Helvetica", Font.BOLD+Font.ITALIC, 28);
        invBorder = new TitledBorder("Inventory");
        invBorder.setTitleJustification(TitledBorder.RIGHT);
        
        // Initialize vector and add comics to it
        comicVec = new Vector();
        for (int i = 0; i < comicLt.cmicList.length; i++)
        {
            tempStr = comicLt.cmicList[i].getStrComicTitle() + " Vol: " + comicLt.cmicList[i].getIntComicVol() + " #. " + comicLt.cmicList[i].getIntComicIssue() + " Pub: " + comicLt.cmicList[i].getStrComicPub();
            comicVec.add(tempStr); 
        }
        
        // Initialize bottom components
        updateInvBut = new JButton("Update Current Record");
        invTextArea = new JTextArea();
        invTextArea.setEditable(false);
        invTextArea.setBackground(Color.orange);
        invTextArea.setOpaque(true);
        invScroll = new JScrollPane(invTextArea);
        
        // Initialize middle compoenent
        comicPriceText = new JTextField(); 
        comicPriceText.setBackground(Color.yellow);
        comicPriceText.setOpaque(true);
        
        // Initialize top components
        stockSlider = new JSlider(0, 50);
        stockSlider.setPaintTicks(true);
        stockSlider.setEnabled(false);
        stockSlider.setMajorTickSpacing(5);
        stockSlider.createStandardLabels(5);
        stockSlider.setPaintLabels(true);
        lockBox = new JCheckBox("Lock", true);
        stockText = new JTextField(1); 
        stockText.setEditable(false);
        comicCombo = new JComboBox(comicVec);  
        
        // Set initial values
        comicPriceText.setText(String.valueOf(comicLt.cmicList[0].getDoubComicPrice()));
        stockSlider.setValue(comicLt.cmicList[0].getIntComicStock());
        stockText.setText(String.valueOf(comicLt.cmicList[0].getIntComicStock()));     
        
        // Set component fonts
        invTextArea.setFont(invFont);
        invBorder.setTitleFont(bigFont);
        updateInvBut.setFont(bigFont);
        stockText.setFont(stockFont);
        comicPriceText.setFont(bigFont);      
        
        // Set borders
        comicPriceText.setBorder(new TitledBorder("Comic Price"));
        stockPanel.setBorder(new TitledBorder("Comic Stock (50 Max)"));
        invScroll.setBorder(invBorder);       
        
        // Add listeners
        lockBox.addItemListener(this);
        comicCombo.addItemListener(this);
        stockText.addActionListener(this);
        comicPriceText.addActionListener(this);
        updateInvBut.addActionListener(this);
        op1.addActionListener(this);
        op2.addActionListener(this);
        stockSlider.addChangeListener(this);
        
        // Create screen
        comicPanel.add(comicCombo, BorderLayout.NORTH);
        tFPanel.add(stockText);
        tFPanel.add(blankPanel[5]);
        sliderAndTF.add(stockSlider);
        sliderAndTF.add(tFPanel);
        stockPanel.add(lockBox);
        stockPanel.add(stockSlider);
        stockPanel.add(tFPanel);
        topPanel.add(comicPanel, BorderLayout.WEST);
        topPanel.add(stockPanel, BorderLayout.CENTER);
        middlePanel.add(blankPanel[0]);
        middlePanel.add(comicPriceText);
        middlePanel.add(blankPanel[1]);
        middlePanel.add(blankPanel[2]);
        middlePanel.add(blankPanel[3]);
        middlePanel.add(blankPanel[4]);
        bottomPanel.add(updateInvBut);
        bottomPanel.add(invScroll);
        overallPanel.add(topPanel);
        overallPanel.add(middlePanel);
        overallPanel.add(bottomPanel);
        con.add(overallPanel);
    }
    
    public void actionPerformed (ActionEvent e)
    {
        if (e.getSource() instanceof JTextField)
        {
            // Keep stockText within 0-50 and make stockSlider match
            if (e.getSource() == stockText)
            {
               if (Integer.parseInt(stockText.getText()) > 50)
                  stockText.setText("50");
               if (Integer.parseInt(stockText.getText()) < 0)
                  stockText.setText("0");
               stockSlider.setValue(Integer.parseInt(stockText.getText()));
            }
            else if (e.getSource() == comicPriceText)
            {
               // Format new price to 2 decimal places
               comicPriceText.setText(twoFormat.format(Double.parseDouble(comicPriceText.getText())));
            }
        }
        else if (e.getSource() instanceof JButton)
        {
            // Update comicLt & show MessageDialog
            JOptionPane.showMessageDialog(this, "Update Complete", "Confirmation Box", JOptionPane.INFORMATION_MESSAGE);
            comicLt.cmicList[indx].setDoubComicPrice(Double.parseDouble(comicPriceText.getText()));
            comicLt.cmicList[indx].setIntComicStock(Integer.parseInt(stockText.getText()));
        }
        else if (e.getSource() instanceof JMenuItem)
        {
            if (e.getSource() == op1)
            {
               // Display comic list with prices in invTextArea
               invTextArea.setText("");
               for (int a = 0; a < comicLt.cmicList.length; a++)
               {
                  invTextArea.append(comicLt.cmicList[a].getStrComicTitle() + " Vol: " + comicLt.cmicList[a].getIntComicVol() + " #. " + comicLt.cmicList[a].getIntComicIssue() + " Pub: " + comicLt.cmicList[a].getStrComicPub() + " ==> $" + String.valueOf(twoFormat.format(comicLt.cmicList[a].getDoubComicPrice()))+"\n");
               }
            }
            else if (e.getSource() == op2)
            {
               // Clear invTextArea
               invTextArea.setText("");
            }
        }
    }
    
    public void itemStateChanged (ItemEvent e)
    {
        if (e.getSource() instanceof JCheckBox)
        {
            // Set stockSlider & stockText editable
            if (lockBox.isSelected() == false)
            {
               stockSlider.setEnabled(true);
               stockText.setEditable(true);
            }
            // Set stockSlider & stockText non-editable
            else
            {
               stockSlider.setEnabled(false);
               stockText.setEditable(false);
            }
        }
        else if (e.getSource() instanceof JComboBox)
        {
            // Set values of stockSlider, stockText & comicPriceText to that of the new comic selected
            indx = comicCombo.getSelectedIndex();
            stockSlider.setValue(comicLt.cmicList[indx].getIntComicStock());
            stockText.setText(String.valueOf(comicLt.cmicList[indx].getIntComicStock()));
            comicPriceText.setText(String.valueOf(twoFormat.format(comicLt.cmicList[indx].getDoubComicPrice())));
        }
    }
    
    public void stateChanged (ChangeEvent e)
    {
        if (e.getSource() instanceof JSlider)
        {
            // Set stockText to match value of stockSlider
            stockText.setText(String.valueOf(stockSlider.getValue()));
        }
    }
}