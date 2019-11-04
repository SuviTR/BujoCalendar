package MetropoliaAMKgroup02.BujoCalendar.controller;

import MetropoliaAMKgroup02.BujoCalendar.model.HttpConnection;
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
import MetropoliaAMKgroup02.BujoCalendar.view.AlarmOverviewController;
import MetropoliaAMKgroup02.BujoCalendar.view.CalendarOverviewController;
import MetropoliaAMKgroup02.BujoCalendar.view.FontOverviewController;
import MetropoliaAMKgroup02.BujoCalendar.view.NoteOverviewController;
import MetropoliaAMKgroup02.BujoCalendar.view.RootLayoutController;
import MetropoliaAMKgroup02.Common.model.Merkinta;
import MetropoliaAMKgroup02.Common.model.TestModel;

/**
* @author suvi
*/

public class MainApp extends Application {

	private Stage primaryStage;
    private BorderPane rootLayout;
    private CalendarOverviewController calController;
    private FontOverviewController fontController;
    private RootLayoutController rootController;
    private CalendarController calendarController;
    private NoteOverviewController noteController;
    private AlarmOverviewController alarmController;
    private boolean handleCurrentDate = false;
    /**
    * Starts the calendar application.
    * Opens the RootLayout and the Calendar view.
    * @param primaryStage is the primary stage of the application.
    */
	@Override
	public void start(Stage primaryStage) {
		/*TestModel testi = new TestModel("Pertti", "52", "Murre");
		HttpClient backend = new HttpClient();
		backend.post("/test", testi, TestModel.class);
	//	Merkinta merkinta = new Merkinta();
	//	backend.post("/calendar", merkinta, Merkinta.class);
	*/	
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("My Bullet Journal Calendar");
		this.primaryStage.getIcons().add(new Image("https://stickershop.line-scdn.net/stickershop/v1/product/3238751/LINEStorePC/main.png;compress=true"));
		
		calendarController = new CalendarController();
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
     * Opens Calendar view.
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
	
		    //calendarController.fetchAll();
	
		    calController.updateView();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Opens the view where a user can change different calendar's fonts.
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
            
            noteController.setRootLayoutController(rootController); 
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
    
    public void handleCurrentDate(boolean boolCurrentDate) {
    	calController.handleCurrentDateOrSelectedDate("", boolCurrentDate);
    }
    
    /**
     * Conveys the date from MonthView to CalendarOverview.
     * @param date includes the date that a user has chosen from DatePicker in a MonthView.
     * @return date that was chosen from DatePicker in MontView.
     */
    public void handleSelectedDateView(String date, boolean boolCurrentDate) {
    	calController.handleCurrentDateOrSelectedDate(date, boolCurrentDate);
    	//calController.handleSelectedDateView(date);
    	//return date;
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
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public CalendarController getCalendarController() {
	    return this.calendarController;
    }
    
    public static void main(String[] args) {
	    launch(args);
    }
}
