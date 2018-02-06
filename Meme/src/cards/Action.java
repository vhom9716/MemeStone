package cards;

import battle.Player;

public interface Action {
	/**
	 * Interface Action with method act()
	 * 
	 * Used to pass in methods as a parameter
	 * @author Jason Yan
	 */
	public void act(Player player);
}
