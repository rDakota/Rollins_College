/**
 * The Pacman pellet
 * 
 * @author rowanrichter
 */
public class Pellet {
	
	private double x, y, radius;
	
	/**
	 * Constructor for the pellet object
	 * 
	 * @param newX 		
	 * @param newY		
	 */
	public Pellet(double newX, double newY) {
		this.x = newX;
		this.y = newY;
		this.radius = .0075;
	}
	
    /**
     *  calculate the right side position of the pellet
     *  
     * @return 		the position as a double 
     */
    public double right() {
        return this.x + this.radius;
    }
    
    /**
     *  calculate the left side position of the pellet
     *  
     * @return 		the position as a double 
     */
    public double left() {
        return this.x - this.radius;
    }
    
    /**
     *  calculate the top side position of the pellet
     *  
     * @return 		the position as a double 
     */
    public double top() {
        return this.y + this.radius;
    }
    
    /**
     *  calculate the bottom side position of the pellet
     *  
     * @return 		the position as a double 
     */
    public double bottom() {
        return this.y - this.radius;
    }
	
    /**
     * Draw
     * @return void
     */
	public void draw() {
		StdDraw.setPenColor(250, 250, 250);
		StdDraw.filledCircle(this.x, this.y, this.radius);
	}
}