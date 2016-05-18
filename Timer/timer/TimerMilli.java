package timer;

public class TimerMilli {

    private long start;
    private long end;

    public TimerMilli() {
        start = 0;
        end = 0;
    }

    public TimerMilli(long start) {
        this.start = start;
        end = 0;
    }

    public void setStart(long start) {
        this.start = start;
        end = 0;
    }

    public void reset() {
        start = 0;
        end = 0;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public long getDifference() {
        return (end - start);
    }
}