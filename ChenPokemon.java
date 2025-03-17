class ChenPokemon {
    String name;
    String type1;
    String ability;

    public ChenPokemon(String name, String type1, String ability) {
        this.name = name;
        this.type1 = type1;
        this.ability = ability;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + ", Tipo1: " + type1 + ", Habilidad: " + ability;
    }
}
