// package thequest;

public class Potion extends Item {

	/* constructor for potion */
	public Potion(String name, int price, int level, Attribute attribute, int increase) {
		super(name, price, level);
		this.attribute = attribute;
		this.type = ItemType.Potion;
		this.increase = increase;
	}
	
}
