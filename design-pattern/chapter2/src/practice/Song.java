package practice;

public class Song {
	private DiscountMode discountMode;
	public void setMode(DiscountMode discountMode){
		this.discountMode = discountMode;
	}
	public double getPrice() {
		return 10.0 - (10.0*discountMode.getDiscountRate());
	}
}
