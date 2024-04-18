package it.edu.iisgubbio.conversioni;

import java.util.Hashtable;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BinaryCodedDecimal extends Application{
	
	TextField cNumeroDec= new TextField();
	Label eNumeroConvertito= new Label("Numero convertito");
	
	Hashtable<Character, String> dizionario = new Hashtable<Character, String>(); //creo il dizionario
	
	public void start(Stage finestra){
		

		dizionario.put('0', "0000");
		dizionario.put('1', "0001");
		dizionario.put('2', "0010");
		dizionario.put('3', "0011");
		dizionario.put('4', "0100");
		dizionario.put('5', "0101");
		dizionario.put('6', "0110");
		dizionario.put('7', "0111");
		dizionario.put('8', "1000");
		dizionario.put('9', "1001");
		
		//converti da una numero decimale a BCD
		Button bConverti=new Button("Converti");
		
		Label eNumeroDecimale= new Label("Numero decimale");
		Label eBase= new Label("Base");
		
		GridPane griglia=new GridPane();
		
		griglia.add(eNumeroDecimale, 0, 0);
		griglia.add(cNumeroDec, 1, 0);
		griglia.add(bConverti, 0, 2, 2, 1);
		griglia.add(eNumeroConvertito, 0, 3, 2, 1);
		
		bConverti.setMaxWidth(1000);
		
		griglia.setPadding(new Insets(10,10,10,10));
		
		bConverti.setOnAction(e->converti());
		
		Scene scena=new Scene(griglia);
		finestra.setTitle("conversioni numeri decimali");
		finestra.setScene(scena);
		finestra.show();
	}
	public void converti() {
		char[] numeroDaConvertire=cNumeroDec.getText().toCharArray();
		String valoreFinale="";
		for(int i=0; i<numeroDaConvertire.length; i++) {
			if(valoreFinale.equals("")) {
				valoreFinale+=dizionario.get(numeroDaConvertire[i]);
			}else {
				valoreFinale+=" "+dizionario.get(numeroDaConvertire[i]);
			}
		}
		eNumeroConvertito.setText(valoreFinale);
	}
	public static void main(String[] args) {
		launch(args);
	}
}