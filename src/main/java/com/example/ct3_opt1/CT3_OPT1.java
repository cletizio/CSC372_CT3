package com.example.ct3_opt1;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
public class CT3_OPT1 extends Application  {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("User Interface Example");
        MenuItem menuItem1 = new MenuItem("Display Date/Time");
        MenuItem menuItem2 = new MenuItem("Write to txt file");
        MenuItem menuItem3 = new MenuItem("Option 3");
        MenuItem menuItem4 = new MenuItem("Exit");

        menuItem1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("FIXME date/time");
            }
        });
        menuItem3.setOnAction(new EventHandler<>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Option 3 selected");
            }
        });
        menuItem2.setOnAction(event -> {
                System.out.println("FIXME: Write to TXT file.");
});
        menuItem3.setOnAction(new EventHandler<>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Option 3 selected");
            }
        });

        menuItem4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("FIXME: Exit Program");
            }
        });
        MenuButton menuButton = new MenuButton("Options", null, menuItem1, menuItem2, menuItem3);
        HBox hbox = new HBox(menuButton);
        Scene scene = new Scene(hbox, 200, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}