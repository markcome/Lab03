package it.polito.tdp.spellchecker.model;

public class Word {
	
	private String word;
	private boolean right;
	
	
	/**
	 * @param word parola inserita
	 * @param right indica con TRUE se è corretta e FALSE se è errata
	 */
	public Word(String word) {
		super();
		this.word = word;
		this.right = false;
	}


	/**
	 * @return the right, ovvero se la parola è giusta o sbagliata
	 */
	public boolean isRight() {
		return right;
	}


	/**
	 * @param right setto giusta la parola
	 */
	public void setRight() {
		this.right = true;
	}
	

	/**
 * @return the word
	 */
	public String getWord() {
		return word;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (right ? 1231 : 1237);
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (right != other.right)
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}




	
}
