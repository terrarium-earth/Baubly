package earth.terrarium.baubly.common;

public enum DefaultSlotIdentifiers implements SlotIdentifier {
    HEAD("head", "head/hat"),
    GLASSES("glasses", "head/glasses"),
    NECKLACE("necklace", "chest/necklace"),
    BACK("back", "chest/back"),
    BODY("body", "chest/cape"),
    BELT("belt", "legs/belt"),
    RING("ring", "hand/ring", "offhand/ring"),
    HANDS("hands", "hand/glove", "offhand/glove"),
    ;

    private final String curioId;
    private final String[] trinketId;

    DefaultSlotIdentifiers(String curioId, String ... trinketId) {
        this.curioId = curioId;
        this.trinketId = trinketId;
    }

    @Override
    public String[] trinketIds() {
        return trinketId;
    }

    @Override
    public String curioId() {
        return curioId;
    }
}
