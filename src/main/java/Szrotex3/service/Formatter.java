package Szrotex3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

@Service
public class Formatter {

    Locale locale = new Locale("pl", "PL");

    @Autowired
    public Formatter() {

    }

    public String formatPrice(double price) {
        String.format("%10.0f", price);
        Currency currency = Currency.getInstance(locale);
        return String.format("%.0f", price) + " " + currency.getSymbol(locale);
    }

    public String formatDateHumainReadable(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("dd MMM, yyyy HH:mm", locale);
        return df.format(date);
    }


}
