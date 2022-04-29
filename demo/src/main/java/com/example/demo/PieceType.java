package com.example.demo;

public enum PieceType {

    PLAYER1(1),
   PLAYER2(-1);

    final int moveDir;

    PieceType(int moveDir) {
        this.moveDir = moveDir;
    }
}


