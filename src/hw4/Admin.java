/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class Admin extends Application {
    String str[] = new String[100];
    @Override
    public void start(Stage primaryStage) {
        
        HBox mainHb = new HBox();
        HBox firstHb = new HBox();
        HBox secondHb = new HBox();
        
        mainHb.setAlignment(Pos.CENTER);
        firstHb.setAlignment(Pos.CENTER);
        secondHb.setAlignment(Pos.CENTER);
        
        VBox firstVb = new VBox();
        VBox secondVb = new VBox();
        VBox thirdVb = new VBox();
        VBox fourthVb = new VBox();
        
        firstVb.setAlignment(Pos.CENTER_LEFT);
        secondVb.setAlignment(Pos.CENTER);
        thirdVb.setAlignment(Pos.CENTER_LEFT);
        fourthVb.setAlignment(Pos.CENTER);
        
        //registration
        Label nickNameReg = new Label("Login: ");
        Label passwordReg = new Label("Password: ");
        Label nameClient = new Label("Name: ");
        Label lastName = new Label("Last Name: ");
        Label email = new Label("e-mail: ");

        TextField nnRTF = new TextField();
        TextField pwRTF = new TextField();
        TextField ncRTF = new TextField();
        TextField lnRTF = new TextField();
        TextField emRTF = new TextField();
        
        Button signIn = new Button("Sign In");
        signIn.setStyle(
                "-fx-margin: 0 0 0 20;"
                        + "-fx-font-size:25;"
        );
        signIn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            
            }
        });
        
        secondVb.getChildren().addAll(nickNameReg, passwordReg, nameClient, lastName, email);
        fourthVb.getChildren().addAll(nnRTF, pwRTF, ncRTF, lnRTF, emRTF);
        secondVb.setSpacing(15);
        fourthVb.setSpacing(5);
        secondHb.getChildren().addAll(secondVb, fourthVb);
        //registration end
        
        //login begin
        Label nickName = new Label("Login: ");
        Label password = new Label("Password: ");
        
        TextField nnTf = new TextField();
        PasswordField pwTf = new PasswordField();
        
        Button logIn = new Button("Log In");
        logIn.setStyle(
                "-fx-font-size: 25;"
                        + "-fx-"
        );
        logIn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        firstVb.getChildren().addAll(nickName, password);
        thirdVb.getChildren().addAll(nnTf, pwTf);
        firstHb.getChildren().addAll(firstVb, thirdVb);
        //log in end
        VBox mainVb = new VBox();
        mainVb.setAlignment(Pos.CENTER);
        mainVb.setSpacing(15);
        
        HBox btnHb = new HBox();
        btnHb.setStyle("-fx-padding: 0 0 10 10;");
        
        btnHb.setAlignment(Pos.CENTER);
        btnHb.getChildren().addAll(logIn, signIn);
        
        mainHb.getChildren().addAll(firstHb, secondHb);
        mainVb.getChildren().addAll(mainHb,btnHb);
        Scene scene = new Scene(mainVb, 600, 450);
        scene.getStylesheets().add("/style.css");
        primaryStage.setTitle("Sign in or Registration!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
