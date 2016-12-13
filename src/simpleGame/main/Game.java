package simpleGame.main;

import static simpleGame.settings.WindowSettings.HEIGHT;
import static simpleGame.settings.WindowSettings.WIDTH;

import org.lwjgl.input.Keyboard;

import simpleGame.player.Player;
import simpleGame.player.PlayerObject;

public class Game {
	private static PlayerObject player =  new Player(WIDTH/2,HEIGHT/2, 0);
	
	
	static void render() {
		player.draw();
		
	}
	static void update() {
		input();
		((Player) player).update();
		
	}
	private static void input() {
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
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
			((Player)player).fire();
		}
		
	}
}
