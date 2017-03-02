package Starclipse;

import java.util.Date;

/** My class */
public class Timer {

	/**The number of milliseconds in the day {@value #DAY}ms*/
	public static final long DAY = 86400000L;
	/**The number of milliseconds in the hour {@value #HOUR}ms*/
	public static final long HOUR = 3600000L;
	/**The number of milliseconds in the minute {@value #MINUTE}ms*/
	public static final long MINUTE = 60000L;
	/**The number of milliseconds in the second {@value #SECOND}ms*/
	public static final long SECOND = 1000L;
	
	private long duration = 0;
	private long finish = 0;
	
	/**
     * Creates a timer a certain amount of time specified in the parameters. 
     * 
     * <p>
     * <strong>Parameters: </strong>
     * <pre>  <b>duration</b> the number of the milliseconds.</pre>
     * 
     * <p>
     * <strong>Example: </strong>
     * <pre>
     * <code> Timer timer = new Timer(1000);// 1s
     *  Timer timer = new Timer(Timer.HOUR * 4);// 4h
     *  Timer timer = new Timer(Timer.DAY * 2 + Timer.MINUTE * 50);// 2d 50m
     *  Timer timer = new Timer(Timer.HOUR * 48);// 2d 
     * </code></pre>
     */
	public Timer(long duration) {
		this.duration = duration;	
	}
	
	
	/**
	 * Starts counting timer.
	 */
	public void start() {
		this.finish = new Date().getTime() + this.duration;
	}
	
	@Override
	public String toString() {
		long timer = this.finish - new Date().getTime();
		
		if(timer > 0) {
			return  (getDays(timer)    == 0 ? "" : getDays(timer)    + "d ") + 
					(getHours(timer)   == 0 ? "" : getHours(timer)   + "h ") + 
					(getMinutes(timer) == 0 ? "" : getMinutes(timer) + "m ") + 
					(getSeconds(timer) + "s");
		} else if(finish == 0) {
			return "Start";
		}
		
		return "Claim";
	}
	
	public String toString(String format) {
		long timer = this.finish - new Date().getTime();
		
		if(timer > 0) {
			format = format.replace("dd", getDays(timer) + "");
			format = format.replace("hh", getHours(timer) + "");
			format = format.replace("mm", getMinutes(timer) + "");
			format = format.replace("ss", getSeconds(timer) + "");
			return format;
		} else if(finish == 0) {
			return "Start";
		}
		
		return "Claim";
	}
	
	private long getDays(long time) {
		return time / DAY;
	}
	
	private long getHours(long time) {
		return (time % DAY) / HOUR;
	}
	
	private long getMinutes(long time) {
		return ((time % DAY) % HOUR) / MINUTE;
	}
	
	private long getSeconds(long time) {
		return (((time % DAY) % HOUR) % MINUTE) / SECOND;
	}
}
