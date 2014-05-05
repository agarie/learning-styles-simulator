public class ModuloPedagogico {
    // Recebe os EA armazenados no StudentModel e infere a CEA atraves de
    // cadeias de markov
    public static LearningStylesCombination gerarCEA(LearningStyle EA)
    {
        double x;
        LearningStylesCombination lsc = new LearningStylesCombination();

        // For each FSLSM dimension, randomly select if it's 0 or 1.
        for (int i = 0; i < 4; i++){
            x = Math.random();
            if ( (EA.get()[i][0] - x) >= 0) {
                lsc.get()[i] = 0;
            }
            else {
                lsc.get()[i] = 1;
            }
        }

        return lsc;
    }

    public static LearningStylesCombination gerarCEA(LearningStyle EA, int z)
    {
        // Same as above, but only on dimension z.
        double x;
        LearningStylesCombination lsc = new LearningStylesCombination();

        for (int i = 0; i < 4; i++){
            if (i != z){
                if (EA.get()[i][0] >= EA.get()[i][1])
                    lsc.get()[i] = 0;
                else
                    lsc.get()[i] = 1;
            }
            else {
                x = Math.random();
                if ( (EA.get()[i][0] - x) >= 0)
                    lsc.get()[i] = 0;
                else
                    lsc.get()[i] = 1;
            }
        }
        return lsc;
    }
}
