package main;

import org.lwjgl.input.Keyboard;

public class Keybind {
	
	public int keyCode;
	public String description;
	public boolean[] keyStates;
	
	public Keybind(int keyCode, String description) {
		this.keyCode = keyCode;
		this.description = description;
		this.keyStates = new boolean[256];
	}
	
	private boolean checkKey(int i) {
		if(Keyboard.isKeyDown(i) != this.keyStates[i]) {
			return this.keyStates[i] != this.keyStates[i];
		} else {
			return false;
		}
	}
	
	public boolean isKeyDown() {
		return Keyboard.isKeyDown(this.keyCode);
	}
	
	public boolean isKeyPressed() {
		return this.checkKey(this.keyCode);
	}

}
