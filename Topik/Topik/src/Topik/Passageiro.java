package Topik;

class Passageiro{
    public String id;
    public int idade;
 

    public Passageiro(String id, int idade){
        this.id = id;
        this.idade = idade;
    }
    
    @Override
    public String toString() {
        return id + ":" + idade;
    }
}