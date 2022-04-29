package com.example.demo;


import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {

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
    public Tile(boolean light, int x, int y) {
        setWidth(HelloController.TILE_SIZE);
        setHeight(HelloController.TILE_SIZE);

        relocate(x * HelloController.TILE_SIZE, y * HelloController.TILE_SIZE);

        setFill(light ? Color.BLACK : Color.WHITE);

    }
}

