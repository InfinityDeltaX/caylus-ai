
public class Favors {
	private int pointRank;
	private int denierRank;
	private int blockRank;
	private int buildRank;
	
	public Favors(Favors copy) {
		this.pointRank = copy.pointRank;
		this.denierRank = copy.denierRank;
		this.blockRank = copy.blockRank;
		this.buildRank = copy.buildRank;
	}
	
	public void increasePointRank(){pointRank++;}
	public void increaseDenierRank(){denierRank++;}
	public void increaseBlockRank(){blockRank++;}
	public void increaseBuildRank(){buildRank++;}
}
