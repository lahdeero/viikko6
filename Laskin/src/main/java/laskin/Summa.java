package laskin;

import java.util.HashSet;
import java.util.Set;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Summa extends Laskutoimitus {

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        super.savePrevious();
        int luku = super.getSyotekenttaNumerona();
        super.getSovellus().plus(luku);
        super.getTuloskentta().setText("" + super.getSovellus().tulos());
    }
}
