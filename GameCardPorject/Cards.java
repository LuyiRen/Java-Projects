public class Cards implements Comparable<Cards>{
    private String suits;
    private String number;

    public String getSuits() {
        return suits;
    }

    public void setSuits(String suits) {
        this.suits = suits;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    protected int toValueNumbers(){
        try{
            int value = Integer.parseInt(this.getNumber());
            return value;
        }catch (Exception e){
            if(this.getNumber().toLowerCase().equals("ace")){
                return 14;
            }
            if(this.getNumber().toLowerCase().equals("king")){
                return 13;
            }
            if(this.getNumber().toLowerCase().equals("queen")){
                return 12;
            }
            if(this.getNumber().toLowerCase().equals("jack")){
                return 11;
            }
        }
        return -1;
    }
    protected int toSuits(){
        if (suits.toLowerCase().equals("spades")){
            return 4;
        }
        if (suits.toLowerCase().equals("heart")){
            return 3;
        }
        if (suits.toLowerCase().equals("diamond")){
            return 2;
        }
        else {
            return 1;
        }
    }

    @Override
    public int compareTo(Cards o) {
        if(this.toValueNumbers() > o.toValueNumbers()){
            return 1;
        }
        else if(this.toValueNumbers() == o.toValueNumbers()){
            return  this.getSuits().compareTo(o.getSuits());

        }
        else {
                return -1;
            }
        }
    }
