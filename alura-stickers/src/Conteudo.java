public class Conteudo {

    private final String titulo;
    private final String urlImagem;
    private final String informacao;

    public Conteudo(String titulo, String urlImagem, String informacao) {
        this.titulo = titulo;
        this.urlImagem = urlImagem;
        this.informacao = informacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public String getInformacao() {
        return informacao;
    }
}
