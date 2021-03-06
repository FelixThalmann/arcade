package games.pong.Tiles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import environment.model.KeyRequest;
import environment.model.gameobject.Drawable;
import environment.model.gameobject.ProceedsInput;
import environment.model.gameobject.Seat;
import environment.model.gameobject.Updateable;

public abstract class Tile implements Updateable, Drawable, ProceedsInput {

	public static final int SPEED = 30; // TODO hard coded

	public final Seat player;
	private int Tor;
	private int width;
	private int height;
	private int Pkt;
	static int i = 0;
	/**
	 * 
	 */
	Rectangle rect;

	/**
	 * 
	 */
	boolean stateLeft, stateRight;

	private KeyRequest KEYS;

	/**
	 * @param keyCode1
	 * @param keyCode2
	 * @throws Exception
	 */
	public Tile(Seat player, KeyRequest KEYS) {
		this.player = player;
		this.KEYS = KEYS;
		init();
	}

	/**
	 * 
	 */
	public abstract void actionLeft();

	/**
	 * 
	 */
	public abstract void actionRight();

	/*
	 * (non-Javadoc)
	 * 
	 * @see gamelibrary.GameObject#paint(java.awt.Graphics2D)
	 */
	@Override
	public void draw(Graphics2D GRAPHICS) {
		GRAPHICS.setColor(player.getColor());
		GRAPHICS.fill(rect);
		GRAPHICS.setFont(new Font("Courier", Font.PLAIN, 20));
		GRAPHICS.drawString(Integer.toString(getTor()), getX(), getY());
		GRAPHICS.setColor(Color.BLACK);
	}

	/**
	 * @return
	 */
	public boolean getstateLeft() {
		return stateLeft;
	}

	/**
	 * @return
	 */
	public boolean getstateRight() {
		return stateRight;
	}

	/**
	 * @return
	 */
	public int getX() {
		return rect.x;
	}

	/**
	 * @return
	 */
	public int getY() {
		return rect.y;
	}

	protected abstract void init();

	/*
	 * (non-Javadoc)
	 * 
	 * @see gamelibrary.GameObject#processInput(gamelibrary.FrameBasedGame)
	 */
	@Override
	public void processInput() {
		if (KEYS.isPressed(player.LEFT)) {

			stateLeft = true;

		}
		if (KEYS.isPressed(player.RIGHT)) {
			stateRight = true;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gamelibrary.GameObject#update(java.util.List)
	 */
	@Override

	public void update(long elapsed) {

		if (i <= 3) {
			init();
			i++;
		}
		if (stateLeft) {
			actionLeft();
			stateLeft = false;
		}
		if (stateRight) {
			actionRight();
			stateRight = false;
		}
	}

	public void setTor(int Tor) {
		this.Tor = Tor;
	}

	public int getTor() {
		return Tor;
	}

	public void setwidth(int width) {
		this.width = width;
	}

	public int getwidth() {
		return width;
	}

	public void setheight(int height) {
		this.height = height;
	}

	public int getheight() {
		return height;
	}

	public void seti() {
		i = 0;
	}

	public void setPkt() {
		Pkt = Pkt + 100;
	}

	public int getPkt() {
		return Pkt;
	}
}
