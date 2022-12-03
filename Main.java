import java.util.Scanner;




public class Main {
    static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {

        boolean turn = true;
        int cnt = 0;

        Board board = new Board();
        board.printBoard();
        Queen queen = new Queen(2,2,2);
        board.CheckClearWay(queen, 5, 5);
        while (cnt < 100)
        {
        int fromX, fromY;
        int corX, corY;
        if (turn) // player1
        {
            System.out.println("P1: input cordinates of piece to move ");
            fromX = reader.nextInt();
            fromY = reader.nextInt();
            System.out.println("P1: input where you want to move to ");
            corX = reader.nextInt();
            corY = reader.nextInt();

            board.movePiece(fromX, fromY, corX, corY);
            board.printBoard();
            turn = !turn;
            cnt++;
        }
        else
            {
            System.out.println("P2: input cordinates of piece to move ");
            fromX = reader.nextInt();
            fromY = reader.nextInt();
            System.out.println("P2: input where you want to move to ");
            corX = reader.nextInt();
            corY = reader.nextInt();

            board.movePiece(fromX, fromY, corX, corY);
            board.printBoard();
            turn  = !(turn);
            cnt++;
        }
       }
    }
}