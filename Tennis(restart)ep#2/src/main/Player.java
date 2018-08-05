package main;

public class Player extends Entity {

	public Player(Tennis tennis) {
		super(tennis);
		this.posX = 16f;
		this.posY = (tennis.displayHeight/2) - (this.height/2);
		this.height *= 5f;
	}
	
	@Override
	public void onUpdate(Tennis tennis) {
		super.onUpdate(tennis);
		handlenput(tennis);
	}

	private void handlenput(Tennis tennis) {
		
	}

}
