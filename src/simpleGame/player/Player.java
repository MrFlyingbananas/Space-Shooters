package simpleGame.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.lwjgl.opengl.GL11.*;

import static org.lwjgl.opengl.GL11.*;
import static simpleGame.settings.PlayerSettings.*;
public class Player extends GameObject{

	private int[] cannonXLocs; 
	private int[] cannonYLocs;
	private int numberOfCannons;
	public Player(int x, int y, int angle) {
		super(x, y, angle);
		initCannonLocs();
	}
	private void initCannonLocs() {
		numberOfCannons = CANNON_MAX_NUMBER;
		for(int i = 0; i < numberOfCannons; i++){
			cannonXLocs[i] = CANNON_DEFAULT_XLOCS[i];
		}
		for(int i = 0; i < numberOfCannons; i++){
			cannonYLocs[i] = CANNON_DEFAULT_YLOCS[i];
		}
	}
	@Override
	public void draw(){
		drawPlayer();
	}
	private void drawPlayer() {
		glPushMatrix();
		glTranslatef(getX() + (float)PWIDTH/2,getY() + (float)PHEIGHT/2 ,0);
		
		glRotatef(getAngle(),0,0,1);
		
		glTranslatef(-((float)PWIDTH/2), -((float)PHEIGHT/2), 0);
		glBegin(GL_TRIANGLES);
			
			glVertex2f(0, 0);
			glVertex2f((float)PWIDTH/2, PHEIGHT);
			glVertex2f(PWIDTH, 0);
			
		glEnd();
		glPopMatrix();
	}
	public void update(){
		moveVert();
	}
	
	public void fire(){
		for(int i = 0; i < numberOfCannons; i++){
			
		}
	}
}
