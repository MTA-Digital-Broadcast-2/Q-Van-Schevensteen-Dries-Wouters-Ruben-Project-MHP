/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import org.havi.ui.HComponent;
import org.havi.ui.*;
import java.awt.*;
import org.dvb.ui.*;

public class MijnComponent extends HComponent {
    
    public MijnComponent(int X, int Y, int H, int W)
    {
        this.setBounds(X,Y,H,W);
    } 
    

    public void paint(Graphics g)
    {// SHADOW RECT (afgerond)
        g.setColor(new DVBColor(0,0,92,100));
        g.fillRoundRect(20,20,250,80,10,10);
        
        // GEWONE RECT (afgerond)
        g.setColor(new DVBColor(0,0,255,255));
        g.fillRoundRect(0,0,250,80,10,10);
        
        // TEXT
        g.setColor(new DVBColor(255,255,0,225));
        g.drawString("Some text", 75, 50); 
    }

}