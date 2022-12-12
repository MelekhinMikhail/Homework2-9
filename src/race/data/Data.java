package race.data;

public class Data {
    public static boolean check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        String validCharacters = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890_";
        char[] validChar = validCharacters.toCharArray();

        if (login == null || login.isEmpty() || login.isBlank()) throw new WrongLoginException("Поле Логин должно быть заполнено");
        if (login.length() > 20) throw new WrongLoginException("Длина логина должна быть от 1 до 20");
        char[] loginChar = login.toCharArray();
        int a = 0;
        for (char c : loginChar) {
            for (char value : validChar) {
                if (c == value) a++;
            }
        }
        if (a != loginChar.length) throw new WrongLoginException("Логин содержит недопустимые символы");

        if (password == null || password.isEmpty() || password.isBlank()) throw new WrongPasswordException("Поле Пароль должно быть заполнено");
        if (password.length() > 20) throw new WrongPasswordException("Длина пароля должна быть от 1 до 20");
        char[] passwordChar = password.toCharArray();
        int b = 0;
        for (char d : passwordChar) {
            for (char v : validChar){
                if (d == v) b++;
            }
        }
        if (b != passwordChar.length) throw new WrongPasswordException("Пароль содержит недопустимые символы");
        if (!password.equals(confirmPassword)) throw new WrongPasswordException("Пароли не совпадают");

        return true;
    }

}
