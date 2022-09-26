package KeyListenerPackage;

import java.awt.event.*;


public class KeyListenerImplementation implements KeyListener {
    public KeyListenerImplementation(){

    }
    int count = 0;
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar()=='e'){
            System.exit(0);
        }
        else if(e.getKeyChar()=='h'){
            System.out.println("Hello world!");
        }
        else{
            System.out.println(e.getKeyChar());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        count++;
        System.out.println("You have pressed the keyboard "+count+" times.");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyChar()+","+e.getKeyCode());
    }
}
