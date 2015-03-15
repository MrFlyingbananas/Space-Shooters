package simpleGame.GameStateManager;

import simpleGame.settings.GameStateManagerSettings;

public class GameStateManager {
	private static int gameState;
	public static int getGameState(){
		return gameState;
	}
	public static void setGameState(int state) throws Exception{
		if(state < GameStateManagerSettings.GAMESTATE_MIN_VALUE){
			throw new Exception("GAMESTATE SWITCH BELOW BOUNDS");
		}else if(state > GameStateManagerSettings.GAMESTATE_MAX_VALUE){	
			throw new Exception("GAMESTATE SWITCH ABOVE BOUNDS");
		}else{
			GameStateManager.gameState = state;
		}
	}
}
