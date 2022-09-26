package BlackjackGame;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Math;
import java.util.Random;

import java.util.concurrent.TimeUnit;

public class BlackjackPlayer{
    ArrayList<Integer> playerCards;
    ArrayList<String> keysAsArray;
    HashMap<String, Integer> cards=new HashMap<String, Integer>();
    int[] handTotals;
    JLabel playerCardsLabel;
    JLabel playerTotalLabel;
    static BlackjackPlayer b=new BlackjackPlayer();
    JFrame frame;
    int rand;
    public BlackjackPlayer(){
        frame=new JFrame("Blackjack");
        JPanel panel=new JPanel();
        panel.setPreferredSize(new Dimension(1000, 600));
        JPanel status = new JPanel();
        status.setBounds(50, 50, 350, 500);
        status.setBackground(Color.white);


        JPanel playerPanel=new JPanel();
        playerPanel.setBounds(600, 50, 350, 500);
        playerPanel.setBackground(Color.white);
        frame.add(panel);
        panel.setBackground(Color.gray);

        panel.setLayout(null);
        Random r=new Random();

        JLabel totalsLabel=new JLabel();
        JButton hit=new JButton("Hit");

        panel.add(hit);
        Border dealerBorder = BorderFactory.createTitledBorder("Dealer");
        status.setBorder(dealerBorder);
        Border playerBorder = BorderFactory.createTitledBorder("Player");
        playerPanel.setBorder(playerBorder);

        hit.setBounds(400, 200, 200, 100);
        JButton stay=new JButton("Stay");
        stay.setBounds(400, 300, 200, 100);
        panel.add(stay);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.add(status);
        panel.add(playerPanel);
        frame.pack();
        panel.setVisible(true);
        frame.setVisible(true);
        panel.setFocusable(true);
        JLabel dealerTotalLabel=new JLabel();
        dealerTotalLabel.setBounds(100,100, 25, 25);
        dealerTotalLabel.setFont(new Font("Tahoma", Font.PLAIN,35));
        status.add(dealerTotalLabel);


        handTotals= new int[2];
        handTotals[0]=0;
        handTotals[1]=0;
        boolean busted=false;
        cards=new HashMap<String, Integer>();
        cards.put("A", 1);
        cards.put("2", 2);
        cards.put("3", 3);
        cards.put("4", 4);
        cards.put("5", 5);
        cards.put("6", 6);
        cards.put("7", 7);
        cards.put("8", 8);
        cards.put("9", 9);
        cards.put("10", 10);
        cards.put("J", 10);
        cards.put("Q", 10);
        cards.put("K", 10);
        rand=r.nextInt(13);
        dealerTotalLabel.setText("Dealer: ["+getKey(cards, rand)+"][X]");
        playerCards=new ArrayList<Integer>();
        keysAsArray = new ArrayList<String>(cards.keySet());
        int r1=r.nextInt(13);
        int r2=r.nextInt(13);
        playerCards.add(cards.get(keysAsArray.get(r1)));
        playerCards.add(cards.get(keysAsArray.get(r2)));
        playerCardsLabel =new JLabel("Player: ["+getKey(cards, playerCards.get(0))+"]["+getKey(cards, playerCards.get(1))+"]");
        playerCardsLabel.setBounds(600, 100, 25, 25);
        playerCardsLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
        playerPanel.add(playerCardsLabel);
        for (int i:playerCards){
            if(i==1){
                handTotals[0]+=1;
                handTotals[1]+=11;
            }
            else if (i==11){
                handTotals[0]+=10;
                handTotals[1]+=10;
            }
            else if(i==12){
                handTotals[0]+=10;
                handTotals[1]+=10;
            }
            else if(i==13){
                handTotals[0]+=10;
                handTotals[1]+=10;
            }
            else{
                handTotals[0]+=i;
                handTotals[1]+=i;
            }
        }
        playerTotalLabel =new JLabel("You have: "+playerHandAmount(handTotals));
        playerTotalLabel.setBounds(600, 300, 25, 25);
        playerTotalLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        playerPanel.add(playerTotalLabel);
        hit.addActionListener(new HitAction());
        if(handTotals[0]==21||handTotals[1]==21){
            blackjack();
        }
    }

    public static void main(String[] args) {


    }
    public static int parseData(String i){
        if (i.equals("A")){
            return 1;
        }
        else if(i.equals("J")){
            return 11;
        }
        else if(i.equals("Q")){
            return 12;
        }
        else if(i.equals("K")){
            return 13;
        }
        else{
            return Integer.parseInt(i);
        }
    }
    public int getAces(){
        int retInt=0;
        for (int i:playerCards){
            if (i==1){
                retInt++;
            }
        }
        return retInt;
    }
    public String playerHandAmount(int[] intArr) {
        if(handTotals[0]!=handTotals[1]){
            if(handTotals[0]<=21&&handTotals[1]<=21) {
                return handTotals[0] + "," + handTotals[1];
            }
            else if(handTotals[0]>21&&handTotals[1]<=21){
                return String.valueOf(handTotals[1]);
            }
            else if(handTotals[0]<=21&&handTotals[1]>21){
                return String.valueOf(handTotals[0]);
            }
        }
        else{
            return String.valueOf(handTotals[0]);
        }
        return handTotals[0] + "," + handTotals[1];
    }
    public static String getKey(HashMap<String, Integer> map, int value)
    {
        if (value==10){
            return "K";
        }
        for (String key: map.keySet())
        {
            if (value==(map.get(key))) {
                return key;
            }
        }
        return "10";
    }
    public void addCard(){
        Random r=new Random();
        playerCards.add(cards.get(keysAsArray.get(r.nextInt(13))));
        if(playerCards.get(playerCards.size()-1)==1){
            handTotals[0]+=1;
            handTotals[1]+=11;
        }
        else if(playerCards.get(playerCards.size()-1)==11||playerCards.get(playerCards.size()-1)==12||playerCards.get(playerCards.size()-1)==13){
            handTotals[0]+=10;
            handTotals[1]+=10;
        }

        else{
            handTotals[0]+=playerCards.get(playerCards.size()-1);
            handTotals[1]+=playerCards.get(playerCards.size()-1);
        }
        playerCardsLabel.setText("Player: "+toString(playerCards));
        playerTotalLabel.setText("You have: "+playerHandAmount(handTotals));
        if(handTotals[0]>21&&handTotals[1]>21){
            bust();
        }
        if(handTotals[0]==21||handTotals[1]==21){
            blackjack();
        }
    }
    public String toString(ArrayList<Integer> a){
        String retString="";
        for(int i:a){
            retString+="["+getKey(cards, i)+"]";
        }
        return retString;
    }
    public void bust(){
        frame.dispose();
        JFrame bustFrame = new JFrame();
        JPanel bustPanel=new JPanel();
        bustPanel.setPreferredSize(new Dimension(1000,600));
        bustPanel.setBounds(0,0,1000,600);
        bustPanel.setBackground(Color.WHITE);
        bustFrame.add(bustPanel);
        JLabel bustLabel=new JLabel("You Busted:(\nYou had: "+toString(playerCards)+", "+playerHandAmount(handTotals));
        JLabel bustLabel2=new JLabel("Dealer had: ["+getKey(cards,rand)+"]");
        bustLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
        bustLabel.setBounds(0, 0, 500, 500);
        bustLabel2.setFont(new Font("Tahoma", Font.PLAIN, 50));
        bustLabel2.setBounds(0, 300, 500, 500);
        bustPanel.add(bustLabel);
        bustPanel.add(bustLabel2);
        bustFrame.pack();
        bustFrame.setVisible(true);

    }
    public void blackjack(){
        frame.dispose();
        JFrame bjFrame = new JFrame();
        JPanel bjPanel=new JPanel();
        bjPanel.setPreferredSize(new Dimension(1000,600));
        bjPanel.setBounds(0,0,1000,600);
        bjPanel.setBackground(Color.WHITE);
        bjFrame.add(bjPanel);
        JLabel bjLabel=new JLabel("Blackjack!\nYou had: 21, "+toString(playerCards));
        JLabel bjLabel2=new JLabel("Dealer had: ["+getKey(cards, rand)+"]");
        bjLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
        bjLabel.setBounds(0, 0, 500, 500);
        bjLabel2.setFont(new Font("Tahoma", Font.PLAIN, 50));
        bjLabel2.setBounds(0, 300, 500, 500);
        bjPanel.add(bjLabel);
        bjPanel.add(bjLabel2);
        bjFrame.pack();
        bjFrame.setVisible(true);
    }
}
