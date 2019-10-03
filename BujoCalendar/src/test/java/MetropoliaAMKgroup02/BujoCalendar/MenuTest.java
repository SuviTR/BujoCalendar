package MetropoliaAMKgroup02.BujoCalendar;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.GraphicsEnvironment;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import MetropoliaAMKgroup02.BujoCalendar.model.Menu;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;


class MenuTest {

private Menu menu = new Menu();

    @Test
    @DisplayName("Get all font families installed on the user's system")
    public void testGetFontList() {
    	//List<String> fonts = Font.getFamilies(); !Ei anna kaikkia fontteja!
    	
    	String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    	
    	ObservableList<MenuItem> fontsTest2 = menu.getFontList();
    	String[] fontsTest = new String[fontsTest2.size()];
    	int i = 0;

    	for (MenuItem item : fontsTest2) {
    		String name = item.getText();
    		fontsTest[i] = name;
    		i++;
    	}
    	
    	boolean boolTest = Arrays.equals(fonts, fontsTest);
        boolean bool = true;
    	
        assertEquals(bool,boolTest, "Menus are not equal.");
    }
}
