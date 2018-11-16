package core;

import java.util.ArrayList;

public class Player {

	// players name
	private String pName;
	private Play strat;
	// players hand
	private ArrayList<Tile> hand = new ArrayList<Tile>();
	// indicates if player is playing or waiting for their turn
	private boolean DoneTurn = false;

	public Player(String PName, Play s) {
		this.strat = s;
		pName = PName;
	}

	public Player(String PName) {

		pName = PName;
	}

	public int Play(Game g) {
		return this.strat.play(g);
		// return 0;
	}

	public void ClearHand() {

		hand.clear();
	}

	public ArrayList<Tile> getHand() {

		return hand;
	}

	public boolean addTile(Tile tile) {
		hand.add(tile);
		return true;
	}

	public String getName() {
		return pName;
	}

	public Tile getTile(int i) {
		return hand.get(i);

	}

	public boolean checkWinner() {
		if (this.getHandSize() == 0)
			return true;
		return false;
	}

	public int getHandSize() {
		return hand.size();
	}

	public boolean RemoveTile(int i) {
		if (i > hand.size() - 1) {
			return false;
		}
		hand.remove(i);
		return true;
	}

	public boolean RemoveTile(Tile t) {
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).equals(t)) {
				hand.remove(i);
				return true;
			}
		}
		return false;
	}

	// Checks player equality by name
	public boolean equals(Player p) {
		if (this.getName().equals(p.getName())) {
			return true;
		} else {
			return false;
		}
	}

	public void sortHand() {
		ArrayList<Tile> R = new ArrayList<Tile>();
		ArrayList<Tile> G = new ArrayList<Tile>();
		ArrayList<Tile> B = new ArrayList<Tile>();
		ArrayList<Tile> O = new ArrayList<Tile>();
		for (int i = 0; i < hand.size(); i++) { // sort tiles into colors
			Tile t = hand.get(i);
			if (t.getColour().equals(Colour.Red)) {
				R.add(t);
			} else if (t.getColour().equals(Colour.Green)) {
				G.add(t);
			} else if (t.getColour().equals(Colour.Blue)) {
				B.add(t);
			} else {
				O.add(t);
			}
		}

		sortByValue(R);
		sortByValue(G);
		sortByValue(B);
		sortByValue(O);

		hand.clear();
		for (int i = 0; i < R.size(); i++) {
			hand.add(R.get(i));
		}
		for (int i = 0; i < G.size(); i++) {
			hand.add(G.get(i));
		}
		for (int i = 0; i < B.size(); i++) {
			hand.add(B.get(i));
		}
		for (int i = 0; i < O.size(); i++) {
			hand.add(O.get(i));
		}
	}

	public void sortByValue(ArrayList<Tile> a) {
		for (int i = 0; i < a.size(); i++) {
			Tile smallestTile = a.get(i);
			int smallestIndex = i;
			for (int j = i; j < a.size(); j++) {
				if (a.get(j).getValue() < smallestTile.getValue()) {
					smallestTile = a.get(j);
					smallestIndex = j;
				}
			}
			// swap
			Tile temp = a.get(i);
			a.set(i, smallestTile);
			a.set(smallestIndex, temp);
		}
	}
}
