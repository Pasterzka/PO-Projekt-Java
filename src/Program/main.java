package Program;

import Program.Organizmy.Rosliny.Trawa;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Organizm> organizmy = new ArrayList<>();
        int wysokosc = 20, szerokosc = 20;
        Swiat swiat = new Swiat(wysokosc, szerokosc, organizmy);

        Trawa r1 = new Trawa(swiat,3,5, 1);
        swiat.dodajOrganizm(r1);
        swiat.nastepnaTura();
        swiat.nastepnaTura();
        swiat.nastepnaTura();
        swiat.nastepnaTura();
        //System.out.println(r1.getClass().getSimpleName());


    }
}
