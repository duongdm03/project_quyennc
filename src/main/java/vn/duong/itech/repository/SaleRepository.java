package vn.duong.itech.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.duong.itech.domain.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
    @Query(value = "select count(*) from Sale where name = ?1", nativeQuery = true)
    Integer countSaleByName(String name);

    @Query(value = "select * from sale where name like %?1%", nativeQuery = true)
    List<Sale> findSaleByName(String name);
}
