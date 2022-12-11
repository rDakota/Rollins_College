/**
 * The PacMan wall
 * 
 * @author rowanrichter
 */
public class Wall {
	
	private double x, y, halfWidth, halfHeight;
	
	/**
	 * Constructor for Wall object
	 * @param newX
	 * @param newY
	 * @param newWidth
	 * @param newHeight
	 */
	public Wall(double newX, double newY, double newWidth, double newHeight) {
		this.x = newX;
		this.y = newY;
		this.halfWidth = newWidth;
		this.halfHeight = newHeight;
	}
	
	/**
	 * determine if the wall collides with the PacMan object
	 * 
	 * @param 		PacMan object p 
	 * @return		true if the wall collides with the PacMan and false otherwise
	 */
	public boolean collidesWithPacman(PacMan p) {

	    // Calculate edges of this wall
	    double right = this.x + this.halfWidth;
	    double left = this.x - this.halfWidth;
	    double top = this.y + this.halfHeight;
	    double bottom = this.y - this.halfHeight;
	        
	    if (p.right() < left) {
	        return false;
	    }
	        
	    if (p.left() > right) {
	        return false;
	    }
	      
	    if (p.top() < bottom) {
	        return false;
	    }
	        
	    if (p.bottom() > top) {
	        return false;
	    }
	        
	    // If all of the previous tests fail, the PacMan must be in collision
	    // with the wall
	    return true;
	}
	   
	/**
	 * determine if the wall collides with the ghost object
	 * 
	 * @param 		ghost object g 
	 * @return		true if the wall collides with the ghost and false otherwise
	 */
	public boolean collidesWithGhost(Ghost g) {

	    // Calculate edges of this wall
	    double right = this.x + this.halfWidth;
	    double left = this.x - this.halfWidth;
	    double top = this.y + this.halfHeight;
	    double bottom = this.y - this.halfHeight;
	        
	    if (g.right() < left) {
	        return false;
	    }
	        
	    if (g.left() > right) {
	        return false;
	    }
	      
	    if (g.top() < bottom) {
	        return false;
	    }
	        
	    if (g.bottom() > top) {
	        return false;
	    }
	        
	    // If all of the previous tests fail, the ghost's must be in collision
	    // with the wall
	    return true;
	}
	
	
	/**
	 * Draw
	 * @return void
	 */
	public void draw() {
		StdDraw.setPenColor(20, 100, 225);
		StdDraw.filledRectangle(this.x, this.y, this.halfWidth, this.halfHeight);
	}

}