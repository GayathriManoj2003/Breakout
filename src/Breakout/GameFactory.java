package Breakout;

public interface GameFactory {
    GamePanel getGameInstance(String type);
}
