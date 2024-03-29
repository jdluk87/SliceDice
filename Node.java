public class Node{
	private double x0, x1;
	private double y0, y1;
	private int children = 0;
	
	public Node(){}
	
	public double getX0() {
		return x0;
	}
	
	public void setX0(double x0) {
		this.x0 = x0;
	}
	
	public double getX1() {
		return x1;
	}
	
	public void setX1(double x1) {
		this.x1 = x1;
	}
	
	public double getY0() {
		return y0;
	}
	
	public void setY0(double y0) {
		this.y0 = y0;
	}
	
	public double getY1() {
		return y1;
	}
	
	public void setY1(double y1) {
		this.y1 = y1;
	}
	
	public int getChildren() {
		return children;
	}
	
	public void setChildren(int children) {
		this.children = children;
	}
}