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
		if(getDays(timer) > 0) {
			return  getDays(timer) + "d " +
					(getHours(timer)   < 10 ? "0" + getHours(timer)   : getHours(timer))   + ":" + 
					(getMinutes(timer) < 10 ? "0" + getMinutes(timer) : getMinutes(timer)) + ":" + 
					(getSeconds(timer) < 10 ? "0" + getSeconds(timer) : getSeconds(timer));
		}
		
		return  (getHours(timer)   < 10 ? "0" + getHours(timer)   : getHours(timer))   + ":" + 
				(getMinutes(timer) < 10 ? "0" + getMinutes(timer) : getMinutes(timer)) + ":" + 
				(getSeconds(timer) < 10 ? "0" + getSeconds(timer) : getSeconds(timer));
	}
	
	private long getDays() {
		return this.duration / DAY;
	}
	
	private long getHours() {
		return (this.duration % DAY) / HOUR;
	}
	
	private long getMinutes() {
		return ((this.duration % DAY) % HOUR) / MINUTE;
	}
	
	private long getSeconds() {
		return (((this.duration % DAY) % HOUR) % MINUTE) / SECOND;
	}
}
