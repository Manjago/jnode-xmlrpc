package jnode.ui.client.ui.sys;

public abstract class BlockingServiceCallback<E> extends ServiceCallBack<E> {

	public BlockingServiceCallback(String testStr) {
		this(null, testStr);
	}
	
	public BlockingServiceCallback(Blocker blocker, String testStr) {
		super(testStr);
		if (blocker == null){
			createNewBlocker();			
		} else {
			setBlocker(blocker);			
		}
	}

	private void createNewBlocker() {
		setBlocker(Blocker.createBlocker());
		getBlocker().start();
	}

}
