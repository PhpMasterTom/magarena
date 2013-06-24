package magic.model.trigger;

public abstract class MagicWhenLifeIsGainedTrigger extends MagicTrigger<MagicLifeChangeTriggerData> {
    public MagicWhenLifeIsGainedTrigger(final int priority) {
        super(priority);
    }

    public MagicWhenLifeIsGainedTrigger() {}

    public MagicTriggerType getType() {
        return MagicTriggerType.WhenLifeIsGained;
    }
}
