class Solution {
    int[][] nextGenerationBoard;
    int n;
    int m;
    
    public void gameOfLife(int[][] board) {
        n = board.length;
        m = board[0].length; 

        nextGenerationBoard = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <m; j++) {
                nextGenerationBoard[i][j] = getNextGeneration(i, j, board);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <m; j++) {
                board[i][j] = nextGenerationBoard[i][j];
            }
        }
    }

    public int getNextGeneration(int i, int j, int[][] board) {
        int[] dx = {1, -1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};

        int liveNeighborCount = 0;
        for(int k = 0; k < 8; k++) {
            int neighborX = i + dx[k];
            int neighborY = j + dy[k];

            if(neighborX < 0 || neighborX >= n || neighborY < 0 || neighborY >= m) 
                continue;

            if(board[neighborX][neighborY] == 1) 
                liveNeighborCount++;
        }

        if(board[i][j] == 1) {
            if(liveNeighborCount < 2) return 0;
            if(liveNeighborCount <= 3) return 1;
            if(liveNeighborCount > 3) return 0;
        } 

        if(board[i][j] == 0) {
            if(liveNeighborCount == 3) return 1;
            return 0;
        }

        return 0;
    }
}