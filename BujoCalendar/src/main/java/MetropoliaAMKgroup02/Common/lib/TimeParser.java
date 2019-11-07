/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.Common.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.hibernate.mapping.Collection;

/**
 *
 * @author heikki
 */
public class TimeParser {

	private String original;
	private List<Symbol> words;
	private Symbol time;

	public TimeParser(String input) {
		this.original = input;
		this.parseString();
	}

	private void parseString() {
		this.words = new ArrayList<>();
		String[] words = this.original.split(" ");
		Symbol prev = null;
		for (int i=0; i < words.length; i++) {
			Symbol sym = new Symbol(words[i]);
			sym.setPrev(prev);
			if (prev != null) 
				prev.setNext(sym);
			this.words.add(sym);
			prev = sym;
		}
		/*List<String> wordList = Arrays.asList(words);
		Iterator<String> iter = wordList.iterator();
		while(iter.hasNext()) {
			Symbol sym = new Symbol(iter.next());
			sym.setNext();
			this.words.add(sym);
		}*/

		for (Symbol word : this.words) {
			if(klo(word)) {
				int i = 1;
			}
		}
	}

	private boolean klo(Symbol sym) {
		if(sym.equals("klo")) {
			Symbol time = sym.getNext();
			this.time = time;
			return true;
		}
		return false;
	}

	public Symbol getTime() {
		return this.time;
	}
	

}
