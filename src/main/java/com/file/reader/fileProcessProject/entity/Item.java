package com.file.reader.fileProcessProject.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe responsavel por mapear os items de venda
 *
 * @author patriciaramos1995
 * date: 13/12/2020 13:22
 */
@Data
@Builder
@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue
    private int idItem;

    private int idSale;
    private Long quantityItem;
    private Double price;

    public static List<Item> getItemList(final String items) {

        String[] listItems = items.split(",");
        List<Item> listDTOItems = new ArrayList<>();

        for (String item : listItems) {

            List<String> itemsArray = Arrays.asList(item.split("-"));

            Item itemDTO = Item.builder().idSale(Integer.parseInt(itemsArray.get(0).replace("[", "")))
                    .quantityItem(Long.valueOf(itemsArray.get(1)))
                    .price(Double.valueOf(itemsArray.get(2).replace("]", "")))
                    .build();

            listDTOItems.add(itemDTO);
        }

        return listDTOItems;
    }
}
