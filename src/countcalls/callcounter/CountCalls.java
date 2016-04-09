package countcalls.callcounter;

public class CountCalls {
	
	private int countCalls = 0;
	private String parser;
	
	public void count(){
		countCalls++;
		parser = Integer.toString(countCalls);
	}
	public int getCountCalls() {
		return countCalls;
	}
	public String getParser() {
		return parser;
	}
	



}
