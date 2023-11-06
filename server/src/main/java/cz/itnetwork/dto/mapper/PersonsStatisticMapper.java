package cz.itnetwork.dto.mapper;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.PersonsStatisticDTO;
import cz.itnetwork.entity.InvoiceEntity;
import cz.itnetwork.entity.PersonsStatisticEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonsStatisticMapper {
    PersonsStatisticDTO toDTO(PersonsStatisticEntity source);
    List<PersonsStatisticDTO> toDTO(List<PersonsStatisticEntity> source);
}
