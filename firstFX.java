import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class firstFX extends Application{

   public void start(Stage stage){
       final int WIDTH = 600;
       final int HEIGHT = 500;

       final double pi = 3.1415926535;

       final double CENTER = WIDTH/2.0;

       final double LOW_RAD = HEIGHT/6;
       final double MID_RAD = HEIGHT/9;
       final double TOP_RAD = HEIGHT/12;

       final double OVERLAP = HEIGHT/30;

       final double LOW_LOC = HEIGHT*.73;
       final double MID_LOC = LOW_LOC - LOW_RAD - MID_RAD + OVERLAP;
       final double TOP_LOC = LOW_LOC - LOW_RAD - 2*MID_RAD - TOP_RAD + 1.5*OVERLAP;

       Rectangle sky = new Rectangle(0, 0, WIDTH, HEIGHT*.65);
       sky.setFill(Color.LIGHTBLUE);

       Circle lower = new Circle(CENTER, LOW_LOC, LOW_RAD);
       lower.setStroke(Color.BLACK);
       lower.setFill(Color.WHITE);

       Circle middle = new Circle(CENTER, MID_LOC, MID_RAD);
       middle.setStroke(Color.BLACK);
       middle.setFill(Color.WHITE);

       Circle top = new Circle(CENTER, TOP_LOC, TOP_RAD);
       top.setStroke(Color.BLACK);
       top.setFill(Color.WHITE);

       Group body = new Group(lower, middle, top);

       //arms

       final double OFFCENTER = MID_RAD*.7;
       final double FROM_MIDDLE = MID_RAD*.6;

       final double LENGTH = MID_RAD*2.4;
       final double SLOPE = .5;

       final double START_LEFT_X = CENTER - OFFCENTER;
       final double START_RIGHT_X = CENTER + OFFCENTER;

       final double START_Y = MID_LOC - FROM_MIDDLE;

       final double END_LEFT_X = START_LEFT_X - (LENGTH / (SLOPE*SLOPE + 1));
       final double END_RIGHT_X = START_RIGHT_X + (LENGTH / (SLOPE*SLOPE + 1));

       final double END_Y = START_Y - (LENGTH*SLOPE / (SLOPE*SLOPE + 1));

       Line leftArm = new Line(START_LEFT_X, START_Y, END_LEFT_X, END_Y);
       Line rightArm = new Line(START_RIGHT_X, START_Y, END_RIGHT_X, END_Y);

       leftArm.setStrokeWidth(1.5);
       rightArm.setStrokeWidth(1.5);

       Group arms = new Group(leftArm, rightArm);

       // face

       //eyes

       final double size = TOP_RAD*.08;

       final double APART = TOP_RAD*.4;
       final double UP = TOP_RAD*.2;

       final double LEFT_EYE_X = CENTER - APART;
       final double RIGHT_EYE_X = CENTER + APART;

       final double EYE_Y = TOP_LOC - UP;

       Circle leftEye = new Circle(LEFT_EYE_X, EYE_Y, size);
       Circle rightEye = new Circle(RIGHT_EYE_X, EYE_Y, size);

       final double SMILE_Y = TOP_RAD*.7;
       final double SMILE_SIZE = 100;

       Arc smile = new Arc(CENTER, TOP_LOC, SMILE_Y, SMILE_Y,
                           270-SMILE_SIZE/2.0, 2*pi*SMILE_Y*SMILE_SIZE/180.0);

       smile.setStroke(Color.BLACK);
       smile.setFill(Color.WHITE);

       final double NOSE_SIZE = TOP_RAD*.08;
       final double NOSE_LENGTH = TOP_RAD*.39;
       final double NOSE_OFFSET = TOP_RAD*.07;
       final double NOSE_Y = TOP_LOC + TOP_RAD*.14;

       Color orange = Color.rgb(252, 119, 3);

       Polygon nose = new Polygon();
       nose.getPoints().addAll(new Double[] {
         CENTER-NOSE_OFFSET, NOSE_Y-NOSE_SIZE,
         CENTER-NOSE_OFFSET, NOSE_Y+NOSE_SIZE,
         CENTER-NOSE_OFFSET+NOSE_LENGTH, NOSE_Y});

      nose.setFill(orange);

      // hat!

      

       Group face = new Group(leftEye, rightEye, smile, nose);




       Group root = new Group(sky, body, arms, face);
       Scene scene = new Scene(root, WIDTH, HEIGHT, Color.WHITE);

       stage.setTitle("FXPractice");
       stage.setScene(scene);
       stage.show();
   }

   public static void main(String[] args){
       launch(args);
   }
}
