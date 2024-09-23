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
		var node = get(MyNodeLabels.TownGeneralStore.toString());
		node.add(new NarrationSequence("You enter a small general store that seems to be falling apart at the seams and smells of mold and must. You approach the manic store owner. Would you like to purchase anything?"));
		node.add(new FadeIn());
		node.add(new Face(merchant,player));
		node.add(new Face(player,merchant));
		node.add(new Draw(player,coin));
		node.add(new Draw(merchant,apple));
		node.add(new Take(merchant,coin,player));
		node.add(new Take(player,apple,merchant));
	}
	
	@BuilderMethod
	public void GeneralStoreActions() {
		var node = get(MyNodeLabels.GeneralStore.toString());
		node.add(new NarrationSequence("You walk into the city’s general store and are greeted by a cat meowing at your feet. “Ah, welcome!”, says the store’s owner. “Feel free to shop around for as long as you’d like, and let me know if you see anything that strikes your fancy!”"));
		node.add(new FadeIn());
		node.add(new Face(merchant,player));
		node.add(new Face(player,merchant));
		node.add(new Draw(player,coin));
		node.add(new Draw(merchant,bread));
		node.add(new Take(merchant,coin,player));
		node.add(new Take(player,bread,merchant));
	}
	@BuilderMethod
	public void BlacksmithActions() {
		var node = get(MyNodeLabels.Blacksmith.toString());
		node.add(new NarrationSequence("The smell of fire fills your nostrils as you enter the blacksmiths shop. “Welcome to my humble forge”, says the Blacksmith. “Please, let me know if you’d like to purchase any of my wares”."));
		node.add(new FadeIn());
		node.add(new Face(blacksmith,player));
		node.add(new Face(player,blacksmith));
		node.add(new Draw(player,sword));
		node.add(new Take(blacksmith,sword,player));
		node.add(new Dance(blacksmith));
		node.add(new Give(blacksmith,sword,player));
	}
	@BuilderMethod
	public void AlchemyActions() {
		var node = get(MyNodeLabels.Alchemy.toString());
		node.add(new NarrationSequence("You enter a small, dingy store on the outskirts of town to find a lady brewing potions in a cauldron in the corner of the shop. “What do you want, mortal?”, says the lady, who appears to be the store’s owner."));
		node.add(new FadeIn());
		node.add(new Face(alchemist,player));
		node.add(new Face(player,alchemist));
		node.add(new Draw(player,coin));
		node.add(new Draw(alchemist,evilBook));
		node.add(new NarrationSequence("Warning: This book is evil"));
		node.add(new FadeIn());
		node.add(new Take(player,evilBook,alchemist));
	}
	@BuilderMethod
	public void DungeonActions() {
		var node = get(MyNodeLabels.Dungeon.toString());
		node.add(new SetPosition(bandit, dungeon));
		node.add(new NarrationSequence("You awaken in a cage in the middle of a damp, dark room. You can barely make out the faces of one other prisoner in the dim light of the candlestick on the warden’s desk. “Ah it looks another poor unfortunate soul has awoken from his slumber!”, says the warden. “The only way out of here is to fight your way out! If you lose, you die!” You lock eyes with the other prisoner, ready for battle."));
		node.add(new FadeIn());
		node.add(new Face(bandit,player));
		node.add(new Face(player,bandit));
		node.add(new Draw(player,sword));
		node.add(new Draw(bandit,sword));
	}
	@BuilderMethod
	public void FightPrisonerActions() {
		var node = get(MyNodeLabels.Fight.toString());
		node.add(new NarrationSequence("You ready your weapon against this poor prisoner. He looks to have been here for awhile and is fairly weak."));
		node.add(new Attack(player, bandit, true));
		node.add(new Die(bandit));
		node.add(new Dance(player));
		node.add(new NarrationSequence("You knock him down in one blow. You've earned your freedom... but at what cost?"));
		node.add(new SetPosition(player, city));
	}
	@BuilderMethod
	public void gateActions() {
		var node = get(MyNodeLabels.Gate.toString());
		node.add(new SetPosition(gaurd, bridge));
		node.add(new NarrationSequence("You approach a decrepit gate at the edge of town. A large, burly man carrying a sword blocks the exit with his carriage. “Everyone who leaves this town has to go through me. For 20 coins, I’ll take you to the city. If you don’t, get out of my sight.” Do you pay, leave, or take your chances in a fight?"));
		node.add(new Face(gaurd,player));
		node.add(new Face(player,gaurd));
		node.add(new Draw(player,coin));
		node.add(new Take(gaurd,coin,player));
		node.add(new SetPosition(player, city));
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
	public void AttemptPickpocketActions() {
		var node = get(MyNodeLabels.AttemptPickPocket.toString());
		node.add(new NarrationSequence("You are caught by the stranger! He draws his sword at you, and prepares to attack!"));
		node.add(new Face(npc1, player)).add(new Draw(npc1, sword)).add(new Attack(npc1, player, true)).add(new Die(player));
	}
	
	@BuilderMethod
	public void ForestActions() {
		var node = get(MyNodeLabels.Forest.toString());
		node.add(new WalkTo(player, forestPath, "DirtPile"));
	}
	@BuilderMethod
	public void FountainActions() {
		var node = get(MyNodeLabels.Fountain.toString());
		node.add(new NarrationSequence("There is an evil book shaped hole in the fountain. Would you like to add your evil book?"));
		node.add(new EnableInput());
		node.add(new Draw(player, evilBook));
		
	}
	public void InfiniteGoldActions() {
		var node = get(MyNodeLabels.InfiniteGold.toString());
		node.add(new NarrationSequence("The fountain erupts with gold, giving you seemingly an infinite amount!"));
		
	}
	
	@BuilderMethod
	public void DockActions() {
		var node = get(MyNodeLabels.Dock.toString());
		node.add(new SetPosition(npc1, port,"BigStall"));
		node.add(new NarrationSequence("You are greeted by the smell of sea mist and rum as you enter the dock at the edge of town. You see an intimidating swashbuckler sitting by his ship, as well as local city goers fishing off of the dock. 'Argh! Are ye a pirate?' Asks a captain from atop his pirate ship."));
	}
	
	@BuilderMethod
	public void PirateFightActions() {
		var node = get(MyNodeLabels.PirateFight.toString());
		node.add(new SetPosition(pirate, port,"BigShip"));
		node.add(new NarrationSequence("Pirate: 'I don't believe ye land lubber! Face me in combat to prove your pirate prowess!'"));
		node.add(new Face(pirate, player)).add(new Draw(pirate, sword)).add(new Draw(player,sword)).add(new Attack(player, pirate, true)).add(new Die(pirate));
		node.add(new NarrationSequence("Pirate: 'Congrats you have bested the pirate captain in fair combat!\n+"+ "Arg! Ye are a true pirate'"));
	}
	@BuilderMethod
	public void PirateEndingActions() {
		var node = get(MyNodeLabels.PirateEnding.toString());
		node.add(new NarrationSequence("You sail away from your past life, with nothing but the open ocean and your new mateys surrounding you. You may not have gotten your farm back, but you’ve found a new purpose exploring and pillaging the seven seas.\n"+ "\n"+ "\n"+ "\n"+ "The End"));
	}
	@BuilderMethod
	public void NoActions() {
		var node = get(MyNodeLabels.No.toString());
		node.add(new NarrationSequence("Do ye want to be? I could always use some more crew."));
	}
	@BuilderMethod
	public void TooBadActions() {
		var node = get(MyNodeLabels.TooBad.toString());
		node.add(new NarrationSequence("Then get off me dock land lubber!  >:("));
	}
	@BuilderMethod
	public void ArgActions() {
		var node = get(MyNodeLabels.Arg.toString());
		node.add(new NarrationSequence("If ye wants to be a pirate, first you must go find my lost parrot. Here, this spy glass will help you find him."));
	}
	@BuilderMethod
	public void LoudAndObnoxiousTreeActions() {
		var node = get(MyNodeLabels.LoudAndObnoxiousTree.toString());
		node.add(new NarrationSequence("You see something flying up in the tree. If only you had a spyglass, you could see what it is."));
	}
	@BuilderMethod
	public void LookThroughSpyglassActions() {
		var node = get(MyNodeLabels.LookThroughSpyglass.toString());
		node.add(new NarrationSequence("You see a parrot flying up in the tree."));
	}
	@BuilderMethod
	public void GrabHimActions() {
		var node = get(MyNodeLabels.GrabHim.toString());
		node.add(new NarrationSequence("You have a parrot now!"));
	}
	
	@BuilderMethod
	public void YouDiedTownActions() {
		var node = get(MyNodeLabels.YouDiedTown.toString());
		node.add(new FadeOut());
		node.add(new NarrationSequence("You took too much damage and passed out. A rude peasant found your body and dragged you back to town stealing a portion of your gold"));
		node.add(new SetPosition(player, town));
		node.add(new FadeIn());
	}
	
	@BuilderMethod
	public void YouDiedCityActions() {
		var node = get(MyNodeLabels.YouDiedCity.toString());
		node.add(new FadeOut());
		node.add(new NarrationSequence("You took too much damage and passed out. You wake up in a mysterious, damp stone room."));
		node.add(new SetPosition(player, dungeon));
		node.add(new FadeIn());
	}
	@BuilderMethod
	public void ThroneRoomActions() {
		var node = get(MyNodeLabels.ThroneRoom.toString());
		node.add(new WalkTo(player, king));
		node.add(new NarrationSequence("Who dares come into the great throne room of the great king, king Bartholomew the great?!?! State your buisness immediately or face my wrath!"));	
	}
	@BuilderMethod
	public void FightKingActions() {
		var node = get(MyNodeLabels.FightKing.toString());
		node.add(new Face (player, king)).add(new Draw(king, sword)).add(new Draw(player, sword)).add(new NarrationSequence("Now, you die!")).add(new Attack(player, king, true)).add(new Die(king).add(new Dance(player)));
	}
	
	@BuilderMethod
	public void BuyYourLandBackActions() {
		var node = get(MyNodeLabels.BuyYourLandBack.toString());
		node.add(new NarrationSequence("Very well, you have earned enough money to buy your land back. Capitalism wins yet again!"));
	}
	@BuilderMethod
	public void BuyKingdomActions() {
		var node = get(MyNodeLabels.BuyKingdom.toString());
		node.add(new NarrationSequence("Really, you would be willing to buy this kingdom off me? King Bartholomew asked nervously. Honestly, I never did like being king always... I really just did it for the money. King Bartholomew gingerly paces back and forth across the room while nodding, becoming more and more certain with each step. Yes. I will sell you my kingdom."));
	}
	
	@BuilderMethod
	public void BribeTheGuard1Actions() {
		var node = get(MyNodeLabels.BribeTheGuard1.toString());
		node.add(new SetPosition(gaurd,hallway));
		node.add(new NarrationSequence("The guard happily takes your coins letting you into the Castle."));
	}
	@BuilderMethod
	public void MainHallUnsafeActions() {
		var node = get(MyNodeLabels.MainHallUnsafe.toString());
		node.add(new NarrationSequence("Another guard is standing guard not letting you progress further into the Castle (1/3)"));
	}
	@BuilderMethod
	public void BribeTheGuard2Actions() {
		var node = get(MyNodeLabels.BribeTheGuard2.toString());
		node.add(new NarrationSequence("The guard happily takes your coins letting you into the Castle."));
	}
	@BuilderMethod
	public void MainHallUnsafe2Actions() {
		var node = get(MyNodeLabels.MainHallUnsafe2.toString());
		node.add(new NarrationSequence("As you walk further into the Castle yet another guard blocks your path (2/3)"));
	}
	@BuilderMethod
	public void BribeTheGuard3Actions() {
		var node = get(MyNodeLabels.BribeTheGuard3.toString());
		node.add(new NarrationSequence("The guard happily takes your coins letting you even furhter into the Castle."));
	}
	@BuilderMethod
	public void MainHallUnsafe3Actions() {
		var node = get(MyNodeLabels.MainHallUnsafe3.toString());
		node.add(new NarrationSequence("A final guard stands in the way of letting you acsess the kings thrown room. (3/3)"));
	}
	@BuilderMethod
	public void BribeTheGuard4Actions() {
		var node = get(MyNodeLabels.BribeTheGuard4.toString());
		node.add(new NarrationSequence("The guard happily takes your coins letting you into the throne room."));
	}
	@BuilderMethod
	public void FightTheGuardActions() {
		var node = get(MyNodeLabels.FightTheGuard.toString());
		node.add(new NarrationSequence("You won the fight taking and wearing the guards armor."));
	}
	
	
	

}