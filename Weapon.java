// package thequest;

public class Weapon extends Item {
	
	/* constructor for weapon */
	public Weapon(String name, int price, int level, int increase) {
		super(name, price, level);
		this.attribute = Attribute.ATK;
		this.type = ItemType.Weapon;
		this.increase = increase;
	}
	
}
