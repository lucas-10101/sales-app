package myprojects.salesapp.integrationtest.rest.product;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import myprojects.salesapp.BaseIntegrationTest;
import myprojects.salesapp.dto.product.CategoryDto;
import myprojects.salesapp.models.enums.ErrorType;

public class CategoryControllerTest extends BaseIntegrationTest {

    @Test
    @DisplayName("testCreateNewCategory")
    public void testCreateNewCategory() throws Exception {

        CategoryDto category = new CategoryDto();
        category.setName("category");

        var request = post("/categories")
                .content(objectMapper.writeValueAsString(category))
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.id", not(equalTo(category.getId()))))
                .andExpect(jsonPath("$.name").value(category.getName()));
    }

    @Test
    @DisplayName("testValidationErrorWhenCreateInvalidCategory")
    public void testValidationErrorWhenCreateInvalidCategory() throws Exception {

        CategoryDto category = new CategoryDto();
        category.setName("");

        var request = post("/categories")
                .content(objectMapper.writeValueAsString(category))
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.time").exists())
                .andExpect(jsonPath("$.type").value(ErrorType.VALIDATION.name()))
                .andExpect(jsonPath("$.errors").isArray());
    }
}
