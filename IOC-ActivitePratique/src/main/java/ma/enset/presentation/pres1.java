package ma.enset.presentation;

import ma.enset.dao.DaoImpl;
import ma.enset.metier.IMetier;
import ma.enset.metier.MetierImpl;

public class pres1 {
    public static void main(String[] args) {
        DaoImpl dao = new DaoImpl();
        MetierImpl metier = new MetierImpl(dao); // injection par le constructeur
        metier.setDao(dao); // injection de dépendance
        System.out.println(metier.calcul());
    }
}
