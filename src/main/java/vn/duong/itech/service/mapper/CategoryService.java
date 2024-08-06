package vn.duong.itech.service.mapper;

import java.util.Optional;
import org.springframework.stereotype.Service;
import vn.duong.itech.domain.Category;
import vn.duong.itech.repository.CategoryRepository;
import vn.duong.itech.service.dto.ResultDto;
import vn.duong.itech.service.dto.category.CategoryRequest;
import vn.duong.itech.service.dto.category.CategoryRespone;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public ResultDto createCategory(CategoryRequest categoryRequest) {
        Integer count = categoryRepository.countCategoryByName(categoryRequest.getName());
        if (count > 0) {
            return new ResultDto("Danh Muc San Pham Da Ton Tai", "FAILED", false);
        }
        Category category = new Category();
        category.setName(categoryRequest.getName());
        category = categoryRepository.save(category);
        CategoryRespone categoryRespone = new CategoryRespone(category.getId(), category.getName());
        return new ResultDto("Them danh muc thanh cong", "SUCCESS", true, categoryRespone);
    }

    public ResultDto findCategoryById(Integer id) {
        Category category = categoryRepository.findCategoryById(id);
        CategoryRespone categoryRespone = new CategoryRespone(category.getId(), category.getName());
        return new ResultDto("Lay danh muc thanh cong", "SUCCESS", true, categoryRespone);
    }

    public ResultDto findCategoryByIdUpdate(int id, CategoryRequest categoryRequest) {
        Optional<Category> category = Optional.ofNullable(categoryRepository.findCategoryById(id));
        if (category.isPresent()) {
            Category c = category.get();
            c.setName(categoryRequest.getName());
            c = categoryRepository.save(c);
            CategoryRespone categoryRespone = new CategoryRespone(c.getId(), categoryRequest.getName());
            return new ResultDto("Update danh muc san pham thanh cong", "SUCCESS", true, categoryRespone);
        } else {
            return new ResultDto("Khong tim thay danh muc san pham", "Failed", false, null);
        }
    }

    public ResultDto findCategoryByIdDetete(Integer id) {
        Optional<Category> category = Optional.ofNullable(categoryRepository.findCategoryById(id));
        if (category.isPresent()) {
            categoryRepository.deleteById(id);
            return new ResultDto("Xoa Danh Muc Thanh Cong", "SUCCESS", true, null);
        } else {
            return new ResultDto("Khong tim thay danh muc san pham", "Failed", false, null);
        }
    }
}
