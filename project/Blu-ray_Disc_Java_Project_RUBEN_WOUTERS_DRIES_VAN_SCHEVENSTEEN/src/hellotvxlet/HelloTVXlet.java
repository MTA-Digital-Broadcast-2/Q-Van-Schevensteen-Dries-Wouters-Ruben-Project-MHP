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

    private HGraphicButton[] smallIllustrationButtons = new HGraphicButton[5];
    private String[] smallIllustrationPaths = {"Intro_illu_1.png", "Intro_illu_2.png", "Intro_illu_3.png", "Intro_illu_4.png", "Intro_illu_5.png"};
    private String chosenIllustrationPath = smallIllustrationPaths[0];
    
    public HelloTVXlet() {
        
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
                
        HGraphicButton backButton = new HGraphicButton(Toolkit.getDefaultToolkit().getImage("btn_back.png"));
        backButton.setBordersEnabled(false);
        backButton.setBounds(210, 430, 164, 83);
        backButton.setActionCommand("backButton");
        backButton.addHActionListener(this);
        scene.add(backButton);
        backButton.requestFocus();
        
        HGraphicButton restartButton = new HGraphicButton(Toolkit.getDefaultToolkit().getImage("btn_restart.png"));
        restartButton.setBordersEnabled(false);
        restartButton.setBounds(370, 430, 164, 83);
        restartButton.setActionCommand("restartButton");
        restartButton.addHActionListener(this);
        scene.add(restartButton);
        
        backButton.setFocusTraversal(null, null, null, restartButton);
        restartButton.setFocusTraversal(null, null, backButton, null);
        
        background = new MijnComponent("Play_mockup.png", 0, -35);
        scene.add(background);
 
        scene.repaint();
    }
    
    private void ShowPuzzle() {
        int[][] imgArray =
        {
             {0, 1, 2, 3},
             {4, 5, 6, 7},
             {8, 9, 10, 11},
             {12, 13, 14, 15}
        };
        
        for(int i = 0; i < imgArray.length; i++) {
            for(int j = 0; j < imgArray[i].length; j++) {
                System.out.print(imgArray[i][j] +  ", ");
            }
            System.out.println();
        }
    }
}
