package Starclipse;

import java.util.Date;

public class Timer {
	final static long DAY = 86400000L;
	final static long HOUR = 3600000L;
	final static long MINUTE = 60000L;
	final static long SECOND = 1000L;
	
	long duration = 0;
	long timer = 0;
	long start = 0;
	
	public Timer(long duration) {
		this.duration = duration;	
	}
	
	public void start() {
		this.start = new Date().getTime();
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
