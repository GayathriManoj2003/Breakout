// BrickView.java
package Breakout;

import java.awt.*;
import java.util.HashMap;

public class BrickView {
	HashMap<Integer, Color> mp;
	BrickView() {
		this.mp = new HashMap<Integer, Color>();
		mp.put(1, Color.YELLOW);
		mp.put(2, Color.ORANGE);
		mp.put(3, Color.RED);
	}
    public void drawBrick(Graphics2D g2d, int x, int y, BrickFlyweight flyweight, int durability) {
    	System.out.println(mp.get(durability));
    	g2d.setColor(mp.get(durability));
        
        g2d.fillRect(x, y, flyweight.getWidth(), flyweight.getHeight());
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawRect(x, y, flyweight.getWidth(),flyweight.getHeight());
    }
}
