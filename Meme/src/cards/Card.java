package cards;

public class Card {

	private String name;
	private int cost;
	private String description;
	private String effect;
	
	public Card(String name, int cost, String description) {
		this.name = name;
		this.cost = cost;
		this.description = description;
	}
	
	public void setName(String s) {
		this.name = s;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public void getDescription(String description) {
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCost() {
		return cost;
	}
	
	public String getDescription() {
		return description;
	}
}
