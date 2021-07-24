package circle;

import java.util.Scanner;

public class Human {


    public static void main(String[] args) {
//         final String SURNAME = "Shvetc";
//         final String NAME = "Alexandr";
         final String PATRONYMIC = "Dmitrievich";
//        Human human = new Human(SURNAME, NAME);
//        human.getFullName();
//        human.getShortName();
//
//
//
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Last Name:");
        String surname =sc.nextLine();
        System.out.println("Enter First Name:");
        String name =sc.nextLine();
        System.out.println("Enter Patronymic Name:");
        String patronymic =sc.nextLine();
       Human human1 = new Human(surname,name,patronymic);
       human1.getFullName();
       human1.getShortName();


//        System.out.println(human1.toString());
    }

    private String surname;
    private String name;
    private String patronymic;

    public Human(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    public Human(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public void getShortName(){

        if (patronymic==null){
            char nameChar = name.charAt(0);
            System.out.println("Human: " + surname + " " + nameChar);
        }else {
            char nameChar = name.charAt(0);
            char patronymicChar = patronymic.charAt(0);
            System.out.println("Human: " + surname + " " + nameChar + " " + patronymicChar);
        }
    }


    public void getFullName() {
        if (patronymic==null){
            System.out.println("Human: " + surname + " " + name );
        }else {
            System.out.println("Human: " + surname + " " + name + " " + patronymic);
        }
    }
}

