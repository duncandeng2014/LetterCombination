package com.company.minicodetest.lettercombination.strategy;

import java.util.Optional;

public enum LetterCombinationStrategyFactory {
    instance;

    public enum LcStrategyOption {
        ZeroTo9("1", new ZeroTo9Strategy()), ZeroTo99("2", new ZeroTo99Strategy());

        private String id;
        private LetterCombinationStrategy strategy;

        private LcStrategyOption(String id, LetterCombinationStrategy strategy) {
            this.id = id;
            this.strategy = strategy;
        }

        public static LcStrategyOption valueOfId(String id) {
            id = Optional.ofNullable(id).orElse("1").trim();

            LcStrategyOption result = null;
            for (LcStrategyOption instance: LcStrategyOption.values())
                if (instance.id.equals(id))
                    result = instance;

            return Optional.ofNullable(result).orElse(ZeroTo9);
        }

        public String getId() {
            return id;
        }

        public LetterCombinationStrategy getStrategy() {
            return strategy;
        }
    }

    public LetterCombinationStrategy getStrategy(LcStrategyOption option) {
        return option.strategy;
    }

    public LetterCombinationStrategy getStrategy(String id) {
        LcStrategyOption option = LcStrategyOption.valueOfId(id);
        return option.getStrategy();
    }

}
