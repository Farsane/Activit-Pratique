package Presentation;

import Dao.DaoImplV2;
import Metier.MetierImpl;

public class Pres2 {
    public static void main(String[] args) {
        DaoImplV2 dao = new DaoImplV2();
        MetierImpl metier = new MetierImpl();
        metier.setDao(dao);
        System.out.println("RES = "+ metier.calcul());
    }
}
