public class Rules {

    RulesOptions rulesOptions = new RulesOptions();

    public Rules set(Rule rule, Object value) {
        rulesOptions.set(rule, value);
        return this;
    }

    public Object get(Rule rule) {
        return rulesOptions.get(rule);
    }

}
