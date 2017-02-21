package Treads;

import javax.swing.*;
import java.awt.*;
import java.io.PrintWriter;
import java.io.StringWriter;


public class ThreadLister {
    /** Отображаем информацию о потоке. */
    private static void printThreadInfo(PrintWriter out, Thread t,
                                        String indent) {
        if (t == null) return;
        out.println(indent + "Поток: " + t.getName() +
                "  Приоритет: " + t.getPriority() +
                (t.isDaemon()?" Демон":"") +
                (t.isAlive()?"":" Не активен"));
    }

    /** Отображаем информацию о группе потоков исполнения и содержащихся
     в ней группах и потоках */
    private static void printGroupInfo(PrintWriter out, ThreadGroup g,
                                       String indent) {
        if (g == null) return;
        int num_threads = g.activeCount();
        int num_groups = g.activeGroupCount();
        Thread[] threads = new Thread[num_threads];
        ThreadGroup[] groups = new ThreadGroup[num_groups];

        g.enumerate(threads, false);
        g.enumerate(groups, false);

        out.println(indent + " Группа потоков исполнения: " + g.getName() +
                "  Наивысший приоритет: " + g.getMaxPriority() +
                (g.isDaemon()?"Демон":""));

        for(int i = 0; i < num_threads; i++)
            printThreadInfo(out, threads[i], indent + "    ");
        for(int i = 0; i < num_groups; i++)
            printGroupInfo(out, groups[i], indent + "    ");
    }

    /** Находим корневую группу и рекурсивно распечатываем ее содержимое */
    public static void listAllThreads(PrintWriter out) {
        ThreadGroup current_thread_group;
        ThreadGroup root_thread_group;
        ThreadGroup parent;

        // Получаем группу текущего потока исполнения
        current_thread_group = Thread.currentThread().getThreadGroup();

        // Теперь ищем корневую группу
        root_thread_group = current_thread_group;
        parent = root_thread_group.getParent();
        while(parent != null) {
            root_thread_group = parent;
            parent = parent.getParent();
        }

        // И рекурсивно ее распечатываем
        printGroupInfo(out, root_thread_group, "");
    }
    /**
     * Метод main() создает простой графический интерфейс пользователя
     * для отображения потоков исполнения. Это позволяет нам увидеть
     * потоки исполнения, занимающиеся диспетчеризацией событий
     * ("event dispatch thread"), используемые в AWT и Swing.
     **/
    public static void main(String[] args) {
        // Создаем простой интерфейс Swing GUI
        JFrame frame = new JFrame("ThreadLister Demo");
        JTextArea textarea = new JTextArea();
        frame.getContentPane().add(new JScrollPane(textarea),
                BorderLayout.CENTER);
        frame.setSize(500, 400);
        frame.setVisible(true);
        // Получаем строку threadlisting (распечатку потоков исполнения)
        // при помощи потока (stream) символьного вывода StringWriter
        StringWriter sout = new StringWriter();  // Для приема листинга
        PrintWriter out = new PrintWriter(sout);
        ThreadLister.listAllThreads(out);  // Выводим список потоков
        // исполнения в поток ввода/вывода
        out.close();
        String threadListing = sout.toString();  // Получаем листинг
        // в виде строки
        // Наконец, отображаем распечатку при помощи GUI
        textarea.setText(threadListing);
    }
}
