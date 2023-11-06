package cz.itnetwork.service;

import cz.itnetwork.dto.PersonsStatisticDTO;
import cz.itnetwork.dto.mapper.PersonsStatisticMapper;
import cz.itnetwork.entity.*;
import cz.itnetwork.entity.repository.PersonRepository;
import cz.itnetwork.entity.repository.PersonsStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PersonsStatisticServiceImpl implements PersonsStatisticService {
    @Autowired
    private PersonsStatisticRepository personsStatisticRepository;



    @Override
    public List<PersonsStatisticDTO> getPersonStatistic() {

        return personsStatisticRepository.getPersonStatistic();

    }
}


