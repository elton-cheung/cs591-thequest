// package thequest;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
	/* entry point for application - manages the game */

	protected static final int DIM = 8;
	
	protected int party_size;
	protected Hero[] party;
	protected Tile[][] board;
	protected int pos_i; // current row
	protected int pos_j; // current col
	protected boolean q; // to end game
	
	protected Scanner sc; // singleton instance
	
	protected Data data; // reference to instances of heroes/items/spells
	
	public Client() {
		sc = new Scanner(System.in);
		data = new Data();
		q = false;
	}
	
	/* helper function to add party member to party */
	public void addPartyMember(int index) {
		
		/* user picks warrior, paladin, or sorcerer */
		System.out.println("Enter [w/p/s] to select a warrior, paladin, or sorcerer.");
		while (!sc.hasNext("[(\bw\b|\bp\b|\bs\b)]")) {
			System.out.println("Enter [w/p/s] to select a warrior, paladin, or sorcerer.");
			sc.next();
		}
		
		/* user picks hero from selected class */ 
		String classChoice = sc.next();
		if (classChoice.equals("w")) {
			System.out.format("+---+-WARRIOR-----------+-MANA-+-STR-+-AGL-+-DEX-+-GOLD-+-EXP-+%n");
			System.out.format("| 1 | Gaerdal Ironhand  | 100  | 700 | 500 | 600 | 1354 | 7   |%n");
			System.out.format("| 2 | Sehanine Moonbow  | 600  | 700 | 800 | 500 | 2500 | 8   |%n");
			System.out.format("| 3 | Muamman Duathall  | 300  | 900 | 500 | 750 | 2546 | 6   |%n");
			System.out.format("| 4 | Flandal Steelskin | 200  | 750 | 650 | 700 | 2500 | 7   |%n");
			System.out.println("Enter [1/2/3/4] to select a hero.");
			
			while (!sc.hasNext("[(\b1\b|\b2\b|\b3\b|\b4\b)]")) {
				System.out.println("Enter [1/2/3/4] to select a hero.");
				sc.next();
			}
			
			/* if hero is already in party, try again */
			int heroChoice = sc.nextInt() - 1;
			Hero hero = data.warriors[heroChoice];
			for (Hero partyMember : party) {
				if (hero == partyMember) {
					System.out.println("This hero is already in your party. Try again.");
					this.addPartyMember(index);
					return;
				}
			}
			
			/* add hero to party */
			party[index] = hero;
			
		} else if (classChoice.equals("p")) {
			System.out.format("+---+-PALADIN-------------+-MANA-+-STR-+-AGL-+-DEX-+-GOLD-+-EXP-+%n");
			System.out.format("| 1 | Solonor Thelandira  | 300  | 750 | 650 | 700 | 2500 | 7   |%n");
			System.out.format("| 2 | Sehanine Moonbow    | 300  | 750 | 700 | 700 | 2500 | 7   |%n");
			System.out.format("| 3 | Skoraeus Stonebones | 250  | 650 | 600 | 350 | 2500 | 4   |%n");
			System.out.format("| 4 | Garl Glittergold    | 100  | 600 | 500 | 400 | 2500 | 5   |%n");
			System.out.println("Enter [1/2/3/4] to select a hero.");
			
			while (!sc.hasNext("[(\b1\b|\b2\b|\b3\b|\b4\b)]")) {
				System.out.println("Enter [1/2/3/4] to select a hero.");
				sc.next();
			}
			
			/* if hero is already in party, try again */
			int heroChoice = sc.nextInt() - 1;
			Hero hero = data.paladins[heroChoice];
			for (Hero partyMember : party) {
				if (hero == partyMember) {
					System.out.println("This hero is already in your party. Try again.");
					this.addPartyMember(index);
					return;
				}
			}
			
			/* add hero to party */
			party[index] = hero;
		} else {
			System.out.format("+---+-SORCERER------------+-MANA-+-STR-+-AGL-+-DEX-+-GOLD-+-EXP-+%n");
			System.out.format("| 1 | Garl Glittergold    | 700  | 550 | 600 | 500 | 2500 | 7   |%n");
			System.out.format("| 2 | Rillifane Rallathil | 1300 | 750 | 450 | 500 | 2500 | 9   |%n");
			System.out.format("| 3 | Segojan Earthcaller | 900  | 800 | 500 | 650 | 2500 | 5   |%n");
			System.out.format("| 4 | Skoraeus Stonebones | 800  | 850 | 600 | 450 | 2500 | 6   |%n");
			System.out.println("Enter [1/2/3/4] to select a hero.");
			
			while (!sc.hasNext("[(\b1\b|\b2\b|\b3\b|\b4\b)]")) {
				System.out.println("Enter [1/2/3/4] to select a hero.");
				sc.next();
			}
			
			/* if hero is already in party, try again */
			int heroChoice = sc.nextInt() - 1;
			Hero hero = data.sorcerers[heroChoice];
			for (Hero partyMember : party) {
				if (hero == partyMember) {
					System.out.println("This hero is already in your party. Try again.");
					this.addPartyMember(index);
					return;
				}
			}
			
			/* add hero to party */
			party[index] = hero;
		}
	}
	
	/* allow the user to select party size and party members, and create board */
	public void initialize() {
		
		System.out.println("Enter [1/2/3] to select party size.");
		while (!sc.hasNext("[(\b1\b|\b2\b|\b3\b)]")) {
			System.out.println("Enter [1/2/3] to select party size.");
			sc.next();
		}
		
		/* user has entered correct party size, select party members */
		party_size = sc.nextInt();
		party = new Hero[party_size];
		for (int i = 0; i < party_size; i++) {
			this.addPartyMember(i);
		}
		
		/* print the party */
		System.out.print("PARTY -");
		for (int i = 0; i < party_size; i++) {
			System.out.print(" " + party[i].name + "  ");
		}
		System.out.print("\n");
		
		/* create an 8x8 grid */
		board = new Tile[DIM][DIM];
		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
				board[i][j] = new Tile();
			}
		}
		
		/* initialize the party on a random tile */
		pos_i = (int) Math.floor(Math.random() * 8);
		pos_j = (int) Math.floor(Math.random() * 8);
		board[pos_i][pos_j].setOccupied();
		
	}
	
	/* print the board */
	public void printBoard() {
		
		/* print top border */
		for (int i = 0; i < DIM; i++) {
			System.out.print("+---");
		}
		System.out.print("+\n");
		
		/* print row of tiles and then border */
		for (int i = 0; i < DIM; i++) {
			for (int j = 0; j < DIM; j++) {
				System.out.print("+");
				if (board[i][j].getOccupied()) {
					System.out.print("***");
				} else if (board[i][j].getType() == TileType.Non) {
					System.out.print(" X ");
				} else if (board[i][j].getType() == TileType.Market) {
					System.out.print(" $ ");
				} else { /* common tile */
					System.out.print("   ");
				}
			}
			System.out.print("+\n");
			for (int k = 0; k < DIM; k++) {
				System.out.print("+---");
			}
			System.out.print("+\n");
		}
		
	}
	
	/* allow the user to make a move, triggering relevant tile */
	public void move() {
		
		/* wait for user input */
		System.out.println("Enter [w/a/s/d] to move up/left/down/right. Enter [i] to view party info. Enter [q] to quit.");
		while (!sc.hasNext("[(\bw\b|\ba\b|\bs\b|\bd\b|\bi\b|\bq\b)]")) {
			System.out.println("Enter [w/a/s/d] to move up/left/down/right. Enter [i] to view party info. Enter [q] to quit.");
			sc.next();
		}
		String input = sc.next();
		
		if (input.equals("i")) {
			this.printInfo();
		} else if (input.equals("w")) {
			this.moveUp();
		} else if (input.equals("a")) {
			this.moveLeft();
		} else if (input.equals("s")) {
			this.moveDown();
		} else if (input.equals("d")){
			this.moveRight();
		} else { // quit
			this.quit();
		}
	}
	
	/* player wants to end the game */
	public void quit() {
		this.q = true;
		for (Hero hero : party) {
			System.out.println(hero.name + " reached level " + hero.level + ".");
		}
		System.out.println("Thanks for playing!");
	}
	
	/* try moving the player up */
	public boolean moveUp() {
		int new_i = pos_i - 1;
		if (new_i < 0 || board[new_i][pos_j].type == TileType.Non) {
			System.out.println("You cannot move up...\n");
			return false;
		}
		
		board[pos_i][pos_j].setOccupied();
		pos_i = new_i;
		board[pos_i][pos_j].setOccupied();
		this.triggerTile();
		return true;
	}
	
	/* try moving the player left */
	public boolean moveLeft() {
		int new_j = pos_j - 1;
		if (new_j < 0 || board[pos_i][new_j].type == TileType.Non) {
			System.out.println("You cannot move left...\n");
			return false;
		}
		
		board[pos_i][pos_j].setOccupied();
		pos_j = new_j;
		board[pos_i][pos_j].setOccupied();
		this.triggerTile();
		return true;
	}
	
	/* try moving the player down */
	public boolean moveDown() {
		int new_i = pos_i + 1;
		if (new_i >= DIM || board[new_i][pos_j].type == TileType.Non) {
			System.out.println("You cannot move down...\n");
			return false;
		}
		
		board[pos_i][pos_j].setOccupied();
		pos_i = new_i;
		board[pos_i][pos_j].setOccupied();
		this.triggerTile();
		return true;
	}
	
	/* try moving the player right */
	public boolean moveRight() {
		int new_j = pos_j + 1;
		if (new_j >= DIM || board[pos_i][new_j].type == TileType.Non) {
			System.out.println("You cannot move right...\n");
			return false;
		}
		
		board[pos_i][pos_j].setOccupied();
		pos_j = new_j;
		board[pos_i][pos_j].setOccupied();
		this.triggerTile();
		return true;
	}
	
	/* trigger the action on a new tile */
	public void triggerTile() {
		if (board[pos_i][pos_j].type == TileType.Market) {
			this.market();
		} else if (board[pos_i][pos_j].type == TileType.Common) {
			double monster_chance = Math.random();
			if (monster_chance < board[pos_i][pos_j].chance) {
				this.fight();
			}
		}
	}
	
	/* enter a market menu, redirecting to other markets */
	public void market() {
		
		/* select a hero to shop */
		String leftAlignFormat = "| %-1d | %-20s | %4d |%n";
		System.out.println("MARKET - WELCOME!");
		System.out.format("+---+-HERO-----------------+-GOLD-+%n");
		for (int i = 0; i < party_size; i++) {
			System.out.format(leftAlignFormat, i + 1, party[i].name, party[i].gold);
		}
		System.out.println("Now, who is shopping today?");
		
		/* wait for user input */
		while (!sc.hasNext("[(\b1\b|\b2\b|\b3\b)]")) {
			System.out.println("I didn't understand that...enter [1/2/3] to identify a hero!");
			sc.next();
		}
		
		int heroChoice = sc.nextInt() - 1;
		if (heroChoice > party_size - 1) {
			System.out.println("This hero doesn't exist...get out of my shop!");
			return;
		}
		
		Hero hero = party[heroChoice];
		System.out.println("Ah, " + hero.name + " is shopping. I see you have " + hero.gold + " gold to spend!");	
		
		/* select what type of item to purchase */
		leftAlignFormat = "| %-1d | %-8s |%n";
		System.out.format("+---+-MARKET---+%n");
		System.out.format(leftAlignFormat, 1, "Weaponry");
		System.out.format(leftAlignFormat, 2, "Armory");
		System.out.format(leftAlignFormat, 3, "Potions");
		System.out.format(leftAlignFormat, 4, "Spells");
		System.out.format(leftAlignFormat, 5, "Sell");
		System.out.println("Enter the number on the left-hand column to view those goods. Enter anything else to return to the map.");
		
		if (!sc.hasNext("[(\b1\b|\b2\b|\b3\b|\b4\b|\b5\b)]")) {
			System.out.println("Back to the map...\n");
			sc.next();
			return;
		}
		
		int marketChoice = sc.nextInt();
		if (marketChoice == 1) {
			this.marketWeaponry(hero);
		} else if (marketChoice == 2) {
			this.marketArmory(hero);
		} else if (marketChoice == 3) {
			this.marketPotions(hero);
		} else if (marketChoice == 4) {
			this.marketSpells(hero);
		} else {
			this.sell(hero);
		}
		
	}
	
	/* market - weaponry */
	public void marketWeaponry(Hero hero) {
		String leftAlignFormat = "| %-1d | %-8s | %-3d | %-4d | %-4d |%n";
		System.out.format("+---+-WEAPONRY-+-LVL-+-DMG--+-COST-+%n");
		for (int i = 0; i < data.weaponry.length; i++) {
			Weapon weapon = data.weaponry[i];
			System.out.format(leftAlignFormat, i + 1, weapon.name, weapon.level, weapon.increase, weapon.price);
		}
		System.out.println("Ah, " + hero.name + " is shopping. I see you have " + hero.gold + " gold to spend!");	
		System.out.println("Enter the left-column number to purchase an item. Enter anything else to leave the market!");
		
		if (!sc.hasNext("[(\b1\b|\b2\b|\b3\b|\b4\b|\b5\b|\b6\b|\b7\b)]")) {
			System.out.println("Back to the map...\n");
			sc.next();
			return;
		}
		
		int itemChoice = sc.nextInt() - 1;
		hero.buy(data.weaponry[itemChoice]);
	}
	
	/* market - armory */
	public void marketArmory(Hero hero) {
		String leftAlignFormat = "| %-1d | %-15s | %-3d | %-4d | %-4d |%n";
		System.out.format("+---+-ARMORY----------+-LVL-+-DEF--+-COST-+%n");
		for (int i = 0; i < data.armory.length; i++) {
			Armor armor = data.armory[i];
			System.out.format(leftAlignFormat, i + 1, armor.name, armor.level, armor.increase, armor.price);
		}
		System.out.println("Ah, " + hero.name + " is shopping. I see you have " + hero.gold + " gold to spend!");	
		System.out.println("Enter the left-column number to purchase an item. Enter anything else to leave the market!");
		
		if (!sc.hasNext("[(\b1\b|\b2\b|\b3\b|\b4\b|\b5\b)]")) {
			System.out.println("Back to the map...\n");
			sc.next();
			return;
		}
		
		int itemChoice = sc.nextInt() - 1;
		hero.buy(data.armory[itemChoice]);
	}
	
	/* market - potions */
	public void marketPotions(Hero hero) {
		String leftAlignFormat = "| %-1d | %-15s | %-3d | %-9s | %-4d | %-4d |%n";
		System.out.format("+---+-POTIONS---------+-LVL-+-ATTRIBUTE-+-PTS--+-COST-+%n");
		for (int i = 0; i < data.potions.length; i++) {
			Potion potion = data.potions[i];
			System.out.format(leftAlignFormat, i + 1, potion.name, potion.level, potion.attributeToString(), potion.increase, potion.price);
		}
		System.out.println("Ah, " + hero.name + " is shopping. I see you have " + hero.gold + " gold to spend!");	
		System.out.println("Enter the left-column number to purchase an item. Enter anything else to leave the market!");
		
		if (!sc.hasNext("[(\b1\b|\b2\b|\b3\b|\b4\b|\b5\b|\b6\b)]")) {
			System.out.println("Back to the map...\n");
			sc.next();
			return;
		}
		
		int itemChoice = sc.nextInt() - 1;
		hero.buy(data.potions[itemChoice]);
	}
	
	/* market - spells, redirecting to fire, ice, lightning */
	public void marketSpells(Hero hero) {
		String leftAlignFormat = "| %-1d | %-10s |%n";
		System.out.format("+---+-POTION-----+%n");
		System.out.format(leftAlignFormat, 1, "Fire");
		System.out.format(leftAlignFormat, 2, "Ice");
		System.out.format(leftAlignFormat, 3, "Lightning");
		System.out.println("Enter the left-column number to select the type of spell you'd like to purchase. Enter anything else to leave the market!");
		
		if (!sc.hasNext("[(\b1\b|\b2\b|\b3\b)]")) {
			System.out.println("Back to the map...\n");
			sc.next();
			return;
		}
		
		int spellChoice = sc.nextInt();
		if (spellChoice == 1) {
			this.marketFire(hero);
		} else if (spellChoice == 2) {
			this.marketIce(hero);
		} else {
			this.marketLightning(hero);
		}
		
	}
	
	/* market - fire spells */
	public void marketFire(Hero hero) {
		System.out.println("Did you know fire spells reduce the defense level of the enemy?");
		String leftAlignFormat = "| %-1d | %-18s | %-3d | %-4d | %-4d | %-4d |%n";
		System.out.format("+---+-FIRE SPELL---------+-LVL-+-DMG--+-MANA-+-COST-+%n");
		for (int i = 0; i < data.fire.length; i++) {
			Spell spell = data.fire[i];
			System.out.format(leftAlignFormat, i + 1, spell.name, spell.level, spell.damage, spell.mana_cost, spell.price);
		}
		System.out.println("Ah, " + hero.name + " is shopping. I see you have " + hero.gold + " gold to spend!");	
		System.out.println("Enter the left-column number to purchase an item. Enter anything else to leave the market!");
		
		if (!sc.hasNext("[(\b1\b|\b2\b|\b3\b|\b4\b)]")) {
			System.out.println("Back to the map...\n");
			sc.next();
			return;
		}
		
		int itemChoice = sc.nextInt() - 1;
		hero.buy(data.fire[itemChoice]);
		
	}
	
	/* market - ice spells */
	public void marketIce(Hero hero) {
		System.out.println("Did you know ice spells reduce the damage range of the enemy?");
		String leftAlignFormat = "| %-1d | %-18s | %-3d | %-4d | %-4d | %-4d |%n";
		System.out.format("+---+-ICE SPELL----------+-LVL-+-DMG--+-MANA-+-COST-+%n");
		for (int i = 0; i < data.ice.length; i++) {
			Spell spell = data.ice[i];
			System.out.format(leftAlignFormat, i + 1, spell.name, spell.level, spell.damage, spell.mana_cost, spell.price);
		}
		System.out.println("Ah, " + hero.name + " is shopping. I see you have " + hero.gold + " gold to spend!");	
		System.out.println("Enter the left-column number to purchase an item. Enter anything else to leave the market!");
		
		if (!sc.hasNext("[(\b1\b|\b2\b|\b3\b|\b4\b)]")) {
			System.out.println("Back to the map...\n");
			sc.next();
			return;
		}
		
		int itemChoice = sc.nextInt() - 1;
		hero.buy(data.ice[itemChoice]);
	}
	
	/* market - lightning spells */
	public void marketLightning(Hero hero) {
		System.out.println("Did you know lightning spells reduce the dodge chance of the enemy?");
		String leftAlignFormat = "| %-1d | %-18s | %-3d | %-4d | %-4d | %-4d |%n";
		System.out.format("+---+-LIGHTNING SPELL----+-LVL-+-DMG--+-MANA-+-COST-+%n");
		for (int i = 0; i < data.lightning.length; i++) {
			Spell spell = data.lightning[i];
			System.out.format(leftAlignFormat, i + 1, spell.name, spell.level, spell.damage, spell.mana_cost, spell.price);
		}
		System.out.println("Ah, " + hero.name + " is shopping. I see you have " + hero.gold + " gold to spend!");	
		System.out.println("Enter the left-column number to purchase an item. Enter anything else to leave the market!");
		
		if (!sc.hasNext("[(\b1\b|\b2\b|\b3\b|\b4\b)]")) {
			System.out.println("Back to the map...\n");
			sc.next();
			return;
		}
		
		int itemChoice = sc.nextInt() - 1;
		hero.buy(data.lightning[itemChoice]);
	}
	
	/* sell items */
	public void sell(Hero hero) {
		
		/* print hero inventory */
		if (hero.inventory.isEmpty()) {
			System.out.println(hero.name + "'s inventory is empty. Back to the map...\n");
			return;
		}
		
		System.out.println(hero.name + " - INVENTORY");
		System.out.format("+----+-ITEM------------+-LVL-+-ATTRIBUTE-+-PTS--+-SELL-+%n");
		for (int i = 0; i < hero.inventory.size(); i++) {
			Item item = hero.inventory.get(i);
			System.out.format("| %-2d | %-15s | %-3d | %-9s | %-4d | %-4d |%n", i + 1, item.name, item.level, item.attributeToString(), item.increase, item.price / 2);
		}
		
		/* allow user to sell potion */
		System.out.println(" Enter the left-column number to sell the item. Enter anything else to go back to the map.");
		if (!sc.hasNextInt()) {
			System.out.println(" Back to the map...\n");
			sc.next();
			return;
		}
		
		int itemChoice = sc.nextInt() - 1;
		if (itemChoice > hero.inventory.size() - 1) {
			System.out.println("This item does not exist.\n");
			return;
		}
		
		Item item = hero.inventory.get(itemChoice);
		hero.sell(item);
	}
	
	/* fight monsters */
	public void fight() {
		System.out.println("Encountering danger...");
		
		/* create party of heroes and party of monsters */
		ArrayList<Hero> heroes = new ArrayList<Hero>();
		int maxHeroLevel = 0;
		for (Hero hero : party) {
			maxHeroLevel = Math.max(maxHeroLevel, hero.level);
			heroes.add(hero);
		}
		ArrayList<Monster> monsters = new ArrayList<Monster>();
		for (int i = 0; i < party_size; i++) {
			double chance = Math.random();
			if (chance < 0.33) {
				monsters.add(Monster.copy(data.dragons[maxHeroLevel - 1]));
			} else if (chance < 0.66) {
				monsters.add(Monster.copy(data.exoskeletons[maxHeroLevel - 1]));
			} else {
				monsters.add(Monster.copy(data.spirits[maxHeroLevel - 1]));
			}
		}
		
		/* main fight loop */
		while (this.stillAlive(heroes) && this.stillAlive(monsters)) {
			this.heroTurn(heroes, monsters);
			
			if (this.stillAlive(heroes) && this.stillAlive(monsters)) {
				this.monstersTurn(heroes, monsters);
			}
		}
		
		/* fight is over */
		this.fightIsOver(heroes);
		
	}
	
	/* fight is over - end phase */
	public void fightIsOver(ArrayList<Hero> heroes) {
		
		/* heroes win */
		if (this.stillAlive(heroes)) {
			System.out.println("\nCongratulations! The heroes killed the monsters.");
			
			for (Hero hero : heroes) {
				
				/* if hero is dead, revive at half hp but gain no exp */
				if (hero.hp <= 0) {
					hero.hp = hero.level * 50;
					System.out.println(hero.name + " was revived...");
				} else {
					/* hero is alive, gain exp/gold and level up */
					int rewards = 50 * hero.level;
					hero.gold += rewards;
					System.out.println(hero.name + " gained " + rewards + " gold.");
					hero.gainExperience(2 * hero.level);
					
				}
			}
			
		} else { /* monsters win - revive all the heroes but they lose gold */
			
			System.out.println("\nThe heroes were defeated...");
			
			for (Hero hero : heroes) {
				hero.hp = hero.level * 50;
				hero.gold /= 2;
			}
			
		}
	}
	
	/* helper function for fight - determine if there is a dead party */
	public <T extends Fighter> boolean stillAlive (ArrayList<T> fighters) {
		
		int deadFighters = 0;
		for (Fighter fighter : fighters) {
			if (fighter.hp <= 0) {
				deadFighters += 1;
			}
		}
		if (deadFighters == fighters.size()) {
			return false;
		}
		
		return true;
	
	}
	
	/* helper function for fight - user controls heroes turn */
	public void heroTurn(ArrayList<Hero> heroes, ArrayList<Monster> monsters) {
		
		/* print hero status and monster status */
		String leftAlignFormat = "| %-20s | %-4d | %-4d |%n";
		System.out.format("\n+-PARTY----------------+-HP---+-MANA-+%n");
		for (Hero hero : heroes) {
			System.out.format(leftAlignFormat, hero.name, hero.hp, hero.mana);
		}
		
		leftAlignFormat = "| %-20s | %-4d |%n";
		System.out.format("+-MONSTER--------------+-HP---+%n");
		for (Monster monster : monsters) {
			System.out.format(leftAlignFormat, monster.name, monster.hp);
		}
		
		/* allow living heroes to attack */
		for (Hero hero : heroes) {
			
			if (hero.hp <= 0) {
				continue;
			}
			
			if (!this.stillAlive(monsters)) {
				return;
			}
			
			hero.restore();
			System.out.println("\nIt's " + hero.name + "'s turn to attack!");
			leftAlignFormat = "| %-1d | %-10s |%n";
			System.out.format("+---+-ACTION-----+%n");
			System.out.format(leftAlignFormat, 1, "Attack");
			System.out.format(leftAlignFormat, 2, "Spell");
			System.out.format(leftAlignFormat, 3, "Potion");
			System.out.println("Enter the left-column number to select an action.");
			
			while (!sc.hasNext("[(\b1\b|\b2\b|\b3\b)]")) {
				System.out.println("Enter the left-column number to select an action.");
				sc.next();
			}
			int action = sc.nextInt();
			
			if (action == 1) {
				this.attack(hero, monsters, null);
			} else if (action == 2) {
				this.spell(hero, monsters);
			} else {
				this.potion(hero);
			}
			
		}
		
	}
	
	/* helper function for heroes turn - select monster for hero to attack */
	public void attack(Hero hero, ArrayList<Monster> monsters, Spell spell) {
		
		/* select a monster to attack */
		System.out.println(hero.name + ", choose a monster to attack!");
		String leftAlignFormat = "| %-1d | %-20s | %-4d |%n";
		System.out.format("+---+-MONSTER--------------+-HP---+%n");
		for (int i = 0; i < monsters.size(); i++) {
			Monster monster = monsters.get(i);
			System.out.format(leftAlignFormat, i + 1, monster.name, monster.hp);
		}
		System.out.println("Enter the left-column number to select a monster to attack.");
		
		while (!sc.hasNext("[(\b1\b|\b2\b|\b3\b)]")) {
			System.out.println("Enter the left-column number to select a monster to attack.");
			sc.next();
		}
		int monsterChoice = sc.nextInt() - 1;
		if (monsterChoice > monsters.size() - 1) {
			System.out.println("This monster does not exist...");
			return;
		}
		
		Monster monster = monsters.get(monsterChoice);
		
		/* if the monster is dead, skip */
		if (monster.hp <= 0) {
			System.out.println(monster.name + " is already dead...");
			return;
		}
		
		
		
		/* monster dodged */
		double chance = Math.random();
		if (chance < monster.dodge) {
			System.out.println(monster.name + " dodged the attack!");
		} else {
			/* attack landed */
			int damage;
			if (spell != null) {
				
				damage = spell.damage + (hero.dexterity / 10000) * spell.damage;

				/* spell debuffs */
				if (spell.element == SpellType.Ice) {
					monster.damage *= 0.9;
				} else if (spell.element == SpellType.Fire) {
					monster.defense *= 0.9;
				} else {
					monster.dodge *= 0.9;
				}
			} else { /* weapon attack <(strength + weapon damage) * 0.05> */
				damage = hero.strength;
				if (hero.weapon != null) {
					damage += hero.weapon.increase;
				}
				damage *= 0.05;
			}
			
			damage = (int)Math.floor(Math.max(0, damage - 0.05 * monster.defense));
			monster.hp -= damage;
			
			/* display damage dealt */
			if (monster.hp > 0) {
				System.out.println(hero.name + " dealt " + damage + " damage to " + monster.name + ".");
				System.out.println(monster.name + " has " + monster.hp + "HP left.");
			} else {
				monster.hp = 0;
				System.out.println(hero.name + " killed " + monster.name + "!");
			}

		}
		
	}

	/* helper function for heroes turn - select spell and then attack */
	public void spell(Hero hero, ArrayList<Monster> monsters) {
		
		/* if hero does not know any spells, skip */
		if (hero.spells.size() == 0) {
			System.out.println(hero.name + " doesn't know any spells...");
			return;
		}
		
		/* print spells */
		String leftAlignFormat = "| %-1d | %-20s | %-4d | %-4d |%n";
		System.out.format("+---+-SPELL----------------+-DMG--+-MANA-+%n");
		for (int i = 0; i < hero.spells.size(); i++) {
			Spell spell = hero.spells.get(i);
			System.out.format(leftAlignFormat, i + 1, spell.name, spell.damage, spell.mana_cost);
		}
		System.out.println("Enter the left-column number to select a spell.");
		
		/* select spell */
		while (!sc.hasNextInt()) {
			System.out.println("Enter the left-column number to select a spell.");
			sc.next();
		}
		int spellChoice = sc.nextInt() - 1;
		if (spellChoice > hero.spells.size() - 1) {
			System.out.println("This spell does not exist...");
			return;
		}
		
		Spell spell = hero.spells.get(spellChoice);
		if (spell.mana_cost > hero.mana) {
			System.out.println(hero.name + " tried to cast " + spell.name + " but didn't have enough mana!");
			return;
		}
		
		/* cast spell */
		hero.mana -= spell.mana_cost;
		System.out.println(hero.name + " is casting " + spell.name + "...");
		this.attack(hero, monsters, spell);
		
		
	}
	
	/* helper function for heroes turn - select potion to consume */
	public void potion(Hero hero) {
		
		/* make array of potions */
		ArrayList<Potion> potions = new ArrayList<Potion>();
		for (Item item : hero.inventory) {
			if (item.type == ItemType.Potion) {
				potions.add((Potion) item);                    
			}
		}
		
		/* if the hero has no potions, skip */
		if (potions.size() == 0) {
			System.out.println(hero.name + " has no potions...");
			return;
		}
		
		/* display potions */
		String leftAlignFormat = "| %-1d | %-20s | %-9s | %-3d | %-3d |%n";
		System.out.format("+---+-POTION---------------+-ATTRIBUTE-+-PTS-+-LVL-+%n");
		for (int i = 0; i < potions.size(); i++) {
			Potion potion = potions.get(i);
			System.out.format(leftAlignFormat, i + 1, potion.name, potion.attributeToString(), potion.increase, potion.level);
		}
		System.out.println("Enter the left-column number to select a potion to consume.");
		
		/* wait for user input */
		while (!sc.hasNextInt()) {
			System.out.println("Enter the left-column number to select a potion to consume.");
			sc.next();
		}
		int potionChoice = sc.nextInt() - 1;
		if (potionChoice > potions.size() - 1) {
			System.out.println("This potion does not exist...");
			return;
		}
		
		Potion potion = potions.get(potionChoice);
		hero.consumePotion(potion);
		
	}
	
	/* helper function for fight - monsters randomly attack heroes */
	public void monstersTurn(ArrayList<Hero> heroes, ArrayList<Monster> monsters) {
		
		System.out.println("\nMonsters turn to attack!");
		for (Monster monster : monsters) {
			
			/* if monster is dead, skip */
			if (monster.hp <= 0) {
				continue;
			}
			
			/* select one of the living heroes to randomly attack */
			ArrayList<Hero> living = new ArrayList<Hero>();
			for (Hero hero : heroes) {
				if (hero.hp > 0) {
					living.add(hero);
				}
			}
			if (living.size() == 0) {
				return;
			}
			
			Hero hero = living.get((int)Math.floor(Math.random() * living.size()));
			
			/* hero dodged */
			double chance = Math.random();
			if (chance < hero.agility * 0.0002) {
				System.out.println(hero.name + " dodged the attack!");
			} else {
				
				/* monster's attack landed */
				int damage;
				if (hero.armor != null) {
					damage = (int)Math.floor(Math.max(0, monster.damage - 0.01 * hero.armor.increase));
				} else {
					damage = monster.damage;
				}
				
				hero.hp -= damage;
				
				/* display damage dealt */
				if (hero.hp > 0) {
					System.out.println(monster.name + " dealt " + damage + " damage to " + hero.name + ".");
					System.out.println(hero.name + " has " + hero.hp + "HP left.");
				} else {
					hero.hp = 0;
					System.out.println(monster.name + " killed " + hero.name + "!");
					
				}
				
			}
		}
	}
	
	/* print party info - stats and inventory */
	public void printInfo() {
		
		/* print party info */
		String leftAlignFormat = "| %-1d | %-19s | %-3d | %-4d | %-4d | %-4d | %-4d | %-4d | %-5d | %-3d |%n";
		System.out.println("PARTY - STATS");
		System.out.format("+---+-HERO----------------+-LVL-+--HP--+-MANA-+-STR--+-AGL--+-DEX--+-GOLD--+-EXP-+%n");
		for (int i = 0; i < party_size; i++) {
			System.out.format(leftAlignFormat, i + 1, party[i].name, party[i].level, party[i].hp, party[i].mana, party[i].strength, party[i].agility, party[i].dexterity, party[i].gold, party[i].experience);
		}
		
		/* user selects hero inventory */
		System.out.println("Enter the left-column number to select a hero and view their inventory. Enter anything else to view the map again.");
		if (!sc.hasNext("[(\b1\b|\b2\b|\b3\b)]")) {
			System.out.println("Back to the map...\n");
			sc.next();
			return;
		}
		int heroNumber = sc.nextInt() - 1;
		if (heroNumber > party_size - 1) {
			System.out.println("This party member does not exist.\n");
			return;
		}
		
		/* print hero equipment */
		Hero hero = party[heroNumber];		
		System.out.println(hero.name + " - EQUIPMENT");
		System.out.format("+---+-EQUIPPED--------+-LVL-+-DMG/DEF-+-COST-+%n");
		if (hero.weapon != null) {
			System.out.format("| %-1s | %-15s | %-3d | %-7d | %-4d |%n", "W", hero.weapon.name, hero.weapon.level, hero.weapon.increase, hero.weapon.price);
		} else {
			System.out.format("| %-1s | %-15s | %-3s | %-7s | %-4s |%n", "W", "NONE", "", "", "");
		}
		if (hero.armor != null) {
			System.out.format("| %-1s | %-15s | %-3d | %-7d | %-4d |%n", "A", hero.armor.name, hero.armor.level, hero.armor.increase, hero.armor.price);
		} else {
			System.out.format("| %-1s | %-15s | %-3s | %-7s | %-4s |%n", "A", "NONE", "", "", "");
		}
		
		/* print hero inventory */
		if (hero.inventory.isEmpty()) {
			System.out.println(hero.name + "'s inventory is empty. Back to the map...\n");
			return;
		}
		
		System.out.println(hero.name + " - INVENTORY");
		System.out.format("+----+-ITEM------------+-LVL-+-ATTRIBUTE-+-PTS--+-COST-+%n");
		for (int i = 0; i < hero.inventory.size(); i++) {
			Item item = hero.inventory.get(i);
			System.out.format("| %-2d | %-15s | %-3d | %-9s | %-4d | %-4d |%n", i + 1, item.name, item.level, item.attributeToString(), item.increase, item.price);
		}
		
		/* allow user to equip item or consume potion */
		System.out.println(" Enter the left-column number to either try equipping the item or consuming the potion. Enter anything else to go back to the map.");
		if (!sc.hasNextInt()) {
			System.out.println(" Back to the map...\n");
			sc.next();
			return;
		}
		
		int itemChoice = sc.nextInt() - 1;
		if (itemChoice > hero.inventory.size() - 1) {
			System.out.println("This item does not exist.\n");
			return;
		}
		
		Item item = hero.inventory.get(itemChoice);
		hero.equip(item);
		
	}
	
	/* run the game */
	public void run() {
		
		this.initialize();
		while (!this.q) {
			this.printBoard();
			this.move();
		}
	}
	
	
	
	public static void main(String[] args) {
		Client client = new Client();
		client.run();
	}
	
}
