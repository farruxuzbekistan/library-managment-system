import java.util.Scanner;

public class AuthService {
    private final LibraryService libraryService;
    private final Scanner scanner;

    public AuthService(LibraryService libraryService, Scanner scanner) {
        this.libraryService = libraryService;
        this.scanner = scanner;
    }

    public User registerUser(){
        System.out.println("Ismingizni kiriting: ");
        String name = scanner.nextLine();
        System.out.println("ID raqamingizni kiriting: ");
        String userId = scanner.nextLine();

        if (libraryService.userExists(name, userId)){
            System.out.println("Bu username yoki id orqali allaqchon ro'yxatdan o'tilgan, iltimos boshqa username yoki id kiriting. ");
            return null;
        } else {
            System.out.println("Parolni kiriting: ");
            String password = scanner.nextLine();

            String role;

            while (true){
                System.out.println("Talaba yoki Mehmon?: ");
                role = scanner.nextLine();
                if (role.equals("Talaba") || role.equals("Mehmon")){
                    break;
                } else {
                    System.out.println("Iltimos talaba yoki Mehmon deb kiriting");
                }
            }

            User user = new User(userId, name, role, password);
            libraryService.addUser(user);
            System.out.println("Ro'yxatdan o'tildi");
            return user;
        }
    }

    public User loginUser(){
        System.out.println("Kirish uchun ismingizni kiriting: ");
        String name = scanner.nextLine();

        User user = libraryService.findUserByName(name);

        if (user != null){
            System.out.println("Parolni kiriting: ");
            String password = scanner.nextLine();
            if (user.getPassword().equals(password)){
                System.out.println("Xush kelibsiz " + user.getName() + "!");
                return user;
            } else {
                System.out.println("Parol xato, qaytadan urinib ko'ring");
                return null;
            }
        } else {
            System.out.println("Ro'yxatdan o'tmagan, avval  ro'yxatdan o'ting");

        }
        return null;

    }

    public void resetPassword(User user){
        if (user == null){
            System.out.println("Ro'yxatdan o'tmagan");
            return;
        }

        System.out.println("Hozirgi parolingizni kiriting: ");
        String oldPassword = scanner.nextLine();
        if (user.getPassword().equals(oldPassword)){
            System.out.println("Yangi parolni kiriting: ");
            String newPassword = scanner.nextLine();
            user.setPassword(newPassword);
            System.out.println("Parol muvaffaqiyatli yangilandi");
        } else {
            System.out.println("Parol xato, qaytadan urinib ko'ring");
        }
    }
}
