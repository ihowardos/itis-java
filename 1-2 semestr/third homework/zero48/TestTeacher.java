//package O48;
package new48;

//import O48.Teacher;

/**
 * Created by ihowardos on 04.12.2015.
 */
public class TestTeacher {
    public static void main(String[] args) {
       Teacher t = new Teacher("Калимуллин Искандер Шагитович", "Дискретная математика");
        t.setName("Корнеева Наталья Николаевна");
        System.out.println(t.getName());
        t.setSubject("дискретная математика");
        System.out.println(t.getSubject());
        t.Mark("Сергей Антонов");
 

    }
}
