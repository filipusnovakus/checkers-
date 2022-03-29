package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Label welcomeText;
    @FXML
    private GridPane board;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
// vytvoření tabulky a dosazení figurek (nelze doplnit tiles o figurky)

        Piece piece = null;
        int count = 0;
        double s = 100;
        for (int i = 0; i < 8; i++) {
            count++;
            for (int j = 0; j < 8; j++) {

                Tile tile = new Tile();

                Rectangle r = new Rectangle(s, s, s, s);
                if (count % 2 == 0)
                    r.setFill(Color.WHITE);
                board.add(r, j, i);
                count++;


                if (i <= 2 && (j + i) % 2 != 0) {
                    //Figurky hráče 1
                    piece = makePiece(PieceType.PLAYER1);
                }

                if (i >= 5 && (j + i) % 2 != 0) {
                    //Figurky hráče 2
                    piece = makePiece(PieceType.PLAYER2);
                }
                //rozhoduje zda je v políčku figurka (chyba asi)
                if (piece != null) {
                    tile.setPiece(piece);

                }


            }

        }
        //ohraničení
        board.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, new BorderWidths(5))));

    }
    //vytvoření jedné figurky v jednom políčku
   public Piece makePiece(PieceType type) {
        Piece piece = new Piece(type);




        return piece;
    }
}