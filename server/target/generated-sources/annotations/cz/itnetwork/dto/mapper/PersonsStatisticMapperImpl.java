package cz.itnetwork.dto.mapper;

import cz.itnetwork.dto.PersonsStatisticDTO;
import cz.itnetwork.entity.PersonsStatisticEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class PersonsStatisticMapperImpl implements PersonsStatisticMapper {

    @Override
    public PersonsStatisticDTO toDTO(PersonsStatisticEntity source) {
        if ( source == null ) {
            return null;
        }

        PersonsStatisticDTO personsStatisticDTO = new PersonsStatisticDTO();

        personsStatisticDTO.setPersonId( source.getPersonId() );
        personsStatisticDTO.setPersonName( source.getPersonName() );
        personsStatisticDTO.setRevenue( source.getRevenue() );

        return personsStatisticDTO;
    }

    @Override
    public List<PersonsStatisticDTO> toDTO(List<PersonsStatisticEntity> source) {
        if ( source == null ) {
            return null;
        }

        List<PersonsStatisticDTO> list = new ArrayList<PersonsStatisticDTO>( source.size() );
        for ( PersonsStatisticEntity personsStatisticEntity : source ) {
            list.add( toDTO( personsStatisticEntity ) );
        }

        return list;
    }
}
