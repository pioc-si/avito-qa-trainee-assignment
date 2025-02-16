package tests.ui.generators;

import lombok.Builder;
import lombok.Data;
import tests.ui.Advertisement;

@Builder
@Data
public class TestData {
    private Advertisement advertisement;
}
