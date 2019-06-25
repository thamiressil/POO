package agiota;

class Transacao{
    int id;
    float value;
    String clientId;

    public Transacao(int id, float value, String clientId) {
        this.id = id;
        this.value = value;
        this.clientId = clientId;
    }

    public String toString(){
        return "" + id + ":" + value + ":" + clientId;
    }
}
