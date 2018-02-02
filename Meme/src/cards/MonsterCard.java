package cards;

public class MonsterCard extends Card {

	private int health;
	private int attack;
	
	public MonsterCard(String name, int cost, String effect, String effect2, int amt,int attack,int health, String location) {
		super(name,cost, effect, effect2, amt,location);
		this.health = health;
		this.attack = attack;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public int getHealth() {
		return health;
	}

}
