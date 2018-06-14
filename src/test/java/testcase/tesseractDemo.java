package testcase;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class tesseractDemo {
    public static void main(String[] args) throws TesseractException {
        File imageFile = new File("./src/test/resources/imageCode.jpeg");
        Tesseract instance = new Tesseract();
        instance.setDatapath("./src/test/resources/tessdata");
        //instance.setLanguage("eng");
        try{
            String result = instance.doOCR(imageFile);
            System.out.println(result.substring(0,4));
        }catch (TesseractException e){
            System.err.println(e.getMessage());
        }
    }
}
