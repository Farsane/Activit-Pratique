package Metier;

import Dao.IDao;

public class MetierImpl implements IMetier {
    private IDao dao; //Couplage faible
    @Override
    public double calcul() {
        double data= dao.getData();
        double res = data * 11.4;
        return res;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
