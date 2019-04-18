package br.com.srm.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter @Setter
@ToString @EqualsAndHashCode
@Entity
@Table(name = "srm_product")
public class Product implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String barCode;
    private String department;
    private Integer amount;

    @Transient
    public boolean isNew() {
        return id == null;
    }

}
