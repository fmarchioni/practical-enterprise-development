import jakarta.faces.push.Push;
import jakarta.faces.push.PushContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

@ViewScoped
@Named("helloBean")
public class HelloBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(HelloBean.class.getName());

    @Inject
    @Push
    PushContext helloChannel;

    String message;

    public void sendMessage() {
        LOG.log(Level.INFO, "send push message");
        this.sendPushMessage("hello");
    }

    private void sendPushMessage(Object message) {
        helloChannel.send("" + message + " at " + new java.util.Date());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void sendMessage2() {
        // log.log(Level.INFO, "send push message from input box::" + this.message);
        this.sendPushMessage(this.message);
    }

}