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
						{'b','v','n'}};
	
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
		int pesoTotale= 3*3*24;
		int primoElemento=immagine[0][0];
		int contaRipetizioni=1;
		int pesoTotaleCompresso=0;
		for(int i=0; i<3; i++) {
			for(int j=1; j<3;j++) {
				if(primoElemento==immagine[i][j]) {
					contaRipetizioni++;
				}else {
					pesoTotaleCompresso=contaRipetizioni+24;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
