package gra;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.Timer;
/**
 * klasa glowna gry zawierajca cala metodyke i schematy dzialania
 * dziedziczy po JPanel oraz impementuje MouseListener i MouseMotionListener
 * @author Natalia Poniatowska
 */
public class akcja extends JPanel implements MouseListener, MouseMotionListener{
    
    int p=0;
    int klik=0;
    Timer t1;
    Okno ok= new Okno();
    status st= new status();
    nowaGra ng=new nowaGra();
    private int a,b;
    private int dX,dY;
    
    Icon[] tla ={
    new ImageIcon(getClass().getResource("ziemias.png")),
    new ImageIcon(getClass().getResource("rzeka.png")),
    new ImageIcon(getClass().getResource("las.png")),
    new ImageIcon(getClass().getResource("jezioro.png")),
    new ImageIcon(getClass().getResource("plaza.png")),
    new ImageIcon(getClass().getResource("tlo.png")),
    new ImageIcon(getClass().getResource("ziemiah.png"))
    };
    Icon[] rzeczy ={
    new ImageIcon(getClass().getResource("ziemias.png")),
    new ImageIcon(getClass().getResource("bursztyn.png")),
    new ImageIcon(getClass().getResource("szyszka.png")),
    new ImageIcon(getClass().getResource("kamien.png")),
    new ImageIcon(getClass().getResource("muszla.png")),
    new ImageIcon(getClass().getResource("butelka.png")),
    new ImageIcon(getClass().getResource("butelkapl.png")),
    new ImageIcon(getClass().getResource("butelkaszkl.png")),
    new ImageIcon(getClass().getResource("karnister.png")),
    new ImageIcon(getClass().getResource("papier.png")),
    };

    public akcja()
    {       
        ok.zakoncz.addMouseListener(this); 
        ok.dalej.addMouseListener(this);
        ok.nowy.addMouseListener(this);   
        ok.pam.addMouseListener(this);
             
        ok.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ok.setVisible(true);
            
        showStatus();              
    }
//metoda ta jest uruchamiana gdy nciskamy przycisk "nastepny poziom"
    void nastPoziom()
    {
        ng.losPolozenia();
        klik++; 
        //zaleznie od liczby klikniec czas jest odliczany/ zapisywany/ zerowany
        
        switch (klik)
        {
            case 1:
                ng.czasStart();
                break;
            case 2:
                ng.t.stop();
                st.czas[0]=ng.czas;
                ng.czas=0;
                ng.czasStart();
                break;
            case 3:
                ng.t.stop();
                st.czas[1]=ng.czas;
                ng.czas=0;
                ng.czasStart();
                break;    
            case 4:
                ng.t.stop();
                st.czas[2]=ng.czas;
                ng.czas=0;
                ng.czasStart();
                break;
            case 5:
                ng.t.stop();
                st.czas[3]=ng.czas;
                ng.czas=0;
                break;    
        }
        if(p < tla.length)
        {
            ok.tlo.setIcon(tla[p]);
            ok.sm.setVisible(false);
            ok.sm1.setVisible(false);
            ok.sm2.setVisible(false);
            ok.sm3.setVisible(false);
            ok.sm4.setVisible(false);
            ok.pam.setVisible(false);
            ok.kosz1.setVisible(false);
            ok.kosz2.setVisible(false);
            ok.kosz3.setVisible(false);
            ok.poz1.setVisible(false);
            ok.poz2.setVisible(false);
            ok.poz3.setVisible(false);
            ok.poz4.setVisible(false);
            ok.poz5.setVisible(false);
        }
        if(p<5 && p>0) 
        {
            st.smieci=5;
            ok.sm.addMouseMotionListener(this);
            ok.sm1.addMouseMotionListener(this);
            ok.sm2.addMouseMotionListener(this);
            ok.sm3.addMouseMotionListener(this);
            ok.sm4.addMouseMotionListener(this);
            
            ok.sm.setIcon(rzeczy[5]);
            ok.sm1.setIcon(rzeczy[6]);
            ok.sm2.setIcon(rzeczy[7]);
            ok.sm3.setIcon(rzeczy[8]);
            ok.sm4.setIcon(rzeczy[9]);
            ok.pam.setIcon(rzeczy[p]);
            
            ok.sm.setBounds(ng.x[0],ng.y[0],89,76);
            ok.sm1.setBounds(ng.x[1],ng.y[1],147,42);
            ok.sm2.setBounds(ng.x[2],ng.y[2],166,48);
            ok.sm3.setBounds(ng.x[3],ng.y[3],120,93);
            ok.sm4.setBounds(ng.x[4],ng.y[4],76,65);
            ok.pam.setBounds(ng.x[5],ng.y[5],100,100);
            
            ok.add(ok.sm);
            ok.add(ok.sm1);
            ok.add(ok.sm2);
            ok.add(ok.sm3);
            ok.add(ok.sm4);
            ok.add(ok.pam); 
            ok.add(ok.kosz1);          
            ok.add(ok.kosz2); 
            ok.add(ok.kosz3);
            
            ok.sm.setVisible(true);
            ok.sm1.setVisible(true);
            ok.sm2.setVisible(true);
            ok.sm3.setVisible(true);
            ok.sm4.setVisible(true);
            ok.pam.setVisible(true);
            ok.kosz1.setVisible(true);
            ok.kosz2.setVisible(true);
            ok.kosz3.setVisible(true);
            
            ok.add(ok.tlo);          
        }
        else
            st.smieci=0;
        if (p==5)
            koniec();
    }
//uruchamiana jest kiedy poziom p=5, pokazuje podsumowanie wynikow
    void koniec()
    {
       
        ok.poz1.setText("Czas przejscia poziomu 1 wynosi: "+st.czas[0]+" s.");
     
        ok.poz2.setText("Czas przejscia poziomu 2 wynosi: "+st.czas[1]+" s.");

        ok.poz3.setText("Czas przejscia poziomu 3 wynosi: "+st.czas[2]+" s.");
   
        ok.poz4.setText("Czas przejscia poziomu 4 wynosi: "+st.czas[3]+" s.");
   
        ok.poz5.setText("Liczba zdobytych pamiatek: "+st.pamiatki);
        
        ok.poz1.setVisible(true);
        ok.poz2.setVisible(true);
        ok.poz3.setVisible(true);
        ok.poz4.setVisible(true);
        ok.poz5.setVisible(true);
                
        ok.add(ok.poz1);
        ok.add(ok.poz2);
        ok.add(ok.poz3);
        ok.add(ok.poz4);
        ok.add(ok.poz5);
        ok.add(ok.tlo);
    }
    
//metoda odswiezajaca status dolnego menu
    void showStatus()
    {
        t1 = new Timer(1000,new ActionListener() {                
            @Override
            public void actionPerformed(ActionEvent e) {                
               ok.stSmieci.setText(Integer.toString(st.smieci));
               ok.stPam.setText(Integer.toString(st.pamiatki));
            }       
        });
        t1.start();
    }

//metoda sprawdzajaca na ktory przycisk (JLabel) nacisnieto
    @Override
    public void mousePressed(MouseEvent e) {
 
        Object zrodlo = e.getSource();
        if (zrodlo == ok.dalej)
        {   
            if(st.smieci<1)
            {
                p++;            
                nastPoziom();
            }
        }
        else if (zrodlo == ok.zakoncz)
                ok.dispose();
        else if (zrodlo == ok.nowy)
        {
            restart();
            nastPoziom();
        } 
        else if (zrodlo == ok.pam)
        {
            odnPamiatki();
        }
        else if (zrodlo == ok.sm)
        {            
            dX = e.getLocationOnScreen().x - ok.sm.getX();         
            dY = e.getLocationOnScreen().y - ok.sm.getY();           
        }
        else if (zrodlo == ok.sm1)
        {           
            dX = e.getLocationOnScreen().x - ok.sm1.getX();
            dY = e.getLocationOnScreen().y - ok.sm1.getY();           
        }
        else if (zrodlo == ok.sm2)
        {     
            dX = e.getLocationOnScreen().x - ok.sm2.getX();
            dY = e.getLocationOnScreen().y - ok.sm2.getY();            
        }
        else if (zrodlo == ok.sm3)
        {   
            dX = e.getLocationOnScreen().x - ok.sm3.getX();
            dY = e.getLocationOnScreen().y - ok.sm3.getY();            
        }
        else if (zrodlo == ok.sm4)
        {     
            dX = e.getLocationOnScreen().x - ok.sm4.getX();
            dY = e.getLocationOnScreen().y - ok.sm4.getY();           
        }
    }
//metoda wywolywana kiedy nacisnieto przycisk "rozpocznij od nowa"
    private void restart()
    {
        p=0;
        klik=0;
        st.pamiatki=0;
        st.smieci=0;
        ok.sm.removeMouseMotionListener(this);
        ok.sm1.removeMouseMotionListener(this);
        ok.sm2.removeMouseMotionListener(this);
        ok.sm3.removeMouseMotionListener(this);
        ok.sm4.removeMouseMotionListener(this);
    }

 //metoda odpowiedzialna za przemieszczanie smieci po planszy
    @Override
    public void mouseDragged(MouseEvent e) {

        Object zrodlo = e.getSource();
        if (zrodlo == ok.sm)
        {           
            a=e.getLocationOnScreen().x - dX;
            b=e.getLocationOnScreen().y - dY;
            if(a<1)
                a=0;
            if(b<1)
                b=0;
            if(a>1250)
                a=1250;
            if(b>690)
                b=690;
            
            ok.sm.setLocation(a,b );
            dX = e.getLocationOnScreen().x - ok.sm.getX();
            dY = e.getLocationOnScreen().y - ok.sm.getY();
            
            
            if(a>409 && a<611 && b>499 && b<751)
            {
                ok.sm.setVisible(false);
                st.smieci-=1;
                ok.sm.removeMouseMotionListener(this);
            }           
        } 
        else if (zrodlo == ok.sm1)
        {           
            a=e.getLocationOnScreen().x - dX;
            b=e.getLocationOnScreen().y - dY;
            if(a<1)
                a=0;
            if(b<1)
                b=0;
            if(a>1250)
                a=1250;
            if(b>690)
                b=690;
            
            ok.sm1.setLocation(a,b );
            dX = e.getLocationOnScreen().x - ok.sm1.getX();
            dY = e.getLocationOnScreen().y - ok.sm1.getY();
            
            
            if(a>209 && a<411 && b>499 && b<751)
            {
                ok.sm1.setVisible(false);
                st.smieci-=1;
                ok.sm1.removeMouseMotionListener(this);
            }
        }
        else if (zrodlo == ok.sm2)
        {
            a=e.getLocationOnScreen().x - dX;
            b=e.getLocationOnScreen().y - dY;
            if(a<1)
                a=0;
            if(b<1)
                b=0;
            if(a>1250)
                a=1250;
            if(b>690)
                b=690;
            
            ok.sm2.setLocation(a,b );
            dX = e.getLocationOnScreen().x - ok.sm2.getX();
            dY = e.getLocationOnScreen().y - ok.sm2.getY();
            
            if(a>409 && a<611 && b>499 && b<751)
            {
                ok.sm2.setVisible(false);
                st.smieci-=1;
                ok.sm2.removeMouseMotionListener(this);
            }
        }
        else if (zrodlo == ok.sm3)
        {
            a=e.getLocationOnScreen().x - dX;
            b=e.getLocationOnScreen().y - dY;
            if(a<1)
                a=0;
            if(b<1)
                b=0;
            if(a>1250)
                a=1250;
            if(b>690)
                b=690;
            
            ok.sm3.setLocation(a,b );
            dX = e.getLocationOnScreen().x - ok.sm3.getX();
            dY = e.getLocationOnScreen().y - ok.sm3.getY();
            
            if(a>209 && a<411 && b>499 && b<751)
            {
                ok.sm3.setVisible(false);
                st.smieci-=1;
                ok.sm3.removeMouseMotionListener(this);
            }
        }
        else if (zrodlo == ok.sm4)
        {
            a=e.getLocationOnScreen().x - dX;
            b=e.getLocationOnScreen().y - dY;
            if(a<1)
                a=0;
            if(b<1)
                b=0;
            if(a>1250)
                a=1250;
            if(b>690)
                b=690;
            
            ok.sm4.setLocation(a,b );
            dX = e.getLocationOnScreen().x - ok.sm4.getX();
            dY = e.getLocationOnScreen().y - ok.sm4.getY();
            
            if(a>9 && a<211 && b>499 && b<751)
            {
                ok.sm4.setVisible(false);
                st.smieci-=1;
                ok.sm4.removeMouseMotionListener(this);
            }
        }       
    }

    private void odnPamiatki()
    {
        ok.pam.setVisible(false);
        st.pamiatki+=1;
    }
         
    @Override
    public void mouseClicked(MouseEvent e) {        
    }    
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) { 
    }
    @Override
    public void mouseExited(MouseEvent e) {        
    }
    @Override
    public void mouseMoved(MouseEvent e) {       
    }
}
