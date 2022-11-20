package kodlama.io.DevsDemo.business.abstracts;

import kodlama.io.DevsDemo.business.requests.language.CreateLanguageRequest;
import kodlama.io.DevsDemo.business.requests.language.DeleteLanguageRequest;
import kodlama.io.DevsDemo.business.requests.language.UpdateLanguageRequest;
import kodlama.io.DevsDemo.business.responses.language.DeleteLanguageResponse;
import kodlama.io.DevsDemo.business.responses.language.LanguageListResponse;
import kodlama.io.DevsDemo.business.responses.language.LanguageResponse;
import kodlama.io.DevsDemo.business.responses.language.UpdateLanguageResponse;

import java.util.List;

public interface LanguageService {

    LanguageResponse add(CreateLanguageRequest createLanguageRequest) throws Exception;
    DeleteLanguageResponse delete(int id) throws Exception;
    UpdateLanguageResponse update(int id , UpdateLanguageRequest updateLanguageRequest) throws Exception;
    LanguageResponse getById(int id) throws Exception;
    List<LanguageListResponse> getAll();

}
