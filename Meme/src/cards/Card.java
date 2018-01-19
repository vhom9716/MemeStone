package cards;

public class Card {

	private String name;
	private int cost;
	private String effect;
	private String effect2;
	private int amt;
	
	public Card(String name, int cost, String effect, String effect2, int amt) {
		this.name = name;
		this.effect2 = effect2;
		this.cost = cost;
		this.amt = amt;
		this.effect = effect;
	}

	public void setName(String s) {
		this.name = s;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCost() {
		return cost;
	}
	
	public int getAmt() {
		return amt;
	}

	public void setAmt(int amt) {
		this.amt = amt;
	}
	
	public String getEffectTwo() {
		return effect2;
	}
}
