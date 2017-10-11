package demo.service.impl;

import demo.domain.RunningInformation;
import demo.domain.RunningInformationRepository;
import demo.service.RunningInformationAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunningInformationAnalysisServiceImpl implements RunningInformationAnalysisService {

    private RunningInformationRepository runningInformationRepository;

    @Autowired
    public RunningInformationAnalysisServiceImpl(RunningInformationRepository runningInformationRepository) {
        this.runningInformationRepository = runningInformationRepository;
    }

    @Override
    public List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformation) {
        return runningInformationRepository.save(runningInformation);
    }

    @Override
    public void deleteALL() {
        runningInformationRepository.deleteAll();
    }

    @Override
    public void deleteByRunningId(String runningId) {
        runningInformationRepository.deleteByRunningId(runningId);
    }

    @Override
    public Page<RunningInformation> findByRunningId(String runningId, Pageable pageable) {
        return runningInformationRepository.findByRunningId(runningId, pageable);
    }

    @Override
    public Page<RunningInformation> findByHealthWarningLevel(String healthWarningLevel, Pageable pageable) {
        return runningInformationRepository.findAllOrderByHealthWarningLevelDesc(healthWarningLevel, pageable);
    }

}
