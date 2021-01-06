package com.file.reader.fileProcessProject.service;

import com.file.reader.fileProcessProject.entity.ProcessResult;
import com.file.reader.fileProcessProject.utils.FileProcessUtils;
import com.file.reader.fileProcessProject.utils.MessagesUtils;
import java.io.IOException;
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
public class FileProcessAndWriterService {

    private final ProcessService processService;
    private static final String NAME_FILE_OUTPUT = "process-result.done.dat";

    public void processAndWriteFiles(final String folderOut) throws IOException {

        try {

            FileProcessUtils.createFile(ProcessResult.getProcessResult(this.processService.dataProcesss()), folderOut,
                    NAME_FILE_OUTPUT);

        } catch (IOException e) {
            String error = MessagesUtils.MESSAGE_ERROR_READ.replace("{}", e.getMessage());
            log.error(error);
            throw new IOException(error);
        }
    }
}
