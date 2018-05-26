package matricestorage;

import java.util.ArrayList;

public class CDSMatrix extends Matrix{

    
    ArrayList<Double> val_diagonale_principale;
    ArrayList<Double> val_diagonale_inf;
    ArrayList<Double> val_diagonale_sup;

    public CDSMatrix(int ordre){
        this.ordre=ordre+1;
    }

    public CDSMatrix(ArrayList<Double> val_diagonale_principale, ArrayList<Double> val_diagonale_inf, ArrayList<Double> val_diagonale_sup) {
        this.val_diagonale_principale = val_diagonale_principale;
        this.val_diagonale_inf = val_diagonale_inf;
        this.val_diagonale_sup = val_diagonale_sup;
    }

    public ArrayList<Double> getVal_diagonale_principale() {
        return val_diagonale_principale;
    }

    public void setVal_diagonale_principale(ArrayList<Double> val_diagonale_principale) {
        this.val_diagonale_principale = val_diagonale_principale;
    }

    public ArrayList<Double> getVal_diagonale_inf() {
        return val_diagonale_inf;
    }

    public void setVal_diagonale_inf(ArrayList<Double> val_diagonale_inf) {
        this.val_diagonale_inf = val_diagonale_inf;
    }

    public ArrayList<Double> getVal_diagonale_sup() {
        return val_diagonale_sup;
    }

    public void setVal_diagonale_sup(ArrayList<Double> val_diagonale_sup) {
        this.val_diagonale_sup = val_diagonale_sup;
    }

    @Override
    public void setValeur(int i, int j, double x) {
        if(i==j)
            this.val_diagonale_principale.set(i, x);
        if (i<j)
             this.val_diagonale_sup.set(i, x);
        if(i>j)
            this.val_diagonale_inf.set(j, x);
        
    }

    @Override
    public double getValeur(int i, int j) {
        if(i==j)
            return this.val_diagonale_principale.get(i);
        if (i<j)
            return this.val_diagonale_sup.get(i);
        if(i>j)
            return this.val_diagonale_inf.get(j);
        else
            return 0;
                   
    }

    @Override
    public double getDeterminant() {
        return 0;
    }

    @Override
    public Matrix getInverse() {
        return null;
    }

    @Override
    public String toString() {
        return "CDSMatrix: \n\n" + " val_diagonale_principale=" + val_diagonale_principale.toString() + "\n\n val_diagonale_inf=" + val_diagonale_inf.toString() + "\n\n val_diagonale_sup=" + val_diagonale_sup.toString() + '}';
    }

    
}
