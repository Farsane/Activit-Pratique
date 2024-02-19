package Presentation;

import Dao.DaoImplV2;
import Dao.IDao;
import Metier.IMetier;
import Metier.MetierImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Pres2 {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Scanner scanner=new Scanner(new File("config.txt"));
        String daoClassName=scanner.nextLine();
        Class cDao=Class.forName(daoClassName);
        IDao dao=(IDao) cDao.getConstructor().newInstance();
        System.out.println(dao.getData());
        String metierClassName=scanner.nextLine();
        Class cMetier=Class.forName(metierClassName);

        IMetier metier=(IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);

        System.out.println(metier.calcul());
    }
}
