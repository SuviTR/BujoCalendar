/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.BujoCalendar.model;

import MetropoliaAMKgroup02.Common.model.Merkinta;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 *
 * @author heikki
 */
public class MerkintaList {
	
	private List<Merkinta> events;

	public MerkintaList() {
		events = new ArrayList<>();
	}

	public void addMerkinta(Merkinta merkinta) {
		this.events.add(merkinta);
	}

	public List<Merkinta> getAll() {
		return events;
	}

	public List<Merkinta> getDay(Calendar day) {
		//Start will be at midnight
		Calendar start = (Calendar) day.clone();
		start.set(Calendar.HOUR_OF_DAY, 0);
		start.set(Calendar.MINUTE, 0);
		start.set(Calendar.SECOND, 0);
		start.set(Calendar.MILLISECOND, 0);
		//End is one day after start
		Calendar end = (Calendar) start.clone();
		end.add(Calendar.DAY_OF_MONTH, 1);
			
		return events.stream().filter(merkinta -> merkinta.getStart().after(start) && merkinta.getStart().before(end))
			.collect(Collectors.toList());

	}

	public void importArray(Merkinta[] merkinnat) {
		for(int i = 0; i < merkinnat.length; i++) {
			this.addMerkinta(merkinnat[i]);
		}
	}
}
