package Zad4.skladniki;

import Zad4.Zbiornik;

public class Kubki implements Zbiornik {
    private float zbiornik;
    @Override
    public void napelnij() { zbiornik = 100; }

    @Override
    public boolean isEmpty() { return zbiornik == 0; }

    @Override
    public void pobierz(float ilosc) { zbiornik -= ilosc; }

    @Override
    public float getZbiornik() {
        return zbiornik;
    }
}
