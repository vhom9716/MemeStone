package cards;

public class Card{
	public Action a;
	private String name;
	private int cost;
	private String effect;
	private String effect2;
	private int amt;
	/**
	 * Action a - Passes in a new action so that you can create a method for each individual cards	
	 * 
	 * @param name
	 * @param cost
	 * @param effect
	 * @param effect2
	 * @param amt
	 * @param a
	 * @author Jason Yan
	 */
	public Card(String name, int cost, String effect, String effect2, int amt, Action a) {
		this.name = name;
		this.effect2 = effect2;
		this.cost = cost;
		this.amt = amt;
		this.effect = effect;
		this.a = a;
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
