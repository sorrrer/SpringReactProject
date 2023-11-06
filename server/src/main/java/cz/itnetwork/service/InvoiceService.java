package cz.itnetwork.service;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.PersonDTO;
import cz.itnetwork.entity.PersonEntity;
import cz.itnetwork.entity.filter.InvoiceFilter;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface InvoiceService {
    InvoiceDTO addInvoice(InvoiceDTO invoiceDTO);
    List<InvoiceDTO>getAllInvoices(InvoiceFilter invoiceFilter);
    InvoiceDTO getDetailInvoice(Long id);
    InvoiceDTO editInvoice(Long id,InvoiceDTO invoiceDTO);
    InvoiceDTO removeInvoice(Long id);
    List<InvoiceDTO>getAllBySeller(String identificationNumber);
    List<InvoiceDTO>getAllByBuyer(String identificationNumber);






}
