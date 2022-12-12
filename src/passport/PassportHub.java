package passport;

import java.util.LinkedList;
import java.util.List;

public class PassportHub {
    private List<Passport> list;

    public PassportHub() {
        list = new LinkedList<>();
    }

    public void addPassport(Passport passport) {
        boolean duplicateFound = false;
        if (passport == null) throw new IllegalArgumentException();
        if (list.size() == 0) list.add(passport);
        else {
            for (Passport p : list) {
                if (p.getNumber().equals(passport.getNumber())){
                    p.setName(passport.getName());
                    p.setSurname(passport.getSurname());
                    p.setPatronymic(passport.getPatronymic());
                    p.setDateOfBirth(passport.getDateOfBirth());
                    duplicateFound = true;
                }
            }
            if (!duplicateFound) list.add(passport);
        }
    }

    public Passport getPassportByNumber(String number) {
        if (number == null || number.isEmpty() || number.isBlank()) throw new IllegalArgumentException();
        for (Passport p : list) {
            if (p.getNumber().equals(number)) return p;
        }
        return null;
    }

    public void printPassportHub() {
        for (Passport p : list) {
            System.out.println(p);
        }
    }

    public List<Passport> getList() {
        return list;
    }
}
