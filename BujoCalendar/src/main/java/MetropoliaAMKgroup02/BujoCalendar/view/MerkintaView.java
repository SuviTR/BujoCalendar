/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.BujoCalendar.view;

import MetropoliaAMKgroup02.Common.model.Merkinta;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author heikki
 */
public class MerkintaView {
	
	private final Merkinta merkinta;
	private GridPane container;

	public MerkintaView(Merkinta merkinta) {
		this.merkinta = merkinta;
		this.container = new GridPane();
		Label label = new Label(merkinta.getNimi());
		label.setWrapText(true);
		this.container.add(label,0,0);
		 

	}

	public int getStartTime() {
		return this.merkinta.getHour();
	}

	public int getEndTime() {
		return this.merkinta.getEndHour();
	}

	public int getLength() {
		return getEndTime() - getStartTime();
	}

	public GridPane getGridPane() {
		return this.container;
	}

}
