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
    public int getSila(){
        return  sila;
    }
    public int getInicjatywa(){
        return inicjatywa;
    }
    public int getPozycjaX(){
        return pozycjaX;
    }
    public int getPozycjaY(){
        return pozycjaY;
    }
    public int getWiek(){
        return wiek;
    }
    public int getZdolnosc(){
        return zdolnosc;
    }

    //setery
    public void setSila(int sila){
        this.sila = sila;
    }
    public void setInicjatywa(int inicjatywa){
        this.inicjatywa = inicjatywa;
    }
    public void setPozycjaX(int x){
        this.pozycjaX = x;
    }
    public void setPozycjaY(int y){
        this.pozycjaY = y;
    }
    public void setZdolnosc(int zdolnosc){
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

}
