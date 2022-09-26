package Drawing;

import KeyListenerPackage.KeyListenerImplementation;

import javax.swing.*;
import java.awt.*;

public class FlagDisplay extends JFrame {
    public FlagDisplay(){
        this.setVisible(true);
        this.setSize(600,300);
        this.add(new Flag());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        FlagDisplay f = new FlagDisplay();
    }
}
