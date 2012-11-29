

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.Job;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.job.state.Tree;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.util.Random;

import cooksassistinator.stuff.Methods;
import cooksassistinator.util.Paint;

import cooksassistinator.jobs.*;

@Manifest(authors = { "Nylls" }, name = "StN_Cook's Assistinator", description="A bot that does the Cook's Assistant quest, start at lumbridge castle square." )
public class StN_Cooks_Assistinator extends ActiveScript implements PaintListener{
	
		/*#*****************************************/
		/* Script Skeleton written by ArcaneSanity */
		/*#*****************************************/
	
        private final List<Node> jobsCollection = Collections.synchronizedList(new ArrayList<Node>());
        private Tree jobContainer = null;
        private boolean started = false;
        private long time = System.currentTimeMillis();

        public synchronized final void provide(final Node... jobs) {
                for (final Node job : jobs) {
                        if(!jobsCollection.contains(job)) {
                                jobsCollection.add(job);
                        }
                }
                jobContainer = new Tree(jobsCollection.toArray(new Node[jobsCollection.size()]));
        }

        public synchronized final void revoke(final Node... jobs) {
                for (final Node job : jobs) {
                        if(jobsCollection.contains(job)) {
                                jobsCollection.remove(job);
                        }
                }
                jobContainer = new Tree(jobsCollection.toArray(new Node[jobsCollection.size()]));
        }

        public final void submit(final Job... jobs) {
                for (final Job job : jobs) {
                        getContainer().submit(job);
                }
        }

        @Override
        public void onStart() {
                provide(new WalkToStart(),new Start(started),new GetPot(),new WalkToCow(),new MilkCow(),new WalkToChickens(),new TakeEgg(), new WalkToWheat(),new PickWheat(),new EnterMill(), new MakeFlour(), new WalkBack(),new TalkToCook());
        }

        @Override
        public int loop() {
                if (jobContainer != null) {
                        final Node job = jobContainer.state();
                        if (job != null) {
                                jobContainer.set(job);
                                getContainer().submit(job);
                                job.join();
                        }
                }
                if(Methods.status=="Finished"){
                	shutdown();
                }
                return Random.nextInt(10, 50);
        }
        
        @Override
        public void onRepaint(Graphics render) {
    		Paint.drawPaint(render,time);
    	}

        

}