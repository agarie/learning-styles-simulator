import java.util.ArrayList;

public class ModeloEstudante {
    // Alterado durante o processo de aprendizagem.
    final private EstiloAprendizagem EA;
    final private ArrayList<ObjetivoAprendizagem> OA = new ArrayList<ObjetivoAprendizagem>();
    final private ArrayList<EstadoCognitivo> EC = new ArrayList<EstadoCognitivo>();

    final private double MAXDIFF = 0.9;
    private int TAM = 60 ; // Quantidade de conceitos a serem aprendidos.
    private double K = 0.5; // Taxa de aprendizagem
    private double LIM = 0.05;

    public ObjetivoAprendizagem getOA(int i) {
        if (i < TAM) {
            return OA.get(i);
        }
        else {
            return null;
        }
    }

    public EstadoCognitivo getEC(int i) {
        if (i < TAM) {
            return EC.get(i);
        }
        else {
            return null;
        }
    }

    public void setEC(int conceptNumber,int nc) {
        EC.get(conceptNumber).setNC(nc);
    }

    public int getConceptNumber() {
        // Conceitos de 0 a N-1.
        return Utilitario.RandomInt(TAM);
    }

    public void setEA(EstiloAprendizagem ea) {
        this.EA = ea;
    }

    public EstiloAprendizagem getEA() {
        return this.EA;
    }

    public EstadoCognitivo getConcept() {
        int i = Utilitario.RandomInt(TAM);
        return this.EC.get(i);
    }

    public void setOA() {
        int i;
        Conceito c;
        int nc = 5;   //6 niveis cognitivos: de 0 a 5
        //Synthesis: Builds a structure or pattern from diverse elements.
        //Put parts together to form a whole, with emphasis on creating a new meaning
        //or structure.
        for (i=0; i < TAM; i++){
            c = new Conceito(i, "Conceito"+i);
            //nc = Utilitario.RandomInt(3)+2;
            OA.add(new ObjetivoAprendizagem(c, nc));
        }
    }

    public void setEC() {
        int i;
        Conceito c;
        int nc;
        for (i=0; i < TAM; i++){
            c = new Conceito(i, "Conceito"+i);
            nc = -1; //"SEM CONHECIMENTO"
            EC.add(new EstadoCognitivo(c,nc));
        }
    }

    public boolean OAsatisfeito() {
        int i;
        boolean resultado = true;
        for (i=0; i < TAM; i++){
            if (OA.get(i).getNC() > EC.get(i).getNC()){
                resultado = false;
                break;
            }
        }
        return resultado;
    }

    public boolean conceitoSatisfeito(int i) {
        boolean resultado = true;
        if (OA.get(i).getNC() > EC.get(i).getNC()){
            resultado = false;
        }
        return resultado;
    }

    //d1; //0 = ativo, 1 = reflexivo.
    //d2; //0 = sensitivo, 1 = intuitivo.
    //d3; //0 = visual, 1 = verbal.
    //d4; //0 = sequencial, 1 = global.
    public void setLim(double lim) {
        this.LIM = lim;
    }

    public void setTam(int tam) {
        this.TAM = tam;
    }

    public void setK(double k) {
        this.K = k;
    }

    public double calcF(double DLS, double PFM) {
        if (DLS < 0) DLS = DLS*(-1); //modudo de DLS
        double f = (1/(DLS*PFM));
        if (f > LIM) f = LIM;
        return f;
    }

    //PFM = performance
    public void updateEA_badEval(CEA cea, double PFM) {
        // CALCULO DO REFORCO.
        double R;   //reforco
        double DLS; //amortizador. --distancia learning styles. quanto maior a distacia entre os estilos, menor o ajuste

        for (int i = 0; i < 4 ; i++) {
            DLS = this.EA.get()[i][0] - this.EA.get()[i][1];
            R = K * calcF(DLS,PFM);

            // APLICANDO REFORCO.
            //regras para atualizacao do EA
            //se a CEA esta ativo e o desempenho foi ruim, entao ele nao e' tao ativo
            if  (cea.get()[i] == 0)
                if ( (R + this.EA.get()[i][1]) < MAXDIFF )
                    this.EA.set(i,this.EA.get()[i][0]-R, this.EA.get()[i][1]+R);

            //se a CEA esta' reflexivo e o desempenho foi ruim, entao ele nao e' tao reflexivo
            if  (cea.get()[i] == 1)
                if ( (R + this.EA.get()[i][0]) < MAXDIFF )
                    this.EA.set(i,this.EA.get()[i][0]+R, this.EA.get()[i][1]-R);
            /*
            //se o ME e' ativo e o CEA esta' ativo e mesmo assim o desempenho foi ruim, entao ele nao e' tao ativo
            if ( (cea.get()[i] == 0) && (this.EA.get()[i][0] >= this.EA.get()[i][1])) {
            this.EA.set(i,this.EA.get()[i][0]-f, this.EA.get()[i][1]+f);
            }

            //se o ME e' reflexivo e o CEA esta' reflexivo e mesmo assim o desempenho foi ruim, entao ele nao e' tao reflexivo
            if ( (cea.get()[i] == 1) && (this.EA.get()[i][0] <= this.EA.get()[i][1])) {
            this.EA.set(i,this.EA.get()[i][0]+f, this.EA.get()[i][1]-f);
            }

            //se o ME e' reflexivo e o CEA esta' ativo, e seu desempenho foi ruim, entao realmente ele nao e' ativo
            //reforca o reflexivo
            if ( (cea.get()[i] == 0) && (this.EA.get()[i][0] <= this.EA.get()[i][1])) {
            this.EA.set(i,this.EA.get()[i][0]-f, this.EA.get()[i][1]+f);
            }

            //se o ME e' ativo e o CEA esta' reflexivo e o desempenho foi ruim, entao realmente ele nao e' reflexivo
            //reforca o ativo
            if ( (cea.get()[i] == 1) && (this.EA.get()[i][0] >= this.EA.get()[i][1])) {
            this.EA.set(i,this.EA.get()[i][0]+f, this.EA.get()[i][1]-f);
            }
            */
        }
    }

    public void updateEA_goodEval(CEA cea, double PFM){
        //---------CALCULO DO REFORCO-----------
        double R;   //Reforco
        double DLS; //--distancia learning styles. quanto maior a distacia entre os estilos, menor e' o ajuste

        for (int i = 0; i < 4 ; i++){
            DLS = this.EA.get()[i][0] - this.EA.get()[i][1];
            R = K*calcF(DLS,PFM);

            //---------APLICANDO REFORCO-----------
            //se CEA esta' ativo e ele teve um bom desempenho, entao realmente ele e' ativo
            if (cea.get()[i] == 0)
                if ( (R + this.EA.get()[i][0] ) < MAXDIFF )
                    this.EA.set(i,this.EA.get()[i][0]+R, this.EA.get()[i][1]-R);

            //se o CEA esta' reflexivo e ele teve um bom desempenho, entao realmente ele e' reflexivo
            if (cea.get()[i] == 1)
                if ( (R + this.EA.get()[i][1] ) < MAXDIFF )
                    this.EA.set(i,this.EA.get()[i][0]-R, this.EA.get()[i][1]+R);
            /*
            //se o ME e' ativo e o CEA esta' ativo e ele teve um bom desempenho, entao realmente ele e' ativo
            if ( (cea.get()[i] == 0) && (this.EA.get()[i][0] >= this.EA.get()[i][1]))
            if ( (this.EA.get()[i][0] - this.EA.get()[i][1]) < MAXDIFF )
            this.EA.set(i,this.EA.get()[i][0]+f, this.EA.get()[i][1]-f);

            //se o ME e' reflexivo e o CEA esta' reflexivo e ele teve um bom desempenho, entao realmente ele e' reflexivo
            if ( (cea.get()[i] == 1) && (this.EA.get()[i][0] <= this.EA.get()[i][1]))
            if ( (this.EA.get()[i][1] - this.EA.get()[i][0]) < MAXDIFF )
            this.EA.set(i,this.EA.get()[i][0]-f, this.EA.get()[i][1]+f);

            //se o ME e' reflexivo e o CEA esta' ativo, e ele teve um bom desempenho, entao  ele e' mais ativo do que parece
            if ( (cea.get()[i] == 0) && (this.EA.get()[i][0] <= this.EA.get()[i][1]))
            this.EA.set(i, this.EA.get()[i][0]+f, this.EA.get()[i][1]-f);

            //se o ME e' ativo e o CEA esta' reflexivo e ele teve um bom desempenho, entao ele e' mais reflexivo do que aparenta
            if ( (cea.get()[i] == 1) && (this.EA.get()[i][0] >= this.EA.get()[i][1]))
            this.EA.set(i, this.EA.get()[i][0]-f, this.EA.get()[i][1]+f);
            */

        }
    }

    public void showEC(){
        for (EstadoCognitivo ec : EC){
            System.out.println(ec.getConceito().getId()+" - "+ec.getConceito().getNome());
            System.out.println(ec.getNC());
        }
    }

    //compara e calcula as diferencas entre o ME e a CEA passada como parametro
    public int compare(CEA cea) {
        int diff = 0;
        for (int i = 0; i < 4; i++){
            if ( (this.EA.get()[i][0] > this.EA.get()[i][1]) && (cea.get()[i] == 1) ) diff++;
            if ( (this.EA.get()[i][0] < this.EA.get()[i][1]) && (cea.get()[i] == 0) ) diff++;
        }
        return diff;
    }

    public boolean spNotSatisfied(CEA cea) {
        boolean result = false;
        for (int i = 0; i < 4; i++){
            if ( (this.EA.get()[i][0] > this.EA.get()[i][1]) && (cea.get()[i] == 1) && (cea.getSt()[i] == 'F') ) {result = true; break;};
            if ( (this.EA.get()[i][0] < this.EA.get()[i][1]) && (cea.get()[i] == 0) && (cea.getSt()[i] == 'F') ) {result = true; break;};
        }
        return result;
    }

    public boolean mpNotSatisfied(CEA cea) {
        boolean result = false;
        for (int i = 0; i < 4; i++){
            if ( (this.EA.get()[i][0] > this.EA.get()[i][1]) && (cea.get()[i] == 1) && (cea.getSt()[i] == 'M') ) {result = true; break;};
            if ( (this.EA.get()[i][0] < this.EA.get()[i][1]) && (cea.get()[i] == 0) && (cea.getSt()[i] == 'M') ) {result = true; break;};
        }
        return result;
    }
}
