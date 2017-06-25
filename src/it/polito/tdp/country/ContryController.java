/**
 * Sample Skeleton for 'Country.fxml' Controller Class
 */

package it.polito.tdp.country;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.country.model.Country;
import it.polito.tdp.country.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class ContryController {

	Model model;
	
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="boxPartenza"
    private ComboBox<Country> boxPartenza; // Value injected by FXMLLoader

    @FXML // fx:id="boxDestinazione"
    private ComboBox<Country> boxDestinazione; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

 
    

    @FXML
    void handlePercorso(ActionEvent event) {

    	Country destinazione = boxDestinazione.getValue();
    	List<Country> percorso = model.getPercorso(destinazione);
    	txtResult.clear();
    	System.out.println(percorso);
    	txtResult.appendText(percorso.toString());
    	
    }

    @FXML
    void handleRaggiungibili(ActionEvent event) {
    	
    	Country partenza = boxPartenza.getValue();
    	if(partenza==null){
    		txtResult.appendText("ERRORE, devi selezionare uno stato di partenza!\n");
    		return;
    	}
    	List<Country> raggiungibili = model.getRaggiungibili(partenza);
    	txtResult.clear();
    	txtResult.setText(raggiungibili.toString());
    	//riempiamo la seconda tendina
    	boxDestinazione.getItems().clear();//cancello gli elementi presenti dalla volta prima
    	boxDestinazione.getItems().addAll(raggiungibili);
    }
    public void setModel(Model model){
    	this.model = model;
    	boxPartenza.getItems().addAll(model.getCountries());
    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert boxPartenza != null : "fx:id=\"boxPartenza\" was not injected: check your FXML file 'Country.fxml'.";
        assert boxDestinazione != null : "fx:id=\"boxDestinazione\" was not injected: check your FXML file 'Country.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Country.fxml'.";

    }
}
