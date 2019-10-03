/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.Common;

/**
 *
 * @author heikki
 */
public class TestModel {

	public String pet;
	public String age;
	public String name;

	public TestModel() {

	}

	public TestModel(String givenname, String givenage, String givenpet) {
		this.age = givenage;
		this.name = givenname;
		this.pet = givenpet;
	}
	
	public String getPet() {
		return pet;
	}
	public void setPet(String pet) {
		this.pet = pet;
	}

	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
