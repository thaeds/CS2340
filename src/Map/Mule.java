package Map;

/**
 * Created by Sergey on 10/16/15.
 * @author Sergey
 * @version 1.0
 * Basic mule that contains type (string)
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
