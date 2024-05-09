package main.views;

import java.awt.Color;
import java.awt.Graphics2D;

public class BallView {
	public void drawBall(Graphics2D g2d, int ballPosX, int ballPosY, int radius, Color ballColor) {
		int x = ballPosX - radius;
        int y = ballPosY - radius;
        int diameter = radius * 2;
        g2d.setColor(ballColor);
        g2d.fillOval(x, y, diameter, diameter);
	}
}
