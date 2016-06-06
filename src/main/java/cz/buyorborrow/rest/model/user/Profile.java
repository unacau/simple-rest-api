package cz.buyorborrow.rest.model.user;

import static cz.buyorborrow.rest.utils.PreCondition.isTrue;
import static cz.buyorborrow.rest.utils.PreCondition.notEmpty;
import static cz.buyorborrow.rest.utils.PreCondition.notNull;

/**
 * Created by ekishigo on 31.3.16.
 */
public class Profile {

    public final static int MAX_NICKNAME_LENGTH =   25;
    public final static int     MAX_PHONE_LENGTH =      12;
    public final static String  ONLY_DIGITS_REGEXP =    "^[1-9]\\d*$";

    private String nickName;
    private String phone;
    private PragueCityParts locality;

    public Profile(String nickname, String phone, PragueCityParts locality)  {
        this.nickName = nickname;
        this.phone =    phone;
        this.locality = locality;
    }

    private void checkNickname(String nick) {
        if (nick != null) {
            notEmpty(nick, "Username can't be empty.");
            isTrue(nick.length() <= MAX_NICKNAME_LENGTH,
                    "Username should be shorter than %d chars",
                    MAX_NICKNAME_LENGTH);
        }
    }

    private void checkPhone(String phone) {
        if (phone != null) {
            notEmpty(phone, "Phone can't be empty");
            isTrue(phone.matches(ONLY_DIGITS_REGEXP), "Phone should contain only numbers");
            isTrue(phone.length() <= MAX_PHONE_LENGTH,
                    "Phone should be shorter than %d chars",
                    MAX_PHONE_LENGTH);
        }
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickname(String nickname) {
        notNull(nickname, "You can't set nickname as null.");
        checkNickname(nickname);
        this.nickName = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        notNull(phone, "You can't set phone as null.");
        checkPhone(phone);
        this.phone = phone;
    }

    public PragueCityParts getLocality() {
        return locality;
    }

    public void setLocality(PragueCityParts locality) {
        notNull(locality, "You can't set locality as null.");
        this.locality = locality;
    }

    @Override
    public String toString() {
        return String.format("Nickname is %s, telephone is %s, locality is %s", nickName, phone, locality);
    }
}
