package lf.ontopsolutions.barcode.services;

import lf.ontopsolutions.barcode.util.BarcodeImageDecoderCamel;
import lf.ontopsolutions.barcode.util.BarcodeImageFileDecoderAccusoft;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class BarcodeServiceImpl implements BarcodeService {

    @Autowired
    private BarcodeImageDecoderCamel barcodeImageDecoderCamel;

    @Autowired
    private BarcodeImageFileDecoderAccusoft barcodeImageFileDecoderAccusoft;

    public void processImageBarcodeCamel(MultipartFile file){

        try {
             BarcodeImageDecoderCamel.BarcodeInfo barcodeInfo= barcodeImageDecoderCamel.decodeImage(file.getInputStream());
             log.info(barcodeInfo.toString());
        }catch (Exception e){
            log.info(e.getMessage());
        }

    }

    @Override
    public void processImageBarcodeAccusoft(MultipartFile file) {

        try {
              barcodeImageFileDecoderAccusoft.decode(file);
        }catch (Exception e){
            log.info(e.getMessage());
        }
    }
}
