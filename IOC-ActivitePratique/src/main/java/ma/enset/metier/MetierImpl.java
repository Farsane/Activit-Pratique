package ma.enset.metier;

import ma.enset.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service("metier")
public class MetierImpl implements IMetier{
    private IDao dao;
    public MetierImpl(IDao dao) {
        this.dao = dao;
    }
    public void setDao(IDao dao) {
        this.dao = dao;
    }
    @Override
    public double calcul() {
        double d=dao.getData();
        double res=d*23;
        return res;
    }
}
