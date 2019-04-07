
public class HourAndMinuteAngle {

	private static final int minuteAngle = 6;
	private static final int hourAngle = 30;

	public static int calculateAngle(int hour, int min) {
		if (hour == 12) {
			hour = 0;
		}
		if (min == 60) {
			min = 0;
		}

		int totalHourAngle = hour * hourAngle;
		int totalMinAngle = min * minuteAngle;

		int diff = Math.abs(totalHourAngle - totalMinAngle);

		if (diff > 180) {

			if (totalHourAngle > totalMinAngle) {
				totalHourAngle = 360 - totalHourAngle;
			} else {
				totalMinAngle = 360 - totalMinAngle;
			}

			return totalHourAngle + totalMinAngle;
		} else {
			return diff;
		}
	}

	public static void main(String[] args) {

		System.out.println(calculateAngle(11, 05));
	}

}
