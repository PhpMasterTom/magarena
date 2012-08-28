package magic.card;

import magic.data.TokenCardDefinitions;
import magic.model.MagicGame;
import magic.model.MagicPermanent;
import magic.model.MagicPlayer;
import magic.model.action.MagicPlayTokenAction;
import magic.model.choice.MagicMayChoice;
import magic.model.choice.MagicSimpleMayChoice;
import magic.model.event.MagicEvent;
import magic.model.trigger.MagicLandfallTrigger;

public class Emeria_Angel {
    public static final MagicLandfallTrigger T = new MagicLandfallTrigger() {
        @Override
        protected MagicEvent getEvent(final MagicPermanent permanent) {
            final MagicPlayer player = permanent.getController();
            return new MagicEvent(
                    permanent,
                    player,
                    new MagicSimpleMayChoice(
                            player + " may put a 1/1 white Bird creature " +
                            "token with flying onto the battlefield.",
                            MagicSimpleMayChoice.PLAY_TOKEN,
                            1,
                            MagicSimpleMayChoice.DEFAULT_YES),
                    new Object[]{player},
                    this,
                    player + " may$ put a 1/1 white Bird creature " +
                    "token with flying onto the battlefield.");
        }
        
        @Override
        public void executeEvent(
                final MagicGame game,
                final MagicEvent event,
                final Object data[],
                final Object[] choiceResults) {
            if (MagicMayChoice.isYesChoice(choiceResults[0])) {
                game.doAction(new MagicPlayTokenAction(
                        (MagicPlayer)data[0],
                        TokenCardDefinitions.get("Bird1")));
            }
        }        
    };
}
