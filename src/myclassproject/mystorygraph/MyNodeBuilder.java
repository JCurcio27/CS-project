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
		.add(new CreateCharacterSequence(bandit))
		.add(new CreateCharacterSequence(npc1))
		.add(new CreateCharacterSequence(npc2))
		.add(new CreateCharacterSequence(blacksmith))
		.add(new CreateCharacterSequence(alchemist))
		.add(new CreateCharacterSequence(king))
		.add(new CreateCharacterSequence(gaurd))
		.add(new CreateCharacterSequence(pirate))
		.add(new CreateCharacterSequence(merchant))
		.add(new SetPosition(player, farm))
		.add(new SetPosition(bandit, dungeon))
		.add(new SetPosition(npc1, town))
		.add(new SetPosition(npc2, town))
		.add(new SetPosition(blacksmith, blackSmith))
		.add(new SetPosition(alchemist, alchemyShop))
		.add(new SetPosition(king, greatHall))
		.add(new SetPosition(gaurd, bridge))
		.add(new SetPosition(pirate, port))
		.add(new SetCameraFocus(player))
		.add(new SetPosition(merchant, storage))
		.add(new ShowMenu());
	}
	@BuilderMethod
	public void TownActions() {
		var node = get(MyNodeLabels.Town.toString());
		node.add(new HideMenu()).add(new EnableInput());
		node.add(new NarrationSequence("You awaken in the small, poor town of Gregoria, on the outer edge of the forest. The town is filled with dilapidated buildings and broken people. You know what to do next. \n" + "Where would you like to go?"));
		
		
	}
	@BuilderMethod
	public void CityActions() {
		var node = get(MyNodeLabels.City.toString());
		node.add(new CreateAll(List.of(npc1, gaurd)));
		node.add(new NarrationSequence("As you pass through the pearly gates of the city, you are taken aback by the hustle and bustle of the beautiful Camelot City. You are excited by the prospect of exploring every corner of the mysterious new location, but you know you must focus on your ultimate goal; getting your land back.\n"));
		
	}
	
	@BuilderMethod
	public void TownBeggingActions() {
		var node = get(MyNodeLabels.BeggingSpot.toString());
		node.add(new WalkTo(player,town,"RightLog"));
		node.add(new HideMenu()).add(new EnableInput());
		node.add(new NarrationSequence("While in your begging spot, a citizen crosses your path. Would you like to beg for coins, attempt to fight him, or attempt to pickpocket him?"));
		
	}
	@BuilderMethod
	public void TownGeneralStoreActions() {
		var node = get(MyNodeLabels.Town.toString());
		node.add(new NarrationSequence("You enter a small general store that seems to be falling apart at the seams and smells of mold and must. You approach the manic store owner. Would you like to purchase anything?"));
		node.add(new Draw(player,coin));
		node.add(new Draw(merchant,coin));
		node.add(new FadeIn());
		node.add(new HideMenu()).add(new EnableInput());
		
	}
	@BuilderMethod
	public void CityBeggingSpotActions() {
		var node = get(MyNodeLabels.BeggingSpot.toString());
		node.add(new WalkTo(player, city, "Alley2"));
		node.add(new HideMenu()).add(new EnableInput());
		node.add(new NarrationSequence("While in your begging spot, a citizen crosses your path. Would you like to beg for coins, attempt to fight him, or attempt to pickpocket him?"));
		
	}
	@BuilderMethod
	public void FightActions() {
		var node = get(MyNodeLabels.Fight.toString());
		node.add(new Attack(player, npc1, true));
		node.add(new Die(npc1));
		node.add(new Dance(player));
		
	}
	
	@BuilderMethod
	public void BegForCoinsActions() {
		var node = get(MyNodeLabels.BegForCoins.toString());
		node.add(new NarrationSequence("The stranger relents, and gives you the coins you asked for."));
	}
	
	@BuilderMethod
	public void AttemptPickPocketActions() {
		var node = get(MyNodeLabels.Attemptpickpocket.toString());
		node.add(new NarrationSequence("You are caught by the stranger! He draws his sword at you, and prepares to attack!"));
		node.add(new Face(npc1, player)).add(new Draw(npc1, sword)).add(new Attack(npc1, player, true)).add(new Die(player));
	}
	

}