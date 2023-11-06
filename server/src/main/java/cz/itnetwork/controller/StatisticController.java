package cz.itnetwork.controller;

import cz.itnetwork.dto.InvoicesStatisticDTO;
import cz.itnetwork.dto.PersonsStatisticDTO;
import cz.itnetwork.entity.PersonsStatisticEntity;
import cz.itnetwork.service.InvoicesStatisticService;
import cz.itnetwork.service.PersonsStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StatisticController {
    @Autowired
    private InvoicesStatisticService invoicesStatisticService;
    @Autowired
    private PersonsStatisticService personsStatisticService;

    @GetMapping("/invoices/statistics")
    public InvoicesStatisticDTO getStatistic()
    {
        return invoicesStatisticService.getStatistic();
    }
    @GetMapping("/people/statistics")
    public List<PersonsStatisticDTO> getPersonStatistic()
    {
        return personsStatisticService.getPersonStatistic();
    }




}
