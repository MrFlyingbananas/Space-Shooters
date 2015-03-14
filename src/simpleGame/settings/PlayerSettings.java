package simpleGame.settings;

import java.util.Collection;

public class PlayerSettings {
	public static final float SPEED_INC_DELTA_MAX = .2f; 
	public static final float SPEED_DEC_DELTA_MAX = -.2f; 
	public static final float SPEED_MAX = 6f;
	public static final float SPEED_DEC_MAX = -6f;
	public static final int PWIDTH = 60;
	public static final int PHEIGHT = 60;
	public static final int CANNON_DEFAULT_NUMBER = 1;
	public static final int CANNON_MAX_NUMBER = 5;
	public static final int CANNON_WIDTH = 10;
	public static final int CANNON_HEIGHT = 40;
	public static final int[] CANNON_DEFAULT_XLOCS = {(PWIDTH/2) - CANNON_WIDTH};
	public static final int[] CANNON_DEFAULT_YLOCS = {PHEIGHT};
}