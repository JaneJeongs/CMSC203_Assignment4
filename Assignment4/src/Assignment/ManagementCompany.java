package Assignment;

public class ManagementCompany {
	private int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name;
	private Property[] properties;
	private String taxID;
	private int MGMT_WIDTH = 10;
	private int MGMT_DEPTH = 10;
	private Plot plot;
	
	
	
	// Constructors
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.plot = new Plot(0,0,10,10);
		this.properties = new Property[MAX_PROPERTY];
	}
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(0,0,10,10);
		this.properties = new Property[MAX_PROPERTY];
	}
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(x,y,width,depth);
		this.properties = new Property[MAX_PROPERTY];
	}
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.plot = otherCompany.plot;
		this.properties = otherCompany.properties;
	}
	
	// get methods
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	
	// add properties
	public int addProperty(Property property) {
		int checker = 0;
		Property newProperty = new Property(property);
		Plot newPlot = new Plot(plot);
		for (int i = 0; i <MAX_PROPERTY; i++) {
			properties[i] = property;
			if (i >= MAX_PROPERTY) {
				checker = -1;
			} else if (property == null) {
				checker = -2;
			} else if (newPlot.encompasses(newProperty.getPlot())) {
				checker = -3;
			} else if(newPlot.overlaps(newProperty.getPlot())) {
				checker = -4;
			} else {
				properties[i] = newProperty;
				checker = i;
			}
		}
		return checker;

	}

	
	public int addProperty(String name, String city, double rent, String owner, int x,int y,int width,int depth ) {
		Property newProperty = new Property(name,city,rent,owner,x,y,width,depth);
		Plot newPlot = new Plot(x,y,width,depth);
		int checker = 0;
		for (int i = 0; i <= MAX_PROPERTY; i++) {
			if(i==MAX_PROPERTY) {
				checker = -1;
			} else if (name == null && city == null && rent == 0 && owner == null && x == 0 && y ==0 && width == 0 && depth == 0) {
				checker = -2;
			} else if (newPlot.encompasses(newProperty.getPlot())) {
				checker = -3;
			} else if (newPlot.overlaps(newProperty.getPlot())) {
				checker = -4;
			} else {
				properties[i] = newProperty;
				checker = i;
			}
		}
		return checker;
	}
	
	public double totalRent() {
		double totalRent=0.0;
		for (int i = 0;  i < properties.length; i++) {
			totalRent += properties[i].getRentAmount();
		}
		return totalRent;
	}
	
	public double maxRentProp() {
		double maxRent = properties[0].getRentAmount();
		for (int i = 0; i < properties.length; i++) {
			if(maxRent > properties[i].getRentAmount()) {
				maxRent = properties[i].getRentAmount();
			}
		}
		return maxRent;
	}
	
	public int maxRentPropertyIndex() {
		int maxRentIndex = 0;
		//double maxRent = 0.0;
		for (int i = 0; i < properties.length; i++) {
			if(properties[i].getRentAmount() > properties[i+1].getRentAmount()) {
				//double maxRent = properties[i].getRentAmount();
				maxRentIndex = i;
			}
		}
		return maxRentIndex;
	}
	
	public String displayPropertyAtIndex(int i) {
		String str = "Owner: " + properties[i].getOwner() +
						"\n City: " + properties[i].getCity() +
						"\n Property Name: " + properties[i].getPropertyName() +
						"\n Rent Amount: " + properties[i].getRentAmount();
		return str;
		
	}
	
	public String toString() {
		String str = "";
		for (int i = 0; i < properties.length; i++) {
			String propertyName = properties[i].getPropertyName();
			String location = properties[i].getCity();
			String owner = properties[i].getOwner();
			double rent = properties[i].getRentAmount();
			str += "List of the properties for " + name + ", taxID: " + taxID +
					"\n" +
					"Property Name: " + propertyName +
					"\n  Located in: " + location + 
					"\n  Belonging to: " + owner +
					"\n  Rent Amount: " + rent;
			
		}
		return str;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	public Plot getPlot() {
		// TODO Auto-generated method stub
		return plot;
	}
}
