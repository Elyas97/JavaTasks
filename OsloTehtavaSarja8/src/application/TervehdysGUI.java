package application;
	
import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class TervehdysGUI extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Tervehdyksiä");
			BorderPane root = new BorderPane();
			Button Aamu =new Button("Aaamu");
			Button Päivä =new Button("Päivä");
			Button Ilta =new Button("ilta");
			Button Yö =new Button("yö");
			Text txt=new Text("Napsauta painiketta");
			Aamu.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
				System.out.println("Hyvää huomenta!");
				txt.setText("Hyvää Huomenta");
				txt.setFont(Font.font("Arial",FontWeight.BOLD,20));
				
		
				}
			});
			Päivä.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
				System.out.println("Hyvää Päivää!");
				txt.setText("Hyvää Päivää");
				txt.setFont(Font.font("Arial",FontWeight.BOLD,20));
				
				root.setTop(txt);
				}
			});
			Ilta.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
				System.out.println("Hyvää iltaa!");
				txt.setText("Hyvää iltaa");
				txt.setFont(Font.font("Arial",FontWeight.BOLD,20));
				
				
				}
			});
			Yö.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
				System.out.println("Hyvää yötä!");
				txt.setText("Hyvää yötä");
				txt.setFont(Font.font("Arial",FontWeight.BOLD,20));
				
				
				}
			});
			
			root.setTop(txt);
			BorderPane.setAlignment(txt,Pos.CENTER);
			root.setCenter(Aamu);
			root.setLeft(Päivä);
			BorderPane.setAlignment(Päivä,Pos.CENTER);
			root.setRight(Ilta);
			BorderPane.setAlignment(Ilta,Pos.CENTER);
			root.setBottom(Yö);
			BorderPane.setAlignment(Yö,Pos.CENTER);
		
			
			Scene scene = new Scene(root,300,150);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
