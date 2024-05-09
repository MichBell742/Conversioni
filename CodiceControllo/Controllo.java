package it.edu.iisgubbio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controllo extends Application{

	TextField cCodiceCorretti=new TextField(); //sono i byte separati da uno spazio
	TextField cCodiceErrato=new TextField(); //sono i byte separati da uno spazio con un errore
	RadioButton rbBitDiParita=new RadioButton("bit di parità");
	RadioButton rbHamming=new RadioButton("Hamming");
	RadioButton rbBo2=new RadioButton();
	Label messaggio= new Label();
	Label controllo= new Label();
	Label esito= new Label();

	//TODO: creare un dizionario con il bit di parità e la rispettiva posizioni
	
	public void start(Stage finestra) {
		ToggleGroup controlli = new ToggleGroup();
		rbBitDiParita.setToggleGroup(controlli);
		rbHamming.setToggleGroup(controlli);
		rbBo2.setToggleGroup(controlli);
		Button bControlla= new Button("controlla");
		Label eMessaggio= new Label("messaggio:");
		Label eControllo= new Label("controllo:");
		Label eEsito= new Label("esito:");

		GridPane griglia=new GridPane();

		griglia.add(cCodiceCorretti, 		0, 0, 3, 1);
		griglia.add(rbBitDiParita, 	0, 1, 3, 1);
		griglia.add(rbHamming, 			0, 2, 3, 1);
		griglia.add(rbBo2, 			0, 3, 3, 1);
		griglia.add(eMessaggio, 	0, 4, 1, 1);
		griglia.add(messaggio, 		1, 4, 2, 1);
		griglia.add(eControllo, 	0, 5, 1, 1);
		griglia.add(controllo, 		1, 5, 2, 1);
		griglia.add(eEsito, 		0, 6, 1, 1);
		griglia.add(esito, 			1, 6, 1, 1);
		griglia.add(bControlla, 	2, 6, 1, 1);

		griglia.setPadding(new Insets(10,10,10,10));

		bControlla.setOnAction(e->verifica());

		Scene scena=new Scene(griglia);
		scena.getStylesheets().add("it/edu/iisgubbio/Stile.css");
		finestra.setTitle("Codici di controllo");
		finestra.setScene(scena);
		finestra.show();
	}

	public void verifica() {

		char parolaCodice[]= new char[12];
		String codice=cCodiceCorretti.getText();
		char[] charCodice=codice.toCharArray();
		System.out.println(parolaCodice.length);

		if(rbBitDiParita.isSelected()  ) {
			controllo.setText("bit di parità");
			int conta=0;
			String messaggio="";
			for(int i=0; i<charCodice.length; i++) {
				if(charCodice[i]=='1') {
					conta++;
				}
				if(i!=(charCodice.length-1)) {
					messaggio+=charCodice[i];
				}
			}
			if(conta%2==0) {
				esito.setText("Okay");
			}else {
				esito.setText("failed");
			}
			this.messaggio.setText(messaggio);
		}else if(rbHamming.isSelected()) {
			if(charCodice.length==12) {

			}else if(charCodice.length==8) {
				int offset=0;
				for(int i=0;i<parolaCodice.length;i++) {
					if(i==0 || i==1 || i==3 || i==7){
						offset++;
					}else {
						parolaCodice[i]=charCodice[i-offset];
					}
				}
				for(int i=0;i<parolaCodice.length;i++) {
					if(i==0 || i==1 || i==3 || i==7){
					}
				}
			}else {
				esito.setText("Pirla hai sbagliato");
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
