package kodlama.io.DevsDemo.business.responses.technology;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTechnologyResponse {

    private String oldName;
    private String newName;
}
