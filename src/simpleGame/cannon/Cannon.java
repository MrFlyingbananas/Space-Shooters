package simpleGame.cannon;

import static org.lwjgl.opengl.GL11.*;
import static simpleGame.settings.CannonSettings.*;
import simpleGame.missle.Laser;
import simpleGame.settings.MissleSettings;
import simpleGame.settings.PlayerSettings;
public class Cannon extends CannonObject{
	public Cannon(float xPosOnShip, float yPosOnShip, float baseAngle, int cannonType, boolean isReloading, boolean isDisabled) {
		super(xPosOnShip, yPosOnShip, baseAngle, cannonType, isReloading, isDisabled);
	
	}
	
	@Override
	public void draw() {
	
		glColor3f( 1f, 0f, 0f);
		glBegin(GL_QUADS);
		glVertex2f(getXOffset(),getYOffset());
		glVertex2f(getXOffset(),CANNON_HEIGHT+getYOffset());
		glVertex2f(CANNON_WIDTH+getXOffset(),CANNON_HEIGHT+getYOffset());
		glVertex2f(CANNON_WIDTH+getXOffset(),getYOffset());
		glEnd();
	}



	@Override
	public void fire() {
		if(!isReloading()){
			new Laser(getX() + CANNON_WIDTH, getY() + CANNON_HEIGHT, getAngle(), MissleSettings.MISSLETYPE_LASER);
			reload();
		}
		
	}

}
