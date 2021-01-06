package com.file.reader.fileProcessProject.service.implementation;

import com.file.reader.fileProcessProject.entity.Customer;
import com.file.reader.fileProcessProject.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Classe responsavel por realizar integração com o repositório de clientes
 *
 * @author patriciaramos1995
 * date: 03/01/2021 15:58
 */
@Component
@RequiredArgsConstructor
public class CustomerServiceImpl {

    private final CustomerRepository customerRepository;

    public void save(final Customer customer) {
        this.customerRepository.save(customer);
    }
}
