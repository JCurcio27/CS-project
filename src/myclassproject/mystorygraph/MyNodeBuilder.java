package myclassproject.mystorygraph;

import java.util.List;

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
		root.add(new CreateAll(List.of(cottage, town, sword))).add(new CreateCharacterSequence(bandit))
		.add(new CreateCharacterSequence(player)).add(new SetPosition(bandit, cottage, "Chest"))
		.add(new SetPosition(player, cottage)).add(new Face(bandit, player)).add(new Draw(bandit, sword))
		.add(new SetCameraFocus(player)).add(new ShowMenu());
	}
	public void Town() {
		var node = get(NodeLabels.Town.toString());
		node.add(new HideMenu()).add(new EnableInput());
	}
	

};

