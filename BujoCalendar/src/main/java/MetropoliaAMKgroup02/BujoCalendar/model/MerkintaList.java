/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.BujoCalendar.model;

import MetropoliaAMKgroup02.Common.model.Merkinta;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 *
 * @author heikki
 */
public class MerkintaList {
	
	private HashMap<Calendar, Merkinta> events;

	public MerkintaList() {
	}

	public void addMerkinta(Merkinta merkinta) {
		this.events.put(merkinta.getStart(), merkinta);
	}

	public HashMap<Calendar, Merkinta> getAll() {
		return events;
	}

	public List<Calendar> getDay(Calendar day) {
		return events.entrySet().stream().filter(date -> date == day)
			.map(Entry::getKey).collect(Collectors.toList());

	}
}
