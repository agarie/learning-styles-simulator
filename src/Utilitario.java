public class Utilitario
{
    //retorna um numero aleatorio inteiro de 0 a N-1
    public static int RandomInt(int N) {
         double r = Math.random();
         int n = (int) (r * N);
         return n;
    }
    public static void pause(int x){
            try {
               Thread.sleep(x);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
    }

    public static void teste(){
        System.out.println("------------------");
        for (int i = 0; i < 10; i++)
            System.out.println(Math.random());
    }
}
