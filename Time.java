package Starclipse;

public class Time {
	final static long DAY = 86400000L;
	final static long HOUR = 3600000L;
	final static long MINUTE = 60000L;
	final static long SECOND = 1000L;
	long duration = 0;
	long start = 0;
	
	public Time(long duration) {
		this.duration = duration;	
	}
	
	@Override
	public String toString() {
		if(getDays() > 0) {
			return  getDays() + "d " +
					(getHours()   < 10 ? "0" + getHours()   : getHours())   + ":" + 
					(getMinutes() < 10 ? "0" + getMinutes() : getMinutes()) + ":" + 
					(getSeconds() < 10 ? "0" + getSeconds() : getSeconds());
		}
		
		return  (getHours()   < 10 ? "0" + getHours()   : getHours())   + ":" + 
				(getMinutes() < 10 ? "0" + getMinutes() : getMinutes()) + ":" + 
				(getSeconds() < 10 ? "0" + getSeconds() : getSeconds());
	}
}
