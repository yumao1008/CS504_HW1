package demo.service;

import demo.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RunningInformationAnalysisService {
    List<RunningInformation> saveRunningInformation(List<RunningInformation> runningInformation) ;
    void deleteALL();
    void deleteByRunningId(String runningId);
    Page<RunningInformation> findByRunningId(String runningId, Pageable pageable);
    Page<RunningInformation> findByHealthWarningLevel(String healthWarningLevel, Pageable pageable);
}
