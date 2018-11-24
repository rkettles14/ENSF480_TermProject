public  abstract class User {
    protected Server instance;
    
    /**
     * shows what the user can do to std out
     * ie "press 1 to add publication"
     */
    public abstract void showOptions();
    
}
