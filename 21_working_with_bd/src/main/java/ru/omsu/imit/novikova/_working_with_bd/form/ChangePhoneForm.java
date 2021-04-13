package ru.omsu.imit.novikova._working_with_bd.form;

public class ChangePhoneForm {
    private String oldPhone;
    private String newPhone;

    public ChangePhoneForm(String oldPhone, String newPhone) {
        this.oldPhone = oldPhone;
        this.newPhone = newPhone;
    }

    public String getOldPhone() {
        return oldPhone;
    }

    public String getNewPhone() {
        return newPhone;
    }
}
