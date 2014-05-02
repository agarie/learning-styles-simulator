import java.util.ArrayList;

/**
 * Represents the knowledge about a given student.
 * <p>
 * This model uses Felder-Silverman's learning styles to represent the preferences
 * of a given student.
 */
public class StudentModel {
    // Alterado durante o processo de aprendizagem.
    private LearningStyle EA;
    final private ArrayList<LearningObjective> OA = new ArrayList<LearningObjective>();
    final private ArrayList<CognitiveState> EC = new ArrayList<CognitiveState>();

    final private double MAX_DIFFERENCE = 0.9;
    final private int TAM; // Quantidade de conceitos a serem aprendidos.
    final private double K; // Taxa de aprendizagem
    final private double limit;

    public StudentModel(LearningStyle ea, int t, double k, double lim) {
        // Usual values for (t, k, lim) = (60, 0.5, 0.05).
        this.EA = ea;
        this.TAM = t;
        this.K = k;
        this.limit = lim;
    }

    public LearningObjective getOA(int i) {
        if (i < TAM) {
            return OA.get(i);
        }
        else {
            return null;
        }
    }

    public CognitiveState getEC(int i) {
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
        // Concepts de 0 a N-1.
        return (int) Math.floor(Math.random() * TAM);
    }

    public LearningStyle getEA() {
        return this.EA;
    }

    public CognitiveState getConcept() {
        int i = (int) Math.floor(Math.random() * TAM);
        return this.EC.get(i);
    }

    public void setOA() {
        int i;
        Concept c;
        int nc = 5;   //6 niveis cognitivos: de 0 a 5
        //Synthesis: Builds a structure or pattern from diverse elements.
        //Put parts together to form a whole, with emphasis on creating a new meaning
        //or structure.
        for (i=0; i < TAM; i++) {
            c = new Concept(i, "Concept"+i);
            OA.add(new LearningObjective(c, nc));
        }
    }

    public void setEC() {
        int i;
        Concept c;
        int nc;
        for (i=0; i < TAM; i++) {
            c = new Concept(i, "Concept"+i);
            nc = -1; //"SEM CONHECIMENTO"
            EC.add(new CognitiveState(c,nc));
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
            return false;
        }
        return true;
    }

    public double calcF(double learningStylesDistance, double performance) {
        double f = 1.0 / (Math.abs(learningStylesDistance) * performance);

        // The value of `f` can't be larger than the `limit`.
        return Math.min(f, this.limit);
    }

    public void updateEA_badEval(LearningStylesCombination cea, double performance) {
        double reinforcement;
        //--distancia learning styles. quanto maior a distacia entre os estilos, menor e' o ajuste
        double DLS;

        for (int i = 0; i < 4 ; i++) {
            DLS = this.EA.get()[i][0] - this.EA.get()[i][1];
            reinforcement = K * calcF(DLS,performance);

            // Aplicando reforço -- regras para atualizacao do EA.
            // Se a LearningStylesCombination esta ativo e o desempenho foi ruim, entao ele nao e'
            // tao ativo.
            if  (cea.get()[i] == 0) {
                if ((reinforcement + this.EA.get()[i][1]) < MAX_DIFFERENCE) {
                    this.EA.set(i,this.EA.get()[i][0]-reinforcement, this.EA.get()[i][1]+reinforcement);
                }
            }

            //se a LearningStylesCombination esta' reflexivo e o desempenho foi ruim, entao ele nao e' tao reflexivo
            if  (cea.get()[i] == 1) {
                if ((reinforcement + this.EA.get()[i][0]) < MAX_DIFFERENCE) {
                    this.EA.set(i,this.EA.get()[i][0]+reinforcement, this.EA.get()[i][1]-reinforcement);
                }
            }
        }
    }

    public void updateEA_goodEval(LearningStylesCombination cea, double performance) {
        double reinforcement;
        //--distancia learning styles. quanto maior a distacia entre os estilos, menor e' o ajuste
        double DLS;

        for (int i = 0; i < 4 ; i++) {
            DLS = this.EA.get()[i][0] - this.EA.get()[i][1];
            reinforcement = K*calcF(DLS,performance);

            //---------APLICANDO REFORCO-----------
            //se LearningStylesCombination esta' ativo e ele teve um bom desempenho, entao realmente ele e' ativo
            if (cea.get()[i] == 0) {
                if ( (reinforcement + this.EA.get()[i][0] ) < MAX_DIFFERENCE ) {
                     this.EA.set(i,this.EA.get()[i][0]+reinforcement, this.EA.get()[i][1]-reinforcement);
               }
            }

            //se o LearningStylesCombination esta' reflexivo e ele teve um bom desempenho, entao realmente ele e' reflexivo
            if (cea.get()[i] == 1) {
                if ( (reinforcement + this.EA.get()[i][1] ) < MAX_DIFFERENCE ) {
                    this.EA.set(i,this.EA.get()[i][0]-reinforcement, this.EA.get()[i][1]+reinforcement);
                }
            }
        }
    }

    public void showEC() {
        for (CognitiveState ec : EC) {
            System.out.println(ec.toString());
        }
    }

    //compara e calcula as diferencas entre o ME e a LearningStylesCombination passada como parametro
    public int compare(LearningStylesCombination cea) {
        int diff = 0;
        for (int i = 0; i < 4; i++) {
            if ( (this.EA.get()[i][0] > this.EA.get()[i][1]) && (cea.get()[i] == 1) ) diff++;
            if ( (this.EA.get()[i][0] < this.EA.get()[i][1]) && (cea.get()[i] == 0) ) diff++;
        }
        return diff;
    }

    public boolean spNotSatisfied(LearningStylesCombination cea) {
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

    public boolean mpNotSatisfied(LearningStylesCombination cea) {
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
