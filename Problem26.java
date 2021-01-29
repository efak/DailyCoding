/**
 * Given a singly linked list and an integer k, remove the kth last element from
 * the list. k is guaranteed to be smaller than the length of the list.
 * 
 * The list is very long, so making more than one pass is prohibitively
 * expensive.
 * 
 * Do this in constant space and in one pass
 */
public class LinkListLastK {

   //Class for linkedlist node
    class LNode {
        int val;
        LNode next;

        LNode() {
        }

        LNode(int val) {
            this.val = val;
        }

        LNode(int val, LNode next) {
            this.val = val;
            this.next = next;
        }
    }

    LNode removeKthFromEnd(LNode head, int k) {
        LNode dummy, current, runner;
        dummy = new LNode(0);
        dummy.next = head;
        current = dummy;
        runner = dummy;

        //Advace runnner by k+1 steps
        for (int i = 0; i <= k; i++) {
            runner = runner.next;
        }

        while (runner != null) {
            current = current.next;
            runner = runner.next;
        }

        // remove
        current.next = current.next.next;

        return dummy.next;
    }

}
