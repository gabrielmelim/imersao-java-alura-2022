import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class AppNasa {

    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar as Imagens da NASA
        String url = "https://api.nasa.gov/planetary/apod?api_key=SE8gdyRy8mayLKBv5Wkin4f0lN8gbdoSd2QB6kCK"; // API NASA ALURA
        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeConteudos = parser.parse(json);

        // exibir e manipular os dados 
        ExtratorDeConteudo extrator = new ExtratorDeConteudoNasa();
        List<Conteudo> conteudos = extrator.extraiConteudo(json);


        // buscar conteudo dentro do laço ( total 250 conteudos )
        var geradora = new GeradoraDeFigurinhasNasa();
        for (int i = 0; i < listaDeConteudos.size(); i++) {
            Conteudo conteudo = conteudos.get(i);
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = conteudo.getTitulo() + " date - " + conteudo.getInformacao() + ".png";

            var date = conteudo.getInformacao();
            geradora.cria(inputStream, nomeArquivo,date);
            System.out.println("nome do arquivo" + nomeArquivo);
            System.out.println();

        }
    }
}
