package cards;

import java.util.*;

import guiTeacher.components.Action;

public class Deck {
	//25
	static Card IQ = new SpellCard("200 IQ",2,"Draw a random minion from deck",2,"resources/200iq.png");
	static Card Doge = new MonsterCard("Doge",6,"Taunt",null, 1, 6, 6,"resources/dog.png");
	static Card UltraMegaChicken = new MonsterCard("UltraMegaChicken",2,"",null, 3, 3, 3,"resources/UltraMegaChicken.png");
	static Card OmaeWaMouShindeiru = new SpellCard("Omae wa mou Shindeiru",7, "Damage the hero 15 health", 1,"resources/omaewa.png");
	static Card Pikachu = new MonsterCard("Pikachu",4,"Battlecry",null, 1, 7, 7,"resources/pika.png");
	static Card PotOfGreed = new SpellCard("Pot of Greed",1,"Draw 2 cards",2,"resources/pog.png");
	static Card TheExcutiveProducer = new MonsterCard("The Excutive Producer",3,"",null, 3, 4, 2,"resources/theexecutiveproducter.png");
	static Card RainbowDash = new MonsterCard("Rainbow Dash!",3,"Charge",null, 2,5,1,"resources/rd.png");
	static Card SaltBae = new SpellCard("Salt Bae",5,"Heals target for 10",2,"resources/saltbae.png");
	static Card ScrewTheRulesIHaveMoney = new SpellCard("Screw The Rules, I Have Money",5,"Gain max empty mana crystals",3,"resources/screwingtherules.png");
	static Card Shenron = new MonsterCard("Shenron",50,"Charge","Taunt",0,99,99,"resources/shenrun.png");
	static Card DewYuKnoDeWae = new MonsterCard("Dew yu kno de wae", 4, null, null, 1, 5, 4,"resources/dewyuknodewae.png");
	static Card UWot = new MonsterCard("u wot", 1, null, null, 3,1,1,"resources/wotm8.png");
	static Card WTF = new SpellCard("WTF?!?", 3, "Deals 3 damage to a random character",2,"resources/wtfs.png");
	static Card DragonBalls = new SpellCard("Seven Dragon Balls", 10, "Summon Shenron",0,"resources/sevendragonballs.png");
	
	static ArrayList<Card> userDeck = new ArrayList<Card>();
	
	public Deck() {
		// TODO Auto-generated constructor stub
	}

	
	public void addCard(Card card) {
		if(userDeck.size() < 16 && card.getAmt() > 1) {
			userDeck.add(card);
			card.setAmt(card.getAmt()-1);
		}
	}
	
	public void deleteCard(Card c) {
		userDeck.remove(c);
	}
	
	public void shuffleDeck() {
		Collections.shuffle(userDeck);
	}
}
