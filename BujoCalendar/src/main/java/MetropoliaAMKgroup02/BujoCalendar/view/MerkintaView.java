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
		this.container.add(new Label(merkinta.getNimi()),0,0);
                this.container.setOnMouseClicked((t) -> {
                    this.eventActivated();
                });
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
        
        private void eventActivated() {
            System.out.println("Event " + this.merkinta.getNimi() + " activated");
            //This could work for example like:
            // AppController.getInstance().getMainApp().openNoteOverview(this.merkinta);
        }

}
