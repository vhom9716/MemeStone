package cards;

public class MonsterCard extends Card {

	private int health;
	private int attack;
	
	public MonsterCard(String name, int cost, String description) {
		super(name, cost, description);
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
