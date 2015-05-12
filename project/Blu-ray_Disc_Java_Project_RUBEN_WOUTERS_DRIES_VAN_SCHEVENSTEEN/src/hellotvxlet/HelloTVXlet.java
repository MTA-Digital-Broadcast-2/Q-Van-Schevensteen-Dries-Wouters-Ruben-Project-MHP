package hellotvxlet;

import java.awt.Color;
import java.awt.Toolkit;
import javax.tv.xlet.*;
import org.havi.ui.*;
import org.havi.ui.event.*;
import java.awt.event.*;

public class HelloTVXlet implements Xlet, HActionListener {
    
    private HScene scene;
   
    private MijnComponent background, solution, puzzle_bg;
    
    private MijnScore scoreTxt, gameOverTxt;
    private int score, startScore;

    String[][][] currentField, solutionField;

    private HGraphicButton backButton, restartButton;
    private HGraphicButton[] tiles;

    private HGraphicButton[] smallIllustrationButtons;
    private String[] smallIllustrationPaths = {"Intro_illu_1.png", "Intro_illu_2.png", "Intro_illu_3.png", "Intro_illu_4.png", "Intro_illu_5.png"};
    private String chosenIllustrationPath;
    
    public HelloTVXlet() {

        score = startScore = 50;

        currentField = new String[4][4][2];
        solutionField = new String[4][4][2];
        
        tiles = new HGraphicButton[16];

        smallIllustrationButtons = new HGraphicButton[5];
        chosenIllustrationPath = smallIllustrationPaths[0];
    }

    public void initXlet(XletContext context) {
        scene = HSceneFactory.getInstance().getDefaultHScene();

        showStartScreen();
        
        scene.validate();
        scene.setVisible(true);
    }

    public void startXlet() {}
    public void pauseXlet() {}
    public void destroyXlet(boolean unconditional) {}

    public void actionPerformed(ActionEvent e) {
        //System.out.println(e.getActionCommand());
        
        // start screen
        if(e.getActionCommand().equals("playButton")) showGameScreen();
        
        for (int i = 0; i < smallIllustrationPaths.length; i++)
            if(e.getActionCommand().equals("smallIllustrationButton" + i)) 
                chosenIllustrationPath = smallIllustrationPaths[i];
        
        // game screen
        if(e.getActionCommand().equals("backButton")) showStartScreen();
        if(e.getActionCommand().equals("restartButton")) showGameScreen();

        for(int i = 0; i < solutionField.length; i++)
            for(int j = 0; j < solutionField[i].length; j++)
                if(e.getActionCommand().equals(solutionField[i][j][0])) 
                    tileClicked(solutionField[i][j][0]);
    }

    /*
    * Show screens functions
    */

    private void showStartScreen() {
        System.out.println("showStartScreen()");
        
        scene.removeAll();
        
        HGraphicButton playButton = new HGraphicButton(Toolkit.getDefaultToolkit().getImage("btn_intro_play.png"));
        playButton.setBordersEnabled(false);
        playButton.setBounds(290, 430, 164, 83);
        playButton.setActionCommand("playButton");
        playButton.addHActionListener(this);
        scene.add(playButton);
        playButton.requestFocus();

        for (int i = 0; i < smallIllustrationButtons.length; i++) {
            smallIllustrationButtons[i] = new HGraphicButton(Toolkit.getDefaultToolkit().getImage("puzzle_images/illustrations/Intro_illu_" + (i + 1) +".png"));
            smallIllustrationButtons[i].setBordersEnabled(false);
            scene.add(smallIllustrationButtons[i]);
            
            smallIllustrationButtons[i].setActionCommand("smallIllustrationButton" + i);
            smallIllustrationButtons[i].addHActionListener(this);
        }
        
        for (int i = 0; i < smallIllustrationButtons.length; i++) {
            HGraphicButton btn = smallIllustrationButtons[i];
            switch(i) {
                case 0:
                    btn.setBounds(35, 250, 131, 152);
                    btn.setFocusTraversal( null, playButton, smallIllustrationButtons[4], smallIllustrationButtons[1]);
                    break;
                case 1:
                    btn.setBounds(166,250,129,152);
                    btn.setFocusTraversal(null, playButton, smallIllustrationButtons[0], smallIllustrationButtons[2]);
                    break;
                case 2:
                    btn.setBounds(295,250,129,152);
                    btn.setFocusTraversal(null, playButton, smallIllustrationButtons[1], smallIllustrationButtons[3]);
                    break;
                case 3:
                    btn.setBounds(424,250,129,152);
                    btn.setFocusTraversal(null, playButton, smallIllustrationButtons[2], smallIllustrationButtons[4]);
                    break;
                case 4:
                    btn.setBounds(553,250,134,152);
                    btn.setFocusTraversal(null, playButton, smallIllustrationButtons[3], smallIllustrationButtons[0]);
                    break;
                default:
                    break;
            }
        }
        
        playButton.setFocusTraversal(smallIllustrationButtons[0], smallIllustrationButtons[4], null, null);
        
        background = new MijnComponent("Intro_bg_test.png", 0, -35);
        scene.add(background);
        
        scene.repaint();
    }

    private void showGameScreen() {
        System.out.println("showGameScreen()");

        score = startScore;

        scene.removeAll();
    
        addPuzzleField(chosenIllustrationPath); 
    
        addGameScreenComponents();
        
        scene.repaint();
    }

    /*
    * Show game screen helper functions
    */

    private void addGameScreenComponents() {
        
        addScore();
        addBackAndRestartButtons();

        puzzle_bg = new MijnComponent("puzzle_images/puzzle_bg.png", 245, 175);
        scene.add(puzzle_bg);
        
        background = new MijnComponent("Play.png", 0, -35);
        scene.add(background);
    }

    private void addScore() {
        String strScore = Integer.toString(score);
        scoreTxt = new MijnScore("Score: " + strScore, 325, 150);
        scene.add(scoreTxt);
    }

    private void addBackAndRestartButtons() {
        backButton = new HGraphicButton(Toolkit.getDefaultToolkit().getImage("btn_back.png"));
        backButton.setBordersEnabled(false);
        backButton.setBounds(210, 480, 164, 83);
        backButton.setActionCommand("backButton");
        backButton.addHActionListener(this);
        scene.add(backButton);
        backButton.requestFocus();
        
        restartButton = new HGraphicButton(Toolkit.getDefaultToolkit().getImage("btn_restart.png"));
        restartButton.setBordersEnabled(false);
        restartButton.setBounds(370, 480, 164, 83);
        restartButton.setActionCommand("restartButton");
        restartButton.addHActionListener(this);
        scene.add(restartButton);
        
        backButton.setFocusTraversal(tiles[0], tiles[0], null, restartButton);
        restartButton.setFocusTraversal(tiles[0], tiles[0], backButton, null);
    }

    private void addPuzzleField(String fullImagePath) {
        String puzzleNr = fullImagePath.substring(11, 12);
        
        initSolutionField(puzzleNr);
        initCurrentField(puzzleNr);

        drawPuzzleField();
    }

    private void reAddPuzzleField (int focusTile) {
        scene.removeAll();
        
        drawPuzzleField();
        addGameScreenComponents();

        addScore();

        tiles[focusTile].requestFocus();

        scene.repaint();
    }

    private void drawPuzzleField() {

        int xStart = 250,
            widthAndHeight = 63,
            x = xStart,
            y = 180;

        int tileIndex = 0;
        
        for(int i = 0; i < currentField.length; i++) {
            for(int j = 0; j < currentField[i].length; j++) {

                tiles[tileIndex] = new HGraphicButton(Toolkit.getDefaultToolkit().getImage(currentField[i][j][1]));
                tiles[tileIndex].setBordersEnabled(false);
                tiles[tileIndex].setBounds(x, y, widthAndHeight, widthAndHeight);
                tiles[tileIndex].setActionCommand(currentField[i][j][0]);
                tiles[tileIndex].addHActionListener(this);
                scene.add(tiles[tileIndex]);

                x += widthAndHeight;

                tileIndex ++;
            }

            x = xStart;
            y += widthAndHeight + 4;
        }

        addGameScreenComponents();

        // UP, DOWN, LEFT, RIGHT
        tiles[0].setFocusTraversal(restartButton, tiles[4], tiles[3], tiles[1]);
        tiles[1].setFocusTraversal(restartButton, tiles[5], tiles[0], tiles[2]);
        tiles[2].setFocusTraversal(restartButton, tiles[6], tiles[1], tiles[3]);
        tiles[3].setFocusTraversal(restartButton, tiles[7], tiles[2], tiles[0]);
        tiles[4].setFocusTraversal(tiles[0], tiles[8], tiles[7], tiles[5]);
        tiles[5].setFocusTraversal(tiles[1], tiles[9], tiles[4], tiles[6]);
        tiles[6].setFocusTraversal(tiles[2], tiles[10], tiles[5], tiles[7]);
        tiles[7].setFocusTraversal(tiles[3], tiles[11], tiles[6], tiles[4]);
        tiles[8].setFocusTraversal(tiles[4], tiles[12], tiles[11], tiles[9]);
        tiles[9].setFocusTraversal(tiles[5], tiles[13], tiles[8], tiles[10]);
        tiles[10].setFocusTraversal(tiles[6], tiles[14], tiles[9], tiles[11]);
        tiles[11].setFocusTraversal(tiles[7], tiles[15], tiles[10], tiles[8]);
        tiles[12].setFocusTraversal(tiles[8], restartButton, tiles[15], tiles[13]);
        tiles[13].setFocusTraversal(tiles[9], restartButton, tiles[12], tiles[14]);
        tiles[14].setFocusTraversal(tiles[10], restartButton, tiles[13], tiles[15]);
        tiles[15].setFocusTraversal(tiles[11], restartButton, tiles[14], tiles[12]);
        backButton.requestFocus();

        scene.repaint();
    }

    private void initSolutionField(String puzzleNr) {

        // Get all image url's (all 16 parts)
        for(int i = 0; i < solutionField.length; i++) {
            for(int j = 0; j < solutionField[i].length; j++) {
                
                int tileIndex = (j + i * 4) + 1;
                String counter = Integer.toString(tileIndex);
                
                if(tileIndex < 10) counter = '0' + Integer.toString(tileIndex);
                
                solutionField[i][j][0] = counter;
                solutionField[i][j][1] = "/puzzle_images/" + "puzzle" + puzzleNr + "/puzzle" + puzzleNr + "_" + counter + ".png"; 
            }
        }
    }

    private void initCurrentField(String puzzleNr) {

        int[] randomTileIndexes = generateRandomAndUniqueNumberArray(16);

        for(int i = 0; i < currentField.length; i++) {
            for(int j = 0; j < currentField[i].length; j++) {
                
                int tileIndex = randomTileIndexes[j + i * 4];

                String counter = Integer.toString(tileIndex) ;
                
                if(tileIndex < 10) counter = '0' + Integer.toString(tileIndex);
                
                currentField[i][j][0] = counter;
                currentField[i][j][1] = "/puzzle_images/" + "puzzle" + puzzleNr + "/puzzle" + puzzleNr + "_" + counter + ".png";

                if(tileIndex == 16)
                    currentField[i][j][1] = "";
            }
        }
    }

    private int[] generateRandomAndUniqueNumberArray(int range) {
        int[] stack = new int[range];
        for (int i = 0; i < range; i++)
            stack[i] = generateRandomAndUniqueNumber(stack, range + 1);

        return stack;
    }

    // Recursive function that keeps calling itself until a new unique number is found on the stack
    private int generateRandomAndUniqueNumber(int[] stack, int range) {
        int randomNum = (int)(Math.random()*range);
        for (int i = 0; i < stack.length; i++)
            if (stack[i] == randomNum) randomNum = generateRandomAndUniqueNumber(stack, range);

        return randomNum;
    }

    /* 
    * Puzzle field functions
    */

    private void tileClicked(String tileIndex) {
        System.out.println("tileClicked()");
        checkIfTileShouldMoveAndMove(tileIndex);
        if(checkIfAllTilesAreInPlace()) 
            endGame(score);
    }

    private void checkIfTileShouldMoveAndMove(String tileIndex) {

        int currentX = 0,
            currentY = 0,
            emptyX = 2,
            emptyY = 2;

        // System.out.println(tileIndex + 1);

        for(int i = 0; i < currentField.length; i++) {
            for(int j = 0; j < currentField[i].length; j++) {
                
                if (currentField[i][j][0].equals(tileIndex)) {
                    currentX = j;
                    currentY = i;
                }

                if (currentField[i][j][0].equals("16")) {
                    emptyX = j;
                    emptyY = i;
                }
            }
        }

        if (currentX == emptyX && (currentY == emptyY + 1 || currentY == emptyY - 1) ||
            currentY == emptyY && (currentX == emptyX + 1 || currentX == emptyX - 1)) {
        
            // System.out.println("Switch tiles");
               
            score -= 10;
            System.out.println("Current score: " + score);

            currentField[emptyY][emptyX][0] = new String(currentField[currentY][currentX][0]);
            currentField[emptyY][emptyX][1] = new String(currentField[currentY][currentX][1]);
            currentField[currentY][currentX][0] = "16";
            currentField[currentY][currentX][1] = "";

            reAddPuzzleField(Integer.parseInt(currentField[emptyY][emptyX][0]) - 1);
        }
        
        if(score <= 0) endGame(score);
    }

    private boolean checkIfAllTilesAreInPlace() {
        for(int i = 0; i < currentField.length; i++) {
            for(int j = 0; j < currentField[i].length; j++) {

                if(currentField[i][j][0].equals(solutionField[i][j][0]))
                    return false;
            }
        }

        return true;
    }
    
    private void endGame(int score){
        scene.removeAll();
        
        gameOverTxt = new MijnScore("Game over! Score: " + Integer.toString(score), 250, 150);
        scene.add(gameOverTxt);

        addBackAndRestartButtons();
        
        String puzzleNr = chosenIllustrationPath.substring(11, 12);
        solution = new MijnComponent("puzzle_images/images/puzzle" + puzzleNr + ".png", 255, 185);
        scene.add(solution);
        
        background = new MijnComponent("Play.png", 0, -35);
        scene.add(background);
    }
}






