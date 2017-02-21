package new48;

/**
 * Created by ihowardos on 04.12.2015.
 */
public class Teacher {
    private String name;
    private String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;

    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void Mark(String namestudent) {
        int mark = (int) Math.round(Math.random() * 3 + 2);
        String markr = null;
        if (mark == 2) markr = "неудовлетворительно";
        if (mark == 3) markr = "удовлетворительно";
        if (mark == 4) markr = "хорошо";
        if (mark == 5) markr = "отлично";
        System.out.println("Преподаватель " + name + " оценил студента с именем " + namestudent + " по предмету " + subject + " на оценку " + markr + ".");
    }
}
