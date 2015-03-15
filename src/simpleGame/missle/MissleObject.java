package simpleGame.missle;

public abstract class MissleObject {
	private float x, y, angle;
	private int missleType;
	public MissleObject(float x, float y, float angle, int missleType) {
		this.x = x;
		this.y = y;
		this.angle = angle;
		this.missleType = missleType;
	}
	public abstract void draw();
	public abstract void uodate();
}
