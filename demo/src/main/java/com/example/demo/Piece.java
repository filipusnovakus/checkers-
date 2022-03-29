package com.example.demo;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Piece {
//definování že každá figurka bude mít jednu nebo druhou barvu
        private PieceType type;
        public PieceType getType() {
            return type;
        }
//vytvoření figurky
        public Piece(PieceType type) {
            this.type = type;

            Ellipse bg = new Ellipse(20 , 20);
           bg.setFill(Color.BLACK);

            bg.setStroke(Color.BLACK);
            bg.setStrokeWidth(5);

            Ellipse ellipse = new Ellipse(20,20);
            ellipse.setFill(type == PieceType.PLAYER1
                    ? Color.valueOf("#c40003") : Color.valueOf("#fff9f4"));

            ellipse.setStroke(Color.BLACK);
            ellipse.setStrokeWidth(5);


        }   }


