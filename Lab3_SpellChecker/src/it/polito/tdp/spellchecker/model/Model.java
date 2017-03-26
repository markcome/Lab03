package it.polito.tdp.spellchecker.model;

import java.util.*;

public class Model {

	private Dictionary dizionario;
	private String[] languages;
	private List<Word> paroleInserite;
	
	/**
	 * @param parole parole che si vogliono controllare
	 * @param language lingua del dizionario
	 */
	public Model() {
		super();
		this.languages = new String[]{"Italian", "English"};
		this.paroleInserite = new LinkedList<Word>();
		
	}
	
	/**
	 * Carica il dizionario corrispondente alla lingua selezionata
	 * @param language lingua selezionata
	 */
	public void setLanguage (String language){
		if(language.equals(languages[0]))
			this.dizionario = new ItalianDictionary();
		else
			this.dizionario = new EnglishDictionary();
	}
	
	/**
	 * Riceve la lista delle parole inserite dall'utente e ritorna la lista delle parole sbagliate
	 * @param paroleInserite Lista delle parole inserite dall'utente
	 * @return Lista delle parole sbagliate
	 */
	public LinkedList<String> correzioneOrotografica (String stringaInserimento){
		LinkedList<String> correzzione = new LinkedList<String>();
		this.paroleInserite.clear();
		
		//Acquisisco parole inserite da stringa inserimento
		stringaInserimento.replaceAll("[ \\p{Punct}]", "");
		String[] array = stringaInserimento.split(" ");
		
		for(String s: array)
			paroleInserite.add(new Word(s));
		
		//Setto a TRUE le parole corrette e lascio a FALSE le parole sbagliate
		for(Word w: paroleInserite){
			if(this.dizionario.checkWord(w.getWord()))
				w.setRight();
		}
		
		//Aggiungo alla lista collezione le stringhe sbagliate
		for(Word w: paroleInserite){
			if(!w.isRight())
				correzzione.add(w.getWord());
		}
		return correzzione;
	}
	
	
}
