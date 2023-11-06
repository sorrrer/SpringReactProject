package cz.itnetwork.dto.mapper;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.PersonDTO;
import cz.itnetwork.entity.InvoiceEntity;
import cz.itnetwork.entity.PersonEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class InvoiceMapperImpl implements InvoiceMapper {

    @Override
    public InvoiceEntity toEntity(InvoiceDTO source) {
        if ( source == null ) {
            return null;
        }

        InvoiceEntity invoiceEntity = new InvoiceEntity();

        invoiceEntity.setId( source.getId() );
        invoiceEntity.setInvoiceNumber( source.getInvoiceNumber() );
        invoiceEntity.setSeller( personDTOToPersonEntity( source.getSeller() ) );
        invoiceEntity.setBuyer( personDTOToPersonEntity( source.getBuyer() ) );
        invoiceEntity.setIssued( source.getIssued() );
        invoiceEntity.setDueDate( source.getDueDate() );
        invoiceEntity.setProduct( source.getProduct() );
        invoiceEntity.setPrice( source.getPrice() );
        if ( source.getVat() != null ) {
            invoiceEntity.setVat( source.getVat() );
        }
        invoiceEntity.setNote( source.getNote() );

        return invoiceEntity;
    }

    @Override
    public InvoiceDTO toDTO(InvoiceEntity source) {
        if ( source == null ) {
            return null;
        }

        InvoiceDTO invoiceDTO = new InvoiceDTO();

        invoiceDTO.setId( source.getId() );
        invoiceDTO.setInvoiceNumber( source.getInvoiceNumber() );
        invoiceDTO.setSeller( personEntityToPersonDTO( source.getSeller() ) );
        invoiceDTO.setBuyer( personEntityToPersonDTO( source.getBuyer() ) );
        invoiceDTO.setIssued( source.getIssued() );
        invoiceDTO.setDueDate( source.getDueDate() );
        invoiceDTO.setProduct( source.getProduct() );
        invoiceDTO.setPrice( source.getPrice() );
        invoiceDTO.setVat( source.getVat() );
        invoiceDTO.setNote( source.getNote() );

        return invoiceDTO;
    }

    @Override
    public void updateInvoiceEntity(InvoiceDTO source, InvoiceEntity target) {
        if ( source == null ) {
            return;
        }

        target.setId( source.getId() );
        target.setInvoiceNumber( source.getInvoiceNumber() );
        if ( source.getSeller() != null ) {
            if ( target.getSeller() == null ) {
                target.setSeller( new PersonEntity() );
            }
            personDTOToPersonEntity1( source.getSeller(), target.getSeller() );
        }
        else {
            target.setSeller( null );
        }
        if ( source.getBuyer() != null ) {
            if ( target.getBuyer() == null ) {
                target.setBuyer( new PersonEntity() );
            }
            personDTOToPersonEntity1( source.getBuyer(), target.getBuyer() );
        }
        else {
            target.setBuyer( null );
        }
        target.setIssued( source.getIssued() );
        target.setDueDate( source.getDueDate() );
        target.setProduct( source.getProduct() );
        target.setPrice( source.getPrice() );
        if ( source.getVat() != null ) {
            target.setVat( source.getVat() );
        }
        target.setNote( source.getNote() );
    }

    @Override
    public List<InvoiceDTO> toDTO(List<InvoiceEntity> source) {
        if ( source == null ) {
            return null;
        }

        List<InvoiceDTO> list = new ArrayList<InvoiceDTO>( source.size() );
        for ( InvoiceEntity invoiceEntity : source ) {
            list.add( toDTO( invoiceEntity ) );
        }

        return list;
    }

    protected PersonEntity personDTOToPersonEntity(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();

        if ( personDTO.getId() != null ) {
            personEntity.setId( personDTO.getId() );
        }
        personEntity.setName( personDTO.getName() );
        personEntity.setIdentificationNumber( personDTO.getIdentificationNumber() );
        personEntity.setTaxNumber( personDTO.getTaxNumber() );
        personEntity.setAccountNumber( personDTO.getAccountNumber() );
        personEntity.setBankCode( personDTO.getBankCode() );
        personEntity.setIban( personDTO.getIban() );
        personEntity.setTelephone( personDTO.getTelephone() );
        personEntity.setMail( personDTO.getMail() );
        personEntity.setStreet( personDTO.getStreet() );
        personEntity.setZip( personDTO.getZip() );
        personEntity.setCity( personDTO.getCity() );
        personEntity.setCountry( personDTO.getCountry() );
        personEntity.setNote( personDTO.getNote() );

        return personEntity;
    }

    protected PersonDTO personEntityToPersonDTO(PersonEntity personEntity) {
        if ( personEntity == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId( personEntity.getId() );
        personDTO.setName( personEntity.getName() );
        personDTO.setIdentificationNumber( personEntity.getIdentificationNumber() );
        personDTO.setTaxNumber( personEntity.getTaxNumber() );
        personDTO.setAccountNumber( personEntity.getAccountNumber() );
        personDTO.setBankCode( personEntity.getBankCode() );
        personDTO.setIban( personEntity.getIban() );
        personDTO.setTelephone( personEntity.getTelephone() );
        personDTO.setMail( personEntity.getMail() );
        personDTO.setStreet( personEntity.getStreet() );
        personDTO.setZip( personEntity.getZip() );
        personDTO.setCity( personEntity.getCity() );
        personDTO.setCountry( personEntity.getCountry() );
        personDTO.setNote( personEntity.getNote() );

        return personDTO;
    }

    protected void personDTOToPersonEntity1(PersonDTO personDTO, PersonEntity mappingTarget) {
        if ( personDTO == null ) {
            return;
        }

        if ( personDTO.getId() != null ) {
            mappingTarget.setId( personDTO.getId() );
        }
        mappingTarget.setName( personDTO.getName() );
        mappingTarget.setIdentificationNumber( personDTO.getIdentificationNumber() );
        mappingTarget.setTaxNumber( personDTO.getTaxNumber() );
        mappingTarget.setAccountNumber( personDTO.getAccountNumber() );
        mappingTarget.setBankCode( personDTO.getBankCode() );
        mappingTarget.setIban( personDTO.getIban() );
        mappingTarget.setTelephone( personDTO.getTelephone() );
        mappingTarget.setMail( personDTO.getMail() );
        mappingTarget.setStreet( personDTO.getStreet() );
        mappingTarget.setZip( personDTO.getZip() );
        mappingTarget.setCity( personDTO.getCity() );
        mappingTarget.setCountry( personDTO.getCountry() );
        mappingTarget.setNote( personDTO.getNote() );
    }
}
