package backtracking;

public class NRainhas {

    private static boolean temAtaque(int x, int y, int[][] tab){

        for (int i =0; i < tab.length; i++){
            if (tab[i][y] == 1) {
                return true;
            }
        }

        for (int j =0; j < tab.length; j++){
            if (tab[x][j] == 1) {
                return true;
            }
        }

        for (int i =0; i < tab.length; i++){
            for (int j =0; j < tab.length; j++){
                int indEsq = i + j;
                int indDir = i - j;

                if(indEsq == (x+y)){
                    if(tab[i][j] == 1){
                        return true;
                    }
                }

                if(indDir == (x - y)){
                    if(tab[i][j] == 1){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static void imprimeTabuleiro(int[][] tabuleiro) {
        System.out.println("  A B C D E F G H");
        for (int i =0; i<tabuleiro.length; i++) {
            System.out.print((i+1)+ " ");
            for (int j = 0; j < tabuleiro.length; j++) {

                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean resolveRainhas(int[][] tabuleiro, int n) {
        if(n == 0) {
            return true;
        }

        for (int i =0; i<tabuleiro.length; i++){
            for(int j = 0; j<tabuleiro.length; j++){
                if(temAtaque(i, j, tabuleiro)) {
                    continue;
                }

                tabuleiro[i][j] = 1;

                if(resolveRainhas(tabuleiro, n-1)){
                    return true;
                }
                tabuleiro[i][j] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] tabuleiro =
                {
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0},};

        int n = 8;

        boolean resultado = resolveRainhas(tabuleiro, n);

        if(resultado) {
            imprimeTabuleiro(tabuleiro);
        } else {
            System.out.println("Erro");
        }
    }
}
