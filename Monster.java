// package thequest;

enum MonsterType {
	Dragon, Exoskeleton, Spirit
}

public class Monster extends Fighter {

	/* monster member variables */
	protected MonsterType type;
	protected int damage;
	protected int defense;
	protected double dodge;
	
	/* constructor for monster */
	public Monster(String name, MonsterType type, int level, int damage, int defense, double dodge) {
		this.name = name;
		this.level = level;
		this.hp = 100 * level;
		
		this.type = type;
		this.level = level;
		this.damage = damage;
		this.defense = defense;
		this.dodge = dodge;
	}
	
	/* make a copy of an existing monster */
	public static Monster copy(Monster monster) {
		return new Monster(monster.name, monster.type, monster.level, monster.damage, monster.defense, monster.dodge);
	}
	
}
