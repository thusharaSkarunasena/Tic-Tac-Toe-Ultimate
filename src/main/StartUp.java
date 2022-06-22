package main;

import java.util.Optional;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 *
 * @author Thushara Supun
 */
public class StartUp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/loading.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("/asset/image/gameIcon.png"));
        primaryStage.centerOnScreen();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

        primaryStage.setOnCloseRequest(event -> {
            event.consume();
            Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION);
            exitAlert.setTitle("Exit?");
            exitAlert.setContentText(" Are You Sure to Exit?");
            Optional<ButtonType> action = exitAlert.showAndWait();

            if (action.get() == ButtonType.OK) {
                System.exit(0);
                Platform.exit();
            }
        });

        FadeTransition trans = new FadeTransition(Duration.millis(500), root);
        trans.setFromValue(0.02);
        trans.setToValue(1);
        trans.play();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
