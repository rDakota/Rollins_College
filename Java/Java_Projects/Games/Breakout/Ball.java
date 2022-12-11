/**
 * The Breakout Ball
 *
 * @author CMS_121
 */
 
public class Ball {

    //*** Instance variables ***//
    private double x, y;
    private double radius;
    private double dx, dy;

    /**
     * Constructor -- initialize a new Ball
     */
    public Ball() {
        this.x = .5;
        this.y = .10;
        this.radius = .01;
        this.dx = .005;
        this.dy = .005;
    }
    
    /**
     * Update -- move the ball and reflect off of the sides
     *
     * Look at the BouncingBall and Pong examples
     * 
     * @return void
     */
    public void update() {
    	
    	// reflect off top of screen
        if (this.y + this.radius > 1.0) {
            this.dy = -this.dy;

        }
    	// reflect off of each side of the screen
        if (this.x + this.radius > 1.0 || this.x - this.radius < 0.0) {
            this.dx = -this.dx;

        }
        
        this.x += this.dx;
        this.y += this.dy;

    }
    
    /**
     * (added game feature)
     * Reset the position of the ball to original
     * starting position and reflect the ball back toward the bricks
     * 
     * @return void
     */
    public void resetBall() {
  	  this.x = .5;
  	  this.y = .10;
  	  this.dy = -this.dy;
    }
    
    /**
     * (added game feature)
     * increase the velocity of the ball by rate of 1.08
     * do not let the dx velocity go above .01 or the dy velocity
     * 
     * @return void
     */
    public void upVelocity() {
        if (this.dx <= .01 && this.dy <= .005) {
      	  this.dx *= 1.07;
      	  this.dy *= 1.07;
        }
    }

    /**
     * Check if this Ball collides with the Paddle
     *
     * If so, reverse the Ball's y velocity
     *
     * Look at the examples from Secret Collect and Pong
     * 
     * @return  nothing, this method only updates the Ball's dy data member
     */
    public void checkPaddleCollision(Paddle paddle) {
    	
        // Calculate edges of the ball
        double right = this.x + this.radius;
        double left = this.x - this.radius;
        double top = this.y + this.radius;
        double bottom = this.y - this.radius;
        
        if (paddle.right() < left) {
            return;
        }
        
        if (paddle.left() > right) {
            return;
        }
      
        if (paddle.top() < bottom) {
            return;
        } 
        
        if (paddle.bottom() > top) {
            return;
        }
        
        // reflect the ball if all the other if statements fail
        // meaning that the ball must have hit the paddle and thus should be reflected
        this.dy = -this.dy;
    }
    
    /**
     * Check if this Ball collides with the given Brick
     *
     * Similar to testing for Paddle collisions, but this method
     * returns a boolean indicating if the collision happened
     *
     * @return  false if no collision, true otherwise
     */
    public boolean checkBrickCollision(Brick brick) {
    	
        // Calculate edges of the ball
        double right = this.x + this.radius;
        double left = this.x - this.radius;
        double top = this.y + this.radius;
        double bottom = this.y - this.radius;
        

        if (brick.right() < left) {
            return false;
        }
        
        if (brick.left() > right) {
            return false;
        }
      
        if (brick.top() < bottom) {
            return false;
        }
        
        if (brick.bottom() > top) {
            return false;
        }
        
        // If all of the previous tests fail, the ball must be in collision
        // with the brick
        // reverse the direction of the ball and return true
        this.dy = -this.dy;
        return true;
    }
    
    /**
     * Check if the ball is still in play or not 
     * 
     * @return 		true if the ball is at the below where it should be, 
     * 				return false otherwise (ball still in play)
     */
    public boolean atBottomofScreen() {
    	if (this.y - this.radius < 0.0) {
    		return true;
    	}
    	return false;
    }
     
    /**
     * Draw
     * @return void
     */
    public void draw() {
        StdDraw.filledCircle(this.x, this.y, this.radius);
    }

}