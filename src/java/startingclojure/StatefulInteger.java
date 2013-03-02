package startingclojure;


public class StatefulInteger {
	
	private int state;

    public StatefulInteger (int initialState) {
        this.state = initialState;
    }

    public void setInt (int newState) {
        this.state = newState;
    }

    public int intValue () {
        return state;
    }

    public int hashCode () {
        return state;
    }

    public boolean equals (Object obj) {
        return obj instanceof StatefulInteger &&
            state == ((StatefulInteger)obj).state;
    }
}
