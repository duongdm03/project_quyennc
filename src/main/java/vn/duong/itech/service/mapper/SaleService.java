package vn.duong.itech.service.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import vn.duong.itech.domain.Sale;
import vn.duong.itech.repository.SaleRepository;
import vn.duong.itech.service.dto.ResultDto;
import vn.duong.itech.service.dto.sale.SaleRequest;
import vn.duong.itech.service.dto.sale.SaleRespone;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public ResultDto createSale(SaleRequest saleRequest) {
        if (saleRequest.getEndDate().isBefore(saleRequest.getStartDate())) {
            return new ResultDto("Ngay ket thuc phai lon hon ngay bat dau", "FAILED", false);
        }
        Integer count = saleRepository.countSaleByName(saleRequest.getName());
        if (count > 0) {
            return new ResultDto("Su Kien Giam Gia Da Ton Tai", "FAILED", false);
        }
        Sale sale = new Sale();
        sale.setName(saleRequest.getName());
        sale.setStartDate(saleRequest.getStartDate());
        sale.setEndDate(saleRequest.getEndDate());
        sale.setDiscount(saleRequest.getDiscount());
        sale.setTypeDiscount(saleRequest.getTypeDiscount());
        sale.setTypeSale(saleRequest.getTypeSale());
        sale.setMinimumPrice(saleRequest.getMinimumPrice());
        sale.setNote(saleRequest.getNote());
        sale.setTopUser(saleRequest.getTopUser());
        sale.setStatus(saleRequest.isStatus());
        saleRepository.save(sale);

        SaleRespone saleRespone = new SaleRespone(
            sale.getId(),
            sale.isStatus(),
            sale.getNote(),
            sale.getMinimumPrice(),
            sale.getTopUser(),
            sale.getEndDate(),
            sale.getStartDate(),
            sale.getTypeSale(),
            sale.getTypeDiscount(),
            sale.getDiscount(),
            sale.getName()
        );

        return new ResultDto("Them xu kien giam gia thanh cong", "SUCCESS", true, saleRespone);
    }

    public ResultDto findSaleById(int id, SaleRequest saleRequest) {
        Optional<Sale> sale = saleRepository.findById(id);
        if (saleRequest.getStartDate().isAfter(saleRequest.getEndDate())) {
            return new ResultDto("Ngay bat dau phai nho hon ngay ket thuc", "FAILED", false);
        }
        Integer count = saleRepository.countSaleByName(saleRequest.getName());
        if (count > 0) {
            return new ResultDto("Su Kien Giam Gia Da Ton Tai", "FAILED", false);
        }
        if (sale.isPresent()) {
            Sale s = sale.get();
            s.setName(saleRequest.getName());
            s.setStartDate(saleRequest.getStartDate());
            s.setEndDate(saleRequest.getEndDate());
            s.setDiscount(saleRequest.getDiscount());
            s.setTypeDiscount(saleRequest.getTypeDiscount());
            s.setTypeSale(saleRequest.getTypeSale());
            s.setMinimumPrice(saleRequest.getMinimumPrice());
            s.setNote(saleRequest.getNote());
            s.setTopUser(saleRequest.getTopUser());
            s.setStatus(saleRequest.isStatus());
            saleRepository.save(s);
            SaleRespone saleRespone = new SaleRespone(
                s.getId(),
                s.isStatus(),
                s.getNote(),
                s.getMinimumPrice(),
                s.getTopUser(),
                s.getEndDate(),
                s.getStartDate(),
                s.getTypeSale(),
                s.getTypeDiscount(),
                s.getDiscount(),
                s.getName()
            );
            return new ResultDto("Cap Nhat Su Kien Giam Gia Thanh Cong", "SUCCESS", true, saleRespone);
        } else {
            return new ResultDto("Khong tim thay su kien Giam Gia", "FAILED", false);
        }
    }

    public List<ResultDto> findSaleByName(String name) {
        List<Sale> sales = (List<Sale>) saleRepository.findSaleByName(name);
        List<ResultDto> resultDtoList = new ArrayList<>();

        if (sales.isEmpty()) {
            resultDtoList.add(new ResultDto("Khong tim thay su kien Giam Gia", "FAILED", false, null));
        } else {
            for (Sale s : sales) {
                SaleRespone saleRespone = new SaleRespone(
                    s.getId(),
                    s.isStatus(),
                    s.getNote(),
                    s.getMinimumPrice(),
                    s.getTopUser(),
                    s.getEndDate(),
                    s.getStartDate(),
                    s.getTypeSale(),
                    s.getTypeDiscount(),
                    s.getDiscount(),
                    s.getName()
                );
                resultDtoList.add(new ResultDto("Tim kiem thanh cong ma giam gia", "SUCCESS", true, saleRespone));
            }
        }
        return resultDtoList;
    }
}
