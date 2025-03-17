import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

interface ChenMapFactory {
    Map<String, ChenPokemon> createMap();
}
