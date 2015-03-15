package simpleGame.player;



import org.lwjgl.opengl.GL11.*;

import simpleGame.cannon.Cannon;
import static org.lwjgl.opengl.GL11.*;
import static simpleGame.settings.PlayerSettings.*;
import static simpleGame.settings.CannonSettings.*;

public class Player extends PlayerObject{

	private Cannon[] cannons;
	private int numberOfCannons;
	public Player(int x, int y, int angle) {
		super(x, y, angle);
		
		initCannons();
		
	}
	private void initCannons() {
		numberOfCannons = CANNON_DEFAULT_NUMBER;
		cannons = new Cannon[CANNON_MAX_NUMBER];
		for(int i = 0; i < numberOfCannons; i++){
			cannons[i] = new Cannon(CANNON_DEFAULT_XOFFSETS[i], CANNON_DEFAULT_YOFFSETS[i], getAngle(), 0, false, false);
			
		}
	}
	@Override
	public void draw(){
		drawPlayer();
	}
	private void drawCannons() {
		for(int i = 0; i < numberOfCannons; i++){
			cannons[i].draw();
		}
		
	}
	private void drawPlayer() {
		glPushMatrix();
		glColor3f(1f, 1f, 1f);
		glTranslatef(getX(), getY(),0);
		
		glRotatef(getAngle(),0,0,1);
		
		glTranslatef(-((float)PWIDTH/2), -((float)PHEIGHT/2), 0);
		glBegin(GL_TRIANGLES);
			
			glVertex2f(0, 0);
			glVertex2f((float)PWIDTH/2, PHEIGHT);
			glVertex2f(PWIDTH, 0);
			
		glEnd();
		drawCannons();
		glPopMatrix();
	}
	public void update(){
		moveVert();
		updateCannons();
		
	}
	
	private void updateCannons() {
		for(int i = 0; i < numberOfCannons; i++){
			cannons[i].update(getX(), getY(), getAngle());
		}
		
	}
	public void fire(){
		for(int i = 0; i < numberOfCannons; i++){
			cannons[i].fire();
		}
	}
}
