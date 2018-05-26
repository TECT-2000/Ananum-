package matricestorage;

public abstract class Matrix implements Storage{

    int ordre;// l'ordre de la matrice

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }
}
