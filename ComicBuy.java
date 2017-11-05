import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.util.Vector;
import java.util.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ComicBuy extends JFrame implements ActionListener, ItemListener, ListSelectionListener, MouseListener
{
    ComicList cl = new ComicList();
    JPanel keyPadPanel, enterPanel, employeePanel, blank1Panel, blank2Panel, bottomPanel, middlePanel, middle2Panel, paymentPanel, creditCardPanel;
    JPanel deliveryPanel, topPanel, publisherPanel, numbToAddPanel, overallPanel;
    JButton JBut[] = new JButton[10];
    JButton enterBut, resetBut, clearBut, clearAllBut, submitBut, buyBut;
    JCheckBox allBox, marvelBox, dcBox, otherBox;
    JLabel passwordText, keypadInsText, totalText, enterCCText, stockText, priceText, comicPic;
    JPasswordField creditCardNumPF;
    JScrollPane comicSelScroll, comicDispScroll,comicPicScroll;
    JList comicSelList, comicDispList;
    JComboBox numCopyDropDown;
    JRadioButton withinRadio, outsideRadio;
    String tempStr = "", visPasswordStr = "", passwordStr = "";
    TitledBorder comicPicBorder;
    ButtonGroup delivery;
    double deliveryFee = 3.95, totalPrice = 0;
    Vector comicSelVec, numCopyVec, comicDispVec, marvelVec, dcVec, otherVec, indexVec; 
    
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
        passwordText = new JLabel(visPasswordStr);
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
        indexVec = new Vector();
        comicPicScroll = new JScrollPane(comicPic);
        comicPicBorder = new TitledBorder("None");
        delivery = new ButtonGroup();

        for (int i = 1; i < 8; i++)
        {
            numCopyVec.add(i + " issue(s)");
        }
        for (int i = 0; i < 19; i++)
        {
            tempStr = cl.cmicList[i].getStrComicTitle() + " Vol: " + cl.cmicList[i].getIntComicVol() + " #. " + cl.cmicList[i].getIntComicIssue() + " Pub: " + cl.cmicList[i].getStrComicPub();           
            if (cl.cmicList[i].getChComicPubType() == 'd')
            {
                dcVec.add(tempStr);
                indexVec.add(tempStr);
            }
            else if (cl.cmicList[i].getChComicPubType() == 'm')
            {
                marvelVec.add(tempStr);
                indexVec.add(tempStr);
            }
            else
            {
                otherVec.add(tempStr);
                indexVec.add(tempStr);
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
        comicPic.addMouseListener(this);
        
        Font pubFont = new Font("Comic Sans MS", Font.BOLD+Font.ITALIC, 16);
        Font normalFont = new Font ("Arial", Font.PLAIN, 14);
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
        comicDispList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        comicSelList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        comicPic.setOpaque(true);
        buyBut.setIcon(new ImageIcon("buyLogo1.gif"));
        comicPic.setHorizontalAlignment(JLabel.CENTER);
        enterBut.setFont(normalFont);
        resetBut.setFont(normalFont);
        clearAllBut.setFont(normalFont);
        clearBut.setFont(normalFont);
        submitBut.setFont(normalFont);
        withinRadio.setFont(normalFont);
        outsideRadio.setFont(normalFont);
        for (int i = 0; i < JBut.length; i++)
        {
            JBut[i].setFont(normalFont);
        }
        passwordText.setFont(normalFont);
        totalText.setFont(normalFont);
        keypadInsText.setFont(normalFont);
        enterCCText.setFont(normalFont);
        stockText.setFont(normalFont);
        priceText.setFont(normalFont);
        numCopyDropDown.setFont(normalFont);
        delivery.add(outsideRadio);
        delivery.add(withinRadio);

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
        middlePanel.add(comicPicScroll);
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
        //Vector password = new Vector(4);
        
        if (e.getSource() instanceof JButton)
        {
            
            if (e.getSource() == buyBut)
            {
                int numCopy, index, stock, stockUpd; 
                String info, selectedObj, totalStr, stockStr, preDelivStr;
                double pricePer = 0, preDeliv = 0;
                numCopy = numCopyDropDown.getSelectedIndex()+1;
                index = comicDispList.getSelectedIndex();
                info = comicDispList.getSelectedValue().toString();
                if (marvelBox.isSelected() == true && dcBox.isSelected() == true && otherBox.isSelected() == true)
                {
                    stock = cl.cmicList[index].getIntComicStock();
                    if (numCopy <= stock)
                    {
                        pricePer = cl.cmicList[index].getDoubComicPrice();
                        totalPrice += pricePer*numCopy;
                        selectedObj = info + " (" + numCopy + ") $" + totalPrice; 
                        comicSelVec.add(selectedObj);
                        comicSelList.setListData(comicSelVec);
                        cl.cmicList[index].setIntComicStock(stock - numCopy);
                        stockUpd = cl.cmicList[index].getIntComicStock();
                        stockStr = Integer.toString(stockUpd);
                        stockText.setText("Stock: " + stockStr);
                    }
                }
                else if (dcBox.isSelected() == true && marvelBox.isSelected() == true)
                {
                    stock = cl.cmicList[index].getIntComicStock();
                    if (numCopy <= stock)
                    {
                        pricePer = cl.cmicList[index].getDoubComicPrice();
                        totalPrice += pricePer*numCopy;
                        selectedObj = info + " (" + numCopy + ") $" + totalPrice; 
                        comicSelVec.add(selectedObj);
                        comicSelList.setListData(comicSelVec);
                        cl.cmicList[index].setIntComicStock(stock - numCopy);
                        stockUpd = cl.cmicList[index].getIntComicStock();
                        stockStr = Integer.toString(stockUpd);
                        stockText.setText("Stock: " + stockStr);
                    }
                }
                else if (marvelBox.isSelected() == true && otherBox.isSelected() == true)
                {   
                    index += dcVec.size();
                    stock = cl.cmicList[index].getIntComicStock();
                    if (numCopy<= stock)
                    {
                        pricePer = cl.cmicList[index].getDoubComicPrice();
                        totalPrice += pricePer*numCopy;
                        selectedObj = info + " (" + numCopy + ") $" + totalPrice; 
                        comicSelVec.add(selectedObj);
                        comicSelList.setListData(comicSelVec);
                        cl.cmicList[index].setIntComicStock(stock - numCopy);
                        stockUpd = cl.cmicList[index].getIntComicStock();
                        stockStr = Integer.toString(stockUpd);
                        stockText.setText("Stock: " + stockStr);
                    }
                }
                else if (marvelBox.isSelected() == true)
                {  
                    index += dcVec.size();
                    stock = cl.cmicList[index].getIntComicStock(); 
                    if (numCopy <= stock)
                    {
                        pricePer = cl.cmicList[index].getDoubComicPrice();
                        totalPrice += pricePer*numCopy;
                        selectedObj = info + " (" + numCopy + ") $" + totalPrice; 
                        comicSelVec.add(selectedObj);
                        comicSelList.setListData(comicSelVec);
                        cl.cmicList[index].setIntComicStock(stock - numCopy);
                        stockUpd = cl.cmicList[index].getIntComicStock();
                        stockStr = Integer.toString(stockUpd);
                        stockText.setText("Stock: " + stockStr);
                    }
                }
                else if (otherBox.isSelected() == true)
                {  
                    index += dcVec.size();
                    index += marvelVec.size();
                    stock = cl.cmicList[index].getIntComicStock();
                    if (numCopy <= stock)
                    {
                        pricePer = cl.cmicList[index].getDoubComicPrice();
                        totalPrice += pricePer*numCopy;
                        selectedObj = info + " (" + numCopy + ") $" + totalPrice; 
                        comicSelVec.add(selectedObj);
                        comicSelList.setListData(comicSelVec);
                        cl.cmicList[index].setIntComicStock(stock - numCopy);
                        stockUpd = cl.cmicList[index].getIntComicStock();
                        stockStr = Integer.toString(stockUpd);
                        stockText.setText("Stock: " + stockStr);
                    }
                }
                else if (dcBox.isSelected() == true)
                {
                    stock = cl.cmicList[index].getIntComicStock();
                    if (numCopy <= stock)
                    {
                        pricePer = cl.cmicList[index].getDoubComicPrice();
                        totalPrice += pricePer*numCopy;
                        selectedObj = info + " (" + numCopy + ") $" + totalPrice; 
                        comicSelVec.add(selectedObj);
                        comicSelList.setListData(comicSelVec);
                        cl.cmicList[index].setIntComicStock(stock - numCopy);
                        stockUpd = cl.cmicList[index].getIntComicStock();
                        stockStr = Integer.toString(stockUpd);
                        stockText.setText("Stock: " + stockStr);
                    }
                }   
                else
                {   
                    stock = cl.cmicList[index].getIntComicStock();
                    if (numCopy <= stock)
                    {
                        pricePer = cl.cmicList[index].getDoubComicPrice();
                        totalPrice += pricePer*numCopy;
                        selectedObj = info + " (" + numCopy + ") $" + totalPrice; 
                        comicSelVec.add(selectedObj);
                        comicSelList.setListData(comicSelVec);
                        cl.cmicList[index].setIntComicStock(stock - numCopy);
                        stockUpd = cl.cmicList[index].getIntComicStock();
                        stockStr = Integer.toString(stockUpd);
                        stockText.setText("Stock: " + stockStr);
                    }
                }
            }
            else if (e.getSource() == JBut[0])
            {
                passwordStr += "a";
                visPasswordStr += "*";
                passwordText.setText(visPasswordStr);
            }
            else if (e.getSource() == JBut[1])
            {
                passwordStr += "b";
                visPasswordStr += "*";
                passwordText.setText(visPasswordStr);
            }
            else if (e.getSource() == JBut[2])
            {
                passwordStr += "c";
                visPasswordStr += "*";
                passwordText.setText(visPasswordStr);
            }
            else if (e.getSource() == JBut[3])
            {
                passwordStr += "d";
                visPasswordStr += "*";
                passwordText.setText(visPasswordStr);
            }
            else if (e.getSource() == JBut[4])
            {
                passwordStr += "d";
                visPasswordStr += "*";
                passwordText.setText(visPasswordStr);
            }
            else if (e.getSource() == JBut[5])
            {
                passwordStr += "e";
                visPasswordStr += "*";
                passwordText.setText(visPasswordStr);
            }
            else if (e.getSource() == JBut[6])
            {
                passwordStr += "f";
                visPasswordStr += "*";
                passwordText.setText(visPasswordStr);
            }
            else if (e.getSource() == JBut[7])
            {
                passwordStr += "g";
                visPasswordStr += "*";
                passwordText.setText(visPasswordStr);
            }
            else if (e.getSource() == JBut[8])
            {
                passwordStr += "h";
                visPasswordStr += "*";
                passwordText.setText(visPasswordStr);
            }
            else if (e.getSource() == JBut[9])
            {
                passwordStr += "i";
                visPasswordStr += "*";
                passwordText.setText(visPasswordStr);
            }
            else if (e.getSource() == enterBut)
            {
                passwordText.setText(passwordStr);
                if (passwordStr.compareTo("abcd") == 0)
                {
                    JOptionPane.showMessageDialog(null, "Well done!");
                }
                else 
                {
                    JOptionPane.showMessageDialog(null, "Wrong password, please re-enter", "Not Allowed", JOptionPane.ERROR_MESSAGE);
                    passwordStr = "";
                    visPasswordStr = "";
                    passwordText.setText(visPasswordStr);
                }
            }
            else if (e.getSource() == resetBut)
            {
                //password.clear();
                visPasswordStr = "";
                passwordText.setText(visPasswordStr);
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
                if (allBox.isSelected() == true)
                {
                    otherBox.setSelected(false);
                    marvelBox.setSelected(false);
                    dcBox.setSelected(false);
                    comicDispVec.clear();
                    for (int i = 0; i < dcVec.size(); i++)
                    {
                        comicDispVec.add(dcVec.get(i));
                    }
                    for (int i = 0; i < marvelVec.size(); i++)
                    {
                        comicDispVec.add(marvelVec.get(i));
                    }         
                    for (int i = 0; i < otherVec.size(); i++)
                    {
                        comicDispVec.add(otherVec.get(i));
                    }
                    comicDispList.setListData(comicDispVec);
                }
                else
                {
                    for (int i = 0; i < dcVec.size(); i++)
                    {
                        comicDispVec.remove(dcVec.get(i));
                    }
                    for (int i = 0; i < marvelVec.size(); i++)
                    {
                        comicDispVec.remove(marvelVec.get(i));
                    }         
                    for (int i = 0; i < otherVec.size(); i++)
                    {
                        comicDispVec.remove(otherVec.get(i));
                    }
                    comicDispList.setListData(comicDispVec);
                }
            }
            else if (e.getSource() == otherBox)
            {
                if (otherBox.isSelected() == true)
                {
                    if (allBox.isSelected() == true)
                    {
                        allBox.setSelected(false);
                        comicDispVec.clear();
                    }
                    
                    for (int i = 0; i < otherVec.size(); i++)
                    {
                        comicDispVec.add(otherVec.get(i));
                    }
                    comicDispList.setListData(comicDispVec);
                }
                else
                {
                    for (int i = 0; i < otherVec.size(); i++)
                    {
                        comicDispVec.remove(otherVec.get(i));
                    }
                    comicDispList.setListData(comicDispVec);
                }
            }
            else if (e.getSource() == marvelBox)
            {
                int x = dcVec.size();
                if (allBox.isSelected() == true)
                {
                    allBox.setSelected(false);
                    comicDispVec.clear();
                }
                if (marvelBox.isSelected() == true)
                {
                    for (int i = 0; i < marvelVec.size(); i++)
                    {
                        
                        if (dcBox.isSelected() == true)
                        {
                            comicDispVec.add(x+i, marvelVec.get(i));
                        }
                        else if (otherBox.isSelected() == true)
                        {
                            comicDispVec.add(i, marvelVec.get(i));
                        }
                        else
                        {
                            comicDispVec.add(marvelVec.get(i));
                        }
                    }
                    comicDispList.setListData(comicDispVec);
                }
                else
                {
                    for (int i = 0; i < marvelVec.size(); i++)
                    {
                        comicDispVec.remove(marvelVec.get(i));
                    }
                    comicDispList.setListData(comicDispVec);
                }
            }
            else
            {
                if (allBox.isSelected() == true)
                {
                allBox.setSelected(false);
                comicDispVec.clear();
                }
                if (dcBox.isSelected() == true)
                {
                    for (int i = 0; i < dcVec.size(); i++)
                    {
                        comicDispVec.insertElementAt(dcVec.get(i), i);
                    }
                    comicDispList.setListData(comicDispVec);
                }
                else
                {
                    for (int i = 0; i < dcVec.size(); i++)
                    {
                        comicDispVec.remove(dcVec.get(i));
                    }
                    comicDispList.setListData(comicDispVec);
                }
            }
        }
        else
        {
            if (withinRadio.isSelected() == true)
            {
                deliveryFee -= 7.52;
                deliveryFee += 3.95;
                double delivered = totalPrice + deliveryFee;
                totalText.setText("Total: $" + totalPrice + " plus Delivery is: $" + deliveryFee);
                totalPrice -= deliveryFee;
            }
            else if (outsideRadio.isSelected() == true)
            {
                deliveryFee -= 3.95;
                deliveryFee += 7.52;
                double delivered = totalPrice + deliveryFee;
                totalText.setText("Total: $" + totalPrice + " plus Delivery is: $" + deliveryFee);
                totalPrice -= deliveryFee;
            }
        }
    }

    public void valueChanged (ListSelectionEvent e)
    {
        int index, stock, issue;
        double price;
        String stockStr, priceStr, imageName, title, issueStr;
        if (e.getSource() instanceof JList)
        {
            if (e.getSource() == comicDispList)
            {
                if (comicDispList.isSelectionEmpty() == true)
                {

                }
                else
                {
                    index = comicDispList.getSelectedIndex();
                    
                    if (marvelBox.isSelected() == true && dcBox.isSelected() == true && otherBox.isSelected() == true)
                    {
                        issue = cl.cmicList[index].getIntComicIssue();
                        stock = cl.cmicList[index].getIntComicStock();
                        price = cl.cmicList[index].getDoubComicPrice();
                        imageName = cl.cmicList[index].getStrComicCover();
                        title = cl.cmicList[index].getStrComicTitle();
                        comicPic.setIcon(new ImageIcon(imageName));
                        issueStr = Integer.toString(issue);
                        comicPicBorder.setTitle(title + " #" + issueStr);
                        stockStr = Integer.toString(stock);
                        priceStr = Double.toString(price);
                        stockText.setText("Stock: " + stockStr);
                        priceText.setText("Price: $" + priceStr);
                    }
                    else if (dcBox.isSelected() == true && marvelBox.isSelected() == true)
                    {
                        issue = cl.cmicList[index].getIntComicIssue();
                        stock = cl.cmicList[index].getIntComicStock();
                        price = cl.cmicList[index].getDoubComicPrice();
                        imageName = cl.cmicList[index].getStrComicCover();
                        title = cl.cmicList[index].getStrComicTitle();
                        comicPic.setIcon(new ImageIcon(imageName));
                        issueStr = Integer.toString(issue);
                        comicPicBorder.setTitle(title + " #" + issueStr);
                        stockStr = Integer.toString(stock);
                        priceStr = Double.toString(price);
                        stockText.setText("Stock: " + stockStr);
                        priceText.setText("Price: $" + priceStr);
                    }
                    else if (marvelBox.isSelected() == true && otherBox.isSelected() == true)
                    {
                        index += dcVec.size();
                        issue = cl.cmicList[index].getIntComicIssue();
                        stock = cl.cmicList[index].getIntComicStock();
                        price = cl.cmicList[index].getDoubComicPrice();
                        imageName = cl.cmicList[index].getStrComicCover();
                        title = cl.cmicList[index].getStrComicTitle();
                        comicPic.setIcon(new ImageIcon(imageName));
                        issueStr = Integer.toString(issue);
                        comicPicBorder.setTitle(title + " #" + issueStr);
                        stockStr = Integer.toString(stock);
                        priceStr = Double.toString(price);
                        stockText.setText("Stock: " + stockStr);
                        priceText.setText("Price: $" + priceStr);
                    }
                    else if (marvelBox.isSelected() == true)
                    {
                        index += dcVec.size();
                        issue = cl.cmicList[index].getIntComicIssue();
                        stock = cl.cmicList[index].getIntComicStock();
                        price = cl.cmicList[index].getDoubComicPrice();
                        imageName = cl.cmicList[index].getStrComicCover();
                        title = cl.cmicList[index].getStrComicTitle();
                        comicPic.setIcon(new ImageIcon(imageName));
                        issueStr = Integer.toString(issue);
                        comicPicBorder.setTitle(title + " #" + issueStr);
                        stockStr = Integer.toString(stock);
                        priceStr = Double.toString(price);
                        stockText.setText("Stock: " + stockStr);
                        priceText.setText("Price: $" + priceStr);
                    }
                    else if (otherBox.isSelected() == true)
                    {
                        index += dcVec.size();
                        index += marvelVec.size();
                        issue = cl.cmicList[index].getIntComicIssue();
                        stock = cl.cmicList[index].getIntComicStock();
                        price = cl.cmicList[index].getDoubComicPrice();
                        imageName = cl.cmicList[index].getStrComicCover();
                        title = cl.cmicList[index].getStrComicTitle();
                        comicPic.setIcon(new ImageIcon(imageName));
                        issueStr = Integer.toString(issue);
                        comicPicBorder.setTitle(title + " #" + issueStr);
                        stockStr = Integer.toString(stock);
                        priceStr = Double.toString(price);
                        stockText.setText("Stock: " + stockStr);
                        priceText.setText("Price: $" + priceStr);
                    }
                    else if (dcBox.isSelected() == true)
                    {
                        issue = cl.cmicList[index].getIntComicIssue();
                        stock = cl.cmicList[index].getIntComicStock();
                        price = cl.cmicList[index].getDoubComicPrice();
                        imageName = cl.cmicList[index].getStrComicCover();
                        title = cl.cmicList[index].getStrComicTitle();
                        comicPic.setIcon(new ImageIcon(imageName));
                        issueStr = Integer.toString(issue);
                        comicPicBorder.setTitle(title + " #" + issueStr);
                        stockStr = Integer.toString(stock);
                        priceStr = Double.toString(price);
                        stockText.setText("Stock: " + stockStr);
                        priceText.setText("Price: $" + priceStr);
                    }   
                    else
                    {
                        issue = cl.cmicList[index].getIntComicIssue();
                        stock = cl.cmicList[index].getIntComicStock();
                        price = cl.cmicList[index].getDoubComicPrice();
                        imageName = cl.cmicList[index].getStrComicCover();
                        title = cl.cmicList[index].getStrComicTitle();
                        comicPic.setIcon(new ImageIcon(imageName));
                        issueStr = Integer.toString(issue);
                        comicPicBorder.setTitle(title + " #" + issueStr);
                        stockStr = Integer.toString(stock);
                        priceStr = Double.toString(price);
                        stockText.setText("Stock: " + stockStr);
                        priceText.setText("Price: $" + priceStr);
                    }                 
                }
            }
            else
            {

            }
        }
    }

    public void mouseEntered(MouseEvent e)
    {
        if (comicDispList.isSelectionEmpty() == true)
        {

        }
        else
        {
            int index = comicDispList.getSelectedIndex();
            if (marvelBox.isSelected() == true && dcBox.isSelected() == true && otherBox.isSelected() == true)
            {
                String info = cl.cmicList[index].getStrComicComment();
                comicPic.setText(info);
                comicPic.setIcon(null);
            }
            else if (dcBox.isSelected() == true && marvelBox.isSelected() == true)
            {
                String info = cl.cmicList[index].getStrComicComment();
                comicPic.setText(info);
                comicPic.setIcon(null);
            }
            else if (marvelBox.isSelected() == true && otherBox.isSelected() == true)
            {   
                index += dcVec.size();
                String info = cl.cmicList[index].getStrComicComment();
                comicPic.setText(info);
                comicPic.setIcon(null);
            }
            else if (marvelBox.isSelected() == true)
            {   
                index += dcVec.size();
                String info = cl.cmicList[index].getStrComicComment();
                comicPic.setText(info);
                comicPic.setIcon(null);
            }
            else if (otherBox.isSelected() == true)
            {  
                index += dcVec.size();
                index += marvelVec.size();
                String info = cl.cmicList[index].getStrComicComment();
                comicPic.setText(info);
                comicPic.setIcon(null);
            }
            else if (dcBox.isSelected() == true)
            {
                String info = cl.cmicList[index].getStrComicComment();
                comicPic.setText(info);
                comicPic.setIcon(null);
            }   
            else
            {   
                String info = cl.cmicList[index].getStrComicComment();
                comicPic.setText(info);
                comicPic.setIcon(null);
            }
            
        }
    }
    public void mouseExited(MouseEvent e)
    {
        if (comicDispList.isSelectionEmpty() == true)
        {

        }
        else
        {
            int index = comicDispList.getSelectedIndex();
            if (marvelBox.isSelected() == true && dcBox.isSelected() == true && otherBox.isSelected() == true)
            {
                String imageName;
                imageName = cl.cmicList[index].getStrComicCover();
                comicPic.setIcon(new ImageIcon(imageName));
                comicPic.setText(null);
            }
            else if (dcBox.isSelected() == true && marvelBox.isSelected() == true)
            {
                String imageName;
                imageName = cl.cmicList[index].getStrComicCover();
                comicPic.setIcon(new ImageIcon(imageName));
                comicPic.setText(null);
            }
            else if (marvelBox.isSelected() == true && otherBox.isSelected() == true)
            {
                index += dcVec.size();
                String imageName;
                imageName = cl.cmicList[index].getStrComicCover();
                comicPic.setIcon(new ImageIcon(imageName));
                comicPic.setText(null);
            }
            else if (marvelBox.isSelected() == true)
            {
                index += dcVec.size();
                String imageName;
                imageName = cl.cmicList[index].getStrComicCover();
                comicPic.setIcon(new ImageIcon(imageName));
                comicPic.setText(null);
            }
            else if (otherBox.isSelected() == true)
            {
                index += dcVec.size();
                index += marvelVec.size();
                String imageName;
                imageName = cl.cmicList[index].getStrComicCover();
                comicPic.setIcon(new ImageIcon(imageName));
                comicPic.setText(null);
            }
            else if (dcBox.isSelected() == true)
            {
                String imageName;
                imageName = cl.cmicList[index].getStrComicCover();
                comicPic.setIcon(new ImageIcon(imageName));
                comicPic.setText(null);
            }   
            else
            {
                String imageName;
                imageName = cl.cmicList[index].getStrComicCover();
                comicPic.setIcon(new ImageIcon(imageName));
                comicPic.setText(null); 
            }
            
        }
    }
    public void mouseReleased(MouseEvent e)
    {

    }
    public void mousePressed(MouseEvent e)
    {

    }
    public void mouseClicked(MouseEvent e)
    {

    }
    public static void main (String Args[])
    {
        ComicBuy cb = new ComicBuy();
        cb.createScreen();
        cb.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cb.setTitle("Kobza and Mennie's Comic Buy App");
        cb.setSize(1366,768);
        cb.setVisible(true);
    }
    
}