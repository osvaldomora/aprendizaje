package osvaldo.morales.company.demo.api.dto.request;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductRequest {

    private Long id;
    private String name;
    private String price;
}
