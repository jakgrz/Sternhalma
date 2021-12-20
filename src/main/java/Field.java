public class Field {
    private boolean enabled;
    private Pawn pawn;

    public Field(Pawn pawn, boolean enabled) {
        this.pawn = pawn;
        this.enabled = enabled;
    }

   public void setPawn(Pawn pawn) {
        this.pawn = pawn;
    }

    public Pawn getPawn() {
        return this.pawn;
    }

    public boolean isEnabled() {
        return this.enabled;
    }
}
