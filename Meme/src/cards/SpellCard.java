package cards;

public class SpellCard extends Card {

	private String effect;
	
	public SpellCard(String name, int cost, String description) {
		
		super(name, cost, description);
		// TODO Auto-generated constructor stub
		
		
	}
	
	public String getEffect() {
		return effect;
	}
	
	public void setEffect(String effect) {
		this.effect = effect;
	}

}
