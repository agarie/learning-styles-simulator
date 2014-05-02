public class ObjetivoAprendizagem
{
    private Conceito conceito;
    private int nc; //6 niveis cognitivos, de 0 a 5

    ObjetivoAprendizagem(Conceito c, int nc){
        this.conceito = c;
        setNC(nc);
    }

    public void setNC (int nc){
        if ((nc >= 0) && (nc <=5))
            this.nc = nc;
        else
            this.nc = -1;
    }

    public int getNC(){
        return nc;
    }

    public Conceito getConceito(){
        return this.conceito;
    }

    public String toString() {
        Conceito c = this.getConceito();
        return c.getId() + " - " + c.getNome() + "\n" + this.getNC();
    }
}
