import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Main m = new Main();
        Random rnd = new Random();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
                int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

                JFrame f = new JFrame("Exampel");
                // on ESC key close frame
                f.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                        KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
                f.getRootPane().getActionMap().put("Cancel", new AbstractAction()
                {

                    public void actionPerformed(ActionEvent e)
                    {
                        System.exit(0);
                        //framename.setVisible(false);
                    }
                });

                f.setLayout(new BorderLayout());
                f.setBounds(width,height,width,height);
                   f.setUndecorated(true);
                    f.setBackground(new Color(0,0,0,0));
                f.setExtendedState(JFrame.MAXIMIZED_BOTH);
                f.setVisible(true);


                try {
                    Drawer drawer = new Drawer();
                    f.add(drawer);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

}
