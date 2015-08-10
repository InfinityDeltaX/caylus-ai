import java.util.HashSet;
import java.util.Set;

import com.sun.swing.internal.plaf.basic.resources.basic;

public class Board {

	public final int TOTAL_BOARD_SPACES = 34;
	public final int PROVOST_STARTING_POSITION = 0;

	private Location[] spaces = new Location[TOTAL_BOARD_SPACES]; //34 is the number of squares.
	Set<Player> players;

	private int provostPosition = 0;

	public Board() {
		initialize();
	}

	public void getBoardsFromGivingFavor(Player p){
		return 
	}

	private void initialize() {
		spaces[0] = new Location(new Property(), Player.NONE);
		spaces[1] = new Location(new Property(new Trade(ResourceQuantity.NONE, new ResourceQuantity(0, 0, 0, 0, 0, 3))), Player.NONE);
		spaces[2] = new Location(new Property( //provost movement square
				(p, b) -> {
					Set<Board> output = new HashSet<Board>();
					for (int i = -3; i <= 3; i++) {
						Board c = new Board(b);
						c.moveProvost(i);
						output.add(c);
					}
					return output;
				}), Player.NONE);

	}

	private void moveProvost(int amt) {
		provostPosition += amt;
	}

}
