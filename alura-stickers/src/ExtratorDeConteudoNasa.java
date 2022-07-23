import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoNasa implements ExtratorDeConteudo {

    public List<Conteudo> extraiConteudo(String json) {
        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        // popular a lista de conteudos
        for (Map<String, String> atributos : listaDeAtributos) {

            String urlImagem = atributos.get("url");
            String titulo = atributos.get("title");
            String informacao = atributos.get("date");
            titulo = titulo.replace(":","");
            var conteudo = new Conteudo(titulo, urlImagem, informacao);

            conteudos.add(conteudo);
        }

        return conteudos;
    }
}
