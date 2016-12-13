package simpleGame.cannon;

import org.lwjgl.Sys;

import simpleGame.settings.CannonSettings;
import simpleGame.util.NUtil;

public abstract class CannonObject {
	private float xOffset, yOffset, angle, xPos, yPos;
	private int cannonType;
	protected boolean isReloading;
	private boolean isDisabled;
	private long timeSinceLastReload = CannonSettings.CANNON_RELOADTIME_IN_MILLI;
	public CannonObject(float xOffsetOnShipFromCenter, float yOffsetOnShip, float baseAngle, int cannonType, boolean isReloading, boolean isDisabled) {
		this.xOffset = xOffsetOnShipFromCenter;
		this.yOffset = yOffsetOnShip;
		this.angle = baseAngle;
		this.cannonType = cannonType;
		this.isDisabled = isDisabled;
		this.cannonType = cannonType;
		this.isReloading = isReloading;
	}
	public abstract void draw();
	public abstract void fire();
	
	public void update(float shipX, float shipY, float shipAngle){
		if(NUtil.getTime() - timeSinceLastReload >= CannonSettings.CANNON_RELOADTIME_IN_MILLI){
			isReloading = false;
		}
		this.angle = shipAngle;
		this.xPos = shipX+xOffset;
		this.yPos = shipY+yOffset;
	}
	protected float getX() {
		return xPos;
	}
	protected float getY(){
		return yPos;
	}
	protected float getAngle() {
		return angle;
	}
	protected float getYOffset() {
		return yOffset;
	}

	protected float getXOffset() {
		return xOffset;
	}
	protected boolean isReloading(){
		return isReloading;
	}
	protected void reload(){
		isReloading = true;
		timeSinceLastReload = NUtil.getTime();
		
	}

}
