package cards;

import java.util.*;

import battle.BattleBackend;
import battle.Player;
/**
 * Made act(Player player) that changes the player's property
 * @author Jason Yan
 *
 */
public class Deck{
	//25
	 static public Card IQ = new SpellCard("200 IQ",2,"Draw a random minion from deck", 2, new Action() {
		public void act(Player player){
			player.hand.add(player.deck.get(1));
			player.deck.remove(player.hand.get(0));
		}

		@Override
		public void act() {
			// TODO Auto-generated method stub
			
		};
	}, "resources/200iq.png");
	static public Card Doge = new MonsterCard("Doge",6,"Taunt",null, 1, 6, 6, false, new Action() {
		public void act() {
			
		}
	},"resources/dog.png" );
	
	static public Card UltraMegaChicken = new MonsterCard("UltraMegaChicken",2,"",null, 3, 3, 3, false, new Action() {
		public void act() {
			
		}
	},"resources/UltraMegaChicken.png");
	static public Card OmaeWaMouShindeiru = new SpellCard("Omae wa mou Shindeiru",7, "Damage the hero 15 health", 1, new Action() {
		public void act() {
			
		}
	}, "resources/omaewa.png");
	static public Card Pikachu = new MonsterCard("Pikachu",4,"Battlecry",null, 1, 7, 7, false, new Action() {
		public void act() {
			
		}
	}, "pika.png");
	static public Card PotOfGreed = new SpellCard("Pot of Greed",1,"Draw 2 cards",2, new Action() {
		public void act() {
			
		}
	}, "resources/pog.png");
	static public Card TheExcutiveProducer = new MonsterCard("The Excutive Producer",3,"",null, 3, 4, 2, false, new Action() {
		public void act() {
			
		}
	}, "theexecutiveproducer.png");
	static public Card RainbowDash = new MonsterCard("Rainbow Dash!",3,"Charge",null, 2,5,1, false, new Action() {
		public void act() {
			
		}
	}, "resources/rd.png");
	static public Card SaltBae = new SpellCard("Salt Bae",5,"Heals target for 10",2, new Action() {
		public void act() {
			
		}
	}, "resources/saltbae.png");
	static public Card ScrewTheRulesIHaveMoney = new SpellCard("Screw The Rules, I Have Money",5,"Gain max empty mana crystals",3, new Action() {
		public void act() {
			
		}
	}, "resources/screwingtherules.png");
	static public Card Shenron = new MonsterCard("Shenron",50,"Charge","Taunt",0,99,99, false, new Action() {
		public void act() {
			
		}
	}, "resources/shenrun.png");
	static public Card DewYuKnoDeWae = new MonsterCard("Dew yu kno de wae", 4, null, null, 1, 5, 4, false, new Action() {
		public void act() {
			
		}
	}, "resources/dewyuknowdewae.png");
	static public Card UWot = new MonsterCard("u wot", 1, null, null, 3,1,1, false, new Action() {
		public void act() {
			
		}
	}, "resources/wotm8.png");
	static public Card WTF = new SpellCard("WTF?!?", 3, "Deals 3 damage to a random character",2, new Action() {
		public void act() {
			
		}
	}, "resources/wtfs.png");
	static public Card DragonBalls = new SpellCard("Seven Dragon Balls", 10, "Summon Shenron",0, new Action() {
		public void act() {
			
		}
	}, "resources/sevendragonballs.png");

	public ArrayList<Card> deck= new ArrayList<Card>();
	public Deck() {
		deck = new ArrayList<Card>();
		for(int i = 0; i<10; i++) {
			//addCard(Doge);
			deck.add(Doge);
		}
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
