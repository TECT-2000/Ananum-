/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Equation_1D;

import java.util.ArrayList;
import matricestorage.CDSMatrix;

/**
 *
 * @author Mike Tsebo
 */
public class Equation extends Maillage{
    
    private CDSMatrix matrice;
    private ArrayList<Double> vecteurB;
    
    public Equation(int nbreMaille) {
        super(nbreMaille);
    }

    public Equation( int nbreMaille, double firstValue, Double lastValue) {
        super(nbreMaille, firstValue, lastValue);
        this.setMatrice(nbreMaille);
    }
    

    public CDSMatrix getMatrice() {
        return matrice;
    }

    public void setMatrice(int n) {
        this.matrice=new CDSMatrix(n);
        
        ArrayList<Double> diag_prin=new ArrayList<>();
        diag_prin.add(3.0);
        for(int i=1;i<=n-1;i++)
            diag_prin.add(2.0);
        diag_prin.add(3.0);
        
        this.matrice.setVal_diagonale_principale(diag_prin);
        
        ArrayList<Double> diag_inf=new ArrayList<>();
        diag_inf.add(0.0);
        for(int i=1;i<=n;i++)
            diag_inf.add(-1.0);
        this.matrice.setVal_diagonale_inf(diag_inf);
        
        ArrayList<Double> diag_sup=new ArrayList<>();
        for(int i=0;i<=n-1;i++)
            diag_sup.add(-1.0);
        diag_sup.add(0.0);
        this.matrice.setVal_diagonale_sup(diag_sup);
        
        //initialisation du vecteur B
        this.vecteurB=new ArrayList<>();
        double temp=this.getPas()*this.getPas();
        for(int k=0;k<=n;k++){
            this.vecteurB.add(temp*this.getImagesPtsDuMaillage().get(k));
        }
    }

    public ArrayList<Double> getVecteurB() {
        return vecteurB;
    }

    
    
}
