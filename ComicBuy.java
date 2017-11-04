import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.util.Vector;
import java.util.*;
import javax.swing.border.*;

public class ComicBuy extends JFrame
{
    JPanel keyPadPanel, enterPanel, employeePanel, blank1Panel, blank2Panel, bottomPanel, middlePanel, middle2Panel, paymentPanel, creditCardPanel;
    JPanel deliveryPanel, topPanel, publisherPanel, numbToAddPanel, overallPanel;
    JButton JBut[] = new JButton[10];
    JButton enterBut, resetBut, clearBut, clearAllBut, submitBut, buyBut;
    JCheckBox allBox, marvelBox, dcBox, otherBox;
    JLabel passwordText, keypadInsText, totalText, enterCCText, stockText, priceText, comicPic;
    JTextField creditCardNumTF;
    JScrollPane comicSelScroll, comicDispScroll;
    JList comicSelList, comicDispList;
    JComboBox numCopyDropDown;
    JRadioButton withinRadio, outsideRadio;
    
    Vector comicSelVec, numCopyVec, comicDispVec; 
    
    Container con;
    
    public void createScreen()
    {
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
        passwordText = new JLabel();
        keypadInsText = new JLabel("Use Keypad to enter password for settings");
        totalText = new JLabel ("Total:");
        enterCCText = new JLabel ("Enter credit card number:");
        enterCCText.setHorizontalAlignment(JLabel.RIGHT);
        creditCardNumTF = new JTextField();
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
        withinRadio = new JRadioButton("Within Canada (+$3.95)");
        outsideRadio = new JRadioButton("Outside Canada (+$7.52)");
        stockText = new JLabel("Stock:");
        priceText = new JLabel("Price:");
        buyBut = new JButton();
        comicPic = new JLabel();

        
        for (int i = 0; i < JBut.length; i++)
        {
            int temp = i+65;
            char Char = (char)temp;
            JBut[i] = new JButton(String.valueOf(Char));
            keyPadPanel.add(JBut[i]);
        }
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
        comicPic.setBorder(new TitledBorder("None"));
        comicPic.setBackground(Color.YELLOW);
        totalText.setBackground(Color.CYAN);
        totalText.setOpaque(true);
        passwordText.setOpaque(true);

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
        creditCardPanel.add(creditCardNumTF);
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