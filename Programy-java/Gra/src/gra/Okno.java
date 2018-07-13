
package gra;

import javax.swing.*;
import java.awt.*;
/**
 * Okno inicjalizujace komponenty graficzne gry dziedziczace po JFrame 
 * @author Natalia Poniatowska
 */
public class Okno extends JFrame {
    /** Labele przechowujace wszystkie grafiki uzyte w programie */
    JLabel tlo, smieci, pamiatki, stSmieci, stPam;//tlo i napisy informujace o stanie gry
    JLabel zakoncz, dalej, nowy;//przyciski
    JLabel kosz1, kosz2, kosz3;//kosze na smieci
    JLabel sm, sm1,sm2,sm3,sm4,pam; //smieci i pamiatki
    JLabel poz1,poz2,poz3,poz4,poz5;//napisy koncowe - podsumowanie wynikow
    
    
    public Okno()
    {      
        
        super("Happy Earth");         
        setSize(1280,900);       
        setLayout(null);
                
                
        tlo = new JLabel(""); 
        smieci = new JLabel("Ilosc pozostalych smieci: "); 
        pamiatki = new JLabel("Pamiatki: ");     
        zakoncz = new JLabel(); 
        stSmieci = new JLabel(); 
        stPam = new JLabel(); 
        zakoncz.setIcon(new ImageIcon (getClass().getResource("zakoncz.png"))); 
        dalej = new JLabel(); 
        dalej.setIcon(new ImageIcon (getClass().getResource("dalej.png")));
        nowy = new JLabel(); 
        nowy.setIcon(new ImageIcon (getClass().getResource("nowa.png")));
        kosz1 = new JLabel(); 
        kosz1.setIcon(new ImageIcon (getClass().getResource("papier kosz.png")));
        kosz2 = new JLabel(); 
        kosz2.setIcon(new ImageIcon (getClass().getResource("plastik kosz.png")));
        kosz3 = new JLabel(); 
        kosz3.setIcon(new ImageIcon (getClass().getResource("szklo kosz.png")));
        
        sm = new JLabel();     
        sm1 = new JLabel(); 
        sm2 = new JLabel();  
        sm3 = new JLabel(); 
        sm4 = new JLabel();
        pam = new JLabel();
        poz1= new JLabel();
        poz2= new JLabel();
        poz3= new JLabel();
        poz4= new JLabel();
        poz5= new JLabel();
         
        tlo.setBounds(0, 0, 1280, 700);
        tlo.setIcon(new ImageIcon (getClass().getResource("ziemias.png"))); // ustawienie poczatkowego tla

        smieci.setFont(new Font ("Arial",Font.BOLD,20)); 
        pamiatki.setFont(new Font ("Arial",Font.BOLD,20));
        stSmieci.setFont(new Font ("Arial",Font.BOLD,20));
        stPam.setFont(new Font ("Arial",Font.BOLD,20));
        poz1.setFont(new Font ("Arial",Font.BOLD,40));
        poz2.setFont(new Font ("Arial",Font.BOLD,40));
        poz3.setFont(new Font ("Arial",Font.BOLD,40));
        poz4.setFont(new Font ("Arial",Font.BOLD,40));
        poz5.setFont(new Font ("Arial",Font.BOLD,40));
        poz1.setForeground(Color.BLUE);
        poz2.setForeground(Color.BLUE);
        poz3.setForeground(Color.BLUE);
        poz4.setForeground(Color.BLUE);
        poz5.setForeground(Color.BLUE);
        
        zakoncz.setBounds(750,750,150,50);
        dalej.setBounds(1000,700,300,150);
        nowy.setBounds(500,750,200,50);
        smieci.setBounds(50,720,300,50);
        pamiatki.setBounds(50,760,150,50);
        stSmieci.setBounds(300,720,300,50);
        stPam.setBounds(150,760,150,50);
        poz1.setBounds(10,10,800,50);
        poz2.setBounds(10,110,800,50);
        poz3.setBounds(10,210,800,50);
        poz4.setBounds(10,310,800,50);
        poz5.setBounds(10,410,800,50);
        kosz1.setBounds(10,500,170,214);
        kosz2.setBounds(210,500,173,233);
        kosz3.setBounds(410,500,171,222);

        
        add(zakoncz);
        add(smieci);
        add(pamiatki);
        add(nowy);
        add(dalej);
        add(tlo);
        add(stSmieci);
        add(stPam);

    }   
}
