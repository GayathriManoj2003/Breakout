package Breakout;

import javax.swing.*;
import java.awt.event.KeyEvent;

interface GameState {
    void handleKey(GameFrame frame, KeyEvent e);
}
