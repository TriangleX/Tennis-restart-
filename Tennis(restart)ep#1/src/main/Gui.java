package main;

import org.lwjgl.opengl.GL11;

public class Gui {
	
	public float getRedFromHex(int color) {
		return (float)(color >> 16 & 0xFF) / 255f;
	}
	
	public float getGreenFromHex(int color) {
		return (float)(color >> 8 & 0xFF) / 255f;
	}
	
	public float getBlueFromHex(int color) {
		return (float)(color & 0xFF) / 255f;
	}
	
	public float getAlphaFromHex(int color) {
		return (float)(color >> 24 & 0xFF) / 255f;
	}
	
	public void drawRect(float x, float y, float width, float height, int color) {
		float r = this.getRedFromHex(color);
		float g = this.getGreenFromHex(color);
		float b = this.getBlueFromHex(color);
		float a = this.getAlphaFromHex(color);
		
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		
		GL11.glColor4f(r, g, b, a);
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2f(x, y);
			GL11.glVertex2f(x + width, y);
			GL11.glVertex2f(x + width, y + height);
			GL11.glVertex2f(x, y + height);
		GL11.glEnd();
		
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}

}
