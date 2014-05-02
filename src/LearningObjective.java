public class LearningObjective
{
    private Concept concept;
    private int nc; //6 niveis cognitivos, de 0 a 5

    LearningObjective(Concept c, int nc){
        this.concept = c;
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

    public String toString() {
        Concept c = this.concept;
        return c.getId() + " - " + c.getNome() + "\n" + this.getNC();
    }
}
