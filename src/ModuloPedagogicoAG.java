public class ModuloPedagogicoAG
{
    private static final int POPSIZE = 100;
    private static double[] pd = new double[POPSIZE]; //distrib. de probabilidades
    private static double[] ft = new double[POPSIZE]; //fitness de cada individuo
    private static CEA[] lsc = new CEA[POPSIZE];      //populacao de individuos
    private static double[] ac = new double[POPSIZE]; //accumulated probabilities (roleta)

    public static CEA[] getlsc(){
        return lsc;
    }

    public static double sumFitness(){
        double sum = 0;
        for (int i = 0; i<POPSIZE; i++)
            sum = sum + ft[i];
        return sum;
    }
    //calcula fitness
    public static void calcFT(LearningStyle EA){
        for (int i=0; i <POPSIZE; i++){
            ft[i] = 1;
            for (int j = 0; j < 4 ; j++){
                ft[i] = ft[i] * (EA.get()[j][lsc[i].get()[j]]);
            }
        }
    }
    //calcula probabilidades de selecao
    //fitness individual / soma dos fitness da populacao
    public static void calcPD(){
        double sf = sumFitness();
        for (int i=0; i <POPSIZE; i++)
            pd[i] =  ft[i] / sf;

    }
    //calcula probabilidades acumuladas para roleta
    public static void calcAC(){
        ac[0] = pd[0];
        for (int i = 1; i < POPSIZE; i++){
            ac[i] = ac[i-1] + pd[i];
        }
    }

    public static int roulette(){
        double r = Math.random();
        int i;
        for (i = 0; i < POPSIZE; i++){
            if (r <= ac[i]) break;
        }
        return i;
    }

    public static void initLSC(){
        int i, j;
        double r;
        String crom;

        lsc[0]  = new CEA("0000");
        lsc[1]  = new CEA("1000");
        lsc[2]  = new CEA("0100");
        lsc[3]  = new CEA("0010");
        lsc[4]  = new CEA("0001");
        lsc[5]  = new CEA("1100");
        lsc[6]  = new CEA("0110");
        lsc[7]  = new CEA("0011");
        lsc[8]  = new CEA("1010");
        lsc[9]  = new CEA("1001");
        lsc[10] = new CEA("0101");
        lsc[11] = new CEA("1110");
        lsc[12] = new CEA("0111");
        lsc[13] = new CEA("1101");
        lsc[14] = new CEA("1011");
        lsc[15] = new CEA("1111");

        for (i = 16; i < POPSIZE; i++){
            crom = "";
            for (j = 0; j < 4; j++){
                r = Math.random();
                if (r < 0.5)
                    crom = crom + "0";
                else
                    crom = crom + "1";
            }
            lsc[i] = new CEA(crom);
        }

    }

    private static void mutation(CEA c, double mr){
        if (Math.random() <= mr) {
            int p = Utilitario.RandomInt(4); //gera um int [0..3]
            if (c.get()[p] == 1)
                c.get()[p] = 0;
            else c.get()[p] = 1;
        }
    }

    public static void crossover(double Pc, double Pm){
        double r;
        int c; //ponto de cruzamento
        int ind1, ind2;
        CEA[] lscNEW = new CEA[POPSIZE];  //nova populacao de individuos

        for (int i = 0; i < POPSIZE; i+=2)
        {
            r = Math.random();
            c = Utilitario.RandomInt(4);
            ind1 = roulette();
            ind2 = roulette();
            if ( (r <= Pc) && (c > 0) ){
                lscNEW[i] = new CEA();
                lscNEW[i+1] = new CEA();
                //copiar 1a. parte dos cromossosmos
                for (int j=0; j<c; j++){
                    lscNEW[i].set(j, lsc[ind1].get()[j]);
                    lscNEW[i+1].set(j, lsc[ind2].get()[j]);
                }
                //fazer o crossover
                for (int j=c; j<4; j++) {
                    lscNEW[i].set(j, lsc[ind2].get()[j]);
                    lscNEW[i+1].set(j, lsc[ind1].get()[j]);
                }
            }
            else {
                lscNEW[i]   = lsc[ind1];
                lscNEW[i+1] = lsc[ind2];
            }
            mutation(lscNEW[i], Pm);
            mutation(lscNEW[i+1], Pm);
        }
        lsc = lscNEW;
    }

    public static void teste(){
        initLSC();
        LearningStyle EA = new LearningStyle();
        CEA c;
        EA.set(0,0.70,0.30); //ativo-reflexivo
        EA.set(1,0.35,0.65); //sensitivo-intuitivo
        EA.set(2,0.60,0.40); //visual-verbal
        EA.set(3,0.45,0.55); //sequencial-global
        calcFT(EA);
        calcPD();
        calcAC();

        System.out.println("LSC:");
        for (int i=0; i<POPSIZE; i++)
            System.out.println(lsc[i].get()[0]+" "+lsc[i].get()[1]+" "+lsc[i].get()[2]+" "+lsc[i].get()[3]);

        System.out.println("PD:");
        for (int i=0; i <POPSIZE; i++){
            System.out.println(pd[i]);
        }

        System.out.println("AC:");
        for (int i=0; i <POPSIZE; i++){
            System.out.println(ac[i]);
        }

        System.out.println("ROLETA:");
        int r = roulette();
        System.out.println(r);
        c= lsc[r];
        c.show();
        mutation(c,1);
        c.show();
        crossover(0.5, 0.01);

        System.out.println("LSC:");
        for (int i=0; i < POPSIZE; i++)
            System.out.println(lsc[i].get()[0]+" "+lsc[i].get()[1]+" "+lsc[i].get()[2]+" "+lsc[i].get()[3]);

    }
    //=========================================================
}
