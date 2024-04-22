package Breakout;

import javax.swing.*;
import java.awt.event.KeyEvent;

class QuitState implements GameState {
    @Override
    public void handleKey(GameFrame frame, KeyEvent e) {
        // Handle quitting the game
        System.exit(0);
    }
}
