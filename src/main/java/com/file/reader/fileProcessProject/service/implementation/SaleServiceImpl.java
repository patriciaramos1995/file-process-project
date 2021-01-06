package com.file.reader.fileProcessProject.service.implementation;

import com.file.reader.fileProcessProject.entity.Sale;
import com.file.reader.fileProcessProject.repository.ItemRepository;
import com.file.reader.fileProcessProject.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Classe responsavel por realizar integração com o repositório de vendas
 *
 * @author patriciaramos1995
 * date: 03/01/2021 15:58
 */
@Component
@RequiredArgsConstructor
public class SaleServiceImpl {

    private final SaleRepository saleRepository;
    private final ItemRepository itemRepository;

    public void save(final Sale sale) {

        sale.getItem().forEach(item -> this.itemRepository.save(item));
        this.saleRepository.save(sale);
    }

}
