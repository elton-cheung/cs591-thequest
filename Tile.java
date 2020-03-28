// package thequest;

enum TileType {
	Non, Market, Common
}

public class Tile {

	/* tile member variables */
	protected TileType type;
	protected double chance; // chance of monster attack on common tiles
	protected boolean occupied;
	
	/* constructor for tile - 20% non, 30% market, 50% common */
	public Tile() {
		
		double random = Math.random();
		if (random <= 0.2) {
			type = TileType.Non;
		} else if (random <= 0.5) {
			type = TileType.Market;
		} else {
			type = TileType.Common;
		}
		
		if (type == TileType.Common) {
			chance = 0.5;
		} else {
			chance = 0;
		}
		
		occupied = false;
	}
	
	public TileType getType() {
		return type;
	}
	
	public boolean getOccupied() {
		return occupied;
	}
	
	public void setOccupied() {
		occupied = !occupied;
	}
	
}
