package main.interfaces;

import main.gamepanels.GamePanel;

public interface GameFactory {
    GamePanel getGameInstance(String type);
}
