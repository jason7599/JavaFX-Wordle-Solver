package wordlesolver;

import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class GrowShrinkAnimation 
{
	private SequentialTransition anim;
	
	public GrowShrinkAnimation(Node node, Duration duration, double scaleDelta)
	{
		ScaleTransition grow = new ScaleTransition(duration.divide(2));
		grow.setByX(scaleDelta); 
		grow.setByY(scaleDelta);
		
		ScaleTransition shrink = new ScaleTransition(duration.divide(2));
		shrink.setByX(-scaleDelta);
		shrink.setByY(-scaleDelta);

		anim = new SequentialTransition(node, grow, shrink);
	}
	
	public void play()
	{
		anim.play();
	}
}
