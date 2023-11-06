package cz.itnetwork.service;

import cz.itnetwork.dto.InvoicesStatisticDTO;
import cz.itnetwork.dto.mapper.InvoicesStatisticMapper;
import cz.itnetwork.entity.InvoiceEntity;
import cz.itnetwork.entity.InvoicesStatisticEntity;
import cz.itnetwork.entity.repository.InvoiceRepository;
import cz.itnetwork.entity.repository.InvoicesStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class InvoicesStatisticServiceImpl implements InvoicesStatisticService {
    @Autowired
    private InvoicesStatisticRepository invoicesStatisticRepository;
    @Autowired
    private InvoicesStatisticMapper invoicesStatisticMapper;

    /* metoda pro statistiky:
        - výpis celkových počet faktur,
        - výpis celkové ceny faktur za jeden rok,
        - výpis celkové ceny faktur;
     */
    @Override
    public InvoicesStatisticDTO getStatistic() {
        LocalDate todayDate = LocalDate.now();
        LocalDate yearAgoDate = todayDate.minusYears(1);

        long totalCount = invoicesStatisticRepository.count();
        BigDecimal totalPrice = invoicesStatisticRepository.getSumPrice();
        BigDecimal totalPriceForYear = invoicesStatisticRepository.getSumPriceForYear(yearAgoDate,todayDate);

        InvoicesStatisticEntity entity = new InvoicesStatisticEntity();
        entity.setInvoicesCount(totalCount);
        entity.setAllTimeSum(totalPrice);
        entity.setCurrentYearSum(totalPriceForYear);

        invoicesStatisticRepository.save(entity);
        return invoicesStatisticMapper.toDTO(entity);
    }

}
