public class EstiloAprendizagem
{
    private double[][] d = new double[4][2]; //posicao 0=ativo / 1=reflexivo

    public double[][] get(){
        return d;
    }

    public void set(int e, double e0, double e1 ){
        //l variando de 0 a 3
        this.d[e][0] = e0;
        this.d[e][1] = e1;
    }

    public void show() {
        System.out.println(this.toString());
        System.out.println("----------------------------");
    }

    public String toString() {
        String output = "";

        for (int i = 0; i < 4; i++) {
            output = output + this.d[i][0] + "\n";
            output = output + this.d[i][1] + "\n";
        }

        return output;
    }
}

