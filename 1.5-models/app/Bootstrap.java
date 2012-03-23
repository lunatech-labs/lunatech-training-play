import models.CompositeNumber;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

/**
 * Application start-up job.
 */
@OnApplicationStart
public class Bootstrap extends Job {

   public void doJob() {
      if (CompositeNumber.count() == 0) {
         Fixtures.loadModels("data.yml");
      }
   }
}