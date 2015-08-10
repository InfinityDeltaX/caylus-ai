import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Board {

	public final int TOTAL_BOARD_SPACES = 34;
	public final int PROVOST_STARTING_POSITION = 0;
	
	private Location[] spaces = new Location[TOTAL_BOARD_SPACES]; //34 is the number of squares.
	private HashMap<PlayerColor, Player> players;
	private Map<Player, Favors> favors = new HashMap<Player, Favors>();
	
	private int provostPosition = 0;

	public Board() {
		initialize();
	}

	public Board(Board copy) {
		for(int i = 0; i < TOTAL_BOARD_SPACES; i++){
			this.spaces[i] = new Location(copy.spaces[i]);
		}
		copy.players.forEach((pc, p) -> {this.players.put(pc, new Player(p));});
		copy.favors.forEach((p, f) -> {this.favors.put(new Player(p), new Favors(f));});
	}

	public Set<Board> getBoardsFromGivingFavor(Player p){
		Set<Board> output = new HashSet<Board>();
		Board a = new Board(this);
		a.favors.get(p).increasePointRank();
		output.add(a);
		Board b = new Board(this);
		b.favors.get(p).increaseDenierRank();
		output.add(b);
		Board c = new Board(this);
		c.favors.get(p).increaseBlockRank();
		output.add(c);
		Board d = new Board(this);
		d.favors.get(p).increaseBuildRank();
		output.add(d);
		
		return output;
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
		spaces[3] = new Location(new Property((p, b) -> {
			ResourceQuantity trade = new ResourceQuantity(0, 0, 0, 0, 1, 1);
			Set<Board> output = new HashSet<Board>();
			output.add(new Board(b));
			if(p.hasResources(trade)){
				Board tookTrade = new Board(b);
				Player n = tookTrade.getCorrespondingPlayer(p);
				n.deductResources(trade);
				output.addAll(tookTrade.getBoardsFromGivingFavor(n));
			}
			
			return output;
		}), Player.NONE);
	}

	private Player getCorrespondingPlayer(Player p) {
		return this.players.get(p.color);
	}

	private void moveProvost(int amt) {
		provostPosition += amt;
	}

}
