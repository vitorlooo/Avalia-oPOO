
package avaliativa;

public class QuebraCabeca {
    private final Peca[][] tabuleiro;
    private final int linhas;
    private final int colunas;

    public QuebraCabeca(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.tabuleiro = new Peca[linhas][colunas];
    }

    public boolean encaixarPeca(Peca peca, int linha, int coluna) {
        if (linha < 0 || linha >= linhas || coluna < 0 || coluna >= colunas) {
            System.out.println("Posição fora dos limites do tabuleiro.");
            return false;
        }

        if (linha > 0 && tabuleiro[linha - 1][coluna] != null) {
            if (!tabuleiro[linha - 1][coluna].getBaixo().encaixa(peca.getTopo())) {
                System.out.println("Não é possível encaixar a peça no topo.");
                return false;
            }
        }

        if (coluna > 0 && tabuleiro[linha][coluna - 1] != null) {
            if (!tabuleiro[linha][coluna - 1].getDireita().encaixa(peca.getEsquerda())) {
                System.out.println("Não é possível encaixar a peça à esquerda.");
                return false;
            }
        }

        tabuleiro[linha][coluna] = peca;
        return true;
    }

    public void mostrarTabuleiro() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (tabuleiro[i][j] == null) {
                    System.out.print(" . ");
                } else {
                    System.out.print(" P ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Borda dente = new Borda("dente");
        Borda vazio = new Borda("vazio");

        Peca peca1 = new Peca(dente, dente, vazio, vazio);
        Peca peca2 = new Peca(vazio, dente, dente, vazio);
        Peca peca3 = new Peca(vazio, vazio, dente, dente);
        Peca peca4 = new Peca(dente, vazio, vazio, dente);

        System.out.println("Quebra-cabeça 2x2:");
        QuebraCabeca qc2x2 = new QuebraCabeca(2, 2);
        qc2x2.encaixarPeca(peca1, 0, 0);
        qc2x2.encaixarPeca(peca2, 1, 0);
        qc2x2.encaixarPeca(peca3, 0, 1);
        qc2x2.encaixarPeca(peca4, 1, 1);
        qc2x2.mostrarTabuleiro();

        System.out.println("Quebra-cabeça 4x4:");
        QuebraCabeca qc4x4 = new QuebraCabeca(4, 4);
        qc4x4.encaixarPeca(peca1, 0, 0);
        qc4x4.encaixarPeca(peca2, 1, 0);
        qc4x4.encaixarPeca(peca3, 0, 1);
        qc4x4.encaixarPeca(peca4, 1, 1);
        qc4x4.mostrarTabuleiro();
    }
}
