// package thequest;

enum SpellType {
	Ice, Fire, Lightning
}

public class Spell extends Item {
	
	/* spell member variables */
	protected SpellType element;
	protected int damage;
	protected int mana_cost;

	/* constructor for spell */
	public Spell(String name, int price, int level, SpellType type, int damage, int mana_cost) {
		super(name, price, level);
		this.attribute = Attribute.ATK;
		this.type = ItemType.Spell;
		this.element = type;
		this.damage = damage;
		this.mana_cost = mana_cost;
	}
	
}