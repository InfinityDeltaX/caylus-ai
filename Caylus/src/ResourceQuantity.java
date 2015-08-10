
public class ResourceQuantity {

	public final int grey;
	public final int pink;
	public final int gold;
	public final int brown;
	public final int blue;
	public final int denier;
	
	public ResourceQuantity(int grey, int pink, int gold, int brown, int blue, int denier) {
		this.grey = grey;
		this.pink = pink;
		this.gold = gold;
		this.brown = brown;
		this.blue = blue;
		this.denier = denier;
	}
	
	public static final ResourceQuantity NONE = new ResourceQuantity(0, 0, 0, 0, 0, 0);

}
