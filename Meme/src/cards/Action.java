package cards;

import battle.BattleBackend;
import battle.Player;

public interface Action {
	/**
	 * Interface Action with method act()
	 * 
	 * Used to pass in methods as a parameter
	 * @author Jason Yan
	 */
	public void act(Player player, BattleBackend backend);
}
