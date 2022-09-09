/**
 * The PacMan
 * 
 * @author rowanrichter
 */

import java.awt.event.KeyEvent;

public class PacMan {
	
	private double x, y, oldX, oldY, radius;
	private String direction;
	
	/**
	 * Constructor -- initialize PacMan player
	 */
	public PacMan() {
		this.x = .55;
		this.y = .825;
		this.oldX = this.x;
		this.oldY = this.y;
		this.radius = .02;
		this.direction = "";
	}
	
    /**
     * Update -- moving the PacMan
     *
     * When direction key is pressed the PacMan goes that direction
     * 
     * @return void
     */
	public void update() {
		
        // Check for direction changes
        if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
            this.direction = "right";
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
            this.direction = "left";
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
            this.direction = "up";
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
            this.direction = "down";
        }
		
        // Move right
        if (this.direction.equals("right")) {
        	oldX = this.x; // save position
        	this.x += .005;
        }
        // Move left
        if (this.direction.equals("left")) {
        	oldX = this.x; // save position
            this.x -= .005;
        }
        // Move up
        if (this.direction.equals("up")) {
        	oldY = this.y; // save position
        	this.y += .005;	
        }
        // Move down
        if (this.direction.equals("down")) {
        	oldY = this.y; // save position
            this.y -=.005;
        }
	}
	
	/**
	 *  determine if PacMan has collided with a pellet
	 * @param 	pellet object p
	 * @return  true if PacMan collides with the pellet and false otherwise
	 */
    public boolean collidesWithPellet(Pellet p) {

        // Calculate edges of this PacMan
        double right = this.x + this.radius;
        double left = this.x - this.radius;
        double top = this.y + this.radius;
        double bottom = this.y - this.radius;
        

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
        
        // If all of the previous tests fail, the pellet must be in collision
        // with PacMan
        return true;
    }
    
	/**
	 *  determine if PacMan has collided with a ghost
	 * @param 	ghost object g
	 * @return  true if PacMan collides with the ghost and false otherwise
	 */
    public boolean collidesWithGhost(Ghost g) {

        // Calculate edges of this PacMan
        double right = this.x + this.radius;
        double left = this.x - this.radius;
        double top = this.y + this.radius;
        double bottom = this.y - this.radius;
        
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
        
        // If all of the previous tests fail, the ghost must be in collision
        // with the PacMan
        return true;
    }
    
    /**
     *  calculate the right side position of the PacMan
     *  
     * @return 		the position as a double 
     */
    public double right() {
        return this.x + this.radius;
    }
    
    /**
     *  calculate the left side position of PacMan
     *  
     * @return 		the position as a double 
     */
    public double left() {
        return this.x - this.radius;
    }
    
    /**
     *  calculate the top side position of PacMan
     *  
     * @return 		the position as a double 
     */
    public double top() {
        return this.y + this.radius;
    }
    
    /**
     *  calculate the bottom side position of PacMan
     *  
     * @return 		the position as a double 
     */
    public double bottom() {
        return this.y - this.radius;
    }
    
    /**
     * reset the last position of PacMan 
     * @return void
     */
    public void undoPosition() {
    	this.x = this.oldX; // extra save position
    	this.y = this.oldY; // extra save position
    	
    }
    
    /**
     * Respawn PacMan to original position 
     * @return void
     */
    public void respawnPacman() {
		this.x = .55;
		this.y = .825;
		oldX = this.x; // extra save position
		oldY = this.y; // extra save position
		this.direction = ""; // default direction back to no direction
    }
    
	
	/**
	 * Draw
	 * @return void
	 */
	public void draw() {
		StdDraw.setPenColor(250, 250, 50); // Color yellow for PacMan
		StdDraw.filledCircle(this.x, this.y, this.radius);
	}

}