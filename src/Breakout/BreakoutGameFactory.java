package Breakout;

public class BreakoutGameFactory implements GameFactory {
    public GamePanel getGameInstance(String type) {
        if (type.equals("Hard"))
            return new HardGamePanel();
        else if (type.equals("Easy"))
            return new EasyGamePanel();

        // Default return if type doesn't match
        return new MediumGamePanel();
    }
}