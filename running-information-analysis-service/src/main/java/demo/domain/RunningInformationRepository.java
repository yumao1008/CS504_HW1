package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface RunningInformationRepository extends JpaRepository<RunningInformation, Long> {

    void deleteByRunningId(String runningId);

    Page<RunningInformation> findAllOrderByHealthWarningLevelDesc(@Param("healthWarningLevel") String healthWarningLevel, Pageable pageable);

    Page<RunningInformation> findAll(@Param("healthWarningLevel") Sort healthWarningLevel, Pageable pageable);

    Page<RunningInformation> findByRunningId(@Param("runningId") String runningId , Pageable pageable);
}
