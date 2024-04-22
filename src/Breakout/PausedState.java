package Breakout;

import javax.swing.*;
import java.awt.event.KeyEvent;
class PausedState implements GameState {
    @Override
    public void handleKey(GameFrame frame, KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
            frame.setCurrentState(new PlayingState());
        }
    }
}
