package com.example.demo;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import java.util.Set;

import static com.example.demo.HelloController.TILE_SIZE;

public class Piece extends StackPane {
//definování že každá figurka bude mít jednu nebo druhou barvu
        private PieceType type;


    public PieceType getType() {
            return type;
        }
        private double mouseX;
        private double mouseY;
    private double oldX;
    private double oldY;


    public double getOldX() {
        return oldX;
    }

    public double getOldY() {
        return oldY;
    }





    //vytvoření figurky
public Piece(PieceType type, int x, int y) {
    this.type = type;
    move(x, y);
    Ellipse bg = new Ellipse(30, 30);
    bg.setFill(Color.WHITE);

    bg.setTranslateX((20));
    bg.setTranslateY((20));
    Ellipse ellipse = new Ellipse(30, 30);
    ellipse.setFill(type == PieceType.PLAYER1
            ? Color.WHITE : Color.BLACK);

    ellipse.setStroke(Color.BLUE);
    ellipse.setStrokeWidth(5);

    ellipse.setTranslateX((20));
    ellipse.setTranslateY((20));

    getChildren().addAll(bg, ellipse);

    setOnMousePressed(e -> {
        mouseX = e.getSceneX();
        mouseY = e.getSceneY();
        ellipse.setRadiusX(25);
        ellipse.setRadiusY(25);
        bg.setRadiusX(25);
        bg.setRadiusY(25);

    });

    setOnMouseDragged(e -> {
        relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);

    });


     setOnMouseClicked(e -> {

    ellipse.setRadiusX(30);
    ellipse.setRadiusY(30);
    bg.setRadiusX(30);
    bg.setRadiusY(30);

});}


    public void move(int x, int y) {
        oldX = x * TILE_SIZE;
        oldY = y * TILE_SIZE ;
        relocate(oldX, oldY);
    }
    public void abortMove() {
        relocate(oldX, oldY);
    }

}









