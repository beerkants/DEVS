package kodlama.io.DevsDemo.business.abstracts;

import kodlama.io.DevsDemo.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.DevsDemo.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.DevsDemo.business.responses.technology.TechnologyDeleteResponse;
import kodlama.io.DevsDemo.business.responses.technology.TechnologyListResponses;
import kodlama.io.DevsDemo.business.responses.technology.TechnologyResponse;
import kodlama.io.DevsDemo.business.responses.technology.UpdateTechnologyResponse;
import kodlama.io.DevsDemo.entities.Technology;

import java.util.List;

public interface TechnologyService {

    TechnologyResponse add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
    List<TechnologyListResponses> getAll();
    TechnologyDeleteResponse delete(int id) throws Exception;
    TechnologyResponse getById(int id) throws Exception;
    UpdateTechnologyResponse update(int id, UpdateTechnologyRequest updateTechnologyRequest) throws Exception;

    // for me
    Technology getTechnologyById(int id);
}
