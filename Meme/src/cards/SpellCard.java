package cards;

public class SpellCard extends Card {

	private String effect;
	
	public SpellCard(String name, int cost,String effect,int amt, Action a) {
		
		super(name, cost, effect, null, amt, a);
		// TODO Auto-generated constructor stub
		
	}
	
	public String getEffect() {
		return effect;
	}
	
	public void setEffect(String effect) {
		this.effect = effect;
	}

}
