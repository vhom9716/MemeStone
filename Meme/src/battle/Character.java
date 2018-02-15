package battle;

import java.util.ArrayList;

import cards.Card;
import cards.MonsterCard;
import cards.SpellCard;

public interface Character {
	Card getFromHand(int pos);
	void addToBoard(MonsterCard c);
	void removeFromHand(int pos);
	int getHandSize();
	void playSpell();
	void playSpell(SpellCard card);
}
