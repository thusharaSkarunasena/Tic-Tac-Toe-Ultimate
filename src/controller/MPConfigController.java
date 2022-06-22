package controller;

import com.jfoenix.controls.JFXTextField;
import db.DBUtil;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Thushara Supun
 */
public class MPConfigController implements Initializable {

    @FXML
    private AnchorPane mpConfigAnchPane;
    @FXML
    private ImageView closeIcon;
    @FXML
    private JFXTextField player1NameTF;
    @FXML
    private ImageView homeIcon;
    @FXML
    private ImageView playIcon;
    @FXML
    private JFXTextField player2NameTF;

    private int soundState = 0;
    private final String confirmMessageSoundPath = "src/asset/audio/audio5.wav";
    private AudioClip audioClip;

    public static String player1Name;
    public static String player2Name;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.gc();

        try {
            checkGamePlaySoundState();
            loadGamePlaySound();
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
    private void player1NameTF_onAction(ActionEvent event) {
        String name1 = player1NameTF.getText();
        boolean matches = name1.matches("[a-z A-Z 0-9]{4,12}");
        if (matches) {
            player2NameTF.requestFocus();
        } else {
            new Alert(Alert.AlertType.ERROR, "Something Wrong in Player 1 Name.", ButtonType.OK).show();
            player1NameTF.requestFocus();
            player1NameTF.selectAll();
        }
    }

    @FXML
    private void player2NameTF_onAction(ActionEvent event) throws IOException {
        String name2 = player2NameTF.getText();
        boolean matches = name2.matches("[a-z A-Z 0-9]{4,12}");
        if (matches) {
            playIcon_onMouseClicked(
                    new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, MouseButton.PRIMARY, 1, true, true, true, true, true, true, true, true, true, true, null)
            );
        } else {
            new Alert(Alert.AlertType.ERROR, "Something Wrong in Player 2 Name.", ButtonType.OK).show();
            player2NameTF.requestFocus();
            player2NameTF.selectAll();
        }
    }

    @FXML
    private void homeIcon_onMouseEntered(MouseEvent event) {
        ImageView icon = (ImageView) event.getSource();

        RotateTransition rotateTrans = new RotateTransition(Duration.millis(400), icon);
        rotateTrans.setFromAngle(360.0);
        rotateTrans.setToAngle(0.0);
        rotateTrans.setCycleCount(1);
        rotateTrans.play();

        DropShadow glow = new DropShadow();
        glow.setColor(Color.rgb(0, 153, 204));
        glow.setWidth(20);
        glow.setHeight(20);
        glow.setRadius(20);
        icon.setEffect(glow);
    }

    @FXML
    private void homeIcon_onMouseExited(MouseEvent event) {
        ImageView icon = (ImageView) event.getSource();

        RotateTransition rotateTrans = new RotateTransition(Duration.millis(400), icon);
        rotateTrans.setFromAngle(0.0);
        rotateTrans.setToAngle(360.0);
        rotateTrans.setCycleCount(1);
        rotateTrans.play();

        icon.setEffect(null);
    }

    @FXML
    private void homeIcon_onMouseClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/home.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.mpConfigAnchPane.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();

        TranslateTransition trans = new TranslateTransition(Duration.millis(300), scene.getRoot());
        trans.setFromX(+scene.getHeight());
        trans.setToX(0);
        trans.play();
    }

    @FXML
    private void playIcon_onMouseEntered(MouseEvent event) {
        ImageView icon = (ImageView) event.getSource();

        RotateTransition rotateTrans = new RotateTransition(Duration.millis(400), icon);
        rotateTrans.setFromAngle(0.0);
        rotateTrans.setToAngle(360.0);
        rotateTrans.setCycleCount(1);
        rotateTrans.play();

        DropShadow glow = new DropShadow();
        glow.setColor(Color.rgb(0, 189, 147));
        glow.setWidth(20);
        glow.setHeight(20);
        glow.setRadius(20);
        icon.setEffect(glow);
    }

    @FXML
    private void playIcon_onMouseExited(MouseEvent event) {
        ImageView icon = (ImageView) event.getSource();

        RotateTransition rotateTrans = new RotateTransition(Duration.millis(400), icon);
        rotateTrans.setFromAngle(360.0);
        rotateTrans.setToAngle(0.0);
        rotateTrans.setCycleCount(1);
        rotateTrans.play();

        icon.setEffect(null);
    }

    @FXML
    private void playIcon_onMouseClicked(MouseEvent event) throws IOException {
        String name1 = player1NameTF.getText();
        String name2 = player2NameTF.getText();
        boolean matches1 = name1.matches("[a-z A-Z 0-9]{4,12}");
        boolean matches2 = name2.matches("[a-z A-Z 0-9]{4,12}");

        if (matches1) {
            if (matches2) {
                this.player1Name = name1;
                this.player2Name = name2;

                try {
                    String sql = "UPDATE gbState SET state = 0 WHERE board = 'gb';";
                    DBUtil.executeUpdate(sql);
                } catch (Exception ex) {
                    printDBErrorAndExit(ex);
                }

                Parent root = FXMLLoader.load(this.getClass().getResource("/view/mpGamePlay.fxml"));
                Scene scene = new Scene(root);
                Stage temp = (Stage) this.mpConfigAnchPane.getScene().getWindow();
                temp.close();
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.getIcons().add(new Image("/asset/image/gameIcon.png"));
                stage.centerOnScreen();
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();

                FadeTransition trans = new FadeTransition(Duration.millis(1500), root);
                trans.setFromValue(0.2);
                trans.setToValue(1);
                trans.play();
            } else {
                new Alert(Alert.AlertType.ERROR, "Something Wrong in Player 2 Name.", ButtonType.OK).show();
                player2NameTF.requestFocus();
                player2NameTF.selectAll();
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Something Wrong in Player 1 Name.", ButtonType.OK).show();
            player1NameTF.requestFocus();
            player1NameTF.selectAll();
        }
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
