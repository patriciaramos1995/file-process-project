package com.file.reader.fileProcessProject.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe responsavel por mapear os dados do vendedor
 *
 * @author patriciaramos1995
 * date: 13/12/2020 13:15
 */
@Data
@Builder
@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Seller {

    @Id
    private String cpf;

    private String name;

    private Double salary;

    public static Seller getSellerDTO(final List<String> text) {

        return Seller.builder()
                .cpf(text.get(1))
                .name(text.get(2))
                .salary(Double.valueOf(text.get(3))).build();
    }
}
