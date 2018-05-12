/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb.hu.ataxx.model;

/**
 * Ez az osztály tartalmazza a játék logikáját.
 *
 * Itt található a játék kezdőállapotának inicializálása, a lépések kezelése,
 * a végállapot felismerése, valamint a játékhoz szükséges egyéb információk.
 * 
 * @author Hegedűs Attila
 */
public class Game {

    /**
     * Inicializálja a játéktábla szélességét 7 mezőre.
     */
    private static int WIDTH = 7;
    /**
     * Inicializálja a játéktábla magasságát 7 mezőre.
     */
    private static int HEIGHT = 7;

    /**
     * Logikai érték, hogy melyik az aktuális játékos.
     * 
     * True, ha a piros terültekkel rendelkező játékos lép,
     * False ha a kék területtekkel rendelkező játékos.
     */
    private static boolean isCurrentRed;
    /**
     * A két játékos pontszámainak tárolására használt változók.
     */
    private static int redPoints, bluePoints;

    /**
     * Visszaadja a játéktábla szélességét a mezők számában mérve.
     * 
     * @return a játéktábla szélessége egész számban
     */
    public static int getWIDTH() {
        return WIDTH;
    }

    /**
     * Megadhatjuk a játéktábla szélességét a mezők számában mérve.
     * 
     * @param WIDTH a tábla szélessége
     */
    public static void setWIDTH(int WIDTH) {
        Game.WIDTH = WIDTH;
    }

    /**
     * Visszaadja a játéktábla magasságát a mezők számában mérve.
     * 
     * @return a játéktábla magassága egész számban
     */
    public static int getHEIGHT() {
        return HEIGHT;
    }

    /**
     * Megadhatjuk a játéktábla magasságát a mezők számában mérve.
     * 
     * @param HEIGHT a tábla magassága
     */
    public static void setHEIGHT(int HEIGHT) {
        Game.HEIGHT = HEIGHT;
    }

    /**
     * Visszaadja, hogy jelenleg a piros területekkel rendelkező játékos
     * következik-e lépni.
     * 
     * @return true, ha a piros következik lépni
     */
    public static boolean isIsCurrentRed() {
        return isCurrentRed;
    }

    /**
     * Megadhatjuk, hogy jelenleg a piros területekkel rendelkező játékos
     * következzen-e lépni.
     * 
     * @param isCurrentRed logikai érték arról, hogy a piros játékos-e az aktuális
     * játékos.
     */
    public static void setIsCurrentRed(boolean isCurrentRed) {
        Game.isCurrentRed = isCurrentRed;
    }

    /**
     * Visszaadja a piros területekkel rendelkező játékos mezőinek a számát.
     * 
     * @return a piros mezők száma
     */
    public static int getRedPoints() {
        return redPoints;
    }

    /**
     * Megadhatjuk a piros területekkel rendelkező játékos mezőinek a számát.
     * 
     * @param redPoints a piros mezők száma
     */
    public static void setRedPoints(int redPoints) {
        Game.redPoints = redPoints;
    }

    /**
     * Visszaadja a kék területekkel rendelkező játékos mezőinek a számát.
     * 
     * @return a kék mezők száma
     */
    public static int getBluePoints() {
        return bluePoints;
    }

    /**
     * Megadhatjuk a kék területekkel rendelkező játékos mezőinek a számát.
     * 
     * @param bluePoints a kék mezők száma
     */
    public static void setBluePoints(int bluePoints) {
        Game.bluePoints = bluePoints;
    }

    /**
     * Visszaadja a tábla összes mezejét mátrixalakban.
     * 
     * @return a játéktábla mátrix formában
     */
    public static Tile[][] getBoard() {
        return board;
    }

    /**
     * Megadhatjuk a tábla összes mezejét mátrix alakban.
     * 
     * @param board a játéktábla mátrix formában
     */
    public static void setBoard(Tile[][] board) {
        Game.board = board;
    }

    /**
     * Az osztály konstruktora.
     * 
     * Két egész számot megadva beállítja a leendő játéktábla
     * szélességét és magasságát.
     *
     * @param width a játéktábla szélessége
     * @param height a játéktábla magassága
     */
    public Game(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
    }

    /**
     * Létrehoz egy új táblát a konstruktorban megadott szélességgel
     * és magassággal.
     */
    public static Tile[][] board = new Tile[WIDTH][HEIGHT];

    /**
     * Inicializál egy új játékot.
     * 
     * Elhelyezi a területeket a kezdőpozícióba és beállítja, hogy a piros
     * területekkel rendelkező játékos következik lépni.
     */
    public static void startNewGame() {

        isCurrentRed = true;
        redPoints = 2;
        bluePoints = 2;

        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                Tile tile = new Tile();
                board[x][y] = tile;

                Piece piece = null;

                if ((x == 0 && y == 0) || (x == WIDTH - 1 && y == HEIGHT - 1)) {
                    piece = makePiece(PieceType.RED, x, y);
                }

                if ((x == WIDTH - 1 && y == 0) || (x == 0 && y == HEIGHT - 1)) {
                    piece = makePiece(PieceType.BLUE, x, y);
                }

                if (piece != null) {
                    tile.setPiece(piece);
                }

            }
        }

    }

    /**
     * Létrehoz egy elfoglalt mezőt a megadott mezőtípussal és a megadott
     * koordinátákkal.
     * 
     * @param pieceType A mező típusa. Két típus lehet: RED vagy BLUE
     * @param x A létrehozott mező sorindexe.
     * @param y A létrehozott mező oszlopindexe.
     * @return Egy kész mező a megadott típussal és koordinátákkal.
     */
    private static Piece makePiece(PieceType pieceType, int x, int y) {
        Piece piece = new Piece(pieceType, x, y);

        return piece;
    }

    /**
     * Megadja, hogy az (x,y) pozíciójú mező választható-e lépésre.
     * 
     * @param x a kíválasztani kívánt mező sorindexe
     * @param y a kíválasztani kívánt mező oszlopindexe
     * @return true, ha az (x,y) mező azonos színű, mint a lépni következő
     * játékos többi mezeje
     */
    public boolean validChoose(int x, int y) {
        if (board[x][y].hasPiece()) {
            if (isCurrentRed) {
                return board[x][y].getPiece().getType() == PieceType.RED;
            } else {
                return board[x][y].getPiece().getType() == PieceType.BLUE;
            }
        } else {
            return false;
        }
    }
    
    /**
     * Megadja, hogy a kiválasztott lépés milyen típusú lépésnek számít.
     * 
     * Háromféle lépéstípus van. Egy mezős lépés, ha a közvetlen szomszédjába
     * lép. Két mezős lépés ha a két kiválasztott terület között van egy mező.
     * Érvénytelen lépés pedig, ha vagy kettőnél többet akar lépni, vagy 
     * a célnak kiválasztott mező már foglalt.
     * 
     * @param oldX A lépésre kiválasztott mező sorindexe.
     * @param oldY A lépésre kiválasztott mező oszlopindexe.
     * @param newX A lépés céljának kiválasztott mező sorindexe.
     * @param newY A lépés céljának kiválasztott mező oszlopindexe.
     * @return A lépés typusa.
     */
    private MoveResult tryMove(int oldX, int oldY, int newX, int newY) {

        if (board[newX][newY].hasPiece()
                || (newX - oldX == 0 && newY - oldY == 0)
                || (Math.abs(newX - oldX) > 2 || Math.abs(newY - oldY) > 2)) {
            return new MoveResult(MoveType.NONE);
        }

        if (Math.abs(newX - oldX) == 2 || Math.abs(newY - oldY) == 2) {
            return new MoveResult(MoveType.TWO);

        } else if (Math.abs(newX - oldX) == 1 || Math.abs(newY - oldY) == 1) {
            return new MoveResult(MoveType.ONE);
        }

        return new MoveResult(MoveType.NONE);
    }

    /**
     * Lépés után ellenőrzi az új terület szomszédos mezőit.
     * 
     * Ha a lépés után létrejött új terület szomszédjában van az ellenfélnek
     * területe, akkor az a terület a lépést tett játékos területe lesz.
     * 
     * @param x az új mező sorindexe
     * @param y az új mező oszlopindexe
     */
    public void checkNeighbourTypes(int x, int y) {
        PieceType type = board[x][y].getPiece().getType();

        if (x < WIDTH - 1) {
            if (y < HEIGHT - 1) {
                if (board[x + 1][y + 1].hasPiece()) {
                    if (board[x + 1][y + 1].getPiece().getType() != type) {
                        board[x + 1][y + 1].getPiece().setType(type);
                        if (isCurrentRed) {
                            redPoints++;
                            bluePoints--;
                        } else {
                            bluePoints++;
                            redPoints--;
                        }
                    }
                }
            }
            if (board[x + 1][y].hasPiece()) {
                if (board[x + 1][y].getPiece().getType() != type) {
                    board[x + 1][y].getPiece().setType(type);
                    if (isCurrentRed) {
                        redPoints++;
                        bluePoints--;
                    } else {
                        bluePoints++;
                        redPoints--;
                    }
                }
            }
            if (y > 0) {
                if (board[x + 1][y - 1].hasPiece()) {
                    if (board[x + 1][y - 1].getPiece().getType() != type) {
                        board[x + 1][y - 1].getPiece().setType(type);
                        if (isCurrentRed) {
                            redPoints++;
                            bluePoints--;
                        } else {
                            bluePoints++;
                            redPoints--;
                        }
                    }
                }
            }
        }
        if (x > 0) {
            if (y < HEIGHT - 1) {
                if (board[x - 1][y + 1].hasPiece()) {
                    if (board[x - 1][y + 1].getPiece().getType() != type) {
                        board[x - 1][y + 1].getPiece().setType(type);
                        if (isCurrentRed) {
                            redPoints++;
                            bluePoints--;
                        } else {
                            bluePoints++;
                            redPoints--;
                        }
                    }
                }
            }
            if (board[x - 1][y].hasPiece()) {
                if (board[x - 1][y].getPiece().getType() != type) {
                    board[x - 1][y].getPiece().setType(type);
                    if (isCurrentRed) {
                        redPoints++;
                        bluePoints--;
                    } else {
                        bluePoints++;
                        redPoints--;
                    }
                }
            }
            if (y > 0) {
                if (board[x - 1][y - 1].hasPiece()) {
                    if (board[x - 1][y - 1].getPiece().getType() != type) {
                        board[x - 1][y - 1].getPiece().setType(type);
                        if (isCurrentRed) {
                            redPoints++;
                            bluePoints--;
                        } else {
                            bluePoints++;
                            redPoints--;
                        }
                    }
                }
            }
        }
        if (y < HEIGHT - 1) {
            if (board[x][y + 1].hasPiece()) {
                if (board[x][y + 1].getPiece().getType() != type) {
                    board[x][y + 1].getPiece().setType(type);
                    if (isCurrentRed) {
                        redPoints++;
                        bluePoints--;
                    } else {
                        bluePoints++;
                        redPoints--;
                    }
                }
            }
        }
        if (y > 0) {
            if (board[x][y - 1].hasPiece()) {
                if (board[x][y - 1].getPiece().getType() != type) {
                    board[x][y - 1].getPiece().setType(type);
                    if (isCurrentRed) {
                        redPoints++;
                        bluePoints--;
                    } else {
                        bluePoints++;
                        redPoints--;
                    }
                }
            }
        }
    }

    /**
     * Elvégzi a lépést attól függően, hogy milyen típusú lépés volt.
     * 
     * Háromféle lépést tehet. Ha csak egy mezővel lépett arréb, akkor létrejön
     * egy új mező és a régi is megmarad. Ha egyszerre kettő mezővel lépett
     * arréb, akkor létrejön egy új mező és eltűnik a régi. Végül van az
     * érvénytelen lépés, ha kettőnél többet akart a játékos lépni, vagy olyan
     * mezőre akart lépni, ami már foglalt.
     * 
     * @param oldX a régi mező sorindexe
     * @param oldY a régi mező oszlopindexe
     * @param newX az új mező sorindexe
     * @param newY az új mező oszlopindexe
     * @return true, ha a lépés végrehajtható (szabálytalan lépés esetén false)
     */
    public boolean move(int oldX, int oldY, int newX, int newY) {
        MoveResult result = tryMove(oldX, oldY, newX, newY);
        Piece piece;

        switch (result.getType()) {
            case NONE:
                return false;
            case ONE:
                piece = makePiece(board[oldX][oldY].getPiece().getType(), newX, newY);
                board[newX][newY].setPiece(piece);
                checkNeighbourTypes(newX, newY);
                if (isCurrentRed) {
                    redPoints++;
                } else {
                    bluePoints++;
                }
                isCurrentRed = !isCurrentRed;
                return true;
            case TWO:
                piece = makePiece(board[oldX][oldY].getPiece().getType(), newX, newY);
                board[oldX][oldY].setPiece(null);
                board[newX][newY].setPiece(piece);
                checkNeighbourTypes(newX, newY);
                isCurrentRed = !isCurrentRed;
                return true;
        }
        return false;
    }

    /**
     * Megadja, hogy véget ért-e a játék.
     * 
     * @return true, ha az egyik játékosnak elfogytak a területei, vagy ha már
     * nincs szabad terület és így egyik játékos sem tud lépni.
     */
    public boolean isEnd() {
        if (redPoints == 0 || bluePoints == 0 || redPoints + bluePoints == WIDTH * HEIGHT) {
            return true;
        } else {
            return false;
        }
    }

}
