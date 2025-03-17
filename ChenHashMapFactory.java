import java.util.*;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class ChenHashMapFactory implements ChenMapFactory {
    public Map<String, ChenPokemon> createMap() {
        return new HashMap<>();
    }
}

class ChenTreeMapFactory implements ChenMapFactory {
    public Map<String, ChenPokemon> createMap() {
        return new TreeMap<>();
    }
}

class ChenLinkedHashMapFactory implements ChenMapFactory {
    public Map<String, ChenPokemon> createMap() {
        return new LinkedHashMap<>();
    }
}
