package controller;

import com.jfoenix.controls.JFXButton;
import db.DBUtil;
import dto.Box;
import dto.GlobalBoard;
import dto.LocalBoard;
import dto.Player;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
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
public class MPGamePlayController implements Initializable {

    @FXML
    private AnchorPane mpGamePlayAnchPane;
    @FXML
    private ImageView closeIcon;
    @FXML
    private Label nextTurnPlayerNameLbl;
    @FXML
    private Label nextTurnSignLbl;
    @FXML
    private Pane globalBoardPane;
    @FXML
    private Pane localBoard_1_Pane;
    @FXML
    private JFXButton box_11_Btn;
    @FXML
    private JFXButton box_12_Btn;
    @FXML
    private JFXButton box_13_Btn;
    @FXML
    private JFXButton box_14_Btn;
    @FXML
    private JFXButton box_15_Btn;
    @FXML
    private JFXButton box_16_Btn;
    @FXML
    private JFXButton box_17_Btn;
    @FXML
    private JFXButton box_18_Btn;
    @FXML
    private JFXButton box_19_Btn;
    @FXML
    private Pane localBoard_2_Pane;
    @FXML
    private JFXButton box_21_Btn;
    @FXML
    private JFXButton box_22_Btn;
    @FXML
    private JFXButton box_23_Btn;
    @FXML
    private JFXButton box_24_Btn;
    @FXML
    private JFXButton box_25_Btn;
    @FXML
    private JFXButton box_26_Btn;
    @FXML
    private JFXButton box_27_Btn;
    @FXML
    private JFXButton box_28_Btn;
    @FXML
    private JFXButton box_29_Btn;
    @FXML
    private Pane localBoard_3_Pane;
    @FXML
    private JFXButton box_31_Btn;
    @FXML
    private JFXButton box_32_Btn;
    @FXML
    private JFXButton box_33_Btn;
    @FXML
    private JFXButton box_34_Btn;
    @FXML
    private JFXButton box_35_Btn;
    @FXML
    private JFXButton box_36_Btn;
    @FXML
    private JFXButton box_37_Btn;
    @FXML
    private JFXButton box_38_Btn;
    @FXML
    private JFXButton box_39_Btn;
    @FXML
    private Pane localBoard_4_Pane;
    @FXML
    private JFXButton box_41_Btn;
    @FXML
    private JFXButton box_42_Btn;
    @FXML
    private JFXButton box_43_Btn;
    @FXML
    private JFXButton box_44_Btn;
    @FXML
    private JFXButton box_45_Btn;
    @FXML
    private JFXButton box_46_Btn;
    @FXML
    private JFXButton box_47_Btn;
    @FXML
    private JFXButton box_48_Btn;
    @FXML
    private JFXButton box_49_Btn;
    @FXML
    private Pane localBoard_5_Pane;
    @FXML
    private JFXButton box_51_Btn;
    @FXML
    private JFXButton box_52_Btn;
    @FXML
    private JFXButton box_53_Btn;
    @FXML
    private JFXButton box_54_Btn;
    @FXML
    private JFXButton box_55_Btn;
    @FXML
    private JFXButton box_56_Btn;
    @FXML
    private JFXButton box_57_Btn;
    @FXML
    private JFXButton box_58_Btn;
    @FXML
    private JFXButton box_59_Btn;
    @FXML
    private Pane localBoard_6_Pane;
    @FXML
    private JFXButton box_61_Btn;
    @FXML
    private JFXButton box_62_Btn;
    @FXML
    private JFXButton box_63_Btn;
    @FXML
    private JFXButton box_64_Btn;
    @FXML
    private JFXButton box_65_Btn;
    @FXML
    private JFXButton box_66_Btn;
    @FXML
    private JFXButton box_67_Btn;
    @FXML
    private JFXButton box_68_Btn;
    @FXML
    private JFXButton box_69_Btn;
    @FXML
    private Pane localBoard_7_Pane;
    @FXML
    private JFXButton box_71_Btn;
    @FXML
    private JFXButton box_72_Btn;
    @FXML
    private JFXButton box_73_Btn;
    @FXML
    private JFXButton box_74_Btn;
    @FXML
    private JFXButton box_75_Btn;
    @FXML
    private JFXButton box_76_Btn;
    @FXML
    private JFXButton box_77_Btn;
    @FXML
    private JFXButton box_78_Btn;
    @FXML
    private JFXButton box_79_Btn;
    @FXML
    private Pane localBoard_8_Pane;
    @FXML
    private JFXButton box_81_Btn;
    @FXML
    private JFXButton box_82_Btn;
    @FXML
    private JFXButton box_83_Btn;
    @FXML
    private JFXButton box_84_Btn;
    @FXML
    private JFXButton box_85_Btn;
    @FXML
    private JFXButton box_86_Btn;
    @FXML
    private JFXButton box_87_Btn;
    @FXML
    private JFXButton box_88_Btn;
    @FXML
    private JFXButton box_89_Btn;
    @FXML
    private Pane localBoard_9_Pane;
    @FXML
    private JFXButton box_91_Btn;
    @FXML
    private JFXButton box_92_Btn;
    @FXML
    private JFXButton box_93_Btn;
    @FXML
    private JFXButton box_94_Btn;
    @FXML
    private JFXButton box_95_Btn;
    @FXML
    private JFXButton box_96_Btn;
    @FXML
    private JFXButton box_97_Btn;
    @FXML
    private JFXButton box_98_Btn;
    @FXML
    private JFXButton box_99_Btn;
    @FXML
    private ImageView restartIcon;
    @FXML
    private ImageView homeIcon;
    @FXML
    private ImageView player1Icon;
    @FXML
    private ImageView player2Icon;
    @FXML
    private Label player1NameLbl;
    @FXML
    private Label player2NameLbl;
    @FXML
    private Label player1ScoreLbl;
    @FXML
    private Label player2ScoreLbl;

    private int soundState = 0;

    private final String player1SignSoundPath = "src/asset/audio/audio1.wav";
    private final String player2SignSoundPath = "src/asset/audio/audio2.wav";
    private final String LBWinSoundPath = "src/asset/audio/audio3.wav";
    private final String gameOverSoundPath = "src/asset/audio/audio4.wav";
    private final String confirmMessageSoundPath = "src/asset/audio/audio5.wav";

    private AudioClip audioClip1;
    private AudioClip audioClip2;
    private AudioClip audioClip3;
    private AudioClip audioClip4;
    private AudioClip audioClip5;

    private final int lbCount = 9;
    private final int boxCount = 9;

    private ObservableList<Node> globalBoard;

    private ObservableList<Node> localBoard1;
    private ObservableList<Node> localBoard2;
    private ObservableList<Node> localBoard3;
    private ObservableList<Node> localBoard4;
    private ObservableList<Node> localBoard5;
    private ObservableList<Node> localBoard6;
    private ObservableList<Node> localBoard7;
    private ObservableList<Node> localBoard8;
    private ObservableList<Node> localBoard9;

    private ArrayList<ObservableList<Node>> localBoards;

    private Player player1;
    private Player player2;
    private String nextPlayerID;
    private String nextPlayerName;
    private String nextPlayerSign;
    private GlobalBoard gb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.gc();

        globalBoard = globalBoardPane.getChildren();

        localBoard1 = localBoard_1_Pane.getChildren();
        localBoard2 = localBoard_2_Pane.getChildren();
        localBoard3 = localBoard_3_Pane.getChildren();
        localBoard4 = localBoard_4_Pane.getChildren();
        localBoard5 = localBoard_5_Pane.getChildren();
        localBoard6 = localBoard_6_Pane.getChildren();
        localBoard7 = localBoard_7_Pane.getChildren();
        localBoard8 = localBoard_8_Pane.getChildren();
        localBoard9 = localBoard_9_Pane.getChildren();

        localBoards = new ArrayList<>();
        localBoards.add(localBoard1);
        localBoards.add(localBoard2);
        localBoards.add(localBoard3);
        localBoards.add(localBoard4);
        localBoards.add(localBoard5);
        localBoards.add(localBoard6);
        localBoards.add(localBoard7);
        localBoards.add(localBoard8);
        localBoards.add(localBoard9);

        try {
            checkGamePlaySoundState();
            loadGamePlaySound();

            int gbState = checkGBState();
            switch (gbState) {
                case 0:
                    newMPGamePlay();
                    break;
                case 2:
                    restoreMPGamePlay();
                    break;
                default:
                    printDBErrorAndExit();
            }
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
            if (this.audioClip1 == null) {
                this.audioClip1 = new AudioClip(Paths.get(player1SignSoundPath).toUri().toString());
            }

            if (this.audioClip2 == null) {
                this.audioClip2 = new AudioClip(Paths.get(player2SignSoundPath).toUri().toString());
            }

            if (this.audioClip3 == null) {
                this.audioClip3 = new AudioClip(Paths.get(LBWinSoundPath).toUri().toString());
            }

            if (this.audioClip4 == null) {
                this.audioClip4 = new AudioClip(Paths.get(gameOverSoundPath).toUri().toString());
            }

            if (this.audioClip5 == null) {
                this.audioClip5 = new AudioClip(Paths.get(confirmMessageSoundPath).toUri().toString());
            }
        }
    }

    private void playGamePlaySound(String soundFilePath) throws Exception {
        loadGamePlaySound();

        if (this.soundState == 1) {
            switch (soundFilePath) {
                case player1SignSoundPath:
                    if (this.audioClip1.isPlaying()) {
                        this.audioClip1.stop();
                    }
                    this.audioClip1.play();
                    break;
                case player2SignSoundPath:
                    if (this.audioClip2.isPlaying()) {
                        this.audioClip2.stop();
                    }
                    this.audioClip2.play();
                    break;
                case LBWinSoundPath:
                    if (this.audioClip3.isPlaying()) {
                        this.audioClip3.stop();
                    }
                    this.audioClip3.play();
                    break;
                case gameOverSoundPath:
                    if (this.audioClip4.isPlaying()) {
                        this.audioClip4.stop();
                    }
                    this.audioClip4.play();
                    break;
                case confirmMessageSoundPath:
                    if (this.audioClip5.isPlaying()) {
                        this.audioClip5.stop();
                    }
                    this.audioClip5.play();
                    break;
            }
        }
    }

    private int checkGBState() throws Exception {
        String sql = "SELECT state FROM gbState WHERE board = 'gb'";
        ResultSet rst = DBUtil.executeQuery(sql);

        int gbState = 0;

        if (rst.next()) {
            gbState = rst.getInt("state");
        }

        return gbState;
    }

    private void clearDBTables() throws Exception {
        ArrayList<String> sqls = new ArrayList<>();

        sqls.add("DELETE FROM gbState;");
        sqls.add("DELETE FROM lbState;");
        sqls.add("DELETE FROM gbValue;");
        sqls.add("DELETE FROM playerState;");
        sqls.add("DELETE FROM playerValue;");

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

        for (String sql : sqls) {
            DBUtil.executeUpdate(sql);
        }
    }

    private void newMPGamePlay() throws Exception {
        clearDBTables();
        initializeDBTables();

        this.player1 = new Player("player1", MPConfigController.player1Name, "X", 0, 1);
        this.player2 = new Player("player2", MPConfigController.player2Name, "O", 0, 0);

        ArrayList<LocalBoard> lbs = new ArrayList<>();

        for (int i = 0; i < lbCount; i++) {
            ArrayList<Box> boxs = new ArrayList<>();
            for (int j = 0; j < boxCount; j++) {
                boxs.add(j, new Box("", i + 1, j + 1, true));
            }
            lbs.add(i, new LocalBoard(i + 1, boxs, true, true));
        }
        this.gb = new GlobalBoard(lbs, 2);

        new Thread(() -> {
            try {
                updateDBTables();
            } catch (Exception ex) {
                printDBErrorAndExit(ex);
            }
        }).start();
        publishPlayerNames();
        publishPlayerScores();
        setNextTurnPlayerID();
        setAndpublishNextTurnPlayerName();
        setAndpublishNextTurnPlayerSign();
        setAndPublishNextPlayerGlow();
        publishLBState();
        setGBValues();
        publishActiveLBsBoxState();
    }

    private void updateDBTables() throws Exception {
        updateGBStateTable();
        updateLBStateTable();
        updateGBValueTable();
        updatePlayerStateTable();
        updatePlayerValueTable();
    }

    private void updateGBStateTable() throws Exception {
        String sql = "UPDATE gbState SET state = 2 WHERE board = 'gb';";
        DBUtil.executeUpdate(sql);
    }

    private void updateLBStateTable() throws Exception {
        for (LocalBoard localBoard : this.gb.getLocalBoards()) {

            int state1 = 0;
            int state2 = 0;

            if (localBoard.getState()) {
                state1 = 1;
            } else {
                state1 = 0;
            }

            if (localBoard.getAvailable()) {
                state2 = 1;
            } else {
                state2 = 0;
            }

            String sql = "UPDATE lbState SET state = "
                    + state1
                    + ", available ="
                    + state2
                    + " WHERE board = 'lb"
                    + localBoard.getBoardNumber()
                    + "';";
            DBUtil.executeUpdate(sql);
        }
    }

    private void updateGBValueTable() throws Exception {
        for (LocalBoard localBoard : this.gb.getLocalBoards()) {
            for (Box box : localBoard.getBoxs()) {
                String sql = "UPDATE gbValue SET "
                        + "b" + box.getBoxNumber()
                        + "='" + box.getSign()
                        + "' WHERE b0 = 'lb"
                        + box.getLBNumber()
                        + "';";
                DBUtil.executeUpdate(sql);
            }
        }
    }

    private void updatePlayerStateTable() throws Exception {
        String sql1 = "UPDATE playerState SET "
                + "sign = '" + player1.getSign() + "'"
                + ", state = " + player1.getState()
                + " WHERE playerID='"
                + player1.getPlayerID()
                + "';";
        String sql2 = "UPDATE playerState SET "
                + "sign = '" + player2.getSign() + "'"
                + ", state = " + player2.getState()
                + " WHERE playerID='"
                + player2.getPlayerID()
                + "';";
        DBUtil.executeUpdate(sql1);
        DBUtil.executeUpdate(sql2);
    }

    private void updatePlayerValueTable() throws Exception {
        String sql1 = "UPDATE playerValue SET "
                + "name = '" + player1.getName()
                + "', score = " + player1.getScore()
                + " WHERE playerID='"
                + player1.getPlayerID()
                + "';";
        String sql2 = "UPDATE playerValue SET "
                + "name = '" + player2.getName()
                + "', score = " + player2.getScore()
                + " WHERE playerID='"
                + player2.getPlayerID()
                + "';";
        DBUtil.executeUpdate(sql1);
        DBUtil.executeUpdate(sql2);
    }

    private void restoreMPGamePlay() throws Exception {
        queryDBTables();
        publishPlayerNames();
        publishPlayerScores();
        setNextTurnPlayerID();
        setAndpublishNextTurnPlayerName();
        setAndpublishNextTurnPlayerSign();
        setAndPublishNextPlayerGlow();
        publishLBState();
        setGBValues();
        publishActiveLBsBoxState();
    }

    private void queryDBTables() throws Exception {
        int gbState = queryGBStateTable();
        int[] lbStates = queryLBStateTableState();
        int[] lbAvailable = queryLBStateTableAvailable();
        String[][] gbValues = queryGBValueTable();
        Player[] playerStates = queryPlayerStateTable();
        Player[] playerValues = queryPlayerValueTable();

        ArrayList<LocalBoard> lbs = new ArrayList<>();

        boolean state1 = false;
        boolean state2 = false;
        boolean state3 = false;

        for (int i = 0; i < lbCount; i++) {
            ArrayList<Box> boxs = new ArrayList<>();
            for (int j = 0; j < boxCount; j++) {
                if (gbValues[i][j].equals("X") || gbValues[i][j].equals("O")) {
                    state1 = false;
                } else {
                    state1 = true;
                }
                boxs.add(j, new Box(gbValues[i][j], i + 1, j + 1, state1));
            }
            if (lbStates[i] == 1) {
                state2 = true;
            } else {
                state2 = false;
            }
            if (lbAvailable[i] == 1) {
                state3 = true;
            } else {
                state3 = false;
            }
            lbs.add(i, new LocalBoard(i + 1, boxs, state2, state3));
        }
        this.gb = new GlobalBoard(lbs, gbState);

        this.player1 = new Player(
                playerStates[0].getPlayerID(),
                playerValues[0].getName(),
                playerStates[0].getSign(),
                playerValues[0].getScore(),
                playerStates[0].getState()
        );

        this.player2 = new Player(
                playerStates[1].getPlayerID(),
                playerValues[1].getName(),
                playerStates[1].getSign(),
                playerValues[1].getScore(),
                playerStates[1].getState()
        );
    }

    private int queryGBStateTable() throws Exception {
        String sql = "SELECT state FROM gbState;";
        ResultSet rst = DBUtil.executeQuery(sql);

        int gbState = 0;

        while (rst.next()) {
            gbState = rst.getInt("state");
        }

        return gbState;
    }

    private int[] queryLBStateTableState() throws Exception {
        String sql = "SELECT state FROM lbState;";
        ResultSet rst = DBUtil.executeQuery(sql);

        int count = 0;
        int[] lbState = new int[9];

        while (rst.next()) {
            lbState[count] = rst.getInt("state");
            count++;
        }

        return lbState;
    }

    private int[] queryLBStateTableAvailable() throws Exception {
        String sql = "SELECT available FROM lbState;";
        ResultSet rst = DBUtil.executeQuery(sql);

        int count = 0;
        int[] lbavailable = new int[9];

        while (rst.next()) {
            lbavailable[count] = rst.getInt("available");
            count++;
        }

        return lbavailable;
    }

    private String[][] queryGBValueTable() throws Exception {
        String sql = "SELECT b1, b2, b3, b4, b5, b6, b7, b8, b9 FROM gbValue;";
        ResultSet rst = DBUtil.executeQuery(sql);

        int count = 0;
        String[][] gbValue = new String[9][9];

        while (rst.next()) {
            gbValue[count][0] = rst.getString("b1");
            gbValue[count][1] = rst.getString("b2");
            gbValue[count][2] = rst.getString("b3");
            gbValue[count][3] = rst.getString("b4");
            gbValue[count][4] = rst.getString("b5");
            gbValue[count][5] = rst.getString("b6");
            gbValue[count][6] = rst.getString("b7");
            gbValue[count][7] = rst.getString("b8");
            gbValue[count][8] = rst.getString("b9");
            count++;
        }

        return gbValue;
    }

    private Player[] queryPlayerStateTable() throws Exception {
        String sql = "SELECT playerID, sign, state FROM playerState;";
        ResultSet rst = DBUtil.executeQuery(sql);

        int count = 0;
        Player[] playerStates = {new Player(), new Player()};

        while (rst.next()) {
            playerStates[count].setPlayerID(rst.getString("playerID"));
            playerStates[count].setSign(rst.getString("sign"));
            playerStates[count].setState(rst.getInt("state"));
            count++;
        }

        return playerStates;
    }

    private Player[] queryPlayerValueTable() throws Exception {
        String sql = "SELECT playerID, name, score FROM playerValue;";
        ResultSet rst = DBUtil.executeQuery(sql);

        int count = 0;
        Player[] playerValues = {new Player(), new Player()};

        while (rst.next()) {
            playerValues[count].setPlayerID(rst.getString("playerID"));
            playerValues[count].setName(rst.getString("name"));
            playerValues[count].setScore(rst.getInt("score"));
            count++;
        }

        return playerValues;
    }

    private void publishPlayerNames() throws Exception {
        player1NameLbl.setText(MPConfigController.player1Name);
        player2NameLbl.setText(MPConfigController.player2Name);
    }

    private void publishPlayerScores() throws Exception {
        player1ScoreLbl.setText(Integer.toString(player1.getScore()));
        player2ScoreLbl.setText(Integer.toString(player2.getScore()));
    }

    private void setNextTurnPlayerID() throws Exception {
        if (player1.getState() == 1 && player2.getState() == 0) {
            this.nextPlayerID = "player1";
        } else if (player1.getState() == 0 && player2.getState() == 1) {
            this.nextPlayerID = "player2";
        } else {
            printDBErrorAndExit();
        }
    }

    private void setAndpublishNextTurnPlayerName() throws Exception {
        if (player1.getState() == 1 && player2.getState() == 0) {
            this.nextPlayerName = "Player 1";
            nextTurnPlayerNameLbl.setText("Player 1");
        } else if (player1.getState() == 0 && player2.getState() == 1) {
            this.nextPlayerName = "Player 2";
            nextTurnPlayerNameLbl.setText("Player 2");
        } else {
            printDBErrorAndExit();
        }
    }

    private void setAndpublishNextTurnPlayerSign() throws Exception {
        if (player1.getState() == 1 && player2.getState() == 0) {
            this.nextPlayerSign = player1.getSign();
            nextTurnSignLbl.setText("(" + player1.getSign() + ")");
            nextTurnSignLbl.setStyle("-fx-text-fill: #FF0000");
        } else if (player1.getState() == 0 && player2.getState() == 1) {
            this.nextPlayerSign = player2.getSign();
            nextTurnSignLbl.setText("(" + player2.getSign() + ")");
            nextTurnSignLbl.setStyle("-fx-text-fill: #0000FF");
        } else {
            printDBErrorAndExit();
        }
    }

    private void setAndPublishNextPlayerGlow() throws Exception {
        DropShadow glow = new DropShadow();
        glow.setWidth(40);
        glow.setHeight(40);
        glow.setRadius(40);

        if (player1.getState() == 1 && player2.getState() == 0) {
            glow.setColor(Color.rgb(255, 0, 0));
            player2Icon.setEffect(null);
            player1Icon.setEffect(glow);
        } else if (player1.getState() == 0 && player2.getState() == 1) {
            glow.setColor(Color.rgb(0, 0, 255));
            player1Icon.setEffect(null);
            player2Icon.setEffect(glow);
        } else {
            printDBErrorAndExit();
        }
    }

    private void swapAndSetPlayerState() throws Exception {
        if (player1.getState() == 1 && player2.getState() == 0) {
            player1.setState(0);
            player2.setState(1);
        } else if (player1.getState() == 0 && player2.getState() == 1) {
            player1.setState(1);
            player2.setState(0);
        } else {
            printDBErrorAndExit();
        }

        String sql1 = "UPDATE playerState SET "
                + " state = " + player1.getState()
                + " WHERE playerID='"
                + player1.getPlayerID()
                + "';";
        String sql2 = "UPDATE playerState SET "
                + " state = " + player2.getState()
                + " WHERE playerID='"
                + player2.getPlayerID()
                + "';";
        DBUtil.executeUpdate(sql1);
        DBUtil.executeUpdate(sql2);
    }

    private void swapAndPublishNextPlayerValues() throws Exception {
        swapAndSetPlayerState();
        setNextTurnPlayerID();
        setAndpublishNextTurnPlayerName();
        setAndpublishNextTurnPlayerSign();
        setAndPublishNextPlayerGlow();
    }

    private void setGBValues() throws Exception {

        String player1SignCssStyle = "-fx-text-fill: #FF0000;";

        String player2SignCssStyle = "-fx-text-fill: #0000FF;";

        for (int i = 0; i < lbCount; i++) {
            for (int j = 0; j < boxCount; j++) {
                if (this.gb.getLocalBoards().get(i).getBoxs().get(j).getSign().equals("X")) {
                    this.localBoards.get(i).get(j).setStyle(player1SignCssStyle);
                } else if (this.gb.getLocalBoards().get(i).getBoxs().get(j).getSign().equals("O")) {
                    this.localBoards.get(i).get(j).setStyle(player2SignCssStyle);
                }
                Node node = this.localBoards.get(i).get(j);
                JFXButton jFXButton = (JFXButton) node;
                jFXButton.setText(this.gb.getLocalBoards().get(i).getBoxs().get(j).getSign());
            }
        }

    }

    private void publishLBState() throws Exception {

        String lbEnabledCssStyle = ""
                + "-fx-background-color: transparent;"
                + "\n -fx-border-color: #000000;"
                + "\n -fx-border-width: 3;";

        String lbDisabledCssStyle = ""
                + "-fx-background-color: rgba(192,192,192, 0.5);"
                + "\n -fx-border-color: #ffffff;"
                + "\n -fx-border-width: 2;";

        for (int i = 0; i < lbCount; i++) {
            for (int j = 0; j < boxCount; j++) {
                this.localBoards.get(i).get(j).setMouseTransparent(true);
            }
        }

        for (int i = 0; i < lbCount; i++) {
            if (this.gb.getLocalBoards().get(i).getAvailable()) {
                if (this.gb.getLocalBoards().get(i).getState()) {
                    this.globalBoard.get(i).setStyle(lbEnabledCssStyle);
                    for (int j = 0; j < boxCount; j++) {
                        this.localBoards.get(i).get(j).setMouseTransparent(false);
                    }
                } else {
                    this.globalBoard.get(i).setStyle(lbDisabledCssStyle);
                    for (int j = 0; j < boxCount; j++) {
                        this.localBoards.get(i).get(j).setMouseTransparent(true);
                    }
                }
            } else {
                this.globalBoard.get(i).setStyle(lbDisabledCssStyle);
                for (int j = 0; j < boxCount; j++) {
                    this.localBoards.get(i).get(j).setMouseTransparent(true);
                }
            }

        }
    }

    private void publishActiveLBsBoxState() throws Exception {
        for (int i = 0; i < lbCount; i++) {
            for (int j = 0; j < boxCount; j++) {
                if (this.gb.getLocalBoards().get(i).getAvailable()) {
                    if (this.gb.getLocalBoards().get(i).getState()) {
                        this.localBoards.get(i).get(j).setMouseTransparent(
                                !this.gb.getLocalBoards().get(i).getBoxs().get(j).getState()
                        );
                    }
                }
            }
        }
    }

    @FXML
    private void box_11_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_12_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_13_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_14_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_15_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_16_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_17_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_18_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_19_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_21_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_22_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_23_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_24_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_25_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_26_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_27_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_28_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_29_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_31_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_32_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_33_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_34_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_35_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_36_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_37_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_38_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_39_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_41_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_42_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_43_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_44_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_45_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_46_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_47_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_48_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_49_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_51_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_52_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_53_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_54_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_55_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_56_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_57_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_58_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_59_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_61_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_62_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_63_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_64_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_65_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_66_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_67_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_68_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_69_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_71_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_72_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_73_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_74_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_75_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_76_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_77_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_78_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_79_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_81_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_82_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_83_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_84_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_85_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_86_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_87_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_88_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_89_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_91_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_92_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_93_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_94_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_95_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_96_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_97_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_98_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    @FXML
    private void box_99_Btn_onAction(ActionEvent event) {
        JFXButton jFXButton = (JFXButton) event.getSource();
        box_Btn_onAction(jFXButton.getId());
    }

    private void box_Btn_onAction(String boxBtnId) {
        try {
            int locationCode = Integer.parseInt(
                    boxBtnId.substring(4, 6)
            );

            int lbNumber = locationCode / 10;
            int boxNumber = locationCode % 10;

            if ((this.gb.getLocalBoards().get(lbNumber - 1).getState())
                    && (this.gb.getLocalBoards().get(lbNumber - 1).getBoxs().get(boxNumber - 1).getState())) {
                if (this.player1.getState() == 1 && this.player2.getState() == 0) {
                    playGamePlaySound(this.player1SignSoundPath);
                } else if (this.player1.getState() == 0 && this.player2.getState() == 1) {
                    playGamePlaySound(this.player2SignSoundPath);
                }

                setBoxValues_boxBtnOnAction(lbNumber, boxNumber);
                publishBoxStateAndValues_boxBtnOnAction(lbNumber, boxNumber);
                new Thread(() -> {
                    try {
                        updateDBBoxStateAndValues_boxBtnOnAction(lbNumber, boxNumber);
                    } catch (Exception ex) {
                        printDBErrorAndExit(ex);
                    }
                }).start();

                setPublishAndUpdatePlayerNewScore(nextPlayerID, -5);

                boolean isGBWin = checkForGBWin(lbNumber);
                checkForLBWin(lbNumber);

                checkForLBFull(lbNumber);
                boolean isGBFull = checkForGBFull();

                setBoxState_boxBtnOnAction(lbNumber, boxNumber);
                setLBStateAndValues_boxBtnOnAction(lbNumber, boxNumber);
                publishLBStateAndBoxState_boxBtnOnAction();
                new Thread(() -> {
                    try {
                        updateDBLBStateAndValues_boxBtnOnAction();
                    } catch (Exception ex) {
                        printDBErrorAndExit(ex);
                    }
                }).start();

                if (isGBWin || isGBFull) {
                    MPGamePlayOver();
                }

                swapAndPublishNextPlayerValues();
            }
        } catch (Exception ex) {
            printDBErrorAndExit(ex);
        }
    }

    private void setBoxValues_boxBtnOnAction(int lbNumber, int boxNumber) throws Exception {
        this.gb.getLocalBoards().get(lbNumber - 1).getBoxs().get(boxNumber - 1).setSign(nextPlayerSign);
    }

    private void setBoxState_boxBtnOnAction(int lbNumber, int boxNumber) throws Exception {
        this.gb.getLocalBoards().get(lbNumber - 1).getBoxs().get(boxNumber - 1).setState(false);
    }

    private void publishBoxStateAndValues_boxBtnOnAction(int lbNumber, int boxNumber) throws Exception {
        Node node = this.localBoards.get(lbNumber - 1).get(boxNumber - 1);
        JFXButton jFXButton = (JFXButton) node;
        if (nextPlayerSign.equals("X")) {
            jFXButton.setStyle("-fx-text-fill: #FF0000;");
        } else if (nextPlayerSign.equals("O")) {
            jFXButton.setStyle("-fx-text-fill: #0000FF;");
        }
        jFXButton.setText(nextPlayerSign);
        jFXButton.setMouseTransparent(true);
    }

    private void updateDBBoxStateAndValues_boxBtnOnAction(int lbNumber, int boxNumber) throws Exception {
        Box box = this.gb.getLocalBoards().get(lbNumber - 1).getBoxs().get(boxNumber - 1);

        String sql = "UPDATE gbValue SET "
                + "b" + box.getBoxNumber()
                + "='" + box.getSign()
                + "' WHERE b0 = 'lb"
                + box.getLBNumber()
                + "';";
        DBUtil.executeUpdate(sql);
    }

    private void setLBStateAndValues_boxBtnOnAction(int lbNumber, int boxNumber) throws Exception {
        if (this.gb.getLocalBoards().get(boxNumber - 1).getAvailable()) {
            for (int i = 0; i < lbCount; i++) {
                if ((boxNumber - 1) == i) {
                    this.gb.getLocalBoards().get(i).setState(true);
                } else {
                    this.gb.getLocalBoards().get(i).setState(false);
                }
            }
        } else {
            for (int i = 0; i < lbCount; i++) {
                if ((boxNumber - 1) == i) {
                    this.gb.getLocalBoards().get(i).setState(false);
                } else {
                    this.gb.getLocalBoards().get(i).setState(true);
                }
            }
        }
    }

    private void publishLBStateAndBoxState_boxBtnOnAction() throws Exception {
        publishLBState();
        publishActiveLBsBoxState();
    }

    private void updateDBLBStateAndValues_boxBtnOnAction() throws Exception {
        updateLBStateTable();
    }

    private void checkForLBWin(int lbNumber) throws Exception {
        Box box1 = this.gb.getLocalBoards().get(lbNumber - 1).getBoxs().get(0);
        Box box2 = this.gb.getLocalBoards().get(lbNumber - 1).getBoxs().get(1);
        Box box3 = this.gb.getLocalBoards().get(lbNumber - 1).getBoxs().get(2);
        Box box4 = this.gb.getLocalBoards().get(lbNumber - 1).getBoxs().get(3);
        Box box5 = this.gb.getLocalBoards().get(lbNumber - 1).getBoxs().get(4);
        Box box6 = this.gb.getLocalBoards().get(lbNumber - 1).getBoxs().get(5);
        Box box7 = this.gb.getLocalBoards().get(lbNumber - 1).getBoxs().get(6);
        Box box8 = this.gb.getLocalBoards().get(lbNumber - 1).getBoxs().get(7);
        Box box9 = this.gb.getLocalBoards().get(lbNumber - 1).getBoxs().get(8);

        ArrayList<Box> boxs = new ArrayList<>();
        boxs.add(0, box1);
        boxs.add(1, box2);
        boxs.add(2, box3);
        boxs.add(3, box4);
        boxs.add(4, box5);
        boxs.add(5, box6);
        boxs.add(6, box7);
        boxs.add(7, box8);
        boxs.add(8, box9);

        boolean isWinRow = checkRowsForLBWin(boxs);
        boolean isWinColumn = checkColumnsForLBWin(boxs);
        boolean isWinDiagonal = checkDiagonalsForLBWin(boxs);

        String playerName = null;
        if (this.player1.getPlayerID().equals(nextPlayerID)) {
            playerName = this.player1.getName();
        } else if (this.player2.getPlayerID().equals(nextPlayerID)) {
            playerName = this.player2.getName();
        }

        if (isWinRow) {
            setPublishAndUpdatePlayerNewScore(nextPlayerID, 100);

            playGamePlaySound(this.LBWinSoundPath);

            this.gb.getLocalBoards().get(lbNumber - 1).setAvailable(false);
            String sql = "UPDATE lbState SET available = "
                    + "0"
                    + " WHERE board = 'lb"
                    + lbNumber
                    + "';";
            DBUtil.executeUpdate(sql);

            Alert alert = new Alert(
                    Alert.AlertType.NONE,
                    " You Have Earned 100 More Score for Winning a \n 'Row' of Local Board " + lbNumber + ".",
                    ButtonType.OK
            );
            alert.setTitle("Congratulations! " + playerName);
            alert.show();
        }
        if (isWinColumn) {
            setPublishAndUpdatePlayerNewScore(nextPlayerID, 100);

            playGamePlaySound(this.LBWinSoundPath);

            this.gb.getLocalBoards().get(lbNumber - 1).setAvailable(false);
            String sql = "UPDATE lbState SET available = "
                    + "0"
                    + " WHERE board = 'lb"
                    + lbNumber
                    + "';";
            DBUtil.executeUpdate(sql);

            Alert alert = new Alert(
                    Alert.AlertType.NONE,
                    " You Have Earned 100 More Score for Winning a \n 'Column' of Local Board " + lbNumber + ".",
                    ButtonType.OK
            );
            alert.setTitle("Congratulations! " + playerName);
            alert.show();
        }
        if (isWinDiagonal) {
            setPublishAndUpdatePlayerNewScore(nextPlayerID, 100);

            playGamePlaySound(this.LBWinSoundPath);

            this.gb.getLocalBoards().get(lbNumber - 1).setAvailable(false);
            String sql = "UPDATE lbState SET available = "
                    + "0"
                    + " WHERE board = 'lb"
                    + lbNumber
                    + "';";
            DBUtil.executeUpdate(sql);

            Alert alert = new Alert(
                    Alert.AlertType.NONE,
                    " You Have Earned 100 More Score for Winning a \n 'Diagonal' of Local Board " + lbNumber + ".",
                    ButtonType.OK
            );
            alert.setTitle("Congratulations! " + playerName);
            alert.show();
        }
    }

    private boolean checkRowsForLBWin(ArrayList<Box> boxs) throws Exception {
        boolean isWin = false;

        if (areAllSignsEqual(nextPlayerSign, boxs.get(0).getSign(), boxs.get(1).getSign(), boxs.get(2).getSign())) {
            if (!areAllBooleansFalse(boxs.get(0).getState(), boxs.get(1).getState(), boxs.get(2).getState())) {
                isWin = true;
            }
        } else if (areAllSignsEqual(nextPlayerSign, boxs.get(3).getSign(), boxs.get(4).getSign(), boxs.get(5).getSign())) {
            if (!areAllBooleansFalse(boxs.get(3).getState(), boxs.get(4).getState(), boxs.get(5).getState())) {
                isWin = true;
            }
        } else if (areAllSignsEqual(nextPlayerSign, boxs.get(6).getSign(), boxs.get(7).getSign(), boxs.get(8).getSign())) {
            if (!areAllBooleansFalse(boxs.get(6).getState(), boxs.get(7).getState(), boxs.get(8).getState())) {
                isWin = true;
            }
        }

        return isWin;
    }

    private boolean checkColumnsForLBWin(ArrayList<Box> boxs) throws Exception {
        boolean isWin = false;

        if (areAllSignsEqual(nextPlayerSign, boxs.get(0).getSign(), boxs.get(3).getSign(), boxs.get(6).getSign())) {
            if (!areAllBooleansFalse(boxs.get(0).getState(), boxs.get(3).getState(), boxs.get(6).getState())) {
                isWin = true;
            }
        } else if (areAllSignsEqual(nextPlayerSign, boxs.get(1).getSign(), boxs.get(4).getSign(), boxs.get(7).getSign())) {
            if (!areAllBooleansFalse(boxs.get(1).getState(), boxs.get(4).getState(), boxs.get(7).getState())) {
                isWin = true;
            }
        } else if (areAllSignsEqual(nextPlayerSign, boxs.get(2).getSign(), boxs.get(5).getSign(), boxs.get(8).getSign())) {
            if (!areAllBooleansFalse(boxs.get(2).getState(), boxs.get(5).getState(), boxs.get(8).getState())) {
                isWin = true;
            }
        }

        return isWin;
    }

    private boolean checkDiagonalsForLBWin(ArrayList<Box> boxs) throws Exception {
        boolean isWin = false;

        if (areAllSignsEqual(nextPlayerSign, boxs.get(0).getSign(), boxs.get(4).getSign(), boxs.get(8).getSign())) {
            if (!areAllBooleansFalse(boxs.get(0).getState(), boxs.get(4).getState(), boxs.get(8).getState())) {
                isWin = true;
            }
        } else if (areAllSignsEqual(nextPlayerSign, boxs.get(2).getSign(), boxs.get(4).getSign(), boxs.get(6).getSign())) {
            if (!areAllBooleansFalse(boxs.get(2).getState(), boxs.get(4).getState(), boxs.get(6).getState())) {
                isWin = true;
            }
        }

        return isWin;
    }

    private boolean checkForGBWin(int lbNumber) throws Exception {
        boolean isWinRow = checkRowsForGBWin(lbNumber);
        boolean isWinColumn = checkColumnsForGBWin(lbNumber);
        boolean isWinDiagonal = checkDiagonalsForGBWin(lbNumber);
        boolean isWin = false;

        String playerName = null;
        if (this.player1.getPlayerID().equals(nextPlayerID)) {
            playerName = this.player1.getName();
        } else if (this.player2.getPlayerID().equals(nextPlayerID)) {
            playerName = this.player2.getName();
        }

        if (isWinRow) {
            isWin = true;
            setPublishAndUpdatePlayerNewScore(nextPlayerID, 700);

            Alert alert = new Alert(
                    Alert.AlertType.NONE,
                    " You Have Earned 700 More Score for Winning a \n 'Row' of Global Board.",
                    ButtonType.OK
            );
            alert.setTitle("Congratulations! " + playerName);
            alert.show();
        }
        if (isWinColumn) {
            isWin = true;
            setPublishAndUpdatePlayerNewScore(nextPlayerID, 700);

            Alert alert = new Alert(
                    Alert.AlertType.NONE,
                    " You Have Earned 700 More Score for Winning a \n 'Column' of Global Board.",
                    ButtonType.OK
            );
            alert.setTitle("Congratulations! " + playerName);
            alert.show();
        }
        if (isWinDiagonal) {
            isWin = true;
            setPublishAndUpdatePlayerNewScore(nextPlayerID, 700);

            Alert alert = new Alert(
                    Alert.AlertType.NONE,
                    " You Have Earned 700 More Score for Winning a \n 'Diagonal' of Global Board.",
                    ButtonType.OK
            );
            alert.setTitle("Congratulations! " + playerName);
            alert.show();
        }

        return isWin;
    }

    private boolean checkRowsForGBWin(int lbNumber) throws Exception {
        boolean isWin = false;

        switch (lbNumber) {
            case 1:
            case 2:
            case 3:
                if (areAllSignsEqual(
                        nextPlayerSign,
                        this.gb.getLocalBoards().get(0).getBoxs().get(0).getSign(),
                        this.gb.getLocalBoards().get(0).getBoxs().get(1).getSign(),
                        this.gb.getLocalBoards().get(0).getBoxs().get(2).getSign(),
                        this.gb.getLocalBoards().get(1).getBoxs().get(0).getSign(),
                        this.gb.getLocalBoards().get(1).getBoxs().get(1).getSign(),
                        this.gb.getLocalBoards().get(1).getBoxs().get(2).getSign(),
                        this.gb.getLocalBoards().get(2).getBoxs().get(0).getSign(),
                        this.gb.getLocalBoards().get(2).getBoxs().get(1).getSign(),
                        this.gb.getLocalBoards().get(2).getBoxs().get(2).getSign()
                )) {
                    if (!areAllBooleansFalse(
                            this.gb.getLocalBoards().get(0).getBoxs().get(0).getState(),
                            this.gb.getLocalBoards().get(0).getBoxs().get(1).getState(),
                            this.gb.getLocalBoards().get(0).getBoxs().get(2).getState(),
                            this.gb.getLocalBoards().get(1).getBoxs().get(0).getState(),
                            this.gb.getLocalBoards().get(1).getBoxs().get(1).getState(),
                            this.gb.getLocalBoards().get(1).getBoxs().get(2).getState(),
                            this.gb.getLocalBoards().get(2).getBoxs().get(0).getState(),
                            this.gb.getLocalBoards().get(2).getBoxs().get(1).getState(),
                            this.gb.getLocalBoards().get(2).getBoxs().get(2).getState()
                    )) {
                        isWin = true;
                    }
                } else if (areAllSignsEqual(
                        nextPlayerSign,
                        this.gb.getLocalBoards().get(0).getBoxs().get(3).getSign(),
                        this.gb.getLocalBoards().get(0).getBoxs().get(4).getSign(),
                        this.gb.getLocalBoards().get(0).getBoxs().get(5).getSign(),
                        this.gb.getLocalBoards().get(1).getBoxs().get(3).getSign(),
                        this.gb.getLocalBoards().get(1).getBoxs().get(4).getSign(),
                        this.gb.getLocalBoards().get(1).getBoxs().get(5).getSign(),
                        this.gb.getLocalBoards().get(2).getBoxs().get(3).getSign(),
                        this.gb.getLocalBoards().get(2).getBoxs().get(4).getSign(),
                        this.gb.getLocalBoards().get(2).getBoxs().get(5).getSign()
                )) {
                    if (!areAllBooleansFalse(
                            this.gb.getLocalBoards().get(0).getBoxs().get(3).getState(),
                            this.gb.getLocalBoards().get(0).getBoxs().get(4).getState(),
                            this.gb.getLocalBoards().get(0).getBoxs().get(5).getState(),
                            this.gb.getLocalBoards().get(1).getBoxs().get(3).getState(),
                            this.gb.getLocalBoards().get(1).getBoxs().get(4).getState(),
                            this.gb.getLocalBoards().get(1).getBoxs().get(5).getState(),
                            this.gb.getLocalBoards().get(2).getBoxs().get(3).getState(),
                            this.gb.getLocalBoards().get(2).getBoxs().get(4).getState(),
                            this.gb.getLocalBoards().get(2).getBoxs().get(5).getState()
                    )) {
                        isWin = true;
                    }
                } else if (areAllSignsEqual(
                        nextPlayerSign,
                        this.gb.getLocalBoards().get(0).getBoxs().get(6).getSign(),
                        this.gb.getLocalBoards().get(0).getBoxs().get(7).getSign(),
                        this.gb.getLocalBoards().get(0).getBoxs().get(8).getSign(),
                        this.gb.getLocalBoards().get(1).getBoxs().get(6).getSign(),
                        this.gb.getLocalBoards().get(1).getBoxs().get(7).getSign(),
                        this.gb.getLocalBoards().get(1).getBoxs().get(8).getSign(),
                        this.gb.getLocalBoards().get(2).getBoxs().get(6).getSign(),
                        this.gb.getLocalBoards().get(2).getBoxs().get(7).getSign(),
                        this.gb.getLocalBoards().get(2).getBoxs().get(8).getSign()
                )) {
                    if (!areAllBooleansFalse(
                            this.gb.getLocalBoards().get(0).getBoxs().get(6).getState(),
                            this.gb.getLocalBoards().get(0).getBoxs().get(7).getState(),
                            this.gb.getLocalBoards().get(0).getBoxs().get(8).getState(),
                            this.gb.getLocalBoards().get(1).getBoxs().get(6).getState(),
                            this.gb.getLocalBoards().get(1).getBoxs().get(7).getState(),
                            this.gb.getLocalBoards().get(1).getBoxs().get(8).getState(),
                            this.gb.getLocalBoards().get(2).getBoxs().get(6).getState(),
                            this.gb.getLocalBoards().get(2).getBoxs().get(7).getState(),
                            this.gb.getLocalBoards().get(2).getBoxs().get(8).getState()
                    )) {
                        isWin = true;
                    }
                }
                break;
            case 4:
            case 5:
            case 6:
                if (areAllSignsEqual(
                        nextPlayerSign,
                        this.gb.getLocalBoards().get(3).getBoxs().get(0).getSign(),
                        this.gb.getLocalBoards().get(3).getBoxs().get(1).getSign(),
                        this.gb.getLocalBoards().get(3).getBoxs().get(2).getSign(),
                        this.gb.getLocalBoards().get(4).getBoxs().get(0).getSign(),
                        this.gb.getLocalBoards().get(4).getBoxs().get(1).getSign(),
                        this.gb.getLocalBoards().get(4).getBoxs().get(2).getSign(),
                        this.gb.getLocalBoards().get(5).getBoxs().get(0).getSign(),
                        this.gb.getLocalBoards().get(5).getBoxs().get(1).getSign(),
                        this.gb.getLocalBoards().get(5).getBoxs().get(2).getSign()
                )) {
                    if (!areAllBooleansFalse(
                            this.gb.getLocalBoards().get(3).getBoxs().get(0).getState(),
                            this.gb.getLocalBoards().get(3).getBoxs().get(1).getState(),
                            this.gb.getLocalBoards().get(3).getBoxs().get(2).getState(),
                            this.gb.getLocalBoards().get(4).getBoxs().get(0).getState(),
                            this.gb.getLocalBoards().get(4).getBoxs().get(1).getState(),
                            this.gb.getLocalBoards().get(4).getBoxs().get(2).getState(),
                            this.gb.getLocalBoards().get(5).getBoxs().get(0).getState(),
                            this.gb.getLocalBoards().get(5).getBoxs().get(1).getState(),
                            this.gb.getLocalBoards().get(5).getBoxs().get(2).getState()
                    )) {
                        isWin = true;
                    }
                } else if (areAllSignsEqual(
                        nextPlayerSign,
                        this.gb.getLocalBoards().get(3).getBoxs().get(3).getSign(),
                        this.gb.getLocalBoards().get(3).getBoxs().get(4).getSign(),
                        this.gb.getLocalBoards().get(3).getBoxs().get(5).getSign(),
                        this.gb.getLocalBoards().get(4).getBoxs().get(3).getSign(),
                        this.gb.getLocalBoards().get(4).getBoxs().get(4).getSign(),
                        this.gb.getLocalBoards().get(4).getBoxs().get(5).getSign(),
                        this.gb.getLocalBoards().get(5).getBoxs().get(3).getSign(),
                        this.gb.getLocalBoards().get(5).getBoxs().get(4).getSign(),
                        this.gb.getLocalBoards().get(5).getBoxs().get(5).getSign()
                )) {
                    if (!areAllBooleansFalse(
                            this.gb.getLocalBoards().get(3).getBoxs().get(3).getState(),
                            this.gb.getLocalBoards().get(3).getBoxs().get(4).getState(),
                            this.gb.getLocalBoards().get(3).getBoxs().get(5).getState(),
                            this.gb.getLocalBoards().get(4).getBoxs().get(3).getState(),
                            this.gb.getLocalBoards().get(4).getBoxs().get(4).getState(),
                            this.gb.getLocalBoards().get(4).getBoxs().get(5).getState(),
                            this.gb.getLocalBoards().get(5).getBoxs().get(3).getState(),
                            this.gb.getLocalBoards().get(5).getBoxs().get(4).getState(),
                            this.gb.getLocalBoards().get(5).getBoxs().get(5).getState()
                    )) {
                        isWin = true;
                    }
                } else if (areAllSignsEqual(
                        nextPlayerSign,
                        this.gb.getLocalBoards().get(3).getBoxs().get(6).getSign(),
                        this.gb.getLocalBoards().get(3).getBoxs().get(7).getSign(),
                        this.gb.getLocalBoards().get(3).getBoxs().get(8).getSign(),
                        this.gb.getLocalBoards().get(4).getBoxs().get(6).getSign(),
                        this.gb.getLocalBoards().get(4).getBoxs().get(7).getSign(),
                        this.gb.getLocalBoards().get(4).getBoxs().get(8).getSign(),
                        this.gb.getLocalBoards().get(5).getBoxs().get(6).getSign(),
                        this.gb.getLocalBoards().get(5).getBoxs().get(7).getSign(),
                        this.gb.getLocalBoards().get(5).getBoxs().get(8).getSign()
                )) {
                    if (!areAllBooleansFalse(
                            this.gb.getLocalBoards().get(3).getBoxs().get(6).getState(),
                            this.gb.getLocalBoards().get(3).getBoxs().get(7).getState(),
                            this.gb.getLocalBoards().get(3).getBoxs().get(8).getState(),
                            this.gb.getLocalBoards().get(4).getBoxs().get(6).getState(),
                            this.gb.getLocalBoards().get(4).getBoxs().get(7).getState(),
                            this.gb.getLocalBoards().get(4).getBoxs().get(8).getState(),
                            this.gb.getLocalBoards().get(5).getBoxs().get(6).getState(),
                            this.gb.getLocalBoards().get(5).getBoxs().get(7).getState(),
                            this.gb.getLocalBoards().get(5).getBoxs().get(8).getState()
                    )) {
                        isWin = true;
                    }
                }
                break;
            case 7:
            case 8:
            case 9:
                if (areAllSignsEqual(
                        nextPlayerSign,
                        this.gb.getLocalBoards().get(6).getBoxs().get(0).getSign(),
                        this.gb.getLocalBoards().get(6).getBoxs().get(1).getSign(),
                        this.gb.getLocalBoards().get(6).getBoxs().get(2).getSign(),
                        this.gb.getLocalBoards().get(7).getBoxs().get(0).getSign(),
                        this.gb.getLocalBoards().get(7).getBoxs().get(1).getSign(),
                        this.gb.getLocalBoards().get(7).getBoxs().get(2).getSign(),
                        this.gb.getLocalBoards().get(8).getBoxs().get(0).getSign(),
                        this.gb.getLocalBoards().get(8).getBoxs().get(1).getSign(),
                        this.gb.getLocalBoards().get(8).getBoxs().get(2).getSign()
                )) {
                    if (!areAllBooleansFalse(
                            this.gb.getLocalBoards().get(6).getBoxs().get(0).getState(),
                            this.gb.getLocalBoards().get(6).getBoxs().get(1).getState(),
                            this.gb.getLocalBoards().get(6).getBoxs().get(2).getState(),
                            this.gb.getLocalBoards().get(7).getBoxs().get(0).getState(),
                            this.gb.getLocalBoards().get(7).getBoxs().get(1).getState(),
                            this.gb.getLocalBoards().get(7).getBoxs().get(2).getState(),
                            this.gb.getLocalBoards().get(8).getBoxs().get(0).getState(),
                            this.gb.getLocalBoards().get(8).getBoxs().get(1).getState(),
                            this.gb.getLocalBoards().get(8).getBoxs().get(2).getState()
                    )) {
                        isWin = true;
                    }
                } else if (areAllSignsEqual(
                        nextPlayerSign,
                        this.gb.getLocalBoards().get(6).getBoxs().get(3).getSign(),
                        this.gb.getLocalBoards().get(6).getBoxs().get(4).getSign(),
                        this.gb.getLocalBoards().get(6).getBoxs().get(5).getSign(),
                        this.gb.getLocalBoards().get(7).getBoxs().get(3).getSign(),
                        this.gb.getLocalBoards().get(7).getBoxs().get(4).getSign(),
                        this.gb.getLocalBoards().get(7).getBoxs().get(5).getSign(),
                        this.gb.getLocalBoards().get(8).getBoxs().get(3).getSign(),
                        this.gb.getLocalBoards().get(8).getBoxs().get(4).getSign(),
                        this.gb.getLocalBoards().get(8).getBoxs().get(5).getSign()
                )) {
                    if (!areAllBooleansFalse(
                            this.gb.getLocalBoards().get(6).getBoxs().get(3).getState(),
                            this.gb.getLocalBoards().get(6).getBoxs().get(4).getState(),
                            this.gb.getLocalBoards().get(6).getBoxs().get(5).getState(),
                            this.gb.getLocalBoards().get(7).getBoxs().get(3).getState(),
                            this.gb.getLocalBoards().get(7).getBoxs().get(4).getState(),
                            this.gb.getLocalBoards().get(7).getBoxs().get(5).getState(),
                            this.gb.getLocalBoards().get(8).getBoxs().get(3).getState(),
                            this.gb.getLocalBoards().get(8).getBoxs().get(4).getState(),
                            this.gb.getLocalBoards().get(8).getBoxs().get(5).getState()
                    )) {
                        isWin = true;
                    }
                } else if (areAllSignsEqual(
                        nextPlayerSign,
                        this.gb.getLocalBoards().get(6).getBoxs().get(6).getSign(),
                        this.gb.getLocalBoards().get(6).getBoxs().get(7).getSign(),
                        this.gb.getLocalBoards().get(6).getBoxs().get(8).getSign(),
                        this.gb.getLocalBoards().get(7).getBoxs().get(6).getSign(),
                        this.gb.getLocalBoards().get(7).getBoxs().get(7).getSign(),
                        this.gb.getLocalBoards().get(7).getBoxs().get(8).getSign(),
                        this.gb.getLocalBoards().get(8).getBoxs().get(6).getSign(),
                        this.gb.getLocalBoards().get(8).getBoxs().get(7).getSign(),
                        this.gb.getLocalBoards().get(8).getBoxs().get(8).getSign()
                )) {
                    if (!areAllBooleansFalse(
                            this.gb.getLocalBoards().get(6).getBoxs().get(6).getState(),
                            this.gb.getLocalBoards().get(6).getBoxs().get(7).getState(),
                            this.gb.getLocalBoards().get(6).getBoxs().get(8).getState(),
                            this.gb.getLocalBoards().get(7).getBoxs().get(6).getState(),
                            this.gb.getLocalBoards().get(7).getBoxs().get(7).getState(),
                            this.gb.getLocalBoards().get(7).getBoxs().get(8).getState(),
                            this.gb.getLocalBoards().get(8).getBoxs().get(6).getState(),
                            this.gb.getLocalBoards().get(8).getBoxs().get(7).getState(),
                            this.gb.getLocalBoards().get(8).getBoxs().get(8).getState()
                    )) {
                        isWin = true;
                    }
                }
                break;
            default:
                break;
        }

        return isWin;
    }

    private boolean checkColumnsForGBWin(int lbNumber) throws Exception {
        boolean isWin = false;

        switch (lbNumber) {
            case 1:
            case 4:
            case 7:
                if (areAllSignsEqual(
                        nextPlayerSign,
                        this.gb.getLocalBoards().get(0).getBoxs().get(0).getSign(),
                        this.gb.getLocalBoards().get(0).getBoxs().get(3).getSign(),
                        this.gb.getLocalBoards().get(0).getBoxs().get(6).getSign(),
                        this.gb.getLocalBoards().get(3).getBoxs().get(0).getSign(),
                        this.gb.getLocalBoards().get(3).getBoxs().get(3).getSign(),
                        this.gb.getLocalBoards().get(3).getBoxs().get(6).getSign(),
                        this.gb.getLocalBoards().get(6).getBoxs().get(0).getSign(),
                        this.gb.getLocalBoards().get(6).getBoxs().get(3).getSign(),
                        this.gb.getLocalBoards().get(6).getBoxs().get(6).getSign()
                )) {
                    if (!areAllBooleansFalse(
                            this.gb.getLocalBoards().get(0).getBoxs().get(0).getState(),
                            this.gb.getLocalBoards().get(0).getBoxs().get(3).getState(),
                            this.gb.getLocalBoards().get(0).getBoxs().get(6).getState(),
                            this.gb.getLocalBoards().get(3).getBoxs().get(0).getState(),
                            this.gb.getLocalBoards().get(3).getBoxs().get(3).getState(),
                            this.gb.getLocalBoards().get(3).getBoxs().get(6).getState(),
                            this.gb.getLocalBoards().get(6).getBoxs().get(0).getState(),
                            this.gb.getLocalBoards().get(6).getBoxs().get(3).getState(),
                            this.gb.getLocalBoards().get(6).getBoxs().get(6).getState()
                    )) {
                        isWin = true;
                    }
                } else if (areAllSignsEqual(
                        nextPlayerSign,
                        this.gb.getLocalBoards().get(0).getBoxs().get(1).getSign(),
                        this.gb.getLocalBoards().get(0).getBoxs().get(4).getSign(),
                        this.gb.getLocalBoards().get(0).getBoxs().get(7).getSign(),
                        this.gb.getLocalBoards().get(3).getBoxs().get(1).getSign(),
                        this.gb.getLocalBoards().get(3).getBoxs().get(4).getSign(),
                        this.gb.getLocalBoards().get(3).getBoxs().get(7).getSign(),
                        this.gb.getLocalBoards().get(6).getBoxs().get(1).getSign(),
                        this.gb.getLocalBoards().get(6).getBoxs().get(4).getSign(),
                        this.gb.getLocalBoards().get(6).getBoxs().get(7).getSign()
                )) {
                    if (!areAllBooleansFalse(
                            this.gb.getLocalBoards().get(0).getBoxs().get(1).getState(),
                            this.gb.getLocalBoards().get(0).getBoxs().get(4).getState(),
                            this.gb.getLocalBoards().get(0).getBoxs().get(7).getState(),
                            this.gb.getLocalBoards().get(3).getBoxs().get(1).getState(),
                            this.gb.getLocalBoards().get(3).getBoxs().get(4).getState(),
                            this.gb.getLocalBoards().get(3).getBoxs().get(7).getState(),
                            this.gb.getLocalBoards().get(6).getBoxs().get(1).getState(),
                            this.gb.getLocalBoards().get(6).getBoxs().get(4).getState(),
                            this.gb.getLocalBoards().get(6).getBoxs().get(7).getState()
                    )) {
                        isWin = true;
                    }
                } else if (areAllSignsEqual(
                        nextPlayerSign,
                        this.gb.getLocalBoards().get(0).getBoxs().get(2).getSign(),
                        this.gb.getLocalBoards().get(0).getBoxs().get(5).getSign(),
                        this.gb.getLocalBoards().get(0).getBoxs().get(8).getSign(),
                        this.gb.getLocalBoards().get(3).getBoxs().get(2).getSign(),
                        this.gb.getLocalBoards().get(3).getBoxs().get(5).getSign(),
                        this.gb.getLocalBoards().get(3).getBoxs().get(8).getSign(),
                        this.gb.getLocalBoards().get(6).getBoxs().get(2).getSign(),
                        this.gb.getLocalBoards().get(6).getBoxs().get(5).getSign(),
                        this.gb.getLocalBoards().get(6).getBoxs().get(8).getSign()
                )) {
                    if (!areAllBooleansFalse(
                            this.gb.getLocalBoards().get(0).getBoxs().get(2).getState(),
                            this.gb.getLocalBoards().get(0).getBoxs().get(5).getState(),
                            this.gb.getLocalBoards().get(0).getBoxs().get(8).getState(),
                            this.gb.getLocalBoards().get(3).getBoxs().get(2).getState(),
                            this.gb.getLocalBoards().get(3).getBoxs().get(5).getState(),
                            this.gb.getLocalBoards().get(3).getBoxs().get(8).getState(),
                            this.gb.getLocalBoards().get(6).getBoxs().get(2).getState(),
                            this.gb.getLocalBoards().get(6).getBoxs().get(5).getState(),
                            this.gb.getLocalBoards().get(6).getBoxs().get(8).getState()
                    )) {
                        isWin = true;
                    }
                }
                break;
            case 2:
            case 5:
            case 8:
                if (areAllSignsEqual(
                        nextPlayerSign,
                        this.gb.getLocalBoards().get(1).getBoxs().get(0).getSign(),
                        this.gb.getLocalBoards().get(1).getBoxs().get(3).getSign(),
                        this.gb.getLocalBoards().get(1).getBoxs().get(6).getSign(),
                        this.gb.getLocalBoards().get(4).getBoxs().get(0).getSign(),
                        this.gb.getLocalBoards().get(4).getBoxs().get(3).getSign(),
                        this.gb.getLocalBoards().get(4).getBoxs().get(6).getSign(),
                        this.gb.getLocalBoards().get(7).getBoxs().get(0).getSign(),
                        this.gb.getLocalBoards().get(7).getBoxs().get(3).getSign(),
                        this.gb.getLocalBoards().get(7).getBoxs().get(6).getSign()
                )) {
                    if (!areAllBooleansFalse(
                            this.gb.getLocalBoards().get(1).getBoxs().get(0).getState(),
                            this.gb.getLocalBoards().get(1).getBoxs().get(3).getState(),
                            this.gb.getLocalBoards().get(1).getBoxs().get(6).getState(),
                            this.gb.getLocalBoards().get(4).getBoxs().get(0).getState(),
                            this.gb.getLocalBoards().get(4).getBoxs().get(3).getState(),
                            this.gb.getLocalBoards().get(4).getBoxs().get(6).getState(),
                            this.gb.getLocalBoards().get(7).getBoxs().get(0).getState(),
                            this.gb.getLocalBoards().get(7).getBoxs().get(3).getState(),
                            this.gb.getLocalBoards().get(7).getBoxs().get(6).getState()
                    )) {
                        isWin = true;
                    }
                } else if (areAllSignsEqual(
                        nextPlayerSign,
                        this.gb.getLocalBoards().get(1).getBoxs().get(1).getSign(),
                        this.gb.getLocalBoards().get(1).getBoxs().get(4).getSign(),
                        this.gb.getLocalBoards().get(1).getBoxs().get(7).getSign(),
                        this.gb.getLocalBoards().get(4).getBoxs().get(1).getSign(),
                        this.gb.getLocalBoards().get(4).getBoxs().get(4).getSign(),
                        this.gb.getLocalBoards().get(4).getBoxs().get(7).getSign(),
                        this.gb.getLocalBoards().get(7).getBoxs().get(1).getSign(),
                        this.gb.getLocalBoards().get(7).getBoxs().get(4).getSign(),
                        this.gb.getLocalBoards().get(7).getBoxs().get(7).getSign()
                )) {
                    if (!areAllBooleansFalse(
                            this.gb.getLocalBoards().get(1).getBoxs().get(1).getState(),
                            this.gb.getLocalBoards().get(1).getBoxs().get(4).getState(),
                            this.gb.getLocalBoards().get(1).getBoxs().get(7).getState(),
                            this.gb.getLocalBoards().get(4).getBoxs().get(1).getState(),
                            this.gb.getLocalBoards().get(4).getBoxs().get(4).getState(),
                            this.gb.getLocalBoards().get(4).getBoxs().get(7).getState(),
                            this.gb.getLocalBoards().get(7).getBoxs().get(1).getState(),
                            this.gb.getLocalBoards().get(7).getBoxs().get(4).getState(),
                            this.gb.getLocalBoards().get(7).getBoxs().get(7).getState()
                    )) {
                        isWin = true;
                    }
                } else if (areAllSignsEqual(
                        nextPlayerSign,
                        this.gb.getLocalBoards().get(1).getBoxs().get(2).getSign(),
                        this.gb.getLocalBoards().get(1).getBoxs().get(5).getSign(),
                        this.gb.getLocalBoards().get(1).getBoxs().get(8).getSign(),
                        this.gb.getLocalBoards().get(4).getBoxs().get(2).getSign(),
                        this.gb.getLocalBoards().get(4).getBoxs().get(5).getSign(),
                        this.gb.getLocalBoards().get(4).getBoxs().get(8).getSign(),
                        this.gb.getLocalBoards().get(7).getBoxs().get(2).getSign(),
                        this.gb.getLocalBoards().get(7).getBoxs().get(5).getSign(),
                        this.gb.getLocalBoards().get(7).getBoxs().get(8).getSign()
                )) {
                    if (!areAllBooleansFalse(
                            this.gb.getLocalBoards().get(1).getBoxs().get(2).getState(),
                            this.gb.getLocalBoards().get(1).getBoxs().get(5).getState(),
                            this.gb.getLocalBoards().get(1).getBoxs().get(8).getState(),
                            this.gb.getLocalBoards().get(4).getBoxs().get(2).getState(),
                            this.gb.getLocalBoards().get(4).getBoxs().get(5).getState(),
                            this.gb.getLocalBoards().get(4).getBoxs().get(8).getState(),
                            this.gb.getLocalBoards().get(7).getBoxs().get(2).getState(),
                            this.gb.getLocalBoards().get(7).getBoxs().get(5).getState(),
                            this.gb.getLocalBoards().get(7).getBoxs().get(8).getState()
                    )) {
                        isWin = true;
                    }
                }
                break;
            case 3:
            case 6:
            case 9:
                if (areAllSignsEqual(
                        nextPlayerSign,
                        this.gb.getLocalBoards().get(2).getBoxs().get(0).getSign(),
                        this.gb.getLocalBoards().get(2).getBoxs().get(3).getSign(),
                        this.gb.getLocalBoards().get(2).getBoxs().get(6).getSign(),
                        this.gb.getLocalBoards().get(5).getBoxs().get(0).getSign(),
                        this.gb.getLocalBoards().get(5).getBoxs().get(3).getSign(),
                        this.gb.getLocalBoards().get(5).getBoxs().get(6).getSign(),
                        this.gb.getLocalBoards().get(8).getBoxs().get(0).getSign(),
                        this.gb.getLocalBoards().get(8).getBoxs().get(3).getSign(),
                        this.gb.getLocalBoards().get(8).getBoxs().get(6).getSign()
                )) {
                    if (!areAllBooleansFalse(
                            this.gb.getLocalBoards().get(2).getBoxs().get(0).getState(),
                            this.gb.getLocalBoards().get(2).getBoxs().get(3).getState(),
                            this.gb.getLocalBoards().get(2).getBoxs().get(6).getState(),
                            this.gb.getLocalBoards().get(5).getBoxs().get(0).getState(),
                            this.gb.getLocalBoards().get(5).getBoxs().get(3).getState(),
                            this.gb.getLocalBoards().get(5).getBoxs().get(6).getState(),
                            this.gb.getLocalBoards().get(8).getBoxs().get(0).getState(),
                            this.gb.getLocalBoards().get(8).getBoxs().get(3).getState(),
                            this.gb.getLocalBoards().get(8).getBoxs().get(6).getState()
                    )) {
                        isWin = true;
                    }
                } else if (areAllSignsEqual(
                        nextPlayerSign,
                        this.gb.getLocalBoards().get(2).getBoxs().get(1).getSign(),
                        this.gb.getLocalBoards().get(2).getBoxs().get(4).getSign(),
                        this.gb.getLocalBoards().get(2).getBoxs().get(7).getSign(),
                        this.gb.getLocalBoards().get(5).getBoxs().get(1).getSign(),
                        this.gb.getLocalBoards().get(5).getBoxs().get(4).getSign(),
                        this.gb.getLocalBoards().get(5).getBoxs().get(7).getSign(),
                        this.gb.getLocalBoards().get(8).getBoxs().get(1).getSign(),
                        this.gb.getLocalBoards().get(8).getBoxs().get(4).getSign(),
                        this.gb.getLocalBoards().get(8).getBoxs().get(7).getSign()
                )) {
                    if (!areAllBooleansFalse(
                            this.gb.getLocalBoards().get(2).getBoxs().get(1).getState(),
                            this.gb.getLocalBoards().get(2).getBoxs().get(4).getState(),
                            this.gb.getLocalBoards().get(2).getBoxs().get(7).getState(),
                            this.gb.getLocalBoards().get(5).getBoxs().get(1).getState(),
                            this.gb.getLocalBoards().get(5).getBoxs().get(4).getState(),
                            this.gb.getLocalBoards().get(5).getBoxs().get(7).getState(),
                            this.gb.getLocalBoards().get(8).getBoxs().get(1).getState(),
                            this.gb.getLocalBoards().get(8).getBoxs().get(4).getState(),
                            this.gb.getLocalBoards().get(8).getBoxs().get(7).getState()
                    )) {
                        isWin = true;
                    }
                } else if (areAllSignsEqual(
                        nextPlayerSign,
                        this.gb.getLocalBoards().get(2).getBoxs().get(2).getSign(),
                        this.gb.getLocalBoards().get(2).getBoxs().get(5).getSign(),
                        this.gb.getLocalBoards().get(2).getBoxs().get(8).getSign(),
                        this.gb.getLocalBoards().get(5).getBoxs().get(2).getSign(),
                        this.gb.getLocalBoards().get(5).getBoxs().get(5).getSign(),
                        this.gb.getLocalBoards().get(5).getBoxs().get(8).getSign(),
                        this.gb.getLocalBoards().get(8).getBoxs().get(2).getSign(),
                        this.gb.getLocalBoards().get(8).getBoxs().get(5).getSign(),
                        this.gb.getLocalBoards().get(8).getBoxs().get(8).getSign()
                )) {
                    if (!areAllBooleansFalse(
                            this.gb.getLocalBoards().get(2).getBoxs().get(2).getState(),
                            this.gb.getLocalBoards().get(2).getBoxs().get(5).getState(),
                            this.gb.getLocalBoards().get(2).getBoxs().get(8).getState(),
                            this.gb.getLocalBoards().get(5).getBoxs().get(2).getState(),
                            this.gb.getLocalBoards().get(5).getBoxs().get(5).getState(),
                            this.gb.getLocalBoards().get(5).getBoxs().get(8).getState(),
                            this.gb.getLocalBoards().get(8).getBoxs().get(2).getState(),
                            this.gb.getLocalBoards().get(8).getBoxs().get(5).getState(),
                            this.gb.getLocalBoards().get(8).getBoxs().get(8).getState()
                    )) {
                        isWin = true;
                    }
                }
                break;
            default:
                break;
        }

        return isWin;
    }

    private boolean checkDiagonalsForGBWin(int lbNumber) throws Exception {
        boolean isWin = false;

        if (lbNumber == 1 || lbNumber == 5 || lbNumber == 9) {
            if (areAllSignsEqual(
                    nextPlayerSign,
                    this.gb.getLocalBoards().get(0).getBoxs().get(0).getSign(),
                    this.gb.getLocalBoards().get(0).getBoxs().get(4).getSign(),
                    this.gb.getLocalBoards().get(0).getBoxs().get(8).getSign(),
                    this.gb.getLocalBoards().get(4).getBoxs().get(0).getSign(),
                    this.gb.getLocalBoards().get(4).getBoxs().get(4).getSign(),
                    this.gb.getLocalBoards().get(4).getBoxs().get(8).getSign(),
                    this.gb.getLocalBoards().get(8).getBoxs().get(0).getSign(),
                    this.gb.getLocalBoards().get(8).getBoxs().get(4).getSign(),
                    this.gb.getLocalBoards().get(8).getBoxs().get(8).getSign()
            )) {
                if (!areAllBooleansFalse(
                        this.gb.getLocalBoards().get(0).getBoxs().get(0).getState(),
                        this.gb.getLocalBoards().get(0).getBoxs().get(4).getState(),
                        this.gb.getLocalBoards().get(0).getBoxs().get(8).getState(),
                        this.gb.getLocalBoards().get(4).getBoxs().get(0).getState(),
                        this.gb.getLocalBoards().get(4).getBoxs().get(4).getState(),
                        this.gb.getLocalBoards().get(4).getBoxs().get(8).getState(),
                        this.gb.getLocalBoards().get(8).getBoxs().get(0).getState(),
                        this.gb.getLocalBoards().get(8).getBoxs().get(4).getState(),
                        this.gb.getLocalBoards().get(8).getBoxs().get(8).getState()
                )) {
                    isWin = true;
                }
            }
        }

        if (lbNumber == 3 || lbNumber == 5 || lbNumber == 7) {
            if (areAllSignsEqual(
                    nextPlayerSign,
                    this.gb.getLocalBoards().get(2).getBoxs().get(2).getSign(),
                    this.gb.getLocalBoards().get(2).getBoxs().get(4).getSign(),
                    this.gb.getLocalBoards().get(2).getBoxs().get(6).getSign(),
                    this.gb.getLocalBoards().get(4).getBoxs().get(2).getSign(),
                    this.gb.getLocalBoards().get(4).getBoxs().get(4).getSign(),
                    this.gb.getLocalBoards().get(4).getBoxs().get(6).getSign(),
                    this.gb.getLocalBoards().get(6).getBoxs().get(2).getSign(),
                    this.gb.getLocalBoards().get(6).getBoxs().get(4).getSign(),
                    this.gb.getLocalBoards().get(6).getBoxs().get(6).getSign()
            )) {
                if (!areAllBooleansFalse(
                        this.gb.getLocalBoards().get(2).getBoxs().get(2).getState(),
                        this.gb.getLocalBoards().get(2).getBoxs().get(4).getState(),
                        this.gb.getLocalBoards().get(2).getBoxs().get(6).getState(),
                        this.gb.getLocalBoards().get(4).getBoxs().get(2).getState(),
                        this.gb.getLocalBoards().get(4).getBoxs().get(4).getState(),
                        this.gb.getLocalBoards().get(4).getBoxs().get(6).getState(),
                        this.gb.getLocalBoards().get(6).getBoxs().get(2).getState(),
                        this.gb.getLocalBoards().get(6).getBoxs().get(4).getState(),
                        this.gb.getLocalBoards().get(6).getBoxs().get(6).getState()
                )) {
                    isWin = true;
                }
            }
        }

        return isWin;
    }

    public boolean areAllSignsEqual(String checkSign, String... otherSigns) throws Exception {
        for (String sign : otherSigns) {
            if (!sign.equals(checkSign)) {
                return false;
            }
        }
        return true;
    }

    public boolean areAllBooleansFalse(boolean... booleanValues) throws Exception {
        for (boolean value : booleanValues) {
            if (value == true) {
                return false;
            }
        }
        return true;
    }

    private void setPublishAndUpdatePlayerNewScore(String playerID, int score) throws Exception {
        int newScore = 0;
        if (player1.getPlayerID().equals(playerID)) {
            newScore = this.player1.getScore() + score;
        } else if (player2.getPlayerID().equals(playerID)) {
            newScore = this.player2.getScore() + score;
        } else {
            printDBErrorAndExit();
        }

        setPlayerNewScore(playerID, newScore);
        publishPlayerNewScore(playerID, newScore);
        updateDBPlayerNewScore(playerID, newScore);
    }

    private void setPlayerNewScore(String playerID, int newScore) throws Exception {
        if (player1.getPlayerID().equals(playerID)) {
            player1.setScore(newScore);
        } else if (player2.getPlayerID().equals(playerID)) {
            player2.setScore(newScore);
        }
    }

    private void publishPlayerNewScore(String playerID, int newScore) throws Exception {
        publishPlayerScores();
    }

    private void updateDBPlayerNewScore(String playerID, int newScore) throws Exception {
        String sql = "UPDATE playerValue SET "
                + " score = " + newScore
                + " WHERE playerID='"
                + playerID
                + "';";

        DBUtil.executeUpdate(sql);
    }

    private void checkForLBFull(int lbNumber) throws Exception {
        boolean isFull = true;

        for (int i = 0; i < boxCount; i++) {
            Node node = this.localBoards.get(lbNumber - 1).get(i);
            JFXButton jFXButton = (JFXButton) node;
            if (jFXButton.getText().equals("")) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            this.gb.getLocalBoards().get(lbNumber - 1).setAvailable(false);

            String sql = "UPDATE lbState SET available = "
                    + "0"
                    + " WHERE board = 'lb"
                    + lbNumber
                    + "';";
            DBUtil.executeUpdate(sql);
        }
    }

    private boolean checkForGBFull() throws Exception {
        boolean isFull = true;

        for (int i = 0; i < lbCount; i++) {
            if (this.gb.getLocalBoards().get(i).getAvailable()) {
                isFull = false;
                break;
            }
        }

        return isFull;
    }

    private void MPGamePlayOver() throws Exception {
        this.gb.setState(0);

        playGamePlaySound(this.gameOverSoundPath);

        String sql = "UPDATE gbState SET state = 0 WHERE board = 'gb';";
        DBUtil.executeUpdate(sql);

        Alert alert1 = new Alert(
                Alert.AlertType.NONE,
                " \n You Win the Game... \n ",
                ButtonType.OK
        );
        alert1.setTitle(" Congratulations! " + this.player1.getName());

        Alert alert2 = new Alert(
                Alert.AlertType.NONE,
                " \n You Win the Game... \n ",
                ButtonType.OK
        );
        alert2.setTitle(" Congratulations! " + this.player2.getName());

        Alert alert3 = new Alert(
                Alert.AlertType.NONE,
                " \n You Both Win the Game... \n ",
                ButtonType.OK
        );
        alert3.setTitle(" Congratulations! " + this.player1.getName() + "&" + this.player2.getName());

        if (this.player1.getScore() > this.player2.getScore()) {
            boolean isHighScore = checkForHighScores(this.player1.getName(), this.player1.getScore());
            if (isHighScore) {
                String alertContestText = ""
                        + " \n You Win the Game... \n "
                        + " \n\n \t\t\t High Score : " + this.player1.getScore();
                alert1.setContentText(alertContestText);
            }

            Optional<ButtonType> action1 = alert1.showAndWait();
            if (action1.get() == ButtonType.OK) {
                homeIcon_onMouseClicked(
                        new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, MouseButton.PRIMARY, 1, true, true, true, true, true, true, true, true, true, true, null)
                );
            }
        } else if (this.player1.getScore() < this.player2.getScore()) {
            boolean isHighScore = checkForHighScores(this.player2.getName(), this.player2.getScore());
            if (isHighScore) {
                String alertContestText = ""
                        + " \n You Win the Game... \n"
                        + " \n\n \t\t\t High Score : " + this.player2.getScore();
                alert2.setContentText(alertContestText);
            }

            Optional<ButtonType> action2 = alert2.showAndWait();
            if (action2.get() == ButtonType.OK) {
                homeIcon_onMouseClicked(
                        new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, MouseButton.PRIMARY, 1, true, true, true, true, true, true, true, true, true, true, null)
                );
            }
        } else if (this.player1.getScore() == this.player2.getScore()) {
            boolean isHighScore = checkForHighScores(this.player1.getName(), this.player1.getScore());
            if (isHighScore) {
                String alertContestText = ""
                        + " \n You Both Win the Game... \n "
                        + " \n\n \t\t\t High Score : " + this.player1.getScore();
                alert3.setContentText(alertContestText);
            }

            Optional<ButtonType> action3 = alert3.showAndWait();
            if (action3.get() == ButtonType.OK) {
                homeIcon_onMouseClicked(
                        new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, MouseButton.PRIMARY, 1, true, true, true, true, true, true, true, true, true, true, null)
                );
            }
        } else {
            printDBErrorAndExit();
        }
    }

    private boolean checkForHighScores(String playerName, int score) throws Exception {
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> scores = new ArrayList<>();
        boolean isHighScore = false;

        String sql1 = "SELECT name, score FROM highscore;";
        ResultSet rst = DBUtil.executeQuery(sql1);

        while (rst.next()) {
            names.add(rst.getString("name"));
            scores.add(rst.getInt("score"));
        }

        if (names.size() < 10) {
            isHighScore = true;

            names.add(playerName);
            scores.add(score);
        } else {
            if (scores.get(scores.size()) < score) {
                isHighScore = true;

                names.remove(names.size());
                scores.remove(scores.size());

                names.add(playerName);
                scores.add(score);
            }
        }

        int temp1 = 0;
        String temp2 = "";

        for (int i = 0; i < names.size(); i++) {
            for (int j = 0; j < names.size() - 1; j++) {
                if (scores.get(j + 1) > scores.get(j)) {
                    temp1 = scores.get(j);
                    scores.set(j, scores.get(j + 1));
                    scores.set(j + 1, temp1);

                    temp2 = names.get(j);
                    names.set(j, names.get(j + 1));
                    names.set(j + 1, temp2);
                }
            }
        }

        String sql2 = "DELETE FROM highscore;";
        DBUtil.executeUpdate(sql2);

        for (int i = 0; i < names.size(); i++) {
            String sql3 = "INSERT INTO highscore (name, score) VALUES ('" + names.get(i) + "'," + scores.get(i) + " )";
            DBUtil.executeUpdate(sql3);
        }

        return isHighScore;
    }

    @FXML
    private void closeIcon_onMouseEntered(MouseEvent event) {
        ImageView icon = (ImageView) event.getSource();

        ScaleTransition scaleTrans = new ScaleTransition(Duration.millis(100), icon);
        scaleTrans.setToX(1.1);
        scaleTrans.setToY(1.1);
        scaleTrans.play();

        RotateTransition trans = new RotateTransition(Duration.millis(200), icon);
        trans.setFromAngle(0.0);
        trans.setToAngle(180.0);
        trans.setCycleCount(1);
        trans.play();
    }

    @FXML
    private void closeIcon_onMouseExited(MouseEvent event) {
        ImageView icon = (ImageView) event.getSource();

        RotateTransition trans = new RotateTransition(Duration.millis(200), icon);
        trans.setFromAngle(180.0);
        trans.setToAngle(0.0);
        trans.setCycleCount(1);
        trans.setAutoReverse(true);
        trans.play();

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
        RotateTransition trans = new RotateTransition(Duration.millis(400), icon);
        trans.setFromAngle(0.0);
        trans.setToAngle(360.0);
        trans.setCycleCount(1);
        trans.play();

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
        RotateTransition trans = new RotateTransition(Duration.millis(400), icon);
        trans.setFromAngle(360.0);
        trans.setToAngle(0.0);
        trans.setCycleCount(1);
        trans.play();
        icon.setEffect(null);
    }

    @FXML
    private void homeIcon_onMouseClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/home.fxml"));
        Scene scene = new Scene(root);
        Stage temp = (Stage) this.mpGamePlayAnchPane.getScene().getWindow();
        temp.close();
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image("/asset/image/gameIcon.png"));
        stage.centerOnScreen();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

        TranslateTransition trans = new TranslateTransition(Duration.millis(300), scene.getRoot());
        trans.setFromX(+scene.getHeight());
        trans.setToX(0);
        trans.play();
    }

    @FXML
    private void restartIcon_onMouseEntered(MouseEvent event) {
        ImageView icon = (ImageView) event.getSource();
        RotateTransition trans = new RotateTransition(Duration.millis(400), icon);
        trans.setFromAngle(360.0);
        trans.setToAngle(0.0);
        trans.setCycleCount(1);
        trans.play();

        DropShadow glow = new DropShadow();
        glow.setColor(Color.rgb(0, 189, 147));
        glow.setWidth(20);
        glow.setHeight(20);
        glow.setRadius(20);
        icon.setEffect(glow);
    }

    @FXML
    private void restartIcon_onMouseExited(MouseEvent event) {
        ImageView icon = (ImageView) event.getSource();
        RotateTransition trans = new RotateTransition(Duration.millis(400), icon);
        trans.setFromAngle(0.0);
        trans.setToAngle(360.0);
        trans.setCycleCount(1);
        trans.play();
        icon.setEffect(null);
    }

    @FXML
    private void restartIcon_onMouseClicked(MouseEvent event) throws IOException, Exception {
        event.consume();
        try {
            playGamePlaySound(confirmMessageSoundPath);
        } catch (Exception ex) {
            printDBErrorAndExit(ex);
        }
        Alert restartConfirmAlert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.CANCEL, ButtonType.YES);
        restartConfirmAlert.setTitle("Restart Game?");
        restartConfirmAlert.setContentText("Are You Sure to Restart Multiplayer Game Play ?");
        Optional<ButtonType> action = restartConfirmAlert.showAndWait();

        if (action.get() == ButtonType.YES) {
            System.gc();
            newMPGamePlay();
        } else if (action.get() == ButtonType.CANCEL) {
            // Do Nothing
        }
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
            try {
                clearDBTables();
                initializeDBTables();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.exit(0);
            Platform.exit();
        }
    }

}
