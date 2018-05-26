/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Equation_1D;

import java.util.ArrayList;

/**
 *
 * @author Mike Tsebo
 */
public abstract class Maillage implements SecondMembre{
    private double pas;
    protected int nbreMaille;
    private double firstValue=0,lastValue=1;
    protected ArrayList<Double> pointsDuMaillage;
    protected ArrayList<Double> imagesPtsDuMaillage;
    
    public void init(){
    this.setPas();
    this.setPointsDuMaillage();
    this.setImagesPtsDuMaillage();
    }

    public Maillage(int nbreMaille) {
        this.nbreMaille = nbreMaille;
        this.init();
    }
    public Maillage(int nbreMaille,double firstValue,Double lastValue){
        this.nbreMaille=nbreMaille;
        this.firstValue=firstValue;
        this.lastValue=lastValue;
        this.init();
    }
    
    public double getPas() {
        return pas;
    }

    public void setPas() {
        this.pas = (this.lastValue-this.firstValue)/(this.nbreMaille+1);
    }

    public int getNbreMaille() {
        return nbreMaille;
    }

    public void setNbreMaille(int nbreMaille) {
        this.nbreMaille = nbreMaille;
        this.init();
    }

    public ArrayList<Double> getPointsDuMaillage() {
        return pointsDuMaillage;
    }

    public void setPointsDuMaillage() {
        this.pointsDuMaillage=new ArrayList<>();
        for(int i=0;i<this.nbreMaille+1;i++){
            this.pointsDuMaillage.add(this.firstValue+(this.pas/2)+i*this.pas);
        }
    }

    public double getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(double firstValue) {
        this.firstValue = firstValue;
    }

    public double getLastValue() {
        return lastValue;
    }

    public void setLastValue(double lastValue) {
        this.lastValue = lastValue;
    }

    public ArrayList<Double> getImagesPtsDuMaillage() {
        return imagesPtsDuMaillage;
    }

    public void setImagesPtsDuMaillage() {
        this.imagesPtsDuMaillage=new ArrayList<>();
        for(int i=0;i<this.nbreMaille+1;i++){
            this.imagesPtsDuMaillage.add(fonctionSecondMembre(pointsDuMaillage.get(i)));
        }

    }

    @Override
    public double fonctionSecondMembre(double x) {
        return -2;
                //Math.sin(Math.PI*x);
    }
    
    
}
