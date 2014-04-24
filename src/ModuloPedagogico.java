public class ModuloPedagogico {
    // Recebe os EA armazenados no ModeloEstudante e infere a CEA atraves de
    // cadeias de markov
    public static CEA gerarCEA(EstiloAprendizagem EA)
    {
        double x;
        CEA cea = new CEA();

        // For each FSLSM dimension, randomly select if it's 0 or 1.
        for (int i = 0; i < 4; i++){
            x = Math.random();
            if ( (EA.get()[i][0] - x) >= 0) {
                cea.get()[i] = 0;
            }
            else {
                cea.get()[i] = 1;
            }
        }

        return cea;
    }

    public static CEA gerarCEA(EstiloAprendizagem EA, int z)
    {
        // Same as above, but only on dimension z.
        double x;
        CEA cea = new CEA();

        for (int i = 0; i < 4; i++){
            if (i != z){
                if (EA.get()[i][0] >= EA.get()[i][1])
                    cea.get()[i] = 0;
                else
                    cea.get()[i] = 1;
            }
            else {
                x = Math.random();
                if ( (EA.get()[i][0] - x) >= 0)
                    cea.get()[i] = 0;
                else
                    cea.get()[i] = 1;
            }
        }
        return cea;
    }
}
