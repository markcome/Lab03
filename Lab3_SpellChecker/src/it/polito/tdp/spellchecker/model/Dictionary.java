package it.polito.tdp.spellchecker.model;

import java.util.*;

public class Dictionary {
	
	Set<String> dizionario;
	
	/**
	 * @param dizionario
	 */
	public Dictionary() {
		super();
		this.dizionario = new HashSet<String>();
	}

	public boolean checkWord(String word) {
		Iterator<String> it = dizionario.iterator();
		while(it.hasNext()){
			if(it.next().equals(word))
				return true;
		}	
		return false;
	}
}
