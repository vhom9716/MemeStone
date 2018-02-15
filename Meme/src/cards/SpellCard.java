package cards;

public class SpellCard extends Card implements Spell{

	private String effect;
	
	public SpellCard(String name, int cost,String effect,int amt, Action a, String imageLoc) {
		
		super(name, cost, effect, null, amt, a, imageLoc);
		// TODO Auto-generated constructor stub
		
	}
	
	public String getEffect() {
		return effect;
	}
	
	public void setEffect(String effect) {
		this.effect = effect;
	}
	
	public Action getAction() {
		return a;
	}

}
