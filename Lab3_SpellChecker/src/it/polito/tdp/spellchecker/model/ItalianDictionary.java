package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class ItalianDictionary extends Dictionary{
	
	public ItalianDictionary() {
		super();
		try {
				FileReader fr = new FileReader("rsc/Italian.txt"); 
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


//	@Override
//	public boolean checkWord(String word) {
//		Iterator<String> it = dizionario.iterator();
//		while(it.hasNext()){
//			if(it.next().equals(word))
//				return true;
//		}	
//		return false;
//	}
}


