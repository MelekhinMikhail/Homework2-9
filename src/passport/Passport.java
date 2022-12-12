package passport;

import java.util.Arrays;

public class Passport {
    private String number;
    private String name;
    private String surname;
    private String patronymic;
    private String dateOfBirth;

    public Passport(String number, String name, String surname, String patronymic, String dateOfBirth) {
        if (number == null || number.isEmpty() || number.isBlank()) throw new IllegalArgumentException("Поле Паспорт должно быть заполнено!");
        else this.number = number;
        if (name == null || name.isEmpty() || name.isBlank()) throw new IllegalArgumentException("Поле Имя должно быть заполнено!");
        else this.name = name;
        if (surname == null || surname.isEmpty() || surname.isBlank()) throw new IllegalArgumentException("Поле Фамилия должно быть заполнено!");
        else this.surname = surname;
        if (patronymic == null || patronymic.isEmpty() || patronymic.isBlank()) throw new IllegalArgumentException("Поле Паспорт должно быть заполнено!");
        else this.patronymic = patronymic;
        if (!isDateOfBirthCorrect(dateOfBirth)) throw new IllegalArgumentException("Дата Рождения должна быть в формате ДД:ММ:ГГГГ");
        else this.dateOfBirth = dateOfBirth;
    }

    public Passport(String number, String name, String surname, String dateOfBirth) {
        this(number, name, surname, "none", dateOfBirth);
    }

    public static boolean isDateOfBirthCorrect(String date) {
        if (date.length() != 10) return false;
        char[] enableChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] dateChar = date.toCharArray();
        int a = 0;
        for (int i=0; i<dateChar.length; i++) {
            if (i != 2 && i != 5) {
                for (int j=0; j<enableChar.length; j++) {
                    if (dateChar[i] == enableChar[j]) a++;
                }
            } else if (dateChar[i] == '.') a++;
        }
        return a==10;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty() || name.isBlank()) throw new IllegalArgumentException("Поле Имя должно быть заполнено!");
        else this.name = name;
    }

    public void setSurname(String surname) {
        if (surname == null || surname.isEmpty() || surname.isBlank()) throw new IllegalArgumentException("Поле Фамилия должно быть заполнено!");
        else this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        if (patronymic == null || patronymic.isEmpty() || patronymic.isBlank()) throw new IllegalArgumentException("Поле Паспорт должно быть заполнено!");
        else this.patronymic = patronymic;
    }

    public void setDateOfBirth(String dateOfBirth) {
        if (!isDateOfBirthCorrect(dateOfBirth)) throw new IllegalArgumentException("Дата Рождения должна быть в формате ДД:ММ:ГГГГ");
        else this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Номер паспорта: "+getNumber()+"   " +
                "Имя: "+getName()+"   " +
                "Фамилия: "+getSurname()+"   " +
                "Отчество: "+((getPatronymic().equals("none")) ? "остутствует" : getPatronymic())+"   " +
                "Дата рождения: "+getDateOfBirth();
    }
}
