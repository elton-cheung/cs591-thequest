Elton Cheung
U79831525

I cannot submit directory on gradescope so put files inside directory called thequest
From inside thequest, call pwd to get the path. Then run:

javac <path>/*.java
java Client

For example:

javac /Users/eltoncheung/eclipse-workspace/cs591java/src/thequest/*.java
java Client

Follow the instructions in the command line to play the game.

Classes:
Fighter - abstract class to represent fighting entities (heroes and monsters). fighters have name, hp, level.
Hero - subclass of Fighter, represents a hero. inherits Fighter attributes as well as specific Hero attributes such as inventory/skill levels. contains methods to equip items, buy/sell from market, and gain experience, etc.
Monster - subclass of Fighter, represents a monster to fight heroes.

Item - abstract class to represent items/consumables. items have general variables such as name, price, level, attribute, etc
Armor - subclass of Item, represents an armor item.
Potion - subclass of Item, represents a potion item.
Weapon - subclass of Item, represents a weapon item.
Spell - subclass of Item, represents a spell, and has different features than the other items, such as mana_cost, spell_type.

Tile - represents a tile on the board, such as non-accessible, market, common. keeps track of whether it is occuppied by party.
Data - this class instantiates instances of each item in the game, which are referenced accordingly.

Client - entry point of game. user initializes party, then plays through the main loop of the game. main loop prints the game board, and allows the user to make a move. when the user makes a move, the tile's behavior is triggered, such as entering the market or fighting a monster.

Notes:
- Some of the monster damage and defense calculations were adjusted to make for better gameplay.
- Numbers on experience and gold gain were adjusted to make for better gameplay.
- Monsters randomly choose one of the living heroes to attack.
- User can change equipment or consume potions in the [i] screen when game board is printed.
- User cannot change equipment during a fight.
- Chance of encountering enemies is 50%.
- Spells cannot be sold.
- HP and MP are uncapped (as suggested).
