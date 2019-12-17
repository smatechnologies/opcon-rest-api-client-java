package com.smatechnologies.opcon.restapiclient.model;

/**
 * Resource model of Machine Status Count
 *
 * @author Francois EYL
 */
public class MachineStatusCount {

    public static final String RESOURCE = "machineStatusCount";

    public static final String PROPERTY_UP = "up";
    public static final String PROPERTY_DOWN = "down";
    public static final String PROPERTY_ERROR = "error";
    public static final String PROPERTY_WAITING = "waiting";
    public static final String PROPERTY_LIMITED = "limited";

    private int up = 0;
    private int down = 0;
    private int error = 0;
    private int waiting = 0;
    private int limited = 0;

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public int getWaiting() {
        return waiting;
    }

    public void setWaiting(int waiting) {
        this.waiting = waiting;
    }

    public int getLimited() {
        return limited;
    }

    public void setLimited(int limited) {
        this.limited = limited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        MachineStatusCount that = (MachineStatusCount) o;

        if (up != that.up)
            return false;
        if (down != that.down)
            return false;
        if (error != that.error)
            return false;
        if (waiting != that.waiting)
            return false;
        return limited == that.limited;

    }

    @Override
    public String toString() {
        return "MachineStatusCount{" +
                "up=" + up +
                ", down=" + down +
                ", error=" + error +
                ", waiting=" + waiting +
                ", limited=" + limited +
                '}';
    }

    @Override
    public int hashCode() {
        int result = up;
        result = 31 * result + down;
        result = 31 * result + error;
        result = 31 * result + waiting;
        result = 31 * result + limited;
        return result;
    }

}
