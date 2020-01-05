package Zad4;

public interface Pompa {
    boolean isOn();
    void setPompa(boolean status);
    void setPressure(float pressure);
    float getPressure();
}
