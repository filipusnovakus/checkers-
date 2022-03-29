package com.example.demo;

public enum PieceType {
    //enum pro získání figurek hráčů na základě zda začínají dole nebo nahoře
    PLAYER1(1),
   PLAYER2(-1);

    final int moveDir;
//kam se figurky budou hýbat - záporné či kladné hodnoty
    PieceType(int moveDir) {
        this.moveDir = moveDir;
    }
}


