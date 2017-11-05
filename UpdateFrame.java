import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.text.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.event.ChangeListener;

public class UpdateFrame extends JFrame
{
    ComicBuy cb = new ComicBuy();
    ComicList comicLt = new ComicList();
    JComboBox comicCombo;
    JButton updateInvBut;
    JTextArea invTextArea;
    JPanel stockPanel, bottomPanel, topPanel, middlePanel, overallPanel, sliderAndTF,tFPanel;
    JPanel blankPanel[] = new JPanel [6];
    JScrollPane invScroll;
    JLabel comicPriceLabel;
    JSlider stockSlider;
    JCheckBox lockBox;
    JTextField stockText;
    int stockInt;
    double priceDouble;
    Vector comicVec;
    String tempStr;

    Container con;

    public void createScreen()
    {
        comicLt.createList();
        con = getContentPane();
        stockPanel = new JPanel (new GridLayout(1,3, 50, 50));
        sliderAndTF = new JPanel (new GridLayout(1,2));
        bottomPanel = new JPanel (new GridLayout (1,2));
        topPanel = new JPanel (new GridLayout (1,0));
        middlePanel = new JPanel (new GridLayout (2,3));
        overallPanel = new JPanel (new GridLayout (3,1));
        tFPanel = new JPanel(new GridLayout(2,1));

        updateInvBut = new JButton("Update Current Record");
        invTextArea = new JTextArea();
        invScroll = new JScrollPane(invTextArea);
        comicPriceLabel = new JLabel();
        stockSlider = new JSlider(0, 50);
        lockBox = new JCheckBox("Lock");
        stockText = new JTextField();
        comicVec = new Vector();
        Font invFont = new Font("Helvetica", Font.BOLD+Font.ITALIC, 14);

        for (int i = 0; i < blankPanel.length; i++)
        {
            blankPanel[i] = new JPanel (new GridLayout (0,1));
        }
        for (int i = 0; i < comicLt.cmicList.length; i++)
        {
            tempStr = comicLt.cmicList[i].getStrComicTitle() + " Vol: " + comicLt.cmicList[i].getIntComicVol() + " #. " + comicLt.cmicList[i].getIntComicIssue() + " Pub: " + comicLt.cmicList[i].getStrComicPub();
            comicVec.add(tempStr); 
        }
        
        comicCombo = new JComboBox(comicVec);
        comicPriceLabel.setBorder(new TitledBorder("Comic Price"));
        invTextArea.setFont(invFont);
        stockSlider.setMajorTickSpacing(5);
        stockSlider.createStandardLabels(5);
        stockSlider.setPaintLabels(true);
        

        tFPanel.add(stockText);
        tFPanel.add(blankPanel[5]);
        sliderAndTF.add(stockSlider);
        sliderAndTF.add(tFPanel);
        stockPanel.add(lockBox);
        stockPanel.add(stockSlider);
        stockPanel.add(tFPanel);
        topPanel.add(comicCombo);
        topPanel.add(stockPanel);
        middlePanel.add(blankPanel[0]);
        middlePanel.add(comicPriceLabel);
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
    public static void main (String args[])
    {
        UpdateFrame uf = new UpdateFrame();
        uf.createScreen();
        uf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        uf.setSize(1366,768);
        uf.setVisible(true);

    }
}