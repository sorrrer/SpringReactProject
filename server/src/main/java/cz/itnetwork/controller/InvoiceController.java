package cz.itnetwork.controller;

import cz.itnetwork.dto.InvoiceDTO;
import cz.itnetwork.dto.PersonDTO;
import cz.itnetwork.entity.PersonEntity;
import cz.itnetwork.entity.filter.InvoiceFilter;
import cz.itnetwork.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/invoices")
    public InvoiceDTO addInvoice(@RequestBody InvoiceDTO invoiceDTO)
    {
        return invoiceService.addInvoice(invoiceDTO);
    }
    @GetMapping("/invoices")
    public List<InvoiceDTO>getAllInvoices(InvoiceFilter invoiceFilter)
    {
        return invoiceService.getAllInvoices(invoiceFilter);
    }
    @GetMapping("/invoices/{invoicesId}")
    public InvoiceDTO getDetailInvoice(@PathVariable Long invoicesId)
    {
        return invoiceService.getDetailInvoice(invoicesId);
    }
    @PutMapping("/invoices/{invoicesId}")
    public InvoiceDTO editInvoice(@PathVariable Long invoicesId,@RequestBody InvoiceDTO invoiceDTO)
    {
        return invoiceService.editInvoice(invoicesId,invoiceDTO);
    }
    @DeleteMapping("/invoices/{invoicesId}")
    public InvoiceDTO removeInvoice(@PathVariable Long invoicesId)
    {
        return invoiceService.removeInvoice(invoicesId);
    }

    @GetMapping("/identification/{identificationNumber}/sales")
    public List<InvoiceDTO>getAllBySeller(@PathVariable String identificationNumber)
    {
        return invoiceService.getAllBySeller(identificationNumber);
    }
    @GetMapping("/identification/{identificationNumber}/purchases")
    public  List<InvoiceDTO>getAllByBuyer(@PathVariable String identificationNumber)
    {
        return invoiceService.getAllByBuyer(identificationNumber);
    }







}
