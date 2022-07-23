import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoImdb  implements ExtratorDeConteudo{

    public List<Conteudo> extraiConteudo(String json)   {
        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        // popular a lista de conteudos

        for (Map<String, String> atributos : listaDeAtributos) {

            String urlImagem = atributos.get("image");
            String titulo = atributos.get("title");
            String nota = atributos.get("imDbRating");
            titulo = titulo.replace(":","");
            var conteudo = new Conteudo(titulo, urlImagem, nota);

            // localizando o @ da imagem, e deixando somente o @.jpg para trazer img original
            var localizarUltimoPonto = urlImagem.lastIndexOf(".");
            var tratativa = urlImagem.substring(0, localizarUltimoPonto);
            localizarUltimoPonto = tratativa.lastIndexOf(".");
            var imagemAltaResolucao = tratativa.substring(0, localizarUltimoPonto) + ".jpg";

            // tratando erro de formato de imagem incompatível ou não encontrada
            try {
                InputStream inputStream = new URL(imagemAltaResolucao).openStream();
                String nomeArquivo = titulo +".png";
            } catch (IOException e) {
                System.out.println("erro imagem do arquivo nao encontrada ou formato invalido");
            }

            conteudos.add(conteudo);
        }

        return conteudos;
    }

}
