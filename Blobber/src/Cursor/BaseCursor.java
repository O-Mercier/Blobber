package Cursor;

public class BaseCursor  implements ICursor{
	private int damage;
	
	
	public BaseCursor() {
		damage = 1;
	}
	
	@Override
	public int getDamage() {
		return damage;
	}
}
