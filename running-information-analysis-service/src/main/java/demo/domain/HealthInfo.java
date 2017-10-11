package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HealthInfo {
    private String healthWarningLevel;

    public HealthInfo(){}

    public HealthInfo(long heartRate){

        if(heartRate >= 60 && heartRate <= 75){
            this.healthWarningLevel = "LOW";
        }else if(heartRate >= 75 && heartRate <= 120){
            this.healthWarningLevel = "NORMAL";
        }else if(heartRate >= 120 ){
            this.healthWarningLevel = "HIGH";
        }else{
            this.healthWarningLevel = "ERROR";
        }
    }
}
