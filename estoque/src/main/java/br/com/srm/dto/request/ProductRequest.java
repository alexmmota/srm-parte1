package br.com.srm.dto.request;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class ProductRequest implements Serializable {

    @NotBlank(message = "ISBN deve ser informado")
    private String isbn;

    @NotBlank(message = "Nome deve ser informado")
    private String name;

    @NotNull(message = "Quantidade deve ser informada")
    private Integer amount;

    @NotNull(message = "Preço de custo deve ser informado")
    private Double cost;

}
