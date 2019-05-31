package lf.ontopsolutions.barcode.util;

import com.accusoft.barcodexpress.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Slf4j
@Component
public class BarcodeImageFileDecoderAccusoft {


    public void decode(MultipartFile file) throws IOException {

        BarcodeXpress barcodeXpress = new BarcodeXpress();
        BarcodeReader reader = barcodeXpress.getReader();
        reader.setBarcodeTypes(new BarcodeType[] { BarcodeType.PDF417,BarcodeType.ALL2D });

        readerAnalyze(reader, file);
    }

    protected void readerAnalyze(BarcodeReader reader, MultipartFile file) {

        try {
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            Result[] results = reader.analyze(bufferedImage);

            for (int i = 0; i < results.length; i++) {
                log.info("Value: {}" , results[i].getValue());
                log.info("Type:  {}" , results[i].getType());
                log.info("Confidence: {}" , results[i].getConfidence());
                log.info("Skew: {}" , results[i].getSkew());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
