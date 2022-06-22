package controller;

import com.jfoenix.controls.JFXButton;
import db.DBConnection;
import db.DBUtil;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
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
public class HomeController implements Initializable {

    @FXML
    private AnchorPane homeAnchPane;
    @FXML
    private ImageView closeIcon;
    @FXML
    private JFXButton singlePlayerBtn;
    @FXML
    private JFXButton multiPlayerBtn;
    @FXML
    private JFXButton restoreBtn;
    @FXML
    private JFXButton highScoreBtn;
    @FXML
    private JFXButton settingsBtn;
    @FXML
    private JFXButton helpBtn;
    @FXML
    private JFXButton aboutBtn;

    private int soundState = 0;
    private final String confirmMessageSoundPath = "src/asset/audio/audio5.wav";
    private AudioClip audioClip;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.gc();

        try {
            checkGamePlaySoundState();
            loadGamePlaySound();

            checkDBAvailability();
            checkRestoreBtnEnability();
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

    private void checkDBAvailability() throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        if (connection != null) {
            String sql = "SELECT * FROM sqlite_master WHERE type='table' AND name ='gbState'";
            ResultSet rst = DBUtil.executeQuery(sql);
            if (!rst.next()) {
                createDBTables();
                initializeDBTables();
            }
        } else {
            printDBErrorAndExit();
        }
    }

    private void createDBTables() throws Exception {
        ArrayList<String> sqls = new ArrayList<>();

        sqls.add(
                "CREATE TABLE IF NOT EXISTS gbState("
                + "board TEXT NOT NULL,"
                + "state INTEGER NOT NULL"
                + ");"
        );

        sqls.add(
                "CREATE TABLE IF NOT EXISTS lbState("
                + "board TEXT NOT NULL,"
                + "state INTEGER NOT NULL,"
                + "available INTEGER NOT NULL"
                + ");"
        );

        sqls.add(
                "CREATE TABLE IF NOT EXISTS gbValue("
                + "b0 TEXT NOT NULL,"
                + "b1 TEXT NOT NULL,"
                + "b2 TEXT NOT NULL,"
                + "b3 TEXT NOT NULL,"
                + "b4 TEXT NOT NULL,"
                + "b5 TEXT NOT NULL,"
                + "b6 TEXT NOT NULL,"
                + "b7 TEXT NOT NULL,"
                + "b8 TEXT NOT NULL,"
                + "b9 TEXT NOT NULL"
                + ");"
        );

        sqls.add(
                "CREATE TABLE IF NOT EXISTS playerState("
                + "playerID TEXT NOT NULL,"
                + "sign TEXT NOT NULL,"
                + "state INTEGER NOT NULL"
                + ");"
        );

        sqls.add(
                "CREATE TABLE IF NOT EXISTS playerValue("
                + "playerID TEXT NOT NULL,"
                + "name TEXT NOT NULL,"
                + "score INTEGER NOT NULL"
                + ");"
        );

        sqls.add(
                "CREATE TABLE IF NOT EXISTS highscore("
                + "name TEXT NOT NULL,"
                + "score INTEGER NOT NULL"
                + ");"
        );

        sqls.add(
                "CREATE TABLE IF NOT EXISTS settings("
                + "setting TEXT NOT NULL,"
                + "state INTEGER NOT NULL"
                + ");"
        );

        for (String sql : sqls) {
            DBUtil.executeUpdate(sql);
        }
    }

    private void initializeDBTables() throws Exception {
        ArrayList<String> sqls = new ArrayList<>();

        sqls.add(
                "INSERT INTO gbState(board, state) VALUES ('gb', 0);"
        );

        sqls.add(
                "INSERT INTO lbState(board, state, available) VALUES"
                + "('lb1', 0, 0),"
                + "('lb2', 0, 0),"
                + "('lb3', 0, 0),"
                + "('lb4', 0, 0),"
                + "('lb5', 0, 0),"
                + "('lb6', 0, 0),"
                + "('lb7', 0, 0),"
                + "('lb8', 0, 0),"
                + "('lb9', 0, 0);"
        );

        sqls.add(
                "INSERT INTO gbValue(b0, b1, b2, b3, b4, b5, b6, b7, b8, b9) VALUES"
                + "('lb1', '', '', '', '', '', '', '', '', ''),"
                + "('lb2', '', '', '', '', '', '', '', '', ''),"
                + "('lb3', '', '', '', '', '', '', '', '', ''),"
                + "('lb4', '', '', '', '', '', '', '', '', ''),"
                + "('lb5', '', '', '', '', '', '', '', '', ''),"
                + "('lb6', '', '', '', '', '', '', '', '', ''),"
                + "('lb7', '', '', '', '', '', '', '', '', ''),"
                + "('lb8', '', '', '', '', '', '', '', '', ''),"
                + "('lb9', '', '', '', '', '', '', '', '', '');"
        );

        sqls.add(
                "INSERT INTO playerState(playerID, sign, state) VALUES"
                + "('player1', '', 0),"
                + "('player2', '', 0);"
        );

        sqls.add(
                "INSERT INTO playerValue(playerID, name, score) VALUES"
                + "('player1', '', 0),"
                + "('player2', '', 0);"
        );

        sqls.add(
                "INSERT INTO settings(setting, state) VALUES"
                + "('sound', 1),"
                + "('darkTheme', 0),"
                + "('animation', 1);"
        );

        for (String sql : sqls) {
            DBUtil.executeUpdate(sql);
        }
    }

    private void checkRestoreBtnEnability() throws Exception {
        String sql = "SELECT state from gbState where board = 'gb'";
        ResultSet rst = DBUtil.executeQuery(sql);

        int gbState = 0;

        if (rst.next()) {
            gbState = rst.getInt(1);
        }

        if (gbState == 0) {
            restoreBtn.setDisable(true);
        } else {
            restoreBtn.setDisable(false);
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
    private void singlePlayerBtn_onMouseEntered(MouseEvent event) {
        ScaleTransition scaleTrans = new ScaleTransition(Duration.millis(100), singlePlayerBtn);
        scaleTrans.setToX(1.2);
        scaleTrans.setToY(1.2);
        scaleTrans.play();

        DropShadow glow = new DropShadow();
        glow.setColor(Color.rgb(0, 153, 204));
        glow.setWidth(30);
        glow.setHeight(30);
        glow.setRadius(30);
        singlePlayerBtn.setEffect(glow);
    }

    @FXML
    private void singlePlayerBtn_onMouseExited(MouseEvent event) {
        ScaleTransition scaleTrans = new ScaleTransition(Duration.millis(200), singlePlayerBtn);
        scaleTrans.setToX(1);
        scaleTrans.setToY(1);
        scaleTrans.play();
        singlePlayerBtn.setEffect(null);
    }

    @FXML
    private void singlePlayerBtn_onAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/spConfig.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.homeAnchPane.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

        TranslateTransition trans = new TranslateTransition(Duration.millis(300), scene.getRoot());
        trans.setFromX(-scene.getHeight());
        trans.setToX(0);
        trans.play();
    }

    @FXML
    private void multiPlayerBtn_onMouseEntered(MouseEvent event) {
        ScaleTransition scaleTrans = new ScaleTransition(Duration.millis(100), multiPlayerBtn);
        scaleTrans.setToX(1.2);
        scaleTrans.setToY(1.2);
        scaleTrans.play();

        DropShadow glow = new DropShadow();
        glow.setColor(Color.rgb(0, 189, 147));
        glow.setWidth(30);
        glow.setHeight(30);
        glow.setRadius(30);
        multiPlayerBtn.setEffect(glow);
    }

    @FXML
    private void multiPlayerBtn_onMouseExited(MouseEvent event) {
        ScaleTransition scaleTrans = new ScaleTransition(Duration.millis(200), multiPlayerBtn);
        scaleTrans.setToX(1);
        scaleTrans.setToY(1);
        scaleTrans.play();
        multiPlayerBtn.setEffect(null);
    }

    @FXML
    private void multiPlayerBtn_onAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/mpConfig.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.homeAnchPane.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

        TranslateTransition trans = new TranslateTransition(Duration.millis(300), scene.getRoot());
        trans.setFromX(-scene.getHeight());
        trans.setToX(0);
        trans.play();
    }

    @FXML
    private void restoreBtn_onAction(ActionEvent event) {
        try {
            String sql = "SELECT state from gbState where board = 'gb'";
            ResultSet rst = DBUtil.executeQuery(sql);

            int gbState = 0;

            if (rst.next()) {
                gbState = rst.getInt(1);
            }

            if (gbState == 1) {
                Parent root = FXMLLoader.load(this.getClass().getResource("/view/spGamePlay.fxml"));
                Scene scene = new Scene(root);
                Stage temp = (Stage) this.homeAnchPane.getScene().getWindow();
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
            } else if (gbState == 2) {
                Parent root = FXMLLoader.load(this.getClass().getResource("/view/mpGamePlay.fxml"));
                Scene scene = new Scene(root);
                Stage temp = (Stage) this.homeAnchPane.getScene().getWindow();
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
            }
        } catch (Exception ex) {
            printDBErrorAndExit(ex);
        }
    }

    @FXML
    private void settingsBtn_onAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/settings.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.homeAnchPane.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

        TranslateTransition trans = new TranslateTransition(Duration.millis(300), scene.getRoot());
        trans.setFromX(-scene.getHeight());
        trans.setToX(0);
        trans.play();
    }

    @FXML
    private void highScoreBtn_onAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/highScore.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.homeAnchPane.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

        TranslateTransition trans = new TranslateTransition(Duration.millis(300), scene.getRoot());
        trans.setFromX(-scene.getHeight());
        trans.setToX(0);
        trans.play();
    }

    @FXML
    private void helpBtn_onAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/help.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.homeAnchPane.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

        TranslateTransition trans = new TranslateTransition(Duration.millis(300), scene.getRoot());
        trans.setFromX(-scene.getHeight());
        trans.setToX(0);
        trans.play();
    }

    @FXML
    private void aboutBtn_onAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/about.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) this.homeAnchPane.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

        TranslateTransition trans = new TranslateTransition(Duration.millis(300), scene.getRoot());
        trans.setFromX(-scene.getHeight());
        trans.setToX(0);
        trans.play();
    }

    private void printDBErrorAndExit(Exception ex) {
        ex.printStackTrace();
        printDBErrorAndExit();
    }

    private void printDBErrorAndExit() {
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
