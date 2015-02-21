package hellotvxlet;

import java.awt.Toolkit;
import javax.tv.xlet.*;
import org.havi.ui.*;
import org.havi.ui.event.*;
import java.awt.event.*;

public class HelloTVXlet implements Xlet, HActionListener {
    
    // SCENE & BACKGROUND
    private MijnComponent bgImage;
    private HScene scene;
    
    // ALLE BUTTONS
    private HGraphicButton btnPlay =new HGraphicButton();
    private HGraphicButton img1 =new HGraphicButton();
    private HGraphicButton img2 =new HGraphicButton();
    private HGraphicButton img3 =new HGraphicButton();
    private HGraphicButton img4 =new HGraphicButton();
    private HGraphicButton img5 =new HGraphicButton();
    
    private String chosenImg = "Intro_illu_1.png";;
    
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
        
        // SCENE AANMAKEN 
        scene = HSceneFactory.getInstance().getDefaultHScene();
        
        // ALLE BUTTONS AANMAKEN
        btnPlay.setBounds(290,430,164,83);
        btnPlay.setGraphicContent(Toolkit.getDefaultToolkit().getImage("Intro_btn_play.png"),128);
        
        img1.setBounds(20,250,138,139);
        img1.setGraphicContent(Toolkit.getDefaultToolkit().getImage("Intro_illu_1.png"),128);
        
        img2.setBounds(158,250,134,139);
        img2.setGraphicContent(Toolkit.getDefaultToolkit().getImage("Intro_illu_2.png"),128);
        
        img3.setBounds(292,250,134,139);
        img3.setGraphicContent(Toolkit.getDefaultToolkit().getImage("Intro_illu_3.png"),128);
        
        img4.setBounds(426,250,134,139);
        img4.setGraphicContent(Toolkit.getDefaultToolkit().getImage("Intro_illu_4.png"),128);
        
        img5.setBounds(560,250,138,139);
        img5.setGraphicContent(Toolkit.getDefaultToolkit().getImage("Intro_illu_5.png"),128);
        
        //ACHTERGROND
         bgImage = new MijnComponent("Intro_bg_test.png", 0, -35);
        
          //RICHTING INPUT BUTTONS
          img1.setFocusTraversal( null, btnPlay, img5, img2);
          img2.setFocusTraversal(null, btnPlay, img1, img3);
          img3.setFocusTraversal(null, btnPlay, img2, img4);
          img4.setFocusTraversal(null, btnPlay, img3, img5);
          img5.setFocusTraversal(null, btnPlay, img4, img1);
          btnPlay.setFocusTraversal(img3, img3, null, null);

          //ADD EVERYTHING TO SCENE
          scene.add(img1);
          scene.add(img2);
          scene.add(img3);
          scene.add(img4);
          scene.add(img5);
          scene.add(btnPlay);
          scene.add(bgImage);

          //ACTION NAMES MEEGEVEN
          btnPlay.setActionCommand("btnPlay_actioned");
          btnPlay.addHActionListener(this);
          btnPlay.requestFocus();

          img1.setActionCommand("image1_actioned");
          img1.addHActionListener(this);
          img2.setActionCommand("image2_actioned");
          img2.addHActionListener(this);
          img3.setActionCommand("image3_actioned");
          img3.addHActionListener(this);
          img4.setActionCommand("image4_actioned");
          img4.addHActionListener(this);
          img5.setActionCommand("image5_actioned");
          img5.addHActionListener(this);

          scene.validate();
          scene.setVisible(true);
          btnPlay.setVisible(true);
          img1.setVisible(true);
          img2.setVisible(true);
          img3.setVisible(true);
          img4.setVisible(true);
          img5.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("btnPlay_actioned"))
        {
            System.out.println("CLICKED BUTTON PLAY");
            StartGame();
        }
        if(e.getActionCommand().equals("image1_actioned"))
        {
            chosenImg = "Intro_illu_1.png";
            System.out.println("CHOSEN IMAGE 1");
        }
        if(e.getActionCommand().equals("image2_actioned"))
        {
            chosenImg = "Intro_illu_2.png";
            System.out.println("CHOSEN IMAGE 2");
        }
        if(e.getActionCommand().equals("image3_actioned"))
        {
            chosenImg = "Intro_illu_3.png";
            System.out.println("CHOSEN IMAGE 3");
        }
        if(e.getActionCommand().equals("image4_actioned"))
        {
            chosenImg = "Intro_illu_4.png";
            System.out.println("CHOSEN IMAGE 4");
        }
        if(e.getActionCommand().equals("image5_actioned"))
        {
            chosenImg = "Intro_illu_5.png";
            System.out.println("CHOSEN IMAGE 5");
        }
    }
    public void startXlet() {
       
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }

    private void StartGame() {
        System.out.println("Game started");
        System.out.println(chosenImg);
       
        // ALLES VAN SCENE HALEN (MENU)
        scene.removeAll();

        // ACHTERGROND AANMAKEN
        MijnComponent GameScene = new MijnComponent("Play_mockup.png", 0, -15);
        scene.add(GameScene);
        scene.validate();
        scene.setVisible(true);
        scene.repaint();
    }
}
