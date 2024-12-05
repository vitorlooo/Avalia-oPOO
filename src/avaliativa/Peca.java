package avaliativa;


public class Peca {
    private final Borda topo;
    private final Borda direita;
    private final Borda baixo;
    private final Borda esquerda;

    public Peca(Borda topo, Borda direita, Borda baixo, Borda esquerda) {
        this.topo = topo;
        this.direita = direita;
        this.baixo = baixo;
        this.esquerda = esquerda;
    }

    public Borda getTopo() {
        return topo;
    }

    public Borda getDireita() {
        return direita;
    }

    public Borda getBaixo() {
        return baixo;
    }

    public Borda getEsquerda() {
        return esquerda;
    }

    public boolean encaixaCom(Peca outraPeca) {
        return this.baixo.encaixa(outraPeca.getTopo()) &&
               this.direita.encaixa(outraPeca.getEsquerda());
    }
}

