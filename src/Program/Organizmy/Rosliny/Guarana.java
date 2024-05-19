package Program.Organizmy.Rosliny;

import Program.Organizm;
import Program.Roslina;
import Program.Swiat;

import java.awt.*;

public class Guarana extends Roslina {
    public Guarana(int inicjatywa, int sila, int x, int y, int wiek, Swiat swiat, int zdolnosc){
        super(swiat);
        this.pozycjaX = x;
        this.pozycjaY = y;
        this.wiek = wiek;
        this.inicjatywa = inicjatywa;
        this.sila = sila;
        this.zdolnosc = 0;
    }
    public Guarana(Swiat swiat) {
        super(swiat);
        this.inicjatywa = 0;
        this.sila = 0;
    }

    public Guarana(Swiat swiat, int x, int y) {
        super(swiat);
        this.inicjatywa = 0;
        this.sila = 0;
        this.pozycjaX = x;
        this.pozycjaY = y;
    }

    public Guarana(Swiat swiat, int x, int y, int wiek) {
        super(swiat);
        this.inicjatywa = 0;
        this.sila = 0;
        this.pozycjaX = x;
        this.pozycjaY = y;
        this.wiek = wiek;
    }
    @Override
    public void akcja(){
        super.akcja();
    }

    @Override
    public void kolizja(Organizm organizm) {
        String log;
        organizm.setSila(organizm.getSila() + 3);
        log = organizm.getClass().getSimpleName() + " z (" + organizm.getPozycjaX() + " " + organizm.getPozycjaY() + ") niszczy Guarana  z (" + this.pozycjaX + " " + this.pozycjaY + ").\n";
        swiat.dodajLog(log);
        int x = this.getPozycjaX();
        int y = this.getPozycjaY();
        swiat.usunOrganizm(swiat.getIndexOrganizmu(pozycjaX, pozycjaY));
        organizm.setPozycjaX(x);
        organizm.setPozycjaY(y);
    }

    @Override
    public void wypisz(Graphics g) {
        g.setColor(Color.PINK);
    }

    @Override
    public boolean czyOdbil(Organizm organizm) {
        return false;
    }

    @Override
    protected void ucieczka(Organizm organizm) {

    }

    @Override
    protected void dodanie(int x, int y) {
        swiat.dodajOrganizm(new Guarana(swiat, x, y));
        String log;
        log = this.getClass().getSimpleName() + " z (" + this.pozycjaX + " " + this.pozycjaY + ") rozmnozyla sie na (" + x + " " + y + ").\n";
        swiat.dodajLog(log);
    }
}
