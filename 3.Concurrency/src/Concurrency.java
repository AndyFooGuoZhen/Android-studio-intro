
public class Concurrency {

	public static void main(String[] args) {
		//Making a thread
		//Must implement run method
		
		Thread thread = new Thread(new Runnable(){
			@Override
			public void run() {
				for(int i=0;i<5;i++)
				{
					System.out.println("Printing" + i + " in worker thread");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
				});

		thread.start(); //Starting the thread
		
		for(int i=0;i<5;i++)
		{
			System.out.println("Printing" + i + " in main thread");
			
		}
	}

}
