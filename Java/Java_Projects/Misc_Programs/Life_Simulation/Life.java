/**
 * JOHN CONWAY'S LIFE
 * 
 * Complete the class according to the instructions in the project write-up.
 * @author rowanrichter
 */

public class Life {

    // Instance variable representing the grid of cells
    private boolean[][] grid;
  
  
    /**
     * Constructor -- initialize the grid
     */
    public Life(int nRows, int nCols) {
        this.grid = new boolean[nRows][nCols]; 
    }
  
  
    /**
     * Clear the grid -- set all entries to false
     *
     * Recall: this.grid.length is the number of rows, this.grid[r].length is the number of columns
     */
    public void clear() {
        for (int r = 0; r < this.grid.length; r++) {
            for (int c = 0; c < this.grid[r].length; c++) {
                this.grid[r][c] = false; 
            }
        }
    }
    
    /**
     * Sets the cell at row r and column c to true
     * 
     * @param r
     * @param c
     */
    public void set(int r, int c) {
    	this.grid[r][c] = true;
    	
    }
    
    /**
     * 
     * @param r
     * @param c
     * @return	the value of a cell at a given position
     */
    public boolean isAlive(int r, int c) {
        return this.grid[r][c];
    }
    
    /**
     * 
     * @return  the number of rows in the grid
     */
    public int numRows() {
        return this.grid.length;
    }
    
    /**
     * 
     * @return the number of columns in the grid
     */
    public int numCols() {
    	return this.grid[0].length;

    }
    
    /**
     * Update for the next generation
     */
    public void update() {
 
        // Create a next grid that will hold the state of the cells in the next generation
        // At the end of the method, set this.grid = nextGrid;
        boolean[][] next = new boolean[this.numRows()][this.numCols()];
   
        // Loop through the entire grid
        for (int r = 0; r < this.grid.length; r++) {
            for (int c = 0; c < this.grid[r].length; c++) {
        
                // Determine the number of living neighbors of cell (r, c)
                int neighbors = 0;
        
                // Check upper-left cell, position (r - 1, c - 1)
                // Skip the cell if it would fall off the grid
                if (r > 0 && c > 0 && this.grid[r - 1][c - 1] == true) {
                    neighbors++;
                }
        
                // Check upper-middle cell, position (r - 1, c)
                if (r > 0 && this.grid[r - 1][c] == true) {
                    neighbors++; 
                }
                
                // Add cases to check the other six neighbors
                
                // Check upper-right cell, position (r - 1, c + 1)
                if (r > 0 && c < (this.grid[0].length - 1) && this.grid[r - 1][c + 1] == true) {
                	neighbors++;
                }
                
                // Check left cell, position (r, c - 1)
                if (c > 0 && this.grid[r][c - 1] == true) {
                    neighbors++;
                }
                
                // Check right cell, position (r, c + 1)
                if (c < (this.grid[0].length - 1) && this.grid[r][c + 1] == true) {
                	neighbors++;
                }
                
                // Check bottom-left cell, position(r + 1, c - 1)
                if (r < (this.grid.length - 1) && c > 0 && this.grid[r + 1][c - 1] == true) {
                	neighbors++;
                }
                
                // Check bottom cell, position(r + 1, c)
                if (r < (this.grid.length - 1) && this.grid[r + 1][c] == true) {
                	neighbors++;
                }
                
                // Check bottom-right cell, position(r + 1, c + 1)
                if (r < (this.grid.length - 1) && c < (this.grid[0].length - 1) && this.grid[r + 1][c + 1] == true) {
                	neighbors++;
                }
                
                // Add rules to determine if cell lives or dies in the next generation
                // Set next[r][c] to true or false 
                
                // if the cell is alive and there are less then 2 neighbors 
                // or 
                // greater than 3 neighbors then that cell dies
                // 
                // else if the cell is alive and there are 2 or 3 neighbors
                // then the cell stays alive
                if (this.grid[r][c] == true && (neighbors < 2 || neighbors > 3)) {
                	next[r][c] = false;
                } else if (this.grid[r][c] == true && (neighbors >=2 && neighbors <= 3)) {
                	next[r][c] = true;
                }
                
                // if the cell is dead and there are exactly 3 neighbors
                // then that cell becomes alive
                //
                // else if the cell is dead and there are not exactly 3 neighbors
                // then the cell stays dead
                if (this.grid[r][c] == false && neighbors == 3) {
                	next[r][c] = true;
                } else if (this.grid[r][c] == false && neighbors != 3) {
                	next[r][c] = false;
                }
                                
            }
        }   
   
        // Make next the active grid in the next generation
        this.grid = next;
   
    }
  
}