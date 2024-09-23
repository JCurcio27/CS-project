package myclassproject.mystorygraph;

import com.entities.Characters;
import com.entities.Furniture;
import com.entities.Item;
import com.entities.Place;
import com.enums.BodyTypes;
import com.enums.Clothing;
import com.enums.Colors;
import com.enums.FurnitureTypes;
import com.enums.HairStyle;
import com.enums.ItemTypes;
import com.enums.PlaceTypes;

public final class MyStoryEntities {
	//Create an instance of Character, Place, Furniture, and Item classes 
	//for each of the characters, places, furniture, and items in your story
	//Make that instance public static final
	//e.g. public static final Characters player = new Characters("Player", BodyTypes.D, Clothing.Peasant, HairStyle.Short, Colors.Black, 6);
	//You can access these instances in your EdgeBuilder and NodeBuilder classes by importing:
	//import static myclassproject.mystorygraph.MyStoryEntities.*;
	

	public static final Place town = new Place("Town", PlaceTypes.Camp);
	public static final Place farm = new Place("Farm", PlaceTypes.Farm);
	public static final Place city = new Place("City", PlaceTypes.City);
	public static final Place dungeon = new Place("Dungeon", PlaceTypes.Dungeon);
	public static final Place forestPath = new Place("ForestPath", PlaceTypes.ForestPath);
	public static final Place ruins = new Place("Ruins", PlaceTypes.Ruins);
	public static final Place alchemyShop = new Place("Port", PlaceTypes.Port);
	public static final Place blackSmith = new Place("BlackSmith", PlaceTypes.Blacksmith);
	public static final Place castleCrossroads = new Place("CastleCrossroads", PlaceTypes.CastleCrossroads);
	public static final Place hallway = new Place("Hallway", PlaceTypes.Hallway);
	public static final Place greatHall = new Place(" GreatHall", PlaceTypes.GreatHall);
	public static final Place port = new Place("Port", PlaceTypes.Port);
	public static final Place storage = new Place("Storage", PlaceTypes.Storage);
	public static final Place bridge = new Place("Bridge", PlaceTypes.Bridge);

}
}
