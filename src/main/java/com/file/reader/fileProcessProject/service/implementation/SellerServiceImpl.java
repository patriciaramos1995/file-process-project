package com.file.reader.fileProcessProject.service.implementation;

import com.file.reader.fileProcessProject.entity.Seller;
import com.file.reader.fileProcessProject.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Classe responsavel por realizar integração com o repositório de vendedor
 *
 * @author patriciaramos1995
 * date: 03/01/2021 15:58
 */
@Component
@RequiredArgsConstructor
public class SellerServiceImpl {

    private final SellerRepository sellerRepository;

    public void save(final Seller seller) {
        this.sellerRepository.save(seller);
    }
}
