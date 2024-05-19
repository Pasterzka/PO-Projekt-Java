package Program.Organizmy.Rosliny;

import Program.Organizm;
import Program.Roslina;
import Program.Swiat;

import java.awt.*;

public class WilczeJagody extends Roslina {
    public WilczeJagody(Swiat swiat) {
        super(swiat);
        this.inicjatywa = 0;
        this.sila = 100;
    }

    public WilczeJagody(Swiat swiat, int x, int y) {
        super(swiat);
        this.inicjatywa = 0;
        this.sila = 100;
        this.pozycjaX = x;
        this.pozycjaY = y;
    }

    public WilczeJagody(Swiat swiat, int x, int y, int wiek) {
        super(swiat);
        this.inicjatywa = 0;
        this.sila = 100;
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
        if (organizm.getSila() > this.sila){
            log = organizm.getClass().getSimpleName() + " z (" + organizm.getPozycjaX() + " " + organizm.getPozycjaY() + ") niszczy WilczeJagody  z (" + this.pozycjaX + " " + this.pozycjaY + ").\n";
            swiat.dodajLog(log);
            log = this.getClass().getSimpleName() + " z (" + this.getPozycjaX() + " " + this.getPozycjaY() + ") niszczy " + organizm.getClass().getSimpleName() + " z (" + this.pozycjaX + " " + this.pozycjaY + ").\n";
            swiat.dodajLog(log);
            swiat.usunOrganizm(swiat.getIndexOrganizmu(organizm.getPozycjaX(), organizm.getPozycjaY()));
            swiat.usunOrganizm(swiat.getIndexOrganizmu(this.getPozycjaX(), this.getPozycjaY()));
        }else {
            log = this.getClass().getSimpleName() + " z (" + this.getPozycjaX() + " " + this.getPozycjaY() + ") niszczy " + organizm.getClass().getSimpleName() + " z (" + this.pozycjaX + " " + this.pozycjaY + ").\n";
            swiat.dodajLog(log);
            swiat.usunOrganizm(swiat.getIndexOrganizmu(organizm.getPozycjaX(), organizm.getPozycjaY()));
        }
    }

    @Override
    public void wypisz(Graphics g) {
        g.setColor(Color.decode("#FF00FF"));
    }
    @Override
    protected void ucieczka(Organizm organizm) {

    }

    @Override
    public boolean czyOdbil(Organizm organizm) {
        return false;
    }

    @Override
    protected void dodanie(int x, int y) {
        swiat.dodajOrganizm(new WilczeJagody(swiat, x, y));
        String log;
        log = this.getClass().getSimpleName() + " z (" + this.pozycjaX + " " + this.pozycjaY + ") rozmnozyla sie na (" + x + " " + y + ").\n";
        swiat.dodajLog(log);
    }
}
