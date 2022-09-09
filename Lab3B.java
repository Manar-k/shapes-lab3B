/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3b;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author lokamloka
 */
public class Lab3B extends Application {
    
    @Override
    public void start(Stage B){
        Rectangle r=new Rectangle(100,60,Color.BLUE);
        r.setStroke(Color.BLACK);
        r.setStrokeWidth(1);
        
        Circle c=new Circle(30,Color.BLUE);
        c.setStroke(Color.BLACK);
        c.setStrokeWidth(1);
        
        Rectangle s=new Rectangle(50,50,Color.BLUE);
        s.setStroke(Color.BLACK);
        s.setStrokeWidth(1);
        
        VBox vboxshp=new VBox(20);
        vboxshp.getChildren().addAll(r,c,s);
        vboxshp.setAlignment(Pos.CENTER);
        
        Label shapes=new Label("Shapes: ");
        ChoiceBox list=new ChoiceBox();
        list.getItems().addAll("Rectangle","Circle","Square");
        list.setValue("Rectangle");
        
        HBox hbox1=new HBox(20);
        hbox1.getChildren().addAll(shapes,list);
        hbox1.setAlignment(Pos.CENTER);
        
        Label colors=new Label("Color: ");
        ToggleGroup group=new ToggleGroup();
        RadioButton red=new RadioButton("Red");
        red.setToggleGroup(group);
        RadioButton green=new RadioButton("Green");
        green.setToggleGroup(group);
        RadioButton blue=new RadioButton("Blue");
        blue.setToggleGroup(group);
        
        
        HBox hbox2=new HBox(20);
        hbox2.getChildren().addAll(colors,red,green,blue);
        hbox2.setAlignment(Pos.CENTER);
        
        Label width=new Label("Stroke Width: ");
        TextField num=new TextField();
        num.setMaxWidth(50);
        
        HBox hbox3=new HBox(20);
        hbox3.getChildren().addAll(width,num);
        hbox3.setAlignment(Pos.CENTER);
        
        CheckBox yes=new CheckBox("Add Background ?");
        
        HBox hbox4=new HBox(20);
        hbox4.getChildren().add(yes);
        hbox4.setAlignment(Pos.CENTER);
        
        VBox vbox1=new VBox(20);
        vbox1.setPadding(new Insets(10,10,10,10));
        vbox1.setSpacing(20);
        vbox1.getChildren().addAll(hbox1,hbox2,hbox3,hbox4);
        vbox1.setAlignment(Pos.CENTER);
        
        GridPane pane=new GridPane();
        pane.setStyle("-fx-background-color: WHITE;-fx-border-color:BLACK;");
        pane.setMinSize(300, 300);
        pane.setPadding(new Insets(10,10,10,10));
        pane.getChildren().add(vboxshp);
        pane.setAlignment(Pos.CENTER);
        
        ///////////////////////////////////////////////////////////////////////

        num.setOnAction(e->{
            if(Double.parseDouble(num.getText())<1 || Double.parseDouble(num.getText())>5){
            return;}
            else{
            if(list.getValue()=="Rectangle")
            {
                r.setStrokeWidth(Double.parseDouble(num.getText()));
            }
            else if(list.getValue()=="Circle")
            {
                c.setStrokeWidth(Double.parseDouble(num.getText()));
            }
            else
            {
                s.setStrokeWidth(Double.parseDouble(num.getText()));
            }
            }
        });
        
        red.setOnAction(e->{
            if(red.isSelected()&&list.getValue()=="Rectangle")
            {
                r.setFill(Color.RED);
            }
            else if(red.isSelected()&&list.getValue()=="Circle")
            {
                c.setFill(Color.RED);
            }
            else
            {
                s.setFill(Color.RED);
            }
        });
        
        green.setOnAction(e->{
            if(green.isSelected()&&list.getValue()=="Rectangle")
            {
                r.setFill(Color.GREEN);
            }
            else if(green.isSelected()&&list.getValue()=="Circle")
            {
                c.setFill(Color.GREEN);
            }
            else
            {
                s.setFill(Color.GREEN);
            }
        });
        
        blue.setOnAction(e->{
            if(blue.isSelected()&&list.getValue()=="Rectangle")
            {
                r.setFill(Color.BLUE);
            }
            else if(blue.isSelected()&&list.getValue()=="Circle")
            {
                c.setFill(Color.BLUE);
            }
            else
            {
                s.setFill(Color.BLUE);
            }
        });
        
        yes.setOnAction(e->{
            if(yes.isSelected())
        {
            pane.setStyle("-fx-background-color:LIGHTYELLOW;-fx-border-color:BLACK;");
        }
            else
            {
                pane.setStyle("-fx-background-color: WHITE;-fx-border-color:BLACK;");
            }
        });
        
        pane.setOnMouseClicked(e->{
            r.setFill(Color.BLACK);
            c.setFill(Color.BLACK);
            s.setFill(Color.BLACK);
        });
        ///////////////////////////////////////////////////////////////////////
        
        HBox panelforall=new HBox(vbox1,pane);
        panelforall.setMaxSize(600,300);
        panelforall.setPadding(new Insets(10,10,10,10));
        
        Scene scene=new Scene(panelforall);
        B.setTitle("LAB3 (B)");
        B.setScene(scene);
        B.show(); 
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {launch(args);}   
}