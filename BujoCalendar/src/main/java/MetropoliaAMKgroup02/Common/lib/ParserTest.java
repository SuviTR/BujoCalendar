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
public class ParserTest {
	
	public static void main(String[] args) {
		TimeParser parser = new TimeParser("Lounas klo 16:00 tänään");
		Symbol time = parser.getTime();
		System.out.println(time.getContent());
	}
}
