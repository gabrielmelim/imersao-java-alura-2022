import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class AppLocal {

    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar as Imagens da NASA
        String url = "https://alura-linguagens-api-melim.herokuapp.com/linguagens"; // API MELIM
        var http = new ClienteHttp();
        String json = http.buscaDados(url);


        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeConteudos = parser.parse(json);

        // exibir e manipular os dados
        ExtratorDeConteudo extrator = new ExtratorDeConteudoLocal();
        List<Conteudo> conteudos = extrator.extraiConteudo(json);


        // buscar conteudo dentro do laço
        var geradora = new GeradoraDeFigurinhasLocal();
        for (int i = 0; i < listaDeConteudos.size(); i++) {
            Conteudo conteudo = conteudos.get(i);
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = conteudo.getTitulo() + " ranking - " + conteudo.getInformacao() + ".png";

            int ranking = Integer.parseInt(conteudo.getInformacao());
            geradora.cria(inputStream, nomeArquivo, ranking);
            System.out.println("nome do arquivo: " + nomeArquivo);
            System.out.println();
        }
    }
}
