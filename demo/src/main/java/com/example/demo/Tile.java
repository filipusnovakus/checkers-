package com.example.demo;



public class Tile {
    //objekt který reprezentuje jedno políčko - pro kontrolu zda se zde nachází figurka nebo ne
    private Piece piece;


    public boolean hasPiece() {
        return piece != null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    /*
    public Tile( int x, int y) {
        x = 0;
        y = 0;
    }
*/
}
