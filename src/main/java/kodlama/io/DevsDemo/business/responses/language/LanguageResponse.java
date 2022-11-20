package kodlama.io.DevsDemo.business.responses.language;

import kodlama.io.DevsDemo.business.responses.technology.TechnologyListResponses;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LanguageResponse {
    private String name;
    private List<TechnologyListResponses> technologies;

}
