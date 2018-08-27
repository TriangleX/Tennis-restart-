package main;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Tennis {
	
	private static Tennis tennis;
	public String TITLE = "Tennis";
	public int displayWidth = 800;
	public int displayHeight = 600;
	public static boolean isRunning = true;
	public Player thePlayer;
	public Enemy theEnemy;
	public Ball theBall;
	public World theWorld;
	
	public static void main(String[] args) {
		init();
		initGL();
		gameLoop();
		cleanUp();
	}
	
	private static void init() {
		tennis = new Tennis();
		tennis.thePlayer = new Player(tennis);
		tennis.theBall = new Ball(tennis);
		tennis.theEnemy = new Enemy(tennis);
		tennis.theWorld = new World(tennis);
		
		try {
			Display.setDisplayMode(new DisplayMode(tennis.displayWidth, tennis.displayHeight));
			Display.setInitialBackground(1.0f, 1.0f, 1.0f);
			Display.setTitle(tennis.TITLE);
			Display.create();
		} catch(LWJGLException e) {
			isRunning = false;
			e.printStackTrace();
		}
	}
	
	private static void initGL() {
		
	}
	
	private static void gameLoop() {
		while(!Display.isCloseRequested() && isRunning) {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glLoadIdentity();
			
			tennis.init2D();
			tennis.theWorld.run(tennis);
			
			Display.sync(100);
			Display.update();
		}
	}
	
	private static void cleanUp() {
		isRunning = false;
		Display.destroy();
	}
	
	public void init2D() {
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glDisable(GL11.GL_LIGHTING);
		
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0.0f, Display.getWidth(), Display.getHeight(), 0.0f, -1.0f, 1.0f);
		
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
		
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.4f);
	}
	
	public long getTime() {
		return(Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	public float getRandRange(float min, float max) {
		return min + (float)(Math.random() * max);
	}

}
