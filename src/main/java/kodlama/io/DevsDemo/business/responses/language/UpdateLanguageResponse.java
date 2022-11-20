package kodlama.io.DevsDemo.business.responses.language;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLanguageResponse {

    private String oldName;
    private String newName;
}
