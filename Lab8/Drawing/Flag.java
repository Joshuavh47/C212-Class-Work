package Drawing;

import javax.swing.*;
import java.awt.*;

public class Flag extends JComponent {

    public void paintComponent(Graphics g) {
        g.setColor(Color.GREEN.darker());
        g.fillRect(0, 0, 200, 300);
        g.setColor(Color.WHITE);
        g.fillRect(200, 0, 200, 300);
        g.setColor(Color.RED);
        g.fillRect(400, 0, 200, 300);
    }

}
