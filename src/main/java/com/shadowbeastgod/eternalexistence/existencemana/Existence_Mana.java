package com.shadowbeastgod.eternalexistence.existencemana;


//manager for custom energy type
public class Existence_Mana {
    private int Amount;

    private final String ID;

    Existence_Mana(String id,int amount){
        this.ID = id;
        this.Amount = amount;
    }
    public int getAmount(){
       return Amount;
    }

    public void setAmount(int amount){
        this.Amount = amount;
    }

    public static class Fire implements IExistence_Mana {
        private static final String ID = "fire";
        private int Amount;
        Fire(int amount) {
        }

        @Override
        public String getID() {
            return ID;
        }

        public void setAmount(int amount) {
            Amount = amount;
        }

        @Override
        public int getAmount() {
            return Amount;
        }
    }
    public static class Ice implements IExistence_Mana{
        private static final String ID = "ice";
        private int Amount;
        Ice(int amount) {
            
        }

        @Override
        public String getID() {
            return ID;
        }

        public void setAmount(int amount) {
            Amount = amount;
        }

        @Override
        public int getAmount() {
            return 0;
        }
    }
    public static class Water implements IExistence_Mana{
        private static final String ID = "water";
        private int Amount;
        Water(int amount) {
            
        }

        @Override
        public String getID() {
            return ID;
        }

        public void setAmount(int amount) {
            Amount = amount;
        }

        @Override
        public int getAmount() {
            return Amount;
        }
    }

    public static class Lightning implements IExistence_Mana {
        private static final String ID = "lightning";
        private int Amount;
        Lightning(int amount) {
            
        }

        @Override
        public String getID() {
            return ID;
        }

        public void setAmount(int amount) {
            Amount = amount;
        }

        @Override
        public int getAmount() {
            return Amount;
        }
    }

    public static class Nature implements IExistence_Mana {
        private static final String ID = "nature";
        private int Amount;
        Nature(int amount) {

        }

        @Override
        public String getID() {
            return ID;
        }

        public void setAmount(int amount) {
            Amount = amount;
        }

        @Override
        public int getAmount() {
            return Amount;
        }
    }

    public static class Air implements IExistence_Mana {
        private static final String ID = "air";
        private int Amount;
        Air(int amount) {
            
        }

        @Override
        public String getID() {
            return ID;
        }

        public void setAmount(int amount) {
            Amount = amount;
        }

        @Override
        public int getAmount() {
            return Amount;
        }
    }

    public static class Darkness implements IExistence_Mana {//dark step, dark walk
        private static final String ID = "darkness";
        private int Amount;
        Darkness(int amount) {
            
        }

        @Override
        public String getID() {
            return ID;
        }

        public void setAmount(int amount) {
            Amount = amount;
        }

        @Override
        public int getAmount() {
            return Amount;
        }
    }

    public static class Light implements IExistence_Mana {//illusion, botanic
        private static final String ID = "light";
        private int Amount;
        Light(int amount) {
            
        }

        @Override
        public String getID() {
            return ID;
        }

        public void setAmount(int amount) {
            Amount = amount;
        }

        @Override
        public int getAmount() {
            return Amount;
        }
    }

    public static class Holy implements IExistence_Mana {//healing,cure,purify
        private static final String ID = "holy";
        private int Amount;
        Holy() {
            
        }

        @Override
        public String getID() {
            return ID;
        }

        public void setAmount(int amount) {
            Amount = amount;
        }

        @Override
        public int getAmount() {
            return Amount;
        }
    }

    public static class Demonic implements IExistence_Mana {//Rage,ect{tbd}
        private static final String ID = "demonic";
        private int Amount;
        Demonic(int amount) {
            this.Amount = amount;
        }

        @Override
        public String getID() {
            return ID;
        }

        public void setAmount(int amount) {
            Amount = amount;
        }

        @Override
        public int getAmount() {
            return Amount;
        }
    }

    public static class Celestial implements IExistence_Mana {
        private static final String ID = "celestial";
        private int Amount;

        Celestial(int amount) {
            this.Amount = amount;
        }

        @Override
        public String getID() {
            return ID;
        }

        public void setAmount(int amount) {
            Amount = amount;
        }

        @Override
        public int getAmount() {
            return Amount;
        }
    }

    public static class Existence implements IExistence_Mana {//for creating and instant teleport to other realms
        private static final String ID = "existence";
        private int Amount;

        Existence(int amount) {
            this.Amount = amount;
        }

        @Override
        public String getID() {
            return ID;
        }

        public void setAmount(int amount) {
            Amount = amount;
        }

        @Override
        public int getAmount() {
            return Amount;
        }
    }
}

