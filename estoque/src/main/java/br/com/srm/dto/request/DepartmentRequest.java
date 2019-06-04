package br.com.srm.dto.request;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class DepartmentRequest implements Serializable {

    @NotBlank(message = "Nome deve ser informado")
    private String name;
    private String description;

}
