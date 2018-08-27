package main;

import org.lwjgl.input.Keyboard;

public class Player extends Entity {
	
	public Keybind keyUp;
	public Keybind keyDown;

	public Player(Tennis tennis) {
		super(tennis);
		this.posX = 16f;
		this.posY = (tennis.displayHeight/2) - (this.height/2);
		this.height *= 5f;
		
		this.keyUp = new Keybind(Keyboard.KEY_W, "Up");
		this.keyDown = new Keybind(Keyboard.KEY_S, "Down");
	}
	
	@Override
	public void onUpdate(Tennis tennis) {
		super.onUpdate(tennis);
		handlenput(tennis);
	}

	private void handlenput(Tennis tennis) {
		this.motionX = 0;
		this.motionY = 0;
		
		if(this.keyUp.isKeyDown()) this.motionY = -this.speed;
		if(this.keyDown.isKeyDown()) this.motionY = this.speed;
	}
	
	@Override
	public void move(Tennis tennis, float mX, float mY) {
		if(this.posY < 0 && this.motionY < 0) return;
		if(this.posY + this.height > tennis.displayHeight && this.motionY > 0) return;
		
		super.move(tennis, mX, mY);
	}

}
