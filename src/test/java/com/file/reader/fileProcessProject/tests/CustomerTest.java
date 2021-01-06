package com.file.reader.fileProcessProject.tests;

import static com.file.reader.fileProcessProject.service.FileReaderService.DEMILITER_CHAR;

import com.file.reader.fileProcessProject.entity.Customer;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Classe responsavel por agrupar os testes de unidade do cliente
 *
 * @author patriciaramos1995
 * date: 05/01/2021 11:16
 */
@RunWith(SpringRunner.class)
public class CustomerTest {

    @Test
    public void getCustomerSuccess() {

        final String textFileCustomer = "002ç2345675434544345çJose da SilvaçRural";
        List<String> partsText = Arrays.asList(textFileCustomer.split(DEMILITER_CHAR));

        Customer customerDTO = Customer.getCustomerDTO(partsText);
        Assertions.assertEquals(customerDTO.getCnpj(), "2345675434544345");
        Assertions.assertEquals(customerDTO.getName(), "Jose da Silva");
        Assertions.assertEquals(customerDTO.getBusinessArea(), "Rural");

    }
}
