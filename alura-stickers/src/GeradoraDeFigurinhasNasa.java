import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

public class GeradoraDeFigurinhasNasa {



    public void cria (InputStream inputStream, String nomeArquivo,String date) throws Exception {

        // leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria nova imagem em memória com transparência e com tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 150;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original pra novo imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 36);
        graphics.setColor(Color.GREEN);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        graphics.drawString("DATE: "+date, 110, novaAltura - 100);

        // escrever a nova imagem em um arquivo
        ImageIO.write(novaImagem, "png", new File("saida/"+nomeArquivo));

    }

}