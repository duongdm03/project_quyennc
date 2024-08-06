package vn.duong.itech.web.rest.category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.duong.itech.service.dto.ResultDto;
import vn.duong.itech.service.dto.category.CategoryRequest;
import vn.duong.itech.service.mapper.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryResource {

    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create-category")
    public ResponseEntity<ResultDto> createCategory(@RequestBody CategoryRequest categoryRequest) {
        ResultDto resultDto = categoryService.createCategory(categoryRequest);
        return ResponseEntity.ok(resultDto);
    }

    @GetMapping("/get-category/{id}")
    public ResponseEntity<ResultDto> getCategory(@PathVariable Integer id) {
        ResultDto resultDto = categoryService.findCategoryById(id);
        return ResponseEntity.ok(resultDto);
    }

    @PutMapping("/update-category/{id}")
    public ResponseEntity<ResultDto> updateCategory(@PathVariable int id, @RequestBody CategoryRequest categoryRequest) {
        ResultDto resultDto = categoryService.findCategoryByIdUpdate(id, categoryRequest);
        return ResponseEntity.ok(resultDto);
    }

    @DeleteMapping("/delete-category/{id}")
    public ResponseEntity<ResultDto> deleteCategory(@PathVariable Integer id) {
        ResultDto resultDto = categoryService.findCategoryByIdDetete(id);
        return ResponseEntity.ok(resultDto);
    }
}
