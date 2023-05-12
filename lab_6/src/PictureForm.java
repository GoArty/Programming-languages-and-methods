import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class PictureForm {
    private JPanel mainPanel;
    private JSpinner aSpinner;
    private CanvasPanel canvasPanel;
    private JSpinner bSpinner;
    private JSpinner color1Spinner;
    private JSpinner color2Spinner;
    private JSpinner color3Spinner;
    public PictureForm() {
        aSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int a = (int) aSpinner.getValue();
                canvasPanel.setA(a);
            }
        });
        bSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int b = (int) bSpinner.getValue();
                canvasPanel.setB(b);
            }
        });
        color1Spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int b = (int) color1Spinner.getValue();
                canvasPanel.setColor1(b);
            }
        });
        color2Spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int b = (int) color2Spinner.getValue();
                canvasPanel.setColor2(b);
            }
        });
        color3Spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int b = (int) color3Spinner.getValue();
                canvasPanel.setColor3(b);
            }
        });
        aSpinner.setValue(20);
        bSpinner.setValue(20);
        color1Spinner.setValue(0);
        color2Spinner.setValue(0);
        color1Spinner.setValue(0);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Прямоугольный треугольник, вписанный в окружность");
        frame.setContentPane(new PictureForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
