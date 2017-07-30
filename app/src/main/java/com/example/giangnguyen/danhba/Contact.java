package com.example.giangnguyen.danhba;

/**
 * Created by Giang Nguyen on 28/07/2017.
 */

public class Contact {

    String nName, nNumber;
    boolean isMale;

    public Contact(String nName, String nNumber, boolean isMale) {
        this.nName = nName;
        this.nNumber = nNumber;
        this.isMale = isMale;
    }

    public String getnName() {
        return nName;
    }

    public void setnName(String nName) {
        this.nName = nName;
    }

    public String getnNumber() {
        return nNumber;
    }

    public void setnNumber(String nNumber) {
        this.nNumber = nNumber;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }
}
