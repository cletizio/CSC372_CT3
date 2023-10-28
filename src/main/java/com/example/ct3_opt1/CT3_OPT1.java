package com.example.ct3_opt1;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CT3_OPT1 extends Application  {
    TextField dateTime = null;
    Stage primaryStage = null;
    GridPane pane = null;
    Scene scene = null;

    @Override
    public void start(Stage primaryStage) throws Exception {


        pane = new GridPane();
        scene = new Scene(pane);
        Canvas canvas = new Canvas(300, 300);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        primaryStage.setTitle("User Interface Example");
        MenuItem menuItem1 = new MenuItem("Display Date/Time");
        MenuItem menuItem2 = new MenuItem("Write to txt file");
        MenuItem menuItem3 = new MenuItem("Set background green");
        MenuItem menuItem4 = new MenuItem("Exit");
        dateTime = new TextField();
        dateTime.setAlignment(Pos.CENTER);
        dateTime.setEditable(false);
        pane.add(dateTime, 1, 1);

        Insets gridPadding = new Insets(10,10,10,10);
        pane.setPadding(gridPadding);
        pane.setHgap(20);
        pane.setVgap(20);

        TextField finalDateTime = dateTime;

        menuItem1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                finalDateTime.setText(dtf.format(now));
            }
        });

        menuItem2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                writeToFile();
            }
        });

        menuItem3.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                setRandomGreenBackground();
            }
        });

        menuItem4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("FIXME: Exit Program");
            }
        });
        MenuButton menuButton = new MenuButton("Options", null, menuItem1, menuItem2, menuItem3, menuItem4);

        pane.add(menuButton, 0, 0);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }

    private void writeToFile(){
        String dateTimeBoxInfo = dateTime.getText();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("datetime.txt"));
            writer.write(dateTimeBoxInfo);
            writer.close();
            System.out.println("Successfully wrote to file.");
        } catch (IOException event){
            event.printStackTrace();
            System.err.println("Unable to write to file. " + event);
        }
    }

    private void setRandomGreenBackground(){
        Random random = new Random();
        final int red = 0;
        int green = random.nextInt(256);
        final int blue = 0;

        try {
            Color randGreen = Color.rgb (red, green, blue);
            BackgroundFill backgroundFill = new BackgroundFill(randGreen, null, null);
            Background background = new Background(backgroundFill);
            pane.setBackground(background);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}