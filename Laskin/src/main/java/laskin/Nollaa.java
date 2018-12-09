package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Nollaa extends Laskutoimitus {

    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void suorita() {
        super.savePrevious();
        super.getSovellus().nollaa();
        super.getTuloskentta().setText("" + super.getSovellus().tulos());
    }
}
