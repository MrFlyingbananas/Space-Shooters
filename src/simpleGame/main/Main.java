package simpleGame.main;


import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11.*;

import simpleGame.GameStateManager.GameStateManager;
import simpleGame.player.AIPlayer_MULTIPLAYER_TODO;
import simpleGame.player.PlayerObject;
import simpleGame.player.Player;
import simpleGame.settings.GameStateManagerSettings;
import static org.lwjgl.opengl.GL11.*;
import static simpleGame.settings.WindowSettings.*;
public class Main {
	
	
	public Main(){
		try {
			GameStateManager.setGameState(GameStateManagerSettings.GAMESTATE_GAME_INT);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("CRITICAL ERROR: \n\n");
			e.printStackTrace();
			destroy();
		}
		initWindow();
		initGL();
		
		loop();
		
		destroy();
	}


	
	private void destroy() {
		Display.destroy();
		Keyboard.destroy();
		
	}
	private void loop() {
		
		while(!Display.isCloseRequested()){
			glMatrixMode(GL_MODELVIEW);
			glLoadIdentity();
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

			switch(GameStateManager.getGameState()){
				case GameStateManagerSettings.GAMESTATE_GAME_INT:
					Game.update();
					Game.render();
					
					
					break;
				case GameStateManagerSettings.GAMESTATE_MAP_INT:
					
					break;
				case GameStateManagerSettings.GAMESTATE_MENU_INT:
					
					break;
				case GameStateManagerSettings.GAMESTATE_PAUSESCREEN_INT:
					
					break;
			}
			Display.update();
			Display.sync(60);
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
		new Main();
	}
	
	
}
