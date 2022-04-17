package com.example.demo;

public class MoveResult {

    private MoveType type;

    public MoveType getType() {
        return type;
    }



    public MoveResult(MoveType type) {
        this(type, null);
    }

    public MoveResult(MoveType type, Piece piece) {
        this.type = type;

    }
}