public class Card{
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public enum Rank{
        TWO (2, "Two"),
        THREE (3, "Three"),
        FOUR (4, "Four"),
        FIVE (5, "Five"),
        SIX (6, "Six"),
        SEVEN (7, "Seven"),
        EIGHT (8, "Eight"),
        NINE (9, "Nine"),
        TEN (10, "Ten"),
        ACE (1, "Ace"),
        KNIGHT (11, "Jack"),
        QUEEN (12, "Queen"),
        KING (13, "King"),
        ;
        private final int value;
        private final String text;

        Rank(int value, String text){
            this.value = value;
            this.text = text;
        }

        public int getValue() {
            return value;
        }

        public String getText() {
            return text;
        }

        public String toString(){
            return "Rank: {  " + 
                "value = " + value + 
                ", text = " + text + '\'' +
                "}";
        }
    }

    public enum Suit{
        CLUBS (1, "Clubs"),
        DIAMONDS (2, "Diamonds"),
        HEARTS (3, "Hearts"),
        SPADES (4, "Spades"),
        ;

        private final int value;
        private final String text;

        Suit(int value, String text){
            this.value = value;
            this.text = text;
        }

        public int getValue() {
            return value;
        }

        public String getText() {
            return text;
        }

        public String toString(){
            return "Suit: {" + 
                "value = " + value + 
                ", text = " + text +
                "}";
        }
    }

    public String toString(){
        return "Card: {" + 
            "rank = " + rank + 
            ", suit = " + suit +
            "}";
    }
}