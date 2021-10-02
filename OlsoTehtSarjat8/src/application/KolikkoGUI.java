package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.IView;

public class KolikkoGUI extends Application implements IView{
	KolikkoController kontrolleri1;
	Button btn;
	Label heitä;
	public void init() {
		// MVC-rakenteeseen kuuluvan kontrollerin luonti
		kontrolleri1 = new KolikkoController(this);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		try {
			GridPane grid=new GridPane();
			Scene scene = new Scene(grid,400,400);
			 btn=new Button("Heitä kolikko");
			 heitä =new Label("Vastaus");
			grid.setAlignment(Pos.CENTER);
			grid.add(btn, 0, 2);
			grid.add(heitä, 0, 3);
			btn.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					kontrolleri1.NopanHeitto();
				
				
				}
			});
			
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


	@Override
	public void naytaTulos(String tulos, int heittoMaara) {
		this.heitä.setText(tulos+", Heittomaara"+Integer.toString(heittoMaara));
		
	}

}
