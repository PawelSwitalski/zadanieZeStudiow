package Zad4;

public class Panel {
    private boolean przelacznik, dioda;

    public Panel(){
        przelacznik = false;
        dioda = false;
    }

    public boolean getPrzelacznik(){ return przelacznik; }
    public boolean getDioda(){ return dioda; }
    public void setPrzelacznik(boolean przelacznik){ this.przelacznik = przelacznik; }
    public void setDioda(boolean dioda){ this.dioda = dioda; }

    public void setAll(boolean isOn) { przelacznik = isOn; dioda = isOn; }

}
