package lf.ontopsolutions.barcode.resources;

import lf.ontopsolutions.barcode.services.BarcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class BarcodeResource {

    @Autowired
    private BarcodeService barcodeService;


    @PostMapping(path = "/barcode/v1/read",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void readBarcodeImageFileCamel(MultipartFile file){
        barcodeService.processImageBarcodeCamel(file);
    }

    @PostMapping(path = "/barcode/v2/read",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void readBarcodeImageFileAccusoft(MultipartFile file){
        barcodeService.processImageBarcodeAccusoft(file);
    }

}
