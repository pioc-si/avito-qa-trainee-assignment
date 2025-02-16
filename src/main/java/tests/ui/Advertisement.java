package tests.ui;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Advertisement {
    private String name;
    private int price;
    private String description;
    private String url;
}
