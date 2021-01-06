package com.file.reader.fileProcessProject.repository;

import com.file.reader.fileProcessProject.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Interface responsavel por manter o repositório de vendedores
 *
 * @author patriciaramos1995
 * date: 03/01/2021 15:53
 */
@Repository("sellerRepository")
public interface SellerRepository extends JpaRepository<Seller, Long> {

    @Query(value = "select s.salles_man from (\n"
            + "select salles_man, sum(sum_price_sales) as summary from sale \n"
            + "group by salles_man) as s order by s.summary limit 1", nativeQuery = true)
    String findBadSeller();

}
