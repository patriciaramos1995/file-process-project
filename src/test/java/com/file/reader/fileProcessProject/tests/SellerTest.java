package com.file.reader.fileProcessProject.tests;

import static com.file.reader.fileProcessProject.service.FileReaderService.DEMILITER_CHAR;

import com.file.reader.fileProcessProject.entity.Seller;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Classe responsavel por agrupar os testes de unidade do vendedor
 *
 * @author patriciaramos1995
 * date: 05/01/2021 11:16
 */
@RunWith(SpringRunner.class)
public class SellerTest {

    @Test
    public void getSellerSuccess() {

        final String textFileSeller = "001ç3245678865434çPauloç40000.99";
        List<String> partsText = Arrays.asList(textFileSeller.split(DEMILITER_CHAR));

        Seller sellerDTO = Seller.getSellerDTO(partsText);
        Assertions.assertEquals(sellerDTO.getCpf(), "3245678865434");
        Assertions.assertEquals(sellerDTO.getName(), "Paulo");
        Assertions.assertEquals(sellerDTO.getSalary(), 40000.99);
    }
}
