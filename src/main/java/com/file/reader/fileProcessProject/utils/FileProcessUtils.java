package com.file.reader.fileProcessProject.utils;

import static com.file.reader.fileProcessProject.utils.MessagesUtils.MESSAGE_ERROR_CREATE_FILE;
import static com.file.reader.fileProcessProject.utils.MessagesUtils.MESSAGE_FOLDER_EMPTY;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.extern.log4j.Log4j2;

/**
 * Classe responsavel por manter manipulação de arquivos centralizados
 *
 * @author patriciaramos1995
 * date: 15/12/2020 17:35
 */
@Log4j2
public class FileProcessUtils {

    public static final String SELLER_TEXT = "Quantidade de vendedores: ";
    public static final String CUSTOMER_TEXT = "Quantidade de clientes: ";
    public static final String ID_SALE_TEXT = "ID da venda mais alta: ";
    public static final String BAD_SELLER_TEXT = "Nome do pior vendedor: ";

    public static void createFile(final StringBuilder text, final String pathFile, final String nameFileOutput)
            throws IOException {
        try {

            Path path = Paths.get(pathFile + nameFileOutput);
            Files.createDirectories(path.getParent());
            Files.write(path, text.toString().getBytes());

        } catch (IOException e) {
            String error = MESSAGE_ERROR_CREATE_FILE.replace("{}", e.getMessage());
            log.error(error);
            throw new IOException(error);
        }
    }

    public static File[] listFilesInFolder(final String pathFile) throws FileNotFoundException {
        final File folder = new File(pathFile);

        if (folder.listFiles() == null) {
            throw new FileNotFoundException(MESSAGE_FOLDER_EMPTY);
        }

        return folder.listFiles();
    }
}
