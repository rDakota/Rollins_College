/**
 * The PacMan ghost
 * 
 * @author rowanrichter
 */
public class Ghost {
	
	private double x, y, dx, dy, oldX, oldY, radius;
	private String direction;
	private int red;
	private int green;
	private int blue;
	
	/**
	 * Constructor -- initialize ghost object
	 */
	public Ghost(double x, double y, int red, int green, int blue) {
		this.x = x;
		this.y = y;
		this.dx = .005;
		this.dy = .005;
		this.oldX = this.x;
		this.oldY = this.y;
		this.radius = .02;
		this.direction = "";
	    this.red = red;
	    this.green = green;
	    this.blue = blue; 
	}
	
    /**
     * Update -- moving the ghosts in random manner
     * at each of the decision positions (be they the corners or the top of bottom positions),
     * a randomized logical direction is produced for the ghost to travel
     * 
     * @return void
     */
    public void update() {
    	
    	double r = Math.random();
    	
    	// top row decision positions
    	if (this.y >= .825 && ( (this.x <= .255 && this.x >= .245) || (this.x <= .355 && this.x >= .345) ||
    			(this.x <= .455 && this.x >= .445) || (this.x <= .555 && this.x >= .545) || 
    			(this.x <= .655 && this.x >= .645) || (this.x <= .755 && this.x >= .745) )) { 
    		if (r < .33) {
    			this.direction = "right";
    		} 
    		else if (r >= .33 && r < .66) {
    			this.direction = "left";
    		}
    		else {
    			this.direction = "down";
    		}
    	}
    	
    	// bottom row decision positions
    	if (this.y <= .175 && ( (this.x <= .255 && this.x >= .245) || (this.x <= .355 && this.x >= .345) ||
    			(this.x <= .455 && this.x >= .445) || (this.x <= .555 && this.x >= .545) || 
    			(this.x <= .655 && this.x >= .645) || (this.x <= .755 && this.x >= .745) )) { 
    		if (r < .33) {
    			this.direction = "right";
    		} 
    		else if (r >= .33 && r < .66) {
    			this.direction = "left";
    		}
    		else {
    			this.direction = "up";
    		}
    	}
    	
    	// Bottom right corner
    	if (this.y <= .175 && (this.x >= .85)) {
    		if (r < .5) {
    			this.direction = "left";
    		} else {
    			this.direction = "up";
    		}
    	}
    	// Bottom left corner
    	if (this.y <= .175 && (this.x <= .15)) {
    		if (r < .5) {
    			this.direction = "right";
    		} else {
    			this.direction = "up";
    		}
    	}
    	// top right corner
    	if (this.y >= .825 && (this.x >= .85)) {
    		if (r < .5) {
    			this.direction = "left";
    		} else {
    			this.direction = "down";
    		}
    	}
    	// top left corner
    	if (this.y >= .825 && (this.x <= .15)) {
    		if (r < .5) {
    			this.direction = "right";
    		} else {
    			this.direction = "down";
    		}
    	}
    	
        // Movement right
        if (this.direction.equals("right")) {
        	oldX = this.x; // save position
        	this.x += (dx);
        }
        // Movement left
        if (this.direction.equals("left")) {
        	oldX = this.x; // save position
            this.x -= (dx);
        }
        // Movement up
        if (this.direction.equals("up")) {
        	oldY = this.y; // save position
        	this.y += (dy);
        }
        // Movement down
        if (this.direction.equals("down")) {
        	oldY = this.y; // save position
            this.y -= (dy);
        }
    }
    
    /**
     *  calculate the right side position of the ghost
     *  
     * @return 		the position as a double 
     */
    public double right() {
        return this.x + this.radius;
    }
    
    /**
     *  calculate the left side position of the ghost
     *  
     * @return 		the position as a double 
     */
    public double left() {
        return this.x - this.radius;
    }
    
    /**
     *  calculate the top side position of the ghost
     *  
     * @return 		the position as a double 
     */
    public double top() {
        return this.y + this.radius;
    }
    
    /**
     *  calculate the bottom side position of the ghost
     *  
     * @return 		the position as a double 
     */
    public double bottom() {
        return this.y - this.radius;
    }
    
    
    /**
     * reset the last position of the Ghost 
     * @return void
     */
    public void undoPosition() {
    	this.x = this.oldX; // extra save position
    	this.y = this.oldY; // extra save position
    	this.direction = "";
    }	
    
    /**
     * Respawn Ghost to original position 
     * @return void
     */
    public void respawnGhost(double x, double y) {
		this.x = x;
		this.y = y;
		oldX = this.x; // extra save position
		oldY = this.y;  // extra save position
		this.direction = ""; // default direction back to no direction
    }

	/**
	 * Draw
	 * @return void
	 */
	public void draw() {
		StdDraw.setPenColor(this.red, this.green, this.blue);
		StdDraw.filledSquare(this.x, this.y, this.radius);
	}

}