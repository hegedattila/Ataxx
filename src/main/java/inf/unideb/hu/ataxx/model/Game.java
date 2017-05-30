/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf.unideb.hu.ataxx.model;


/**
 *
 * @author hegedattila
 */
public class Game {
    
    private static int WIDTH = 7;
    private static int HEIGHT = 7;
    
    private static boolean isCurrentRed;
    private static int redPoints, bluePoints;

    public static int getWIDTH() {
        return WIDTH;
    }

    public static void setWIDTH(int WIDTH) {
        Game.WIDTH = WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static void setHEIGHT(int HEIGHT) {
        Game.HEIGHT = HEIGHT;
    }

    public static boolean isIsCurrentRed() {
        return isCurrentRed;
    }

    public static void setIsCurrentRed(boolean isCurrentRed) {
        Game.isCurrentRed = isCurrentRed;
    }

    public static int getRedPoints() {
        return redPoints;
    }

    public static void setRedPoints(int redPoints) {
        Game.redPoints = redPoints;
    }

    public static int getBluePoints() {
        return bluePoints;
    }

    public static void setBluePoints(int bluePoints) {
        Game.bluePoints = bluePoints;
    }

    public static Tile[][] getBoard() {
        return board;
    }

    public static void setBoard(Tile[][] board) {
        Game.board = board;
    }
    
    public Game(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
    }
    
    public static Tile[][] board = new Tile[WIDTH][HEIGHT];
    
    public static void startNewGame(){
        
        isCurrentRed = true;
        redPoints = 2;
        bluePoints = 2;
        
        for (int y = 0; y < HEIGHT; y++){
            for (int x = 0; x < WIDTH; x++){
                Tile tile = new Tile();
                board[x][y] = tile;
                
                Piece piece = null;

                if ((x == 0 && y == 0) || (x == WIDTH-1 && y == HEIGHT-1)) {
                    piece = makePiece(PieceType.RED, x, y);
                }

                if ((x == WIDTH-1 && y == 0) || (x == 0 && y == HEIGHT-1)) {
                    piece = makePiece(PieceType.BLUE, x, y);
                }

                if (piece != null) {
                    tile.setPiece(piece);
                }
                
            }
        }
        
    }

    private static Piece makePiece(PieceType pieceType, int x, int y) {
        Piece piece = new Piece(pieceType, x, y);
        
        return piece;
    }
    
    public boolean validChoose(int x, int y){
        if (board[x][y].hasPiece()){
            if (isCurrentRed)
                return board[x][y].getPiece().getType() == PieceType.RED;
            else
                return board[x][y].getPiece().getType() == PieceType.BLUE;
        }
        else
            return false;
    }
    
    private MoveResult tryMove(int oldX, int oldY, int newX, int newY) {
        
        if (board[newX][newY].hasPiece() || 
                (newX - oldX == 0 && newY - oldY == 0) ||
                (Math.abs(newX - oldX) > 2 || Math.abs(newY - oldY) > 2)) {
            return new MoveResult(MoveType.NONE);
        }

        if (Math.abs(newX - oldX) == 2 || Math.abs(newY - oldY) == 2) {
            return new MoveResult(MoveType.TWO);
            
        } else if (Math.abs(newX - oldX) == 1 || Math.abs(newY - oldY) == 1) {
            return new MoveResult(MoveType.ONE);
        }

        return new MoveResult(MoveType.NONE);
    }
    
    public void checkNeighbourTypes(int x, int y){
        PieceType type = board[x][y].getPiece().getType();
        
        if (x < WIDTH - 1){
            if (y < HEIGHT - 1){
                if (board[x+1][y+1].hasPiece()){
                    if (board[x+1][y+1].getPiece().getType() != type){
                        board[x+1][y+1].getPiece().setType(type);
                        if(isCurrentRed){
                            redPoints++;
                            bluePoints--;
                        }
                        else{
                            bluePoints++;
                            redPoints--;
                        }
                    }
                }
            }
            if (board[x+1][y].hasPiece()){
                if (board[x+1][y].getPiece().getType() != type){
                    board[x+1][y].getPiece().setType(type);
                    if(isCurrentRed){
                        redPoints++;
                        bluePoints--;
                    }
                    else{
                        bluePoints++;
                        redPoints--;
                    }
                }
            }
            if (y > 0) {
                if (board[x+1][y-1].hasPiece()){
                    if (board[x+1][y-1].getPiece().getType() != type){
                        board[x+1][y-1].getPiece().setType(type);
                        if(isCurrentRed){
                            redPoints++;
                            bluePoints--;
                        }
                        else{
                            bluePoints++;
                            redPoints--;
                        }
                    }
                }
            }
        }
        if (x > 0){
            if (y < HEIGHT - 1){
                if (board[x-1][y+1].hasPiece()){
                    if (board[x-1][y+1].getPiece().getType() != type){
                        board[x-1][y+1].getPiece().setType(type);
                        if(isCurrentRed){
                            redPoints++;
                            bluePoints--;
                        }
                        else{
                            bluePoints++;
                            redPoints--;
                        }
                    }
                }
            }
            if (board[x-1][y].hasPiece()){
                if (board[x-1][y].getPiece().getType() != type){
                    board[x-1][y].getPiece().setType(type);
                    if(isCurrentRed){
                        redPoints++;
                        bluePoints--;
                    }
                    else{
                        bluePoints++;
                        redPoints--;
                    }
                }
            }
            if (y > 0) {
                if (board[x-1][y-1].hasPiece()){
                    if (board[x-1][y-1].getPiece().getType() != type){
                        board[x-1][y-1].getPiece().setType(type);
                        if(isCurrentRed){
                            redPoints++;
                            bluePoints--;
                        }
                        else{
                            bluePoints++;
                            redPoints--;
                        }
                    }
                }
            }
        }
        if (y < HEIGHT - 1){
                if (board[x][y+1].hasPiece()){
                    if (board[x][y+1].getPiece().getType() != type){
                        board[x][y+1].getPiece().setType(type);
                        if(isCurrentRed){
                            redPoints++;
                            bluePoints--;
                        }
                        else{
                            bluePoints++;
                            redPoints--;
                        }
                    }
                }
            }
            if (y > 0) {
                if (board[x][y-1].hasPiece()){
                    if (board[x][y-1].getPiece().getType() != type){
                        board[x][y-1].getPiece().setType(type);
                        if(isCurrentRed){
                            redPoints++;
                            bluePoints--;
                        }
                        else{
                            bluePoints++;
                            redPoints--;
                        }
                    }
                }
            }
    }
    
    public boolean move(int oldX, int oldY, int newX, int newY){
        MoveResult result = tryMove(oldX, oldY, newX, newY);
        Piece piece;
        
        switch (result.getType()) {
                    case NONE:
                        return false;
                    case ONE:
                        piece = makePiece(board[oldX][oldY].getPiece().getType(), newX, newY);
                        board[newX][newY].setPiece(piece);
                        checkNeighbourTypes(newX, newY);
                        if(isCurrentRed)
                            redPoints++;
                        else
                            bluePoints++;
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
    
    public boolean isEnd(){
        if (redPoints == 0 || bluePoints == 0 || redPoints + bluePoints == WIDTH * HEIGHT)
            return true;
        else
            return false;
    }
    
}