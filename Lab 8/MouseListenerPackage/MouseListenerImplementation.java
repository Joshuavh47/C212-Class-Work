package MouseListenerPackage;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerImplementation implements MouseListener {
    int count = 0;
    public MouseListenerImplementation(){

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        count++;
        System.out.println(count);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println("("+x+","+y+") - Mouse was released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
