/**
 * Use the graphics package to draw a simple face of
 * the specified size at a given location (x, y).
 *
 * Step 1: Enter your name for @author and the password for @version
 * @author  Froilan Zarate
 * @version SampleExamOne
 */
public class Face
{
    public static final double FACE_SIZE = 60.0;
    public static final double EYE_SIZE = 5.0;
    public static final double MOUTH_SIZE = 30.0;
    public static final double EYES_DISTANCE = 20.0;
    public static final double EYE_FROM_TOP = 20.0;
    public static final double MOUTH_FROM_TOP = 45.0;
    
    // Step 2: Declare two double instance variables
    //         for the given location (x, y)
    private double x, y;


    // Step 3: Write the constructor according to the description
    /**
     * Constructs a Face object by initializing the two
     * instance variables
     * 
     * @param xPos the x-coordinate of the upper-left corner of this face
     * @param yPos the y-coordinate of the upper-left corner of this face
     */
    public Face (double xPos, double yPos)
    {
        x = xPos;
        y = yPos;
    }


    // Step 4: Write the draw() method according to the description
    /**
     * Draws this face. 
     * A Face oject has a big circle for the face, two small circles 
     * for the eyes, and one line for the mouth. 
     * The diameter of the face is FACE_SIZE, and the two instance
     * variables specify the upper-left corner of the bounding square
     * of the big circle.
     * The diameter of the eyes is EYE_SIZE, the distance between the 
     * two eyes is EYES_DISTANCE, the distance above the eyes is
     * EYE_FROM_TOP, and the two eyes together are horizontally 
     * centered on the face.
     * The length of the mouth is MOUTH_SIZE, the distance above the 
     * mouth is MOUTH_FROM_TOP, and the mouth is centered on the face. 
     */
    public void draw()
    {
        Ellipse face = new Ellipse(x, y, FACE_SIZE, FACE_SIZE);
        Ellipse eye1 = new Ellipse(x + EYES_DISTANCE - EYE_SIZE, y + EYE_FROM_TOP, EYE_SIZE, EYE_SIZE);
        Ellipse eye2 = new Ellipse(x + EYES_DISTANCE + EYES_DISTANCE, y + EYE_FROM_TOP, EYE_SIZE, EYE_SIZE);
        Line mouth = new Line(x + EYES_DISTANCE - EYE_SIZE, y + MOUTH_FROM_TOP,
                                x + EYES_DISTANCE + MOUTH_SIZE - EYE_SIZE, y + MOUTH_FROM_TOP);
        
        face.draw();
        eye1.draw();
        eye2.draw();
        mouth.draw();

    }
}
