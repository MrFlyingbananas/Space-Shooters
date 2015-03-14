package simpleGame.cannon;

public abstract class CannonObject {
	private float xOffset, yOffset, angle, xPos, yPos;
	private int cannonType;
	private boolean isDisabled;
	public CannonObject(float xOffsetOnShipFromCenter, float yOffsetOnShip, float baseAngle, int cannonType, boolean isDisabled) {
		this.xOffset = xOffsetOnShipFromCenter;
		this.yOffset = yOffsetOnShip;
		this.angle = baseAngle;
		this.cannonType = cannonType;
		this.isDisabled = isDisabled;
		this.cannonType = cannonType;
	}
	public abstract void draw();
	
	public void updatePos(float shipX, float shipY, float shipAngle){
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
}
