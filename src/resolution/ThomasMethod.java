package resolution;

import matricestorage.Matrix;

import java.util.ArrayList;

/**
 * la méthode de thomas est utilisée pour les matrices tridiagonales
 */

public class ThomasMethod extends ResolvMethod{

    public ThomasMethod(Matrix matrice, ArrayList<Double> vecteurb) {
        super(matrice, vecteurb);
    }

    @Override
    public void resolv() {
        ArrayList<Double> vecteurY=new ArrayList<>();//vecteur obtenu après résolution de LY=B
        ArrayList<Double> alpha=new ArrayList<>();
        ArrayList<Double> beta=new ArrayList<>();

        for(int k=0;k<this.matrice.getOrdre();k++){
            beta.add(0.0);
            alpha.add(0.0);
            vecteurY.add(0.0);
            this.solution.add(0.0);
        }

        vecteurY.set(0,this.vecteurB.get(0));
        alpha.set(0,this.matrice.getValeur(0,0));
        beta.set(0,0.0); //la première valeur de beta ne devra jamais être utilisée

        //calcul des valeurs de vecteurY
        for(int k=1;k<this.matrice.getOrdre();k++){
            beta.set(k,this.matrice.getValeur(k,k-1)/alpha.get(k-1));
            alpha.set(k,this.matrice.getValeur(k,k)-beta.get(k)*this.matrice.getValeur(k-1,k));
            vecteurY.set(k,this.vecteurB.get(k)-beta.get(k)*vecteurY.get(k-1));
        }

        //calcul des valeurs du vecteur X qui est dans notre cas le vecteur solution
        this.solution.set(this.matrice.getOrdre()-1,vecteurY.get(this.matrice.getOrdre()-1)/alpha.get(this.matrice.getOrdre()-1));
        for(int k=this.matrice.getOrdre()-2;k>=0;k--){
            this.solution.set(k,(vecteurY.get(k)-this.matrice.getValeur(k,k+1)*this.solution.get(k+1))/alpha.get(k));
        }
    }
}
