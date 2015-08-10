import java.util.HashSet;
import java.util.Set;

public class Trade implements Action{
	public final ResourceQuantity give;
	public final ResourceQuantity get;
	
	public Trade(ResourceQuantity give, ResourceQuantity get) {
		this.give = give;
		this.get = get;
	}

	@Override
	public Set<Board> possibeBoardsAfterAction(Player p, Board b) {
		return null;
	}
	
}
