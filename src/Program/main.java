package Program;

import Program.Organizmy.Rosliny.BarszczSosnowskiego;
import Program.Organizmy.Rosliny.Mlecz;
import Program.Organizmy.Rosliny.Trawa;
import Program.Organizmy.Zwierzeta.Wilk;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {

        // Pobranie szerokości i wysokości od użytkownika
        int szerokosc = Integer.parseInt(JOptionPane.showInputDialog("Podaj szerokość planszy:"));
        int wysokosc = Integer.parseInt(JOptionPane.showInputDialog("Podaj wysokość planszy:"));

        List<Organizm> organizmy = new ArrayList<>();

        Swiat swiat = new Swiat(wysokosc, szerokosc, organizmy);

        swiat.dodajOrganizm(new Trawa(swiat,1,1, 1));
        swiat.dodajOrganizm(new Trawa(swiat,1,2, 1));
        swiat.dodajOrganizm(new Trawa(swiat,1,3, 1));
        swiat.dodajOrganizm(new Trawa(swiat,2,3, 1));
        swiat.dodajOrganizm(new Trawa(swiat,2,1, 1));
        swiat.dodajOrganizm(new Trawa(swiat,3,1, 1));
        swiat.dodajOrganizm(new Trawa(swiat,3,2, 1));
        swiat.dodajOrganizm(new Trawa(swiat,3,3, 1));

        swiat.dodajOrganizm(new Wilk(swiat, 2 ,2 , 1));

        SwiatGui swiatGUI = new SwiatGui(swiat);
        swiat.setSwiatGUI(swiatGUI);


    }
}
