package Szrotex3.service;

import Szrotex3.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

@Service
public class Authorisation {

    private HibernateSession hibernateSession;

    @Autowired
    public Authorisation(HibernateSession hibernateSession) {

        this.hibernateSession = hibernateSession;
    }

    public String md5Hash(String input) {

        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("MD5 algorithm not found.");
            System.exit(-1);
        }

        md.update(input.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter.printHexBinary(digest);

        return hash;
    }

    public String generateHashedPassword(String rawPassword, String salt) {

        return this.md5Hash(rawPassword + salt);
    }

    public String createSalt() {

        byte[] array = new byte[7];
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        return this.md5Hash(generatedString);
    }

    public User getAuthorizedUser(String email, String rawPassword) throws InvalidCredentialsException{

        Session session = this.hibernateSession.getSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("email", email));
        User user = (User) criteria.uniqueResult();

        String hashedPassword = this.generateHashedPassword(rawPassword, user.getSalt());

        if (hashedPassword != user.getPassword()) {
            throw new InvalidCredentialsException("Invalid credentials.");
        }

        return user;
    }

    public class InvalidCredentialsException extends SecurityException {
        public InvalidCredentialsException(String message) {
            super(message);
        }
    }



}
