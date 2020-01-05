package Zad4.skladniki;

import Zad4.Grzalka;
import Zad4.Pompa;
import Zad4.Zbiornik;

public class Woda implements Grzalka, Pompa, Zbiornik {

    private float temperature, zbiornik, pressure;
    private boolean status = false;

    @Override
    public void setTemperature(float temperature) { this.temperature = temperature; }

    @Override
    public float getTemperature() { return this.temperature; }

    @Override
    public boolean isOn() { return status; }

    @Override
    public void setPompa(boolean status) { this.status = status; }

    @Override
    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    @Override
    public float getPressure() {
        return pressure;
    }

    @Override
    public void napelnij() { zbiornik = 100; }

    @Override
    public boolean isEmpty() { return zbiornik <= 0; }

    @Override
    public void pobierz(float ilosc) {
        if (isOn()) zbiornik -= ilosc;
        else System.out.println("wlacz pompe");
    }

    @Override
    public float getZbiornik() { return zbiornik; }
}
