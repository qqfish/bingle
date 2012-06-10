package baseUse;

import java.util.TimerTask;

public class CleanTask extends TimerTask {

	@Override
	public void run() {
		Global.cache().autoClean();

	}

}
