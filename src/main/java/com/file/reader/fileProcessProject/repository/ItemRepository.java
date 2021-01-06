package com.file.reader.fileProcessProject.repository;

import com.file.reader.fileProcessProject.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface responsavel por manter o repositório de itens
 *
 * @author patriciaramos1995
 * date: 03/01/2021 17:56
 */
@Repository("itemRepository")
public interface ItemRepository extends JpaRepository<Item, Long> {
}
