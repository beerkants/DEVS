package kodlama.io.DevsDemo.business.requests.language;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateLanguageRequest {

    private String name;
    private List<Integer> technologiesIds;
}
