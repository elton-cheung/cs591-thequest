// package thequest;

import java.util.ArrayList;

enum HeroType {
	Warrior, Sorcerer, Paladin
}

public class Hero extends Fighter {
	
	
	/* hero member variables - attributes */
	protected int mana;
	protected HeroType type;
	protected int experience;
	protected int gold;
	
	/* hero member variables - items */
	protected Weapon weapon;
	protected Armor armor;
	protected ArrayList<Item> inventory;
	protected ArrayList<Spell> spells;
	
	
	/* hero member variables - skills */
	protected int strength;  // affects weapon damage dealt
	protected int agility;   // affects dodge chance
	protected int dexterity; // affects spell damage dealt
	
	/* constructor for hero */
	public Hero(String name, HeroType type, int mana, int strength, int agility, int dexterity, int gold, int experience) {
		this.name = name;
		this.hp = 100;
		this.level = 1;
		
		this.mana = mana;
		this.type = type;
		this.experience = experience;
		this.gold = gold;
		
		this.weapon = null;
		this.armor = null;
		this.inventory = new ArrayList<Item>();
		this.spells = new ArrayList<Spell>();
		
		this.strength = strength;
		this.agility = agility;
		this.dexterity = dexterity;
		
	}
	
	public boolean equip(Item item) {
		if (item.type == ItemType.Armor) {
			return this.equipArmor((Armor)item);
		} else if (item.type == ItemType.Weapon) {
			return this.equipWeapon((Weapon)item);
		} else if (item.type == ItemType.Potion) {
			return this.consumePotion((Potion)item);
		}
		
		return false;
	}
	
	/* try equipping weapon */
	public boolean equipWeapon(Weapon weapon) {
		if (weapon.level > this.level) {
			System.out.println("This item cannot be equipped.");
			return false;
		}
		
		/* swap out equip to inventory */
		if (this.weapon != null) {
			this.inventory.add(this.weapon);
		}
		this.weapon = weapon;
		this.inventory.remove(weapon);
		System.out.println(this.name + " equipped " + weapon.name + ".");
		return true;
	}
	
	/* try equipping armor */
	public boolean equipArmor(Armor armor) {
		if (armor.level > this.level) {
			System.out.println("This item cannot be equipped.");
			return false;
		}
		
		/* swap out equip to inventory */
		if (this.armor != null) {
			this.inventory.add(this.armor);
		}
		this.armor = armor;
		this.inventory.remove(armor);
		System.out.println(this.name + " equipped " + armor.name + ".");
		return true;
	}
	
	/* try consuming potion */
	public boolean consumePotion(Potion potion) {
		if (potion.level > this.level) {
			System.out.println("This potion cannot be consumed.");
			return false;
		}
		
		if (potion.attribute == Attribute.HP) {
			this.hp += potion.increase;
		} else if (potion.attribute == Attribute.STR) {
			this.strength += potion.increase;
		} else if (potion.attribute == Attribute.MANA) {
			this.mana += potion.increase;
		} else if (potion.attribute == Attribute.AGL) {
			this.agility += potion.increase;
		} else if (potion.attribute == Attribute.DEX) {
			this.dexterity += potion.increase;
		} else if (potion.attribute == Attribute.AMB) {
			this.hp += potion.increase;
			this.mana += potion.increase;
			this.strength += potion.increase;
			this.dexterity += potion.increase;
		}

		this.inventory.remove(potion);
		System.out.println(this.name + " drank " + potion.name + ".");
		return true;
	}
	
	/* try purchasing item - if purchased, spend gold and add item to inventory */
	public boolean buy(Item item) {
		
		System.out.println("You'd like to buy " + item.name + ", yes?");
		if (item.price > this.gold) {
			System.out.println("You don't have enough gold! Out of the market!\n");
			return false;
		}
		
		this.gold -= item.price;
		if (item.type == ItemType.Spell) {
			this.spells.add((Spell)item);
			for (int i = 0; i < spells.size(); i++) {
			}
		} else {
			this.inventory.add(item);
			for (int i = 0; i < inventory.size(); i++) {
			}
		}
		System.out.println("You spent " + item.price + " on " + item.name + ". Thank you for the business!\n");
		return true;
	}
	
	/* sell an item - remove from inventory and regain half of cost in gold */
	public void sell(Item item) {
		
		System.out.println("Selling the " + item.name + "? Ok, I'll give you " + (item.price / 2) + " gold!");
		this.gold += item.price / 2;
		this.inventory.remove(item);
		System.out.println("You now have " + this.gold + ". Thank you for the business!");
	}
	
	/* restoring 5% of health and 10% of mana after a round of fight */
	public void restore() {
		this.hp += 5 * level;
		this.mana += 10 * level;
	}
	
	/* hero gains experience */
	public boolean gainExperience(int exp) {
		this.experience += exp;
		System.out.println(this.name + " gained " + exp + " experience. " + (Math.max(0, this.level * 10 - this.experience)) + " left till level " + (level + 1) + ".");
		
		if (this.experience >= this.level * 10) {
			this.levelUp();
			return true;
		}
		return false;
	}
	
	/* hero levels up */
	public void levelUp() {
		this.level += 1;
		this.experience = 0;
		this.hp += 100;
		this.mana *= 1.1;
		
		if (this.type == HeroType.Warrior) {
			this.strength *= 1.1;
			this.agility *= 1.1;
			this.dexterity *= 1.05;
		} else if (this.type == HeroType.Sorcerer) {
			this.strength *= 1.05;
			this.agility *= 1.1;
			this.dexterity *= 1.1;
		} else if (this.type == HeroType.Paladin) {
			this.strength *= 1.1;
			this.agility *= 1.05;
			this.dexterity *= 1.1;
		}
		System.out.println(this.name + " has reached level " + this.level);
	}
	
}
