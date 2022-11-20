package kodlama.io.DevsDemo.webApi.controllers;

import kodlama.io.DevsDemo.business.abstracts.TechnologyService;
import kodlama.io.DevsDemo.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.DevsDemo.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.DevsDemo.business.responses.technology.TechnologyDeleteResponse;
import kodlama.io.DevsDemo.business.responses.technology.TechnologyListResponses;
import kodlama.io.DevsDemo.business.responses.technology.TechnologyResponse;
import kodlama.io.DevsDemo.business.responses.technology.UpdateTechnologyResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/technologies")
public class TechnologiesController {

    private TechnologyService technologyService;
    public TechnologiesController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }


    @PostMapping("/add")
    public TechnologyResponse add(@RequestBody CreateTechnologyRequest createTechnologyRequest) throws Exception {
        return this.technologyService.add(createTechnologyRequest);
    }

    @GetMapping("/getall")
    public List<TechnologyListResponses> getAll() {
        return this.technologyService.getAll();
    }

    @GetMapping("/getById")
    public TechnologyResponse getById (@RequestParam int id) throws Exception {
        return this.technologyService.getById(id);
    }

    @DeleteMapping("/delete")
    public TechnologyDeleteResponse delete(@RequestParam int id) throws Exception {
        return  this.technologyService.delete(id);
    }

    @PutMapping("/update")
    public UpdateTechnologyResponse update(@RequestParam int id, @RequestBody UpdateTechnologyRequest updateTechnologyRequest) throws Exception {
        return this.technologyService.update(id,updateTechnologyRequest);
    }

}
