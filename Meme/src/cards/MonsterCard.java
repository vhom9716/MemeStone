package cards;

public class MonsterCard extends Card implements Monster{

	private int health;
	private int attack;
	private boolean charge;
	
	public MonsterCard(String name, int cost, String effect, String effect2, int amt,int attack,int health, boolean charge, Action a, String imageLoc) {
		super(name,cost, effect, effect2, amt, a, imageLoc);
		this.health = health;
		this.attack = attack;
		this.charge = charge;
		this.canAttack = charge;
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
	
	public boolean getCharge() {
		return charge;
	}
	
	public boolean returnCanAttack() {
		return canAttack;
	}

}
