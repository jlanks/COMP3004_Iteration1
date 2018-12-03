package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class StrategyTwoTest {

	@Test
	public void testPlayGameAdd() {

		Game game = new Game();
		game.nextTurn();
		game.nextTurn();
		Tile t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
		t5 = (new Tile(Colour.Orange, 7));
		t6 = (new Tile(Colour.Orange, 8));
		t7 = (new Tile(Colour.Orange, 9));
		t8 = (new Tile(Colour.Orange, 10));
		t9 = (new Tile(Colour.Orange, 11));
		t10 = (new Tile(Colour.Orange, 13));
		t14 = (new Tile(Colour.Orange, 6));
		
		t11 = (new Tile(Colour.Red, 13));
		t12 = (new Tile(Colour.Green, 13));
		t13 = (new Tile(Colour.Blue, 13));
		
		Player p = game.getPlayer();
		Hand h = game.getCurrHand();
		Table t = game.getTable(); 
		
		
		Meld m = new Meld(t5,t6,t7,false); 
		t.addMeld(m);
		assertEquals(1,game.getNumMelds()); 
		
		p.addTile(t11);
		p.addTile(t12);
		p.addTile(t13);
		
		p.Play(game);
		
		assertEquals(2,game.getNumMelds()); 
		
		p.addTile(t10);
		p.addTile(t14);
		p.addTile(t8);
		
		
		//
		 /*
		assertEquals(true,m.CheckBack(t8)); 
		assertEquals(false,m.CheckBack(t14)); 
		assertEquals(true,m.CheckFront(t14)); 
		
		 * */
		// p.Play(game);
		//
		//h.AddAllPossible(game.getMelds());
		
		// this works 
		// *** h.AddAllTiles(game, game.getMelds().get(0));
		
		//h.AddAllTiles(game, game.getMelds().get(0));
		
		/*
		 * 	But this Does not work, idk why - assertEquals(4,p.Play(game));
		 *	StrategyTwo, line 61
		 */
		
		assertEquals(4,p.Play(game));
		assertEquals(0,game.getCurrHand().getSize()); 
		
		}	

//@Test
public void testPlayGameRunSet() {

	Game game = new Game();
	game.nextTurn();
	game.nextTurn();
	Tile t5,t6,t7,t8,t9,t10,t11,t12,t13;
	t5 = (new Tile(Colour.Orange, 7));
	t6 = (new Tile(Colour.Orange, 8));
	t7 = (new Tile(Colour.Orange, 9));
	t8 = (new Tile(Colour.Orange, 10));
	t9 = (new Tile(Colour.Orange, 11));
	t10 = (new Tile(Colour.Orange, 12));
	t11 = (new Tile(Colour.Orange, 13));
	t11 = (new Tile(Colour.Orange, 13));
	t12 = (new Tile(Colour.Green, 13));
	t13 = (new Tile(Colour.Blue, 13));
	
	game.getPlayer().addTile(t7); 
	game.getPlayer().addTile(t11); 
	game.getPlayer().addTile(t13); 
	game.getPlayer().addTile(t12); 
	
	// random tiles for more game like testing
	
	
	game.getPlayer().addTile(t10); 
	game.getPlayer().addTile(t13); 
	/**/
	game.getPlayer().addTile(t5); 
	game.getPlayer().addTile(t6); 
	game.getPlayer().addTile(t7); 
	game.getPlayer().addTile(t7); 
	//game.getCurrHand().sortHand();
	assertEquals(10,game.currHandSize());
	assertEquals("Player 3",game.getPlayer().getName());
	
	game.getPlayer().Play(game);
	assertEquals(3,game.currHandSize());
	assertEquals("Player 3",game.getPlayer().getName());
	assertEquals(2,game.getNumMelds());
	
	
	
	
	
	}	

//@Test
public void testCantPlay() {
	
	Game game = new Game();
	game.nextTurn();
	game.nextTurn();
	Tile t5,t6,t7,t8,t9,t10,t11,t12,t13;
	t5 = (new Tile(Colour.Orange, 7));
	t6 = (new Tile(Colour.Orange, 8));
	t7 = (new Tile(Colour.Orange, 9));
	t8 = (new Tile(Colour.Orange, 10));
	t9 = (new Tile(Colour.Orange, 11));
	t10 = (new Tile(Colour.Orange, 12));
	t11 = (new Tile(Colour.Orange, 13));
	t11 = (new Tile(Colour.Orange, 13));
	t12 = (new Tile(Colour.Green, 13));
	t13 = (new Tile(Colour.Blue, 13));
	
	game.getPlayer().addTile(t11);
	game.getPlayer().addTile(t12);
	game.getPlayer().addTile(t13);
	assertEquals(3,game.currHandSize());
	game.Play(); 
	 
	assertEquals(3,game.currHandSize());
	// adding a meld to the table
	Meld m = new Meld(t5,t6,t7,false);
	game.getTable().addMeld(m);
	assertEquals(1,game.getNumMelds());
	assertEquals(3,game.currHandSize());
	game.Play(); 
	assertEquals(0,game.currHandSize());
	assertEquals(2,game.getNumMelds());
	
	
	
	
}

//@Test
public void testPlaystowin() {
	
	Game game = new Game();
	game.nextTurn();
	game.nextTurn();
	Tile t5,t6,t7,t8,t9,t10,t11,t12,t13;
	t5 = (new Tile(Colour.Orange, 7));
	t6 = (new Tile(Colour.Orange, 8));
	t7 = (new Tile(Colour.Orange, 9));
	t8 = (new Tile(Colour.Orange, 10));
	t9 = (new Tile(Colour.Orange, 11));
	t10 = (new Tile(Colour.Orange, 12));
	t11 = (new Tile(Colour.Orange, 13));
	t11 = (new Tile(Colour.Orange, 13));
	t12 = (new Tile(Colour.Green, 13));
	t13 = (new Tile(Colour.Blue, 13));
	
	game.getPlayer().addTile(t11);
	game.getPlayer().addTile(t12);
	game.getPlayer().addTile(t13);
	game.getPlayer().addTile(t13);
	assertEquals(4,game.currHandSize());
	game.Play(); 
	 
	assertEquals(4,game.currHandSize());
	// adding a meld to the table
	Meld m = new Meld(t5,t6,t7,false);
	game.getTable().addMeld(m);
	assertEquals(1,game.getNumMelds());
	assertEquals(4,game.currHandSize());
	game.playFirst();
	game.Play(); 
	assertEquals(5,game.currHandSize());
	assertEquals(1,game.getNumMelds());
	
}
}
