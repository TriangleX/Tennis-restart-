package main;

public class Enemy extends Entity {

	public Enemy(Tennis tennis) {
		super(tennis);
		this.posX = tennis.displayWidth - this.width - 16f;
		this.posY = (tennis.displayHeight/2) - (this.height/2);
		this.height *= 5;
	}
	
	@Override
	public void onUpdate(Tennis tennis) {
		super.onUpdate(tennis);
		
		float mistake = tennis.getRandRange(0.0f, 0.1f);
		
		this.motionY = (this.posY - tennis.theBall.posY > 0) ? - (this.speed + mistake) : this.speed + mistake;
	}
	
	@Override
	public void move(Tennis tennis, float mX, float mY) {
		if(this.posY < 0 && this.motionY < 0) return;
		if(this.posY + this.height > tennis.displayHeight && this.motionY > 0) return;
		
		super.move(tennis, mX, mY);
	}

}
