package view;


import controller.ValuuttakoneenOhjain;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Valuuttakone;

public class ValuuttakoneenGUI extends Application implements IValuuttakoneenUI {
	ValuuttakoneenOhjain kontrolleri1;
	Valuuttakone valuutta =new Valuuttakone();
	
	ListView<String> valuuttaLista;
	ListView<String> valuuttaMihin;
	TextField maara;
	TextField tulosNaytto;
	public void init() {
	// MVC-rakenteeseen kuuluvan kontrollerin luonti
	kontrolleri1 = new ValuuttakoneenOhjain(this,valuutta);
}
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Valuutta muunnin");

			HBox root = createHBox();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private HBox createHBox() {
		// Perusrakenteena vaakasuuntaineni

		HBox hBox = new HBox();
		hBox.setPadding(new Insets(15, 12, 15, 12)); // marginaalit ylä, oikea, ala, vasen
		hBox.setSpacing(10); // väliiin 10 pikseliä
		hBox.setStyle("-fx-background-color: #F2EAE9");

		// Tuotteet (kaksi ListView-kontrollia: vaatteille ja väreille):

		 
		valuuttaLista = new ListView<String>();
		valuuttaLista.setPrefSize(130, 120);

		ObservableList<String> valuutat = FXCollections.observableArrayList();
		valuutat.addAll(kontrolleri1.getValuutat());
		valuuttaLista.setItems(valuutat);
	

		// laita ListView VBoxiin, niin saadaan otsikko yläpuolelle
		VBox vaateBox = new VBox();
		vaateBox.getChildren().addAll(new Label("Mistä"), valuuttaLista);

		valuuttaMihin = new ListView<String>();
		valuuttaMihin.setPrefSize(130, 120);
		ObservableList<String> valuutat2 = FXCollections.observableArrayList();
		valuutat2.addAll(kontrolleri1.getValuutat());
		valuuttaMihin.setItems(valuutat2);

		// laita ListView VBoxiin , niin saadaan otsikko yläpuolelle
		VBox väriBox = new VBox();
		väriBox.getChildren().addAll(new Label("Mihin"), valuuttaMihin);

		// Ostajan tiedot (ruudukkona)

		GridPane ostajaGrid = new GridPane();

		ostajaGrid.setHgap(5);
		ostajaGrid.setVgap(5);
		ostajaGrid.setPadding(new Insets(0, 10, 0, 10));

		Label ostajaLabel = new Label("Määrä");
		ostajaGrid.add(ostajaLabel, 0, 0, 2, 1);

		maara = new TextField();
		ostajaGrid.add(maara, 0, 1, 1, 1);

		Button muunna = new Button("Muunna");
		
		ostajaGrid.add(muunna, 0, 2,1,1);
		muunna.setPrefSize(150,20);
		

		Label tulos = new Label("Tulos");
		ostajaGrid.add(tulos, 0, 3, 1, 1);
		
		tulosNaytto = new TextField();
		ostajaGrid.add(tulosNaytto, 0, 4, 1, 1);
	
		
		// Lambda-lauseke ja anonyymi funktio
		muunna.setOnAction((event) -> {
			kontrolleri1.muunnos();
		});
		
		// Täytä pääboxi:
		hBox.getChildren().addAll(vaateBox, väriBox, ostajaGrid);
		return hBox;
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public int getLähtöIndeksi() {
		return valuuttaLista.getSelectionModel().getSelectedIndex();
	}

	@Override
	public int getKohdeIndeksi() {
		return valuuttaMihin.getSelectionModel().getSelectedIndex();
	}

	@Override
	public double getMäärä() {
		double paluuarvo=0;
		try {
			paluuarvo=Double.parseDouble(maara.getText());
		}catch(Exception e) {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Ei numero");
			alert.setContentText("Syötä vain numeroita");
			alert.showAndWait();	
		}
		return paluuarvo;
	}

	@Override
	public void setTulos(double määrä) {
		tulosNaytto.setText(Double.toString(määrä));
		
	}

}
