

public class ModuloPedagogico
{
    //recebe os EA armazenados no ME e 
    //infere a CEA atraves de cadeias de markov
    public static CEA gerarCEA(EstiloAprendizagem EA)
    {
        double x;
        CEA cea = new CEA();
        for (int i = 0; i < 4; i++){
            x = Math.random();
            if ( (EA.get()[i][0] - x) >= 0)
                cea.get()[i] = 0;
            else
                cea.get()[i] = 1;        
        }
        return cea;
    }       
//================================================
    public static CEA gerarCEA(EstiloAprendizagem EA, int z)
    {
        //faz roleta so' no elemento determinado por z
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
