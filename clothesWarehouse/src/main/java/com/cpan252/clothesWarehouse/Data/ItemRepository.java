package com.cpan252.clothesWarehouse.Data;

import com.cpan252.clothesWarehouse.model.ItemModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemRepository extends PagingAndSortingRepository<ItemModel, Long> {


    Page<ItemModel> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Page<ItemModel> findAllByOrderByNameAsc(Pageable pageable);

    Page<ItemModel> findAllByOrderByNameDesc(Pageable pageable);


}
