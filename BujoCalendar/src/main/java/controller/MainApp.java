package controller;

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
import model.Menu;
import view.CalendarOverviewController;
import view.FontOverviewController;

public class MainApp extends Application {

	private Stage primaryStage;
    private BorderPane rootLayout;
    private Menu menu;
    private CalendarOverviewController calController;
    private FontOverviewController fontController;
    
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("My Bullet Journal Calendar");
        this.primaryStage.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVbn-ai60RDWdSSz89ZGkqRrLqTh4tRRIWe-zGYGi1NyV-0b59"));
        
        initRootLayout();

        showCalendarOverview();
	}
	
    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCalendarOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/CalendarOverview.fxml"));
            AnchorPane calendarOverview = (AnchorPane) loader.load();
            
            rootLayout.setCenter(calendarOverview);
            
            calController = loader.getController();
            calController.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean showFontOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/FontOverview.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Valitse fontti");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            this.fontController = loader.getController();
            fontController.setCalendarOverviewController(calController); 
            fontController.setDialogStage(dialogStage);
        
            dialogStage.showAndWait();

            return fontController.isOkClicked();
            
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
	public static void main(String[] args) {
		launch(args);
	}
}
