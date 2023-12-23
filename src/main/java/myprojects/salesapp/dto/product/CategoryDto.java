package myprojects.salesapp.dto.product;

import java.io.Serializable;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.Data;
import myprojects.salesapp.dto.validation.ValidateAll;
import myprojects.salesapp.dto.validation.ValidateOnCreate;
import myprojects.salesapp.dto.validation.ValidateOnUpdate;

@Data
public class CategoryDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Null(message = "{id.Null}", groups = { ValidateOnCreate.class })
    @NotNull(message = "{id.NotNull}", groups = { ValidateOnUpdate.class })
    @Min(value = 1, message = "{id.Min}", groups = { ValidateOnUpdate.class })
    private Integer id;

    @NotBlank(message = "{name.NotBlank}", groups = { ValidateAll.class })
    @Size(max = 60, message = "{name.Size.max}", groups = { ValidateAll.class })
    private String name;
}
