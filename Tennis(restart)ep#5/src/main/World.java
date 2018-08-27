package main;

import java.util.ArrayList;

public class World {
	
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	
	public World(Tennis tennis) {
		this.entities.add(tennis.thePlayer);
		this.entities.add(tennis.theEnemy);
		this.entities.add(tennis.theBall);
	}
	
	public void run(Tennis tennis) {
		for(Entity entity : this.entities) {
			entity.onUpdate(tennis);
		}
	}

}
