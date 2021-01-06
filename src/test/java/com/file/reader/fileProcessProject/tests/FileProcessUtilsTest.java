package com.file.reader.fileProcessProject.tests;

import static com.file.reader.fileProcessProject.config.PathFiles.FILE_NAME_OUTPUT;
import static com.file.reader.fileProcessProject.config.PathFiles.PATH_INPUT_EMPTY_FILE;
import static com.file.reader.fileProcessProject.config.PathFiles.PATH_INPUT_FOLDER_VALID;
import static com.file.reader.fileProcessProject.config.PathFiles.PATH_INPUT_NON_EXISTENT_FOLDER;
import static com.file.reader.fileProcessProject.utils.MessagesUtils.MESSAGE_FOLDER_EMPTY;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.file.reader.fileProcessProject.entity.ProcessResult;
import com.file.reader.fileProcessProject.utils.FileProcessUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Classe responsavel por agrupar os testes de unidade do utilitário
 *
 * @author patriciaramos1995
 * date: 05/01/2021 10:34
 */
@RunWith(SpringRunner.class)
public class FileProcessUtilsTest {

    @Test
    public void createFileSuccess() throws IOException {

        ProcessResult processResultDTO = ProcessResult.builder().countCustomer(1L)
                .countSeller(1L)
                .idBestSale(1L)
                .nameBadSeller("Fulano")
                .build();

        // Criação do arquivo
        FileProcessUtils.createFile(ProcessResult.getProcessResult(processResultDTO), PATH_INPUT_FOLDER_VALID,
                FILE_NAME_OUTPUT);

        // Verificação se o arquivo foi criado e exclusão do mesmo
        File fileVerify = new File(PATH_INPUT_FOLDER_VALID + FILE_NAME_OUTPUT);
        boolean existFile = fileVerify.exists();
        fileVerify.delete();

        Assertions.assertTrue(existFile);

    }

    @Test
    public void listFilesInFolderSuccess() throws FileNotFoundException {

        File[] files = FileProcessUtils.listFilesInFolder(PATH_INPUT_FOLDER_VALID);
        Assertions.assertTrue(files.length > 0);
    }

    @Test
    public void listFilesInFolderEmpty() {

        Exception exception = assertThrows(FileNotFoundException.class, () -> {
            FileProcessUtils.listFilesInFolder(PATH_INPUT_EMPTY_FILE);
        });

        Assertions.assertEquals(MESSAGE_FOLDER_EMPTY, exception.getMessage());
    }

    @Test
    public void listFilesInFolderInvalid() {

        Exception exception = assertThrows(FileNotFoundException.class, () -> {
            FileProcessUtils.listFilesInFolder(PATH_INPUT_NON_EXISTENT_FOLDER);
        });

        Assertions.assertEquals(MESSAGE_FOLDER_EMPTY, exception.getMessage());
    }

}
