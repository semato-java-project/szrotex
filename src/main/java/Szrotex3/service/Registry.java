package Szrotex3.service;

import Szrotex3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Registry implements ServiceInterface {

    private User signedUser = null;

    @Autowired
    public Registry() {

    }

    public String getName() {
        return "registry";
    }

    public User getSignedUser() {
        return signedUser;
    }

    public void setSignedUser(User signedUser) {
        this.signedUser = signedUser;
    }

}
