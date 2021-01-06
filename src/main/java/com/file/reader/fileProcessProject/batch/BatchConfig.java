package com.file.reader.fileProcessProject.batch;

import com.file.reader.fileProcessProject.service.FileProcessAndWriterService;
import com.file.reader.fileProcessProject.service.FileReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classe responsavel por centralizar configurações e chamadas dos steps e jobs
 *
 * @author patriciaramos1995
 * date: 03/01/2021 15:30
 */

@Configuration
@RequiredArgsConstructor
public class BatchConfig {

    @Value("${file.path.input}")
    public String pathInput;

    @Value("${file.path.output}")
    public String pathOutput;

    private final FileReaderService fileReaderService;
    private final FileProcessAndWriterService fileProcessAndWriterService;
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step stepReader() {
        return this.stepBuilderFactory.get("Leitura dos arquivos em: " + this.pathInput).tasklet(new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                BatchConfig.this.fileReaderService.readFiles(BatchConfig.this.pathInput);
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    @Bean
    public Step stepProcessAndWrite() {
        return this.stepBuilderFactory.get("Processamento dos dados e gravação do arquivo final em: " + this.pathOutput)
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
                            throws Exception {
                        BatchConfig.this.fileProcessAndWriterService.processAndWriteFiles(BatchConfig.this.pathOutput);
                        return RepeatStatus.FINISHED;
                    }
                }).build();
    }

    @Bean
    public Job job() {

        return this.jobBuilderFactory.get("Leitura de arquivos em lotes")
                .start(this.stepReader())
                .next(this.stepProcessAndWrite())
                .build();
    }
}
