public class Evaluator {
    // cea = CEA gerada estocasticamente pelo ModuloPedagogico.
    // cea_real = preferencias reais do estudante
    public static double avaliar(CEA cea, CEA cea_real){
        //a probalidade da avaliacao ser ruim aumenta quando as diferencas entre os ceas aumentam
        //diff = difficulty factor -- varia de 0 a 5
        double diff = cea_real.compare(cea); //retorna a quantidade de diferencas entre a CEA selecionada e a CEA real do estudante
        boolean sp = cea_real.spNotSatisfied(cea); //strong preference not satisfied
        boolean mp = cea_real.mpNotSatisfied(cea); //moderate preference not satisfied
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
