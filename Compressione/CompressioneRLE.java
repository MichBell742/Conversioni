package it.edu.iisgubbio.compressioneRLE;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CompressioneRLE extends Application{

	char immagine[][]= {{'v','b','b'},
						{'g','g','g'},
						{'b','c','d'}};
	
	Label pesoNonCompresso= new Label("-----------------");
	Label pesoCompresso= new Label("-----------------");
	Label rate= new Label("-----------------");
	
	public void start(Stage finestra) {
		GridPane griglia=new GridPane();
		
		Label ePesoNonCompresso= new Label("peso non compresso");
		Label ePesoCompresso= new Label("peso compresso");
		Label eRate= new Label("compressione rate");
		
		Button calcola=new Button("calcola");
		
		
		
		griglia.add(ePesoNonCompresso,0,0);
		griglia.add(pesoNonCompresso,1,0);
		griglia.add(ePesoCompresso,0,1);
		griglia.add(pesoCompresso,1,1);
		griglia.add(eRate,0,2);
		griglia.add(rate,1,2);
		griglia.add(calcola,1,3);
		
		griglia.setHgap(10);
		griglia.setVgap(10);
		griglia.setPadding(new Insets(10,10,10,10));
		
		calcola.setOnAction(e->calcolaDati());
		
		Scene scena=new Scene(griglia);
		finestra.setTitle("compressione RLE");
		finestra.setScene(scena);
		finestra.show();
	}
	
	public void calcolaDati() {
		double pesoTotale= immagine.length*immagine[0].length*24;
		int primoElemento=immagine[0][0];
		int contaRipetizioni=0;
		int pesoTotaleCompresso=0;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3;j++) {
				System.out.println(immagine[i][j]);
				if(primoElemento==immagine[i][j]) {
					contaRipetizioni++;
					System.out.println("corrisponde "+contaRipetizioni);
				}else {
					int lunghezza=converti(contaRipetizioni).length();
					pesoTotaleCompresso+=lunghezza+24;
					contaRipetizioni=1;
					primoElemento=immagine[i][j];
				}
			}
		}
		int lunghezza=converti(contaRipetizioni).length();
		pesoTotaleCompresso+=lunghezza+24;
		System.out.println("finale "+ pesoTotaleCompresso);
		pesoNonCompresso.setText(""+pesoTotale);
		pesoCompresso.setText(""+pesoTotaleCompresso);
		double risultato=100-((pesoTotaleCompresso/pesoTotale)*100);
		rate.setText(""+risultato);
	}
	public String converti(int numeroConvertire) {
		int base=2;
		int numero=numeroConvertire;
		int resto=0;
		String numeroConvertito="";
		
		while(numero!=0) {
			numero=numeroConvertire/base;
			resto=numeroConvertire-numero*base;
			numeroConvertire=numero;
			numeroConvertito=resto+numeroConvertito;
			
		}
		return numeroConvertito;
	}
	public static void main(String[] args) {
		launch(args);
	}
}
