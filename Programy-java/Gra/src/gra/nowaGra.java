
package gra;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

/**
 * klasa rozpoczynajaca odliczanie czasu i losujaca polozenie smmieci
 * wykorzystywana jest przy rozpoczeciu nowego poziomu
 * @author Natalia Poniatowska
 */

public class nowaGra {
    
    private int los[] = new int[6];  
    int x[]= new int[6],y[]= new int[6];
    int czas=0;
    Timer t;
//polozenia smieci zdefiniowane sa punktami
    Point gdzie[]={new Point(10,300),new Point(333,333),
    new Point(1000,400),new Point(1100,500),new Point(700,500),
    new Point(50,350),new Point(50,400),new Point(100,300),
    new Point(550,350),new Point(850,415),new Point(900,338),
    new Point(900,555),new Point(1111,600),new Point(950,400),
    new Point(600,390),new Point(200,320),new Point(300,400),
    new Point(250,430),new Point(650,600),new Point(800,600),
    new Point(900,355),new Point(1111,400),new Point(950,550),
    new Point(600,300),new Point(200,420),new Point(300,300),
    new Point(250,330),new Point(650,400),new Point(800,300),
    };
    
//funkcja losujaca polozenie smieci
    public void losPolozenia()
    {    
  
        Random r = new Random();
        
        for (int i=0;i<los.length;i++)
        {            
            los[i]=r.nextInt(29);
            x[i] = gdzie[los[i]].x;
            y[i] = gdzie[los[i]].y;           
        }             
    }
//funkcja odliczajaca czas trwania kolejnych poziomow
   public void czasStart()
   {
       t = new Timer(1000,new ActionListener() {             
            @Override
            public void actionPerformed(ActionEvent e) {                
               czas++;      
            }       
        });
        t.start();
   }

}