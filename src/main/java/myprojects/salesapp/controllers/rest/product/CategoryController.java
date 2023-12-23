package myprojects.salesapp.controllers.rest.product;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myprojects.salesapp.dto.product.CategoryDto;
import myprojects.salesapp.dto.validation.ValidateOnCreate;
import myprojects.salesapp.models.product.Category;
import myprojects.salesapp.services.product.CategoryService;

@RestController
@RequestMapping(path = "/categories", consumes = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<CategoryDto> getMethodName(@RequestBody @Validated(ValidateOnCreate.class) CategoryDto inDto) {

        var category = modelMapper.map(inDto, Category.class);
        category = categoryService.save(category);

        var outDto = modelMapper.map(category, CategoryDto.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(outDto);
    }
}
