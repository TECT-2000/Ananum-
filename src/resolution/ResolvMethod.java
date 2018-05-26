package resolution;

import matricestorage.Matrix;

import java.util.ArrayList;

public abstract class ResolvMethod {
    Matrix matrice; //la matrice A
    ArrayList<Double> vecteurB, solution; // le vecteur B et le vecteur solution

    public ResolvMethod(Matrix matrice, ArrayList<Double> vecteurb) {
        this.matrice = matrice;
        this.vecteurB = vecteurb;
        this.solution=new ArrayList<>();
    }

    public Matrix getMatrice() {
        return matrice;
    }

    public void setMatrice(Matrix matrice) {
        this.matrice = matrice;
        this.resolv();
    }

    public ArrayList<Double> getVecteur() {
        return vecteurB;
    }

    public void setVecteur(ArrayList<Double> vecteurb) {
        this.vecteurB = vecteurb;
        this.resolv();
    }

    public ArrayList<Double> getSolution() {
        return solution;
    }

    public abstract void resolv();
}
