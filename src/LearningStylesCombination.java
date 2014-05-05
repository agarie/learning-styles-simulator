/**
 * Combination of Learning Styles.
 */
public class LearningStylesCombination {
    private int[] lsc = new int[4]; //0 = ativo, 1 = reflexivo.
    private char[] lscSt = new char[4]; //strength - F = forte / M = moderada / L = leve

    public LearningStylesCombination() {
        super();
    }

    public LearningStylesCombination(String lsc)
    {
        for (int i = 0; i < 4; i++) {
            this.lsc[i] = Integer.parseInt(lsc.substring(i,i+1));
        }
    }

    public void set(int d1,int d2, int d3, int d4) {
        this.lsc[0] = d1;
        this.lsc[1] = d2;
        this.lsc[2] = d3;
        this.lsc[3] = d4;
    }

    public void set(int pos, int val) {
        this.lsc[pos] = val;
    }

    public void setStrength(char s1, char s2, char s3, char s4) {
        this.lscSt[0] = s1;
        this.lscSt[1] = s2;
        this.lscSt[2] = s3;
        this.lscSt[3] = s4;
    }

    public char[] getSt() {
        return this.lscSt;
    }

    public int[] get() {
        return this.lsc;
    }

    // Strong Preference Not Satisfied lscSt: F = forte, M = moderada, L = leve
    public boolean spNotSatisfied(LearningStylesCombination lsc) {
        boolean result = false;
        for (int i = 0; i < 4; i++) {
            if ( (this.lscSt[i] == 'F') && (this.lsc[i] != lsc.get()[i])  ) {
                result = true;
                break;
            }
        }
        return result;
    }

    // Moderate Preference Not Satisfied lscSt: F = forte, M = moderada, L = leve
    public boolean mpNotSatisfied(LearningStylesCombination lsc) {
        boolean result = false;
        for (int i = 0; i < 4; i++) {
            if ( (this.lscSt[i] == 'M') && (this.lsc[i] != lsc.get()[i])  ) {
                result = true;
                break;
            }
        }
        return result;
    }

    public int compare(LearningStylesCombination lsc) {
        int diff = 0;
        for (int i = 0; i < 4; i++) {
            if (this.lsc[i] != lsc.get()[i])
                diff++;
        }
        return diff;
    }

    public void show() {
        System.out.println(this.toString());
    }

    public String toString() {
        String output = "";

        if (lsc[0] == 0) {
            output = output + "Ativo\n";
        }
        else {
            output = output + "Reflexivo\n";
        }

        if (lsc[1] == 0) {
            output = output + "Sensitivo\n";
        }
        else {
            output = output + "Intuitivo\n";
        }

        if (lsc[2] == 0) {
            output = output + "Visual\n";
        }
        else {
            output = output + "Verbal\n";
        }

        if (lsc[3] == 0) {
            output = output + "Sequencial\n";
        }
        else {
            output = output + "Global\n";
        }

        return output;
    }
}
