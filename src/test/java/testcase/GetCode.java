package testcase;

import net.sourceforge.tess4j.Tesseract;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class GetCode {

    public String getValidateCode(WebDriver driver, WebElement img){
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Point p = img.getLocation();
            int width = img.getSize().getWidth();
            int height = img.getSize().getHeight();
            Dimension d = new Dimension(width,height);
            //Rectangle rect = new Rectangle(p,d);
            BufferedImage buffImg = ImageIO.read(srcFile);
            BufferedImage dest = buffImg.getSubimage(p.x,p.y,d.width,d.height);
            ImageIO.write(dest,"png",srcFile);
            File validateCodeImage = new File("./src/test/resources/validateCodeImage.png");
            if(validateCodeImage.exists()){
                validateCodeImage.delete();
            }
            FileUtils.copyFile(srcFile,validateCodeImage);

            Tesseract instance = new Tesseract();
            instance.setDatapath("./src/test/resources/tessdata");
            //instance.setLanguage("eng");
            String result = instance.doOCR(validateCodeImage);
            System.out.println("识别的验证码为======" + result);
            return result;

        }catch (Exception e){
            e.printStackTrace();
        }
    return "";
    }
}
