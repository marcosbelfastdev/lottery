package components;

import components.Rule;

import java.util.HashMap;
import java.util.Map;

public class RulesOptions<T> {

    Map<Rule, Object> rulesOptions = new HashMap<Rule, Object>();

    public RulesOptions() {
        rulesOptions.put(Rule.COMPLETE_REMAINING_WITH, RuleValue.MOST_FREQUENT_BALLS);
        rulesOptions.put(Rule.CONVERT_REPEATED_BALL_TO, RuleValue.RANDOM);
        rulesOptions.put(Rule.DEFAULT_HISTORY_FACTOR, 0.20);
        rulesOptions.put(Rule.LEAST_FREQUENT_BALLS_DEFAULT_COUNT, 2);
        rulesOptions.put(Rule.LEAST_FREQUENT_BALLS_FACTOR, 1.00);
        rulesOptions.put(Rule.MOST_FREQUENT_BALLS_DEFAULT_COUNT, 2);
        rulesOptions.put(Rule.MOST_FREQUENT_BALLS_FACTOR, 0.30);
        rulesOptions.put(Rule.NEVER_REPEAT_HISTORY, true);
    }

    public void set(Rule rule, Object value) {
        try {
            rulesOptions.remove(rule);
            rulesOptions.put(rule, value);
        } catch (Exception ignore) {

        }
    }

    public Rule get(Rule rule) {
        return (Rule) rulesOptions.get(rule);
    }
}
