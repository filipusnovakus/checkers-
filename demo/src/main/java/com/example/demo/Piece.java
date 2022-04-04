package com.example.demo;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import static com.example.demo.HelloController.TILE_SIZE;

public class Piece extends StackPane {
//definování že každá figurka bude mít jednu nebo druhou barvu
        private PieceType type;
        public PieceType getType() {
            return type;
        }
//vytvoření figurky
public Piece(PieceType type, int x, int y) {
    this.type = type;

            Ellipse bg = new Ellipse(30 , 30);
           bg.setFill(Color.WHITE);

            bg.setStroke(Color.WHITE);
            bg.setStrokeWidth(5);

            Ellipse ellipse = new Ellipse(30,30);
            ellipse.setFill(type == PieceType.PLAYER1
                    ? Color.WHITE : Color.BLACK);

            ellipse.setStroke(Color.BLUE);
            ellipse.setStrokeWidth(5);

    getChildren().addAll(bg, ellipse);

        }

}

