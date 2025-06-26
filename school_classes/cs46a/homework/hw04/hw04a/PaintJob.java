
/**
 * Model a paint job.
 *
 * @author Froilan Zarate
 * @version 09-22-2022
 */
public class PaintJob
{
    // instance variables - replace the example below with your own
    private double length;
    private double width;

    /**
     * The length and width of the room.
     *
     * @param theLength  the length of the room.
     * @param theWidth  the width of the room.
     */
    public PaintJob(double theLength, double theWidth)
    {
        length = theLength;
        width = theWidth;
    }
    /**
     * Get the length of the room.
     *
     * @return the length of the room.
     */
    public double getLength()
    {
        return length;
    }
    /**
     * Get the width of the room.
     *
     * @return the width of the room.
     */
    public double getWidth()
    {
        return width;
    }
    /**
     * The new length and width of the room.
     *
     * @param newLength  the new length of the room.
     * @param newWidth  the new width of the room.
     */
    public void setDimensions(double newLength, double newWidth)
    {
        length = newLength;
        width = newWidth;
    }
    /**
     * Get the surface area of the room.
     *
     * @return the surface area of the room.
     */
    public double surfaceArea()
    {
        return ((width + width + length + length) * 8.0) + (width * length)
                    - ((80.0 / 12.0) * (32.0 / 12.0)) - (4.0 * 5.0);
    }
    /**
     * Gets the cost of the paint job.
     *
     * @return the cost of the point job for the room.
     */
    public double costOfPaint()
    {
        return (31.95 / 300.0) * surfaceArea();
    }
    /**
     * Gets the cost of the job.
     *
     * @return the cost of the job for the room.
     */
    public double totalJobCost()
    {
        return costOfPaint() + 100.0;
    }
}
