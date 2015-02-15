package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.ui.*;
import java.awt.*;
import org.havi.ui.*;
import org.havi.ui.event.*;
import java.awt.event.*;

public class HelloTVXlet implements Xlet, HActionListener {
    private XletContext actueleXletContext;
    private HScene scene;
    private boolean debug = true;
    
    private HTextButton knop1, knop2, knop3, knop4, knop5;
    
  
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {
      if(debug) System.out.println("Xlet Initialiseren");
      this.actueleXletContext = context;
      HSceneTemplate sceneTemplate = new HSceneTemplate();
      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, 
              new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION,
              new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED );
     
      scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);

      HStaticText tekstLabel = new HStaticText("Wie wordt multimiljonair?");
      tekstLabel.setLocation(200,30);
      tekstLabel.setSize(300,50);
//      tekstLabel.setBackground(new DVBColor(255,255,255,179));
      tekstLabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
      scene.add(tekstLabel);
      
      knop1 = new HTextButton("Antwoord 1");
      knop1.setLocation(200,100);
      knop1.setSize(300,50);
      knop1.setBackground(new DVBColor(0,0,0,179));
      knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      knop2 = new HTextButton("Antwoord 2");
      knop2.setLocation(200,200);
      knop2.setSize(300, 50);
      knop2.setBackground(new DVBColor(0,0,0,179));
      knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      
      knop3 = new HTextButton("Antwoord 3");
      knop3.setLocation(200,300);
      knop3.setSize(300, 50);
      knop3.setBackground(new DVBColor(0,0,0,179));
      knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      
      knop4 = new HTextButton("Antwoord 4");
      knop4.setLocation(200,400);
      knop4.setSize(300, 50);
      knop4.setBackground(new DVBColor(0,0,0,179));
      knop4.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      knop5 = new HTextButton("Hulplijn!");
      knop5.setLocation(200,500);
      knop5.setSize(300, 50);
      knop5.setBackground(new DVBColor(0,0,0,179));
      knop5.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      knop1.setFocusTraversal(knop5, knop2, null, null);
      knop2.setFocusTraversal(knop1, knop3, null, null);
      knop3.setFocusTraversal(knop2, knop4, null, null);
      knop4.setFocusTraversal(knop3, knop5, null, null);
      knop5.setFocusTraversal(knop4, knop1, null, null);
      
      
      scene.add(knop1);
      scene.add(knop2);
      scene.add(knop3);
      scene.add(knop4);
      scene.add(knop5);
      
      knop1.requestFocus();
      
      knop1.setActionCommand("knop1_actioned");
      knop1.addHActionListener(this);
      
      knop2.setActionCommand("knop2_actioned");
      knop2.addHActionListener(this);
      
      knop3.setActionCommand("knop3_actioned");
      knop3.addHActionListener(this);
      
      knop4.setActionCommand("knop4_actioned");
      knop4.addHActionListener(this);
      
      knop5.setActionCommand("knop5_actioned");
      knop5.addHActionListener(this);
   
      
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("knop3_actioned"))
        {
            System.out.println("Juist!");
            knop3.setBackground(new DVBColor(0,200,100,100));
            knop1.setBackground(new DVBColor(255,0,0,255));
            knop2.setBackground(new DVBColor(255,0,0,255));
            knop4.setBackground(new DVBColor(255,0,0,255));
            scene.repaint();
            
        }
        else if(e.getActionCommand().equals("knop5_actioned"))
        {
            System.out.println("Hulplijn gevraagd!");
            knop2.setBackground(new DVBColor(255,0,0,255));
            knop4.setBackground(new DVBColor(255,0,0,255));
            scene.repaint();
            
        }
        else
        {
            knop3.setBackground(new DVBColor(0,0,0,179));
            
            if(e.getActionCommand().equals("knop1_actioned"))
            {
                knop1.setBackground(new DVBColor(255,0,0,255)); 
            }
            
            if(e.getActionCommand().equals("knop2_actioned"))
            {
                 knop2.setBackground(new DVBColor(255,0,0,255));
            }
            
            if(e.getActionCommand().equals("knop4_actioned"))
            {
                 knop4.setBackground(new DVBColor(255,0,0,255));
            }
            
            scene.repaint();
            
            System.out.println("Fout!");
        }
    }
    public void startXlet() {
        if(debug) System.out.println("Xlet starten");
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }
}
