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

public class ConvertiNumeroDecimale extends Application{
	
	TextField cNumeroDec= new TextField();
	TextField cConvertiA= new TextField();
	Label eNumeroConvertito= new Label("Numero convertito");
	
	Hashtable<Integer, Character> dizionario = new Hashtable<Integer, Character>(); //creo il dizionario
	
	
	
	public void start(Stage finestra){

		for(int i=0; i<10; i++) {
			int val=i+48;
			dizionario.put(i, (char)val);
		}
		dizionario.put(10, 'A');
		dizionario.put(11, 'B');
		dizionario.put(12, 'C');
		dizionario.put(13, 'D');
		dizionario.put(14, 'E');
		dizionario.put(15, 'F');
		dizionario.put(16, 'G');

		Button bConverti=new Button("Converti");

		Button bConvertiContrario=new Button("riconverti in decimale");
		
		Label eNumeroDecimale= new Label("Numero decimale");
		Label eBase= new Label("Base");
		
		GridPane griglia=new GridPane();
		
		griglia.add(eNumeroDecimale, 0, 0);
		griglia.add(cNumeroDec, 1, 0);
		griglia.add(eBase, 0, 1);
		griglia.add(cConvertiA, 1, 1);
		griglia.add(bConverti, 0, 2);
		griglia.add(bConvertiContrario, 1, 2);
		griglia.add(eNumeroConvertito, 0, 3,2,1);
		
		bConverti.setMaxWidth(1000);
		
		griglia.setPadding(new Insets(10,10,10,10));
		
		bConverti.setOnAction(e->converti());
		bConvertiContrario.setOnAction(e->convertiInDecimale());
		
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
		
		while(numero!=0) {
			numero=numeroConvertire/base;
			resto=numeroConvertire-numero*base;
			numeroConvertire=numero;
			if(base>10) {
				char restoChar=dizionario.get(resto);
				numeroConvertito=restoChar+numeroConvertito;
			}else {
				numeroConvertito=resto+numeroConvertito;
			}
			
		}
		eNumeroConvertito.setText(numeroConvertito);
	}

	public void convertiInDecimale() {
		char numeroConvertireCaratteri[]= cNumeroDec.getText().toCharArray();
		int numeroConvertireIntero[]= new int[numeroConvertireCaratteri.length];
		int base=Integer.parseInt(cConvertiA.getText());
		int numeroDecimale=0;
		int cont=0;
		for(int i=numeroConvertireCaratteri.length-1; i>=0; i--) {
			if(numeroConvertireCaratteri[i]>='0' && numeroConvertireCaratteri[i]<='9'){
				numeroConvertireIntero[i]=numeroConvertireCaratteri[i]-'0';
			}else if(numeroConvertireCaratteri[i]>='A' && numeroConvertireCaratteri[i]<='Z') {
				numeroConvertireIntero[i]=(numeroConvertireCaratteri[i]-'A')+10;
			}
			System.out.println(numeroConvertireIntero[i]);
		}
		for(int i=numeroConvertireIntero.length-1; i>=0; i--) {
			numeroDecimale+=numeroConvertireIntero[i]*Math.pow(base, cont);
			cont++;
		}
		eNumeroConvertito.setText(""+numeroDecimale);
	}
	public static void main(String[] args) {
		launch(args);
	}
}
