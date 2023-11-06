package cz.itnetwork.entity.repository;

import cz.itnetwork.entity.InvoicesStatisticEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface InvoicesStatisticRepository extends JpaRepository<InvoicesStatisticEntity,Long> {

    //Long countBy();
    @Query(value = "SELECT SUM(i.price) FROM invoice i")
    BigDecimal getSumPrice();
    @Query(value ="SELECT SUM(i.price) FROM invoice i WHERE i.dueDate BETWEEN:startDate AND :endDate" )
    BigDecimal getSumPriceForYear(@Param("startDate")LocalDate startDate,@Param("endDate")LocalDate endDate);
}
