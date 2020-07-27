package Assignment;

public class Property {

	private String city;
	private String owner;
	private String propertyName;
	private Double rentAmount;
	private Plot plot;
	
	// no-arg constructor
	public Property() {
		city = " ";
		owner = " ";
		propertyName = " ";
		rentAmount = (double) 0;
		this.plot = new Plot();
	}
	
	// copy constructor
	public Property(Property p) {
		this.city = p.city;
		this.owner = p.owner;
		this.propertyName = p.propertyName;
		this.rentAmount = p.rentAmount;
		this.plot = new Plot(p.plot);
	}
	
	// parameterized constructor w/o plot
	public Property(String propertyName,String city,double rentAmount,String owner) {
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		this.plot = new Plot();
	}
	
	// parameterized constructor w/ plot
	public Property(String propertyName,String city,double rentAmount,String owner, 
			                                    int x, int y, int width, int depth ) {
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		this.plot = new Plot(x,y,width,depth);
	}
	
	// get methods
	public String getCity() {
		return city;
	}
	public String getOwner() {
		return owner;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public double getRentAmount() {
		return rentAmount;
	}
	public Plot getPlot() {
		return plot;
	}
	
	// set methods

	public void setCity(String city) {
		this.city = city;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	
	// toString
	public String toString() {
		String str = "Property Name: " + propertyName +
					"\n Located in " + city +
					"\n Belonging to: " + owner +
					"\n Rent Amount: " + rentAmount;
		return str;
	}
	
}

