package demo.RunningInformationAnalysisController;

import demo.domain.RunningInformation;
import demo.service.RunningInformationAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class RunningInformationAnalysisController {

    private RunningInformationAnalysisService runningInformationAnalysisService;

    @Autowired
    public RunningInformationAnalysisController(RunningInformationAnalysisService runningInformationAnalysisService){
        this.runningInformationAnalysisService = runningInformationAnalysisService;
    }

    @RequestMapping(value = "/running", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(List<RunningInformation> runningInformation){
        this.runningInformationAnalysisService.saveRunningInformation(runningInformation);
    }

    @RequestMapping(value = "/running/{id}", method = RequestMethod.DELETE)
    public void purge(){
        this.runningInformationAnalysisService.deleteByRunningId("id");
    }

    @RequestMapping(value = "/running/runningId/{runningId}", method = RequestMethod.GET)
    public Page<RunningInformation> findByHealthWarningLevel(@PathVariable String runningId, @RequestParam(name = "page") int page, @RequestParam(name = "size") int size){
        return this.runningInformationAnalysisService.findByHealthWarningLevel(runningId, new PageRequest(page, 2));
    }

}
