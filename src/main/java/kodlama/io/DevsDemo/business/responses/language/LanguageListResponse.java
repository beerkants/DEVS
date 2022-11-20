package kodlama.io.DevsDemo.business.responses.language;

import kodlama.io.DevsDemo.business.responses.technology.TechnologyListResponses;
import kodlama.io.DevsDemo.entities.Technology;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LanguageListResponse {
    private int id;
    private String name;

    private List<TechnologyListResponses> technologies;
}
