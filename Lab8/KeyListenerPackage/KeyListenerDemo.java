package KeyListenerPackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class KeyListenerDemo {
    static boolean close = false;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Key Listener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel primary = new JPanel();
        primary.setFocusable(true);
        KeyListenerImplementation k = new KeyListenerImplementation();
        primary.addKeyListener(new KeyListenerImplementation());
        primary.setBackground(Color.white);
        primary.setPreferredSize(new Dimension(500, 125));
        frame.getContentPane().add(primary);
        frame.pack();
        frame.setVisible(true);

    }


}
