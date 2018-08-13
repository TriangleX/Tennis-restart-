package main;

import java.util.ArrayList;

public class World {
	
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	
	public World(Tennis tennis) {
		this.entities.add(tennis.thePlayer);
	}
	
	public void run(Tennis tennis) {
		for(Entity entity : this.entities) {
			entity.onUpdate(tennis);
		}
	}

}
