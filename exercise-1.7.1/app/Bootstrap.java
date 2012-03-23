import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

/**
 * Application start-up job.
 */
@OnApplicationStart
public class Bootstrap extends Job {

   public void doJob() {
      Fixtures.loadModels("data.yml");
   }
}