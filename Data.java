// package thequest;

public class Data {
	/* hold references to heroes, items, spells */
	
	public Hero[] warriors;
	public Hero[] paladins;
	public Hero[] sorcerers;
	public Weapon[] weaponry;
	public Armor[] armory;
	public Potion[] potions;
	public Spell[] fire;
	public Spell[] ice;
	public Spell[] lightning;
	public Monster[] dragons;
	public Monster[] exoskeletons;
	public Monster[] spirits;
	
	public Data() {
		
		/* heroes - warriors */
		warriors = new Hero[4];
		warriors[0] = new Hero("Gaerdal Ironhand", HeroType.Warrior, 100, 700, 500, 600, 1354, 7);
		warriors[1] = new Hero("Sehanine Moonbow", HeroType.Warrior, 600, 700, 800, 500, 2500, 8);
		warriors[2] = new Hero("Muamman Duathall", HeroType.Warrior, 300, 900, 500, 750, 2546, 6);
		warriors[3] = new Hero("Flandal Steelskin", HeroType.Warrior, 200, 750, 650, 700, 2500, 7);
	
		/* heroes - paladins */
		paladins = new Hero[4];
		paladins[0] = new Hero("Solonor Thelandira", HeroType.Paladin, 300, 750, 650, 700, 2500, 7);
		paladins[1] = new Hero("Sehanine Moonbow", HeroType.Paladin, 300, 750, 700, 700, 2500, 7);
		paladins[2] = new Hero("Skoraeus Stonebones", HeroType.Paladin, 250, 650, 600, 350, 2500, 4);
		paladins[3] = new Hero("Garl Glittergold", HeroType.Paladin, 100, 600, 500, 400, 2500, 5);
	
		/* heroes - sorcerers */
		sorcerers = new Hero[4];
		sorcerers[0] = new Hero("Garl Glittergold", HeroType.Sorcerer, 700, 550, 600, 500, 2500, 7);
		sorcerers[1] = new Hero("Rillifane Rallathil", HeroType.Sorcerer, 1300, 750, 450, 500, 2500, 9);
		sorcerers[2] = new Hero("Segojan Earthcaller", HeroType.Sorcerer, 900, 800, 500, 650, 2500, 5);
		sorcerers[3] = new Hero("Skoraeus Stonebones", HeroType.Sorcerer, 800, 850, 600, 450, 2500, 6);	
	
		/* items - weaponry */
		weaponry = new Weapon[7];
		weaponry[0] = new Weapon("Dagger", 200, 1, 250);
		weaponry[1] = new Weapon("Sword", 500, 1, 800);
		weaponry[2] = new Weapon("Shield", 400, 1, 100);
		weaponry[3] = new Weapon("Bow", 300, 2, 500);
		weaponry[4] = new Weapon("Axe", 550, 5, 850);
		weaponry[5] = new Weapon("Scythe", 1000, 6, 1100);
		weaponry[6] = new Weapon("TSwords", 1400, 8, 1600);
		
		/* items - armory */
		armory = new Armor[5];
		armory[0] = new Armor("Platinum Shield", 150, 1, 200);
		armory[1] = new Armor("Breastplate", 350, 3, 600);
		armory[2] = new Armor("Speed Boots", 550, 4, 600);
		armory[3] = new Armor("Full Body Armor", 1000, 8, 1100);
		armory[4] = new Armor("Wizard Shield", 1200, 10, 1500);
		
		/* items - potions */
		potions = new Potion[6];
		potions[0] = new Potion("Healing Potion", 250, 1, Attribute.HP, 100);
		potions[1] = new Potion("Strength Potion", 200, 1, Attribute.STR, 100);
		potions[2] = new Potion("Magic Potion", 350, 2, Attribute.MANA, 100);
		potions[3] = new Potion("Luck Elixir", 500, 4, Attribute.AGL, 65);
		potions[4] = new Potion("Mermaid Tears", 850, 5, Attribute.DEX, 100);
		potions[5] = new Potion("Ambrosia", 1000, 8, Attribute.AMB, 150);
		
		/* spells - fire */
		fire = new Spell[4];
		fire[0] = new Spell("Breath of Fire", 350, 1, SpellType.Fire, 450, 100);
		fire[1] = new Spell("Heat Wave", 450, 2, SpellType.Fire, 600, 150);
		fire[2] = new Spell("Flame Tornado", 700, 4, SpellType.Fire, 850, 300);
		fire[3] = new Spell("Lava Comet", 800, 7, SpellType.Fire, 1000, 550);
		
		/* spells - ice */
		ice = new Spell[4];
		ice[0] = new Spell("Ice Blade", 250, 1, SpellType.Ice, 450, 100);
		ice[1] = new Spell("Snow Cannon", 500, 2, SpellType.Ice, 650, 250);
		ice[2] = new Spell("Frost Blizzard", 750, 5, SpellType.Ice, 850, 350);
		ice[3] = new Spell("Arctic Storm", 700, 6, SpellType.Ice, 800, 300);
		
		/* spells - lightning */
		lightning = new Spell[4];
		lightning[0] = new Spell("Lightning Dagger", 400, 1, SpellType.Lightning, 500, 150);
		lightning[1] = new Spell("Spark Needles", 500, 2, SpellType.Lightning, 600, 200);
		lightning[2] = new Spell("Thunder Blast", 750, 4, SpellType.Lightning, 950, 400);
		lightning[3] = new Spell("Electric Arrows", 550, 5, SpellType.Lightning, 650, 200);
		
		/* monsters - dragons */
		dragons = new Monster[10];
		dragons[0] = new Monster("Natsunomeryu", MonsterType.Dragon, 1, 10, 200, 0.01);
		dragons[1] = new Monster("Chrysophylax", MonsterType.Dragon, 2, 20, 500, 0.02);
		dragons[2] = new Monster("Desghidorrah", MonsterType.Dragon, 3, 30, 400, 0.035);
		dragons[3] = new Monster("BunsenBurner", MonsterType.Dragon, 4, 40, 500, 0.045);
		dragons[4] = new Monster("Kas-Ethelinh", MonsterType.Dragon, 5, 60, 500, 0.06);
		dragons[5] = new Monster("Phaarthurnax", MonsterType.Dragon, 6, 60, 700, 0.06);
		dragons[6] = new Monster("The Scaleless", MonsterType.Dragon, 7, 70, 600, 0.075);
		dragons[7] = new Monster("The Weatherbe", MonsterType.Dragon, 8, 80, 900, 0.08);
		dragons[8] = new Monster("D-Maleficent", MonsterType.Dragon, 9, 90, 950, 0.085);
		dragons[9] = new Monster("Alexstraszan", MonsterType.Dragon, 10, 100, 9000, 0.055);
		
		/* monsters - exoskeletons */
		exoskeletons = new Monster[10];
		exoskeletons[0] = new Monster("Big Bad Wolf", MonsterType.Exoskeleton, 1, 15, 250, 0.015);
		exoskeletons[1] = new Monster("Wicked Witch", MonsterType.Exoskeleton, 2, 25, 350, 0.025);
		exoskeletons[2] = new Monster("Brandobaris", MonsterType.Exoskeleton, 3, 35, 450, 0.030);
		exoskeletons[3] = new Monster("Aasterinian", MonsterType.Exoskeleton, 4, 40, 500, 0.045);
		exoskeletons[4] = new Monster("St-Shargaas", MonsterType.Exoskeleton, 5, 55, 650, 0.055);
		exoskeletons[5] = new Monster("Chronepsish", MonsterType.Exoskeleton, 6, 65, 750, 0.06);
		exoskeletons[6] = new Monster("Cyrrollalee", MonsterType.Exoskeleton, 7, 70, 800, 0.075);
		exoskeletons[7] = new Monster("Kiaransalee", MonsterType.Exoskeleton, 8, 85, 950, 0.085);
		exoskeletons[8] = new Monster("St-Yeenoghu", MonsterType.Exoskeleton, 9, 95, 850, 0.090);
		exoskeletons[9] = new Monster("Merrushaullk", MonsterType.Exoskeleton, 10, 100, 900, 0.055);
		
		/* monsters - spirits */
		spirits = new Monster[10];
		spirits[0] = new Monster("Aim-Haborym", MonsterType.Spirit, 1, 45, 350, 0.035);
		spirits[1] = new Monster("Andrealphus", MonsterType.Spirit, 2, 60, 500, 0.04);
		spirits[2] = new Monster("Andromalius", MonsterType.Spirit, 3, 55, 450, 0.025);
		spirits[3] = new Monster("Chiang-shih", MonsterType.Spirit, 4, 70, 600, 0.04);
		spirits[4] = new Monster("Fallen Angel", MonsterType.Spirit, 5, 80, 700, 0.05);
		spirits[5] = new Monster("Ereshkigall", MonsterType.Spirit, 6, 95, 450, 0.035);
		spirits[6] = new Monster("Melchiresas", MonsterType.Spirit, 7, 35, 150, 0.075);
		spirits[7] = new Monster("Jormunngand", MonsterType.Spirit, 8, 60, 900, 0.02);
		spirits[8] = new Monster("Rakkshasass", MonsterType.Spirit, 9, 55, 600, 0.035);
		spirits[9] = new Monster("Taltecuhtli", MonsterType.Spirit, 10, 30, 200, 0.05);
		
	}
	
	
}
