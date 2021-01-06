package com.file.reader.fileProcessProject.repository;

import com.file.reader.fileProcessProject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface responsavel por manter o repositório de clientes
 *
 * @author patriciaramos1995
 * date: 03/01/2021 15:53
 */
@Repository("customerRepository")
public interface CustomerRepository  extends JpaRepository<Customer, Long> {
}
