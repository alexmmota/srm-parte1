package br.com.srm.model;

import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "srm_product")
public class ProductEntity implements Serializable {

    @Id
    @Column(name = "isbn")
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;

    private String name;
    private Integer amount;
    private Double cost;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "change_date")
    private Date changeDate;

}
