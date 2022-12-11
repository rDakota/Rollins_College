/**
 * Breakout: A Brick-Blasting Arcade Game
 *
 * @author CMS_121
 */
 
// DO NOT DIRECTLY ACCESS ANY OBJECT PROPERTIES FROM main!

public class Breakout {

    static final int NUM_ROWS = 6;
    static final int NUM_COLS = 8;

    public static void main(String[] args) {

        //*** Initialization ***//

        Ball ball = new Ball();
        Paddle paddle = new Paddle();

        // Array of Bricks
        Brick[] bricks = new Brick[NUM_ROWS * NUM_COLS];
        int numBricks = NUM_ROWS * NUM_COLS;

        // Initialize the bricks
        // Code automatically converts index i into a row-column position
        for (int i = 0; i < bricks.length; i++) {
            int row = i / NUM_COLS;
            int col = i - (NUM_COLS * row);
            
            bricks[i] = new Brick(row, col);
        }

        // Main game loop
        //
        // Score and lives are added game features
        //
        // set score at zero
        int score = 0;
        // set lives to three
        int lives = 3;

        boolean playing = true;
        
        while (playing) {
        	
        	
            //*** Update positions ***//
            ball.update();
            paddle.update();
            
            //*** Clear the board ***//
            StdDraw.clear();
        	
            
            //*** Check terminating conditions ***//
            //
            // Stop if all bricks have been destroyed
        	if (numBricks == 0) {
        		playing = false;
        		StdDraw.text(.50, .20, "You Win!");
        	}
    		// below is added game feature that decrements the lives and resets the ball 
        	// when the ball is at the bottom of the screen instead of stopping the game
        	if (ball.atBottomofScreen()) {
        		lives--;
        		// added game feature to reset the ball and decrement 
        		// the lives every time the ball goes off screen
        		ball.resetBall();
        		
        		// in most retro-computer games you still are able to play when you have zero lives
        		// so if the lives go below zero display the ending game message
                if (lives < 0) {
                    playing = false;
                    StdDraw.text(.50, .40, "Game over!");
                } 
        	}

            //*** Check for collisions ***//
        	// Make the ball reverse direction when it hits the paddle
            ball.checkPaddleCollision(paddle);

            // Check for all brick collisions
            //
            // If the ball hits the brick, reverse its direction (in the checkBrickCollision method)
            // and set the Brick to null to remove it from the board
            for (int i = 0; i < bricks.length; i++) {
                if (bricks[i] == null) {
                    continue;
                }
                
                if (ball.checkBrickCollision(bricks[i])) {
                    bricks[i]= null;
                    numBricks--;
                    // increase the speed every time an brick is eliminated using added game feature
                	ball.upVelocity();
                    // score increases by 4 for every brick that is eliminated
                    score += 4;
                }
            }
            
            
            //*** Draw the board ***//
            ball.draw();
            paddle.draw();
            
            // show score as part of added feature
            StdDraw.text(.25, .95, "Score:" + score);
            // show lives below in added feature
            //
            // only want to display the lives if they are greater or equal to zero
            // do not want to display negative lives when the game ends
            // instead in the else statement I will display a message 
            // showing that the lives have run out
            if (lives >= 0) {
                StdDraw.text(.75, .95, "Extra Lives:" + lives);
            } else {
            	StdDraw.text(.75, .95, "You Ran Out Of Lives! " );
            }
          
            // draw the bricks unless they are null
            for (int i = 0; i < bricks.length; i++) {
                if (bricks[i] == null) {
                    continue;
                } else {
                    bricks[i].draw();
                }
            }

            StdDraw.show(20);
         
        } // End of main game loop
     
    } // End of main method
 
} // End of class