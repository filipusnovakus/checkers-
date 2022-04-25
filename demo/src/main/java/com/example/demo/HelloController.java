package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;

public class HelloController extends Application  {

    public static final int TILE_SIZE = 100;
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
//vytvoření políčka o 2 parametrech
    private Tile[][] board = new Tile[WIDTH][HEIGHT];

    private Group tileGroup = new Group();
    private Group pieceGroup = new Group();

    public void start(Stage stage) throws IOException {



        Scene scene = new Scene(createContent());

        stage.setTitle("Hello!");
stage.setResizable(false);
        stage.setScene(scene);


        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(800, 800);
        root.getChildren().addAll(tileGroup, pieceGroup);

    for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                Tile tile = new Tile((x + y) % 2 == 0, x, y);
                board[x][y] = tile;

                tileGroup.getChildren().add(tile);

                Piece piece = null;

                if (y <= 2 && (x + y) % 2 != 0) {
                    piece = makePiece(PieceType.PLAYER2, x, y);
                }

                if (y >= 5 && (x + y) % 2 != 0) {
                    piece = makePiece(PieceType.PLAYER1, x, y);
                }

                if (piece != null) {
                    tile.setPiece(piece);
                    pieceGroup.getChildren().add(piece);
                }
            }
        }

        return root;
    }
    //vytvoření jedné figurky v jednom políčku
    private Piece makePiece(PieceType type, int x, int y) {
        Piece piece = new Piece(type, x, y);
        piece.setOnMouseReleased(e -> {
            int newX = toBoard(piece.getLayoutX());
            int newY = toBoard(piece.getLayoutY());

            MoveResult result;

            if (newX < 0 || newY < 0 || newX >= WIDTH || newY >= HEIGHT) {
                result = new MoveResult(MoveType.NONE);
            } else {
                result = tryMove(piece, newX, newY);
            }
            int x1 = toBoard(piece.getOldX());
            int y1 = toBoard(piece.getOldY());
            switch (result.getType()) {
                case NONE:
                    piece.abortMove();
                    break;
                case NORMAL:
                    piece.move(newX, newY);
                    board[x1][y1].setPiece(null);
                    board[newX][newY].setPiece(piece);
                    break  ;
                case KILL:
                    board[newX][newY].setPiece(null);

            }
        });
            return piece;
        }
    private int toBoard(double pixel) {

        return (int)(pixel + TILE_SIZE / 2) / TILE_SIZE;
    }
    private MoveResult tryMove(Piece piece, int newX, int newY) {
        if (board[newX][newY].hasPiece() || (newX + newY) % 2 == 0) {
            return new MoveResult(MoveType.NONE);
        }
        int x1 = toBoard(piece.getOldX());
                int y1 = toBoard(piece.getOldY());
        if (Math.abs(newX-x1) == 1 || Math.abs(newY - y1) == 1 ) {
          return new MoveResult(MoveType.NORMAL); }
        //  else if (Math.abs(newX- x1) == 1  || //
         //  int x2 = newX + 2 ;

            //int y2 = newY + 2 ;
             /*  else if (Math.abs(newX - x1) == 2 && newY - y1 == piece.getType().moveDir * 2){

            }*/
                return new MoveResult(MoveType.NONE);
        }

}