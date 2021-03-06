package cards;

public class Card{
	public Action a;
	private String name;
	private int cost;
	private String effect;
	private String effect2;
	private int amt;
	private String imageLoc;
	private int amtUsed = 0;
	public boolean canAttack;
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
	public Card(String name, int cost, String effect, String effect2, int amt, Action a, String imageLoc) {
		this.name = name;
		this.effect2 = effect2;
		this.cost = cost;
		this.amt = amt;
		this.setEffect(effect);
		this.a = a;
		this.imageLoc = imageLoc;
		this.setCanAttack(false);
	}

	public int getAmtUsed() {
		return amtUsed;
	}
	
	public void resetAmts() {
		amtUsed = 0;
	}
	
	public void usedOne() {
		amtUsed ++;
	}
	
	public void removedOneFromDeck() {
		amtUsed --;
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
	
	public String toString() {
		return getName();
		
	}
	public String getImage() {
		return imageLoc;
	}

	public boolean isCanAttack() {
		return canAttack;
	}

	public boolean setCanAttack(boolean canAttack) {
		return this.canAttack = canAttack;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}
}
