package org.example;


import java.awt.*;

//Can plan out interface on Paint for ex and use dimensions for plotting shapes, e.g. the triangles.
public class Paintbrush {
    private static final Color ALIZARIN_CRIMSON = new Color(78, 21, 0);
    private static final Color BRIGHT_RED = new Color(219, 0, 0);
    private static final Color CADMIUM_YELLOW = new Color(255, 236, 0);
    private static final Color DARK_SIENNA = new Color(95, 46, 31);
    private static final Color INDIAN_YELLOW = new Color(255, 184, 0);
    private static final Color MIDNIGHT_BLACK = new Color(0, 0, 0);
    private static final Color PHTHALO_BLUE = new Color(12, 0, 64);
    private static final Color PHTHALO_GREEN = new Color(16, 46, 60);
    private static final Color PRUSSIAN_BLUE = new Color(2, 30, 68);
    private static final Color SAP_GREEN = new Color(10, 52, 16);
    private static final Color TITANIUM_WHITE = new Color(255, 255, 255);
    private static final Color VAN_DYKE_BROWN = new Color(34, 27, 21);
    private static final Color YELLOW_OCHRE = new Color(199, 155, 0);

    private Graphics g;
    public Paintbrush(Graphics g) {
        this.g = g;
    }

    public void drawSky() {
        //create sky along top of window
        g.setColor(new Color(157,233,245));
        g.fillRect(0,0,900,220);
        //create yellow sun
        g.setColor(Color.yellow);
        g.fillOval(650,30,60,60);
    }

    public void drawMountains() {
        //draw a mountain
        g.setColor(VAN_DYKE_BROWN);
        Polygon triangle = new Polygon();
        triangle.addPoint(15,450); //bottom-left
        triangle.addPoint(340,60); //top
        triangle.addPoint(500,450); //bottom-irght
        g.fillPolygon(triangle);

        Color mountainMix = blend(VAN_DYKE_BROWN, YELLOW_OCHRE, 0.15f);
        g.setColor(mountainMix);
        Polygon second = new Polygon();
        second.addPoint(280,445);
        second.addPoint(435,170);
        second.addPoint(475,280);
        second.addPoint(580,120);
        second.addPoint(755,520);
        g.fillPolygon(second);

    }

    public void drawTree(){
        //draw the tree trunk
        Color trunk = blend(VAN_DYKE_BROWN, CADMIUM_YELLOW, 0.21f);
        g.setColor(trunk);
        g.fillRect(790,420,26,140);

        //draw the leaves
        Color leaf = blend(SAP_GREEN, PHTHALO_GREEN, 0.11f);
        g.setColor(leaf);

        //draw 5 levels of leaves
        for (int i = 0; i < 5; i++){
            Polygon triangle = new Polygon();
            int height = 50;
            int width = 70;
            int spacing = 15; //adds 5 layres of trainagles in loop
            float rate = 0.26f; //how wide each branch should grow each time downwards
            float growth = 1 + (rate * i);

            triangle.addPoint(803,310 + (spacing * i)); //top
            triangle.addPoint(
                    Math.round(803 - (width)/2 * growth),
                    Math.round(310 + height + (spacing * i) * growth)
            ); //bottom-left
            triangle.addPoint(
                    Math.round(803 + (width)/2 * growth),
                    Math.round(310 + height + (spacing * i) * growth)
            );//bottom-right

            g.fillPolygon(triangle);
        }
    }

    public void drawGrass() {
        //create a gradient from top to bottom
        Color grassFarMix = blend(SAP_GREEN, PHTHALO_BLUE, 0.414f);
        Color grassNearMix = blend(SAP_GREEN, TITANIUM_WHITE, 0.165f);
        GradientPaint grassMix = new GradientPaint(0,0,grassFarMix,0,500,grassNearMix);

        //have to cast Graphics to Graphics 2D to use the gradient
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(grassMix);
        g2.fillRect(0, 220, 900, 600);
    }

    /*
    public void finishingTouches(){
        try {
            BufferedImage img = ImageIO.read(new File("mountain_sunset.jpeg"));
            g.drawImage(img, 0, 0, null);
        } catch (IOException e) {
            System.out.println("Error opening image file");
        }
    }
     */

    // https://stackoverflow.com/a/20332789/4655368
    private Color blend(Color c1, Color c2, float ratio) {
        if ( ratio > 1f ) ratio = 1f;
        else if ( ratio < 0f ) ratio = 0f;
        float iRatio = 1.0f - ratio;

        int i1 = c1.getRGB();
        int i2 = c2.getRGB();

        int a1 = (i1 >> 24 & 0xff);
        int r1 = ((i1 & 0xff0000) >> 16);
        int g1 = ((i1 & 0xff00) >> 8);
        int b1 = (i1 & 0xff);

        int a2 = (i2 >> 24 & 0xff);
        int r2 = ((i2 & 0xff0000) >> 16);
        int g2 = ((i2 & 0xff00) >> 8);
        int b2 = (i2 & 0xff);

        int a = (int)((a1 * iRatio) + (a2 * ratio));
        int r = (int)((r1 * iRatio) + (r2 * ratio));
        int g = (int)((g1 * iRatio) + (g2 * ratio));
        int b = (int)((b1 * iRatio) + (b2 * ratio));

        return new Color( a << 24 | r << 16 | g << 8 | b );
    }


}
