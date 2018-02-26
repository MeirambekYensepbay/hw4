/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
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
public class JavaFXApplication10 extends Application {
    Scene logScene, signScene, logedScene, succScene;
    String log[] = new String[100];
    String pass[] = new String[100];
    private static ResultSet rs;
    public void addClientDb(String login, String pass, String last_name){
        try{
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate("insert into java.client123 (login,last_name,password) VALUES ('"+login+"','"+last_name+"', '"+pass+"')");
                    conn.close();
                }
                catch(Exception ex){
                    System.out.println(ex);
                }
        
    }
    /*public void welcomeScene( String str){
        Stage nextStage = new Stage();
        VBox vb = new VBox(10);
        vb.setAlignment(Pos.CENTER);
        
        Label welcome = new Label("Hello "+str);
        vb.getChildren().add(vb);
        logedScene = new Scene(vb, 300, 250);
        nextStage.setTitle("Welcome!");
        nextStage.setScene(logedScene);
        nextStage.show();
    }*/
    @Override
    public void start(Stage primaryStage) {
        try{
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
                    Statement stmt = conn.createStatement();
        //            stmt.executeUpdate("insert into java.client123 (login,last_name,password) VALUES ('Meir','Meirambek', '1234')");
                    String query = "Select login, password from java.client123";
                    rs = stmt.executeQuery(query);
                    int i=0;
                    while(rs.next()){
                        log[i] = rs.getString(1);
                        pass[i] = rs.getString(2);
                        System.out.println(log[i] +"  "+pass[i]);
                        i++;
                    }
                    conn.close();
                }
                catch(Exception ex){
                    System.out.println(ex);
                }
        
        VBox vb = new VBox(10);
        vb.setAlignment(Pos.CENTER);
        
        Label loginLab = new Label("Логин:");
        Label passLab = new Label("Пароль:");
        Label err = new Label();
        TextField logtf = new TextField();
        PasswordField passtf = new PasswordField();
        logtf.setMaxWidth(200);
        passtf.setMaxWidth(200);
        
        Button login = new Button("Войти");
        Button signin = new Button("зарегистрироваться ");
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
            String logStr=logtf.getText(), passStr=passtf.getText();
                for(int i=0; i<log.length; i++){
                    System.out.print(log[i]+" "+logStr+" "+pass[i]+" "+passStr);
                    if(log[i].equals(logStr)&&pass[i].equals(passStr)){ 
                        VBox vb1 = new VBox();
                        Label wellab = new Label("Здравствуйте "+logStr);
                        vb1.getChildren().add(wellab);
                        logedScene = new Scene(vb1, 300,250);
                        primaryStage.setTitle("Здравствуйте!");
                        primaryStage.setScene(logedScene);
                    }
                    else{
                        err.setText("Неправильный логин или пароль");
                    }
                }
            }
        });
        
        signin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                VBox vb = new VBox(10);
                vb.setAlignment(Pos.CENTER);
                Label slogin = new Label("Логин:");
                Label sLast_name = new Label("Имя:");
                Label spassword = new Label("Пароль:");
                Label sconf_pass = new Label("Подтвердите пароль:");
                Label mess = new Label();
                TextField slogtf = new TextField();
                slogtf.setMaxWidth(200);
                TextField slast_nametf = new TextField();
                slast_nametf.setMaxWidth(200);
                TextField spasstf = new TextField();
                spasstf.setMaxWidth(200);
                TextField sconf_passtf = new TextField();
                sconf_passtf.setMaxWidth(200);
                
                HBox hb = new HBox(10);
                hb.setAlignment(Pos.CENTER);
                Button btn = new Button("Регистрация!");
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if(slogtf.getText().trim().isEmpty()&&slast_nametf.getText().trim().isEmpty()&&spasstf.getText().trim().isEmpty()&&sconf_passtf.getText().trim().isEmpty()){
                            mess.setText("Заполните все поля");
                        }
                        else{
                             if(spasstf.getText().equals(sconf_passtf.getText())){
                                addClientDb(slogtf.getText(), spasstf.getText(), slast_nametf.getText());
                                VBox vb = new VBox(10);
                                vb.setAlignment(Pos.CENTER);
                                Label cong = new Label("Поздравляем вас с успешной регистрацией вашего нового аккаунта!");
                                Button back = new Button("Войти");
                                back.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        primaryStage.setScene(logScene);
                                    }
                                });
                                vb.getChildren().addAll(cong,back);
                                succScene  = new Scene(vb,300,250);
                                primaryStage.setTitle("Поздравляем!");
                                primaryStage.setScene(succScene);
                                
                                mess.setText("");
                            }
                            else{
                                mess.setText("Пароли не совпадают!");
                                mess.setStyle("-fx-font-color:red;");
                            }
                        }
                    }
                });
                Button cnl = new Button("Отмена");
                cnl.setOnAction(e -> primaryStage.setScene(logScene));
                hb.getChildren().addAll(btn,cnl);
                vb.getChildren().addAll(slogin,slogtf,sLast_name, slast_nametf,spassword, spasstf, sconf_pass, sconf_passtf, hb, mess);
                
                signScene = new Scene(vb, 300, 400);
                primaryStage.setScene(signScene);
                primaryStage.setTitle("Регистрация");
            }
        });
        
        HBox hb = new HBox(10);
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll(login, signin);
        
        vb.getChildren().addAll(loginLab,logtf, passLab, passtf, hb,err);
        logScene = new Scene(vb, 300, 250);
        
        primaryStage.setTitle("Log in!");
        primaryStage.setScene(logScene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}   
