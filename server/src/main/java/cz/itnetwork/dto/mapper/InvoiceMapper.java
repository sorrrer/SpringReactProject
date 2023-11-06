package cz.itnetwork.dto.mapper;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.PersonDTO;
import cz.itnetwork.entity.InvoiceEntity;
import cz.itnetwork.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    InvoiceEntity toEntity(InvoiceDTO source);
    InvoiceDTO toDTO(InvoiceEntity source);

    void updateInvoiceEntity(InvoiceDTO source, @MappingTarget InvoiceEntity target);
    List<InvoiceDTO>toDTO(List<InvoiceEntity> source);
}
