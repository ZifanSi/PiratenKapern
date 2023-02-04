package pk;

public class Card {
    private final Cards tempCard;
    public Card(Cards tempCard){
        this.tempCard = tempCard;
    }

    public Cards getCard() {
        return tempCard;
    }
}

