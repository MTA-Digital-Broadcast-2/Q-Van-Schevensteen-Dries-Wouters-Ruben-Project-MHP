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
    {
        g.setColor(new DVBColor(0,0, 100 ,255));
        g.drawLine(100,100,200,200);
        g.drawString("BLABLABLA, 2, 3", 30, 30);
        //g.fillRoundRect(0,0,50,80,10,10);
    }

}