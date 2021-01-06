package com.file.reader.fileProcessProject.tests;

import static com.file.reader.fileProcessProject.config.PathFiles.FILE_NAME_OUTPUT;
import static com.file.reader.fileProcessProject.config.PathFiles.PATH_OUTPUT_FOLDER;

import com.file.reader.fileProcessProject.FileProcessApplication;
import com.file.reader.fileProcessProject.entity.ProcessResult;
import com.file.reader.fileProcessProject.service.FileProcessAndWriterService;
import com.file.reader.fileProcessProject.service.ProcessService;
import java.io.File;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
 * Classe responsavel por agrupar os testes de unidade do serviço de gravação de arquivos
 *
 * @author patriciaramos1995
 * date: 05/01/2021 18:55
 */
@SpringBatchTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = FileProcessApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class })
public class FileProcessAndWriterServiceTest {

    @InjectMocks
    private FileProcessAndWriterService fileProcessAndWriterService;

    @Mock
    private ProcessService processService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createFileSuccess() throws IOException {

        ProcessResult processResultDTO = ProcessResult.builder().countCustomer(1L)
                .countSeller(1L)
                .idBestSale(1L)
                .nameBadSeller("Fulano")
                .build();

        Mockito.when(this.processService.dataProcesss()).thenReturn(processResultDTO);

        this.fileProcessAndWriterService.processAndWriteFiles(PATH_OUTPUT_FOLDER);
        File file = new File(PATH_OUTPUT_FOLDER + FILE_NAME_OUTPUT);
        boolean fileExists = file.exists();

        file.delete();

        Assertions.assertTrue(fileExists);
    }
}
