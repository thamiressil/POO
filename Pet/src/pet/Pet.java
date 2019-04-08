package pet;

import java.util.Scanner;

class Pet{
    String nome;

    public int getEnergia() {
        return energia;
    }


    public void setEnergia(int energia) {
        if(energia >= this.energiaMax)
            this.energia = energiaMax;
        else if(energia <= 0) {
            this.energia = 0;
            this.isAlive = false;
        }else
            this.energia = energia;
    }

    public int getSaciedade() {
        return saciedade;
    }

    public void setSaciedade(int saciedade) {
        if(saciedade >= this.saciedadeMax)
            this.saciedade = saciedadeMax;
        else if(saciedade < 0) {
            this.saciedade = 0;
            this.isAlive = false;
        }else
            this.saciedade = saciedade;
    }

    public int getLimpeza() {
        return limpeza;
    }

    public void setLimpeza(int limpeza){
        if(limpeza > this.limpezaMax){
            this.limpeza = this.limpezaMax;
        }else if(limpeza < 0){
            this.limpeza = 0;
            this.isAlive = false;
        }else{
            this.limpeza = limpeza;
        }
    }

    public boolean testAlive(){
        if(this.isAlive)
            return true;
        System.out.println("fail: pet esta morto");
        return false;
    }

    public void play(){
        if(!this.testAlive())
            return;
        this.setEnergia(this.getEnergia() - 2);
        this.setSaciedade(this.getSaciedade() - 1);
        this.setLimpeza(this.getLimpeza() - 3);

        this.diamantes += 1;
        this.idade += 1;
    }

    public void eat(){
        if(!this.testAlive())
            return;
        this.setEnergia(this.getEnergia() - 1);
        this.setSaciedade(this.getSaciedade() + 4);
        this.setLimpeza(this.getLimpeza() - 2);

        this.idade += 1;
    }

    public void sleep(){
        if(!this.testAlive())
            return;
        if(this.energiaMax - this.energia < 5){
            System.out.println("fail: nao esta com sono");
            return;
        }
        this.idade += this.energiaMax - this.energia;
        this.setEnergia(this.getEnergiaMax());
    }
    
    public void limpar(){
        if(!this.testAlive())
            return;
        if(this.getLimpeza() == this.getEnergiaMax()){
            System.out.println("fail: ele está limpo");
            return;
        }
        this.setLimpeza(this.limpeza + 2);
    }

    private boolean isAlive;
    private int energia;
    private int saciedade;
    private int limpeza;
    private int energiaMax;
    private int saciedadeMax;
    private int limpezaMax;
    private int idade;

    public int getEnergiaMax() {
        return energiaMax;
    }

    public int getSaciedadeMax() {
        return saciedadeMax;
    }

    public int getLimpezaMax() {
        return limpezaMax;
    }

    public int getIdade() {
        return idade;
    }

    public int getDiamantes() {
        return diamantes;
    }

    private int diamantes;

    public Pet(String nome, int energia, int saciedade, int limpeza){
        this.nome = nome;
        this.energia = energia;
        this.energiaMax = energia;
        this.limpeza = limpeza;
        this.limpezaMax = limpeza;
        this.saciedade = saciedade;
        this.saciedadeMax = saciedade;
        this.idade = 0;
        this.diamantes = 0;
        this.isAlive = true;
    }

    public String toString() {
        return "[" + this.nome + "] " +
                "E: " + this.energia + "/" + this.energiaMax + " " +
                "S: " + this.saciedade + "/" + this.saciedadeMax + " " +
                "L: " + this.limpeza + "/" + this.limpezaMax + " " +
                "I: " + this.idade + " D:" + this.diamantes;
    }
}



