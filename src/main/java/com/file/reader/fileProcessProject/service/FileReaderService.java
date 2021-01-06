package com.file.reader.fileProcessProject.service;

import static com.file.reader.fileProcessProject.utils.MessagesUtils.MESSAGE_TEXT_NOT_MATCH_CATEGORY;

import com.file.reader.fileProcessProject.entity.Customer;
import com.file.reader.fileProcessProject.entity.Sale;
import com.file.reader.fileProcessProject.entity.Seller;
import com.file.reader.fileProcessProject.service.implementation.CustomerServiceImpl;
import com.file.reader.fileProcessProject.service.implementation.SaleServiceImpl;
import com.file.reader.fileProcessProject.service.implementation.SellerServiceImpl;
import com.file.reader.fileProcessProject.utils.FileProcessUtils;
import com.file.reader.fileProcessProject.utils.MessagesUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * Classe responsavel por servir o resource que salva e processa o arquivo
 *
 * @author patriciaramos1995
 * date: 11/12/2020 20:25
 */
@Log4j2
@Service
@RequiredArgsConstructor
public class FileReaderService {

    private final SellerServiceImpl sellerServiceImpl;
    private final CustomerServiceImpl customerServiceImpl;
    private final SaleServiceImpl saleServiceImpl;
    public static final String PERMITED_EXTENSION = ".dat";
    public static final String DEMILITER_CHAR = "ç";

    public void readFiles(final String folderIn) throws IOException {

        log.info("Leitura de arquivos iniciada");

        try {

            for (File fileItem : FileProcessUtils.listFilesInFolder(folderIn)) {

                if (!Objects.requireNonNull(fileItem.getName()).contains(PERMITED_EXTENSION)) {
                    throw new IllegalArgumentException(MessagesUtils.MESSAGE_EXTENSION_INVALID_UPLOAD);
                }

                log.info("Leitura de do arquivo {}  iniciada", fileItem.getName());
                this.readContentFile(fileItem);
                log.info("Leitura de do arquivo {}  finalizada", fileItem.getName());
            }
        } catch (IOException e) {
            String error = MessagesUtils.MESSAGE_ERROR_READ.replace("{}", e.getMessage());
            log.error(error);
            throw new IOException(error);
        }

        log.info("Leitura de arquivos finalizada");

    }

    public void readContentFile(final File file) throws FileNotFoundException {

        try {

            String fileName = file.getAbsolutePath();
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                this.saveByTypeText(myReader.nextLine());
            }

            myReader.close();

        } catch (FileNotFoundException e) {
            String error = MessagesUtils.MESSAGE_ERROR_READ.replace("{}", e.getMessage());
            log.error(error);
            throw new FileNotFoundException(error);
        }
    }

    public void saveByTypeText(final String text) {
        List<String> partsText = Arrays.asList(text.split(DEMILITER_CHAR));
        String idText = partsText.get(0);

        switch (idText) {
        case "001":
            this.sellerServiceImpl.save(Seller.getSellerDTO(partsText));
            break;
        case "002":
            this.customerServiceImpl.save(Customer.getCustomerDTO(partsText));
            break;
        case "003":
            this.saleServiceImpl.save(Sale.getSaleDTO(partsText));
            break;
        default:
            throw new IllegalArgumentException(MESSAGE_TEXT_NOT_MATCH_CATEGORY.replace("{}", text));
        }
    }
}
