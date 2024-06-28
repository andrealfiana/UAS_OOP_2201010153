package pertemuan11;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author IKadekAndreAlfiana_2201010153
 * TGL: 2024-06-27
 */
public class loadIMG {
    
    public static BufferedImage loadImage(String img){
        BufferedImage bimg = null;
        try{
            bimg = ImageIO.read(new File(img));
        }catch(IOException e){
        }
        return bimg;
    }
    
}
