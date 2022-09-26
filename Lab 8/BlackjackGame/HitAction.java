package BlackjackGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static BlackjackGame.BlackjackPlayer.b;


public class HitAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        b.addCard();
    }
}
