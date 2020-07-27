package Assignment;

public class Plot {
	private int x;
	private int y;
	private int width;
	private int depth;
	
	// no-arg constructor
	public Plot() {
		x=0;
		y=0;
		width=1;
		depth=1;
	}
	//copy constructor
	public Plot(Plot p) {
		this.x = p.x;
		this.y = p.y;
		this.width = p.width;
		this.depth = p.depth;
	}
	//parameterized constructor
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	//check if plots overlaps
	// 8 overlapping scenarios
	public boolean overlaps(Plot plot) {

		boolean AOverlapsXY1, AOverlapsXY2, BOverlapsXY1, BOverlapsXY2,COverlapsXY1
		, COverlapsXY2, DOverlapsXY1, DOverlapsXY2;

		AOverlapsXY1 = (plot.x >= x && plot.x < (x+width)) && (plot.y >= y && plot.y < (y+depth));
		AOverlapsXY2 = (x >= plot.x && x < (plot.x + width)) && (y >= plot.y && y < (plot.depth + plot.y));

		BOverlapsXY1 = (plot.x + plot.width) > x && (plot.x + plot.width) < (x + width) && plot.y >= y && plot.y <= (y + depth);
		BOverlapsXY2 = (x + width) > plot.x && (x + width) < (plot.x + plot.width) && y>= plot.y && y <= (plot.y + plot.depth);

		COverlapsXY1 = plot.x >= x && plot.x < (x + width) && (plot.y + plot.depth) > y && (plot.y + plot.depth) <= (y + depth);
		COverlapsXY2 = x >= plot.x && x < (plot.x + plot.width) && (y + depth) > plot.y && (y + depth) <= (plot.y + plot.depth);

		DOverlapsXY1 = (plot.x + plot.width) > x && (plot.x +plot.width) <= (x + width) && (plot.y + plot.depth) > y && (plot.y + plot.depth) <= (y + depth);
		DOverlapsXY2 = (x + width) > plot.x && (x + width) <= (plot.x + plot.width) && (y + depth) > plot.y && (y + depth) <= (plot.y + plot.depth);

	
		return AOverlapsXY1 || AOverlapsXY2 || BOverlapsXY1 || BOverlapsXY2 || COverlapsXY1
		|| COverlapsXY2 || DOverlapsXY1 || DOverlapsXY2;
		
	}
	
	//check if input plot is inside current plot
	// four encompassing scenarios
	public boolean encompasses(Plot plot) {
		
		boolean newX, newY, newWidth, newDepth;
		newX = plot.x >= x;
		newY = plot.y >= y;
		newWidth = (plot.x + plot.width) <= (x + width);
		newDepth = (plot.y + plot.depth) <= (y + depth);
		return newX && newY && newWidth && newDepth;
		
	}
	
	// set methods
	public void setX(int x) {
		this.x=x;
	}
	public void setY(int y) {
		this.y=y;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	// get methods
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getDepth() {
		return depth;
	}
	
	public String toString() {
	String str = "Upper Left: (" + x + "," + y + ")" +
	" Width: " + width + " Depth: " + depth;
	return str;
	}
	
	
}
