package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Thushara Supun
 */
public class LoadingController implements Initializable {

    @FXML
    private AnchorPane loadingAnchPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.gc();

        applyFadeTransition(loadingAnchPane, Duration.seconds(1), (evt) -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/view/home.fxml"));
                Scene scene = new Scene(root);
                Stage temp = (Stage) this.loadingAnchPane.getScene().getWindow();
                temp.close();
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.getIcons().add(new Image("/asset/image/gameIcon.png"));
                stage.centerOnScreen();
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();

                TranslateTransition trans = new TranslateTransition(Duration.millis(300), scene.getRoot());
                trans.setFromY(-scene.getHeight());
                trans.setToY(0);
                trans.play();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    public void applyFadeTransition(Node node, Duration duration, EventHandler<ActionEvent> event) {
        javafx.animation.FadeTransition fadeIn = new javafx.animation.FadeTransition(duration, node);
        fadeIn.setCycleCount(1);
        fadeIn.setFromValue(0.8);
        fadeIn.setToValue(1);
        fadeIn.setAutoReverse(true);
        fadeIn.setOnFinished(event);

        javafx.animation.FadeTransition fadeOut = new javafx.animation.FadeTransition(duration, node);
        fadeOut.setCycleCount(1);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0.8);
        fadeOut.setAutoReverse(true);

        fadeOut.play();
        fadeOut.setOnFinished((evt) -> {
            fadeIn.play();
        });
    }

}
