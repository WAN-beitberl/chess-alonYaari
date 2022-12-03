import java.util.*;
abstract class Piece {
    int color;
    int x;
    int y;
    String name;

    public Piece(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    boolean differenceCases(int tox, int toy)
    {
        int nxDifference = Math.abs(this.x - tox);
        int nyDifference = Math.abs(this.y - toy);
        switch (this.getName())
        {
            case "queen":
                if (nxDifference == 0 || nyDifference == 0 || nxDifference == nyDifference)
                {
                    return (true);
                }
                return (false);

            case "king":
                if (nyDifference <= 1 && nxDifference <= 1)
                {
                    return true;
                }
                return false;
            case "bishop":
                if (nyDifference == nxDifference)
                {
                    return (true);
                }
                return (false);

            case "knight":

                if ((nyDifference == 2 && nxDifference == 1) || (nyDifference == 1 && nxDifference == 2))
                {
                    return (true);
                }
                return (false);

            case "rook":
                if ((nyDifference == 0 && nxDifference > 0) || (nxDifference == 0 && nyDifference > 0))
                {
                    return true;
                }
                return false;

            case "pawn":
                System.out.println("nx diff : " + nxDifference + " nydiff: " + nyDifference);
                if (nyDifference == 0 && tox == this.getX()+ 1)
                {
                    return (true);
                }
                else if(this.getY() == 1 &&  tox == this.getX() +2 )
                {
                    return true;
                }
                    return false;

        }
        return false;
    }
    boolean canMove(int tox, int toy)
    {
        if (tox < 0 || 7 < tox || toy < 0 || 7 < toy)
        {
            System.out.println("Error: Invalid tile:  "+tox +","+  toy);
            return false;
        }
        return true;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Queen extends Piece {
    public Queen(int x, int y, int color) {
        super(x, y, color);
        this.name = "queen";
    }

    @Override
    boolean canMove(int tox, int toy) {
        if (super.canMove(tox, toy) && differenceCases(tox, toy)) //
        {
            System.out.println("can move");
        }
        else{
            System.out.println("cant move");
            return false;
        }
        return true;

    }

}
class King extends Piece {
    public King(int x, int y, int color) {
        super(x, y, color);
        this.name = "king";
    }

    @Override
    boolean canMove(int tox, int toy) {
        if (super.canMove(tox, toy) && differenceCases(tox, toy)) //
        {
            System.out.println("can move");

        } else {
            return false;
        }
        return true;

    }
}

    class Bishop extends Piece {
        public Bishop(int x, int y, int color) {
            super(x, y, color);
            this.name = "bishop";
        }

        @Override
        boolean canMove(int tox, int toy) {
            if (super.canMove(tox, toy) && differenceCases(tox, toy)) //
            {
                System.out.println("can move");
            } else {
                return false;
            }
            return true;
        }

    }

    class Rooke extends Piece {
        public Rooke(int x, int y, int color) {
            super(x, y, color);
            this.name = "rooke";
        }

        @Override
        boolean canMove(int tox, int toy) {
            if (super.canMove(tox, toy) && differenceCases(tox, toy)) //
            {
                System.out.println("can move");
            } else {
                return false;
            }
            return true;
        }
    }

    class Knight extends Piece {
        public Knight(int x, int y, int color) {
            super(x, y, color);
            this.name = "knight";
        }

        @Override
        boolean canMove(int tox, int toy) {
            if (super.canMove(tox, toy) && differenceCases(tox, toy)) //
            {
                System.out.println("can move");
            } else {
                return false;
            }

            return true;
        }
    }



    class Pawn extends Piece {
        public Pawn(int x, int y, int color) {
            super(x, y, color);
            this.name = "pawn";
        }

        @Override
        boolean canMove(int tox, int toy) {
            if (super.canMove(tox, toy) && differenceCases(tox, toy)) //
            {
                System.out.println("can move");
            }
            else
            {
                return false;
            }
            return true;
        }
    }