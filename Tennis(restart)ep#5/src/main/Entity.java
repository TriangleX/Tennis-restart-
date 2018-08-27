package main;

import java.awt.Rectangle;

public class Entity {
	
	public float posX, posY;
	public float motionX, motionY;
	public float width, height;
	public float speed;
	public Rectangle rect;
	public Gui gui;
	
	public Entity(Tennis tennis) {
		this.posX = 0;
		this.posY = 0;
		this.motionX = 0;
		this.motionY = 0;
		this.width = 16f;
		this.height = 16f;
		this.speed = 5.0f;
		this.rect = new Rectangle();
		this.setBounds();
		this.gui = new Gui();
	}
	
	public void setBounds() {
		this.rect.x = (int) this.posX;
		this.rect.y = (int) this.posY;
		this.rect.width = (int) this.width;
		this.rect.height = (int) this.height;
	}
	
	public void onUpdate(Tennis tennis) {
		this.setBounds();
		this.move(tennis, this.motionX, this.motionY);
		this.Render(tennis);
	}

	public void move(Tennis tennis, float mX, float mY) {
		this.posX += mX;
		this.posY += mY;
	}
	
	public void Render(Tennis tennis) {
		gui.drawRect(this.posX, this.posY, this.width, this.height, 0xFF000000);
	}

}
