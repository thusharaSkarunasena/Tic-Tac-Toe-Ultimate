package controller;

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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
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
public class HelpController implements Initializable {

    @FXML
    private AnchorPane helpAnchPane;
    @FXML
    private ImageView closeIcon;
    @FXML
    private ImageView homeIcon;
    @FXML
    private TextArea helpDetailsTA;

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
        } catch (Exception ex) {
            printDBErrorAndExit(ex);
        }

        setHelpDetailsText();
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

    private void setHelpDetailsText() {
        String helpDetailsText = "";

        helpDetailsText += "\n * TicTacToe Ultimate is a complex variation of the \n"
                + "    standard TicTacToe. \n";

        helpDetailsText += "\n * The game board consists of 3X3 standard TicTacToe boards. \n";

        helpDetailsText += "\n * Each small 3-by-3 tictactoe board is referred to as a local board, \n"
                + "    and the larger 3-by-3 board is referred to as the global board. \n";

        helpDetailsText += "\n * Players can play by marking the slots with X and O alternately. \n";

        helpDetailsText += "\n * The game starts with 'X' playing wherever they want in any of \n"
                + "    the 81 empty spots. \n";

        helpDetailsText += "\n * This move 'sends' their opponent to its relative location. local \n"
                + " * For example, if 'X' played in the top right square of their \n"
                + "    board, then 'O' needs to play next in the local board at \n"
                + "    the top right of the global board. \n";

        helpDetailsText += "\n * 'O' can then play in any one of the nine available squares in that \n"
                + "    local board, each move sending 'X' to a different local board.\n"
                + " * For example, if 'O' marks the bottom middle square then 'X' has \n"
                + "    to be marked in the bottom-middle local board. 3 \n";

        helpDetailsText += "\n * If a move is played so that it is to win a local board \n"
                + "    by the rules of standard TicTacToe, then the entire local board \n"
                + "    a victory for the player in the global board. \n";

        helpDetailsText += "\n * Once a local board is won by a player, or it is filled completely, \n"
                + "    no more moves may be played in that board. \n"
                + " * If a player is sent to such a board, then that player may play on \n"
                + "    any other local board. \n";

        helpDetailsText += "\n * Game play ends when either a player wins the global board, \n"
                + "    or there are no legal moves remaining. \n";

        helpDetailsText += "\n # If you have any problem or for more details, please contact \n"
                + "    the developer of this game programme. \n"
                + " # Developer details can be found in 'About' window. \n";

        helpDetailsText += "\n\t\t\t *** That's All & Enjoy the Game! *** \t\t\t\n";

        helpDetailsTA.setText(helpDetailsText);
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
        Stage stage = (Stage) this.helpAnchPane.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

        TranslateTransition trans = new TranslateTransition(Duration.millis(300), scene.getRoot());
        trans.setFromX(+scene.getHeight());
        trans.setToX(0);
        trans.play();
    }

}
