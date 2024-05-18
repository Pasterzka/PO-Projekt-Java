package Program;

import Program.Organizmy.Rosliny.BarszczSosnowskiego;
import Program.Organizmy.Rosliny.Mlecz;
import Program.Organizmy.Rosliny.Trawa;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Organizm> organizmy = new ArrayList<>();
        int wysokosc = 20, szerokosc = 20;
        Swiat swiat = new Swiat(wysokosc, szerokosc, organizmy);

        Mlecz o1 = new Mlecz(swiat,1,1, 1);
        swiat.dodajOrganizm(o1);
        Trawa o2 = new Trawa(swiat,3,4,1);
        swiat.dodajOrganizm(o2);
        swiat.nastepnaTura();
        swiat.nastepnaTura();
        swiat.nastepnaTura();
        swiat.nastepnaTura();
        //System.out.println(r1.getClass().getSimpleName());


    }
}
