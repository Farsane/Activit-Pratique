package Dao;

public class DaoImplV2 implements IDao {
    @Override
    public double getData() {
        System.out.println("Version Web Service ");
        double data = 55;
        return data;
    }
}
