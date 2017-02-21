package com.itis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class PicturePrint extends JComponent implements Printable {
    Stroke lineStyle = new BasicStroke(2.0f);
    GeneralPath location = new GeneralPath();

    public PicturePrint() {
        enableEvents(AWTEvent.MOUSE_EVENT_MASK | AWTEvent.MOUSE_MOTION_EVENT_MASK);
        JButton button = new JButton("Print");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    printimg();
                }
            });
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3));
        this.add(button);
    }

    public void printimg() {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this, job.defaultPage());
        if (job.printDialog()) {
                try {
                    job.print();
                } catch (PrinterException e) {
                    System.err.println(e);
        }
    }
}

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        return 0;
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Print");
        PicturePrint picturePrint = new PicturePrint();
        jFrame.setSize(300,300);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.add(picturePrint);
        jFrame.setVisible(true);

    }
}

