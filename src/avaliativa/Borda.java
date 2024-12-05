
package avaliativa;

public class Borda {
    private final String tipo;

    public Borda(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean encaixa(Borda outraBorda) {
        return (this.tipo.equals("dente") && outraBorda.getTipo().equals("vazio")) ||
               (this.tipo.equals("vazio") && outraBorda.getTipo().equals("dente"));
    }
}
