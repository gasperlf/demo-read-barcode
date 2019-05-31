package lf.ontopsolutions.barcode.services;

import org.springframework.web.multipart.MultipartFile;

public interface BarcodeService {

    void processImageBarcodeCamel(MultipartFile file);
    void processImageBarcodeAccusoft(MultipartFile file);
}
