package ma.enset.presentation;

import ma.enset.dao.*;
import ma.enset.metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

import static java.lang.Class.forName;

public class pres2 {
    public static void main(String[] args) throws Exception {

            Scanner scanner = new Scanner(new File("config.txt"));
            String daoClassName = scanner.nextLine();

            Class cDao = Class.forName(daoClassName);
            IDao dao = (IDao) cDao.getConstructor().newInstance();
            String metierClassName = scanner.nextLine();
            Class cMetier = Class.forName(metierClassName);
            IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);

            System.out.println(dao.getData());
    }
}
