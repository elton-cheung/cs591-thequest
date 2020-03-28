// package thequest;

enum Attribute {
	ATK, DEF, HP, STR, MANA, AGL, DEX, AMB
}

enum ItemType {
	Weapon, Armor, Potion, Spell
}

public abstract class Item {

	/* item member variables - general */
	protected String name;
	protected int price;
	protected int level;
	
	/* item member variables - specific */
	protected Attribute attribute;
	protected ItemType type;
	protected int increase;
	
	/* constructor for item */
	public Item(String name, int price, int level) {
		this.name = name;
		this.price = price;
		this.level = level;
	}
	
	/* mapping from attribute to string for printing */
	public String attributeToString() {
		switch (this.attribute) {
			case ATK:
				return "ATK";
			case DEF:
				return "DEF";
			case HP:
				return "HP";
			case STR:
				return "STR";
			case MANA:
				return "MANA";
			case AGL:
				return "AGL";
			case DEX:
				return "DEX";
			case AMB:
				return "AMB";
			default:
				return "";
		}
	}
	
}
