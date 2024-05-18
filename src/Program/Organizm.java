package Program;

import Program.Swiat;

public abstract class Organizm {
    protected int sila;
    protected int inicjatywa;
    protected int pozycjaX;
    protected int pozycjaY;

    protected int wiek;
    protected int zdolnosc;

    protected Swiat swiat;

    Organizm(Swiat swiat){
        this.swiat = swiat;
        sila = 0;
        inicjatywa = 0;
        pozycjaX = 0;
        pozycjaY = 0;
        wiek = 0;
        zdolnosc = 0;
    }

    //getery
    int getSila(){
        return  sila;
    }
    int getInicjatywa(){
        return inicjatywa;
    }
    int getPozycjaX(){
        return pozycjaX;
    }
    int getPozycjaY(){
        return pozycjaY;
    }
    int getWiek(){
        return wiek;
    }
    int getZdolnosc(){
        return zdolnosc;
    }

    //setery
    void setSila(int sila){
        this.sila = sila;
    }
    void setInicjatywa(int inicjatywa){
        this.inicjatywa = inicjatywa;
    }
    void setPozycjaX(int x){
        this.pozycjaX = x;
    }
    void setPozycjaY(int y){
        this.pozycjaY = y;
    }
    void setZdolnosc(int zdolnosc){
        this.zdolnosc = zdolnosc;
    }

    //funkcje
    void dorastanie(){
        this.wiek++;
    }

    //funkcje abstrakcyjne
    public abstract void akcja();
    public abstract void kolizja(Organizm organizm);
    public abstract void wypisz();
    public abstract boolean czyOdbil(Organizm organizm);

    //override

}
