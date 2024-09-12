

public class Sudoko {

	public static boolean isvalid(int[][] board,int rows, int cols,int num) {
		for(int c=0;c<9;c++) {
			if(board[rows][c]==num) {
				return false;
			}
		}
		for(int r=0;r<9;r++) {
			if(board[r][cols]==num) {
				return false;
			}
		}
		 int startR = 3 * (rows / 3);
	     int startC = 3 * (cols / 3);
	     for (int r = startR; r < startR + 3; r++) {
	            for (int c = startC; c < startC + 3; c++) {
	                if (board[r][c] == num) {
	                    return false;
	                }
	            }
	     }
	     return true;
	}
    public static boolean solveSudoku(int[][] board) {
        for (int rows = 0; rows < 9; rows++) {
            for (int cols = 0; cols < 9; cols++) {
                if (board[rows][cols] == 0) { 
                    for (int num = 1; num <= 9; num++) { 
                        if (isvalid(board, rows, cols, num)) {
                            board[rows][cols] = num; 

                            
                            if (solveSudoku(board)) {
                                return true;
                            }
                            board[rows][cols] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true; 
    }
    public static void printBoard(int[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                System.out.print(board[r][c] + " ");
                
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] sudokuBoard = {
            {5, 0, 4, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        System.out.println("Unsolved Sudoko:");
        printBoard(sudokuBoard);
        System.out.println("");
        if (solveSudoku(sudokuBoard)) {
            System.out.println("Sudoku solved successfully:");
            printBoard(sudokuBoard);
        } else {
            System.out.println("No solution exists");
        }
    }
}

