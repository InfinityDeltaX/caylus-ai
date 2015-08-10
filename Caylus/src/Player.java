
public class Player {
	
	public static final Player NONE = new Player();
	
	public final PlayerColor color;
	
	private int rGrey;
	private int rPink;
	private int rGold;
	private int rBrown;
	private int rBlue;
	private int denier;
	
	public Player(Player copy){
		rGrey = copy.rGrey;
		rPink = copy.rPink;
		rGold = copy.rGold;
		rBrown = copy.rBrown;
		rBlue = copy.rBlue;
		denier = copy.denier;
	}

	public int getrGrey() {return rGrey;}

	public int getrPink() {return rPink;}

	public int getrGold() {return rGold;}

	public int getrBrown() {return rBrown;}

	public int getrBlue() {return rBlue;}

	public int getDenier() {return denier;}

	public void setrGrey(int change) {this.rGrey += change;}

	public void setrPink(int change) {this.rPink += change;}

	public void setrGold(int change) {this.rGold += change;}

	public void setrBrown(int change) {this.rBrown += change;}

	public void setrBlue(int change) {this.rBlue += change;}

	public void setDenier(int change) {this.denier += change;}

	public boolean hasResources(ResourceQuantity trade) {
		return (trade.blue <= rBlue && trade.pink <= rPink && trade.gold <= rGold && trade.brown <= rBrown && trade.grey <= rGrey && trade.denier <= denier);
	}

	public void deductResources(ResourceQuantity trade) {
		rBlue -= trade.blue;
		rGrey -= trade.grey;
		rPink -= trade.pink;
		rGold -= trade.gold;
		rBrown -= trade.brown;
		denier -= trade.denier;
	}
	
}
