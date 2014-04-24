import gui.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;  
import org.jfree.data.xy.XYSeries;

public class ProcessoAprendizagem{
//==================================================================
    /*tx = taxa de aprendizagem
     * m = pfm minimo para inferencia de problemas de aprendizagem
     * lim = limite do reforço
     * c = quantidade de conceitos a serem aprendidos
     */
    public static void executar(CEA cea_r, ModeloEstudante ME, double m, String arquivo, byte idioma, byte abordagem)        
    {        
          
        // LSC={(S,Vi,A,Seq), (S,Vi,A,G), (S,Vi,R,Seq), (S,Vi,R,G), (S,Ve,A,Seq), (S,Ve,A,G),
        //     (S,Ve,R,Seq), (S,Ve,R,G),(I,Vi,A,Seq), (I,Vi,A,G), (I,Vi,R,Seq), (I,Vi,R,G), (I,Ve,A,Seq),
        //     (I,Ve,A,G), (I,Ve,R,Seq), (I,Ve,R,G)}.        
        if (abordagem == 1)
            ModuloPedagogicoAG.initLSC(); //inicializa populacao
              
        CEA cea;    //cea selecionado estocasticament
       
//=====================================================================
//EXPERIMENTOS
//SRLS = \{reflective (strong), sensitive (strong), visual (moderate), global (weak) \} 
//cea real do estudante. dita o comportamento do estudante frente ao processo de avaliacao, o que tem impacto na atualizacao do EA
//cea_r.set(0,0,0,0); //Experimento 1
//cea_r.set(1,0,0,0); //Experimento 2
//cea_r.set(0,1,0,0); //Experimento 3
//cea_r.set(0,0,1,0); //Experimento 4
//cea_r.set(0,0,0,1); //Experimento 5
//cea_r.set(1,1,0,0); //Experimento 6
//cea_r.set(0,1,1,0); //Experimento 7
//cea_r.set(0,0,1,1); //Experimento 8
//cea_r.set(1,0,1,0); //Experimento 9
//cea_r.set(1,0,0,1); //Experimento 10
//cea_r.set(0,1,0,1); //Experimento 11
//cea_r.set(1,1,1,0); //Experimento 12
//cea_r.set(0,1,1,1); //Experimento 13
//cea_r.set(1,1,0,1); //Experimento 14
//cea_r.set(1,0,1,1); //Experimento 15
//cea_r.set(1,1,1,1); //Experimento 16
        
//===============================================================================
        
        
        //enquanto o objetivo de aprendizagem nao estiver satisfeito
        //Scanner s = new Scanner(System.in);
        int contPass= 0;
        int contAtualiz = 0;
        System.out.println("Processo em andamento..: ");      

        XYSeries series1;
        XYSeries series2;
        XYSeries series3;
        XYSeries series4;
        XYSeries series5;
        XYSeries series6;
        XYSeries series7;
        XYSeries series8;

        XYSeries performance;
        XYSeries average;
        XYSeries popFitness;
        XYSeries learningProblems;
        
    if (idioma == 0){
        //legendas em portugues
         series1 = new XYSeries("Ativo");
         series2 = new XYSeries("Reflexivo");        
         series3 = new XYSeries("Sensitivo");                
         series4 = new XYSeries("Intuitivo");                
         series5 = new XYSeries("Visual");                
         series6 = new XYSeries("Verbal");                
         series7 = new XYSeries("Sequencial");                
         series8 = new XYSeries("Global");                

         performance = new XYSeries("Performances");    
         average = new XYSeries("Performance Média");          
         popFitness = new XYSeries("Fitness da População");
         learningProblems = new XYSeries("Problemas de Aprendizagem");
    }
    else{
       
        //legendas em ingles
         series1 = new XYSeries("Active");
         series2 = new XYSeries("Reflective");    
        
         series3 = new XYSeries("Sensitive");                
         series4 = new XYSeries("Intuitive");                
        
         series5 = new XYSeries("Visual");                
         series6 = new XYSeries("Verbal");                
        
         series7 = new XYSeries("Sequential");                
         series8 = new XYSeries("Global");                

         performance = new XYSeries("Performance");    
         average = new XYSeries("Average");          
         popFitness = new XYSeries("Population Fitness");
         learningProblems = new XYSeries("Learning Problems");
    }   
        double PFM;
        int count = 0;
        double sum = 0;
        double media;
        int lpCount = 0; //contador de learning problems
        long start = System.currentTimeMillis();  

        series1.add(contPass, ME.getEA().get()[0][0]*100);
        series2.add(contPass, ME.getEA().get()[0][1]*100);                
        series3.add(contPass, ME.getEA().get()[1][0]*100);
        series4.add(contPass, ME.getEA().get()[1][1]*100);
        series5.add(contPass, ME.getEA().get()[2][0]*100);                
        series6.add(contPass, ME.getEA().get()[2][1]*100);                
        series7.add(contPass, ME.getEA().get()[3][0]*100);                
        series8.add(contPass, ME.getEA().get()[3][1]*100);    
        
        while (!(ME.OAsatisfeito()))
        {   
            //limitar quantidade de iteracoes para fins experimentais 
            //if (count == 10) break;
                
            //apresentar ME
            //ME.getEA().show();
            
            //selecionar conceito a ser aprendido
            int conceptNumber = ME.getConceptNumber();
            
            if ( ! ME.conceitoSatisfeito(conceptNumber))
            {

                //===================               

                if (abordagem == 1){ //AG
                  ModuloPedagogicoAG.calcFT(ME.getEA());
                  ModuloPedagogicoAG.calcPD();
                  ModuloPedagogicoAG.calcAC();         
                  cea = ModuloPedagogicoAG.getlsc()[ModuloPedagogicoAG.roulette()]; 
                }
                else { //MARKOV
                    cea =  ModuloPedagogico.gerarCEA(ME.getEA()); //CMK
                }
                
                //Apresentando CEA
                //cea.show();
                
                int nc = ME.getEC(conceptNumber).getNC();
                //System.out.println("Estudando conceito...Avaliando conceito...");
                
                //SIMULAÇÃO DO ESTUDANTE - Calculo da performance pelo modulo de avaliacao
                //=========================                 
                PFM = ModuloAvaliacao.avaliar(cea, cea_r);              
                
                //Apresentar resultado de performance
                System.out.println("Performance: "+PFM);
                
                if (PFM < m)
                {
                     ME.updateEA_badEval(cea,PFM);
                     contAtualiz++; //quantidade de vezes que o EA sofre alteracao
                     lpCount++; 
                }    
                else 
                {
                     nc++;
                     //ME.updateEA_goodEval(cea,PFM);
                }            
                
                //salvar novo nivel cognitivo neste conceito
                //System.out.println("Atualizando EC...");
                ME.setEC(conceptNumber,nc);
                //ME.showEC();
                //ME.getEA().show();
                contPass++; //contador de passos do processo de aprendizagem
                series1.add(contPass, ME.getEA().get()[0][0]*100);
                series2.add(contPass, ME.getEA().get()[0][1]*100);                
                series3.add(contPass, ME.getEA().get()[1][0]*100);
                series4.add(contPass, ME.getEA().get()[1][1]*100);
                series5.add(contPass, ME.getEA().get()[2][0]*100);                
                series6.add(contPass, ME.getEA().get()[2][1]*100);                
                series7.add(contPass, ME.getEA().get()[3][0]*100);                
                series8.add(contPass, ME.getEA().get()[3][1]*100);        
                
                if (abordagem == 1){ //usando AG
                    //crossover(0.8, 0.4); //prob. cruzamento, prob. mutacao                  
                    //crossover(0.6, 0.3); //prob. cruzamento, prob. mutacao                  
                    //sem crossover e mutacao e com populacao de 16 individuos tem-se o mesmo 
                    //processo expresso pela abordagem baseada em cadeias de markov.
                    ModuloPedagogicoAG.crossover(0.2, 0.1); //prob. cruzamento, prob. mutacao                
                }
                
                
                sum = sum + PFM;
                count++;
                if (count == 20){  //média de 20
                    media = sum / count;
                    average.add(contPass, media);
                    learningProblems.add(contPass, lpCount);
                    lpCount = 0;
                    sum = 0;
                    count = 0;
                    
                    if (abordagem == 1) //usando AG
                        popFitness.add(contPass, ModuloPedagogicoAG.sumFitness());
                }
                
                if ( (contPass % 3) == 0)   //de 5 em 5              
                   performance.add(contPass, PFM);          
                                
            } //if            
        }//while
        long delay = System.currentTimeMillis() - start;   
        
//        ME.showEC();
        ME.getEA().show();        
        showDiff(ME.getEA());
        showResult(ME.getEA());
        cea_r.show(); //CEA real do estudante

        System.out.println("Quantidade de PASSOS:  "+contPass);
        System.out.println("Quantidade de ATUALIZ.:"+contAtualiz);              

        System.out.println("TEMPO(ms): " + delay );            
        
        //gerar grafico    
        String labelX;
        String labelY;

        if (idioma ==0){
           labelX = "Iterações do processo de aprendizagem";
           labelY = "EA probabilísticos no ME (x 100)";
        }
        else {
            labelX = "Iteration of the simulated learning process";
            labelY = "LS in the SM (x 100)";
        }

        Grafico.gerar("Dimensão Processamento",  arquivo+"d1.jpg",series1, series2, labelX, labelY);        
        Grafico.gerar("Dimensão Processamento", arquivo+"d1.jpg",series1, series2, labelX, labelY);        
        Grafico.gerar("Dimensão Percepção", arquivo+"d2.jpg",series3, series4, labelX, labelY);
        Grafico.gerar("Dimensão Entrada", arquivo+"d3.jpg",series5, series6, labelX, labelY);
        Grafico.gerar("Dimensão Organização", arquivo+"d4.jpg",series7, series8, labelX, labelY);         
                
        XYSeries nulo = new XYSeries("");

        if (idioma == 0)
            labelY = "Performance Média";                
        else
            labelY = "Average Performance";


        Grafico.gerar(labelY, arquivo+"avgPerformance.jpg", average,null, labelX, labelY );   
        
        if (idioma == 0)
            labelY = "Problemas de Aprendizagem";        
        else
            labelY = "Learning Problems";
        
        Grafico.gerar(labelY, arquivo+"learningProblems.jpg", learningProblems,null, labelX, labelY );           

        
        if (abordagem == 1) { //usando AG
            if (idioma == 0)
                labelY = "Fitness da População";        
            else
                labelY = "Population Fitness";
        
            Grafico.gerar(labelY, arquivo+"popFitness.jpg", popFitness, null, labelX, labelY );           
        }    
        
        
        //grafico de pontos de performances medias do estudante 
        GraficoPerformance.gerar("",arquivo+"performance.jpg", performance);
    }    
    

    private static void showDiff(EstiloAprendizagem EA){
        System.out.println( (EA.get()[0][0] - EA.get()[0][1]) );
        System.out.println( (EA.get()[1][0] - EA.get()[1][1]) );
        System.out.println( (EA.get()[2][0] - EA.get()[2][1]) );
        System.out.println( (EA.get()[3][0] - EA.get()[3][1]) );    

    }    
    
    private static void showResult(EstiloAprendizagem EA){
        DecimalFormat aproximador = new DecimalFormat("0.0");  
        System.out.println("{("+aproximador.format(EA.get()[0][0])+";"+aproximador.format(EA.get()[0][1])+"); ("+
            aproximador.format(EA.get()[1][0])+";"+aproximador.format(EA.get()[1][1])+"); ("+
            aproximador.format(EA.get()[2][0])+";"+aproximador.format(EA.get()[2][1])+"); ("+
            aproximador.format(EA.get()[3][0])+";"+aproximador.format(EA.get()[3][1])+")}");
    }    
}
