package kodlama.io.DevsDemo.business.concretes;

import kodlama.io.DevsDemo.business.abstracts.TechnologyService;
import kodlama.io.DevsDemo.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.DevsDemo.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.DevsDemo.business.responses.technology.TechnologyDeleteResponse;
import kodlama.io.DevsDemo.business.responses.technology.TechnologyListResponses;
import kodlama.io.DevsDemo.business.responses.technology.TechnologyResponse;
import kodlama.io.DevsDemo.business.responses.technology.UpdateTechnologyResponse;
import kodlama.io.DevsDemo.dataAccess.abstracts.TechnologyDao;
import kodlama.io.DevsDemo.entities.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TechnologyManager implements TechnologyService {

    private TechnologyDao technologyDao;

    @Autowired
    public TechnologyManager(TechnologyDao technologyDao) {
        this.technologyDao = technologyDao;
    }


    /* =================== service methods =========================== */
    @Override
    public TechnologyResponse add(CreateTechnologyRequest createTechnologyRequest) throws Exception {

        checkIfNameEmptyOrNull(createTechnologyRequest.getName());
        checkIfNameDuplicated(createTechnologyRequest.getName());

        Technology technology = new Technology();
        TechnologyResponse technologyResponse = new TechnologyResponse();

        technology.setId(0);
        technology.setName(createTechnologyRequest.getName());

        this.technologyDao.save(technology);

        technologyResponse.setName(technology.getName());

        return technologyResponse;
    }

    @Override
    public List<TechnologyListResponses> getAll() {
        List<TechnologyListResponses> technologyListResponses = new ArrayList<>();
        List<Technology> technologies = this.technologyDao.findAll();

        for (Technology technology:technologies) {
            TechnologyListResponses technologyListItem = new TechnologyListResponses();
            technologyListItem.setId(technology.getId());
            technologyListItem.setName(technology.getName());
            technologyListResponses.add(technologyListItem);
        }
        return technologyListResponses;
    }

    @Override
    public TechnologyDeleteResponse delete(int id) throws Exception {
        checkIfIdValid(id);
        checkIfIdExists(id);
        TechnologyDeleteResponse technologyDeleteResponse = new TechnologyDeleteResponse();
        Optional<Technology> technology = this.technologyDao.findById(id);
        technologyDeleteResponse.setName(technology.get().getName());
        this.technologyDao.deleteById(id);
        return technologyDeleteResponse;
    }

    @Override
    public TechnologyResponse getById(int id) throws Exception {
        checkIfIdValid(id);
        checkIfIdExists(id);
        Technology technology = this.technologyDao.findById(id).get();
        TechnologyResponse technologyResponse = new TechnologyResponse();
        technologyResponse.setName(technology.getName());
        return technologyResponse;
    }

    @Override
    public UpdateTechnologyResponse update(int id, UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
        checkIfIdValid(id);
        checkIfIdExists(id);
        UpdateTechnologyResponse updateTechnologyResponse = new UpdateTechnologyResponse();
        Optional<Technology> technology = this.technologyDao.findById(id);
        updateTechnologyResponse.setOldName(technology.get().getName());
        updateTechnologyResponse.setNewName(updateTechnologyRequest.getName());

        technology.get().setName(updateTechnologyRequest.getName());
        this.technologyDao.save(technology.get());
        return updateTechnologyResponse;
    }

    @Override
    public Technology getTechnologyById(int id) {
        Optional<Technology> technology = this.technologyDao.findById(id);
        return technology.get();
    }



    /* =================== for me ============================ */
    private void checkIfNameDuplicated(String name) throws Exception {
        if (this.technologyDao.existsByNameContainingIgnoreCase(name)) {
            throw new Exception("name already exists");
        }
    }
    private void checkIfIdExists(int id) throws Exception {
        if (!this.technologyDao.existsById(id)) {
            throw  new Exception("id not found");
        }
    }
    private void checkIfIdValid(int id) throws Exception{
        if (id < 0 ) {
            throw new Exception("id cannot be less than zero\n");
        }
    }
    private void checkIfNameEmptyOrNull(String name) throws Exception {
        if (name.isEmpty() || name.isBlank())  {
            throw new Exception("name cannot be empty");
        }
    }
}
