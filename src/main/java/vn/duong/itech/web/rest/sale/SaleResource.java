package vn.duong.itech.web.rest.sale;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.duong.itech.service.dto.ResultDto;
import vn.duong.itech.service.dto.sale.SaleRequest;
import vn.duong.itech.service.mapper.SaleService;

@RestController
@RequestMapping("/api")
public class SaleResource {

    private final SaleService saleService;

    public SaleResource(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping("/create-sale")
    public ResponseEntity<ResultDto> createSale(@RequestBody SaleRequest saleRequest) {
        ResultDto resultDto = saleService.createSale(saleRequest);
        return ResponseEntity.ok(resultDto);
    }

    @PutMapping("/update-sale/{id}")
    public ResponseEntity<ResultDto> updateSale(@PathVariable int id, @RequestBody SaleRequest saleRequest) {
        ResultDto resultDto = saleService.findSaleById(id, saleRequest);
        return ResponseEntity.ok(resultDto);
    }

    @GetMapping("/search-sale/{name}")
    public ResponseEntity<List<ResultDto>> searchSale(@PathVariable String name) {
        List<ResultDto> resultDto = saleService.findSaleByName(name);
        return ResponseEntity.ok(resultDto);
    }
}
