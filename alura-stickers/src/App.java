import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes
        //String url = "https://imdb-api.com/en/API/Top250Movies/k_0ojt0yvm";
        String url = "https://alura-imdb-api.herokuapp.com/movies";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular os dados 
        var geradora = new GeradoraDeFigurinhas();
        for (Map<String,String> filme : listaDeFilmes) {

            String urlImagem = filme.get("image");
            String titulo = filme.get("title");
            String nota = filme.get("imDbRating");
            titulo = titulo.replace(":","");


            // localizando o @ da imagem, e deixando somente o @.jpg para trazer img original
            var localizarUltimoPonto = urlImagem.lastIndexOf(".");
            var tratativa = urlImagem.substring(0,localizarUltimoPonto);
            localizarUltimoPonto = tratativa.lastIndexOf(".");
            var imagemAltaResolucao = tratativa.substring(0,localizarUltimoPonto)+".jpg";


            // tratando erro de formato de imagem incompatível ou não encontrada
            try{
                InputStream inputStream = new URL(imagemAltaResolucao).openStream();
                String nomeArquivo = titulo + " ImdbNota - " +nota + ".png";
                geradora.cria(inputStream, nomeArquivo,nota);

            } catch (IOException e) {
                System.out.println("erro imagem do arquivo não encontrada ou formato inválido");
            }


            System.out.println(titulo);
            System.out.println();
        }
    }
}