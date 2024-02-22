package it.edu.iisgubbio.conversioni;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ConvertiNumeroDecimale extends Application{
	
	TextField cNumeroDec= new TextField();
	TextField cConvertiA= new TextField();
	Label eNumeroConvertito= new Label("Numero convertito");
	
	public void start(Stage finestra){
		Button bConverti=new Button("Converti");
		
		Label eNumeroDecimale= new Label("Numero decimale");
		Label eBase= new Label("Base");
		
		GridPane griglia=new GridPane();
		
		griglia.add(eNumeroDecimale, 0, 0);
		griglia.add(cNumeroDec, 1, 0);
		griglia.add(eBase, 0, 1);
		griglia.add(cConvertiA, 1, 1);
		griglia.add(bConverti, 0, 2, 2, 1);
		griglia.add(eNumeroConvertito, 0, 3,2,1);
		
		bConverti.setMaxWidth(1000);
		
		griglia.setPadding(new Insets(10,10,10,10));
		
		bConverti.setOnAction(e->converti());
		
		Scene scena=new Scene(griglia);
		finestra.setTitle("conversioni numeri decimali");
		finestra.setScene(scena);
		finestra.show();
	}
	
	public void converti() {
		int numeroConvertire=Integer.parseInt(cNumeroDec.getText());
		int base=Integer.parseInt(cConvertiA.getText());
		int numero=numeroConvertire;
		int resto=0;
		String numeroConvertito="";
		char vettore[];
		while(numero!=0) {
			numero=numeroConvertire/base;
			resto=numeroConvertire-numero*base;
			numeroConvertire=numero;
			numeroConvertito=numeroConvertito+resto;
		}
		vettore=numeroConvertito.toCharArray();
		char invertiCon=0;
		for(int i = 0; i < vettore.length/2; i++) {
			invertiCon=vettore[i];
			vettore[i]=vettore[vettore.length-1-i];
			vettore[vettore.length-1-i]=invertiCon;
		}
		eNumeroConvertito.setText(new String(vettore));
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
