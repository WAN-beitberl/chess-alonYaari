public class Board {
    // each turn change color, ask the current color(player) which piece he wants to move and where to
    // check if option is valid
    // execute and
    Piece[][] board;

    public Board() {
        this.board = new Piece[8][8];
        board[0][0] = new Rooke(0, 0, 1);
        board[0][1] = new Knight(0, 1, 1);
        board[0][2] = new Bishop(0, 2, 1);
        board[0][3] = new King(0, 3, 1);
        board[0][4] = new Queen(0, 4, 1);
        board[0][5] = new Bishop(0, 5, 1);
        board[0][6] = new Knight(0, 6, 1);
        board[0][7] = new Rooke(0, 7, 1);

        board[7][0] = new Rooke(7, 0, 2);
        board[7][1] = new Knight(7, 1, 2);
        board[7][2] = new Bishop(7, 2, 2);
        board[7][3] = new King(7, 3, 2);
        board[7][4] = new Queen(7, 4, 2);
        board[7][5] = new Bishop(7, 5, 2);
        board[7][6] = new Knight(7, 6, 2);
        board[7][7] = new Rooke(7, 7, 2);
        for (int i = 0; i <= 7; i++) {
            board[1][i] = new Pawn(1, i, 1);
            board[6][i] = new Pawn(6, i, 2);
        }

    }

    public boolean CheckClearWay(Piece p, int tox, int toy) {
        int start = p.getX();
        int starty = p.getY();
        int i;
        int countx = 0;
        int countY = 0;
        for (i = start + countx; i < tox; i++) {
            for (int j = starty + countY; j < toy; j++) {
                if (board[start + countx][starty + countY] != null) {
                    return false;
                }

            }
            if (tox < countx + start)
                countx--;
            if (tox > countx + start)
                countx++;
            if (toy < countY + starty)
                countY--;
            if (toy > countY + starty) {
                System.out.println("toy : " + toy + " countY" + countY);
                countY++;
            }
            System.out.println("count x : " + countx + " count y : " + countY);
        }

        if (i == start) // start equals to end
        {
            for (int j = starty; j < toy; j++)
            {

                if (board[start + countx][starty + countY] != null)
                {
                    return false;
                }
                if (toy < countY + starty)
                    countY--;
                if (toy > countY + starty)
                    countY++;

            }
        }
        System.out.println("trueing");
        return true;
    }



    int checkChess() // check if there is a threat on king, or if someone lost
    {
        return 0;
    }
    boolean movePiece(int fromX, int fromY, int tox, int toy)
    {
        Piece p  = board[fromX][fromY];
        // assuming its correct;
        if (p.canMove(tox,toy) && CheckClearWay(p, tox, toy))
        {

            if (board[tox][toy] == null)
            {
                board[p.getX()][p.getY()] = null;
                p.setX(tox);
                p.setY(toy);
                board[tox][toy] = p;
                System.out.println("moved to an empty place : " + tox +" , " + toy);
                return true;
            }
            else
            {
                if (p.getColor() == board[tox][toy].getColor()) {
                    System.out.println("cannot move to a place of teammate");
                    return false;
                }
                else
                {
                    // pawn eats sideways || cant move through any player (only knight can)
                    board[tox][toy] = null;
                    board[p.getX()][p.getY()] = null;
                    System.out.println("ate an enemy at : " + tox +" , " + toy);
                    board[tox][toy] = p;
                    return true;
                }
            }
           // check if the destination is empty/opponent/teamate
        }
        else{
            System.out.println("cant move");
        }
        return false;
       // check if color valid, check if can move there(depends on each piece and his movement)
    }
    public void printBoard()
    {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print("(O)");
                }
                else {
                    if (board[i][j].name.equals("king")){
                        System.out.print("G" +board[i][j].getColor() + ",");
                    }
                    else {
                        System.out.print(board[i][j].getName().toUpperCase().charAt(0));
                        System.out.print(board[i][j].getColor() + ",");
                    }
                }
            }
            System.out.println();
        }

    }

}

