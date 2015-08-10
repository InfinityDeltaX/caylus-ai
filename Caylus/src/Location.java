
public class Location {
	private Property property;
	private Player owner;
	
	public Location(Property property, Player owner) {
		this.property = property;
		this.owner = owner;
	}

	public Location(Location copy) {
		this.owner = new Player(copy.owner);
		this.property = new Property(copy.property);
	}
}
