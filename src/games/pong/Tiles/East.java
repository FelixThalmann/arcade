package games.pong.Tiles;

import java.awt.Rectangle;
import java.awt.Toolkit;

import environment.model.KeyRequest;
import environment.model.gameobject.Seat;

public class East extends Tile {

	public East(Seat player, KeyRequest KEYS) {

		super(player, KEYS);
		setheight(300);
		setwidth(50);
		init();
	}

	@Override
	public void actionLeft() {
		if (rect.y + 300 <= Toolkit.getDefaultToolkit().getScreenSize().height && getTor() != 0) {
			rect.y += SPEED;
		}
	}

	@Override
	public void actionRight() {
		if (rect.y >= 100 && getTor() != 0) {
			rect.y -= SPEED;
		}

	}

	@Override
	protected void init() {
		int y = (int) (Toolkit.getDefaultToolkit().getScreenSize().height * .5 - getheight() * .5);
		int x = Toolkit.getDefaultToolkit().getScreenSize().width - getwidth();
		rect = new Rectangle(x, y, getwidth(), getheight());
		// rect = new Rectangle(1850, 350, 50, 300);

	}

}
