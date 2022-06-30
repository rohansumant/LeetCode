class Solution:
    
    def ok(self,board,x,y,opt):
        for i in range(9):
            if board[x][i] == opt or board[i][y] == opt:
                return False
        xx = x - (x%3)
        yy = y - (y%3)
        for i in range(xx,xx+3):
            for j in range(yy,yy+3):
                if board[i][j] == opt:
                    return False
        return True
    
    def solveSudoku(self, board: List[List[str]]) -> None:
        for i in range(9):
            for j in range(9):
                if board[i][j] == '.':
                    for opt in range(1,10):
                        if not self.ok(board,i,j,str(opt)):
                            continue
                        board[i][j] = str(opt)
                        solved = self.solveSudoku(board)
                        if solved:
                            return True
                        board[i][j] = '.'
                    return False
        return True
