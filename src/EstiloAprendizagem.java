
public class EstiloAprendizagem
{
  private double[][] d = new double[4][2]; //posicao 0=ativo / 1=reflexivo
       
 public double[][] get(){
     return d;
 }
     
 
 public void set(int e, double e0, double e1 ){
     //l variando de 0 a 3
     this.d[e][0] = e0;
     this.d[e][1] = e1;     
 }

    public void show(){
        System.out.println("Ativo: "+this.d[0][0]);    
        System.out.println("Reflexivo: "+this.d[0][1]);            
        System.out.println("Sensitivo: "+this.d[1][0]);    
        System.out.println("Intuitivo: "+this.d[1][1]);            
        System.out.println("Visual: "+this.d[2][0]);    
        System.out.println("Verbal: "+this.d[2][1]);            
        System.out.println("Sequencial: "+this.d[3][0]);    
        System.out.println("Global: "+this.d[3][1]);                       
        System.out.println("----------------------------");        
    }
 
}

