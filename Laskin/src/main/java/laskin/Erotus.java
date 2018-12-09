package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Erotus extends Laskutoimitus {
    
    public Erotus(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        super.savePrevious();
        int luku = super.getSyotekenttaNumerona();
        super.getSovellus().miinus(luku);
        super.getTuloskentta().setText("" + super.getSovellus().tulos());
    }
}
