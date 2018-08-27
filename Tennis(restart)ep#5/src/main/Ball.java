package main;

public class Ball extends Entity {
	
	public long lastCollision;

	public Ball(Tennis tennis) {
		super(tennis);
		this.speed /= 2;
		this.posX = (tennis.displayWidth/2) - (this.width/2);
		this.posY = (tennis.displayHeight/2) - (this.height/2);
		this.motionX = this.speed;
		this.motionY = this.speed;
		this.lastCollision = 0;
	}
	
	@Override
	public void onUpdate(Tennis tennis) {
		super.onUpdate(tennis);
		handleCollisions(tennis);
	}
	
	private void handleCollisions(Tennis tennis) {
		if(this.posX < 0) this.bounceX();
		if(this.posX + this.width > tennis.displayWidth) this.bounceX();
		if(this.posY < 0) this.bounceY();
		if(this.posY + this.height > tennis.displayHeight) this.bounceY();
		
		boolean collision = this.rect.intersects(tennis.thePlayer.rect) || this.rect.intersects(tennis.theEnemy.rect);
		
		if(collision && tennis.getTime() - this.lastCollision > 1000) {
			this.bounceX();
			this.lastCollision = tennis.getTime();
		}
	}

	private void bounceX() {
		this.motionX = -this.motionX;
	}
	
	private void bounceY() {
		this.motionY = -this.motionY;
	}
	
}
