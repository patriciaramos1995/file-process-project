package com.file.reader.fileProcessProject.tests;

import static com.file.reader.fileProcessProject.service.FileReaderService.DEMILITER_CHAR;

import com.file.reader.fileProcessProject.entity.Sale;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Classe responsavel por agrupar os testes de unidade da venda
 *
 * @author patriciaramos1995
 * date: 05/01/2021 11:16
 */
@RunWith(SpringRunner.class)
public class SaleTest {

    @Test
    public void getSaleSuccess() {

        final String textFileSale = "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro";
        List<String> partsText = Arrays.asList(textFileSale.split(DEMILITER_CHAR));

        Sale saleDTO = Sale.getSaleDTO(partsText);
        Assertions.assertEquals(saleDTO.getId(), 10);
        Assertions.assertEquals(saleDTO.getSallesMan(), "Pedro");
        Assertions.assertTrue(saleDTO.getItem().size() == 3);

    }
}
