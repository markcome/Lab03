package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class SpellCheckerController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cmbLanguage;

    @FXML
    private TextArea txtInsert;

    @FXML
    private Button btnSpellCheck;

    @FXML
    private TextArea txtErrors;

    @FXML
    private Label lblErrori;

    @FXML
    private Button btnClearText;

    @FXML
    private Label lblTime;

    @FXML
    void doClearText(ActionEvent event) {
    	
    	this.txtInsert.setEditable(true);
    	this.txtInsert.setDisable(false);
    	this.btnSpellCheck.setDisable(false);
    	
    	this.txtErrors.clear();
    	this.txtInsert.clear();
    	this.lblErrori.setText("The text contains 0 errors");
    	this.lblTime.setText("Spell check time");
    	this.lblErrori.setTextFill(Color.BLACK);
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	
    	this.model.setLanguage(this.cmbLanguage.getValue());
    	
    	Long t1 = System.nanoTime();
    	LinkedList<String> correzione = new LinkedList<String>();
    	correzione = model.correzioneOrotografica(this.txtInsert.getText());
    	Long t2 = System.nanoTime();
		
    	if(correzione.size() == 0){
    		this.lblErrori.setTextFill(Color.GREEN);
    		this.lblErrori.setText("The text is completely correct");
    	}else{
    		this.lblErrori.setTextFill(Color.RED);
    		this.lblErrori.setText("The text contains " + correzione.size() + " errors");
    	}
    	this.lblTime.setText("Spell check completed in " + ((t2-t1)/1e9) + " seconds");
		
		
    	for(String s: correzione)
    		this.txtErrors.appendText(s + "\n");
    	
    	this.txtInsert.setEditable(false);
    	this.txtInsert.setDisable(true);
    	this.btnSpellCheck.setDisable(true);
    }

    @FXML
    void initialize() {
        assert cmbLanguage != null : "fx:id=\"cmbLanguage\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtErrors != null : "fx:id=\"txtErrors\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblErrori != null : "fx:id=\"lblErrori\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblTime != null : "fx:id=\"lblTime\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        
        this.cmbLanguage.getItems().addAll("English", "Italian");
        if(cmbLanguage.getItems().size() > 0)
        	cmbLanguage.setValue(cmbLanguage.getItems().get(0));
    }


	public void setModel(Model model) {
		this.model = model;
	}
}

