package cz.buyorborrow.rest.dto.user;

import cz.buyorborrow.rest.model.user.PragueCityParts;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by ekishigo on 9.4.16.
 */
public class ProfileForm {

    @NotEmpty
    private String nickname;
    @NotEmpty
    private String phone;
    @NotEmpty
    private PragueCityParts locality;

    public ProfileForm() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public PragueCityParts getLocality() {
        return locality;
    }

    public void setLocality(PragueCityParts locality) {
        this.locality = locality;
    }
}
