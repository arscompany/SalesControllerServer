package com.arcompany.maven;

import com.arcompany.maven.DaoImpl.DaoImplOrder;
import com.arcompany.maven.entities.Order;
import com.arcompany.maven.entities.Product;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application
{
    Server server = new Server();
    
    public static void main( String[] args ){
        launch(args);
    }
    
    @Override
    public void init() throws Exception{
        server.start();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLserver.fxml"));
        Scene scene = new Scene(root,1900,1000);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sales Controller Server");
        primaryStage.show();
        
    }
}
