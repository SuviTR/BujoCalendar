/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.Backend.model;

/**
 *
 * @author heikki
 */
public class TestModel {

	private final String pet;
	private final String age;
	private final String name;
	
	public TestModel(String name, String age, String pet) {
		this.name = name;
		this.age = age;
		this.pet = pet;
	}

	public String getPet() {
		return pet;
	}

	public String getAge() {
		return age;
	}

	public String getName() {
		return name;
	}
}
