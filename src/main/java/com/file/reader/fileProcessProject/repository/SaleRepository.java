package com.file.reader.fileProcessProject.repository;

import com.file.reader.fileProcessProject.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Interface responsavel por manter o respositório de vendas
 *
 * @author patriciaramos1995
 * date: 03/01/2021 15:53
 */
@Repository("saleRepository")
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(value = "SELECT \n"
            + "  id\n"
            + "FROM sale s\n"
            + "WHERE s.sum_price_sales = (SELECT MAX(sum_price_sales) FROM sale)", nativeQuery = true)
    long findBestSale();

}
