/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.Common.lib;

/**
 *
 * @author heikki
 */
class Symbol {

	private String content;
	private Symbol next;
	private Symbol prev;

	public Symbol(String content) {
		this.setContent(content);
	}

	private void setContent(String content) {
		this.content = content;
	}

	public boolean equals(String othersym) {
		return content.equals(othersym);
	}

	public Symbol getNext() {
		return next;
	}

	public Symbol getPrev() {
		return prev;
	}

	public void setNext(Symbol next) {
		this.next = next;
	}

	String getContent() {
		return this.content;
	}

	void setPrev(Symbol prev) {
		this.prev = prev;
	}
	

}
