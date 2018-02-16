package cards;

import battle.AI;
import battle.BattleBackend;
import battle.Player;

public interface Action {
	/**
	 * Interface Action with method act()
	 * 
	 * Used to pass in methods as a parameter
	 * @author Jason Yan
	 */
	void act(Player player, AI cpu, String turn, Card card, BattleBackend backend);
}