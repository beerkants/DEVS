package kodlama.io.DevsDemo.webApi.controllers;


import kodlama.io.DevsDemo.business.abstracts.LanguageService;
import kodlama.io.DevsDemo.business.requests.language.CreateLanguageRequest;
import kodlama.io.DevsDemo.business.requests.language.UpdateLanguageRequest;
import kodlama.io.DevsDemo.business.responses.language.DeleteLanguageResponse;
import kodlama.io.DevsDemo.business.responses.language.LanguageListResponse;
import kodlama.io.DevsDemo.business.responses.language.LanguageResponse;
import kodlama.io.DevsDemo.business.responses.language.UpdateLanguageResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    private LanguageService languageService;
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping("/add")
    public LanguageResponse add(@RequestBody CreateLanguageRequest createLanguageRequest) throws Exception {
        return this.languageService.add(createLanguageRequest);
    }
    @DeleteMapping("/delete")
    public DeleteLanguageResponse delete(@RequestParam int id) throws Exception {
        return this.languageService.delete(id);
    }

    @PutMapping("/update")
    public UpdateLanguageResponse update(@RequestParam int id, @RequestBody UpdateLanguageRequest updateLanguageRequest) throws Exception {
        return this.languageService.update(id,updateLanguageRequest);
    }

    @GetMapping("/getById")
    public LanguageResponse getById(@RequestParam int id) throws Exception {
        return this.languageService.getById(id);
    }

    @GetMapping("/getall")
    public List<LanguageListResponse> getAll() {
        return this.languageService.getAll();
    }

}
