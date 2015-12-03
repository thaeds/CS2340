package Map;

/**
 * Created by Sergey on 10/16/15.
 */

/**
 * Constructor for Abstract Mule
 *
 */
public abstract class Mule {
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;
}
