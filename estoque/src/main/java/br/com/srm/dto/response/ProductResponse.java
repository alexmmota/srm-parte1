package br.com.srm.dto.response;

import lombok.Data;

@Data
public class ProductResponse {

    private String isbn;
    private String name;
    private Integer amount;
    private Double cost;
    private String changeDate;

}
