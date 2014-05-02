import java.util.ArrayList;

/**
 * Represents the knowledge about a given student.
 * <p>
 * This model uses Felder-Silverman's learning styles to represent the preferences
 * of a given student.
 */
public class ModeloEstudante {
    // Alterado durante o processo de aprendizagem.
    private EstiloAprendizagem EA;
    final private ArrayList<ObjetivoAprendizagem> OA = new ArrayList<ObjetivoAprendizagem>();
    final private ArrayList<EstadoCognitivo> EC = new ArrayList<EstadoCognitivo>();

    final private double MAX_DIFFERENCE = 0.9;
    final private int TAM; // Quantidade de conceitos a serem aprendidos.
    final private double K; // Taxa de aprendizagem
    final private double limit;

    public ModeloEstudante(EstiloAprendizagem ea, int t, double k, double lim) {
        // Usual values for (t, k, lim) = (60, 0.5, 0.05).
        this.EA = ea;
        this.TAM = t;
        this.K = k;
        this.limit = lim;
    }

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
        for (i=0; i < TAM; i++) {
            c = new Conceito(i, "Conceito"+i);
            OA.add(new ObjetivoAprendizagem(c, nc));
        }
    }

    public void setEC() {
        int i;
        Conceito c;
        int nc;
        for (i=0; i < TAM; i++) {
            c = new Conceito(i, "Conceito"+i);
            nc = -1; //"SEM CONHECIMENTO"
            EC.add(new EstadoCognitivo(c,nc));
        }
    }

    public boolean OAsatisfeito() {
        int i;
        boolean resultado = true;
        for (i=0; i < TAM; i++) {
            if (OA.get(i).getNC() > EC.get(i).getNC()) {
                resultado = false;
                break;
            }
        }
        return resultado;
    }

    /**
     * Test if the cognitive level of concept i achieved the objective.
     *
     * @param i Index of the concept.
     */
    public boolean conceitoSatisfeito(int i) {
        if (OA.get(i).getNC() > EC.get(i).getNC()) {
            return false
        }
        return true;
    }

    public double calcF(double learningStylesDistance, double performance) {
        double f = 1.0 / (Math.abs(learningStylesDistance) * performance);

        // The value of `f` can't be larger than the `limit`.
        return Math.min(f, this.limit);
    }

    public void updateEA_badEval(CEA cea, double performance) {
        double reinforcement;
        //--distancia learning styles. quanto maior a distacia entre os estilos, menor e' o ajuste
        double DLS;

        for (int i = 0; i < 4 ; i++) {
            DLS = this.EA.get()[i][0] - this.EA.get()[i][1];
            reinforcement = K * calcF(DLS,performance);

            // Aplicando reforço -- regras para atualizacao do EA.
            // Se a CEA esta ativo e o desempenho foi ruim, entao ele nao e'
            // tao ativo.
            if  (cea.get()[i] == 0) {
                if ((reinforcement + this.EA.get()[i][1]) < MAX_DIFFERENCE) {
                    this.EA.set(i,this.EA.get()[i][0]-reinforcement, this.EA.get()[i][1]+reinforcement);
                }
            }

            //se a CEA esta' reflexivo e o desempenho foi ruim, entao ele nao e' tao reflexivo
            if  (cea.get()[i] == 1) {
                if ((reinforcement + this.EA.get()[i][0]) < MAX_DIFFERENCE) {
                    this.EA.set(i,this.EA.get()[i][0]+reinforcement, this.EA.get()[i][1]-reinforcement);
                }
            }
        }
    }

    public void updateEA_goodEval(CEA cea, double performance) {
        double reinforcement;
        //--distancia learning styles. quanto maior a distacia entre os estilos, menor e' o ajuste
        double DLS;

        for (int i = 0; i < 4 ; i++) {
            DLS = this.EA.get()[i][0] - this.EA.get()[i][1];
            reinforcement = K*calcF(DLS,performance);

            //---------APLICANDO REFORCO-----------
            //se CEA esta' ativo e ele teve um bom desempenho, entao realmente ele e' ativo
            if (cea.get()[i] == 0) {
                if ( (reinforcement + this.EA.get()[i][0] ) < MAX_DIFFERENCE ) {
                     this.EA.set(i,this.EA.get()[i][0]+reinforcement, this.EA.get()[i][1]-reinforcement);
               }
            }

            //se o CEA esta' reflexivo e ele teve um bom desempenho, entao realmente ele e' reflexivo
            if (cea.get()[i] == 1) {
                if ( (reinforcement + this.EA.get()[i][1] ) < MAX_DIFFERENCE ) {
                    this.EA.set(i,this.EA.get()[i][0]-reinforcement, this.EA.get()[i][1]+reinforcement);
                }
            }
        }
    }

    public void showEC() {
        for (EstadoCognitivo ec : EC) {
            System.out.println(ec.toString());
        }
    }

    //compara e calcula as diferencas entre o ME e a CEA passada como parametro
    public int compare(CEA cea) {
        int diff = 0;
        for (int i = 0; i < 4; i++) {
            if ( (this.EA.get()[i][0] > this.EA.get()[i][1]) && (cea.get()[i] == 1) ) diff++;
            if ( (this.EA.get()[i][0] < this.EA.get()[i][1]) && (cea.get()[i] == 0) ) diff++;
        }
        return diff;
    }

    public boolean spNotSatisfied(CEA cea) {
        for (int i = 0; i < 4; i++) {
            if ( (this.EA.get()[i][0] > this.EA.get()[i][1]) && (cea.get()[i] == 1) && (cea.getSt()[i] == 'F') ) {
                return true;
            }
            if ( (this.EA.get()[i][0] < this.EA.get()[i][1]) && (cea.get()[i] == 0) && (cea.getSt()[i] == 'F') ) {
                return true;
            }
        }
        return false;
    }

    public boolean mpNotSatisfied(CEA cea) {
        for (int i = 0; i < 4; i++) {
            if ( (this.EA.get()[i][0] > this.EA.get()[i][1]) && (cea.get()[i] == 1) && (cea.getSt()[i] == 'M') ) {
                return true;
            }
            if ( (this.EA.get()[i][0] < this.EA.get()[i][1]) && (cea.get()[i] == 0) && (cea.getSt()[i] == 'M') ) {
                return true;
            }
        }
        return false;
    }
}
