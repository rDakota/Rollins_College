/**
 * The main method for the PacMan project
 * 
 * @author rowanrichter
 */

public class Game {
	
    static final int NUM_WALLS = 11;
    static final int NUM_PELLETS = 40;
    static final int NUM_GHOSTS = 4;
	
	public static void main(String[] args) {
		
		// Initialize objects
		PacMan pacman = new PacMan();
		
		// initialize array of ghosts
		Ghost[] ghosts = new Ghost[NUM_GHOSTS];
		
		// initialize ghost positions, and colors
		ghosts[0] = new Ghost(.15, .825, 250, 25, 25); // red -- blinky
		ghosts[1] = new Ghost(.15, .175, 51, 204, 255); // cyan -- inky
		ghosts[2] = new Ghost(.85, .175, 255, 105, 180); // pink -- pinky
		ghosts[3] = new Ghost(.85, .825, 255, 153, 0); // orange -- clyde
		
		// initialize array of walls
		Wall[] walls = new Wall[NUM_WALLS];
		
		// wall positions
		walls[0] = new Wall(.1, .5, .02, .40);
		walls[1] = new Wall(.2, .5, .02, .30);
		walls[2] = new Wall(.3, .5, .02, .30);
		walls[3] = new Wall(.4, .5, .02, .30);
		walls[4] = new Wall(.5, .5, .02, .30);
		walls[5] = new Wall(.6, .5, .02, .30);
		walls[6] = new Wall(.7, .5, .02, .30);
		walls[7] = new Wall(.8, .5, .02, .30);
		walls[8] = new Wall(.9, .5, .02, .40);
		walls[9] = new Wall(.5, .875, .40, .02);
		walls[10] = new Wall(.5, .125, .40, .02);

		
		// initializing pellets
		// use of modulo and int-division to place the pellets in specific positions on my board
		Pellet[] pellets = new Pellet[NUM_PELLETS];
		int numPellets = NUM_PELLETS;
		for (int i = 0; i < pellets.length; i++) {
			double x = .15 + (.1 * ((i / 5)));
			double y = .25 + (.125 * ((2 * i) % 5));	
			
			pellets[i] = new Pellet(x, y);
		}
		
		// initialize lives
		int lives = 2;
		
		boolean playing = true;
		while (playing) {
			
			//*** Check for collisions ***//
			for (int i = 0; i < ghosts.length; i++) {
				if (pacman.collidesWithGhost(ghosts[i])) {
					lives --;
					// respawn the PacMan
					pacman.respawnPacman();
					// respawn the ghosts to their initial positions
					ghosts[0].respawnGhost(.15, .825);
					ghosts[1].respawnGhost(.15, .175);
					ghosts[2].respawnGhost(.85, .175);
					ghosts[3].respawnGhost(.85, .825);
					
				}
			}
			
			// loop to set pellets to null if they are eaten, continue if they are already null
			// also reduce the running total numPellets by one each time a pellet is eaten
            for (int i = 0; i < pellets.length; i++) {
                if (pellets[i] == null) {
                    continue;
                }
                if (pacman.collidesWithPellet(pellets[i])) {
                    pellets[i]= null;
                    numPellets--;
                }
            }
			
			//*** Update positions ***//
			
            // PacMan update
			pacman.update();
			// wall array update
			for (int i = 0; i < ghosts.length; i++) {
				ghosts[i].update();
			}

			// if any wall collides with pacman undo pacman's position using the method
			for (int i = 0; i < walls.length; i++) {
				if (walls[i].collidesWithPacman(pacman)) {
					pacman.undoPosition();
				}
			}
			
			// May not need because encoded ghosts to follow relatively set pattern inside of the walls
			// included anyways in case unintended collision with wall occurs
			//
			// if any wall collides with a ghost object undo the ghosts position using the method
			for (int i = 0; i < walls.length; i++) {
				for (int n = 0; n < ghosts.length; n++) {
					if (walls[i].collidesWithGhost(ghosts[n])) {
						ghosts[n].undoPosition();
					}
												
				}
			}


			//*** Animate all elements ***//
			StdDraw.clear();
			
			StdDraw.setPenColor(0, 0, 0);
			StdDraw.filledRectangle(.5, .5, .5, .5);
			
			// draw PacMan
			pacman.draw();
			
			// draw ghosts
			for (Ghost g: ghosts) {
				g.draw();
			}
			
			// if the pellets are all gone then you win
            if (numPellets == 0) {
            	playing = false;
            	StdDraw.setPenColor(250, 250, 50);
            	StdDraw.text(.5, .05, "You Win!");
            	
            }
            
            // if the extra lives go below zero then the game ends game over
            if (lives < 0) {
                playing = false;
                StdDraw.setPenColor(250, 250, 50);
                StdDraw.text(.5, .05, "Game over!");
            } 
			
            // draw title
            StdDraw.setPenColor(250, 250, 50);
            StdDraw.text(.3, .95, "PacMan"); 
            
            // display lives is greater or equal to 0
            if (lives >= 0) {
                StdDraw.text(.7, .95, "Extra Lives:" + lives);
            // display message saying you ran out of all lives
            } else {
            	StdDraw.text(.7, .95, "You Ran Out Of Lives! " );
            } 
			
            // draw the pellets using enhanced for loop
			for (Pellet p : pellets) {
				if (p != null) {
					p.draw();
				}
			}
			
			// draw the walls using an enhanced for loop
			for (Wall w : walls) {
				w.draw();
			}
			
			// delay
			StdDraw.show(20);
		}
		
	}

}