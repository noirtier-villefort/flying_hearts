import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Drawer extends JPanel {

    private int x, y=500;
    int width;
    int height;

    Random rnd = new Random();
    BufferedImage images[];
    BufferedImage text;

    ArrayList<Sticker> stickers = new ArrayList();

    public Drawer() throws IOException {
        super();

        width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        setSize(width+2100,height+5100);
        setOpaque(true);
        setBackground(new Color(0,0,0,125));

        // Images =====================================================================
        try {
            //heart1 = ImageIO.read(new File("src/main/java/heart1.png"));
            text = ImageIO.read(new File("src/main/java/text.png"));

                    images = new BufferedImage[]{
                    ImageIO.read(new File("src/main/java/heart1.png")),
                    ImageIO.read(new File("src/main/java/heart3.png")),
                    ImageIO.read(new File("src/main/java/heart4.png")),
                    ImageIO.read(new File("src/main/java/heart5.png")),
                    ImageIO.read(new File("src/main/java/heart6.png")),
                    ImageIO.read(new File("src/main/java/smile1.png")),
                    ImageIO.read(new File("src/main/java/kiss1.png"))
            };
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // ============================================================================


        // Stickers ===================================================================
        for(int i=0;i<=10000;i++){
            int size = rnd.nextInt(100)+20;
            Sticker sticker = new Sticker(-50+rnd.nextInt(width), (500+rnd.nextInt(5000)), size,size, images[rnd.nextInt(7)]);
            System.out.println("Sticker: x:"+sticker.getX()+", y:"+sticker.getY()+", width:"+sticker.getWidth()+", height:"+sticker.getheight());
            stickers.add(sticker);
        }
        // ============================================================================


        Timer timer = new Timer(2, e -> { y-=1; repaint(); });
        timer.start();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
       // g2d.setClip(0,0, width, height+height);

        g2d.drawImage(text, width/2-250,height/2-100,500,200,null);

        for(Sticker sticker: stickers){
            g2d.drawImage(sticker.getImage(), sticker.getX(), sticker.getY()+y, sticker.getWidth(), sticker.getheight(), null);
        }

    //    g2d.drawImage(image, 100, y, 100, 100,null);
      //  g2d.drawImage(image, 150, 150-y, 100, 100,null);
     //   g2d.dispose();
    }


}
