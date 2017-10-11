package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfo {

    private String username;
    private String address;

    public UserInfo(){

    }

    public UserInfo(String username, String address) {
        this.username = username;
        this.address = address;
    }
}
