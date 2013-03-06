[
    new MagicPermanentActivation( 
            [MagicCondition.ONE_LIFE_CONDITION],
            new MagicActivationHints(MagicTiming.Pump),
            "Pump") {

        @Override
        public MagicEvent[] getCostEvent(final MagicPermanent source) {
            return [
                new MagicPayLifeEvent(source,source.getController(),1),
            ];
        }

        @Override
        public MagicEvent getPermanentEvent(final MagicPermanent source,final MagicPayedCost payedCost) {
            return new MagicEvent(
                source,
                this,
                "SN gets +1/+1 until end of turn."
            );
        }

        @Override
        public void executeEvent(final MagicGame game,final MagicEvent event,final Object[] choiceResults) {
            game.doAction(new MagicChangeTurnPTAction(event.getPermanent(), 1, 1));
        }
    }
]
