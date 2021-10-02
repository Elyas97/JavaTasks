package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class NoppaGUI extends Application implements view.NoppaView {
	NoppaController kontrolleri;
	Button btn;
	Label heitä;
	@Override
	public void init() {
		// MVC-rakenteeseen kuuluvan kontrollerin luonti
		kontrolleri = new NoppaController(this);
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane grid=new GridPane();
			Scene scene = new Scene(grid,400,400);
			 btn=new Button("Heitä noppaa");
			 heitä =new Label("Vastaus");
			grid.setAlignment(Pos.CENTER);
			grid.add(btn, 0, 2);
			grid.add(heitä, 0, 3);
			btn.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					kontrolleri.NopanHeitto();
				
				
				}
			});
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void setNoppa(String tulos,int heittomaara) {
		this.heitä.setText(tulos+". Heittoja:"+Integer.toString(heittomaara));
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
}
