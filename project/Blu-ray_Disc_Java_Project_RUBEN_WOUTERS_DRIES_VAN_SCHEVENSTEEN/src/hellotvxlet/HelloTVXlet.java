package hellotvxlet;

import java.awt.Color;
import java.awt.Toolkit;
import javax.tv.xlet.*;
import org.havi.ui.*;
import org.havi.ui.event.*;
import java.awt.event.*;

public class HelloTVXlet implements Xlet, HActionListener {
    
    private HScene scene;
   
    private MijnComponent background;

    String[][][] currentField = new String[4][4][2];
    String[][][] solutionField = new String[4][4][2];

    private HGraphicButton backButton, restartButton;
    private HGraphicButton[] tiles;

    private HGraphicButton[] smallIllustrationButtons = new HGraphicButton[5];
    private String[] smallIllustrationPaths = {"Intro_illu_1.png", "Intro_illu_2.png", "Intro_illu_3.png", "Intro_illu_4.png", "Intro_illu_5.png"};
    private String chosenIllustrationPath = smallIllustrationPaths[0];
    
    public HelloTVXlet() {
        tiles = new HGraphicButton[16];
    }

    public void initXlet(XletContext context) {
        scene = HSceneFactory.getInstance().getDefaultHScene();

        startScreen();
        
        scene.validate();
        scene.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        
        // start screen
        if(e.getActionCommand().equals("playButton")) gameScreen();
        
        for (int i = 0; i < smallIllustrationPaths.length; i++) {
            if(e.getActionCommand().equals("smallIllustrationButton" + i)) {
                chosenIllustrationPath = smallIllustrationPaths[i];
                System.out.println(chosenIllustrationPath);
            }
        }
        
        // game screen
        if(e.getActionCommand().equals("backButton")) startScreen();
        if(e.getActionCommand().equals("restartButton")) gameScreen();

        for(int i = 0; i < solutionField.length; i++) {
            for(int j = 0; j < solutionField[i].length; j++) {
                if(e.getActionCommand().equals(solutionField[i][j][0])) tileClicked(solutionField[i][j][0]);
            }
        }

    }
    public void startXlet() {
       
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }
    
    private void startScreen() {
        System.out.println("Start Screen");
        
        scene.removeAll();
        
        HGraphicButton playButton = new HGraphicButton(Toolkit.getDefaultToolkit().getImage("btn_intro_play.png"));
        playButton.setBordersEnabled(false);
        playButton.setBounds(290, 430, 164, 83);
        playButton.setActionCommand("playButton");
        playButton.addHActionListener(this);
        scene.add(playButton);
        playButton.requestFocus();

        for (int i = 0; i < smallIllustrationButtons.length; i++) {
            smallIllustrationButtons[i] = new HGraphicButton(Toolkit.getDefaultToolkit().getImage("Intro_illu_" + (i + 1) +".png"));
            smallIllustrationButtons[i].setBordersEnabled(false);
            scene.add(smallIllustrationButtons[i]);
            
            smallIllustrationButtons[i].setActionCommand("smallIllustrationButton" + i);
            smallIllustrationButtons[i].addHActionListener(this);
        }
        
        for (int i = 0; i < smallIllustrationButtons.length; i++) {
            HGraphicButton btn = smallIllustrationButtons[i];
            switch(i) {
                case 0:
                    btn.setBounds(20, 250, 138, 139);
                    btn.setFocusTraversal( null, playButton, smallIllustrationButtons[4], smallIllustrationButtons[1]);
                    break;
                case 1:
                    btn.setBounds(158,250,134,139);
                    btn.setFocusTraversal(null, playButton, smallIllustrationButtons[0], smallIllustrationButtons[2]);
                    break;
                case 2:
                    btn.setBounds(292,250,134,139);
                    btn.setFocusTraversal(null, playButton, smallIllustrationButtons[1], smallIllustrationButtons[3]);
                    break;
                case 3:
                    btn.setBounds(426,250,134,139);
                    btn.setFocusTraversal(null, playButton, smallIllustrationButtons[2], smallIllustrationButtons[4]);
                    break;
                case 4:
                    btn.setBounds(560,250,138,139);
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

    private void gameScreen() {
        System.out.println("Game Screen");
       
        scene.removeAll();
        
        showPuzzle(chosenIllustrationPath); 

        addBackAndRestartButtons();
        
        background = new MijnComponent("Play.png", 0, -35);
        scene.add(background);
 
        scene.repaint();
    }

    private void showPuzzle(String fullImagePath) {

        String puzzleNr = fullImagePath.substring(11, 12);
        
        fillSolutionField(puzzleNr);
        randomizeCurrentField(puzzleNr);

        drawCurrentField();
    }

    private void fillSolutionField(String puzzleNr) {

        // Get all image url's (all 16 parts)
        for(int i = 0; i < solutionField.length; i++) {
            for(int j = 0; j < solutionField[i].length; j++) {
                
                int tileIndex = (j + i * 4) + 1;
                String counter = Integer.toString(tileIndex);
                
                if(tileIndex < 10) counter = '0' + Integer.toString(tileIndex);
                
                solutionField[i][j][0] = counter;
                solutionField[i][j][1] = "/puzzle_images/" + "puzzle" + puzzleNr + "/puzzle" + puzzleNr + "_" + counter + ".png"; 

                // System.out.println(currentField[i][j][0]);
                // System.out.println(currentField[i][j][1]);
                // System.out.println("--");
                
            }
        }
    }

    private void randomizeCurrentField(String puzzleNr) {

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

                // System.out.println(currentField[i][j][0]);
                // System.out.println(currentField[i][j][1]);
                // System.out.println("--");
                
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

    private void tileClicked(String tileIndex) {
        System.out.println("tileClicked()");

        checkIfTileShouldMoveAndMove(tileIndex);
    }

    private void checkIfTileShouldMoveAndMove(String tileIndex) {

        int currentX = 0,
            currentY = 0,
            emptyX = 2,
            emptyY = 2;

        System.out.println(tileIndex + 1);

        for(int i = 0; i < currentField.length; i++) {
            for(int j = 0; j < currentField[i].length; j++) {
                
                if (currentField[i][j][0].equals(tileIndex)) {
                    currentX = j;
                    currentY = i;
                    System.out.println(i);
                    System.out.println(j);
                }

                if (currentField[i][j][0].equals("16")) {
                    emptyX = j;
                    emptyY = i;
                    System.out.println(i);
                    System.out.println(j);
                }
            }
        }

        if (currentX == emptyX && (currentY == emptyY + 1 || currentY == emptyY - 1) ||
            currentY == emptyY && (currentX == emptyX + 1 || currentX == emptyX - 1)) {
        
            System.out.println("Switch tiles");

            String tileName = new String(currentField[currentY][currentX][0]);
            String tileImageName = new String(currentField[currentY][currentX][1]);
            String emptyTileName = new String(currentField[emptyY][emptyX][0]);
            // String emptyImageName = new String(currentField[emptyY][emptyX][1]);

            currentField[currentY][currentX][0] = emptyTileName;
            currentField[currentY][currentX][1] = "";
            currentField[emptyY][emptyX][0] = tileName;
            currentField[emptyY][emptyX][1] = tileImageName;

            redrawCurrentField(Integer.parseInt(currentField[emptyY][emptyX][0]) - 1);

        }
    }

    private void redrawCurrentField(int focusTile) {

        scene.removeAll();
        
        drawCurrentField();

        addBackAndRestartButtons();
        
        background = new MijnComponent("Play.png", 0, -35);
        scene.add(background);

        tiles[focusTile].requestFocus();

        scene.repaint();
    }

    private void drawCurrentField() {

        int xStart = 250,
            widthAndHeight = 59,
            x = xStart,
            y = 150;

        int tileIndex = 0;
        
        for(int i = 0; i < currentField.length; i++) {
            for(int j = 0; j < currentField[i].length; j++) {

                tiles[tileIndex] = new HGraphicButton(Toolkit.getDefaultToolkit().getImage(currentField[i][j][1]));
                tiles[tileIndex].setBordersEnabled(false);
                tiles[tileIndex].setBounds(x, y, widthAndHeight, widthAndHeight);
                System.out.println(currentField[i][j][1]);
                System.out.println(currentField[i][j][0]);
                tiles[tileIndex].setActionCommand(currentField[i][j][0]);
                tiles[tileIndex].addHActionListener(this);
                scene.add(tiles[tileIndex]);

                x += widthAndHeight;

                tileIndex ++;
            }

            x = xStart;
            y += widthAndHeight;
        }

        addBackAndRestartButtons();

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
}






