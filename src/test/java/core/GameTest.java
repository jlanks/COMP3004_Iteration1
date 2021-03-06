package core;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {
	
	
	
	@Test
	public void testS1() {
		
		
		Game game = new Game(); 
		
		Tile t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16;
		t5 = (new Tile(Colour.Orange, 7));
		t6 = (new Tile(Colour.Orange, 8));
		t7 = (new Tile(Colour.Orange, 9));
		t8 = (new Tile(Colour.Orange, 10));
		t9 = (new Tile(Colour.Orange, 11));
		t10 = (new Tile(Colour.Orange, 12));
		t11 = (new Tile(Colour.Red, 13));
		t12 = (new Tile(Colour.Green, 13));
		t13 = (new Tile(Colour.Blue, 13));
		t14 = (new Tile(Colour.Red, 13));
		t15 = (new Tile(Colour.Green, 13));
		t16 = (new Tile(Colour.Blue, 13));
		
		game.nextTurn();
		assertEquals(0,game.getPlayer().getHandSize()); 
		
		game.getPlayer().addTile(t5); 
		game.getPlayer().addTile(t6); 
		game.getPlayer().addTile(t7); 
		game.getPlayer().addTile(t8); 
		game.getPlayer().addTile(t9); 
		game.getPlayer().addTile(t10); 
		game.getPlayer().addTile(t11); 
		game.getPlayer().addTile(t12); 
		game.getPlayer().addTile(t13); 
		game.getPlayer().addTile(t14); 
		game.getPlayer().addTile(t15); 
		game.getPlayer().addTile(t16); 
		
		assertEquals(12,game.getPlayer().getHandSize()); 
		
		game.getPlayer().Play(game); 
		
		assertEquals(0,game.getPlayer().getHandSize());
		assertEquals(3,game.getNumMelds());
		
	
		
		
		
		
		
	}
/*
	@Test
	public void testinit() {
		Game game = new Game();
		Table table = game.getTable();
		Player pHuman = table.player1();
		Player p1 = table.player2();
		Player p3 = table.player3();

		
		assertEquals("Human Player", pHuman.getName()); // StrategyHuman
		assertEquals("Player 1", p1.getName()); // StrategyOne
		assertEquals("Player 3", p3.getName()); // StrategyTwo

		assertEquals(game.getPlayer(), pHuman);
		game.nextTurn();
		assertEquals(game.getPlayer(), p1);
		game.nextTurn();
		assertEquals(game.getPlayer(), p3);
		game.nextTurn();
		assertEquals(game.getPlayer(), pHuman);

		game.end();
		
	}
	
	@Test
	public void testInitialSingleMeld() {
		Game game = new Game();
		Table table = game.getTable();
		Player pHuman = table.player1();
		Player p1 = table.player2();
		Player p3 = table.player3();

		assertEquals(0, p1.getHandSize());
		assertEquals(0, p3.getHandSize());

		pHuman.addTile(new Tile("R1"));// dummy tile so human doens't win
		p1.addTile(new Tile("R9"));
		p1.addTile(new Tile("R10"));
		p3.addTile(new Tile("G10"));
		p3.addTile(new Tile("G11"));

		assertEquals(2, p1.getHandSize());
		assertEquals(2, p3.getHandSize());

		// Neither player can play yet
		game.nextTurn();// skip pHuman
		game.getPlayer().Play(game); // p1 plays, draws tile
		game.nextTurn();
		game.getPlayer().Play(game); // p3 plays, draws tile
		
		assertEquals(3, p1.getHandSize());
		assertEquals(3, p3.getHandSize());
		
		game.nextTurn();// human 
		game.nextTurn(); // p1
		game.nextTurn(); //p2
		
		assertEquals(4, p1.getHandSize());
		assertEquals(4, p3.getHandSize());
		
		assertEquals(0, table.numMelds());
		
		p1.addTile(new Tile("R11"));
		p3.addTile(new Tile("G12"));

		// Both players should play their initial melds worth 30 and 33 respectively
		game.nextTurn();// skip pHuman
		game.getPlayer().Play(game); // p1 plays

		assertEquals(1, table.numMelds());
		
		game.nextTurn();
		game.getPlayer().Play(game); // p3 plays
		/*
		assertEquals(2, table.numMelds());

		game.end();
		
	}
	
	public void testWinFirst() {
		Game game = new Game(); 
		assertEquals(true, game.hasWinner());

	}
	
	
	public void testInitialMultiMeld() {
		Game game = new Game();
		Table table = game.getTable();
		Player pHuman = table.player1();
		Player p1 = table.player2();
		Player p3 = table.player3();

		pHuman.addTile(new Tile("R1"));// dummy tile so human doesn't win

		p1.addTile(new Tile("R4"));
		p1.addTile(new Tile("R5"));
		p1.addTile(new Tile("R6"));
		p3.addTile(new Tile("G5"));
		p3.addTile(new Tile("G6"));
		p3.addTile(new Tile("G7"));

		// Neither player can play yet
		game.nextTurn();// skip pHuman
		game.getPlayer().Play(game); // p1 plays, draws tile
		game.nextTurn();
		game.getPlayer().Play(game); // p3 plays, draws tile
		game.nextTurn();
		
		assertEquals(0, table.numMelds());
		
		p1.addTile(new Tile("B4"));
		p1.addTile(new Tile("B5"));
		p1.addTile(new Tile("B6"));
		p3.addTile(new Tile("O5"));
		p3.addTile(new Tile("O6"));
		p3.addTile(new Tile("O7"));

		// Both players should play their initial two melds worth total of 30 and 36
		// respectively
		game.nextTurn();// skip pHuman
		game.getPlayer().Play(game); // p1 plays

		assertEquals(2, table.numMelds());
	
		game.nextTurn();
		game.getPlayer().Play(game); // p3 plays
	
		assertEquals(4, table.numMelds());

		game.end();
	
	}

	public void testMeldCombos() {
		Game game = new Game();
		Table table = game.getTable();
		Player pHuman = table.player1();
		Player p1 = table.player2();
		Player p3 = table.player3();

		// dummy tiles to prevent players from winning
		pHuman.addTile(new Tile("R1"));
		p1.addTile(new Tile("R1"));
		p3.addTile(new Tile("R1"));

		p1.addTile(new Tile("O5"));
		p1.addTile(new Tile("B5"));
		p1.addTile(new Tile("R5"));
		
		p1.addTile(new Tile("R1"));
		p1.addTile(new Tile("R2"));
		p1.addTile(new Tile("R3"));
		p1.addTile(new Tile("R4"));
		p1.addTile(new Tile("R5"));
		
		// ADDING TO 30
		p1.Play(game); 
		assertEquals(2, table.numMelds());
		
		p1.addTile(new Tile("R9"));
		p1.addTile(new Tile("R10"));
		p1.addTile(new Tile("R11"));
		p1.addTile(new Tile("R12"));
		p1.addTile(new Tile("R13"));
		
		p1.addTile(new Tile("R9"));
		p1.addTile(new Tile("R10"));
		p1.addTile(new Tile("R11"));
		p1.addTile(new Tile("R12"));
		p1.addTile(new Tile("R13"));
		p1.addTile(new Tile("R10"));
		p1.addTile(new Tile("G10"));
		p1.addTile(new Tile("B10"));

		assertEquals(0, table.numMelds());
		
		// Both players play initial 30
		game.nextTurn();// skip pHuman
		game.getPlayer().Play(game); // p1 plays all melds
		

		game.show();
		assertEquals(3, table.numMelds());
		
		
		p1.addTile(new Tile("R9"));
		p1.addTile(new Tile("R10"));
		p1.addTile(new Tile("R11"));
		p1.addTile(new Tile("G9"));
		p1.addTile(new Tile("G10"));
		p1.addTile(new Tile("G11"));
		
		p3.addTile(new Tile("R10"));
		p3.addTile(new Tile("G10"));
		p3.addTile(new Tile("B10"));
		p3.addTile(new Tile("R11"));
		p3.addTile(new Tile("G11"));
		p3.addTile(new Tile("B11"));

		// Both players' second turn
		game.nextTurn();// skip pHuman
		game.getPlayer().Play(game); // p1 plays multiple runs
		game.nextTurn();

		game.show();
		assertEquals(4, table.numMelds());
		
		game.getPlayer().Play(game); // p3 plays multiple sets
		game.nextTurn();

		game.show();
		assertEquals(6, table.numMelds());

		p1.addTile(new Tile("R9"));
		p1.addTile(new Tile("R10"));
		p1.addTile(new Tile("R11"));
		p3.addTile(new Tile("G9"));
		p3.addTile(new Tile("G10"));
		p3.addTile(new Tile("G11"));

		p1.addTile(new Tile("R10"));
		p1.addTile(new Tile("G10"));
		p1.addTile(new Tile("B10"));
		p3.addTile(new Tile("R11"));
		p3.addTile(new Tile("G11"));
		p3.addTile(new Tile("B11"));

		// Both players' third turn
		game.nextTurn();// skip pHuman
		game.getPlayer().Play(game); // p1 plays set and meld
		game.nextTurn();
	
		game.show();
		assertEquals(8, table.numMelds());

		game.getPlayer().Play(game); // p3 plays set and meld
		game.nextTurn();

		game.show();
		assertEquals(10, table.numMelds());

		game.end();
		
	}
	
	public void testStrategies() {
		Game game = new Game();
		Table table = game.getTable();
		Player pHuman = table.player1();
		Player p1 = table.player2();
		Player p3 = table.player3();

		// dummy tiles to prevent players from winning
		pHuman.addTile(new Tile("R1"));
		p1.addTile(new Tile("R1"));
		p3.addTile(new Tile("R1"));

		p1.addTile(new Tile("R9"));
		p1.addTile(new Tile("R10"));
		p1.addTile(new Tile("R11"));
		p3.addTile(new Tile("R10"));
		p3.addTile(new Tile("G10"));
		p3.addTile(new Tile("B10"));

		game.show();
		assertEquals(0, table.numMelds());

		// Both players play initial 30
		game.nextTurn();// skip pHuman
		game.getPlayer().Play(game); // p1 plays single run
		game.nextTurn();

		game.show();
		assertEquals(1, table.numMelds());

		game.getPlayer().Play(game); // p3 plays single set
		game.nextTurn();

		game.show();
		assertEquals(2, table.numMelds());

		// p1 gets useless tiles
		p1.addTile(new Tile("R9"));
		p1.addTile(new Tile("R10"));
		p1.addTile(new Tile("O11"));
		p1.addTile(new Tile("G9"));
		p1.addTile(new Tile("G10"));
		p1.addTile(new Tile("O11"));

		p3.addTile(new Tile("R10"));
		p3.addTile(new Tile("G10"));
		p3.addTile(new Tile("B10"));
		p3.addTile(new Tile("R11"));
		p3.addTile(new Tile("G11"));
		p3.addTile(new Tile("B11"));

		// Both players' second turn
		game.nextTurn();// skip pHuman
		game.getPlayer().Play(game); // p1 cannot play, draws tile
		game.nextTurn();

		game.show();
		assertEquals(2, table.numMelds());

		game.getPlayer().Play(game); // p3 can play, but does not (p1 does not have 3 fewer tiles)
		game.nextTurn();

		game.show();
		assertEquals(2, table.numMelds());

		game.end();

		//*** TEST P3 PLAYS ALL THE TILES THEY CAN, IF THEY CAN WIN
		game = new Game();
		table = game.getTable();
		pHuman = table.player1();
		p1 = table.player2();
		p3 = table.player3();

		// dummy tiles to prevent players from winning
		pHuman.addTile(new Tile("R1"));
		p1.addTile(new Tile("R1"));
		p3.addTile(new Tile("R1"));

		p1.addTile(new Tile("R9"));
		p1.addTile(new Tile("R10"));
		p1.addTile(new Tile("R11"));
		p3.addTile(new Tile("R10"));
		p3.addTile(new Tile("G10"));
		p3.addTile(new Tile("B10"));

		game.show();
		assertEquals(0, table.numMelds());

		// Both players play initial 30
		game.nextTurn();// skip pHuman
		game.getPlayer().Play(game); // p1 plays single run
		game.nextTurn();

		game.show();
		assertEquals(1, table.numMelds());

		game.getPlayer().Play(game); // p3 plays single set
		game.nextTurn();

		game.show();
		assertEquals(2, table.numMelds());

		// p1 gets useless tiles
		p1.addTile(new Tile("R9"));
		p1.addTile(new Tile("R10"));
		p1.addTile(new Tile("O11"));
		p1.addTile(new Tile("G9"));
		p1.addTile(new Tile("G10"));
		p1.addTile(new Tile("O11"));
		p1.addTile(new Tile("R4"));
		p1.addTile(new Tile("R6"));

		p3.addTile(new Tile("R10"));
		p3.addTile(new Tile("G10"));
		p3.addTile(new Tile("B10"));
		p3.addTile(new Tile("R11"));
		p3.addTile(new Tile("G11"));
		p3.addTile(new Tile("B11"));

		// Give p3 tiles to make meld with dummy "R1" tile
		p3.addTile(new Tile("R2"));
		p3.addTile(new Tile("R3"));

		// Both players' second turn
		game.nextTurn();// skip pHuman
		game.getPlayer().Play(game); // p1 cannot play, draws tile
		game.nextTurn();

		game.show();
		assertEquals(2, table.numMelds());

		game.getPlayer().Play(game); // p3 can win so plays all tiles (even though p1 does not have 3 fewer tiles)
		game.nextTurn();

		game.show();
		assertEquals(2, table.numMelds());

		assertEquals(true, game.hasWinner());

		game.end();
		
	}
	
	public void testadd30sum() {
		Game game = new Game();
		Table table = game.getTable();
		Player pHuman = table.player1();
		Player p1 = table.player2();
		Player p3 = table.player3();

		// dummy tiles to prevent players from winning
		pHuman.addTile(new Tile("R1"));
		p1.addTile(new Tile("R1"));
		p3.addTile(new Tile("R1"));

		p1.addTile(new Tile("O10"));
		p1.addTile(new Tile("B10"));
		p1.addTile(new Tile("R10"));
		
		
		
		game.nextTurn();
		game.getPlayer().Play(game); 
		assertEquals(1, game.getTable().numMelds());
		p1.addTile(new Tile("O10"));
		p1.addTile(new Tile("B10"));
		p1.addTile(new Tile("R10"));
		p1.addTile(new Tile("G10"));
		
		game.nextTurn();
		game.nextTurn();
		game.getPlayer().Play(game); 
		assertEquals(2, game.getTable().numMelds());
		
		
		p1.addTile(new Tile("O10"));
		p1.addTile(new Tile("B10"));
		p1.addTile(new Tile("R10"));
		
		p1.addTile(new Tile("G10"));
		p1.addTile(new Tile("B11"));
		p1.addTile(new Tile("R12"));
		game.nextTurn();
		game.nextTurn();
		game.getPlayer().Play(game); 
		assertEquals(4, game.getTable().numMelds());
		
		p1.addTile(new Tile("O10"));
		p1.addTile(new Tile("B10"));
		p1.addTile(new Tile("R10"));
		
		game.nextTurn();
		game.nextTurn();
		game.getPlayer().Play(game); 
		assertEquals(5, game.getTable().numMelds());
		
		
		
	}	
	
	public void testdraw() {
		
		
		Game game = new Game();
		Table table = game.getTable();
		Player pHuman = table.player1();
		Player p1 = table.player2();
		Player p3 = table.player3();
	
		// dummy tiles to prevent players from winning
		pHuman.addTile(new Tile("R1"));
		p1.addTile(new Tile("R1"));
		p3.addTile(new Tile("R1"));
	
		int x = p1.getHandSize();
		game.nextTurn();
		
		assertEquals(x+1, p1.getHandSize());
		
		game.nextTurn();
		game.nextTurn();
		
		game.nextTurn();
		
		assertEquals(x+2, p1.getHandSize());
		
	}
	*/
}
