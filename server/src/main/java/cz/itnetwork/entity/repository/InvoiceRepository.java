package cz.itnetwork.entity.repository;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.PersonDTO;
import cz.itnetwork.entity.InvoiceEntity;
import cz.itnetwork.entity.PersonEntity;
import cz.itnetwork.entity.filter.InvoiceFilter;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface InvoiceRepository extends JpaSpecificationExecutor<InvoiceEntity>, JpaRepository<InvoiceEntity,Long> {
    List<InvoiceEntity>findAllBySellerIdentificationNumber(String seller_identificationNumber);
    List<InvoiceEntity>findAllByBuyerIdentificationNumber(String buyer_identificationNumber);









}
