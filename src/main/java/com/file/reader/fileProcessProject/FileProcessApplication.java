package com.file.reader.fileProcessProject;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@EnableBatchProcessing
@SpringBootApplication
@RequiredArgsConstructor
public class FileProcessApplication implements ApplicationContextAware {

    public static ApplicationContext context;

    @Override
    public void setApplicationContext(final ApplicationContext context) {
        FileProcessApplication.context = context;
    }

    public static void main(String[] args) {
        SpringApplication.run(FileProcessApplication.class, args);
    }
}
