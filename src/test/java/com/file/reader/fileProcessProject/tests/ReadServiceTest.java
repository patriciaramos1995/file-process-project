package com.file.reader.fileProcessProject.tests;

import static com.file.reader.fileProcessProject.config.PathFiles.PATH_INPUT_FOLDER_INVALID;
import static com.file.reader.fileProcessProject.config.PathFiles.PATH_INPUT_FOLDER_VALID;
import static com.file.reader.fileProcessProject.config.PathFiles.PATH_INPUT_NON_EXISTENT_FILE;
import static com.file.reader.fileProcessProject.config.PathFiles.PATH_INPUT_NON_EXISTENT_FOLDER;
import static com.file.reader.fileProcessProject.utils.MessagesUtils.MESSAGE_ERROR_READ;
import static com.file.reader.fileProcessProject.utils.MessagesUtils.MESSAGE_EXTENSION_INVALID_UPLOAD;
import static com.file.reader.fileProcessProject.utils.MessagesUtils.MESSAGE_TEXT_NOT_MATCH_CATEGORY;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.spy;

import com.file.reader.fileProcessProject.FileProcessApplication;
import com.file.reader.fileProcessProject.service.FileReaderService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

/**
 * Classe responsavel por agrupar os testes de unidade do serviço de leitura de arquivos
 *
 * @author patriciaramos1995
 * date: 05/01/2021 10:25
 */
@SpringBatchTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = FileProcessApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class })
public class ReadServiceTest {

    @InjectMocks
    private FileReaderService fileReaderService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void readFileSuccess() throws IOException {

        FileReaderService spyFileReaderService = spy(this.fileReaderService);
        Mockito.doNothing().when(spyFileReaderService).saveByTypeText(Mockito.anyString());
        spyFileReaderService.readFiles(PATH_INPUT_FOLDER_VALID);
    }

    @Test
    public void readFileWithTypeNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.fileReaderService.saveByTypeText("000ç1234567891234çPedroç50000");
        });

        Assertions.assertTrue(exception.getMessage().contains(MESSAGE_TEXT_NOT_MATCH_CATEGORY.replace("{}", "")));
    }

    @Test
    public void readExtensionNotAllowed() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            this.fileReaderService.readFiles(PATH_INPUT_FOLDER_INVALID);
        });

        Assertions.assertTrue(exception.getMessage().contains(MESSAGE_EXTENSION_INVALID_UPLOAD));
    }

    @Test
    public void readNonExistentFolder() {

        Exception exception = assertThrows(IOException.class, () -> {
            this.fileReaderService.readFiles(PATH_INPUT_NON_EXISTENT_FOLDER);
        });

        Assertions.assertTrue(exception.getMessage().contains(MESSAGE_ERROR_READ.replace("{}", "")));
    }

    @Test
    public void readNonExistentFile() {

        File file = new File(PATH_INPUT_NON_EXISTENT_FILE);

        Exception exception = assertThrows(FileNotFoundException.class, () -> {
            this.fileReaderService.readContentFile(file);
        });

        Assertions.assertTrue(exception.getMessage().contains(MESSAGE_ERROR_READ.replace("{}", "")));
    }
}
