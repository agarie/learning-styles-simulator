public class Conceito
{
    private int id;
    private String nome;

    Conceito (int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public int getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }
}
