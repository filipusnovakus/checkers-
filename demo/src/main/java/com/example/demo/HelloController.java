package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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



        int count = 0;
        double s = 100;
        for (int i = 0; i < 8; i++) {
            count++;
            for (int j = 0; j < 8; j++) {
                Rectangle r = new Rectangle(s, s, s, s);
                if (count % 2 == 0)
                    r.setFill(Color.WHITE);
                board.add(r, j, i);
                count++;
            }

        }
        board.setBorder(new Border(new BorderStroke(Color.DARKGREY, BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY, new BorderWidths(5))));

    }
}
