/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.Common.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author heikki
 */
public class JSONHandler {
	protected ObjectMapper mapper;

	public JSONHandler() {
		this.mapper = new ObjectMapper();
	}

	public Object JSONToObj(String json, Class typeclass) {

		try {
			Object object = this.getMapper().readValue(json, typeclass);
			return object;
		} catch (IOException ex) {
			Logger.getLogger(JSONHandler.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	public String ObjToJSON(Object obj) {

		String json = "";
		try {
			json = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException ex) {
			Logger.getLogger(JSONHandler.class.getName()).log(Level.SEVERE, null, ex);
		}
		return json;
	}

	private ObjectMapper getMapper() {
		return this.mapper;
	}
}


