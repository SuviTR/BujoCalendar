package MetropoliaAMKgroup02.BujoCalendar.controller;

import MetropoliaAMKgroup02.BujoCalendar.fetchers.CalendarFetcher;
import MetropoliaAMKgroup02.BujoCalendar.utils.HttpConnection;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import MetropoliaAMKgroup02.BujoCalendar.model.FontMenu;
import MetropoliaAMKgroup02.BujoCalendar.utils.LangBundlePro;
import MetropoliaAMKgroup02.BujoCalendar.view.AlarmOverviewController;
import MetropoliaAMKgroup02.BujoCalendar.view.CalendarOverviewController;
import MetropoliaAMKgroup02.BujoCalendar.view.FontOverviewController;
import MetropoliaAMKgroup02.BujoCalendar.view.NoteOverviewController;
import MetropoliaAMKgroup02.BujoCalendar.view.RootLayoutController;
import MetropoliaAMKgroup02.Common.model.Merkinta;
import MetropoliaAMKgroup02.Common.model.TestModel;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* @author suvi
*/

public class MainApp extends Application {

	private Stage primaryStage;
    private BorderPane rootLayout;
    private CalendarOverviewController calController;
    private FontOverviewController fontController;
    private RootLayoutController rootController;
    private CalendarFetcher calendarFetcher;
    private NoteOverviewController noteController;
    private AlarmOverviewController alarmController;
    private boolean handleCurrentDate = false;
    
    /**
    * Starts the calendar application.
    * Opens the RootLayout and the Calendar view.
    * Creates language setting bundle, starts calendarFetcher
    * @param primaryStage is the primary stage of the application.
    */
	@Override
	public void start(Stage primaryStage) {
        AppController.getInstance().setMainApp(this);
        /* Setting language */
                String lang = "en";
                LangBundlePro country = new LangBundlePro( new Locale (lang));
        AppController.getInstance().SetLangBundlePro(country);

        // Show main window
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("My Bullet Journal Calendar");
		this.primaryStage.getIcons().add(new Image("https://static.thenounproject.com/png/769675-200.png"));
		
        // The main controller responsible of communication with the backend.
		calendarFetcher = new CalendarFetcher();
		initRootLayout();
		showCalendarOverview();
                
	}
	
	/**
    * Initializes the RootLayout of the application.
    * Opens the RootLayout view to primaryStage.
    */
    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            rootController = loader.getController();
        	rootController.setMainApp(this);
            
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Opens the calendar window that includes calendar week view.
     */
    public void showCalendarOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/CalendarOverview.fxml"));
            AnchorPane calendarOverview = (AnchorPane) loader.load();
            
            rootLayout.setCenter(calendarOverview);
            
            calController = loader.getController();
            calController.setMainApp(this);
            
		    calController.initView();
	
		    calendarFetcher.fetchAll();
	
		    calController.updateView();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Opens the font menu window where a user is able to choose new font style for the calendar fonts.
     * @return showController.isOkClicked() is true and window is open as far as a user clicks 
     * ok or close button.
     */
    public boolean showFontOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/FontOverview.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Valitse fontti");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            fontController = loader.getController();
            
            calController.callFontValue();
            
            fontController.setCalendarOverviewController(calController); 
            fontController.setDialogStage(dialogStage);
        
            dialogStage.showAndWait();
            
            return fontController.isOkClicked();
            
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean showNoteOverview() {
        return this.showNoteOverview(null);
    }
    
    /**
     * Opens the Note edit window where a user is able to edit a note information.
     * @return noteController.isOkClicked() is true and window is open as far as a user clicks 
     * ok or close button.
     */
    public boolean showNoteOverview(Merkinta merkinta) {
    
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/NoteOverview.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Merkintä");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            noteController = loader.getController();

            if (merkinta != null) {
                    noteController.setMerkinta(merkinta);
            }
            
            noteController.setRootLayoutController(rootController); 
            noteController.setCalendarFetcher(calendarFetcher);
            noteController.setDialogStage(dialogStage);
        
            dialogStage.showAndWait();
            
            return noteController.isOkClicked();
            
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void handleOpenNoteOverview() {
    	rootController.handleNewNote();
    }
    
    
    /**
     * Opens the Alarm window where a user is able to set alarm for the note.
     * @return alarmController.isOkClicked() is true and window is open as far as a user clicks 
     * ok or close button.
     */
    public boolean showAlarmOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/fxml/AlarmOverview.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Ilmoitus");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            alarmController = loader.getController();
            alarmController.setNoteOverviewController(noteController);
            
            noteController.setRootLayoutController(rootController);
            
            alarmController.setDialogStage(dialogStage);
        
            dialogStage.showAndWait();
            
            return alarmController.isOkClicked();
            
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Sets the window
     */   
    public void handleCurrentDate(boolean boolCurrentDate) {
    	//calController.handleCurrentDateOrSelectedDate("", boolCurrentDate);
    	calController.getCurrentDate();
    }

    /**
     * Displays a setting window of the application
     */
    public void showSettingsWindow() {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("/fxml/SettingsWindow.fxml"));
        try {
            AnchorPane page = (AnchorPane) loader.load();
            Scene scene = new Scene(page);
            Stage dialogStage = new Stage();
            dialogStage.setScene(scene);
            dialogStage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     * Conveys the date from MonthView to CalendarOverview.
     * @param date includes the date that a user has chosen from DatePicker in a MonthView.
     * @return date that was chosen from DatePicker in MontView.
     */
    public void handleSelectedDateView(String date, boolean boolCurrentDate) {
    	calController.handleCurrentDateOrSelectedDate(date, boolCurrentDate);
    }

    /**
     * Conveys the new font name from fontOverview to CalendarOverview.
     * @param value includes the new font name that a user has chosen as a new font.
     * @return value the name of the new font.
     */
    public int fontValue(int value) {
    	fontController.fontValue(value);
    	System.out.println("main " + value);
    	return value;
    }
    
    /**
     * Sets the window.
     * @return primaryStage returns the primary stage.
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Simple getter for CalendarFetcher
     * @return  CalendarFetcher
     */
    public CalendarFetcher getCalendarFetcher() {
	    return this.calendarFetcher;
    }
    
    /**
     * This is where the application is launched
     */
    public static void main(String[] args) {
	    launch(args);
    }

    /**
     * Updates Event model with a new data from Backend.
     */
    public void updateEvents() {
        calendarFetcher.fetchAll();
    }
}
