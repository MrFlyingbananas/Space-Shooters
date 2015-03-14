package simpleGame.player;

import static simpleGame.settings.WindowSettings.*;
import static simpleGame.settings.PlayerSettings.*;
public abstract class PlayerObject {
	private float x, y, angle, speed;
	
	public PlayerObject(float x, float y, float baseAngle){
		this.x = x;
		this.y = y;
		this.angle = baseAngle;
		speed = 0;
	}
	
	protected float getX(){
		return x;
	}
	
	protected float getY(){
		return y;
	}
	
	protected float getAngle(){
		return angle;
	}
	
	public void moveVert(){
		float xInc = (float) Math.sin(Math.toRadians(angle))*speed;
		float yInc = -((float) Math.cos(Math.toRadians(angle))*speed);
		if(x + xInc + PWIDTH/2> WIDTH){
			x = WIDTH - PWIDTH/2;
		}else if(x + xInc - PWIDTH/2< 0){
			x = 0 + PWIDTH/2 ;
		}else{
			x+=xInc;
		}
		
		if(y + yInc + PHEIGHT/2> HEIGHT){
			y = HEIGHT - PHEIGHT/2;
		}else if(y + yInc - PWIDTH/2< 0){
			y = 0+ PHEIGHT/2;
		}else{
			y+=yInc;
		}
	}
	protected void dash(int dir){

		float xInc = (float) Math.sin(angle)*speed;
		float yInc = (float) Math.cos(angle)*speed;
		
		if(x + xInc > WIDTH){
			x = WIDTH;
		}else if(x + xInc < 0){
			x = 0;
		}else{
			x+=xInc;
		}
		
		if(y + yInc > HEIGHT){
			y = HEIGHT;
		}else if(y + yInc < 0){
			y = 0;
		}else{
			y+=yInc;
		}
	}
	
	public void rotate(float f){
		if(angle + f < 0){
			angle = (angle + f) + 360;
		}else if(angle + f > 360){
			angle = angle + f - 360;
		}else{
			angle+=f;
		}
	}
	public abstract void draw();

	public void changeSpeed(float delta) {
		if(delta >= SPEED_INC_DELTA_MAX){
			delta = SPEED_INC_DELTA_MAX;
		}else if(delta <= SPEED_DEC_DELTA_MAX){
			delta = SPEED_DEC_DELTA_MAX;
		}
		if(speed + delta > SPEED_MAX){
			speed = SPEED_MAX;
		}else if(speed + delta < SPEED_DEC_MAX){
			speed = SPEED_DEC_MAX;
		}else{
			speed+= delta;
		}
		
	}

	public float getSpeed() {
		return speed;
	}
	
}
