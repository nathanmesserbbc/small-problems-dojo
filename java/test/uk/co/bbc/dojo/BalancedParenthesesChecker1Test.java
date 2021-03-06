package uk.co.bbc.dojo;


import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BalancedParenthesesChecker1Test {

    private BalancedParenthesesChecker1 checker = new BalancedParenthesesChecker1();

    @Test
    public void shouldTreatEmptyStringAsBalanced() {
        assertThat(checker.isBalanced(""), is(true));
    }

    @Test
    public void shouldTreatSingleBracePairAsBalanced() {
        assertThat(checker.isBalanced("()"), is(true));
    }

    @Test
    public void shouldTreatSingleOpenBraceAsUnbalanced() {
        assertThat(checker.isBalanced("("), is(false));
    }

    @Test
    public void shouldTreatSingleCloseBraceAsUnbalanced() {
        assertThat(checker.isBalanced(")"), is(false));
    }

    @Test
    public void shouldTreatSquarePairAsBalanced() {
        assertThat(checker.isBalanced("[]"), is(true));
    }


    @Test
    public void shouldTreatMixedPairsAsBalanced() {
        assertThat(checker.isBalanced("(){}[]"), is(true));
    }


    @Test
    public void shouldTreatNestedPairsAsBalanced() {
        assertThat(checker.isBalanced("({[]})"), is(true));
    }

    @Test
    public void shouldTreatValidLispAsBalanced() {
        assertThat(checker.isBalanced("(sin (* 2 pi 1/4))"), is(true));
    }

    @Test
    public void shouldTreatMultipleNestedGroupsAsBalanced() {
        assertThat(checker.isBalanced("(+ (* 2 pi 1/4)(/ 8 (- 6 1)))"), is(true));
    }

    @Test
    public void shouldTreatWronglyPositionedPairsAsUnbalanced() {
        assertThat(checker.isBalanced("{(])[}"), is(false));
    }

    @Test
    public void shouldTreatWronglyNestedGroupsAsUnbalanced() {
        assertThat(checker.isBalanced("(()([}))"), is(false));
    }
}
