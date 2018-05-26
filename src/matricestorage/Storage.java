package matricestorage;

public interface Storage {

    public abstract void setValeur(int i, int j, double x);
    public abstract double getValeur(int i, int j);
    public abstract double getDeterminant();
    public abstract Matrix getInverse();
}
