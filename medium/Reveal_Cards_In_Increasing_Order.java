package medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 950. Reveal Cards In Increasing Order
 */

public class Reveal_Cards_In_Increasing_Order {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> deque = new ArrayDeque<>(deck.length);
        for (int i = deck.length - 1; i >= 0; i--) {
            deque.add(deck[i]);
            if (i == 0) {
                break;
            }
            deque.add(deque.poll());
        }
        for (int i = deck.length - 1; i >= 0; i--) {
            deck[i] = deque.poll();
        }
        return deck;
    }
}
