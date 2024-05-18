package Program;

public abstract class Zwierze extends Organizm{
    Zwierze(Swiat swiat) {
        super(swiat);
    }

    @Override
    public void akcja() {

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
}
