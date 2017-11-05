import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.util.Vector;
import java.util.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ComicBuy extends JFrame implements ActionListener, ItemListener, ListSelectionListener
{
    ComicList cl = new ComicList();
    JPanel keyPadPanel, enterPanel, employeePanel, blank1Panel, blank2Panel, bottomPanel, middlePanel, middle2Panel, paymentPanel, creditCardPanel;
    JPanel deliveryPanel, topPanel, publisherPanel, numbToAddPanel, overallPanel;
    JButton JBut[] = new JButton[10];
    JButton enterBut, resetBut, clearBut, clearAllBut, submitBut, buyBut;
    JCheckBox allBox, marvelBox, dcBox, otherBox;
    JLabel passwordText, keypadInsText, totalText, enterCCText, stockText, priceText, comicPic;
    JPasswordField creditCardNumPF;
    JScrollPane comicSelScroll, comicDispScroll;
    JList comicSelList, comicDispList;
    JComboBox numCopyDropDown;
    JRadioButton withinRadio, outsideRadio;
    String temp = "", visPassword = "";
    
    
    Vector comicSelVec, numCopyVec, comicDispVec, marvelVec, dcVec, otherVec; 
    
    Container con;
    
    public void createScreen()
    {
        cl.createList();
        con = getContentPane();
        keyPadPanel = new JPanel (new GridLayout(2,5,2,2));
        enterPanel = new JPanel (new GridLayout (1,2,0,5));
        employeePanel = new JPanel (new GridLayout (4,1,10,5));
        bottomPanel = new JPanel (new GridLayout (1,3));
        blank1Panel = new JPanel (new GridLayout (1,0));
        blank2Panel = new JPanel (new GridLayout (1,0));
        middlePanel = new JPanel (new GridLayout (1,3));
        middle2Panel = new JPanel (new GridLayout (1,2));
        paymentPanel = new JPanel (new GridLayout (5,1,5,0));
        creditCardPanel = new JPanel (new GridLayout (1,2));
        deliveryPanel = new JPanel (new GridLayout (2,1));
        topPanel = new JPanel (new GridLayout (1,3));
        publisherPanel = new JPanel (new GridLayout (2,2));
        numbToAddPanel = new JPanel (new GridLayout (3,1));
        overallPanel = new JPanel (new GridLayout (4,1));

        enterBut = new JButton ("Enter");
        resetBut = new JButton ("Reset");
        clearBut = new JButton ("Clear");
        clearAllBut = new JButton ("Clear All");
        submitBut = new JButton ("Submit");
        passwordText = new JLabel(visPassword);
        keypadInsText = new JLabel("Use Keypad to enter password for settings");
        totalText = new JLabel ("Total:");
        enterCCText = new JLabel ("Enter credit card number:");
        creditCardNumPF = new JPasswordField();
        comicSelVec = new Vector();
        comicSelList = new JList(comicSelVec);
        comicSelScroll = new JScrollPane(comicSelList);
        allBox = new JCheckBox("All");
        marvelBox = new JCheckBox("Marvel");
        dcBox = new JCheckBox("DC");
        otherBox = new JCheckBox("Other");
        numCopyVec = new Vector();
        numCopyDropDown =  new JComboBox(numCopyVec);
        comicDispVec = new Vector();
        comicDispList = new JList (comicDispVec);
        comicDispScroll = new JScrollPane(comicDispList);
        withinRadio = new JRadioButton("Within Canada (+$3.95)", true);
        outsideRadio = new JRadioButton("Outside Canada (+$7.52)", false);
        stockText = new JLabel("Stock:");
        priceText = new JLabel("Price:");
        buyBut = new JButton();
        comicPic = new JLabel();
        marvelVec = new Vector();
        dcVec = new Vector();
        otherVec = new Vector();

        for (int i = 1; i < 8; i++)
        {
            numCopyVec.add(i + " issue(s)");
        }
        for (int i = 0; i < 19; i++)
        {
            temp = cl.cmicList[i].getStrComicTitle() + " Vol: " + cl.cmicList[i].getIntComicVol() + " #. " + cl.cmicList[i].getIntComicIssue() + " Pub: " + cl.cmicList[i].getStrComicPub();           
            if (cl.cmicList[i].getChComicPubType() == 'd')
            {
                dcVec.add(temp);
            }
            else if (cl.cmicList[i].getChComicPubType() == 'm')
            {
                marvelVec.add(temp);
            }
            else
            {
                otherVec.add(temp);
            }
        }
        for (int i = 0; i < JBut.length; i++)
        {
            int temp = i+65;
            char Char = (char)temp;
            JBut[i] = new JButton(String.valueOf(Char));
            keyPadPanel.add(JBut[i]);
        }

        //Adding Item Event Handlers
        JBut[0].addActionListener(this);
        JBut[1].addActionListener(this);
        JBut[2].addActionListener(this);
        JBut[3].addActionListener(this);
        JBut[4].addActionListener(this);
        JBut[5].addActionListener(this);
        JBut[6].addActionListener(this);
        JBut[7].addActionListener(this);
        JBut[8].addActionListener(this);
        JBut[9].addActionListener(this);
        enterBut.addActionListener(this);
        clearBut.addActionListener(this);
        clearAllBut.addActionListener(this);
        submitBut.addActionListener(this);
        buyBut.addActionListener(this);
        resetBut.addActionListener(this);
        withinRadio.addItemListener(this);
        outsideRadio.addItemListener(this);
        allBox.addItemListener(this);
        otherBox.addItemListener(this);
        marvelBox.addItemListener(this);
        dcBox.addItemListener(this);
        comicDispList.addListSelectionListener(this);
        comicSelList.addListSelectionListener(this);

        
        TitledBorder comicPicBorder = new TitledBorder("None");
        Font pubFont = new Font("Comic Sans MS", Font.BOLD+Font.ITALIC, 16);
        employeePanel.setBackground(Color.RED);
        enterPanel.setBackground(Color.RED);
        keyPadPanel.setBackground(Color.RED);
        keypadInsText.setBackground(Color.RED);
        comicSelList.setBorder(new TitledBorder("Your Selection"));
        employeePanel.setBorder(new TitledBorder("For Employee Use ONLY"));
        publisherPanel.setBorder(new TitledBorder("Publisher"));
        comicSelList.setBorder(new TitledBorder("Your Selection"));
        deliveryPanel.setBorder(new TitledBorder("Delivery"));
        comicDispList.setBorder(new TitledBorder("Comic Title"));
        comicPic.setBorder(comicPicBorder);
        comicPic.setBackground(Color.YELLOW);
        totalText.setBackground(Color.CYAN);
        totalText.setOpaque(true);
        passwordText.setOpaque(true);
        enterCCText.setHorizontalAlignment(JLabel.RIGHT);
        allBox.setFont(pubFont);
        otherBox.setFont(pubFont);
        marvelBox.setFont(pubFont);
        dcBox.setFont(pubFont);
        comicPicBorder.setTitleFont(pubFont);
        comicPicBorder.setTitlePosition(TitledBorder.CENTER);
        comicPicBorder.setTitleJustification(TitledBorder.CENTER);
        

        enterPanel.add(resetBut);
        enterPanel.add(enterBut);
        employeePanel.add(keypadInsText);
        employeePanel.add(passwordText);
        employeePanel.add(keyPadPanel);
        employeePanel.add(enterPanel);
        bottomPanel.add(blank1Panel);
        bottomPanel.add(employeePanel);
        bottomPanel.add(blank2Panel);
        creditCardPanel.add(enterCCText);
        creditCardPanel.add(creditCardNumPF);
        paymentPanel.add(clearBut);
        paymentPanel.add(clearAllBut);
        paymentPanel.add(totalText);
        paymentPanel.add(creditCardPanel);
        paymentPanel.add(submitBut);
        middle2Panel.add(comicSelScroll);
        middle2Panel.add(paymentPanel);
        publisherPanel.add(allBox);
        publisherPanel.add(marvelBox);
        publisherPanel.add(dcBox);
        publisherPanel.add(otherBox);
        numbToAddPanel.add(stockText);
        numbToAddPanel.add(priceText);
        numbToAddPanel.add(numCopyDropDown);
        deliveryPanel.add(withinRadio);
        deliveryPanel.add(outsideRadio);
        middlePanel.add(deliveryPanel);
        middlePanel.add(buyBut);
        middlePanel.add(comicPic);
        topPanel.add(publisherPanel);
        topPanel.add(comicDispScroll);
        topPanel.add(numbToAddPanel);   
        overallPanel.add(topPanel);
        overallPanel.add(middlePanel);
        overallPanel.add(middle2Panel);
        overallPanel.add(bottomPanel);
        con.add(overallPanel);
    }

    public void actionPerformed (ActionEvent e)
    {
        String password = "";
        if (e.getSource() instanceof JButton)
        {
            if (e.getSource() == buyBut)
            {

            }
            else if (e.getSource() == JBut[0])
            {
                password += "a";
                visPassword += "*";
                passwordText.setText(visPassword);
            }
            else if (e.getSource() == JBut[1])
            {
                password += "b";
                visPassword += "*";
                passwordText.setText(visPassword);
            }
            else if (e.getSource() == JBut[2])
            {
                password += "c";
                visPassword += "*";
                passwordText.setText(visPassword);
            }
            else if (e.getSource() == JBut[3])
            {
                password += "d";
                visPassword += "*";
                passwordText.setText(visPassword);
            }
            else if (e.getSource() == JBut[4])
            {
                password += "e";
                visPassword += "*";
                passwordText.setText(visPassword);
            }
            else if (e.getSource() == JBut[5])
            {
                password += "f";
                visPassword += "*";
                passwordText.setText(visPassword);
            }
            else if (e.getSource() == JBut[6])
            {
                password += "g";
                visPassword += "*";
                passwordText.setText(visPassword);
            }
            else if (e.getSource() == JBut[7])
            {
                password += "h";
                visPassword += "*";
                passwordText.setText(visPassword);
            }
            else if (e.getSource() == JBut[8])
            {
                password += "i";
                visPassword += "*";
                passwordText.setText(visPassword);
            }
            else if (e.getSource() == JBut[9])
            {
                password += "j";
                visPassword += "*";
                passwordText.setText(visPassword);
            }
            else if (e.getSource() == enterBut)
            {
                if (password == "abcd")
                {

                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Wrong password, please re-enter", "Not Allowed", JOptionPane.ERROR_MESSAGE);
                    password = "";
                    visPassword = "";
                    passwordText.setText(visPassword);
                }
            }
            else if (e.getSource() == resetBut)
            {
                password = "";
                visPassword = "";
                passwordText.setText(visPassword);
            }
            else if (e.getSource() == clearBut)
            {
                
            }
            else if (e.getSource() == clearAllBut)
            {
                
            }
            else if (e.getSource() == submitBut)
            {
                String creditCardString = "";
                for (int i = 0; i < creditCardNumPF.getPassword().length; i++)
                {
                    creditCardString += creditCardNumPF.getPassword()[i];
                }
                int yesno = JOptionPane.showConfirmDialog(null, "Are you Sure?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (yesno == 0)
                {
                    if (comicSelVec.size() == 0)
                    {
                        if (creditCardString.compareTo("") == 0 || creditCardString.compareTo(" ") == 0)
                        {
                            JOptionPane.showMessageDialog(null, "Please enter a valid credit card", "Not Allowed", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else if (creditCardString.compareTo("") == 0 || creditCardString.compareTo(" ") == 0)
                    {
                        JOptionPane.showMessageDialog(null, "Please enter a valid credit card", "Not Allowed", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {

                    }
                }
                
            }
        }
    }

    public void itemStateChanged (ItemEvent e)
    {
        if (e.getSource() instanceof JCheckBox)
        {
            if (e.getSource() == allBox)
            {
                if (allBox.isSelected())
                {
                    otherBox.setSelected(false);
                    marvelBox.setSelected(false);
                    dcBox.setSelected(false);
                    comicDispVec.clear();
                    for (int i = 0; i < marvelVec.size(); i++)
                    {
                        comicDispVec.add(marvelVec.get(i));
                    }
                    for (int i = 0; i < dcVec.size(); i++)
                    {
                        comicDispVec.add(dcVec.get(i));
                    }
                    for (int i = 0; i < otherVec.size(); i++)
                    {
                        comicDispVec.add(otherVec.get(i));
                    }
                }
                comicDispList.setListData(comicDispVec);
            }
            else if (e.getSource() == otherBox)
            {
                if (otherBox.isSelected())
                {
                    allBox.setSelected(false);
                    comicDispVec.clear();
                    if (marvelBox.isSelected())
                    {
                        
                        if (dcBox.isSelected())
                        {
                            for (int i = 0; i < marvelVec.size(); i++)
                            {
                                comicDispVec.add(marvelVec.get(i));
                            }
                            for (int i = 0; i < dcVec.size(); i++)
                            {
                                comicDispVec.add(dcVec.get(i));
                            }
                            for (int i = 0; i < otherVec.size(); i++)
                            {
                                comicDispVec.add(otherVec.get(i));
                            }
                        }
                        else
                        {
                            for (int i = 0; i < marvelVec.size(); i++)
                            {
                                comicDispVec.add(marvelVec.get(i));
                            }
                            for (int i = 0; i < otherVec.size(); i++)
                            {
                                comicDispVec.add(otherVec.get(i));
                            }
                        }
                    }
                    else
                    {
                        for (int i = 0; i < otherVec.size(); i++)
                        {
                            comicDispVec.add(otherVec.get(i));
                        }
                    }
                    comicDispList.setListData(comicDispVec);
                }
            }
            else if (e.getSource() == marvelBox)
            {
                if (marvelBox.isSelected())
                {
                    if (otherBox.isSelected())
                    {
                        if (dcBox.isSelected())
                        {
                            for (int i = 0; i < marvelVec.size(); i++)
                            {
                                comicDispVec.add(marvelVec.get(i));
                            }
                            for (int i = 0; i < dcVec.size(); i++)
                            {
                                comicDispVec.add(dcVec.get(i));
                            }
                            for (int i = 0; i < otherVec.size(); i++)
                            {
                                comicDispVec.add(otherVec.get(i));
                            }
                        }
                        else
                        {
                            for (int i = 0; i < marvelVec.size(); i++)
                            {
                                comicDispVec.add(marvelVec.get(i));
                            }
                            for (int i = 0; i < otherVec.size(); i++)
                            {
                                comicDispVec.add(otherVec.get(i));
                            }
                        }
                    }
                    else
                    {
                        for (int i = 0; i < marvelVec.size(); i++)
                        {
                            comicDispVec.add(marvelVec.get(i));
                        }
                    }
                    comicDispList.setListData(comicDispVec);
                }
            }
            else
            {
                if (dcBox.isSelected())
                {
                    if (marvelBox.isSelected())
                    {
                        if (otherBox.isSelected())
                        {
                            for (int i = 0; i < marvelVec.size(); i++)
                            {
                                comicDispVec.add(marvelVec.get(i));
                            }
                            for (int i = 0; i < dcVec.size(); i++)
                            {
                                comicDispVec.add(dcVec.get(i));
                            }
                            for (int i = 0; i < otherVec.size(); i++)
                            {
                                comicDispVec.add(otherVec.get(i));
                            }
                        }
                        else
                        {
                            for (int i = 0; i < marvelVec.size(); i++)
                            {
                                comicDispVec.add(marvelVec.get(i));
                            }
                            for (int i = 0; i < dcVec.size(); i++)
                            {
                                comicDispVec.add(dcVec.get(i));
                            }
                        }
                    }
                    else
                    {
                        for (int i = 0; i < dcVec.size(); i++)
                        {
                            comicDispVec.add(dcVec.get(i));
                            
                        }
                    }
                    comicDispList.setListData(comicDispVec);
                }
            }
        }
        else
        {
            if (e.getSource() == withinRadio)
            {
                
            }
            else
            {

            }
        }
    }

    public void valueChanged (ListSelectionEvent e)
    {
        if (e.getSource() instanceof JList)
        {
            if (e.getSource() == comicDispList)
            {

            }
            else
            {

            }
        }
    }

    public static void main (String Args[])
    {
        ComicBuy cb = new ComicBuy();
        cb.createScreen();
        cb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cb.setTitle("Kobza and Mennie's Comic Buy App");
        cb.setSize(400,400);
        cb.setVisible(true);
    }
    
}