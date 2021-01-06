package com.file.reader.fileProcessProject.service;

import com.file.reader.fileProcessProject.entity.ProcessResult;
import com.file.reader.fileProcessProject.repository.CustomerRepository;
import com.file.reader.fileProcessProject.repository.SaleRepository;
import com.file.reader.fileProcessProject.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Classe responsavel por processar os textos
 *
 * @author patriciaramos1995
 * date: 26/12/2020 13:48
 */
@Service
@RequiredArgsConstructor
public class ProcessService {

    private final CustomerRepository customerRepository;
    private final SaleRepository saleRepository;
    private final SellerRepository sellerRepository;

    public ProcessResult dataProcesss() {

        return ProcessResult.builder().countCustomer(this.customerRepository.count())
                .countSeller(this.sellerRepository.count())
                .idBestSale(this.saleRepository.findBestSale())
                .nameBadSeller(this.sellerRepository.findBadSeller())
                .build();
    }
}
