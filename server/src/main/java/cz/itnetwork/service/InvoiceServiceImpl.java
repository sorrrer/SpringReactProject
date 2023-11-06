package cz.itnetwork.service;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.PersonDTO;
import cz.itnetwork.dto.mapper.InvoiceMapper;
import cz.itnetwork.entity.InvoiceEntity;
import cz.itnetwork.entity.PersonEntity;
import cz.itnetwork.entity.filter.InvoiceFilter;
import cz.itnetwork.entity.repository.InvoiceRepository;
import cz.itnetwork.entity.repository.PersonRepository;
import cz.itnetwork.entity.repository.specification.InvoiceSpecification;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceServiceImpl implements InvoiceService{

    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private InvoiceMapper invoiceMapper;
    /* Přidání faktury */
    @Override
    public InvoiceDTO addInvoice(InvoiceDTO invoiceDTO) {
        InvoiceEntity invoice = invoiceMapper.toEntity(invoiceDTO);
        invoice.setBuyer(personRepository.getReferenceById(invoiceDTO.getBuyer().getId()));
        invoice.setSeller(personRepository.getReferenceById(invoiceDTO.getSeller().getId()));
        invoice = invoiceRepository.save(invoice);

        return invoiceMapper.toDTO(invoice);
    }
    /* Výpis všech faktur,
        filtrování,
        limit;
    */
    @Override
    public List<InvoiceDTO> getAllInvoices(InvoiceFilter invoiceFilter) {
        InvoiceSpecification invoiceSpecification = new InvoiceSpecification(invoiceFilter);

       return invoiceRepository.findAll(invoiceSpecification,PageRequest.of(0,invoiceFilter.getLimit()))
        .stream()
                .map(invoiceMapper::toDTO)
                .collect(Collectors.toList());
    }
    /* detail faktury */
    @Override
    public InvoiceDTO getDetailInvoice(Long id) {
        InvoiceEntity entity = invoiceRepository.getReferenceById(id);
        return invoiceMapper.toDTO(entity);
    }
    /* úprava faktuy */
    @Override
    public InvoiceDTO editInvoice(Long id, InvoiceDTO invoiceDTO) {
        invoiceDTO.setId(id);
        InvoiceEntity entity = invoiceRepository.getReferenceById(id);
        invoiceMapper.updateInvoiceEntity(invoiceDTO,entity);

        entity.setBuyer(personRepository.getReferenceById(invoiceDTO.getBuyer().getId()));
        entity.setSeller(personRepository.getReferenceById(invoiceDTO.getSeller().getId()));
        entity = invoiceRepository.save(entity);
        return invoiceMapper.toDTO(entity);
    }
    /* Odstranění faktury */
    @Override
    public InvoiceDTO removeInvoice(Long id) {
        InvoiceEntity entity = invoiceRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        InvoiceDTO dto = invoiceMapper.toDTO(entity);
        invoiceRepository.delete(entity);
        return dto;
    }
    /* výpis všech faktur podle ič prodávajícího */
    @Override
    public List<InvoiceDTO> getAllBySeller(String identificationNumber) {
        List<InvoiceEntity>entities =invoiceRepository.findAllBySellerIdentificationNumber(identificationNumber);
        return invoiceMapper.toDTO(entities);
    }
    /* Výpis všech faktur podle ič nakupujícího */
    @Override
    public List<InvoiceDTO> getAllByBuyer(String identificationNumber) {
        List<InvoiceEntity>entities = invoiceRepository.findAllByBuyerIdentificationNumber(identificationNumber);
        return invoiceMapper.toDTO(entities);
    }

}
