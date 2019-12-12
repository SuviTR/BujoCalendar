/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetropoliaAMKgroup02.BujoCalendar.model;

import MetropoliaAMKgroup02.BujoCalendar.model.settings.Setting;
import MetropoliaAMKgroup02.BujoCalendar.model.settings.Settings;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author heikki
 */
public class SettingsTest {

        static Settings instance;
        
        public SettingsTest() {
        }
        
        @BeforeAll
        public static void setUpClass() {
                SettingsTest.instance = Settings.getInstance(); 
        }
        
        @AfterAll
        public static void tearDownClass() {
        }
        
        @BeforeEach
        public void setUp() {
        }
        
        @AfterEach
        public void tearDown() {
        }

        @Test
        public void testSetting() {

        }

        /**
         * Test of setSetting method, of class Settings.
         */
        @Test
        public void testSetSetting() {
                System.out.println("setSetting");
                Setting setting = null;
                instance.addSetting(setting);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }
        
        /**
         * Test of getSettings method, of class Settings.
         */
        @Test
        public void testGetSettings() {
                System.out.println("getSettings");
                List<Setting> expResult = null;
                List<Setting> result = instance.getSettings();
                assertEquals(expResult, result);
                // TODO review the generated test code and remove the default call to fail.
                fail("The test case is a prototype.");
        }

}
