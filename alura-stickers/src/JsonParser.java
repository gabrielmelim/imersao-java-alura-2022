import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParser {

    //private static final Pattern REGEX_ITEMS = Pattern.compile(".*\\[(.+)\\].*");
    private static final Pattern REGEX_ITEMS = Pattern.compile("(\\[\\{.*}])");
    //private static final Pattern REGEX_ATRIBUTOS_JSON = Pattern.compile("\"(.+?)\":\"(.*?)\"");
    private static final Pattern REGEX_ATRIBUTOS_JSON = Pattern.compile("\"([^\"]+)\":[\"]*([^,^\\}^\"]+)");

    public List<Map<String, String>> parse(String json) {
        //Injetar valor json
        //json = "[{'title':'Java','image':'https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_256x256.png','ranking':'1'},{'title':'Php','image':'https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/php/php_256x256.png','ranking':'2'}]";
        Matcher matcher = REGEX_ITEMS.matcher(json);
        if (!matcher.find()) {

            throw new IllegalArgumentException("Não encontrou items.");
        }

        String[] items = matcher.group(1).split("\\},\\{");

        List<Map<String, String>> dados = new ArrayList<>();

        for (String item : items) {

            //Injetar valor
            //item = "{'title':'Java','image':'https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_256x256.png','ranking':'1'";
            Map<String, String> atributosItem = new HashMap<>();

            Matcher matcherAtributosJson = REGEX_ATRIBUTOS_JSON.matcher(item);
            while (matcherAtributosJson.find()) {
                String atributo = matcherAtributosJson.group(1);
                String valor = matcherAtributosJson.group(2);
                atributosItem.put(atributo, valor);
            }

            dados.add(atributosItem);
        }

        return dados;
    }

}