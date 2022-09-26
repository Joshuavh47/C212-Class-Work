package MouseListenerPackage;

import java.awt.*;
import java.awt.event.MouseListener;
import javax.swing.*;
public class MouseListenerDemo extends MouseListenerImplementation {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Listener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel primary = new JPanel();
        primary.setBackground(Color.white);
        primary.setPreferredSize(new Dimension(500, 125));
        MouseListenerImplementation m = new MouseListenerImplementation();
        primary.addMouseListener(m);
        frame.getContentPane().add(primary);
        frame.pack();
        frame.setVisible(true);

    }
}
