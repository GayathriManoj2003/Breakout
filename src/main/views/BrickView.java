// BrickView.java
package main.views;

import java.awt.*;
import java.util.HashMap;

public class BrickView {
	HashMap<Integer, Color> mp;
	public BrickView() {
		this.mp = new HashMap<Integer, Color>();
		mp.put(1, Color.YELLOW);
		mp.put(2, Color.ORANGE);
		mp.put(3, Color.RED);
	}
    public void drawBrick(Graphics2D g2d, int x, int y, int width, int height, int durability) {
        g2d.setColor(mp.get(durability));
        
        g2d.fillRect(x, y, width, height);
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawRect(x, y, width, height);
    }
}
