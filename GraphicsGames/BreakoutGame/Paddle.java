/**
 * The Breakout Paddle
 *
 * @author CMS_121
 */
 
import java.awt.event.KeyEvent;

public class Paddle {

    //*** Instance variables ***//
    private double x, y;
    private double halfWidth, halfHeight;
    private final double STEP = .02;  // Distance to move on each key press

    /**
     * Construct a new Paddle
     */
    public Paddle() {
        this.x = .5;
        this.y = .01;
        this.halfWidth = .10;
        this.halfHeight = .01;
    }

    /**
     * Update -- move the Paddle
     *
     * Check for left and right arrow presses StdDraw.isKeyPressed
     * @return void
     */
    public void update() {

        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)){
            this.x -= STEP;    
        }
        
        if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
            this.x += STEP;    
        }
    }

    /**
     *  calculate the right side position of the paddle
     *  
     * @return 		the position as a double 
     */
    public double right() {
        return this.x + this.halfWidth;
    }
    
    /**
     *  calculate the left side position of the paddle
     *  
     * @return 		the position as a double 
     */
    public double left() {
        return this.x - this.halfWidth;
    }
    
    /**
     *  calculate the top side position of the paddle
     *  
     * @return 		the position as a double 
     */
    public double top() {
        return this.y + this.halfHeight;
    }
    
    /**
     *  calculate the bottom side position of the paddle
     *  
     * @return 		the position as a double 
     */
    public double bottom() {
        return this.y - this.halfHeight;
    }

    /**
     * Draw
     * @return void
     */
    public void draw() {
        StdDraw.filledRectangle(this.x, this.y, this.halfWidth, this.halfHeight);
    }

}