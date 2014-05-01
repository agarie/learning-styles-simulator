public class Utilitario
{
    //retorna um numero aleatorio inteiro de 0 a N-1
    public static int RandomInt(int N) {
         double r = Math.random();
         int n = (int) (r * N);
         return n;
    }
}
