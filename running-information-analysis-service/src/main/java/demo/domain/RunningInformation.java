package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "RUNNING_ANALYSIS")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RunningInformation {

    @Id
    @GeneratedValue
    private String runningId;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "user_name")),
            @AttributeOverride(name = "address", column = @Column(name = "user_address"))
    })
    private UserInfo userInfo;
    @Embedded
    @AttributeOverride(name = "healthWarningLevel", column = @Column(name = "health_warning_level"))
    private HealthInfo healthinfo;

    private double latitude;
    private double longitude;
    private double runningDistance;
    private double totalRunningTime;

    private long heartRate;
    private Date timestamp = new Date();



    public RunningInformation(){
    }

    @JsonCreator
    public  RunningInformation(@JsonProperty("runningId") String runningId){
        this.runningId = runningId;
    }

    public RunningInformation(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
