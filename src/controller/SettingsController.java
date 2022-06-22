package controller;

import com.jfoenix.controls.JFXToggleButton;
import db.DBUtil;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Thushara Supun
 */
public class SettingsController implements Initializable {

    @FXML
    private ImageView closeIcon;
    @FXML
    private ImageView homeIcon;
    @FXML
    private AnchorPane settingsAnchPane;
    @FXML
    private JFXToggleButton soundToggleBtn;
    @FXML
    private JFXToggleButton darkThemeToggleBtn;
    @FXML
    private JFXToggleButton animationToggleBtn;

    private int soundState = 0;
    private final String confirmMessageSoundPath = "src/asset/audio/audio5.wav";
    private AudioClip audioClip;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.gc();

        darkThemeToggleBtn.setSelected(false);
        darkThemeToggleBtn.setDisable(true);

        animationToggleBtn.setSelected(true);
        animationToggleBtn.setDisable(true);

        try {
            checkGamePlaySoundState();
            loadGamePlaySound();

            setSoundToggleBtnCurrentState();
        } catch (Exception ex) {
            printDBErrorAndExit(ex);
        }
    }

    private void checkGamePlaySoundState() throws Exception {
        String sql = "SELECT state FROM settings WHERE setting = 'sound'";
        ResultSet rst = DBUtil.executeQuery(sql);

        if (rst.next()) {
            this.soundState = rst.getInt("state");
        }
    }

    private void loadGamePlaySound() throws Exception {
        checkGamePlaySoundState();
        if (this.soundState == 1) {
            if (this.audioClip == null) {
                this.audioClip = new AudioClip(Paths.get(confirmMessageSoundPath).toUri().toString());
            }
        }
    }

    private void playGamePlaySound(String soundFilePath) throws Exception {
        loadGamePlaySound();

        if (this.soundState == 1) {
            switch (soundFilePath) {
                case confirmMessageSoundPath:
                    if (this.audioClip.isPlaying()) {
                        this.audioClip.stop();
                    }
                    this.audioClip.play();
                    break;
            }
        }
    }

    private void setSoundToggleBtnCurrentState() throws Exception {
        String sql = "SELECT state FROM settings WHERE setting = 'sound'";
        ResultSet rst = DBUtil.executeQuery(sql);

        if (rst.next()) {
            soundState = rst.getInt("state");
        }

        if (soundState == 1) {
            soundToggleBtn.setSelected(true);
        } else {
            soundToggleBtn.setSelected(false);
        }

    }

    @FXML
    private void soundToggleBtn_onAction(ActionEvent event) throws Exception {
        if (soundState == 1) {
            soundState = 0;
        } else {
            soundState = 1;
        }

        String url = "UPDATE settings SET state = " + soundState + " WHERE setting = 'sound';";
        DBUtil.executeUpdate(url);
    }

    @FXML
    private void darkThemeToggleBtn_onAction(ActionEvent event) {
        // Do Nothing
    }

    @FXML
    private void animation_onAction(ActionEvent event) {
        // Do Nothing
    }

    @FXML
    private void closeIcon_onMouseEntered(MouseEvent event) {
        ImageView icon = (ImageView) event.getSource();

        ScaleTransition scaleTrans = new ScaleTransition(Duration.millis(100), icon);
        scaleTrans.setToX(1.1);
        scaleTrans.setToY(1.1);
        scaleTrans.play();

        RotateTransition rotateTrans = new RotateTransition(Duration.millis(200), icon);
        rotateTrans.setFromAngle(0.0);
        rotateTrans.setToAngle(180.0);
        rotateTrans.setCycleCount(1);
        rotateTrans.play();
    }

    @FXML
    private void closeIcon_onMouseExited(MouseEvent event) {
        ImageView icon = (ImageView) event.getSource();

        RotateTransition rotateTrans = new RotateTransition(Duration.millis(200), icon);
        rotateTrans.setFromAngle(180.0);
        rotateTrans.setToAngle(0.0);
        rotateTrans.setCycleCount(1);
        rotateTrans.setAutoReverse(true);
        rotateTrans.play();

        ScaleTransition scaleTrans = new ScaleTransition(Duration.millis(100), icon);
        scaleTrans.setToX(1);
        scaleTrans.setToY(1);
        scaleTrans.play();
    }

    @FXML
    private void closeIcon_onMouseClicked(MouseEvent event) {
        event.consume();
        try {
            playGamePlaySound(confirmMessageSoundPath);
        } catch (Exception ex) {
            printDBErrorAndExit(ex);
        }
        Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.CANCEL, ButtonType.YES);
        exitAlert.setTitle("Exit?");
        exitAlert.setContentText(" Are You Sure to Exit?");
        Optional<ButtonType> action = exitAlert.showAndWait();

        if (action.get() == ButtonType.YES) {
            System.exit(0);
            Platform.exit();
        }
        if (action.get() == ButtonType.CANCEL) {
            // Do Nothing
        }
    }

    @FXML
    private void homeIcon_onMouseEntered(MouseEvent event) {
        ImageView icon = (ImageView) event.getSource();

        DropShadow glow = new DropShadow();
        glow.setColor(Color.rgb(255, 255, 255));
        glow.setWidth(15);
        glow.setHeight(15);
        glow.setRadius(15);
        icon.setEffect(glow);
    }

    @FXML
    private void homeIcon_onMouseExited(MouseEvent event) {
        ImageView icon = (ImageView) event.getSource();
        icon.setEffect(null);
    }

    @FXML
    private void homeIcon_onMouseClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/home.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.settingsAnchPane.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

        TranslateTransition trans = new TranslateTransition(Duration.millis(300), scene.getRoot());
        trans.setFromX(+scene.getHeight());
        trans.setToX(0);
        trans.play();
    }

    private void printDBErrorAndExit(Exception ex) {
        ex.printStackTrace();

        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("Error in Database");
        errorAlert.setContentText(
                " Something Went Wrong with Database."
                + "\n Try to Restart the Tic-Tac-Toe Ultimate."
        );
        Optional<ButtonType> action = errorAlert.showAndWait();
        if (action.get() == ButtonType.OK) {
            System.exit(0);
            Platform.exit();
        }
    }

}
