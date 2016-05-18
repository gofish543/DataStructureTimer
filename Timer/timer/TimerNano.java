package timer;

public class TimerNano {

    private long start;
    private long end;

    public TimerNano() {
        start = 0;
        end = 0;
    }

    public TimerNano(long start) {
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