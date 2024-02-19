package Presentation;

import Dao.DaoImpl;
import Metier.MetierImpl;

public class Pres1 {
    public static void main(String[] args) {
        DaoImpl dao = new DaoImpl();
        MetierImpl metier = new MetierImpl();
        metier.setDao(dao); //injections des dépendances
        System.out.println("ReS = "+ metier.calcul());
    }
}
