package cards;

import java.util.*;

public class Deck {
	//25
	static Card IQ = new SpellCard("200 IQ",2,"Draw a random minion from deck",2);
	public static Card Doge = new MonsterCard("Doge",6,"Taunt",null, 1, 6, 6,false);
	static Card UltraMegaChicken = new MonsterCard("UltraMegaChicken",2,"",null, 3, 3, 3,false);
	static Card OmaeWaMouShindeiru = new SpellCard("Omae wa mou Shindeiru",7, "Damage the hero 15 health", 1);  
	static Card Pikachu = new MonsterCard("Pikachu",4,"Battlecry",null, 1, 7, 7,false);
	static Card PotOfGreed = new SpellCard("Pot of Greed",1,"Draw 2 cards",2);
	static Card TheExcutiveProducer = new MonsterCard("The Excutive Producer",3,"",null, 3, 4, 2, false);
	static Card RainbowDash = new MonsterCard("Rainbow Dash!",3,"Charge",null, 2,5,1, false);
	static Card SaltBae = new SpellCard("Salt Bae",5,"Heals target for 10",2);
	static Card ScrewTheRulesIHaveMoney = new SpellCard("Screw The Rules, I Have Money",5,"Gain max empty mana crystals",3);
	static Card Shenron = new MonsterCard("Shenron",50,"Charge","Taunt",0,99,99, false);
	static Card DewYuKnoDeWae = new MonsterCard("Dew yu kno de wae", 4, null, null, 1, 5, 4, false);
	static Card UWot = new MonsterCard("u wot", 1, null, null, 3,1,1, false);
	static Card WTF = new SpellCard("WTF?!?", 3, "Deals 3 damage to a random character",2);
	static Card DragonBalls = new SpellCard("Seven Dragon Balls", 10, "Summon Shenron",0);
	

	public static ArrayList<Card> deck;

	
	public Deck() {
		deck = new ArrayList<Card>();
		for(int i = 0; i <10; i++) {
			//addCard(Doge);
			deck.add(Doge);
		}
	}

	public static void main(String[] args) {
		deck = new ArrayList<Card>(); 
	}

	public void addCard(Card card) {
		if(deck.size() < 16 && card.getAmt() > 1) {
			deck.add(card);
			card.setAmt(card.getAmt()-1);
		}
	}
	
	public void deleteCard(Card c) {
		deck.remove(c);
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
}
