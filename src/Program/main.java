package Program;

import Program.Organizmy.Rosliny.BarszczSosnowskiego;
import Program.Organizmy.Rosliny.Mlecz;
import Program.Organizmy.Rosliny.Trawa;
import Program.Organizmy.Zwierzeta.Czlowiek;
import Program.Organizmy.Zwierzeta.Wilk;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Organizm> organizmy = new ArrayList<>();

        int wybor = Integer.parseInt(JOptionPane.showInputDialog("Podaj co chcesz robić: 1-Nowa Gra, 2-Wczytaj Gre:"));
        if (wybor == 1){
            // Pobranie szerokości i wysokości od użytkownika
            int szerokosc = Integer.parseInt(JOptionPane.showInputDialog("Podaj szerokość planszy:"));
            int wysokosc = Integer.parseInt(JOptionPane.showInputDialog("Podaj wysokość planszy:"));

            Swiat swiat = new Swiat(wysokosc, szerokosc, organizmy);
            swiat.dodajOrganizm(new Czlowiek(swiat, (int) (Math.random()*szerokosc)+1,(int) (Math.random()*wysokosc)+1));

            SwiatGui swiatGUI = new SwiatGui(swiat);
            swiat.setSwiatGUI(swiatGUI);
        }else{
            Swiat swiat= new Swiat();
            swiat.wczytaj();

            SwiatGui swiatGUI = new SwiatGui(swiat);
            swiat.setSwiatGUI(swiatGUI);
        }









    }
}
