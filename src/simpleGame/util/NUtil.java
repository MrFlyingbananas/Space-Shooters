package simpleGame.util;

import org.lwjgl.Sys;

public class NUtil {
	public static long getTime(){
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
}
