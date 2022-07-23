import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class AppImdb {

    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes
        //String url = "https://imdb-api.com/en/API/Top250Movies/k_0ojt0yvm"; //API IMDB TOP250 FILMES
        String url = "https://alura-imdb-api.herokuapp.com/movies"; // API IMBD TOP250 FILMES ALURA
        var http = new ClienteHttp();
        String json = http.buscaDados(url);


        // exibir e manipular os dados
        ExtratorDeConteudo extrator = new ExtratorDeConteudoImdb();
        List<Conteudo> conteudos = extrator.extraiConteudo(json);

        // buscar conteudo dentro do laço ( total 250 conteudos )
        var geradora = new GeradoraDeFigurinhasImdb();


        for (int i = 0; i < 250; i++) {
            try{
                Conteudo conteudo = conteudos.get(i);
                System.out.println(conteudos.get(i));
                InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
                String nomeArquivo = "saida/" + conteudo.getTitulo() + " nota - " + conteudo.getInformacao() + ".png";
                var nota = conteudo.getInformacao();
                geradora.cria(inputStream, nomeArquivo, nota);
                System.out.println("nome do arquivo" + nomeArquivo);
            } catch (IOException e){
                System.out.println("erro imagem do arquivo nao encontrada ou formato invalido");
            }

        }
    }
}
