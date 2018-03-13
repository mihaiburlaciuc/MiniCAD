

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import main.*;
import main.Canvas;

import java.util.Collection;

public final class Main {
    public static final int ARG_ONE = 1;
    public static final int ARG_TWO = 2;
    public static final int ARG_THREE = 3;
    public static final int ARG_FOUR = 4;

    private Main() { }

    public static void main(final String[] args) {
        String inputFile = args[0];
        Integer numberOfForms;
        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            numberOfForms = Integer.parseInt(bufferedReader.readLine());
            boolean canvasCreated = false;
            Canvas canvas = null;
            FormFactory factory = FormFactory.getInstance();
            Collection<Form> formCollection = new ArrayList<>();

            for (int i = 0; i < numberOfForms; i++) {
                String formInformation = bufferedReader.readLine();

                if (!canvasCreated) {
                    String[] arguments = formInformation.split(" ");

                    canvas = new Canvas(Integer.parseInt(arguments[ARG_ONE]),
                            Integer.parseInt(arguments[ARG_TWO]),
                            ImageUtility.setColor(arguments[ARG_THREE],
                                    Integer.parseInt(arguments[ARG_FOUR])));
                    canvasCreated = true;
                } else {
                    Form tmpForm = factory.getForm(formInformation);
                    formCollection.add(tmpForm);
                }
            }

            BufferedImage img = new BufferedImage(canvas.getLength(),
                    canvas.getHeight(),
                    BufferedImage.TYPE_INT_ARGB);

            ImageUtility.drawCanvas(canvas, img);

            DrawVisitor drawer = new DrawVisitor(img);

            for (Form form : formCollection) {
                form.accept(drawer);
            }

            try {
                File drawing = new File("./drawing.png");
                ImageIO.write(img, "png", drawing);
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
