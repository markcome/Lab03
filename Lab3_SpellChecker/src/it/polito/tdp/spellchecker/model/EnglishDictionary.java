package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class EnglishDictionary extends Dictionary {
	
	public EnglishDictionary() {
		super();
		try {
				FileReader fr = new FileReader("rsc/English.txt"); 
				BufferedReader br = new BufferedReader(fr); 
				String word;
				while ((word = br.readLine()) != null) {
				      // Aggiungere parola alla struttura dati
					this.dizionario.add(word.trim());
				}
				br.close();
			} catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}
		}

}
