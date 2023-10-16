package co.com.bancolombia.model.animales;


import lombok.*;


@Data
@Builder (toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor


public class Animal {
    private String id;
    private int numeroPatas;
    private Character genero;
    private String especie;
    private String habitad;
    private boolean domestico;

}
