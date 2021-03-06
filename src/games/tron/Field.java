package games.tron;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;

import environment.model.gameobject.Drawable;
import environment.model.gameobject.Seat;

public class Field implements Drawable {
	
	private Color[][] wuermer;
	
	private int floor[][];
	private final int tileSize;
	
	private final int width; // breite
	private final int height; // hoehe
	
	Field (int[][] floor2, int tileSize2, int width2, int height2) {
		
		this.floor = floor2;
		this.tileSize = tileSize2;
		
		this.width = width2;
		this.height = height2;
		

		wuermer = new Color[(1024 / tileSize)][(1024 / tileSize)];
	}

//---------------------------------------------------------------------------------------------------------------------------
//	Bild Zentralisiern | wuemer malen mit schweif 
	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height); 
		Graphics2D g2 = (Graphics2D) g;
		
		// Male Boden
		for (int y = 0; y < (height); y++) {
			for (int x = 0; x < (width); x++) {
				if (wuermer[x][y] != null) {
					g.setColor(wuermer[x][y]);
					g.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
				} else {
					if (floor[x][y] == 0); 
					else {
						if (floor[x][y] == 1) { // spieler
							g.setColor(Seat.P1.getColor());
						} else if (floor[x][y] == 2) {
							g.setColor(Seat.P2.getColor());
						} else if (floor[x][y] == 3) {
							g.setColor(Seat.P3.getColor());
						} else if (floor[x][y] == 4) {
							g.setColor(Seat.P4.getColor());
						} else {
							g.setColor(Color.DARK_GRAY);
						}
						g.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
					}
				}
			}
		}
	}

}
