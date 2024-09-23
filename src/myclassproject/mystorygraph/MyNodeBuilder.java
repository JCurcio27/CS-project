package myclassproject.mystorygraph;

import java.util.List;
import myclassproject.mystorygraph.MyNodeLabels;

import com.storygraph.*;

import static myclassproject.mystorygraph.MyStoryEntities.*;


import java.util.List;
import com.actions.*;
import com.sequences.*;
import com.storygraph.*;

public class MyNodeBuilder extends NodeBuilder {
	public MyNodeBuilder(List<Node> list) {
		super(list);
	}

	/**
	 * Write a method for each node. 
	 * Use get to get a reference to the node using its label.
	 * The method adds Camelot actions that execute in order when visiting that node. 
	 * These methods must have a BuilderMethod annotation.
	 */
	@BuilderMethod
	public void rootActions() {
		//Example:
		var root = get(MyNodeLabels.root.toString());
		root.add(new CreateAll(List.of(farm, town, city, blackSmith, castleCrossroads, port, ruins, greatHall,forestPath,dungeon, alchemyShop, hallway, bridge, storage, bridge,sword,coin,evilBook,magnifyingGlass,apple,bread)))
		.add(new CreateCharacterSequence(player))
		.add(new SetPosition(player, farm))
		.add(new Face(bandit, player))
		.add(new SetCameraFocus(player))
		.add(new ShowMenu());
	}
	public void TownActions() {
		var node = get(MyNodeLabels.Town.toString());
		node.add(new HideMenu()).add(new EnableInput());
		
		node.add(new HideMenu()).add(new EnableInput());
		
	}
	@BuilderMethod
	public void atCity() {
		var node = get(MyNodeLabels.City.toString());
		node.add(new CreateAll(List.of(insert people here));
		
	}
	@BuilderMethod
	public void beggingActions() {
		var node = get(MyNodeLabels.BeggingSpot.toString());
		node.add(new HideMenu()).add(new EnableInput());
		node.add(new NarrationSequence("While in your begging spot, a citizen crosses your path. Would you like to beg for coins, attempt to fight him, or attempt to pickpocket him?"));
		
	}

}