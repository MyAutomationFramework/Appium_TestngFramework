package installApkWithJavaCode;

import org.testng.annotations.Test;

public class callExcutionIntallApk  extends ServerStartAndStopInstallApk{
	
	
	@Test(priority=1)
	public void startServer() {
		statrtServerhurray();
	}
	
	@Test(priority=2)
	public void installApkhurrY() throws Exception {
	   intallApk_switchCase();
	}
	
	
	@Test(priority=3)
	public void stopServer() {
		 stopServerhurray();
	}
	
	
	

}// end class
