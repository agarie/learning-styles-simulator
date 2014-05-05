public class Evaluator {
    // lsc = LearningStylesCombination gerada estocasticamente pelo ModuloPedagogico.
    // lsc_real = preferencias reais do estudante
    public static double avaliar(LearningStylesCombination lsc, LearningStylesCombination lsc_real){
        //a probalidade da avaliacao ser ruim aumenta quando as diferencas entre os ceas aumentam
        //diff = difficulty factor -- varia de 0 a 5
        double diff = lsc_real.compare(lsc); //retorna a quantidade de diferencas entre a CEA selecionada e a CEA real do estudante
        boolean sp = lsc_real.spNotSatisfied(lsc); //strong preference not satisfied
        boolean mp = lsc_real.mpNotSatisfied(lsc); //moderate preference not satisfied
        double beta = 0, gamma = 0;

        if (sp) {
            beta = Math.random();
        }

        diff = diff + beta;  //[0,1]

        if (mp) {
            gamma = Math.random();
        }

        if (gamma > (1-beta)) {
            gamma = 1-beta; //[0,1-beta]
        }

        diff = diff + gamma;

        if (diff == 0) {
            diff = Math.random(); //fator de dificuldade passa a ser aleatorio, ja que, na pratica, e' desconhecido
        }

        // Performance.
        return 100 - (diff * 20 * Math.random());
    }
}
