package Program.Organizmy.Rosliny;

import Program.Organizm;
import Program.Roslina;
import Program.Swiat;

public class Mlecz extends Roslina {
    public Mlecz(Swiat swiat) {
        super(swiat);
        this.inicjatywa = 0;
        this.sila = 0;
    }

    public Mlecz(Swiat swiat, int x, int y) {
        super(swiat);
        this.inicjatywa = 0;
        this.sila = 0;
        this.pozycjaX = x;
        this.pozycjaY = y;
    }

    public Mlecz(Swiat swiat, int x, int y, int wiek) {
        super(swiat);
        this.inicjatywa = 0;
        this.sila = 0;
        this.pozycjaX = x;
        this.pozycjaY = y;
        this.wiek = wiek;
    }
    @Override
    public void akcja(){
        for (int i = 0; i < 3; i++){
            super.akcja();
        }
    }

    @Override
    public void kolizja(Organizm organizm) {
        String log;
        log = organizm.getClass().getSimpleName() + " z (" + organizm.getPozycjaX() + " " + organizm.getPozycjaY() + ") niszczy Mlecz  z (" + this.pozycjaX + " " + this.pozycjaY + ").\n";
        swiat.dodajLog(log);
        int x = this.getPozycjaX();
        int y = this.getPozycjaY();
        swiat.usunOrganizm(swiat.getIndexOrganizmu(x,y));
        organizm.setPozycjaX(x);
        organizm.setPozycjaY(y);
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
        swiat.dodajOrganizm(new Mlecz(swiat, x, y));
        String log;
        log = this.getClass().getSimpleName() + " z (" + this.pozycjaX + " " + this.pozycjaY + ") rozmnozyla sie na (" + x + " " + y + ").\n";
        swiat.dodajLog(log);
    }
}
