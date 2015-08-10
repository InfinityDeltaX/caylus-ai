import java.util.Set;

@FunctionalInterface
public interface Action {
	public Set<Board> possibeBoardsAfterAction(Player p, Board b);
}
