
package gra;

/**
 * klasa glowna zawierajaca metode main
 * @author Asus
 */
public class glowna {
    /** metoda main deklarujaca obiekt akcja */
        public static void main (String[] a)
    {       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                /** deklaracja obiektu klasy akcja */
                akcja ak = new akcja();
            }
        });
    }        
}
