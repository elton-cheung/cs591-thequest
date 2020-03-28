// package thequest;

public class Armor extends Item {
	
	/* constructor for armor */
	public Armor(String name, int price, int level, int increase) {
		super(name, price, level);
		this.attribute = Attribute.DEF;
		this.type = ItemType.Armor;
		this.increase = increase;
	}
	
}
