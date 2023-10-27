package com.example.ct3_opt1;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CT3_OPT1 extends Application  {
    private TextField dateTime;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("User Interface Example");
        MenuItem menuItem1 = new MenuItem("Display Date/Time");
        MenuItem menuItem2 = new MenuItem("Write to txt file");
        MenuItem menuItem3 = new MenuItem("Option 3");
        MenuItem menuItem4 = new MenuItem("Exit");
        dateTime = new TextField();

        menuItem1.setOnAction((ActionEvent event) -> {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            dateTime.setText(dtf.format(now));
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
                System.out.println("FIXME: Change background color");
            }
        });

        menuItem4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("FIXME: Exit Program");
            }
        });
        MenuButton menuButton = new MenuButton("Options", null, menuItem1, menuItem2, menuItem3, menuItem4);
        HBox hbox = new HBox(menuButton, dateTime);
        Scene scene = new Scene(hbox, 600, 300);
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
}