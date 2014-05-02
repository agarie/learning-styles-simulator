public class CEA {
    private int[] cea = new int[4]; //0 = ativo, 1 = reflexivo.
    private char[] ceaSt = new char[4]; //strength - F = forte / M = moderada / L = leve

    public CEA() {
        super();
    }

    public CEA(String lsc)
    {
        for (int i = 0; i < 4; i++) {
            this.cea[i] = Integer.parseInt(lsc.substring(i,i+1));
        }
    }

    public void set(int d1,int d2, int d3, int d4) {
        this.cea[0] = d1;
        this.cea[1] = d2;
        this.cea[2] = d3;
        this.cea[3] = d4;
    }

    public void set(int pos, int val) {
        this.cea[pos] = val;
    }

    public void setStrength(char s1, char s2, char s3, char s4) {
        this.ceaSt[0] = s1;
        this.ceaSt[1] = s2;
        this.ceaSt[2] = s3;
        this.ceaSt[3] = s4;
    }

    public char[] getSt() {
        return this.ceaSt;
    }

    public int[] get() {
        return this.cea;
    }

    // Strong Preference Not Satisfied ceaSt: F = forte, M = moderada, L = leve
    public boolean spNotSatisfied(CEA cea) {
        boolean result = false;
        for (int i = 0; i < 4; i++) {
            if ( (this.ceaSt[i] == 'F') && (this.cea[i] != cea.get()[i])  ) {
                result = true;
                break;
            }
        }
        return result;
    }

    // Moderate Preference Not Satisfied ceaSt: F = forte, M = moderada, L = leve
    public boolean mpNotSatisfied(CEA cea) {
        boolean result = false;
        for (int i = 0; i < 4; i++) {
            if ( (this.ceaSt[i] == 'M') && (this.cea[i] != cea.get()[i])  ) {
                result = true;
                break;
            }
        }
        return result;
    }

    public int compare(CEA cea) {
        int diff = 0;
        for (int i = 0; i < 4; i++) {
            if (this.cea[i] != cea.get()[i])
                diff++;
        }
        return diff;
    }

    public void show() {
        System.out.println(this.toString());
    }

    public String toString() {
        String output = "";

        if (cea[0] == 0) {
            output = output + "Ativo\n";
        }
        else {
            output = output + "Reflexivo\n";
        }

        if (cea[1] == 0) {
            output = output + "Sensitivo\n";
        }
        else {
            output = output + "Intuitivo\n";
        }

        if (cea[2] == 0) {
            output = output + "Visual\n";
        }
        else {
            output = output + "Verbal\n";
        }

        if (cea[3] == 0) {
            output = output + "Sequencial\n";
        }
        else {
            output = output + "Global\n";
        }

        return output;
    }
}
