package com.file.reader.fileProcessProject.entity;

import static com.file.reader.fileProcessProject.utils.FileProcessUtils.BAD_SELLER_TEXT;
import static com.file.reader.fileProcessProject.utils.FileProcessUtils.CUSTOMER_TEXT;
import static com.file.reader.fileProcessProject.utils.FileProcessUtils.ID_SALE_TEXT;
import static com.file.reader.fileProcessProject.utils.FileProcessUtils.SELLER_TEXT;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe responsavel por organizar o que virá no arquivo .done
 *
 * @author patriciaramos1995
 * date: 03/01/2021 16:22
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcessResult {

    private long countCustomer;
    private long countSeller;
    private long idBestSale;
    private String nameBadSeller;

    public static StringBuilder getProcessResult(final ProcessResult processResult) {

        return new StringBuilder()
                .append(SELLER_TEXT + processResult.getCountSeller() + "\n")
                .append(CUSTOMER_TEXT + processResult.getCountCustomer() + "\n")
                .append(ID_SALE_TEXT + processResult.getIdBestSale() + "\n")
                .append(BAD_SELLER_TEXT + processResult.getNameBadSeller());
    }

}
