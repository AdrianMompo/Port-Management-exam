//Adrián Mompó Fajardo
package PaqIAdrian;

public class Container {
    private int id, weight, priority;
    private String origin, desc, sender, receiver;
    private boolean inspected;

    public Container(int id, int weight, int priority, String origin, String desc, String sender, String receiver, boolean inspected) {
        this.id = id;
        this.weight = weight;
        this.priority = priority;
        this.origin = origin;
        this.sender = sender;
        this.receiver = receiver;
        this.desc = desc;
        this.inspected = inspected;
    }

    public int getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }


    public int getWeight() {
        return weight;
    }


    public String getOrigin() {
        return origin;
    }

    public String getDescription() {
        return desc;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public boolean isInspected() {
        return inspected;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public void setId(int id) {
        this.id = id;
    }


    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
    public void setDescription(String description) {
        this.desc = description;
    }



    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setInspected(boolean inspected) {
        this.inspected = inspected;
    }

    public String toString() {
        return "Container: {" + id +
                "\n- Weight: " + weight +
                "\n- Priority: " + priority +
                "\n- Origin: " + origin +
                "\n- Description: " + desc +
                "\n- Sender: " + sender +
                "\n- Receiver: " + receiver +
                "\n- Inspected: " + inspected;
    }
}
