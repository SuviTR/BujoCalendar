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
public class Parser {

	private String original;
	private List<Symbol> words;
	private Symbol time;
    private Symbol curSym;

	public Parser(String input) {
		this.original = input;
        this.prepareString();
		this.parse();
	}

    /**
     * This function prepares this.original to be parsed.
     * 
     * It splits original string by spaces and converts all
     * the words to Symbol objects. They are stored in a list
     * this.words.
     */
	private void prepareString() {
		this.words = new ArrayList<>();
		Symbol prev = null;
		for (String word : this.original.split(" ")) {
			Symbol sym = new Symbol(word);
			sym.setPrev(prev);
			if (prev != null) 
				prev.setNext(sym);
			this.words.add(sym);
			prev = sym;
		}
        curSym = this.words.get(0);
	}

    /**
     * This goes through this.words and checks if they are
     * pre-defined tokens.
     */
    private void parse(){
            while(getNext()) {
			if(klo()) {
				int i = 1;
			}
		}
    }

    private boolean getNext() {
            if(curSym.getNext() == null) {
                    return false;
            }
            curSym = curSym.getNext();
            return true;
    }

    /**
     * Accepts a certain symbol.
     * @param symbol
     * @return 
     */
    private boolean accept(String symbol) {
            if(curSym.equals(symbol)) {
                    return true;
            }
            return false;
    }

	private boolean klo() {
		if(accept("klo")) {
                // Next from the token:
			Symbol time = curSym.getNext();
			this.time = time;
			return true;
		}
		return false;
	}

	public Symbol getTime() {
		return this.time;
	}
	

}
