/*
To Do List:
After entering the password, clear all forms and then open up UpdateFrame
Add Comments to help distinguish
Make sure that formatting is right
*/
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
    UpdateFrame uf = new UpdateFrame();
    JPanel keyPadPanel, enterPanel, employeePanel, blank1Panel, blank2Panel, bottomPanel, middlePanel, middle2Panel, paymentPanel, creditCardPanel;
    JPanel deliveryPanel, topPanel, publisherPanel, numbToAddPanel, overallPanel, comicPicPanel, stockPanel;
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
    Vector comicSelVec, numCopyVec, comicDispVec, marvelVec, dcVec, otherVec, indexVec, totalPriceVec, stockVec, selectIndexVec, tempSelVec, purchPriceVec;
    DecimalFormat twoDec; 
    
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
        comicPicPanel = new JPanel(new GridLayout(1,1));
        stockPanel = new JPanel(new GridLayout(1,1));

        uf.createScreen(cl);
        uf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        uf.setTitle("Comic Update");
        uf.setSize(1024, 576);

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
        totalPriceVec = new Vector();
        stockVec = new Vector();
        selectIndexVec = new Vector();
        tempSelVec = new Vector();
        purchPriceVec = new Vector();
        twoDec = new DecimalFormat("0.00");
        Font pubFont = new Font("Comic Sans MS", Font.BOLD+Font.ITALIC, 16);
        Font normalFont = new Font ("Arial", Font.PLAIN, 14);
        

        for (int i = 0; i < 8; i++)
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
            JBut[i].addActionListener(this);
            JBut[i].setFont(normalFont);
        }

        //Adding Item Event Handlers
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
        passwordText.setFont(normalFont);
        totalText.setFont(normalFont);
        keypadInsText.setFont(normalFont);
        enterCCText.setFont(normalFont);
        stockText.setFont(normalFont);
        priceText.setFont(normalFont);
        numCopyDropDown.setFont(normalFont);
        delivery.add(outsideRadio);
        delivery.add(withinRadio);
        comicPicPanel.add(comicPicScroll);
        comicPicPanel.setBorder(comicPicBorder);
        totalText.setText("Total: $0.0 plus Delivery: $0.0");
        numCopyDropDown.setSelectedIndex(0);

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
        stockPanel.add(stockText);
        numbToAddPanel.add(stockPanel);
        numbToAddPanel.add(priceText);
        numbToAddPanel.add(numCopyDropDown);
        deliveryPanel.add(withinRadio);
        deliveryPanel.add(outsideRadio);
        middlePanel.add(deliveryPanel);
        middlePanel.add(buyBut);
        middlePanel.add(comicPicPanel);
        topPanel.add(publisherPanel);
        topPanel.add(comicDispScroll);
        topPanel.add(numbToAddPanel);   
        overallPanel.add(topPanel);
        overallPanel.add(middlePanel);
        overallPanel.add(middle2Panel);
        overallPanel.add(bottomPanel);
        con.add(overallPanel);
    }

    public int CheckComicSelected (int index)
    {
        if (marvelBox.isSelected() == true && otherBox.isSelected() == true && dcBox.isSelected() == false)
        {
            index += dcVec.size();
        }
        if (dcBox.isSelected() == true && otherBox.isSelected() == true && marvelBox.isSelected() == false)
        {
            if (index >= dcVec.size())
            {
                index += marvelVec.size();
            }
        }
        if (marvelBox.isSelected() == true && otherBox.isSelected() == false && dcBox.isSelected() == false)
        {
            index += dcVec.size();
        }
        if (otherBox.isSelected() == true && dcBox.isSelected() == false && marvelBox.isSelected() == false)
        {
            index += dcVec.size();
            index += marvelVec.size();
        }
        else
        {
        }
        return index;
    }

    public void actionPerformed (ActionEvent e)
    {
        
        
        if (e.getSource() instanceof JButton)
        {
            
            if (e.getSource() == buyBut)
            {
                int numCopy, index, stock;
                String info, selectedObj;
                double pricePer = 0;
                double delivered;
                index = comicDispList.getSelectedIndex();
                info = comicDispList.getSelectedValue().toString();
                stock = cl.cmicList[index].getIntComicStock();
                index = CheckComicSelected(index);
                if (numCopyDropDown.getSelectedIndex() > 0)
                {
                    numCopy = numCopyDropDown.getSelectedIndex();
                    if (numCopy <= stock)
                    {
                        pricePer = cl.cmicList[index].getDoubComicPrice();
                        totalPrice += pricePer*numCopy;
                        purchPriceVec.add(pricePer*numCopy);
                        selectedObj = info + " (" + numCopy + ") $" + twoDec.format(pricePer*numCopy); 
                        comicSelVec.add(selectedObj);
                        comicSelList.setListData(comicSelVec);
                        stockVec.add(numCopy);
                        selectIndexVec.add(index);
                        cl.cmicList[index].setIntComicStock(stock - numCopy);
                        if ((stock - numCopy) == 0)
                        {
                            stockPanel.setBackground(Color.red);
                        }
                        stockText.setText("Stock: " + Integer.toString(stock-numCopy));
                        delivered = totalPrice + deliveryFee;
                        totalText.setText("Total: $" + twoDec.format(totalPrice) + " plus Delivery is: $" + twoDec.format(delivered));
                    }
                    else if (numCopy >= stock && stock != 0)
                    {
                        JOptionPane.showMessageDialog(this, "Not enough isses available, please re-select", "Not Allowed", JOptionPane.ERROR_MESSAGE);
                    }
                    else if (stock == 0)
                    {
                        JOptionPane.showMessageDialog(this, "No issues left, please re-select", "Not Allowed", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Select a number of comics to buy", "Not Allowed", JOptionPane.ERROR_MESSAGE);
                }
                numCopyDropDown.setSelectedIndex(0);                
            }
            else if (e.getSource() == enterBut)
            {
                if (passwordStr.compareToIgnoreCase("abcd") == 0)
                {
                    int tempIndex, tempStock;
                    for (int i = 0; i < comicSelVec.size(); i++)
                    {
                        tempIndex = (Integer)selectIndexVec.get(i);
                        tempStock = cl.cmicList[tempIndex].getIntComicStock();
                        cl.cmicList[tempIndex].setIntComicStock(tempStock+(Integer)stockVec.get(i));
                        totalPrice -= (Double)purchPriceVec.get(i);
                    }
                    passwordStr = "";
                    visPasswordStr = "";
                    passwordText.setText(visPasswordStr);
                    totalPrice = 0;
                    deliveryFee = 0;
                    totalText.setText("Total: $" + totalPrice + " plus Delivery: $" + (totalPrice+deliveryFee));
                    comicSelVec.clear();
                    comicDispVec.clear();
                    deliveryFee = 3.95;
                    comicPicBorder.setTitle("None");
                    stockVec.clear();
                    selectIndexVec.clear();
                    stockText.setText("Stock :");
                    purchPriceVec.clear();
                    marvelBox.setSelected(false);
                    dcBox.setSelected(false);
                    allBox.setSelected(false);
                    otherBox.setSelected(false);
                    withinRadio.setSelected(true);
                    outsideRadio.setSelected(false);
                    creditCardNumPF.setText("");
                    comicSelList.repaint();
                    comicDispList.repaint();
                    priceText.setText("Price: ");
                    numCopyDropDown.setSelectedIndex(0);
                    comicPic.setIcon(null);
                    comicPicPanel.repaint();
                    uf.setVisible(true);
                }
                else 
                {
                    JOptionPane.showMessageDialog(this, "Wrong password, please re-enter", "Not Allowed", JOptionPane.ERROR_MESSAGE);
                    passwordStr = "";
                    visPasswordStr = "";
                    passwordText.setText(visPasswordStr);
                }
            }
            else if (e.getSource() == resetBut)
            {
                visPasswordStr = "";
                passwordStr = "";
                passwordText.setText(passwordStr);
            }
            else if (e.getSource() == clearBut)
            {
                if (comicSelList.isSelectionEmpty() == true)
                {
                    JOptionPane.showMessageDialog(this, "No Comics Selected", "Not Allowed", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    int selIndex, comicIndex, cmicStock;
                    double clearPrice, delivered;
                    selIndex = comicSelList.getSelectedIndex();
                    comicIndex = (Integer)selectIndexVec.get(selIndex);
                    clearPrice = (Double)purchPriceVec.get(selIndex);
                    comicSelVec.remove(selIndex);
                    totalPrice -= clearPrice;
                    comicSelList.setListData(comicSelVec);
                    cmicStock = cl.cmicList[comicIndex].getIntComicStock();
                    cl.cmicList[comicIndex].setIntComicStock(cmicStock + (Integer)stockVec.get(selIndex));
                    if (comicSelVec.size() < 1)
                        deliveryFee = 0;
                    delivered = totalPrice + deliveryFee;
                    totalText.setText("Total: $" + twoDec.format(totalPrice) + " plus Delivery is: $" + twoDec.format(delivered));
                    comicDispList.clearSelection();
                    comicPic.setIcon(null);
                    priceText.setText("Price: ");
                    numCopyDropDown.setSelectedIndex(0);
                    stockText.setText("Stock: ");
                    stockPanel.setBackground(deliveryPanel.getBackground());
                }
            }
            else if (e.getSource() == clearAllBut)
            {
                if (comicSelVec.size() == 0)
                {
                    JOptionPane.showMessageDialog(this, "No Comics Selected", "Not Allowed", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    int tempIndex, tempStock;
                    double delivered;
                    for (int i = 0; i < comicSelVec.size(); i++)
                    {
                        tempIndex = (Integer)selectIndexVec.get(i);
                        tempStock = cl.cmicList[tempIndex].getIntComicStock();
                        cl.cmicList[tempIndex].setIntComicStock(tempStock+(Integer)stockVec.get(i));
                        totalPrice -= (Double)purchPriceVec.get(i);
                    }
                    comicSelVec.clear();
                    comicSelList.setListData(comicSelVec);
                    delivered = 0;
                    totalPrice = 0;
                    totalText.setText("Total: $" + twoDec.format(totalPrice) + " plus Delivery is: $" + twoDec.format(delivered));
                    comicDispList.clearSelection();
                    comicPic.setIcon(null);
                    priceText.setText("Price: ");
                    stockText.setText("Stock: ");
                    numCopyDropDown.setSelectedIndex(0);
                    stockPanel.setBackground(deliveryPanel.getBackground());
                }
            }
            else if (e.getSource() == submitBut)
            {
                String creditCardString = "";
                for (int i = 0; i < creditCardNumPF.getPassword().length; i++)
                {
                    creditCardString += creditCardNumPF.getPassword()[i];
                }
                int yesno = JOptionPane.showConfirmDialog(this, "Are you Sure?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (yesno == 0)
                {
                    if (comicSelVec.size() == 0)
                    {
                        if (creditCardString.compareTo("") == 0 || creditCardString.compareTo(" ") == 0)
                        {
                            JOptionPane.showMessageDialog(this, "Please enter a valid credit card", "Not Allowed", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else if (creditCardString.compareTo("") == 0 || creditCardString.compareTo(" ") == 0)
                    {
                        JOptionPane.showMessageDialog(this, "Please enter a valid credit card", "Not Allowed", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Total: $" + twoDec.format(totalPrice+deliveryFee) + " has been charged to your card, Thank you!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                
            }
            else
            {
                passwordStr += e.getActionCommand();
                visPasswordStr += "*";
                passwordText.setText(visPasswordStr);
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
                    stockText.setText("Stock: ");
                    priceText.setText ("Price: ");
                    for (int i = 0; i < indexVec.size(); i++)
                    {
                        comicDispVec.add(indexVec.get(i));
                    }
                    allBox.setSelected(true);
                }
                else
                {
                    comicDispVec.clear();
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
                }
                else
                {
                    for (int i = 0; i < otherVec.size(); i++)
                    {
                        comicDispVec.remove(otherVec.get(i));
                    }
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
                }
                else
                {
                    for (int i = 0; i < marvelVec.size(); i++)
                    {
                        comicDispVec.remove(marvelVec.get(i));
                    }
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
                }
                else
                {
                    for (int i = 0; i < dcVec.size(); i++)
                    {
                        comicDispVec.remove(dcVec.get(i));
                    }
                }
            }
            comicDispList.setListData(comicDispVec);
        }
        else
        {
            if (withinRadio.isSelected() == true)
            {
                deliveryFee = 0;
                deliveryFee += 3.95;
                double delivered = totalPrice + deliveryFee;
                if (comicSelVec.size() == 0)
                    delivered = 0;
                totalText.setText("Total: $" + totalPrice + " plus Delivery is: $" + delivered);
            }
            else if (outsideRadio.isSelected() == true)
            {
                deliveryFee = 0;
                deliveryFee += 7.52;
                double delivered = totalPrice + deliveryFee;
                if (comicSelVec.size() == 0)
                    delivered = 0;
                totalText.setText("Total: $" + totalPrice + " plus Delivery is: $" + delivered);
            }
        }
    }

    public void valueChanged (ListSelectionEvent e)
    {
        int index, stock, issue;
        double price;
        String stockStr, priceStr, imageName, title, issueStr;
        char pub;
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
                    index = CheckComicSelected(index);
                    pub = cl.cmicList[index].getChComicPubType();
                    if (pub == 'm')
                    {
                        comicDispList.setSelectionBackground(Color.blue);
                        comicDispList.setSelectionForeground(Color.white);
                        comicDispList.repaint();
                    }
                    else if (pub == 'd')
                    {
                        comicDispList.setSelectionBackground(Color.red);
                        comicDispList.setSelectionForeground(Color.white);
                        comicDispList.repaint();
                    }
                    else
                    {
                        comicDispList.setSelectionBackground(Color.yellow);
                        comicDispList.setSelectionForeground(Color.black);
                        comicDispList.repaint();
                    }
                    issue = cl.cmicList[index].getIntComicIssue();
                    stock = cl.cmicList[index].getIntComicStock();
                    if (stock == 0)
                    {
                        stockPanel.setBackground(Color.red);
                        stockPanel.repaint();
                    }
                    else
                    {
                        stockPanel.setBackground(deliveryPanel.getBackground());
                        stockPanel.repaint();
                    }
                    price = cl.cmicList[index].getDoubComicPrice();
                    imageName = cl.cmicList[index].getStrComicCover();
                    title = cl.cmicList[index].getStrComicTitle();
                    comicPic.setIcon(new ImageIcon(imageName));
                    issueStr = Integer.toString(issue);
                    comicPicBorder.setTitle(title + " #" + issueStr);
                    comicPicPanel.repaint();
                    stockStr = Integer.toString(stock);
                    priceStr = Double.toString(price);
                    stockText.setText("Stock: " + stockStr);
                    priceText.setText("Price: $" + priceStr);
                                  
                }
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
            index = CheckComicSelected(index);
            String info = cl.cmicList[index].getStrComicComment();
            comicPic.setText(info);
            comicPic.setVerticalAlignment(SwingConstants.TOP);
            comicPic.setIcon(null);
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
            index = CheckComicSelected(index);
            String imageName;
            imageName = cl.cmicList[index].getStrComicCover();
            comicPic.setVerticalAlignment(SwingConstants.CENTER);
            comicPic.setIcon(new ImageIcon(imageName));
            comicPic.setText(null);
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