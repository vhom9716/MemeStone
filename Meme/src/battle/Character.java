package battle;

import java.util.ArrayList;

import cards.Card;
import cards.MonsterCard;

public interface Character {
	Card getFromHand(int pos);
	void addToBoard(MonsterCard c);
	void removeFromHand(int pos);
	
}
