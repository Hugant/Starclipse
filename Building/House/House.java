package starclipse.building.house;

import starclipse.building.Resources;
import starclipse.common.Timer;
import starclipse.common.Subject;

public class House implements starclipse.building.Building{
	private String status = "";
	private String name = "";
	private Timer buildTime;
	private Timer incomeTime;
	private Subject residents;
	private Resources expenses = null;
	
	int i = 0;
	
	private class Updater extends Thread {
		public void run() {
			System.out.println("Start build");
			while(!buildUpdateStatus().equals("End Work")) {
				try {
					Thread.sleep(1000);
				} catch(InterruptedException e) {
					System.out.println(e.toString());
				}
			}
			startWork();
			System.out.println("End build");
		}
	}
	
	private class Worker extends Thread {
		public void run() {
			System.out.println("Worker " + i + " on start");
			while(!workUpdateStatus().equals("End Work")) {
				try {
					Thread.sleep(1000);
				} catch(InterruptedException e) {
					System.out.println(e.toString());
				}
			}
			System.out.println("Worker " + i + " end work");
			i++;
			setStatus("Claim");
		}
	}
	
	public House(String type) {
		switch(type.toLowerCase()) {
			case "big":
				this.residents = new Subject("residents", "0", "100");
				this.name = "Big House";
				this.buildTime = new Timer(Timer.MINUTE + Timer.SECOND * 30);
				this.incomeTime = new Timer(Timer.SECOND * 20);
				this.expenses = new Resources("stone",  "100", 
											  "tree",   "50", 
											  "money",  "1000", 
											  "iron",   "10",  
											  "water",  "10", 
											  "energy", "10"  );
				return;
				
			case "avarage":
				this.residents = new Subject("residents", "0", "50");
				this.name = "Avarage House";
				this.buildTime = new Timer(Timer.MINUTE * 5);
				this.incomeTime = new Timer(Timer.SECOND * 20);
				this.expenses = new Resources("stone",  "50", 
											  "tree",   "25", 
											  "money",  "500",
											  "iron",   "5" , 
											  "water",  "5" , 
											  "energy", "5"  );	
				return;
				
			case "small":
				this.residents = new Subject("residents", "0", "10");
				this.name = "Small House";
				this.buildTime = new Timer(Timer.SECOND * 5);
				this.incomeTime = new Timer(Timer.SECOND * 5);
				this.expenses = new Resources("stone",  "12", 
											  "tree",   "6", 
											  "money",  "125",
											  "iron",   "1" , 
											  "water",  "1", 
											  "energy", "1"  );
				return;
		}
	}
	
	public void build() {
		buildTime.start();
		Updater updater = new Updater();
		updater.start();
	}
	
	
	
	synchronized private String buildUpdateStatus() {
		this.status = buildTime.toString();
		return this.status;
	}
	
	synchronized private String workUpdateStatus() {
		this.status = incomeTime.toString();
		return this.status;
	}
	
	synchronized public String getStatus() {
		return this.status;
	}
	
	private void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
	
	
	
	
	private Worker worker = new Worker();
	
	
	
	public void startWork() {
		incomeTime.start();
		worker.start();
	}
	
	public Subject claim() {
		incomeTime.start();
		worker.start();
		return this.residents;
	}
}
