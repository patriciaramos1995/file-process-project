package com.file.reader.fileProcessProject.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe responsavel por mepar os dados de venda
 *
 * @author patriciaramos1995
 * date: 13/12/2020 13:16
 */
@Data
@Builder
@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Sale {

    @Id
    private long id;

    @OneToMany
    private List<Item> item;

    private String sallesMan;

    private Double sumPriceSales;

    public static Sale getSaleDTO(final List<String> text) {

        List<Item> listItemsSales = Item.getItemList(text.get(2));

        return Sale.builder()
                .id(Long.parseLong(text.get(1)))
                .item(listItemsSales)
                .sallesMan(text.get(3))
                .sumPriceSales(listItemsSales.stream().mapToDouble(Item::getPrice).sum())
                .build();
    }
}
