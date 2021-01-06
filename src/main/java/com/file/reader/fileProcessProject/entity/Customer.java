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
 * Classe responsavel por mapear os dados do cliente
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
public class Customer {


    @Id
    private String cnpj;

    private String name;

    private String businessArea;

    public static Customer getCustomerDTO(final List<String> text) {

        return Customer.builder()
                .cnpj(text.get(1))
                .name(text.get(2))
                .businessArea(text.get(3)).build();
    }
}
