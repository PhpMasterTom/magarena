[
    new MagicPermanentActivation(
        new MagicActivationHints(MagicTiming.Removal),
        "-1/-1"
    ) {
        @Override
        public Iterable<MagicEvent> getCostEvent(final MagicPermanent source) {
            return [
                new MagicPayManaCostEvent(source,"{B}"),
                new MagicRemoveCounterEvent(source,MagicCounterType.MinusOne,1)
            ];
        }
        @Override
        public MagicEvent getPermanentEvent(final MagicPermanent source,final MagicPayedCost payedCost) {
            return new MagicEvent(
                source,
                this,
                "Put a -1/-1 counter on each other creature."
            );
        }
        @Override
        public void executeEvent(final MagicGame game, final MagicEvent event) {
            final MagicTargetFilter<MagicPermanent> filter = new MagicOtherPermanentTargetFilter(
                MagicTargetFilterFactory.CREATURE,
                event.getPermanent()
            );
            final Collection<MagicPermanent> targets=game.filterPermanents(event.getPlayer(),filter);
            for (final MagicPermanent target : targets) {
                game.doAction(new MagicChangeCountersAction(target,MagicCounterType.MinusOne,1));
            }
        }
    }
]
