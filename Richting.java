public enum Richting
    {
        
        Noord(0),
        Oost(1),
        Zuid(2),
        West(3),
        Onbekend(4);
        
        private final int value;
        private Richting(int value) {
            this.value = value;
        }
    
        public int getValue() {
            return value;
        }

        
    }