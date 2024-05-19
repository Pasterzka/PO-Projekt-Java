package Program.Organizmy.Rosliny;

import Program.Organizm;
import Program.Roslina;
import Program.Swiat;

import java.awt.*;

public class Trawa extends Roslina {
    public Trawa(Swiat swiat) {
        super(swiat);
        this.inicjatywa = 0;
        this.sila = 0;
    }

    public Trawa(Swiat swiat, int x, int y) {
        super(swiat);
        this.inicjatywa = 0;
        this.sila = 0;
        this.pozycjaX = x;
        this.pozycjaY = y;
    }

    public Trawa(Swiat swiat, int x, int y, int wiek) {
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
        log = organizm.getClass().getSimpleName() + " z (" + organizm.getPozycjaX() + " " + organizm.getPozycjaY() + ") niszczy Trawa  z (" + this.pozycjaX + " " + this.pozycjaY + ").\n";
        swiat.dodajLog(log);
        int x = this.getPozycjaX();
        int y = this.getPozycjaY();
        swiat.usunOrganizm(swiat.getIndexOrganizmu(x,y));
        organizm.setPozycjaX(x);
        organizm.setPozycjaY(y);
    }

    @Override
    protected void ucieczka(Organizm organizm) {

    }
    @Override
    public void wypisz(Graphics g) {
        g.setColor(Color.green);
    }

    @Override
    public boolean czyOdbil(Organizm organizm) {
        return false;
    }

    @Override
    protected void dodanie(int x, int y) {
        swiat.dodajOrganizm(new Trawa(swiat, x, y));
        String log;
        log = this.getClass().getSimpleName() + " z (" + this.pozycjaX + " " + this.pozycjaY + ") rozmnozyla sie na (" + x + " " + y + ").\n";
        swiat.dodajLog(log);
    }
}
