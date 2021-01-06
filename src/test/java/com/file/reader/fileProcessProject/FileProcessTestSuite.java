package com.file.reader.fileProcessProject;

import com.file.reader.fileProcessProject.tests.CustomerTest;
import com.file.reader.fileProcessProject.tests.FileProcessAndWriterServiceTest;
import com.file.reader.fileProcessProject.tests.FileProcessUtilsTest;
import com.file.reader.fileProcessProject.tests.ReadServiceTest;
import com.file.reader.fileProcessProject.tests.SaleTest;
import com.file.reader.fileProcessProject.tests.SellerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Classe responsavel por centralizar a suite de testes
 *
 * @author patriciaramos1995
 * date: 05/01/2021 22:38
 */
@RunWith(value = Suite.class)
@Suite.SuiteClasses(value = { CustomerTest.class, SaleTest.class, SellerTest.class, ReadServiceTest.class,
        FileProcessAndWriterServiceTest.class, FileProcessUtilsTest.class })
public class FileProcessTestSuite {
}
