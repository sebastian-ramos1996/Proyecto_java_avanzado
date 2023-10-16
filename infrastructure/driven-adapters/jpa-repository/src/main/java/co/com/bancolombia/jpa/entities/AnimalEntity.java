package co.com.bancolombia.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "animals")
public class AnimalEntity {

    @Id private String id;
    @Column private int numeroPatas;
    @Column private Character genero;
    @Column private String especie;
    @Column private String habitad;
    @Column private boolean domestico;


}
