package stabilizer;

public class ScheduleTest {

	public static void main(String[] args) {
		Schedulable system = new Parallel(
				
								new Prefix(new Action("a",false), 
										new Measurement(
												new Prefix(new Action("b",false),
														new Zero()))), 
												
								new Prefix(new Action("a",true), 
										new Prefix(new Action("d",false),
												new Zero())));
		
		Scheduler scheduler = new Scheduler(system);
		scheduler.explore();
	}

}
