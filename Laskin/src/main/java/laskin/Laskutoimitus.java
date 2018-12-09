package laskin;

import java.util.Stack;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public abstract class Laskutoimitus implements Komento {
    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Sovelluslogiikka sovellus;
    private Stack<Integer> history;
    
    public Laskutoimitus(TextField tuloskentta, TextField syotekentta,Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.sovellus = sovellus;
        this.history = new Stack<>();
    }
    
    public int getSyotekenttaNumerona() {
        try {
            return Integer.parseInt(syotekentta.getText());
        } catch(Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    
    public void savePrevious() {
        this.history.add(Integer.parseInt(tuloskentta.getText()));
    }
    
    @Override
    public void peru() {
        this.sovellus.nollaa();
        if (!history.isEmpty()) { 
            this.sovellus.plus(history.pop());
        }
        this.tuloskentta.setText("" + this.sovellus.tulos());
    }

    
    public TextField getTuloskentta() {
        return tuloskentta;
    }

    public void setTuloskentta(TextField tuloskentta) {
        this.tuloskentta = tuloskentta;
    }

    public TextField getSyotekentta() {
        return syotekentta;
    }

    public void setSyotekentta(TextField syotekentta) {
        this.syotekentta = syotekentta;
    }

    public Button getNollaa() {
        return nollaa;
    }

    public void setNollaa(Button nollaa) {
        this.nollaa = nollaa;
    }

    public Sovelluslogiikka getSovellus() {
        return sovellus;
    }

    public void setSovellus(Sovelluslogiikka sovellus) {
        this.sovellus = sovellus;
    }
    
    
    
}
