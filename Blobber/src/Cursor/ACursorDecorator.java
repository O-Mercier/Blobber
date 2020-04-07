package Cursor;

public abstract class ACursorDecorator implements ICursor{
	protected int damage;
	protected ICursor c;
	
	public ACursorDecorator(int damage) {
		this.damage = damage;
	}
	
	public void decorate(ICursor c) {
		this.c = c;
	}
	
	@Override
	public int getDamage() {
		return Math.max(damage + c.getDamage(), 1);
	}
}
