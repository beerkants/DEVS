package kodlama.io.DevsDemo.business.concretes;

import kodlama.io.DevsDemo.business.abstracts.LanguageService;
import kodlama.io.DevsDemo.business.abstracts.TechnologyService;
import kodlama.io.DevsDemo.business.requests.language.CreateLanguageRequest;
import kodlama.io.DevsDemo.business.requests.language.UpdateLanguageRequest;
import kodlama.io.DevsDemo.business.responses.language.DeleteLanguageResponse;
import kodlama.io.DevsDemo.business.responses.language.LanguageListResponse;
import kodlama.io.DevsDemo.business.responses.language.LanguageResponse;
import kodlama.io.DevsDemo.business.responses.language.UpdateLanguageResponse;
import kodlama.io.DevsDemo.business.responses.technology.TechnologyListResponses;
import kodlama.io.DevsDemo.dataAccess.abstracts.LanguageDao;
import kodlama.io.DevsDemo.entities.Language;
import kodlama.io.DevsDemo.entities.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class LanguageManager implements LanguageService {

    private LanguageDao languageDao;
    private TechnologyService technologyService;

    @Autowired
    public LanguageManager(LanguageDao languageDao,TechnologyService technologyService) {
        this.languageDao = languageDao;
        this.technologyService = technologyService;
    }

    @Override
    public LanguageResponse add(CreateLanguageRequest createLanguageRequest) throws Exception {
        checkIfNameEmptyOrNull(createLanguageRequest.getName());
        checkNameDuplicated(createLanguageRequest.getName());

        LanguageResponse languageResponse = new LanguageResponse();
        Language language = new Language();
        List<Technology> technologies = new ArrayList<>();
        List<TechnologyListResponses> technologyListResponses = new ArrayList<>();

        language.setId(0);
        language.setName(createLanguageRequest.getName());

        for (Integer technologyId : createLanguageRequest.getTechnologiesIds()) {
            Technology technology = this.technologyService.getTechnologyById(technologyId);
            technologies.add(technology);
        }

        language.setTechnologies(technologies);
        this.languageDao.save(language);


        languageResponse.setName(language.getName());
        for ( Technology technology : technologies) {
            TechnologyListResponses technologyListItem = new TechnologyListResponses();
            technologyListItem.setId(technology.getId());
            technologyListItem.setName(technology.getName());
            technologyListResponses.add(technologyListItem);
        }
        languageResponse.setTechnologies(technologyListResponses);

        return languageResponse;
    }

    @Override
    public DeleteLanguageResponse delete(int id) throws Exception {

        checkIfIdValid(id);
        checkIfIdDoesNotExists(id);

        DeleteLanguageResponse deleteLanguageResponse = new DeleteLanguageResponse();
        Language language = this.languageDao.findById(id).get();
        deleteLanguageResponse.setName(language.getName());
        this.languageDao.deleteById(id);

        return deleteLanguageResponse;
    }

    @Override
    public UpdateLanguageResponse update(int id, UpdateLanguageRequest updateLanguageRequest) throws Exception {
        checkIfIdValid(id);
        checkIfIdDoesNotExists(id);
        checkIfNameEmptyOrNull(updateLanguageRequest.getName());
        checkNameDuplicated(updateLanguageRequest.getName());

        UpdateLanguageResponse updateLanguageResponse = new UpdateLanguageResponse();
        Language language = this.languageDao.findById(id).get();

        updateLanguageResponse.setOldName(language.getName());
        updateLanguageResponse.setNewName(updateLanguageRequest.getName());

        language.setName(updateLanguageRequest.getName());
        this.languageDao.save(language);

        return updateLanguageResponse;
    }

    @Override
    public LanguageResponse getById(int id) throws Exception {

        checkIfIdValid(id);
        checkIfIdDoesNotExists(id);

        List<TechnologyListResponses> technologyListResponses = new ArrayList<>();
        LanguageResponse languageResponse = new LanguageResponse();
        Language language = this.languageDao.findById(id).get();
        languageResponse.setName(language.getName());

        for (Technology technology:language.getTechnologies()) {
            TechnologyListResponses technologyListResponse = new TechnologyListResponses();
            technologyListResponse.setId(technology.getId());
            technologyListResponse.setName(technology.getName());
            technologyListResponses.add(technologyListResponse);
        }
        languageResponse.setTechnologies(technologyListResponses);

        return languageResponse;
    }

    @Override
    public List<LanguageListResponse> getAll() {

        List<LanguageListResponse> languageListResponses = new ArrayList<>();
        List<Language> languages = this.languageDao.findAll();

        for (Language language:languages) {
            LanguageListResponse languageListResponse = new LanguageListResponse();
            languageListResponse.setId(language.getId());
            languageListResponse.setName(language.getName());

            List<TechnologyListResponses> technologyListResponses = new ArrayList<>();
            for (Technology technology : language.getTechnologies()) {
                TechnologyListResponses technologyListResponse = new TechnologyListResponses();
                technologyListResponse.setId(technology.getId());
                technologyListResponse.setName(technology.getName());
                technologyListResponses.add(technologyListResponse);
            }
            languageListResponse.setTechnologies(technologyListResponses);
            languageListResponses.add(languageListResponse);
        }


        return languageListResponses;
    }


    /* ================= for me ======================== */
    private void checkIfIdValid(int id) throws Exception {
        if ( id < 0) {
            throw new Exception("invalid id");
        }
    }
    private void checkIfIdDoesNotExists(int id) throws Exception {
        if ( !this.languageDao.existsById(id)) {
            throw new Exception("id not found");
        }
    }
    private void checkNameDuplicated(String name) throws Exception {
        if (this.languageDao.existsByNameContainingIgnoreCase(name)) {
            throw new Exception("name already exists");
        }
    }
    private void checkIfNameEmptyOrNull(String name) throws Exception {
        if ( name.isEmpty() || name.isBlank() || Objects.isNull(name)) {
            throw new Exception("name cannot be empty");
        }
    }
}
