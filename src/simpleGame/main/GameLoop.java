package simpleGame.main;


import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11.*;

import simpleGame.player.AIPlayer_MULTIPLAYER_TODO;
import simpleGame.player.PlayerObject;
import simpleGame.player.Player;
import static org.lwjgl.opengl.GL11.*;
import static simpleGame.settings.WindowSettings.*;
public class GameLoop {
	
	private PlayerObject player;
	private PlayerObject ai;
	
	public GameLoop(){
		initWindow();
		initGL();
		initVars();
		
		loop();
		
		destroy();
	}
	private void initVars() {
		player = new Player(60,HEIGHT/2, 0);
		
	}
	
	private void destroy() {
		Display.destroy();
		Keyboard.destroy();
		
	}
	private void loop() {
		
		while(!Display.isCloseRequested()){
			update();
			render();
			
			Display.update();
			Display.sync(60);
		}
		
	}
	private void render() {
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		player.draw();
		
	}
	private void update() {
		input();
		((Player) player).update();
		
	}
	private void input() {
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			player.changeSpeed(-.5f);;
		}else if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			player.changeSpeed(.5f);
		}else if(!Keyboard.isKeyDown(Keyboard.KEY_W) && !Keyboard.isKeyDown(Keyboard.KEY_S)){
			if(player.getSpeed() > 0){
				player.changeSpeed(-.1f);
			}else{
				player.changeSpeed(.1f);
			}
		}	
		if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			player.rotate(2f);;
		}else if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			player.rotate(-2f);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			((Player)player).fire();
		}
		
	}
	private void initGL() {

		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, 0, HEIGHT, -1, 1);
		glMatrixMode(GL_MODELVIEW);
		
	}
	private void initWindow() {
		Display.setResizable(false);
		Display.setTitle("Simple Trig Game");
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		
 	}
	public static void main(String[] args){
		new GameLoop();
	}
	
	
}
