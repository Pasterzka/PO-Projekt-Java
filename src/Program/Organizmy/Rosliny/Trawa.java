package Program.Organizmy.Rosliny;

import Program.Organizm;
import Program.Roslina;
import Program.Swiat;

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

    }

    @Override
    public void wypisz() {

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
